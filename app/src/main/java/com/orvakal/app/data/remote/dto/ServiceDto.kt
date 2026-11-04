package com.orvakal.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ServiceDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("isAvailable")
    val isAvailable: Boolean = true
)
