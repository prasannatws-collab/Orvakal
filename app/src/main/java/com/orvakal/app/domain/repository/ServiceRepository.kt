package com.orvakal.app.domain.repository

import com.orvakal.app.domain.model.Service
import kotlinx.coroutines.flow.Flow

interface ServiceRepository {
    fun getServices(): Flow<List<Service>>
    suspend fun getServiceById(id: Int): Service?
}
