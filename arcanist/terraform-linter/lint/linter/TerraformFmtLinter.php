<?php

// from https://github.com/freelancer/flarc

final class TerraformFmtLinter extends ArcanistExternalLinter {

  const LINT_SYNTAX_ERROR = 1;
  const LINT_FORMATTING   = 2;

  public function getInfoName(): string {
    return 'Terraform Format';
  }

  public function getInfoURI(): string {
    return 'https://www.terraform.io/docs/commands/fmt.html';
  }

  public function getInfoDescription(): string {
    return pht(
      '`%s` rewrites all Terraform configuration files to a '.
      'canonical format and style.',
      'terraform fmt');
  }

  public function getLinterName(): string {
    return 'TERRAFORMFMT';
  }

  public function getLinterConfigurationName(): string {
    return 'terraform-fmt';
  }

  public function getLintNameMap(): array {
    return [
      self::LINT_SYNTAX_ERROR => pht('Syntax Error'),
      self::LINT_FORMATTING   => pht('Formatting Issue'),
    ];
  }

  public function getLintSeverityMap(): array {
    return [
      self::LINT_SYNTAX_ERROR => ArcanistLintSeverity::SEVERITY_ERROR,
      self::LINT_FORMATTING   => ArcanistLintSeverity::SEVERITY_WARNING,
    ];
  }

  protected function canCustomizeLintSeverities(): bool {
    return false;
  }

  public function getDefaultBinary(): string {
    return 'terraform';
  }

  public function getInstallInstructions(): string {
    return pht(
      'Download and install Terraform from %s.',
      'https://www.terraform.io/downloads.html');
  }

  protected function getMandatoryFlags(): array {
    return [
      'fmt',
      '-list=false',
      '-write=false',
    ];
  }

  public function getVersion(): ?string {
    list($stdout) = execx(
      'CHECKPOINT_DISABLE=true %C version',
      $this->getExecutableCommand());

    $matches = null;
    $regex = '/^Terraform v(?<version>\d+(?:\.\d+){2}(?:-(?:alpha|beta|rc)\d+)?)$/m';

    if (!preg_match($regex, $stdout, $matches)) {
      return null;
    }

    return $matches['version'];
  }

  /**
   * Get a version string used for caching lint results.
   *
   * The implementation of this method was mostly copied from
   * @{method:ArcanistExternalLinter::getCacheVersion} but was adapted in order
   * to ensure that only flags which actually affect the linter results are
   * used within the lint cache key.
   */
  public function getCacheVersion(): ?string {
    // TODO: Do we need to `try`-`catch` this?
    try {
      $this->checkBinaryConfiguration();
    } catch (ArcanistMissingLinterException $e) {
      return null;
    }

    return $this->getVersion();
  }

  protected function parseLinterOutput($path, $err, $stdout, $stderr): array {
    // `terraform fmt` returns a non-zero exit status in the case of a syntax
    // error.
    if ($err) {
      // TODO: The output from `terraform fmt` is colorized. Ideally we would be
      // able to pass `-color=false` to `terraform fmt` to produce raw output,
      // but for now we just strip out the ANSI color codes from the output.
      // See https://github.com/hashicorp/terraform/issues/6926.
      $stderr = preg_replace(
        '/\x1B\[([0-9]{1,2}(;[0-9]{1,2})?)?[m|K]/',
        '',
        $stderr);

      $matches = null;
      $regex = pregsprintf(
        '%R%R%R%R',
        '',
        '^Error running fmt: ',
        'In (?P<path>.*?): ',
        '(At (?P<line>\d+):(?P<column>\d+): )?',
        '(?P<message>.*)$');

      if (!preg_match($regex, $stderr, $matches)) {
        throw new Exception(
          pht(
            'Failed to parse `%s` output: "%s".',
            'terraform fmt',
            $stderr));
      }

      $code   = self::LINT_SYNTAX_ERROR;
      $line   = nonempty((int)$matches['line'], null);
      $column = nonempty((int)$matches['column'], null);

      $message = (new ArcanistLintMessage())
        ->setPath($path)
        ->setLine($line)
        ->setChar($column)
        ->setCode($this->getLintMessageFullCode($code))
        ->setSeverity($this->getLintMessageSeverity($code))
        ->setName($this->getLintMessageName($code))
        ->setDescription($matches['message']);

      return [$message];
    }

    $original_text  = $this->getData($path);
    $formatted_text = $stdout;

    // `terraform fmt` removes all trailing newline characters, but we enforce
    // this elsewhere (in `ArcanistTextLinter`). Just ignore trailing newline
    // characters to prevent conflicting linter rules.
    $original_text  = rtrim($original_text);
    $formatted_text = rtrim($formatted_text);

    if ($original_text != $formatted_text) {
      $code = self::LINT_FORMATTING;

      $message = (new ArcanistLintMessage())
        ->setPath($path)
        ->setLine(1)
        ->setChar(1)
        ->setCode($this->getLintMessageFullCode($code))
        ->setSeverity($this->getLintMessageSeverity($code))
        ->setName($this->getLintMessageName($code))
        ->setDescription(
          pht(
            'Source code is not formatted as per `%s`.',
            'terraform fmt'))
        ->setOriginalText($original_text)
        ->setReplacementText($formatted_text);

      return [$message];
    }

    return [];
  }

}
