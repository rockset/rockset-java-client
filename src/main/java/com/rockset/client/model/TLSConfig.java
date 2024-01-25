/*
 * REST API
 * Rockset's REST API allows for creating and managing all resources in Rockset. Each supported endpoint is documented below.  All requests must be authorized with a Rockset API key, which can be created in the [Rockset console](https://console.rockset.com). The API key must be provided as `ApiKey <api_key>` in the `Authorization` request header. For example: ``` Authorization: ApiKey aB35kDjg93J5nsf4GjwMeErAVd832F7ad4vhsW1S02kfZiab42sTsfW5Sxt25asT ```  All endpoints are only accessible via https.  Build something awesome!
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.rockset.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TLSConfig
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2024-01-25T12:03:52.511Z")
public class TLSConfig {
  @SerializedName("ca_cert")
  private String caCert = null;

  @SerializedName("client_cert")
  private String clientCert = null;

  @SerializedName("client_cert_expiry")
  private Long clientCertExpiry = null;

  @SerializedName("client_cert_subject")
  private String clientCertSubject = null;

  @SerializedName("client_key")
  private String clientKey = null;

  public TLSConfig caCert(String caCert) {
    this.caCert = caCert;
    return this;
  }

   /**
   * PEM-formatted certificate chain of the Certificate Authority used to verify remote server. If empty, Rockset, will use publicly trusted CAs
   * @return caCert
  **/

@JsonProperty("ca_cert")
@ApiModelProperty(example = "-----BEGIN CERTIFICATE----- .... -----END CERTIFICATE-----", value = "PEM-formatted certificate chain of the Certificate Authority used to verify remote server. If empty, Rockset, will use publicly trusted CAs")
  public String getCaCert() {
    return caCert;
  }

  public void setCaCert(String caCert) {
    this.caCert = caCert;
  }

  public TLSConfig clientCert(String clientCert) {
    this.clientCert = clientCert;
    return this;
  }

   /**
   * PEM-formatted certificate chain to use for client authentication
   * @return clientCert
  **/

@JsonProperty("client_cert")
@ApiModelProperty(example = "-----BEGIN CERTIFICATE----- .... -----END CERTIFICATE-----", required = true, value = "PEM-formatted certificate chain to use for client authentication")
  public String getClientCert() {
    return clientCert;
  }

  public void setClientCert(String clientCert) {
    this.clientCert = clientCert;
  }

   /**
   * Expiration date of the client certificate (represented as number of ms since epoch)
   * @return clientCertExpiry
  **/

@JsonProperty("client_cert_expiry")
@ApiModelProperty(example = "1695426751", value = "Expiration date of the client certificate (represented as number of ms since epoch)")
  public Long getClientCertExpiry() {
    return clientCertExpiry;
  }

   /**
   * Subject of the client certificate, containing common name and other attributes
   * @return clientCertSubject
  **/

@JsonProperty("client_cert_subject")
@ApiModelProperty(example = "CN=Sample Cert, OU=R&D, O=Company Ltd.", value = "Subject of the client certificate, containing common name and other attributes")
  public String getClientCertSubject() {
    return clientCertSubject;
  }

  public TLSConfig clientKey(String clientKey) {
    this.clientKey = clientKey;
    return this;
  }

   /**
   * PEM-formatted private key to be used for client authentication
   * @return clientKey
  **/

@JsonProperty("client_key")
@ApiModelProperty(example = "-----BEGIN RSA PRIVATE KEY----- ... -----END RSA PRIVATE KEY-----", required = true, value = "PEM-formatted private key to be used for client authentication")
  public String getClientKey() {
    return clientKey;
  }

  public void setClientKey(String clientKey) {
    this.clientKey = clientKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TLSConfig tlSConfig = (TLSConfig) o;
    return Objects.equals(this.caCert, tlSConfig.caCert) &&
        Objects.equals(this.clientCert, tlSConfig.clientCert) &&
        Objects.equals(this.clientCertExpiry, tlSConfig.clientCertExpiry) &&
        Objects.equals(this.clientCertSubject, tlSConfig.clientCertSubject) &&
        Objects.equals(this.clientKey, tlSConfig.clientKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(caCert, clientCert, clientCertExpiry, clientCertSubject, clientKey);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TLSConfig {\n");
    
    sb.append("    caCert: ").append(toIndentedString(caCert)).append("\n");
    sb.append("    clientCert: ").append(toIndentedString(clientCert)).append("\n");
    sb.append("    clientCertExpiry: ").append(toIndentedString(clientCertExpiry)).append("\n");
    sb.append("    clientCertSubject: ").append(toIndentedString(clientCertSubject)).append("\n");
    sb.append("    clientKey: ").append(toIndentedString(clientKey)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

