package com.orvakal.app.presentation.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.data.local.OrvakalData
import com.orvakal.app.data.local.OrvakalSchemesData
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.AppStrings
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.domain.model.LocalEntity
import com.orvakal.app.domain.model.Scheme
import com.orvakal.app.presentation.common.OrvakalSubHeader
import com.orvakal.app.presentation.common.OrvakalTeal
import com.orvakal.app.presentation.common.OrvakalTealDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    categoryKey: String,
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit = {}
) {
    // If navigating to schemes, render the specialized Schemes Catalog view
    val isSchemesCategory = categoryKey in listOf(
        "govt_schemes",
        "schemes",
        "farmer_schemes",
        "bank_schemes",
        "postal_schemes"
    )

    var navigateToSchemesType by remember { mutableStateOf<String?>(null) }

    if (isSchemesCategory) {
        SchemesCatalogView(
            categoryKey = categoryKey,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (navigateToSchemesType != null) {
        SchemesCatalogView(
            categoryKey = navigateToSchemesType!!,
            onBack = { navigateToSchemesType = null },
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "transport") {
        TransportHubDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "grievance") {
        GrievanceDeskDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "police") {
        PoliceStationDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "power_schedule") {
        PowerScheduleDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "mandi_rates") {
        MandiRatesDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "msp_rates") {
        MspRatesDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "machinery_rent") {
        MachineryRentDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "crop_advisory") {
        CropAdvisoryDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "water_levels") {
        WaterLevelsDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "tractor_repairs" || categoryKey == "breakdown") {
        TractorRepairsDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else if (categoryKey == "agri_officers") {
        AgriOfficersDetailView(
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )
    } else {
        var searchQuery by remember { mutableStateOf("") }

    // Map category key to readable title with language support
    val currentLang = LanguageManager.currentLanguage
    val title = when (categoryKey) {
        "medical_stores" -> when (currentLang) {
            AppLanguage.TE -> "మెడికల్ స్టోర్స్ & మందుల దుకాణాలు"
            AppLanguage.HI -> "मेडिकल स्टोर और दवाइयां"
            else -> "Medical Stores & Chemists"
        }
        "kiranam" -> when (currentLang) {
            AppLanguage.TE -> "కిరాణా & నిత్యావసరాలు"
            AppLanguage.HI -> "किराना और दैनिक वस्तुएं"
            else -> "Kiranam & General Stores"
        }
        "hospital", "hospitals" -> when (currentLang) {
            AppLanguage.TE -> "ఆసుపత్రి & ప్రాథమిక ఆరోగ్య కేంద్రం"
            AppLanguage.HI -> "अस्पताल और प्राथमिक स्वास्थ्य केंद्र"
            else -> "Hospitals & PHC Clinics"
        }
        "pesticides" -> when (currentLang) {
            AppLanguage.TE -> "పురుగుమందులు & ఎరువులు"
            AppLanguage.HI -> "कीटनाशक एवं उर्वरक"
            else -> "Pesticides & Agri Marts"
        }
        "milk" -> when (currentLang) {
            AppLanguage.TE -> "పాల డెయిరీలు & కేంద్రాలు"
            AppLanguage.HI -> "दुग्ध डेयरियां और केंद्र"
            else -> "Milk Dairies"
        }
        "mineral_water" -> when (currentLang) {
            AppLanguage.TE -> "మినరల్ వాటర్ ప్లాంట్లు"
            AppLanguage.HI -> "मिनरल वाटर प्लांट"
            else -> "Mineral Water Plants"
        }
        "restaurants" -> when (currentLang) {
            AppLanguage.TE -> "భోజనశాలలు & రెస్టారెంట్లు"
            AppLanguage.HI -> "भोजनालय और रेस्तरां"
            else -> "Food & Restaurants"
        }
        "hardware" -> when (currentLang) {
            AppLanguage.TE -> "హార్డ్‌వేర్ & ఎలక్ట్రికల్స్"
            AppLanguage.HI -> "हार्डवेयर और इलेक्ट्रिकल्स"
            else -> "Hardware & Traders"
        }
        "hotels" -> when (currentLang) {
            AppLanguage.TE -> "హోటళ్ళు & బస"
            AppLanguage.HI -> "होटल और ठहरने की व्यवस्था"
            else -> "Hotels & Stays"
        }
        "temples" -> when (currentLang) {
            AppLanguage.TE -> "దేవాలయాలు & పుణ్యక్షేత్రాలు"
            AppLanguage.HI -> "मंदिर और धार्मिक स्थल"
            else -> "Temples & Holy Shrines"
        }
        "mosque", "mosques" -> when (currentLang) {
            AppLanguage.TE -> "మసీదులు & దర్గాలు"
            AppLanguage.HI -> "मस्जिदें और दरगाहें"
            else -> "Mosques & Dargahs"
        }
        "church", "churches" -> when (currentLang) {
            AppLanguage.TE -> "చర్చ్‌లు (క్రైస్తవ ప్రార్థనా మందిరాలు)"
            AppLanguage.HI -> "चर्च (गिरजाघर)"
            else -> "Churches"
        }
        "veterinary" -> when (currentLang) {
            AppLanguage.TE -> "పశువైద్య సేవలు"
            AppLanguage.HI -> "पशु चिकित्सा सेवाएं"
            else -> "Veterinary Services"
        }
        "school", "schools" -> when (currentLang) {
            AppLanguage.TE -> "పాఠశాలలు & విద్యా కేంద్రాలు"
            AppLanguage.HI -> "स्कूल और शिक्षा केंद्र"
            else -> "Schools & Colleges"
        }
        "post_office", "post" -> when (currentLang) {
            AppLanguage.TE -> "పోస్ట్ ఆఫీస్ & సేవలు"
            AppLanguage.HI -> "डाकघर और सेवाएं"
            else -> "Post Office & Services"
        }
        "bank", "banks" -> when (currentLang) {
            AppLanguage.TE -> "బ్యాంకులు & ఏటీఎంలు"
            AppLanguage.HI -> "बैंक और एटीएम"
            else -> "Banks & ATMs"
        }
        "shopping" -> when (currentLang) {
            AppLanguage.TE -> "బట్టల దుకాణాలు & షాపింగ్"
            AppLanguage.HI -> "कपड़ों की खरीदारी"
            else -> "Cloth Shopping"
        }
        "govt_offices", "offices" -> when (currentLang) {
            AppLanguage.TE -> "ప్రభుత్వ కార్యాలయాలు & అధికారులు"
            AppLanguage.HI -> "सरकारी कार्यालय और अधिकारी"
            else -> "Govt Offices & Administration"
        }
        "visiting_places" -> when (currentLang) {
            AppLanguage.TE -> "దర్శనీయ స్థలాలు & పర్యాటకం"
            AppLanguage.HI -> "पर्यटन एवं दर्शनीय स्थल"
            else -> "Visiting Places & Tourism"
        }
        "market" -> when (currentLang) {
            AppLanguage.TE -> "రైతు & వస్తు మార్కెట్లు"
            AppLanguage.HI -> "किसान एवं वस्तु बाजार"
            else -> "Rythu & Commodity Markets"
        }
        "internet_tv" -> when (currentLang) {
            AppLanguage.TE -> "ఇంటర్నెట్ & కేబుల్ టీవీ సేవలు"
            AppLanguage.HI -> "इंटरनेट और केबल टीवी सेवाएं"
            else -> "Internet & Cable TV Services"
        }
        "decors" -> when (currentLang) {
            AppLanguage.TE -> "బొటిక్‌లు, టైలర్స్ & డెకర్స్"
            AppLanguage.HI -> "बुटीक, दर्जी और सजावट"
            else -> "Decorations & Events"
        }
        "banquet_halls" -> when (currentLang) {
            AppLanguage.TE -> "కళ్యాణ మండపాలు & ఫంక్షన్ హాళ్లు"
            AppLanguage.HI -> "कल्याण मंडप और फंक्शन हॉल"
            else -> "Banquet & Function Halls"
        }
        "courier" -> when (currentLang) {
            AppLanguage.TE -> "కొరియర్ & లాజిస్టిక్స్"
            AppLanguage.HI -> "कूरियर और लॉजिस्टिक्स"
            else -> "Courier & Express Logistics"
        }
        "village_committees", "committees" -> when (currentLang) {
            AppLanguage.TE -> "గ్రామ కమిటీలు & మండళ్లు"
            AppLanguage.HI -> "ग्राम समितियां और मंडल"
            else -> "Village Committees & Clubs"
        }
        "library" -> when (currentLang) {
            AppLanguage.TE -> "ప్రజా గ్రంథాలయం (శాఖా గ్రంథాలయం)"
            AppLanguage.HI -> "सार्वजनिक पुस्तकालय"
            else -> "Public Branch Library"
        }
        else -> categoryKey.replace("_", " ").replaceFirstChar { it.uppercase() }
    }

    // Filter entities by category and search
    val places = OrvakalData.allEntities.filter { entity ->
        val matchesCategory = if (categoryKey.isEmpty() || categoryKey == "all") {
            true
        } else if (categoryKey.equals("church", ignoreCase = true) || categoryKey.equals("churches", ignoreCase = true)) {
            entity.category.equals("church", ignoreCase = true) || entity.category.equals("churches", ignoreCase = true)
        } else if (categoryKey.equals("hospital", ignoreCase = true) || categoryKey.equals("hospitals", ignoreCase = true)) {
            entity.category.equals("hospital", ignoreCase = true) || entity.category.equals("hospitals", ignoreCase = true)
        } else if (categoryKey.equals("school", ignoreCase = true) || categoryKey.equals("schools", ignoreCase = true)) {
            entity.category.equals("school", ignoreCase = true) || entity.category.equals("schools", ignoreCase = true)
        } else if (categoryKey.equals("bank", ignoreCase = true) || categoryKey.equals("banks", ignoreCase = true)) {
            entity.category.equals("bank", ignoreCase = true) || entity.category.equals("banks", ignoreCase = true)
        } else if (categoryKey.equals("post_office", ignoreCase = true) || categoryKey.equals("post", ignoreCase = true)) {
            entity.category.equals("post_office", ignoreCase = true)
        } else if (categoryKey.equals("govt_offices", ignoreCase = true) || categoryKey.equals("offices", ignoreCase = true)) {
            entity.category.equals("govt_offices", ignoreCase = true)
        } else if (categoryKey.equals("village_committees", ignoreCase = true) || categoryKey.equals("committees", ignoreCase = true)) {
            entity.category.equals("village_committees", ignoreCase = true)
        } else {
            entity.category.equals(categoryKey, ignoreCase = true)
        }
        val matchesSearch = searchQuery.isEmpty() ||
                entity.name.contains(searchQuery, ignoreCase = true) ||
                entity.nameTe.contains(searchQuery, ignoreCase = true) ||
                entity.nameHi.contains(searchQuery, ignoreCase = true) ||
                entity.address.contains(searchQuery, ignoreCase = true) ||
                entity.addressTe.contains(searchQuery, ignoreCase = true) ||
                entity.addressHi.contains(searchQuery, ignoreCase = true)

        matchesCategory && matchesSearch
    }

    val isDark = com.orvakal.app.presentation.theme.ThemeManager.isDarkMode

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDark) Color(0xFF121212) else Color(0xFFF3F7F8))
    ) {
        // Top Sub-Header
        OrvakalSubHeader(
            title = title,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )

        // Banner shortcut to Bank / Postal schemes if applicable
        if (categoryKey == "bank") {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable { navigateToSchemesType = "bank_schemes" },
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFA5D6A7))
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("🏦", fontSize = 24.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (LanguageManager.currentLanguage == AppLanguage.TE) "బ్యాంకు రుణాలు & పథకాలు చూడండి" else if (LanguageManager.currentLanguage == AppLanguage.HI) "बैंक ऋण और योजनाएं देखें" else "View Bank Schemes & Loans",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B5E20)
                        )
                        Text(
                            text = "KCC, Canara Stree Shakti, PM SVANidhi, Stand-Up India, FDs",
                            fontSize = 11.sp,
                            color = Color(0xFF2E7D32)
                        )
                    }
                    Text("➔", fontSize = 16.sp, color = Color(0xFF1B5E20), fontWeight = FontWeight.Bold)
                }
            }
        } else if (categoryKey == "post_office") {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable { navigateToSchemesType = "postal_schemes" },
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFFFCDD2))
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("📮", fontSize = 24.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = if (LanguageManager.currentLanguage == AppLanguage.TE) "పోస్టాఫీస్ 12 పొదుపు పథకాలు చూడండి" else if (LanguageManager.currentLanguage == AppLanguage.HI) "डाकघर की 12 बचत योजनाएं देखें" else "View 12 Post Office Schemes",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFB71C1C)
                        )
                        Text(
                            text = "MIS, RD, PPF, Sukanya Samriddhi, KVP, NSC, RPLI, IPPB",
                            fontSize = 11.sp,
                            color = Color(0xFFC62828)
                        )
                    }
                    Text("➔", fontSize = 16.sp, color = Color(0xFFB71C1C), fontWeight = FontWeight.Bold)
                }
            }
        }

        // Search Bar inside category
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                placeholder = {
                    Text(
                        "Search in $title...",
                        color = Color(0xFF78909C),
                        fontSize = 13.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = OrvakalTeal,
                        modifier = Modifier.size(18.dp)
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = if (isDark) Color(0xFF1E1E1E) else Color.White,
                    unfocusedContainerColor = if (isDark) Color(0xFF1E1E1E) else Color.White,
                    focusedTextColor = if (isDark) Color.White else Color(0xFF212121),
                    unfocusedTextColor = if (isDark) Color.White else Color(0xFF212121),
                    focusedBorderColor = OrvakalTeal,
                    unfocusedBorderColor = if (isDark) Color(0xFF424242) else Color(0xFFCFD8DC)
                )
            )
        }

        // List of Places / Stores
        if (places.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🔍", fontSize = 36.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "No entries found",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF455A64)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Check your search keywords or try another category",
                        fontSize = 12.sp,
                        color = Color(0xFF78909C)
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(places) { place ->
                    PlaceDetailCard(place = place)
                }
                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchemesCatalogView(
    categoryKey: String,
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    // Initial type tab index
    val initialTabIndex = when (categoryKey) {
        "bank_schemes" -> 3
        "postal_schemes" -> 4
        else -> 0
    }

    var selectedTabIndex by remember { mutableIntStateOf(initialTabIndex) }
    var selectedCategoryFilter by remember {
        mutableStateOf(if (categoryKey == "farmer_schemes") "farmer" else "all")
    }
    var searchQuery by remember { mutableStateOf("") }

    val tabs = listOf(
        AppStrings.allSchemesTab to "all",
        AppStrings.stateGovtTab to "state",
        AppStrings.centralGovtTab to "central",
        AppStrings.bankSchemesTab to "bank",
        AppStrings.postalSchemesTab to "postal"
    )

    val currentLang = LanguageManager.currentLanguage

    // Filter categories options
    val categoryFilters = listOf(
        "all" to (if (currentLang == AppLanguage.TE) "అన్నీ" else if (currentLang == AppLanguage.HI) "सभी" else "All"),
        "farmer" to (if (currentLang == AppLanguage.TE) "🌾 రైతులు" else if (currentLang == AppLanguage.HI) "🌾 किसान" else "🌾 Farmers"),
        "women" to (if (currentLang == AppLanguage.TE) "👩 మహిళలు" else if (currentLang == AppLanguage.HI) "👩 महिलाएं" else "👩 Women"),
        "student" to (if (currentLang == AppLanguage.TE) "🎓 విద్యార్థులు" else if (currentLang == AppLanguage.HI) "🎓 विद्यार्थी" else "🎓 Students"),
        "welfare" to (if (currentLang == AppLanguage.TE) "🛡️ పెన్షన్ & సంక్షేమం" else if (currentLang == AppLanguage.HI) "🛡️ पेंशन व कल्याण" else "🛡️ Welfare & Pension"),
        "msme" to (if (currentLang == AppLanguage.TE) "🏭 ఉపాధి & MSME" else if (currentLang == AppLanguage.HI) "🏭 एमएसएमई व रोजगार" else "🏭 MSME & Employment"),
        "disabled" to (if (currentLang == AppLanguage.TE) "♿ దివ్యాంగులు" else if (currentLang == AppLanguage.HI) "♿ दिव्यांग" else "♿ Divyangjan"),
        "postal_financial" to (if (currentLang == AppLanguage.TE) "💰 పొదుపు & డిపాజిట్లు" else if (currentLang == AppLanguage.HI) "💰 बचत व जमा" else "💰 Savings & FDs")
    )

    // Filter schemes
    val filteredSchemes = OrvakalSchemesData.allSchemes.filter { scheme ->
        // Type filter
        val selectedType = tabs[selectedTabIndex].second
        val matchesType = if (selectedType == "all") true else scheme.type.equals(selectedType, ignoreCase = true)

        // Category filter
        val matchesCategory = if (selectedCategoryFilter == "all") {
            true
        } else when (selectedCategoryFilter) {
            "farmer" -> scheme.category.contains("farmer", ignoreCase = true) || scheme.category.contains("agri", ignoreCase = true)
            "women" -> scheme.category.contains("women", ignoreCase = true)
            "student" -> scheme.category.contains("student", ignoreCase = true) || scheme.category.contains("education", ignoreCase = true)
            "welfare" -> scheme.category.contains("welfare", ignoreCase = true) || scheme.category.contains("social", ignoreCase = true) || scheme.category.contains("elderly", ignoreCase = true)
            "msme" -> scheme.category.contains("msme", ignoreCase = true) || scheme.category.contains("employment", ignoreCase = true)
            "disabled" -> scheme.category.contains("disabled", ignoreCase = true)
            "postal_financial" -> scheme.category.contains("postal", ignoreCase = true) || scheme.category.contains("deposits", ignoreCase = true) || scheme.category.contains("financial", ignoreCase = true)
            else -> scheme.category.contains(selectedCategoryFilter, ignoreCase = true)
        }

        // Search query
        val titleText = scheme.title.get()
        val descText = scheme.description.get()
        val benText = scheme.benefits.get()
        val eligText = scheme.eligibility.get()
        val matchesSearch = searchQuery.isEmpty() ||
                titleText.contains(searchQuery, ignoreCase = true) ||
                descText.contains(searchQuery, ignoreCase = true) ||
                benText.contains(searchQuery, ignoreCase = true) ||
                eligText.contains(searchQuery, ignoreCase = true)

        matchesType && matchesCategory && matchesSearch
    }

    val pageTitle = when (categoryKey) {
        "farmer_schemes" -> if (currentLang == AppLanguage.TE) "🌾 రైతు సంక్షేమ పథకాలు" else if (currentLang == AppLanguage.HI) "🌾 किसान कल्याण योजनाएं" else "🌾 Farmer Schemes & Subsidies"
        "bank_schemes" -> if (currentLang == AppLanguage.TE) "🏦 బ్యాంకు రుణాలు & పథకాలు" else if (currentLang == AppLanguage.HI) "🏦 बैंक ऋण व योजनाएं" else "🏦 Bank Schemes & Credit"
        "postal_schemes" -> if (currentLang == AppLanguage.TE) "📮 పోస్టాఫీస్ 12 పొదుపు పథకాలు" else if (currentLang == AppLanguage.HI) "📮 डाकघर 12 बचत योजनाएं" else "📮 12 Post Office Schemes"
        else -> AppStrings.schemesPortalTitle
    }

    val isDark = com.orvakal.app.presentation.theme.ThemeManager.isDarkMode

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDark) Color(0xFF121212) else Color(0xFFF3F7F8))
    ) {
        // Top Sub-Header
        OrvakalSubHeader(
            title = pageTitle,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )

        // Type Tabs (All, AP State, Central, Bank, Postal)
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color(0xFF003740),
            contentColor = Color.White,
            edgePadding = 12.dp
        ) {
            tabs.forEachIndexed { index, (label, _) ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            text = label,
                            fontSize = 13.sp,
                            fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Normal,
                            color = if (selectedTabIndex == index) Color(0xFF80DEEA) else Color.White.copy(alpha = 0.8f)
                        )
                    }
                )
            }
        }

        // Search Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                placeholder = {
                    Text(
                        AppStrings.searchSchemesPlaceholder,
                        color = Color(0xFF78909C),
                        fontSize = 12.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = OrvakalTeal,
                        modifier = Modifier.size(18.dp)
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = if (isDark) Color(0xFF1E1E1E) else Color.White,
                    unfocusedContainerColor = if (isDark) Color(0xFF1E1E1E) else Color.White,
                    focusedTextColor = if (isDark) Color.White else Color(0xFF212121),
                    unfocusedTextColor = if (isDark) Color.White else Color(0xFF212121),
                    focusedBorderColor = OrvakalTeal,
                    unfocusedBorderColor = if (isDark) Color(0xFF424242) else Color(0xFFCFD8DC)
                )
            )
        }

        // Category Pills Filter
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categoryFilters) { (catKey, catLabel) ->
                val isSelected = selectedCategoryFilter == catKey
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedCategoryFilter = catKey },
                    label = {
                        Text(
                            text = catLabel,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = OrvakalTeal,
                        selectedLabelColor = Color.White,
                        containerColor = Color.White,
                        labelColor = Color(0xFF37474F)
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = isSelected,
                        borderColor = if (isSelected) OrvakalTeal else Color(0xFFCFD8DC)
                    )
                )
            }
        }

        // Results count indicator
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${filteredSchemes.size} " + (if (currentLang == AppLanguage.TE) "పథకాలు లభ్యం" else if (currentLang == AppLanguage.HI) "योजनाएं उपलब्ध" else "schemes available"),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF546E7A)
            )
            if (searchQuery.isNotEmpty() || selectedCategoryFilter != "all" || selectedTabIndex != 0) {
                Text(
                    text = if (currentLang == AppLanguage.TE) "ఫిల్టర్లు రీసెట్" else if (currentLang == AppLanguage.HI) "रीसेट करें" else "Reset filters",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = OrvakalTeal,
                    modifier = Modifier.clickable {
                        searchQuery = ""
                        selectedCategoryFilter = "all"
                        selectedTabIndex = 0
                    }
                )
            }
        }

        // Schemes List
        if (filteredSchemes.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("📜", fontSize = 42.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        if (currentLang == AppLanguage.TE) "పథకాలు కనుగొనబడలేదు" else if (currentLang == AppLanguage.HI) "कोई योजना नहीं मिली" else "No schemes match your filter",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF37474F)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        if (currentLang == AppLanguage.TE) "వేరొక విభాగం లేదా సెర్చ్ పదాన్ని ప్రయత్నించండి" else if (currentLang == AppLanguage.HI) "कृपया दूसरा खोज शब्द या फ़िल्टर आज़माएं" else "Try clearing your search keyword or switching tabs",
                        fontSize = 12.sp,
                        color = Color(0xFF78909C)
                    )
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(filteredSchemes, key = { it.id }) { scheme ->
                    SchemeCard(scheme = scheme)
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

@Composable
fun SchemeCard(scheme: Scheme) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage
    val isDark = com.orvakal.app.presentation.theme.ThemeManager.isDarkMode

    val (badgeBg, badgeText, badgeColor) = when (scheme.type.lowercase()) {
        "state" -> Triple(
            if (isDark) Color(0xFF1B3820) else Color(0xFFE8F5E9),
            if (currentLang == AppLanguage.TE) "🏛️ ఆంధ్రప్రదేశ్ రాష్ట్ర ప్రభుత్వం" else if (currentLang == AppLanguage.HI) "🏛️ आंध्र प्रदेश राज्य सरकार" else "🏛️ AP State Government",
            if (isDark) Color(0xFFA5D6A7) else Color(0xFF2E7D32)
        )
        "central" -> Triple(
            if (isDark) Color(0xFF1A237E) else Color(0xFFE8EAF6),
            if (currentLang == AppLanguage.TE) "🇮🇳 భారత కేంద్ర ప్రభుత్వం" else if (currentLang == AppLanguage.HI) "🇮🇳 भारत केंद्र सरकार" else "🇮🇳 Central Government",
            if (isDark) Color(0xFF9FA8DA) else Color(0xFF283593)
        )
        "bank" -> Triple(
            if (isDark) Color(0xFF3E2723) else Color(0xFFFFF3E0),
            if (currentLang == AppLanguage.TE) "🏦 బ్యాంకింగ్ & వ్యవసాయ రుణం" else if (currentLang == AppLanguage.HI) "🏦 बैंकिंग व ऋण योजना" else "🏦 Commercial Bank Credit",
            if (isDark) Color(0xFFFFCC80) else Color(0xFFE65100)
        )
        "postal" -> Triple(
            if (isDark) Color(0xFF4A148C) else Color(0xFFFFEBEE),
            if (currentLang == AppLanguage.TE) "📮 భారత తపాలా శాఖ (ఇండియా పోస్ట్)" else if (currentLang == AppLanguage.HI) "📮 भारतीय डाक विभाग (India Post)" else "📮 India Post / Postal Dept",
            if (isDark) Color(0xFFEF9A9A) else Color(0xFFC62828)
        )
        else -> Triple(
            if (isDark) Color(0xFF263238) else Color(0xFFECEFF1),
            "Government Scheme",
            if (isDark) Color(0xFFB0BEC5) else Color(0xFF37474F)
        )
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header Row: Type Badge + Category Pill
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Source Type Badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(badgeBg)
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = badgeText,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = badgeColor
                    )
                }

                // Category Tag
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (isDark) Color(0xFF2C2C2C) else Color(0xFFF1F5F9))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = scheme.category.uppercase(),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF475569)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Scheme Title
            Text(
                text = scheme.title.get(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color = if (isDark) Color.White else Color(0xFF0F172A)
            )

            // Description
            if (scheme.description.get().isNotEmpty()) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = scheme.description.get(),
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    color = if (isDark) Color(0xFFCBD5E1) else Color(0xFF475569)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Benefits Box (Highlighted in soft green)
            if (scheme.benefits.get().isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(if (isDark) Color(0xFF132E1B) else Color(0xFFF0FDF4))
                        .border(
                            1.dp,
                            if (isDark) Color(0xFF1E5E2C) else Color(0xFFBBF7D0),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(12.dp)
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("💰", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = AppStrings.schemeBenefits,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isDark) Color(0xFFA7F3D0) else Color(0xFF166534)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = scheme.benefits.get(),
                            fontSize = 12.sp,
                            lineHeight = 17.sp,
                            fontWeight = FontWeight.Medium,
                            color = if (isDark) Color(0xFFD1FAE5) else Color(0xFF14532D)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Eligibility Box (Highlighted in soft amber)
            if (scheme.eligibility.get().isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(if (isDark) Color(0xFF2E2215) else Color(0xFFFFFBEB))
                        .border(
                            1.dp,
                            if (isDark) Color(0xFF78350F) else Color(0xFFFDE68A),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(12.dp)
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🎯", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = AppStrings.schemeEligibility,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isDark) Color(0xFFFDE68A) else Color(0xFF92400E)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = scheme.eligibility.get(),
                            fontSize = 12.sp,
                            lineHeight = 17.sp,
                            color = if (isDark) Color(0xFFFEF3C7) else Color(0xFF78350F)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            // How to Apply Box (Highlighted in soft sky blue)
            if (scheme.applyProcess.get().isNotEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(if (isDark) Color(0xFF0C2B3F) else Color(0xFFF0F9FF))
                        .border(
                            1.dp,
                            if (isDark) Color(0xFF0369A1) else Color(0xFFBAE6FD),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(12.dp)
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("📝", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = AppStrings.schemeHowToApply,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isDark) Color(0xFFBAE6FD) else Color(0xFF0369A1)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = scheme.applyProcess.get(),
                            fontSize = 12.sp,
                            lineHeight = 17.sp,
                            color = if (isDark) Color(0xFFE0F2FE) else Color(0xFF0C4A6E)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Action: Share Scheme Info
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            val shareBody = buildString {
                                appendLine("📢 ${scheme.title.get()}")
                                appendLine()
                                appendLine("📋 Description:")
                                appendLine(scheme.description.get())
                                appendLine()
                                appendLine("💰 Benefits:")
                                appendLine(scheme.benefits.get())
                                appendLine()
                                appendLine("🎯 Eligibility:")
                                appendLine(scheme.eligibility.get())
                                appendLine()
                                appendLine("📝 How to Apply:")
                                appendLine(scheme.applyProcess.get())
                                appendLine()
                                appendLine("Shared from Orvakal Village & Industrial Hub Portal")
                            }
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_SUBJECT, scheme.title.get())
                                putExtra(Intent.EXTRA_TEXT, shareBody)
                            }
                            context.startActivity(Intent.createChooser(intent, "Share Scheme"))
                        }
                        .background(Color(0xFFF1F5F9))
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        tint = Color(0xFF475569),
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = if (currentLang == AppLanguage.TE) "షేర్ చేయండి" else if (currentLang == AppLanguage.HI) "शेयर करें" else "Share Details",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF475569)
                    )
                }
            }
        }
    }
}

@Composable
fun PlaceDetailCard(
    place: LocalEntity
) {
    val currentLang = LanguageManager.currentLanguage
    val isDark = com.orvakal.app.presentation.theme.ThemeManager.isDarkMode

    val placeName = place.localizedName
    val placeAddress = place.localizedAddress
    val placeTimings = place.localizedTimings
    val placeDesc = place.localizedDesc

    val shareLabel = when (currentLang) {
        AppLanguage.TE -> "షేర్"
        AppLanguage.HI -> "शेयर करें"
        else -> "Share"
    }
    val directionsLabel = when (currentLang) {
        AppLanguage.TE -> "రూట్ మ్యాప్స్ ↗"
        AppLanguage.HI -> "दिशाएं ↗"
        else -> "Get Directions ↗"
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header: Icon + Name
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(if (isDark) Color(0xFF004D40) else Color(0xFFE0F2F1)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = place.icon,
                        fontSize = 20.sp
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = placeName,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isDark) Color.White else Color(0xFF212121)
                    )

                    if (placeTimings.isNotBlank()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(if (isDark) Color(0xFF1B5E20) else Color(0xFFE8F5E9))
                                .padding(horizontal = 7.dp, vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("🕒", fontSize = 10.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = placeTimings,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isDark) Color(0xFFA5D6A7) else Color(0xFF2E7D32)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Address
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Text("📍", fontSize = 13.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = placeAddress,
                    fontSize = 12.sp,
                    lineHeight = 17.sp,
                    color = if (isDark) Color(0xFFB0BEC5) else Color(0xFF546E7A)
                )
            }

            // Description if present
            if (placeDesc.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = placeDesc,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF37474F)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Action row: Directions & Share
            val context = LocalContext.current
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Share action
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            val sendIntent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, "$placeName\n$placeAddress\nOrvakal, Kurnool, AP 518010")
                                type = "text/plain"
                            }
                            context.startActivity(Intent.createChooser(sendIntent, "Share place"))
                        }
                        .background(if (isDark) Color(0xFF2C2C2C) else Color(0xFFECEFF1))
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        tint = if (isDark) Color(0xFFCFD8DC) else Color(0xFF455A64),
                        modifier = Modifier.size(13.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = shareLabel,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF455A64)
                    )
                }

                // Directions to Google Maps
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            val gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode("$placeName, $placeAddress"))
                            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                            mapIntent.setPackage("com.google.android.apps.maps")
                            try {
                                context.startActivity(mapIntent)
                            } catch (e: Exception) {
                                val fallbackIntent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Uri.encode("$placeName, $placeAddress"))
                                )
                                context.startActivity(fallbackIntent)
                            }
                        }
                        .background(if (isDark) Color(0xFF004D40) else Color(0xFFE0F2F1))
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Directions,
                        contentDescription = null,
                        tint = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = directionsLabel,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark
                    )
                }
            }
        }
    }
}
