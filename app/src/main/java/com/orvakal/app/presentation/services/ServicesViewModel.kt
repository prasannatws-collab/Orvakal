package com.orvakal.app.presentation.services

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
class ServicesViewModel @Inject constructor(
    private val getServicesUseCase: GetServicesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<ServicesState>(ServicesState.Loading)
    val state: StateFlow<ServicesState> = _state.asStateFlow()

    init {
        loadServices()
    }

    private fun loadServices() {
        viewModelScope.launch {
            _state.value = ServicesState.Loading
            getServicesUseCase()
                .catch { throwable ->
                    _state.value = ServicesState.Error(
                        message = throwable.message ?: "An unexpected error occurred"
                    )
                }
                .collect { services ->
                    _state.value = ServicesState.Success(services)
                }
        }
    }

    fun retry() {
        loadServices()
    }
}
