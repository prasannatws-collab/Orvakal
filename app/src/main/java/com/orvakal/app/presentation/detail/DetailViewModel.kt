package com.orvakal.app.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orvakal.app.domain.model.Service
import com.orvakal.app.domain.usecase.GetServiceDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface DetailState {
    data object Loading : DetailState
    data class Success(val service: Service) : DetailState
    data class Error(val message: String) : DetailState
}

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getServiceDetailUseCase: GetServiceDetailUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<DetailState>(DetailState.Loading)
    val state: StateFlow<DetailState> = _state.asStateFlow()

    fun loadService(id: Int) {
        viewModelScope.launch {
            _state.value = DetailState.Loading
            try {
                val service = getServiceDetailUseCase(id)
                if (service != null) {
                    _state.value = DetailState.Success(service)
                } else {
                    _state.value = DetailState.Error("Service not found")
                }
            } catch (e: Exception) {
                _state.value = DetailState.Error(e.message ?: "An unexpected error occurred")
            }
        }
    }
}
