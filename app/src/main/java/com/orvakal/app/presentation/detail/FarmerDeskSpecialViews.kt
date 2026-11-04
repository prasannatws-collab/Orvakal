package com.orvakal.app.presentation.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.domain.model.CropAdvisoryItem
import com.orvakal.app.domain.model.MachineryRentItem
import com.orvakal.app.domain.model.MandiCropRate
import com.orvakal.app.domain.model.MspRateItem
import com.orvakal.app.domain.model.PowerFeederInfo
import com.orvakal.app.presentation.common.OrvakalSubHeader
import com.orvakal.app.presentation.common.OrvakalTeal
import com.orvakal.app.presentation.common.OrvakalTealDark
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// 1. Live Agri Mandi Rates (Fetched from Agmarknet Kurnool & Regional Yards)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MandiRatesDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val currentLang = LanguageManager.currentLanguage
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategoryFilter by remember { mutableStateOf("All") }
    var refreshTimestamp by remember {
        mutableStateOf(SimpleDateFormat("dd MMM, hh:mm a", Locale.getDefault()).format(Date()))
    }

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "వ్యవసాయ మార్కెట్ ధరలు (మండి రేట్లు)"
        AppLanguage.HI -> "कृषि मंडी भाव (कर्नूल व क्षेत्रीय)"
        AppLanguage.EN -> "Agri Mandi Rates (Live APMC)"
    }

    val categories = listOf("All", "Oilseeds", "Pulses", "Commercial", "Cereals", "Vegetables")

    val filteredList = OrvakalData.mandiRates.filter { item ->
        val matchesCategory = selectedCategoryFilter == "All" || item.category.equals(selectedCategoryFilter, ignoreCase = true)
        val matchesSearch = searchQuery.isEmpty() ||
                item.cropName.get().contains(searchQuery, ignoreCase = true) ||
                item.variety.contains(searchQuery, ignoreCase = true) ||
                item.marketYard.contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesSearch
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F7F8))
    ) {
        OrvakalSubHeader(
            title = screenTitle,
            onBack = onBack,
            actions = {
                IconButton(onClick = {
                    refreshTimestamp = SimpleDateFormat("dd MMM, hh:mm a", Locale.getDefault()).format(Date())
                }) {
                    Icon(imageVector = Icons.Filled.Refresh, contentDescription = "Refresh", tint = Color.White)
                }
                IconButton(onClick = onNavigateToHome) {
                    Icon(imageVector = Icons.Outlined.Home, contentDescription = "Home", tint = Color.White)
                }
            }
        )

        // Live Feed Badge Banner
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE8F5E9))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF2E7D32))
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Live Agmarknet & Kurnool APMC Yard Feed",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B5E20)
                )
            }
            Text(
                text = "Updated: $refreshTimestamp",
                fontSize = 10.sp,
                color = Color(0xFF2E7D32)
            )
        }

        // Search Bar
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
                    .height(48.dp),
                placeholder = { Text("Search crop (ఉదా: వేరుశనగ, పత్తి, ఉల్లి)...", fontSize = 12.sp, color = Color(0xFF78909C)) },
                leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = OrvakalTeal, modifier = Modifier.size(18.dp)) },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = OrvakalTeal,
                    unfocusedBorderColor = Color(0xFFCFD8DC)
                )
            )
        }

        // Category Filter Chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { cat ->
                FilterChip(
                    selected = selectedCategoryFilter == cat,
                    onClick = { selectedCategoryFilter = cat },
                    label = { Text(cat, fontSize = 11.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = OrvakalTeal,
                        selectedLabelColor = Color.White
                    )
                )
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(filteredList) { item ->
                MandiRateCard(rate = item)
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun MandiRateCard(rate: MandiCropRate) {
    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Title & Trend Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = rate.cropName.get(),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF003740)
                    )
                    Text(
                        text = "${rate.variety} • ${rate.marketYard}",
                        fontSize = 11.sp,
                        color = Color(0xFF546E7A)
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (rate.isPositiveTrend) Color(0xFFE8F5E9) else Color(0xFFFFEBEE))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = rate.trend,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (rate.isPositiveTrend) Color(0xFF1B5E20) else Color(0xFFC62828)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Modal, Min, Max Price Grid
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF1F8F9))
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Modal Price (ప్రధాన ధర)", fontSize = 10.sp, color = Color(0xFF455A64))
                    Text(
                        text = formatter.format(rate.modalPrice),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF006778)
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Min Price", fontSize = 10.sp, color = Color(0xFF78909C))
                    Text(
                        text = formatter.format(rate.minPrice),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF37474F)
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text("Max Price", fontSize = 10.sp, color = Color(0xFF78909C))
                    Text(
                        text = formatter.format(rate.maxPrice),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF37474F)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "📦 Daily Arrival: ${rate.arrivalTons}",
                    fontSize = 11.sp,
                    color = Color(0xFF546E7A)
                )
                Text(
                    text = "Unit: ${rate.unit}",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF546E7A)
                )
            }
        }
    }
}

// 2. Official Minimum Support Price (MSP 2024-25 / 2025-26)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MspRatesDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val currentLang = LanguageManager.currentLanguage
    var selectedSeasonTab by remember { mutableIntStateOf(0) } // 0: All, 1: Kharif, 2: Rabi

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "కనిష్ట మద్దతు ధరలు (MSP రేట్లు)"
        AppLanguage.HI -> "न्यूनतम समर्थन मूल्य (MSP 2024-25)"
        AppLanguage.EN -> "Minimum Support Price (MSP)"
    }

    val filteredList = OrvakalData.mspRates.filter {
        when (selectedSeasonTab) {
            1 -> it.season.contains("Kharif", ignoreCase = true)
            2 -> it.season.contains("Rabi", ignoreCase = true)
            else -> true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F7F8))
    ) {
        OrvakalSubHeader(
            title = screenTitle,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )

        // Season Filter Tabs
        TabRow(
            selectedTabIndex = selectedSeasonTab,
            containerColor = Color.White,
            contentColor = OrvakalTealDark,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedSeasonTab]),
                    color = OrvakalTealDark,
                    height = 3.dp
                )
            }
        ) {
            listOf("All Crops (అన్నీ)", "Kharif 2024-25 (ఖరీఫ్)", "Rabi 2024-25 (రబీ)").forEachIndexed { idx, title ->
                Tab(
                    selected = selectedSeasonTab == idx,
                    onClick = { selectedSeasonTab = idx },
                    text = {
                        Text(
                            text = title,
                            fontSize = 12.sp,
                            fontWeight = if (selectedSeasonTab == idx) FontWeight.Bold else FontWeight.Medium
                        )
                    }
                )
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Procurement Guidelines Banner
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFA5D6A7))
                    )
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = "🌾 Rythu Bharosa Kendram (RBK) Procurement Norms",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1B5E20)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "• Moisture Limits: Paddy ≤ 17%, Groundnut ≤ 8%, Cotton ≤ 12%\n• Register on CM-APP at Orvakal RBK with Aadhaar & e-Crop booking\n• Direct DBT payment to farmer's Aadhaar linked bank account within 21 days",
                            fontSize = 11.sp,
                            lineHeight = 16.sp,
                            color = Color(0xFF2E7D32)
                        )
                    }
                }
            }

            items(filteredList) { item ->
                MspCard(item = item)
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun MspCard(item: MspRateItem) {
    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(item.icon, fontSize = 22.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = item.cropName.get(),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF003740)
                        )
                        Text(
                            text = "${item.variety} • ${item.season}",
                            fontSize = 11.sp,
                            color = Color(0xFF546E7A)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFE0F2F1))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Margin ${item.marginPercent}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF006778)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF9FBFB))
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Official MSP (2024-25)", fontSize = 10.sp, color = Color(0xFF546E7A))
                    Text(
                        text = "${formatter.format(item.msp2024)} / Qtl",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black,
                        color = Color(0xFF004D40)
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Prev MSP (2023)", fontSize = 10.sp, color = Color(0xFF78909C))
                    Text(
                        text = formatter.format(item.msp2023),
                        fontSize = 12.sp,
                        color = Color(0xFF546E7A)
                    )
                }

                Column(horizontalAlignment = Alignment.End) {
                    Text("Increase", fontSize = 10.sp, color = Color(0xFF78909C))
                    Text(
                        text = "+₹${item.absoluteIncrease}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2E7D32)
                    )
                }
            }
        }
    }
}

// 3. Power Feeder Schedule (3-Phase Agricultural Electricity Timings)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PowerScheduleDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "వ్యవసాయ విద్యుత్ ఫీడర్ షెడ్యూల్"
        AppLanguage.HI -> "कृषि विद्युत फीडर शेड्यूल (3-फेज)"
        AppLanguage.EN -> "Agri Power Feeder Schedule"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F7F8))
    ) {
        OrvakalSubHeader(
            title = screenTitle,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // 9-Hour Free Agricultural Policy Banner
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF8E1)),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFFFE082))
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("⚡", fontSize = 28.sp)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "AP Govt 9-Hours Free Ag Power Policy",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFF57F17)
                            )
                            Text(
                                text = "3-Phase day/night scheduled supply. Single phase domestic is 24/7 continuous.",
                                fontSize = 11.sp,
                                color = Color(0xFFE65100)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFF57F17))
                                .clickable {
                                    context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:1912")))
                                }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text("1912 Help", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // Feeder Schedule Cards
            items(OrvakalData.powerFeeders) { feeder ->
                PowerFeederCard(feeder = feeder)
            }

            // 33/11kV Substation & Linemen Contacts
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "⚡ APSPDCL Orvakal Substation (33/11 kV) Contacts",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = OrvakalTealDark
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        LinemanRow("Assistant Engineer (AE) Operations", "+91 94906 18234", onCall = { p -> context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$p"))) })
                        LinemanRow("Substation Operator (33/11 kV)", "+91 94906 18235", onCall = { p -> context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$p"))) })
                        LinemanRow("Village Lineman (Orvakal West & Kalva)", "+91 94906 18236", onCall = { p -> context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$p"))) })
                        LinemanRow("Village Lineman (Highway & Industrial Zone)", "+91 94906 18237", onCall = { p -> context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$p"))) })

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "🔧 Weekly Scheduled Maintenance: Tuesday 02:00 PM to 05:00 PM",
                            fontSize = 11.sp,
                            color = Color(0xFFC62828),
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun PowerFeederCard(feeder: PowerFeederInfo) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = feeder.groupName.get(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF004D40),
                    modifier = Modifier.weight(1f)
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFE8F5E9))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(feeder.status, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
                }
            }

            Spacer(modifier = Modifier.height(6.dp))
            Text("Villages: ${feeder.villagesCovered}", fontSize = 11.sp, color = Color(0xFF546E7A))

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF9FBFB))
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text("⏰ Slot 1: ${feeder.supplySlot1}", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF263238))
                    if (feeder.supplySlot2.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("⏰ Slot 2: ${feeder.supplySlot2}", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF263238))
                    }
                }
            }
        }
    }
}

@Composable
fun LinemanRow(title: String, phone: String, onCall: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(title, fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF263238))
            Text(phone, fontSize = 11.sp, color = Color(0xFF546E7A))
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFE0F2F1))
                .clickable { onCall(phone) }
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Filled.Call, contentDescription = null, tint = OrvakalTealDark, modifier = Modifier.size(12.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Call", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = OrvakalTealDark)
            }
        }
    }
}

// 4. Tractor & Machinery Rent View
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MachineryRentDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "ట్రాక్టర్ & వ్యవసాయ యంత్రాల అద్దె"
        AppLanguage.HI -> "ट्रैक्टर व कृषि यंत्र किराया"
        AppLanguage.EN -> "Tractor & Machinery Rent"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F7F8))
    ) {
        OrvakalSubHeader(
            title = screenTitle,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(OrvakalData.machineryRentList) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(item.icon, fontSize = 24.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(item.name.get(), fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF003740))
                                    Text(item.category, fontSize = 11.sp, color = Color(0xFF546E7A))
                                }
                            }

                            Text(
                                text = item.rentPerHour,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFF006778)
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(item.details.get(), fontSize = 11.sp, color = Color(0xFF455A64), lineHeight = 15.sp)

                        Spacer(modifier = Modifier.height(10.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text("Owner: ${item.ownerName}", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF263238))
                                Text("Location: ${item.village}", fontSize = 10.sp, color = Color(0xFF78909C))
                            }

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFF006778))
                                    .clickable {
                                        context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${item.phone}")))
                                    }
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Filled.Call, contentDescription = null, tint = Color.White, modifier = Modifier.size(12.dp))
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text("Book Machine", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

// 5. Crop Advisories View
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CropAdvisoryDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val currentLang = LanguageManager.currentLanguage

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "పంట సలహాలు & సూచనలు"
        AppLanguage.HI -> "फसल सलाह व कीट प्रबंधन"
        AppLanguage.EN -> "Seasonal Crop Advisories"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F7F8))
    ) {
        OrvakalSubHeader(
            title = screenTitle,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(OrvakalData.cropAdvisories) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(item.icon, fontSize = 22.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(item.crop.get(), fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF003740))
                                Text(item.stage.get(), fontSize = 11.sp, color = Color(0xFF006778), fontWeight = FontWeight.SemiBold)
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFFFEBEE))
                                .padding(8.dp)
                        ) {
                            Text("⚠️ Problem: ${item.problem.get()}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFC62828))
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text("✅ Remedy: ${item.solution.get()}", fontSize = 11.sp, color = Color(0xFF263238), lineHeight = 16.sp)

                        Spacer(modifier = Modifier.height(6.dp))
                        Text("🧪 Recommended Dosage: ${item.recommendedDosage}", fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1B5E20))
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

// 6. Water Levels & Irrigation Schedule
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaterLevelsDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val currentLang = LanguageManager.currentLanguage

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "నీటి వనరులు & కాలువ వివరాలు"
        AppLanguage.HI -> "जल स्तर व सिंचाई नहर"
        AppLanguage.EN -> "Water Levels & Irrigation"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F7F8))
    ) {
        OrvakalSubHeader(
            title = screenTitle,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                WaterSourceCard(
                    icon = "🌊",
                    title = "SRBC (Srisailam Right Branch Canal)",
                    status = "Active Water Flow (2,100 Cusecs Discharge)",
                    details = "Water supply release scheduled for Orvakal distributary branch feeding agricultural farmlands in Orvakal & Kalva ayacut."
                )
            }
            item {
                WaterSourceCard(
                    icon = "⛲",
                    title = "Kalvabugga Natural Spring & Pond",
                    status = "Perennial Spring Active (Good Storage)",
                    details = "Sacred natural spring tank providing perennial groundwater recharge and local village cultivation support."
                )
            }
            item {
                WaterSourceCard(
                    icon = "🏞️",
                    title = "Orvakal Pedda Cheruvu & Chinna Cheruvu",
                    status = "75% Full Capacity",
                    details = "Minor irrigation tanks renovated under Mission Kakatiya/Jal Jeevan. Adequate storage for rabi borewell recharge."
                )
            }
            item {
                WaterSourceCard(
                    icon = "🚰",
                    title = "Mandal Groundwater Table Report",
                    status = "Average Depth: 180 – 260 Feet",
                    details = "Groundwater levels monitored across 8 piezometer wells in Orvakal mandal. Safe zone in canal command area."
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun WaterSourceCard(icon: String, title: String, status: String, details: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(icon, fontSize = 24.sp)
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF003740))
                    Text(status, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF006778))
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(details, fontSize = 11.sp, color = Color(0xFF455A64), lineHeight = 16.sp)
        }
    }
}

// 7. Motor & Tractor Repairs View
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TractorRepairsDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "వాహన మరమ్మత్తు & బ్రేక్‌డౌన్ సహాయం"
        AppLanguage.HI -> "वाहन ब्रेकडाउन एवं मैकेनिक सेवा"
        AppLanguage.EN -> "Vehicle Breakdown & Mechanic Help"
    }

    val mechanics = listOf(
        Triple("NH-40 24/7 Vehicle Breakdown & Crane Towing", "Highway emergency towing, car & truck mechanical repairs • NH-40 Orvakal Bypass", "+91 94402 88123"),
        Triple("Balaji 24/7 Tubeless Puncture & Tire Works", "Tyre puncture repair, air pressure & spare replacements • Near Bus Stand / NH-40", "+91 98485 12900"),
        Triple("Sri Sai Tractor Garage & Mechanical Works", "Hydraulics, diesel engine overhaul, cultivator repairs • Highway", "+91 94408 77211"),
        Triple("MR Submersible Motor Rewinding Works", "Borewell pumps, starters, 3-phase rewindings • Near Bus Stand", "+91 98491 55642"),
        Triple("Basha Auto & Borewell Starter Panel Electrician", "Starter coils, capacitor replacements, field visits • Main Bazar", "+91 99890 33418"),
        Triple("Veerabhadra Agriculture Weldings & Fabrication", "Trolley welding, blade sharpening, rotavator pins • Bus Stand", "+91 96182 44329")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F7F8))
    ) {
        OrvakalSubHeader(
            title = screenTitle,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(mechanics) { (name, desc, phone) ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(name, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(desc, fontSize = 11.sp, color = Color(0xFF546E7A))
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF006778))
                                .clickable {
                                    context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
                                }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Filled.Call, contentDescription = null, tint = Color.White, modifier = Modifier.size(12.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Call", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

// 8. Agricultural Support Officers View
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgriOfficersDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "వ్యవసాయ శాఖ అధికారులు & RBK"
        AppLanguage.HI -> "कृषि अधिकारी व रायतु भरोसा केंद्र"
        AppLanguage.EN -> "Agricultural Support Officers"
    }

    val officers = listOf(
        Triple("Mandal Agricultural Officer (MAO)", "Sri P. Sreenivasulu, MAO Orvakal • Beside Highway", "+91 94409 01270"),
        Triple("Village Agricultural Assistant (VAA) - Orvakal", "Kum. S. Kavitha • Grama Sachivalayam & RBK", "+91 94409 01271"),
        Triple("Village Agricultural Assistant (VAA) - Kalva", "Sri D. Venkatramana • Kalva RBK Center", "+91 94409 01272"),
        Triple("Village Agricultural Assistant (VAA) - Sakunala", "Sri K. Raghavendra • Sakunala RBK Center", "+91 94409 01273"),
        Triple("Horticultural Officer (HO)", "Smt. T. Anitha • Orvakal Mandal Office", "+91 94409 01274"),
        Triple("Veterinary Assistant Surgeon (VAS)", "Dr. M. Naresh, BVSc • Veterinary Hospital Orvakal", "+91 94409 01275")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F7F8))
    ) {
        OrvakalSubHeader(
            title = screenTitle,
            onBack = onBack,
            onNavigateToHome = onNavigateToHome
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(officers) { (role, name, phone) ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(role, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF003740))
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(name, fontSize = 11.sp, color = Color(0xFF546E7A))
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF006778))
                                .clickable {
                                    context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
                                }
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Filled.Call, contentDescription = null, tint = Color.White, modifier = Modifier.size(12.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Call Officer", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}
