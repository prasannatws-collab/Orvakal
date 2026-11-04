package com.orvakal.app.domain.usecase

import com.orvakal.app.domain.model.Service
import com.orvakal.app.domain.repository.ServiceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetServicesUseCase @Inject constructor(
    private val serviceRepository: ServiceRepository
) {
    operator fun invoke(): Flow<List<Service>> = serviceRepository.getServices()
}
