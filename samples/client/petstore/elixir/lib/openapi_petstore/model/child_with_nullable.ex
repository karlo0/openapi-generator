# NOTE: This file is auto generated by OpenAPI Generator 7.12.0-SNAPSHOT (https://openapi-generator.tech).
# Do not edit this file manually.

defmodule OpenapiPetstore.Model.ChildWithNullable do
  @moduledoc """
  
  """

  @derive Jason.Encoder
  defstruct [
    :type,
    :nullableProperty,
    :otherProperty
  ]

  @type t :: %__MODULE__{
    :type => String.t | nil,
    :nullableProperty => String.t | nil,
    :otherProperty => String.t | nil
  }

  def decode(value) do
    value
  end
end

