package com.orvakal.app.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orvakal.app.domain.usecase.GetServicesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getServicesUseCase: GetServicesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state: StateFlow<HomeState> = _state.asStateFlow()

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        viewModelScope.launch {
            _state.value = HomeState.Loading
            getServicesUseCase()
                .catch { throwable ->
                    _state.value = HomeState.Error(
                        message = throwable.message ?: "An unexpected error occurred"
                    )
                }
                .collect { services ->
                    _state.value = HomeState.Success(
                        userName = "Citizen",
                        featuredServices = services.take(4),
                        announcementMessage = "New e-governance services now available!"
                    )
                }
        }
    }

    fun retry() {
        loadHomeData()
    }
}
