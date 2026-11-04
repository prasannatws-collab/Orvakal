package com.orvakal.app.presentation.home

import com.orvakal.app.domain.model.Service

sealed interface HomeState {
    data object Loading : HomeState
    data class Success(
        val userName: String = "Citizen",
        val featuredServices: List<Service> = emptyList(),
        val announcementMessage: String = "New services are now available!"
    ) : HomeState
    data class Error(val message: String) : HomeState
}
