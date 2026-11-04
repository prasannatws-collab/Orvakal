package com.orvakal.app.domain.model

import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.LanguageManager

data class LocalEntity(
    val id: Int,
    val category: String,
    val name: String,
    val address: String,
    val timings: String = "",
    val phone: String = "",
    val description: String = "",
    val badge: String = "",
    val icon: String = "📍",
    val nameTe: String = "",
    val nameHi: String = "",
    val addressTe: String = "",
    val addressHi: String = "",
    val timingsTe: String = "",
    val timingsHi: String = "",
    val descTe: String = "",
    val descHi: String = "",
    val badgeTe: String = "",
    val badgeHi: String = ""
) {
    val localizedName: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> nameTe.ifEmpty { name }
            AppLanguage.HI -> nameHi.ifEmpty { name }
            else -> name
        }

    val localizedAddress: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> addressTe.ifEmpty { address }
            AppLanguage.HI -> addressHi.ifEmpty { address }
            else -> address
        }

    val localizedTimings: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> timingsTe.ifEmpty { timings }
            AppLanguage.HI -> timingsHi.ifEmpty { timings }
            else -> timings
        }

    val localizedDesc: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> descTe.ifEmpty { description }
            AppLanguage.HI -> descHi.ifEmpty { description }
            else -> description
        }

    val localizedBadge: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> badgeTe.ifEmpty { badge }
            AppLanguage.HI -> badgeHi.ifEmpty { badge }
            else -> badge
        }
}

data class CatalogCategory(
    val id: String,
    val title: String,
    val description: String,
    val icon: String,
    val categoryKey: String,
    val titleTe: String = "",
    val titleHi: String = "",
    val descTe: String = "",
    val descHi: String = ""
) {
    val localizedTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> titleTe.ifEmpty { title }
            AppLanguage.HI -> titleHi.ifEmpty { title }
            else -> title
        }

    val localizedDesc: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> descTe.ifEmpty { description }
            AppLanguage.HI -> descHi.ifEmpty { description }
            else -> description
        }
}

data class Industry(
    val id: Int,
    val name: String,
    val sector: String,
    val location: String,
    val statusBadge: String,
    val details: String = "",
    val nameTe: String = "",
    val nameHi: String = "",
    val sectorTe: String = "",
    val sectorHi: String = "",
    val locationTe: String = "",
    val locationHi: String = "",
    val statusBadgeTe: String = "",
    val statusBadgeHi: String = "",
    val detailsTe: String = "",
    val detailsHi: String = ""
) {
    val localizedName: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> nameTe.ifEmpty { name }
            AppLanguage.HI -> nameHi.ifEmpty { name }
            else -> name
        }

    val localizedSector: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> sectorTe.ifEmpty { sector }
            AppLanguage.HI -> sectorHi.ifEmpty { sector }
            else -> sector
        }

    val localizedLocation: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> locationTe.ifEmpty { location }
            AppLanguage.HI -> locationHi.ifEmpty { location }
            else -> location
        }

    val localizedStatusBadge: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> statusBadgeTe.ifEmpty { statusBadge }
            AppLanguage.HI -> statusBadgeHi.ifEmpty { statusBadge }
            else -> statusBadge
        }

    val localizedDetails: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.TE -> detailsTe.ifEmpty { details }
            AppLanguage.HI -> detailsHi.ifEmpty { details }
            else -> details
        }
}

data class LocalizedText(
    val en: String,
    val te: String,
    val hi: String
) {
    fun get(): String = when (LanguageManager.currentLanguage) {
        AppLanguage.TE -> te.ifEmpty { en }
        AppLanguage.HI -> hi.ifEmpty { en }
        else -> en
    }
}

data class Scheme(
    val id: String,
    val title: LocalizedText,
    val type: String, // "state", "central", "bank", "postal"
    val category: String, // "farmer", "women", "student", "welfare", "employment", "elderly", "disabled", "msme", "caste", "postal_financial", "postal_insurance", "postal_service", "deposits", "micro_credit", etc.
    val description: LocalizedText,
    val benefits: LocalizedText,
    val eligibility: LocalizedText,
    val applyProcess: LocalizedText
)

data class MandiCropRate(
    val id: String,
    val cropName: LocalizedText,
    val variety: String,
    val marketYard: String,
    val minPrice: Int,
    val maxPrice: Int,
    val modalPrice: Int,
    val unit: String = "₹ / Quintal",
    val arrivalTons: String,
    val trend: String,
    val isPositiveTrend: Boolean = true,
    val category: String // "Oilseeds", "Pulses", "Commercial", "Cereals", "Vegetables"
)

data class MspRateItem(
    val cropName: LocalizedText,
    val variety: String,
    val season: String,
    val msp2024: Int,
    val msp2023: Int,
    val absoluteIncrease: Int,
    val costA2FL: Int,
    val marginPercent: String,
    val icon: String
)

data class TransportInfo(
    val id: String,
    val type: String, // "flight", "bus", "train", "auto"
    val title: LocalizedText,
    val subtitle: LocalizedText,
    val location: String,
    val distance: String,
    val timingsOrFrequency: LocalizedText,
    val keyRoutes: List<String>,
    val contactPhone: String = "",
    val details: LocalizedText,
    val icon: String
)

data class PowerFeederInfo(
    val groupName: LocalizedText,
    val villagesCovered: String,
    val supplySlot1: String,
    val supplySlot2: String = "",
    val totalHours: String = "9 Hours",
    val phase: String = "3-Phase Agricultural",
    val status: String = "Active (Live)",
    val icon: String = "⚡"
)

data class MachineryRentItem(
    val name: LocalizedText,
    val category: String,
    val rentPerHour: String,
    val ownerName: String,
    val village: String,
    val phone: String,
    val details: LocalizedText,
    val icon: String
)

data class CropAdvisoryItem(
    val crop: LocalizedText,
    val stage: LocalizedText,
    val problem: LocalizedText,
    val solution: LocalizedText,
    val recommendedDosage: String,
    val icon: String
)

