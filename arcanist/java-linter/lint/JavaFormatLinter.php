<?php

/**
 * Lints Java source files using the "google-java-format" tool.
 */
final class JavaFormatLinter extends ArcanistExternalLinter {

  private $jar_path = null;

  public function getInfoName() {
    return 'Java Format';
  }

  public function getInfoDescription() {
    return pht('Checks Java files');
  }

  public function getLinterName() {
    return 'JAVA_FORMAT';
  }

  public function getLinterConfigurationName() {
    return 'java-format';
  }

  public function getLinterConfigurationOptions() {
    $options = array(
      'jar_path' => array(
        'type' => 'string',
        'help' => pht("Jar file to use."),
      ),
    );

    return $options + parent::getLinterConfigurationOptions();
  }

  public function setLinterConfigurationValue($key, $value) {
    switch ($key) {
      case 'jar_path':
        $this->jar_path = $value;
        return;
    }

    return parent::setLinterConfigurationValue($key, $value);
  }

  public function getDefaultBinary() {
    return 'java';
  }

  public function getInstallInstructions() {
    return pht('Install java');
  }

  protected function getMandatoryFlags() {
    return array('-jar', $this->jar_path);
  }

  protected function parseLinterOutput($path, $err, $stdout, $stderr) {
    if ($err) {
      return false;
    }
    if ($this->getData($path) == $stdout) {
        return array();
    }
    $message = new ArcanistLintMessage();
    $message->setPath($path);
    $message->setSeverity(ArcanistLintSeverity::SEVERITY_AUTOFIX);
    $message->setName('Java Format');
    $message->setLine(1);
    $message->setCode($this->getLinterName());
    $message->setChar(1);
    $message->setDescription('This file has not been formatted');
    $message->setOriginalText($this->getData($path));
    $message->setReplacementText($stdout);
    $message->setBypassChangedLineFiltering(true);
    $messages[] = $message;
    return $messages;
  }

}
