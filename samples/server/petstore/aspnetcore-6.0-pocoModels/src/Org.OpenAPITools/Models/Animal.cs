/*
 * OpenAPI Petstore
 *
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 * Generated by: https://openapi-generator.tech
 */

using System;
using System.Linq;
using System.Text;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;
using Newtonsoft.Json;
using JsonSubTypes;
using Swashbuckle.AspNetCore.Annotations;
using Org.OpenAPITools.Converters;

namespace Org.OpenAPITools.Models
{ 
    /// <summary>
    /// 
    /// </summary>
    [DataContract]
    [JsonConverter(typeof(JsonSubtypes), "ClassName")]
    [SwaggerDiscriminator("ClassName")]
    [JsonSubtypes.KnownSubType(typeof(Cat), "CAT")]
    [SwaggerSubType(typeof(Cat), DiscriminatorValue =  "CAT")]
    [JsonSubtypes.KnownSubType(typeof(Dog), "DOG")]
    [SwaggerSubType(typeof(Dog), DiscriminatorValue =  "DOG")]
    public partial class Animal 
    {
        /// <summary>
        /// Gets or Sets ClassName
        /// </summary>
        [Required]
        [DataMember(Name="className", EmitDefaultValue=true)]
        public string ClassName { get; set; }

        /// <summary>
        /// Gets or Sets Color
        /// </summary>
        [DataMember(Name="color", EmitDefaultValue=true)]
        public string Color { get; set; } = "red";

    }
}
