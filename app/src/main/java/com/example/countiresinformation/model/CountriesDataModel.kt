package com.example.countiresinformation.model


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CountriesDataModel (

    @SerializedName("flags"      ) var flags      : Flags? = Flags(),
    @SerializedName("name"       ) var name       : Name?  = Name(),
    @SerializedName("area"       ) var area       : Float?   = null,
    @SerializedName("population" ) var population : Float?   = null

)