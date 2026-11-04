package com.orvakal.app.presentation.services

import com.orvakal.app.domain.model.Service

sealed interface ServicesState {
    data object Loading : ServicesState
    data class Success(val services: List<Service>) : ServicesState
    data class Error(val message: String) : ServicesState
}
