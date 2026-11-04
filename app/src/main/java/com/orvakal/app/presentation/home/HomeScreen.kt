package com.orvakal.app.presentation.home

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.outlined.Campaign
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.AppStrings
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.presentation.common.OrvakalTopHeader
import com.orvakal.app.presentation.common.PrivacyPolicyDialog
import com.orvakal.app.presentation.theme.ThemeManager
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(
    onNavigateToCategory: (String) -> Unit,
    onNavigateToJobs: () -> Unit,
    onNavigateToFarmer: () -> Unit,
    onNavigateToGovt: () -> Unit,
    onNavigateToIndustrialHub: () -> Unit,
    onNavigateToUtilities: (Int) -> Unit,
    onNavigateToMandalProfile: () -> Unit
) {
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }
    var selectedPersonaKey by remember { mutableStateOf("farmer") }
    var showSosDialog by remember { mutableStateOf(false) }
    var showPrivacyPolicyDialog by remember { mutableStateOf(false) }
    var selectedScenicPlace by remember { mutableStateOf<ScenicPlace?>(null) }

    val currentTime = remember {
        val sdf = SimpleDateFormat("hh:mm a", Locale.getDefault())
        sdf.format(Date()).lowercase()
    }

    if (showPrivacyPolicyDialog) {
        PrivacyPolicyDialog(onDismiss = { showPrivacyPolicyDialog = false })
    }

    if (selectedScenicPlace != null) {
        ScenicPlaceDetailDialog(
            place = selectedScenicPlace!!,
            onDismiss = { selectedScenicPlace = null }
        )
    }

    if (showSosDialog) {
        EmergencySosDialog(
            onDismiss = { showSosDialog = false },
            onDial = { number ->
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                context.startActivity(intent)
            }
        )
    }

    val isDark = ThemeManager.isDarkMode

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDark) Color(0xFF121212) else Color(0xFFF3F7F8))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Search Bar
            item {
                Spacer(modifier = Modifier.height(2.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        placeholder = {
                            Text(
                                AppStrings.searchPlaceholder,
                                color = if (isDark) Color(0xFF9E9E9E) else Color(0xFF78909C),
                                fontSize = 14.sp
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search",
                                tint = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = if (isDark) Color(0xFF1E1E1E) else Color.White,
                            unfocusedContainerColor = if (isDark) Color(0xFF1E1E1E) else Color.White,
                            focusedTextColor = if (isDark) Color.White else Color(0xFF263238),
                            unfocusedTextColor = if (isDark) Color.White else Color(0xFF263238),
                            focusedBorderColor = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778),
                            unfocusedBorderColor = if (isDark) Color(0xFF424242) else Color(0xFFCFD8DC)
                        )
                    )
                }
            }

            // Emergency SOS Hotline Banner (Screenshot 3)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFD32F2F))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape)
                                    .background(Color.White.copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Shield,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = AppStrings.emergencySos,
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                fontSize = 13.sp,
                                letterSpacing = 0.5.sp
                            )
                        }

                        // GET HELP Pill Button
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White.copy(alpha = 0.25f))
                                .border(1.dp, Color.White.copy(alpha = 0.6f), RoundedCornerShape(20.dp))
                                .clickable { showSosDialog = true }
                                .padding(horizontal = 12.dp, vertical = 5.dp)
                        ) {
                            Text(
                                text = AppStrings.getHelp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }

            // Hero Card: Orvakal Industrial Hub & Weather (Screenshot 3)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1E1E) else Color(0xFFE4F4F3)
                    ),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(
                            if (isDark) Color(0xFF004D40) else Color(0xFFB2DFDB)
                        )
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        // Title row: Full-width ORVAKAL button with integrated LIVE badge
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    brush = androidx.compose.ui.graphics.Brush.horizontalGradient(
                                        listOf(Color(0xFF004D5A), Color(0xFF006778))
                                    )
                                )
                                .border(1.5.dp, Color(0xFF80CBC4), RoundedCornerShape(12.dp))
                                .clickable { onNavigateToMandalProfile() }
                                .padding(horizontal = 14.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("🏛️", fontSize = 16.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = AppStrings.portalTitle,
                                            fontWeight = FontWeight.Black,
                                            fontSize = 14.sp,
                                            color = Color.White,
                                            letterSpacing = 1.sp
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text("↗", fontSize = 13.sp, color = Color(0xFF80CBC4), fontWeight = FontWeight.Bold)
                                    }
                                    Text(
                                        text = AppStrings.exploreMandalProfile,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = Color(0xFFB2DFDB)
                                    )
                                }
                            }

                            // Integrated LIVE badge
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color.White.copy(alpha = 0.2f))
                                    .border(1.dp, Color(0xFF80CBC4).copy(alpha = 0.6f), RoundedCornerShape(10.dp))
                                    .padding(horizontal = 9.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(6.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF00E676))
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = AppStrings.liveBadge,
                                    color = Color.White,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = AppStrings.bannerDesc,
                            fontSize = 12.sp,
                            lineHeight = 17.sp,
                            color = if (isDark) Color(0xFFE0E0E0) else Color(0xFF37474F)
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                        // Badges Row
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            val currentLang = LanguageManager.currentLanguage
                            val villagesCountText = when (currentLang) {
                                AppLanguage.TE -> "23 గ్రామాలు"
                                AppLanguage.HI -> "23 गांव"
                                AppLanguage.EN -> "23 Villages"
                            }
                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(if (isDark) Color(0xFF1B3820) else Color(0xFFD4EDDA))
                                    .border(1.dp, Color(0xFF28A745).copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                                    .clickable { onNavigateToMandalProfile() }
                                    .padding(horizontal = 10.dp, vertical = 5.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(7.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF28A745))
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "${AppStrings.activePanchayat} ($villagesCountText) ↗",
                                    color = if (isDark) Color(0xFFA5D6A7) else Color(0xFF155724),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(if (isDark) Color(0xFF3E3214) else Color(0xFFFFF3CD))
                                    .padding(horizontal = 9.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("✈️", fontSize = 11.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = AppStrings.airportKjb,
                                    color = if (isDark) Color(0xFFFFE082) else Color(0xFF856404),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Inner Weather Card (Screenshot 3)
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isDark) Color(0xFF282828) else Color.White
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 14.dp, vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Temperature
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("⛅", fontSize = 24.sp)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = "33°C",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isDark) Color.White else Color(0xFF263238)
                                        )
                                        Text(
                                            text = AppStrings.overcast,
                                            fontSize = 11.sp,
                                            color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF78909C)
                                        )
                                    }
                                }

                                // Humidity / Wind
                                Column {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text("💧", fontSize = 10.sp)
                                        Spacer(modifier = Modifier.width(3.dp))
                                        Text(
                                            text = "47%",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF37474F)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text("🌬️", fontSize = 10.sp)
                                        Spacer(modifier = Modifier.width(3.dp))
                                        Text(
                                            text = "6 km/h",
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Medium,
                                            color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF37474F)
                                        )
                                    }
                                }

                                // Local Time
                                Column(horizontalAlignment = Alignment.End) {
                                    Text(
                                        text = currentTime,
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Black,
                                        color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                                    )
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = AppStrings.localTime,
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isDark) Color(0xFFB0BEC5) else Color(0xFF546E7A)
                                        )
                                        Text(" ⌵", fontSize = 10.sp, color = if (isDark) Color(0xFFB0BEC5) else Color(0xFF546E7A))
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Investor Zone Card -> Opens Orvakal Industrial Hub Insights Screen!
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onNavigateToIndustrialHub() },
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isDark) Color(0xFF2C2416) else Color(0xFFF9F5EB)
                            ),
                            border = CardDefaults.outlinedCardBorder().copy(
                                brush = androidx.compose.ui.graphics.SolidColor(
                                    if (isDark) Color(0xFF5D4037) else Color(0xFFE8DFD0)
                                )
                            )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp, vertical = 9.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("💡", fontSize = 18.sp)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = AppStrings.investorCardTitle,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isDark) Color(0xFFFFCC80) else Color(0xFF3E2723)
                                        )
                                        Text(
                                            text = AppStrings.investorZone,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Black,
                                            color = Color(0xFFE65100),
                                            letterSpacing = 0.5.sp
                                        )
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .size(28.dp)
                                        .clip(CircleShape)
                                        .background(if (isDark) Color(0xFF4E342E) else Color(0xFFF0E0C8)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowForward,
                                        contentDescription = null,
                                        tint = Color(0xFFE65100),
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Quick Recommendations & Links Card (Screenshot 3)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
                    )
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isDark) Color(0xFF004D40) else Color(0xFFE0F2F1)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("👥", fontSize = 16.sp)
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = AppStrings.quickRecTitle,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color.White else Color(0xFF263238)
                                )
                                Text(
                                    text = AppStrings.selectPersona,
                                    fontSize = 11.sp,
                                    color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF78909C)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        val currentLang = LanguageManager.currentLanguage

                        // Persona Filter Chips Row with stable keys in order: Farmer, Student, Visitor
                        val personas = listOf(
                            Triple("farmer", "🌾", AppStrings.personaFarmer),
                            Triple("student", "🎓", AppStrings.personaStudent),
                            Triple("visitor", "📖", AppStrings.personaVisitor)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            personas.forEach { (key, icon, name) ->
                                val isSelected = selectedPersonaKey == key
                                Row(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(20.dp))
                                        .background(
                                            if (isSelected) Color(0xFF006778) else (if (isDark) Color(0xFF2C2C2C) else Color(0xFFF0F4F6))
                                        )
                                        .clickable { selectedPersonaKey = key }
                                        .padding(horizontal = 14.dp, vertical = 7.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(icon, fontSize = 13.sp)
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(
                                        text = name,
                                        fontSize = 12.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isSelected) Color.White else (if (isDark) Color(0xFFE0E0E0) else Color(0xFF37474F))
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Distinct Quick Recommendations Tailored for Each Persona (Emergency SOS is ALWAYS #1)
                        val quickActions = when (selectedPersonaKey) {
                            "student" -> listOf(
                                QuickActionItem("🚨", if (currentLang == AppLanguage.TE) "స్టూడెంట్ హెల్ప్‌లైన్ SOS" else if (currentLang == AppLanguage.HI) "छात्र हेल्पलाइन SOS" else "Student Helpline SOS", Color(0xFFFFEBEE), Color(0xFFB71C1C)) { showSosDialog = true },
                                QuickActionItem("🏫", if (currentLang == AppLanguage.TE) "పాఠశాలలు & కళాశాలలు" else if (currentLang == AppLanguage.HI) "स्कूल एवं कॉलेज" else "Schools & Education", Color(0xFFE8F5E9), Color(0xFF1B5E20)) { onNavigateToCategory("schools") },
                                QuickActionItem("📚", if (currentLang == AppLanguage.TE) "ట్యూషన్ & కోచింగ్" else if (currentLang == AppLanguage.HI) "ट्यूशन एवं कोचिंग" else "Tuitions & Coaching", Color(0xFFE1F5FE), Color(0xFF0277BD)) { onNavigateToCategory("tuitions") },
                                QuickActionItem("💼", if (currentLang == AppLanguage.TE) "ఉద్యోగాలు & కెరీర్" else if (currentLang == AppLanguage.HI) "रोजगार एवं करियर" else "Jobs & Careers", Color(0xFFFFF9C4), Color(0xFFF57F17)) { onNavigateToJobs() },
                                QuickActionItem("📋", if (currentLang == AppLanguage.TE) "స్కాలర్‌షిప్‌లు & పథకాలు" else if (currentLang == AppLanguage.HI) "छात्रवृत्ति एवं योजनाएं" else "Scholarships & Schemes", Color(0xFFFFEBEE), Color(0xFFC2185B)) { onNavigateToCategory("govt_schemes") },
                                QuickActionItem("🚌", if (currentLang == AppLanguage.TE) "బస్సు & రవాణా సమయాలు" else if (currentLang == AppLanguage.HI) "बस एवं ट्रांजिट" else "Bus & Transit Hub", Color(0xFFE0F7FA), Color(0xFF006064)) { onNavigateToCategory("transport") },
                                QuickActionItem("⏱️", if (currentLang == AppLanguage.TE) "స్టడీ టైమర్ & వాచ్" else if (currentLang == AppLanguage.HI) "अध्ययन टाइमर" else "Study Timer & Tools", Color(0xFFEDE7F6), Color(0xFF4527A0)) { onNavigateToUtilities(6) },
                                QuickActionItem("📮", if (currentLang == AppLanguage.TE) "పోస్ట్ ఆఫీస్ & సర్టిఫికేట్లు" else if (currentLang == AppLanguage.HI) "डाकघर एवं प्रमाण पत्र" else "Post Office Services", Color(0xFFFCE4EC), Color(0xFFAD1457)) { onNavigateToCategory("post_office") }
                            )
                            "visitor" -> listOf(
                                QuickActionItem("🚨", if (currentLang == AppLanguage.TE) "పోలీస్ & సహాయం SOS" else if (currentLang == AppLanguage.HI) "पर्यटक पुलिस एवं हेल्पलाइन" else "Police & Helpdesk SOS", Color(0xFFFFEBEE), Color(0xFFB71C1C)) { showSosDialog = true },
                                QuickActionItem("🪨", if (currentLang == AppLanguage.TE) "రాక్ గార్డెన్ & టూరిజం" else if (currentLang == AppLanguage.HI) "रॉक गार्डन एवं पर्यटन" else "Rock Garden & Tourism", Color(0xFFE0F2F1), Color(0xFF004D40)) { onNavigateToCategory("hotels") },
                                QuickActionItem("✈️", if (currentLang == AppLanguage.TE) "కర్నూలు విమానాశ్రయం" else if (currentLang == AppLanguage.HI) "कुरनूल हवाई अड्डा" else "Airport & Transit KJB", Color(0xFFE1F5FE), Color(0xFF01579B)) { onNavigateToCategory("transport") },
                                QuickActionItem("🏨", AppStrings.hotelStays, Color(0xFFE3F2FD), Color(0xFF0D47A1)) { onNavigateToCategory("hotels") },
                                QuickActionItem("🍽️", if (currentLang == AppLanguage.TE) "రెస్టారెంట్లు & ధాబాలు" else if (currentLang == AppLanguage.HI) "रेस्तरां एवं ढाबा" else "Food & Highway Dhabas", Color(0xFFFFF3E0), Color(0xFFE65100)) { onNavigateToCategory("restaurants") },
                                QuickActionItem("🛕", if (currentLang == AppLanguage.TE) "చారిత్రక దేవాలయాలు" else if (currentLang == AppLanguage.HI) "ऐतिहासिक मंदिर" else "Historic Temples", Color(0xFFFFF8E1), Color(0xFFF57F17)) { onNavigateToCategory("temples") },
                                QuickActionItem("💡", if (currentLang == AppLanguage.TE) "పారిశ్రామిక హబ్ గైడ్" else if (currentLang == AppLanguage.HI) "औद्योगिक हब गाइड" else "Industrial Hub Tour", Color(0xFFF3E5F5), Color(0xFF6A1B9A)) { onNavigateToIndustrialHub() },
                                QuickActionItem("👥", AppStrings.villageCommittees, Color(0xFFEDE7F6), Color(0xFF4527A0)) { onNavigateToCategory("village_committees") }
                            )
                            else -> listOf( // "farmer"
                                QuickActionItem("🚨", AppStrings.emergency, Color(0xFFFFEBEE), Color(0xFFB71C1C)) { showSosDialog = true },
                                QuickActionItem("🌾", AppStrings.mandiRates, Color(0xFFE8F5E9), Color(0xFF1B5E20)) { onNavigateToCategory("mandi_rates") },
                                QuickActionItem("⚡", if (currentLang == AppLanguage.TE) "కరెంట్ ఫీడర్ షెడ్యూల్" else if (currentLang == AppLanguage.HI) "बिजली फीडर शेड्यूल" else "Power Feeder Schedule", Color(0xFFFFF3E0), Color(0xFFE65100)) { onNavigateToCategory("power_schedule") },
                                QuickActionItem("🏷️", if (currentLang == AppLanguage.TE) "కనీస మద్దతు ధర (MSP)" else if (currentLang == AppLanguage.HI) "न्यूनतम समर्थन मूल्य (MSP)" else "Minimum Support Price", Color(0xFFFFF8E1), Color(0xFFF57F17)) { onNavigateToCategory("msp_rates") },
                                QuickActionItem("🚜", if (currentLang == AppLanguage.TE) "ట్రాక్టర్ & హార్వెస్టర్ అద్దె" else if (currentLang == AppLanguage.HI) "ट्रैक्टर एवं मशीनरी किराया" else "Tractor Machinery Rent", Color(0xFFE0F2F1), Color(0xFF00695C)) { onNavigateToCategory("machinery_rent") },
                                QuickActionItem("💧", if (currentLang == AppLanguage.TE) "బోరుబావులు & నీటి మట్టాలు" else if (currentLang == AppLanguage.HI) "जल स्तर एवं बोरवेल" else "Water Levels & Borewells", Color(0xFFE1F5FE), Color(0xFF0277BD)) { onNavigateToCategory("water_levels") },
                                QuickActionItem("📋", if (currentLang == AppLanguage.TE) "రైతు భరోసా & పథకాలు" else if (currentLang == AppLanguage.HI) "किसान कल्याण योजनाएं" else "Rythu Bharosa & Schemes", Color(0xFFFFEBEE), Color(0xFFC2185B)) { onNavigateToCategory("govt_schemes") },
                                QuickActionItem("💰", AppStrings.interestCalc, Color(0xFFF3E5F5), Color(0xFF6A1B9A)) { onNavigateToUtilities(0) }
                            )
                        }

                        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            for (i in 0 until quickActions.size step 2) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    QuickActionCard(
                                        item = quickActions[i],
                                        modifier = Modifier.weight(1f)
                                    )
                                    if (i + 1 < quickActions.size) {
                                        QuickActionCard(
                                            item = quickActions[i + 1],
                                            modifier = Modifier.weight(1f)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 4 Dedicated Action Buttons under Quick Links:
            // Row 1: Panchayat Grievance Desk & Vehicle Breakdown Help
            // Row 2: Primary Health Center (PHC) & Medical Stores
            item {
                val currentLang = LanguageManager.currentLanguage
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // Row 1
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Button 1: Panchayat Grievance Desk
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onNavigateToCategory("grievance") },
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isDark) Color(0xFF162E2B) else Color(0xFFE0F2F1)
                            ),
                            border = CardDefaults.outlinedCardBorder().copy(
                                brush = androidx.compose.ui.graphics.SolidColor(
                                    if (isDark) Color(0xFF00695C) else Color(0xFF80CBC4)
                                )
                            )
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("📝", fontSize = 20.sp)
                                    Text("↗", fontSize = 14.sp, color = if (isDark) Color(0xFF80CBC4) else Color(0xFF00695C), fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = when (currentLang) {
                                        AppLanguage.TE -> "పంచాయతీ ఫిర్యాదుల డెస్క్"
                                        AppLanguage.HI -> "पंचायत शिकायत डेस्क"
                                        AppLanguage.EN -> "Panchayat Grievance Desk"
                                    },
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFF80CBC4) else Color(0xFF004D40)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = when (currentLang) {
                                        AppLanguage.TE -> "పౌర సమస్య నమోదు ↗"
                                        AppLanguage.HI -> "समस्या दर्ज करें ↗"
                                        AppLanguage.EN -> "File Civic Issue ↗"
                                    },
                                    fontSize = 10.sp,
                                    color = if (isDark) Color(0xFFA7FFEB) else Color(0xFF00695C)
                                )
                            }
                        }

                        // Button 2: Vehicle Breakdown Help
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onNavigateToCategory("breakdown") },
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isDark) Color(0xFF2E2215) else Color(0xFFFFF3E0)
                            ),
                            border = CardDefaults.outlinedCardBorder().copy(
                                brush = androidx.compose.ui.graphics.SolidColor(
                                    if (isDark) Color(0xFFBF360C) else Color(0xFFFFCC80)
                                )
                            )
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("🚗", fontSize = 20.sp)
                                    Text("↗", fontSize = 14.sp, color = if (isDark) Color(0xFFFFB74D) else Color(0xFFE65100), fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = when (currentLang) {
                                        AppLanguage.TE -> "వాహన బ్రేక్‌డౌన్ సహాయం"
                                        AppLanguage.HI -> "वाहन ब्रेकडाउन सहायता"
                                        AppLanguage.EN -> "Vehicle Breakdown Help"
                                    },
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFFFB74D) else Color(0xFFBF360C)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = when (currentLang) {
                                        AppLanguage.TE -> "NH-40 మెకానిక్ & టోయింగ్ ↗"
                                        AppLanguage.HI -> "हाईवे मैकेनिक एवं टोइंग ↗"
                                        AppLanguage.EN -> "NH-40 Mechanics & Towing ↗"
                                    },
                                    fontSize = 10.sp,
                                    color = if (isDark) Color(0xFFFFE082) else Color(0xFFE65100)
                                )
                            }
                        }
                    }

                    // Row 2: Primary Health Center (PHC) & Medical Stores
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        // Button 3: Primary Health Center (PHC)
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onNavigateToCategory("hospitals") },
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isDark) Color(0xFF172D1B) else Color(0xFFE8F5E9)
                            ),
                            border = CardDefaults.outlinedCardBorder().copy(
                                brush = androidx.compose.ui.graphics.SolidColor(
                                    if (isDark) Color(0xFF2E7D32) else Color(0xFFA5D6A7)
                                )
                            )
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("🏥", fontSize = 20.sp)
                                    Text("↗", fontSize = 14.sp, color = if (isDark) Color(0xFFA5D6A7) else Color(0xFF1B5E20), fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = AppStrings.phcTitle,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFA5D6A7) else Color(0xFF1B5E20)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = AppStrings.phcSubtitle,
                                    fontSize = 10.sp,
                                    color = if (isDark) Color(0xFFC8E6C9) else Color(0xFF2E7D32)
                                )
                            }
                        }

                        // Button 4: Medical Stores & Chemist
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onNavigateToCategory("medical_stores") },
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isDark) Color(0xFF2D1822) else Color(0xFFFCE4EC)
                            ),
                            border = CardDefaults.outlinedCardBorder().copy(
                                brush = androidx.compose.ui.graphics.SolidColor(
                                    if (isDark) Color(0xFFAD1457) else Color(0xFFF48FB1)
                                )
                            )
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("💊", fontSize = 20.sp)
                                    Text("↗", fontSize = 14.sp, color = if (isDark) Color(0xFFF48FB1) else Color(0xFFC2185B), fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = AppStrings.medicalStoresTitle,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFF48FB1) else Color(0xFF880E4F)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = AppStrings.medicalStoresSubtitle,
                                    fontSize = 10.sp,
                                    color = if (isDark) Color(0xFFF8BBD0) else Color(0xFFAD1457)
                                )
                            }
                        }
                    }
                }
            }

            // Daily Utilities Section (Screenshot 3 & Latest Screenshot)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
                    )
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isDark) Color(0xFF311B92) else Color(0xFFEDE7F6)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("🛠️", fontSize = 16.sp)
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = AppStrings.dailyUtilities,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color.White else Color(0xFF263238)
                                )
                                Text(
                                    text = AppStrings.handyTools,
                                    fontSize = 11.sp,
                                    color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF78909C)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        // Horizontal Scroll for 4 Handy Utility Cards (Interest Calc, Unit Conv, Timer, More Tools)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // 1. Interest Calc
                            DailyUtilityTile(
                                icon = "💰",
                                title = AppStrings.interestCalc,
                                bgColor = if (isDark) Color(0xFF2C2416) else Color(0xFFFFF9C4),
                                iconBg = if (isDark) Color(0xFF3E3214) else Color(0xFFFFF176),
                                textColor = if (isDark) Color(0xFFFFB74D) else Color(0xFFE65100),
                                onClick = { onNavigateToUtilities(0) }
                            )

                            // 2. Unit Conv
                            DailyUtilityTile(
                                icon = "📐",
                                title = AppStrings.unitConv,
                                bgColor = if (isDark) Color(0xFF132A30) else Color(0xFFE0F7FA),
                                iconBg = if (isDark) Color(0xFF1A3E47) else Color(0xFFB2EBF2),
                                textColor = if (isDark) Color(0xFF80DEEA) else Color(0xFF006064),
                                onClick = { onNavigateToUtilities(1) }
                            )

                            // 3. Stopwatch & Timer
                            DailyUtilityTile(
                                icon = "⏱️",
                                title = AppStrings.stopwatchTimer,
                                bgColor = if (isDark) Color(0xFF2E2514) else Color(0xFFFFF8E1),
                                iconBg = if (isDark) Color(0xFF3E3016) else Color(0xFFFFECB3),
                                textColor = if (isDark) Color(0xFFFFD54F) else Color(0xFFF57F17),
                                onClick = { onNavigateToUtilities(6) }
                            )

                            // 4. More Tools
                            DailyUtilityTile(
                                icon = "⚡",
                                title = AppStrings.moreTools,
                                bgColor = if (isDark) Color(0xFF251A30) else Color(0xFFF3E5F5),
                                iconBg = if (isDark) Color(0xFF35224A) else Color(0xFFE1BEE7),
                                textColor = if (isDark) Color(0xFFCE93D8) else Color(0xFF4A148C),
                                onClick = { onNavigateToUtilities(2) }
                            )
                        }
                    }
                }
            }

            // Notice Board Section (From Latest User Screenshot)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
                    )
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(28.dp)
                                        .clip(CircleShape)
                                        .background(if (isDark) Color(0xFF3E1515) else Color(0xFFFFEBEE)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("🔔", fontSize = 14.sp)
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = AppStrings.noticeBoard,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFFEF5350) else Color(0xFFC62828),
                                    letterSpacing = 0.5.sp
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(RoundedCornerShape(6.dp))
                                    .border(1.dp, if (isDark) Color(0xFF424242) else Color(0xFFCFD8DC), RoundedCornerShape(6.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Campaign,
                                    contentDescription = "Announce",
                                    tint = if (isDark) Color(0xFFB0BEC5) else Color(0xFF455A64),
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isDark) Color(0xFF262626) else Color(0xFFF5F9FA)
                            ),
                            border = CardDefaults.outlinedCardBorder().copy(
                                brush = androidx.compose.ui.graphics.SolidColor(
                                    if (isDark) Color(0xFF424242) else Color(0xFFCFD8DC)
                                )
                            )
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Jal Jeevan Mission & Gram Panchayat Water Supply Timings",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isDark) Color.White else Color(0xFF263238),
                                        modifier = Modifier.weight(1f)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(if (isDark) Color(0xFF37474F) else Color(0xFFECEFF1))
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                    ) {
                                        Text("Today", fontSize = 9.sp, color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF546E7A))
                                    }
                                }
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Morning: 06:00 AM – 08:30 AM | Evening: 05:00 PM – 07:00 PM across Main Bazar & Byreddynagar.",
                                    fontSize = 11.sp,
                                    color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF546E7A)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Scenic & Heritage Photo Gallery: Orvakal Rock Garden & Kethavaram Rock Formations
            item {
                ScenicHeritageGalleryCard(
                    onPlaceClick = { place ->
                        selectedScenicPlace = place
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Google Play Policy Compliance: Civic & Government Disclaimer Card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1E1E) else Color(0xFFF0F4F6)
                    ),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(
                            if (isDark) Color(0xFF424242) else Color(0xFFCFD8DC)
                        )
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(14.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("🏛️", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = AppStrings.civicDisclaimerTitle,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isDark) Color.White else Color(0xFF37474F)
                            )
                        }

                        Text(
                            text = AppStrings.civicDisclaimerBody,
                            fontSize = 11.sp,
                            color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF546E7A),
                            lineHeight = 15.sp
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isDark) Color(0xFF003844) else Color(0xFFE0F2F1))
                                .clickable { showPrivacyPolicyDialog = true }
                                .padding(horizontal = 10.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Filled.Shield,
                                    contentDescription = null,
                                    tint = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778),
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = AppStrings.viewPrivacyPolicy,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                                )
                            }
                            Text(
                                text = "View Details →",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun DailyUtilityTile(
    icon: String,
    title: String,
    bgColor: Color,
    iconBg: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(110.dp)
            .height(105.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(iconBg),
                contentAlignment = Alignment.Center
            ) {
                Text(icon, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = textColor,
                maxLines = 2,
                lineHeight = 14.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

data class QuickActionItem(
    val icon: String,
    val title: String,
    val bgColor: Color,
    val textColor: Color,
    val onClick: () -> Unit
)

@Composable
fun QuickActionCard(
    item: QuickActionItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(72.dp)
            .clickable { item.onClick() },
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = item.bgColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.icon,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = item.textColor
            )
        }
    }
}

@Composable
fun EmergencySosDialog(
    onDismiss: () -> Unit,
    onDial: (String) -> Unit = {}
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("🚨", fontSize = 22.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Emergency SOS Hotlines",
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFC62828)
                )
            }
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    "Orvakal Mandal Emergency Contacts (Tap to call):",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF37474F)
                )

                val contacts = listOf(
                    "Police Control Room" to "100",
                    "Orvakal Police Station" to "08518285233",
                    "Medical Ambulance" to "108",
                    "Government PHC Orvakal" to "08518285220",
                    "Fire & Disaster Services" to "101",
                    "Tahsildar / MRO Orvakal" to "08518285225",
                    "Electricity Feeder Breakdown" to "1912"
                )

                contacts.forEach { (label, number) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFF5F5F5))
                            .clickable { onDial(number) }
                            .padding(horizontal = 10.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(label, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                number,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF006778)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                imageVector = Icons.Filled.Phone,
                                contentDescription = null,
                                tint = Color(0xFF006778),
                                modifier = Modifier.size(14.dp)
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC62828))
            ) {
                Text("Close", color = Color.White)
            }
        }
    )
}

data class ScenicPlace(
    val id: String,
    val icon: String,
    val tagEn: String,
    val tagTe: String,
    val tagHi: String,
    val titleEn: String,
    val titleTe: String,
    val titleHi: String,
    val descEn: String,
    val descTe: String,
    val descHi: String,
    val distanceEn: String,
    val distanceTe: String,
    val distanceHi: String,
    val highlightsEn: String,
    val highlightsTe: String,
    val highlightsHi: String,
    val mapQuery: String,
    val cardGradient: List<Color>
)

@Composable
fun ScenicHeritageGalleryCard(
    onPlaceClick: (ScenicPlace) -> Unit
) {
    val currentLang = LanguageManager.currentLanguage

    val places = listOf(
        ScenicPlace(
            id = "rock_garden",
            icon = "🪨",
            tagEn = "Natural Wonder • 3-Billion-Yr Quartz",
            tagTe = "ప్రకృతి అద్భుతం • 300 కోట్ల ఏళ్ల నాటి శిలలు",
            tagHi = "प्राकृतिक आश्चर्य • 300 करोड़ वर्ष प्राचीन",
            titleEn = "Orvakal Rock Garden",
            titleTe = "ఓర్వకల్లు రాక్ గార్డెన్",
            titleHi = "ओरवाकल रॉक गार्डन",
            descEn = "World-famous natural silica & quartz rock formations, canyon lakes, boating, APTDC Haritha resort cottages & Baahubali movie shooting spot.",
            descTe = "కోట్ల సంవత్సరాల క్రితం ప్రకృతి సిద్ధంగా ఏర్పడిన క్వార్ట్జ్ మరియు సిలికా రాతి నిర్మాణాలు. లోయలు, బోటింగ్, APTDC హరిత రిసార్ట్ కాటేజీలు & ప్రసిద్ధ సినీ షూటింగ్ లొకేషన్.",
            descHi = "अरबों वर्षों के प्राकृतिक अपरदन से निर्मित विश्व प्रसिद्ध सिलिका एवं क्वार्ट्ज चट्टानें। नौकायन झील, एपीटीडीसी रिजॉर्ट एवं प्रसिद्ध फिल्म शूटिंग स्थल।",
            distanceEn = "NH-40 Highway • 3 km from Orvakal",
            distanceTe = "NH-40 హైవే • ఓర్వకల్లు నుండి 3 కి.మీ",
            distanceHi = "एनएच-40 हाईवे • ओरवाकल से 3 किमी",
            highlightsEn = "🌊 Boating Lake • 🏨 APTDC Resort Cottages • 🥾 Canyon Trails • 🎬 Film Shooting",
            highlightsTe = "🌊 బోటింగ్ చెరువు • 🏨 హరిత రిసార్ట్ • 🥾 రాతి లోయల నడక • 🎬 సినిమా షూటింగ్",
            highlightsHi = "🌊 नौकायन झील • 🏨 रिसॉर्ट कॉटेज • 🥾 घाटी मार्ग • 🎬 फिल्म शूटिंग स्थल",
            mapQuery = "Orvakal Rock Garden Kurnool Andhra Pradesh",
            cardGradient = listOf(Color(0xFF004D5A), Color(0xFF006778))
        ),
        ScenicPlace(
            id = "kethavaram",
            icon = "🎨",
            tagEn = "Prehistoric Rock Art • 10,000+ BC",
            tagTe = "పురాతన వారసత్వం • 10,000+ BC శైల చిత్రాలు",
            tagHi = "प्रागैतिहासिक धरोहर • 10,000+ ईसा पूर्व",
            titleEn = "Kethavaram Rock Formations",
            titleTe = "కేతవరం రాతి నిర్మాణాలు & చిత్రాలు",
            titleHi = "केतवरम प्राचीन शैल चित्र",
            descEn = "Prehistoric cave art made with red ochre depicting deer, bulls, hunting & tribal life from Paleolithic/Mesolithic eras. Major archaeological site.",
            descTe = "ప్రాచీన రాతి గుహలు మరియు ఎరుపు-తెలుపు రంగులతో గీసిన వేల ఏళ్ళ నాటి శైల చిత్రాలు. జింకలు, ఎద్దులు, వేట మరియు ప్రాచీన మానవ జీవన విధాన ప్రతిబింబం.",
            descHi = "प्राचीन शैल आश्रय जहां गेरू और प्राकृतिक रंगों से बने प्रागैतिहासिक हिरण, बैल एवं शिकार के शैल चित्र स्थित हैं। प्रमुख पुरातात्विक धरोहर।",
            distanceEn = "Near Kethavaram • 12 km from Orvakal",
            distanceTe = "కేతవరం వద్ద • ఓర్వకల్లు నుండి 12 కి.మీ",
            distanceHi = "केतवरम के पास • ओरवाकल से 12 किमी",
            highlightsEn = "🖌️ Red Ochre Art • 🦌 Prehistoric Wildlife • 🏺 10,000+ BC Cave Art • ⛰️ Natural Cliffs",
            highlightsTe = "🖌️ ఎర్రటి రంగుల చిత్రాలు • 🦌 ప్రాచీన వన్యప్రాణులు • 🏺 గుహా చిత్రాలు • ⛰️ సహజ శిలలు",
            highlightsHi = "🖌️ गेरू रंग शैल चित्र • 🦌 प्रागैतिहासिक वन्यजीव • 🏺 प्राचीन गुफाएं • ⛰️ प्राकृतिक शैल",
            mapQuery = "Kethavaram Rock Art Kurnool Andhra Pradesh",
            cardGradient = listOf(Color(0xFF4E342E), Color(0xFF6D4C41))
        ),
        ScenicPlace(
            id = "airport",
            icon = "✈️",
            tagEn = "Rayalaseema Aviation Gateway • KJB",
            tagTe = "విమానయాన కేంద్రం • KJB ఎయిర్‌పోర్ట్",
            tagHi = "विमानन हब • कुरनूल एयरपोर्ट KJB",
            titleEn = "Kurnool Airport - Orvakal",
            titleTe = "కర్నూలు ఎయిర్‌పోర్ట్ - ఓర్వకల్లు",
            titleHi = "कुरनूल हवाई अड्डा - ओरवाकल",
            descEn = "Modern Greenfield regional airport on NH-40 connecting Orvakal Industrial Hub directly to Bengaluru, Visakhapatnam and Chennai.",
            descTe = "ఓర్వకల్లు పారిశ్రామిక హబ్ పరిధిలోని ఆధునిక విమానాశ్రయం. బెంగళూరు మరియు విశాఖపట్నంకు నిరంతర విమాన సర్వీసులు.",
            descHi = "ओरवाकल औद्योगिक क्षेत्र में स्थित आधुनिक हवाई अड्डा। बेंगलुरु और विशाखापट्टनम के लिए नियमित उड़ानें उपलब्ध।",
            distanceEn = "NH-40 Bypass • 5 km from Orvakal",
            distanceTe = "NH-40 బైపాస్ • ఓర్వకల్లు నుండి 5 కి.మీ",
            distanceHi = "एनएच-40 बाईपास • ओरवाकल से 5 किमी",
            highlightsEn = "🛫 Daily Flights • 🏢 Modern Terminal • 🚗 NH-40 Direct Highway",
            highlightsTe = "🛫 రోజువారీ విమానాలు • 🏢 ప్యాసింజర్ టెర్మినల్ • 🚗 NH-40 హైవే అనుసంధానం",
            highlightsHi = "🛫 नियमित उड़ानें • 🏢 आधुनिक टर्मिनल • 🚗 एनएच-40 सीधा संपर्क",
            mapQuery = "Kurnool Airport Orvakal Andhra Pradesh",
            cardGradient = listOf(Color(0xFF0D47A1), Color(0xFF1976D2))
        ),
        ScenicPlace(
            id = "temples",
            icon = "🛕",
            tagEn = "Historic Heritage • Vijayanagara Era",
            tagTe = "ఆధ్యాత్మిక వారసత్వం • విజయనగర శైలి",
            tagHi = "धार्मिक धरोहर • विजयनगर काल",
            titleEn = "Historic Village Temples",
            titleTe = "చారిత్రక గ్రామ దేవాలయాలు",
            titleHi = "ऐतिहासिक ग्राम मंदिर",
            descEn = "Centuries-old stone temples of Sri Chennakesava Swamy, Sri Rama and Sri Nageswara with ancient stone carvings in Orvakal Main Bazar.",
            descTe = "ఓర్వకల్లు మెయిన్ బజార్‌లోని శతాబ్దాల నాటి శ్రీ చెన్నకేశవ, శ్రీ రామ మరియు శ్రీ నాగేశ్వర స్వామి పురాతన ఆలయాలు మరియు శిలా శిల్పాలు.",
            descHi = "ओरवाकल मुख्य बाजार में स्थित श्री चेन्नाकेशव, श्री राम एवं श्री नागेश्वर स्वामी के ऐतिहासिक प्राचीन मंदिर।",
            distanceEn = "Main Bazar • Orvakal Village",
            distanceTe = "మెయిన్ బజార్ • ఓర్వకల్లు గ్రామం",
            distanceHi = "मुख्य बाजार • ओरवाकल ग्राम",
            highlightsEn = "🛕 Stone Gopuram • 🔔 Daily Pujas & Archana • 🌺 Annual Rathotsavam",
            highlightsTe = "🛕 శిలా గోపురం • 🔔 నిత్య పూజలు • 🌺 వార్షిక రథోత్సవం",
            highlightsHi = "🛕 प्राचीन गोपुरम • 🔔 नित्य पूजा • 🌺 वार्षिक ब्रह्मोत्सव",
            mapQuery = "Sri Chennakesava Swamy Temple Orvakal Kurnool",
            cardGradient = listOf(Color(0xFFBF360C), Color(0xFFE65100))
        )
    )

    val isDark = ThemeManager.isDarkMode

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
        )
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isDark) Color(0xFF004D40) else Color(0xFFE0F2F1)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("📸", fontSize = 16.sp)
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = AppStrings.pictureGalleryTitle,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isDark) Color.White else Color(0xFF263238)
                    )
                    Text(
                        text = AppStrings.pictureGallerySubtitle,
                        fontSize = 11.sp,
                        color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF78909C)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Horizontal Scroll of Scenic Places Cards
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(places) { place ->
                    val title = when (currentLang) {
                        AppLanguage.TE -> place.titleTe
                        AppLanguage.HI -> place.titleHi
                        AppLanguage.EN -> place.titleEn
                    }
                    val tag = when (currentLang) {
                        AppLanguage.TE -> place.tagTe
                        AppLanguage.HI -> place.tagHi
                        AppLanguage.EN -> place.tagEn
                    }
                    val desc = when (currentLang) {
                        AppLanguage.TE -> place.descTe
                        AppLanguage.HI -> place.descHi
                        AppLanguage.EN -> place.descEn
                    }
                    val dist = when (currentLang) {
                        AppLanguage.TE -> place.distanceTe
                        AppLanguage.HI -> place.distanceHi
                        AppLanguage.EN -> place.distanceEn
                    }

                    Card(
                        modifier = Modifier
                            .width(260.dp)
                            .clickable { onPlaceClick(place) },
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isDark) Color(0xFF262626) else Color(0xFFF7FBFB)
                        ),
                        border = CardDefaults.outlinedCardBorder().copy(
                            brush = androidx.compose.ui.graphics.SolidColor(
                                if (isDark) Color(0xFF004D40) else Color(0xFFB2DFDB)
                            )
                        )
                    ) {
                        Column {
                            // Top banner with gradient and icon
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(90.dp)
                                    .background(
                                        brush = androidx.compose.ui.graphics.Brush.horizontalGradient(place.cardGradient)
                                    )
                                    .padding(10.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(38.dp)
                                            .clip(CircleShape)
                                            .background(Color.White.copy(alpha = 0.25f)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(place.icon, fontSize = 20.sp)
                                    }

                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(6.dp))
                                            .background(Color.Black.copy(alpha = 0.35f))
                                            .padding(horizontal = 7.dp, vertical = 3.dp)
                                    ) {
                                        Text(
                                            text = "ℹ️ View Details",
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }
                                }

                                Text(
                                    text = tag,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFE0F2F1),
                                    modifier = Modifier.align(Alignment.BottomStart)
                                )
                            }

                            // Card Body
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    text = title,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color.White else Color(0xFF263238)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = desc,
                                    fontSize = 11.sp,
                                    lineHeight = 15.sp,
                                    color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF546E7A),
                                    maxLines = 3
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "📍 $dist",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                                    )
                                    Text(
                                        text = "Maps ↗",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ScenicPlaceDetailDialog(
    place: ScenicPlace,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage

    val title = when (currentLang) {
        AppLanguage.TE -> place.titleTe
        AppLanguage.HI -> place.titleHi
        AppLanguage.EN -> place.titleEn
    }
    val tag = when (currentLang) {
        AppLanguage.TE -> place.tagTe
        AppLanguage.HI -> place.tagHi
        AppLanguage.EN -> place.tagEn
    }
    val desc = when (currentLang) {
        AppLanguage.TE -> place.descTe
        AppLanguage.HI -> place.descHi
        AppLanguage.EN -> place.descEn
    }
    val dist = when (currentLang) {
        AppLanguage.TE -> place.distanceTe
        AppLanguage.HI -> place.distanceHi
        AppLanguage.EN -> place.distanceEn
    }
    val highlights = when (currentLang) {
        AppLanguage.TE -> place.highlightsTe
        AppLanguage.HI -> place.highlightsHi
        AppLanguage.EN -> place.highlightsEn
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(place.icon, fontSize = 24.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = title,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF004D5A)
                        )
                        Text(
                            text = tag,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF006778)
                        )
                    }
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = desc,
                    fontSize = 12.sp,
                    lineHeight = 17.sp,
                    color = Color(0xFF37474F)
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2F1))
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(
                            text = "✨ Key Highlights:",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF004D40)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = highlights,
                            fontSize = 11.sp,
                            lineHeight = 15.sp,
                            color = Color(0xFF004D40)
                        )
                    }
                }

                Text(
                    text = "📍 $dist",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF546E7A)
                )
            }
        },
        confirmButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = {
                        val gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(place.mapQuery))
                        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                        mapIntent.setPackage("com.google.android.apps.maps")
                        try {
                            context.startActivity(mapIntent)
                        } catch (e: Exception) {
                            val browserIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://www.google.com/maps/search/?api=1&query=" + Uri.encode(place.mapQuery))
                            )
                            context.startActivity(browserIntent)
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006778))
                ) {
                    Text(AppStrings.openInMaps, color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = onDismiss,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCFD8DC))
                ) {
                    Text("Close", color = Color(0xFF263238), fontSize = 11.sp)
                }
            }
        },
        shape = RoundedCornerShape(18.dp),
        containerColor = Color.White
    )
}

