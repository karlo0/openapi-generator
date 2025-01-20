/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import org.openapitools.client.ApiClient;
/**
 * TriangleInterface
 */
@JsonPropertyOrder({
  TriangleInterface.JSON_PROPERTY_TRIANGLE_TYPE
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0-SNAPSHOT")
public class TriangleInterface {
  public static final String JSON_PROPERTY_TRIANGLE_TYPE = "triangleType";
  @javax.annotation.Nonnull
  private String triangleType;

  public TriangleInterface() { 
  }

  public TriangleInterface triangleType(@javax.annotation.Nonnull String triangleType) {
    this.triangleType = triangleType;
    return this;
  }

  /**
   * Get triangleType
   * @return triangleType
   */
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TRIANGLE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getTriangleType() {
    return triangleType;
  }


  @JsonProperty(JSON_PROPERTY_TRIANGLE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTriangleType(@javax.annotation.Nonnull String triangleType) {
    this.triangleType = triangleType;
  }


  /**
   * Return true if this TriangleInterface object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o, false, null, true);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TriangleInterface {\n");
    sb.append("    triangleType: ").append(toIndentedString(triangleType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `triangleType` to the URL query string
    if (getTriangleType() != null) {
      joiner.add(String.format("%striangleType%s=%s", prefix, suffix, URLEncoder.encode(ApiClient.valueToString(getTriangleType()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }

    public static class Builder {

    private TriangleInterface instance;

    public Builder() {
      this(new TriangleInterface());
    }

    protected Builder(TriangleInterface instance) {
      this.instance = instance;
    }

    public TriangleInterface.Builder triangleType(String triangleType) {
      this.instance.triangleType = triangleType;
      return this;
    }


    /**
    * returns a built TriangleInterface instance.
    *
    * The builder is not reusable.
    */
    public TriangleInterface build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        this.instance = null;
      }
    }

    @Override
    public String toString() {
      return getClass() + "=(" + instance + ")";
    }
  }

  /**
  * Create a builder with no initialized field.
  */
  public static TriangleInterface.Builder builder() {
    return new TriangleInterface.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public TriangleInterface.Builder toBuilder() {
    return new TriangleInterface.Builder()
      .triangleType(getTriangleType());
  }

}

