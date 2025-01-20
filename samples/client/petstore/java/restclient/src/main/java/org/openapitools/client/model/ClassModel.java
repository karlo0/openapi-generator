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

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Model for testing model with \&quot;_class\&quot; property
 */
@JsonPropertyOrder({
  ClassModel.JSON_PROPERTY_PROPERTY_CLASS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.12.0-SNAPSHOT")
public class ClassModel {
  public static final String JSON_PROPERTY_PROPERTY_CLASS = "_class";
  @jakarta.annotation.Nullable
  private String propertyClass;

  public ClassModel() {
  }

  public ClassModel propertyClass(@jakarta.annotation.Nullable String propertyClass) {
    
    this.propertyClass = propertyClass;
    return this;
  }

  /**
   * Get propertyClass
   * @return propertyClass
   */
  @jakarta.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PROPERTY_CLASS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPropertyClass() {
    return propertyClass;
  }


  @JsonProperty(JSON_PROPERTY_PROPERTY_CLASS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPropertyClass(@jakarta.annotation.Nullable String propertyClass) {
    this.propertyClass = propertyClass;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassModel classModel = (ClassModel) o;
    return Objects.equals(this.propertyClass, classModel.propertyClass);
  }

  @Override
  public int hashCode() {
    return Objects.hash(propertyClass);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassModel {\n");
    sb.append("    propertyClass: ").append(toIndentedString(propertyClass)).append("\n");
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

}

