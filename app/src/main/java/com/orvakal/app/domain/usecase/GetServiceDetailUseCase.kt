package com.orvakal.app.domain.usecase

import com.orvakal.app.domain.model.Service
import com.orvakal.app.domain.repository.ServiceRepository
import javax.inject.Inject

class GetServiceDetailUseCase @Inject constructor(
    private val serviceRepository: ServiceRepository
) {
    suspend operator fun invoke(id: Int): Service? = serviceRepository.getServiceById(id)
}
