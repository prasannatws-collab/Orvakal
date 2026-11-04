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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Directions
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
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.orvakal.app.domain.model.TransportInfo
import com.orvakal.app.presentation.common.OrvakalSubHeader
import com.orvakal.app.presentation.common.OrvakalTeal
import com.orvakal.app.presentation.common.OrvakalTealDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransportHubDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage

    var selectedTypeFilter by remember { mutableStateOf("all") }

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "రవాణా సమాచారం (బస్సు, రైలు, విమానం)"
        AppLanguage.HI -> "परिवहन हब (बस, ट्रेन, हवाई अड्डा)"
        AppLanguage.EN -> "Transport Hub (Bus, Train, Airport)"
    }

    val typeFilters = listOf(
        "all" to (if (currentLang == AppLanguage.TE) "అన్నీ" else if (currentLang == AppLanguage.HI) "सभी" else "All"),
        "flight" to (if (currentLang == AppLanguage.TE) "✈️ విమానాశ్రయం (KJB)" else if (currentLang == AppLanguage.HI) "✈️ हवाई अड्डा" else "✈️ Airport KJB"),
        "bus" to (if (currentLang == AppLanguage.TE) "🚌 ఆర్టీసీ బస్టాండ్" else if (currentLang == AppLanguage.HI) "🚌 बस स्टैंड" else "🚌 APSRTC Buses"),
        "train" to (if (currentLang == AppLanguage.TE) "🚆 రైల్వే స్టేషన్లు" else if (currentLang == AppLanguage.HI) "🚆 रेलवे स्टेशन" else "🚆 Railways"),
        "auto" to (if (currentLang == AppLanguage.TE) "🛺 ఆటోలు & టాక్సీలు" else if (currentLang == AppLanguage.HI) "🛺 ऑटो व टैक्सी" else "🛺 Autos & Taxis")
    )

    val filteredList = OrvakalData.transportHub.filter {
        selectedTypeFilter == "all" || it.type.equals(selectedTypeFilter, ignoreCase = true)
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

        // Type filter chips
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            typeFilters.forEach { (typeKey, label) ->
                FilterChip(
                    selected = selectedTypeFilter == typeKey,
                    onClick = { selectedTypeFilter = typeKey },
                    label = { Text(label, fontSize = 12.sp) },
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
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(filteredList) { item ->
                TransportCard(
                    info = item,
                    onCall = { phone ->
                        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                        context.startActivity(dialIntent)
                    },
                    onShare = {
                        val shareIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(
                                Intent.EXTRA_TEXT,
                                "${item.title.get()}\n${item.subtitle.get()}\nLocation: ${item.location}\nDistance: ${item.distance}\nContact: ${item.contactPhone}\n\nVia Orvakal Village Portal"
                            )
                        }
                        context.startActivity(Intent.createChooser(shareIntent, "Share Transport Details"))
                    },
                    onMap = {
                        val gmmIntentUri = Uri.parse("geo:0,0?q=${Uri.encode("${item.title.get()} ${item.location}")}")
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        context.startActivity(mapIntent)
                    }
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun TransportCard(
    info: TransportInfo,
    onCall: (String) -> Unit,
    onShare: () -> Unit,
    onMap: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header Row: Icon, Title, Distance Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFE0F2F1)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(info.icon, fontSize = 24.sp)
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = info.title.get(),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF003740)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = info.subtitle.get(),
                        fontSize = 11.sp,
                        color = Color(0xFF006778),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Distance & Location Badges
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFEDE7F6))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text("📍 ${info.distance}", fontSize = 11.sp, color = Color(0xFF4A148C), fontWeight = FontWeight.SemiBold)
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFE8F5E9))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text("⏱️ ${info.timingsOrFrequency.get()}", fontSize = 11.sp, color = Color(0xFF1B5E20), fontWeight = FontWeight.Medium)
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Location Text
            Text(
                text = "Address: ${info.location}",
                fontSize = 12.sp,
                color = Color(0xFF455A64)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Key Routes
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF9FBFB))
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "Key Connections & Schedules:",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF37474F)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    info.keyRoutes.forEach { route ->
                        Text(
                            text = route,
                            fontSize = 11.sp,
                            lineHeight = 16.sp,
                            color = Color(0xFF263238),
                            modifier = Modifier.padding(vertical = 2.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = info.details.get(),
                fontSize = 11.sp,
                lineHeight = 15.sp,
                color = Color(0xFF78909C)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Action Buttons Row: Call, Direction, Share
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (info.contactPhone.isNotEmpty()) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF006778))
                            .clickable { onCall(info.contactPhone) }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(imageVector = Icons.Filled.Call, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Call (${info.contactPhone})", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFE0F2F1))
                        .clickable { onMap() }
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Filled.Directions, contentDescription = "Map", tint = Color(0xFF004D40), modifier = Modifier.size(16.dp))
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFECEFF1))
                        .clickable { onShare() }
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = "Share", tint = Color(0xFF37474F), modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}
