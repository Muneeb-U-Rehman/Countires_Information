package com.example.countiresinformation.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Name (

  @SerializedName("common"     ) var common     : String?     = null,
  @SerializedName("official"   ) var official   : String?     = null,
  @SerializedName("nativeName" ) var nativeName : NativeName? = NativeName()

)