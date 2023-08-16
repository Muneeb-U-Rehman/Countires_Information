package com.example.countiresinformation.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Flags (

  @SerializedName("png" ) var png : String? = null,
  @SerializedName("svg" ) var svg : String? = null,
  @SerializedName("alt" ) var alt : String? = null

)