package com.example.countiresinformation.model

import com.google.gson.annotations.SerializedName


data class Ara (

  @SerializedName("official" ) var official : String? = null,
  @SerializedName("common"   ) var common   : String? = null

)