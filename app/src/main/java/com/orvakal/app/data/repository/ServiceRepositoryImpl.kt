package com.orvakal.app.data.repository

import com.orvakal.app.data.local.dao.ServiceDao
import com.orvakal.app.data.local.entity.ServiceEntity
import com.orvakal.app.data.remote.api.OrvikalApiService
import com.orvakal.app.domain.model.Service
import com.orvakal.app.domain.repository.ServiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ServiceRepositoryImpl @Inject constructor(
    private val apiService: OrvikalApiService,
    private val serviceDao: ServiceDao
) : ServiceRepository {

    override fun getServices(): Flow<List<Service>> = flow {
        // Emit cached data first
        val cachedServices = getDummyServices()
        emit(cachedServices)
    }

    override suspend fun getServiceById(id: Int): Service? {
        return getDummyServices().find { it.id == id }
    }

    /**
     * Returns dummy/stub services since there is no real backend.
     * In production this would fetch from the API and cache to Room.
     */
    private fun getDummyServices(): List<Service> = listOf(
        Service(
            id = 1,
            name = "Education",
            description = "Access scholarships, school admissions, university applications, and digital learning resources for students of all levels.",
            category = "Education",
            icon = "🎓",
            isAvailable = true
        ),
        Service(
            id = 2,
            name = "Healthcare",
            description = "Book hospital appointments, access health records, find nearby clinics, and apply for health insurance schemes.",
            category = "Healthcare",
            icon = "🏥",
            isAvailable = true
        ),
        Service(
            id = 3,
            name = "Agriculture",
            description = "Get weather updates, apply for crop loans, access market prices, and register for agricultural subsidies.",
            category = "Agriculture",
            icon = "🌾",
            isAvailable = true
        ),
        Service(
            id = 4,
            name = "Government",
            description = "Apply for certificates, renew licenses, pay taxes, and access all government e-services in one place.",
            category = "Government",
            icon = "🏛️",
            isAvailable = true
        ),
        Service(
            id = 5,
            name = "Finance",
            description = "Manage your bank accounts, apply for loans, invest in government bonds, and track your pension status.",
            category = "Finance",
            icon = "💰",
            isAvailable = true
        ),
        Service(
            id = 6,
            name = "Transport",
            description = "Book bus and train tickets, renew driving license, register vehicles, and check real-time transport schedules.",
            category = "Transport",
            icon = "🚌",
            isAvailable = true
        )
    )

    private fun ServiceEntity.toDomain() = Service(
        id = id,
        name = name,
        description = description,
        category = category,
        icon = icon,
        isAvailable = isAvailable
    )
}
