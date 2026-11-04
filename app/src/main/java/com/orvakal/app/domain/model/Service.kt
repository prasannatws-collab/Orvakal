package com.orvakal.app.domain.model

data class Service(
    val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val icon: String,
    val isAvailable: Boolean = true
)
