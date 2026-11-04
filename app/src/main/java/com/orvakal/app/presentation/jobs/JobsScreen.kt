package com.orvakal.app.presentation.jobs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BusinessCenter
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.data.local.OrvakalData
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.AppStrings
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.domain.model.Industry
import com.orvakal.app.presentation.common.OrvakalTopHeader
import com.orvakal.app.presentation.common.ScreenHeaderRow
import com.orvakal.app.presentation.theme.ThemeManager

@Composable
fun JobsScreen(
    onNavigateToHome: () -> Unit,
    onViewIndustryDetails: (Industry) -> Unit = {}
) {
    var selectedTab by remember { mutableIntStateOf(2) } // 0: Job Board, 1: Labour Registry, 2: Mega Industries
    var searchQuery by remember { mutableStateOf("") }

    val currentLang = LanguageManager.currentLanguage
    val isDark = ThemeManager.isDarkMode

    val tabs = listOf(AppStrings.tabJobBoard, AppStrings.tabLabourRegistry, AppStrings.tabMegaIndustries)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDark) Color(0xFF121212) else Color(0xFFF3F7F8))
    ) {
        // Screen title row: 💼 Jobs & Commerce | 🏠 Dashboard
        ScreenHeaderRow(
            title = AppStrings.jobsCommerceTitle,
            icon = "💼",
            onDashboardClick = onNavigateToHome
        )

        // Tabs Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            tabs.forEachIndexed { index, title ->
                val isSelected = selectedTab == index
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = index }
                        .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontSize = 13.5.sp,
                        fontWeight = if (isSelected) FontWeight.ExtraBold else FontWeight.SemiBold,
                        color = if (isSelected) {
                            if (isDark) Color(0xFFFFFFFF) else Color(0xFF003844)
                        } else {
                            if (isDark) Color(0xFFCBD5E1) else Color(0xFF475569)
                        }
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.9f)
                            .height(3.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(
                                if (isSelected) {
                                    if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                                } else {
                                    Color.Transparent
                                }
                            )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Search placeholder text
        val searchPlaceholder = when (currentLang) {
            AppLanguage.TE -> if (selectedTab == 2) "పరిశ్రమ లేదా రంగం శోధించండి..." else "ఉద్యోగాలు, నైపుణ్యాలు శోధించండి..."
            AppLanguage.HI -> if (selectedTab == 2) "उद्योग या क्षेत्र खोजें..." else "नौकरियां, कौशल खोजें..."
            else -> if (selectedTab == 2) "Search factory, sector, location..." else "Search jobs, skills, roles..."
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
                    .height(50.dp),
                placeholder = {
                    Text(
                        text = searchPlaceholder,
                        color = if (isDark) Color(0xFF78909C) else Color(0xFF78909C),
                        fontSize = 13.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778),
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
                    focusedBorderColor = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778),
                    unfocusedBorderColor = if (isDark) Color(0xFF424242) else Color(0xFFCFD8DC)
                )
            )
        }

        // Content
        when (selectedTab) {
            2 -> {
                // Mega Industries
                val filteredIndustries = OrvakalData.megaIndustries.filter {
                    it.name.contains(searchQuery, ignoreCase = true) ||
                            it.nameTe.contains(searchQuery, ignoreCase = true) ||
                            it.nameHi.contains(searchQuery, ignoreCase = true) ||
                            it.sector.contains(searchQuery, ignoreCase = true) ||
                            it.sectorTe.contains(searchQuery, ignoreCase = true) ||
                            it.sectorHi.contains(searchQuery, ignoreCase = true) ||
                            it.location.contains(searchQuery, ignoreCase = true) ||
                            it.locationTe.contains(searchQuery, ignoreCase = true) ||
                            it.locationHi.contains(searchQuery, ignoreCase = true)
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredIndustries) { industry ->
                        MegaIndustryCard(
                            industry = industry,
                            onViewDetails = { onViewIndustryDetails(industry) }
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
            0 -> {
                // Job Board
                JobBoardContent()
            }
            1 -> {
                // Labour Registry
                LabourRegistryContent()
            }
        }
    }
}

@Composable
fun MegaIndustryCard(
    industry: Industry,
    onViewDetails: () -> Unit
) {
    val isDark = ThemeManager.isDarkMode
    val currentLang = LanguageManager.currentLanguage

    val indName = industry.localizedName
    val indSector = industry.localizedSector
    val indLocation = industry.localizedLocation
    val indBadge = industry.localizedStatusBadge

    val sectorLabel = when (currentLang) {
        AppLanguage.TE -> "రంగం:"
        AppLanguage.HI -> "क्षेत्र:"
        else -> "Sector:"
    }
    val locationLabel = when (currentLang) {
        AppLanguage.TE -> "ప్రాంతం:"
        AppLanguage.HI -> "स्थान:"
        else -> "Location:"
    }
    val viewDetailsLabel = when (currentLang) {
        AppLanguage.TE -> "పరిశ్రమ వివరాలు & డెస్క్ చూడండి →"
        AppLanguage.HI -> "उद्योग विवरण व डेस्क देखें →"
        else -> "View Industry Desk Details →"
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
            // Header Row: Industry Name and Status Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = indName,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isDark) Color(0xFFECEFF1) else Color(0xFF212121),
                    modifier = Modifier.weight(1f)
                )

                // Status Badge (Pill)
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(if (isDark) Color(0xFF1B5E20) else Color(0xFFE8F5E9))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = indBadge,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isDark) Color(0xFFA5D6A7) else Color(0xFF2E7D32)
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Sector
            Text(
                text = "$sectorLabel $indSector",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Location
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "📍",
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "$locationLabel $indLocation",
                    fontSize = 12.sp,
                    color = if (isDark) Color(0xFFB0BEC5) else Color(0xFF546E7A)
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Action Button: View Industry Desk Details
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (isDark) Color(0xFF004D40) else Color(0xFFE0F2F1))
                    .border(
                        1.dp,
                        if (isDark) Color(0xFF00796B) else Color(0xFF80CBC4),
                        RoundedCornerShape(10.dp)
                    )
                    .clickable { onViewDetails() }
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.BusinessCenter,
                        contentDescription = null,
                        tint = if (isDark) Color(0xFFE0F2F1) else Color(0xFF004D40),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = viewDetailsLabel,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isDark) Color(0xFFE0F2F1) else Color(0xFF004D40)
                    )
                }
            }
        }
    }
}

private data class JobItem(
    val titleEn: String,
    val titleTe: String,
    val titleHi: String,
    val companyEn: String,
    val companyTe: String,
    val companyHi: String,
    val metaEn: String,
    val metaTe: String,
    val metaHi: String
)

@Composable
fun JobBoardContent() {
    val isDark = ThemeManager.isDarkMode
    val currentLang = LanguageManager.currentLanguage

    val jobs = listOf(
        JobItem(
            titleEn = "Solar Plant Maintenance Technician",
            titleTe = "సోలార్ ప్లాంట్ మెయింటెనెన్స్ టెక్నీషియన్",
            titleHi = "सोलर प्लांट मेंटेनेंस तकनीशियन",
            companyEn = "Greenco Solar Park (Pinnapuram)",
            companyTe = "గ్రీన్‌కో సోలార్ పార్క్ (పిన్నాపురం)",
            companyHi = "ग्रीनको सोलर पार्क (पिन्नापुरम)",
            metaEn = "Orvakal | Full-time | ₹18,000 - ₹25,000/mo",
            metaTe = "ఓర్వకల్లు | పూర్తి సమయం | ₹18,000 - ₹25,000/నెలకు",
            metaHi = "ओरवाकल | पूर्णकालिक | ₹18,000 - ₹25,000/माह"
        ),
        JobItem(
            titleEn = "Heavy Vehicle Operator / Driver",
            titleTe = "భారీ వాహన డ్రైవర్ / ఆపరేటర్",
            titleHi = "भारी वाहन ऑपरेटर / चालक",
            companyEn = "UltraTech Cement Plant",
            companyTe = "అల్ట్రాటెక్ సిమెంట్ ప్లాంట్",
            companyHi = "अल्ट्राटेक सीमेंट प्लांट",
            metaEn = "Budawada Road | Full-time | ₹20,000/mo",
            metaTe = "బుడవడ రోడ్డు | పూర్తి సమయం | ₹20,000/నెలకు",
            metaHi = "बुडवड़ा रोड | पूर्णकालिक | ₹20,000/माह"
        ),
        JobItem(
            titleEn = "Packaging & Silo Loading Helper",
            titleTe = "ప్యాకేజింగ్ & సైలో లోడింగ్ హెల్పర్",
            titleHi = "पैकेजिंग और साइलो लोडिंग हेल्पर",
            companyEn = "Ramco Cement Grinding Unit",
            companyTe = "రామ్కో సిమెంట్ గ్రైండింగ్ యూనిట్",
            companyHi = "रामको सीमेंट ग्राइंडिंग यूनिट",
            metaEn = "Nandyal Highway | ₹15,000/mo",
            metaTe = "నంద్యాల హైవే | ₹15,000/నెలకు",
            metaHi = "नंद्याल हाईवे | ₹15,000/माह"
        ),
        JobItem(
            titleEn = "Quality Control Chemist",
            titleTe = "క్వాలిటీ కంట్రోల్ కెమిస్ట్",
            titleHi = "क्वालिटी कंट्रोल केमिस्ट",
            companyEn = "Kurnool Mega Food Park",
            companyTe = "కర్నూలు మెగా ఫుడ్ పార్క్",
            companyHi = "कर्नूल मेगा फूड पार्क",
            metaEn = "APIIC Industrial Area | ₹22,000/mo",
            metaTe = "APIIC ఇండస్ట్రియల్ ఏరియా | ₹22,000/నెలకు",
            metaHi = "APIIC औद्योगिक क्षेत्र | ₹22,000/माह"
        ),
        JobItem(
            titleEn = "Substation Assistant Electrician",
            titleTe = "సబ్‌స్టేషన్ అసిస్టెంట్ ఎలక్ట్రీషియన్",
            titleHi = "सबस्टेशन सहायक इलेक्ट्रीशियन",
            companyEn = "Power Grid Corporation (765kV)",
            companyTe = "పవర్ గ్రిడ్ కార్పొరేషన్ (765kV)",
            companyHi = "पावर ग्रिड कॉर्पोरेशन (765kV)",
            metaEn = "Near Bus Stop | ₹19,000/mo",
            metaTe = "బస్టాండ్ దగ్గర | ₹19,000/నెలకు",
            metaHi = "बस स्टैंड के पास | ₹19,000/माह"
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(jobs) { job ->
            val title = when (currentLang) {
                AppLanguage.TE -> job.titleTe
                AppLanguage.HI -> job.titleHi
                else -> job.titleEn
            }
            val company = when (currentLang) {
                AppLanguage.TE -> job.companyTe
                AppLanguage.HI -> job.companyHi
                else -> job.companyEn
            }
            val meta = when (currentLang) {
                AppLanguage.TE -> job.metaTe
                AppLanguage.HI -> job.metaHi
                else -> job.metaEn
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
                )
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = if (isDark) Color(0xFFECEFF1) else Color(0xFF263238)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = company,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = meta,
                        fontSize = 11.sp,
                        color = if (isDark) Color(0xFF90A4AE) else Color(0xFF78909C)
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

private data class WorkerItem(
    val skillEn: String,
    val skillTe: String,
    val skillHi: String,
    val descEn: String,
    val descTe: String,
    val descHi: String,
    val expEn: String,
    val expTe: String,
    val expHi: String
)

@Composable
fun LabourRegistryContent() {
    val isDark = ThemeManager.isDarkMode
    val currentLang = LanguageManager.currentLanguage

    val workers = listOf(
        WorkerItem(
            skillEn = "Electrician & Motor Winding",
            skillTe = "ఎలక్ట్రీషియన్ & మోటార్ వైండింగ్",
            skillHi = "इलेक्ट्रीशियन और मोटर वाइंडिंग",
            descEn = "Available for industrial & domestic wiring, 3-phase motor repair",
            descTe = "పారిశ్రామిక & గృహ వైరింగ్, 3-ఫేజ్ మోటార్ల మరమ్మతు అందుబాటులో ఉంది",
            descHi = "औद्योगिक और घरेलू वायरिंग, 3-फेज मोटर मरम्मत के लिए उपलब्ध",
            expEn = "8 Years Exp | Orvakal Town",
            expTe = "8 సంవత్సరాల అనుభవం | ఓర్వకల్లు టౌన్",
            expHi = "8 साल का अनुभव | ओरवाकल टाउन"
        ),
        WorkerItem(
            skillEn = "Tractor & Harvester Driver",
            skillTe = "ట్రాక్టర్ & హార్వెస్టర్ డ్రైవర్",
            skillHi = "ट्रैक्टर और हार्वेस्टर चालक",
            descEn = "Licensed commercial driver for agricultural and transport work",
            descTe = "వ్యవసాయ పనులు మరియు రవాణా కోసం లైసెన్స్ పొందిన డ్రైవర్",
            descHi = "कृषि और परिवहन कार्य के लिए लाइसेंस प्राप्त ड्राइवर",
            expEn = "6 Years Exp | Kalva Route",
            expTe = "6 సంవత్సరాల అనుభవం | కాల్వ రోడ్డు",
            expHi = "6 साल का अनुभव | कालवा मार्ग"
        ),
        WorkerItem(
            skillEn = "Mason & Tile Fixing Specialist",
            skillTe = "తాపీ మేస్త్రి & టైల్స్ ఫిక్సింగ్ నిపుణుడు",
            skillHi = "राजमिस्त्री और टाइल फिटिंग विशेषज्ञ",
            descEn = "Commercial building construction, wall plastering & renovations",
            descTe = "వాణిజ్య భవనాల నిర్మాణం, ప్లాస్టరింగ్ మరియు టైల్స్ పనులు",
            descHi = "वाणिज्यिक भवन निर्माण, प्लास्टर और फर्श टाइल कार्य",
            expEn = "10 Years Exp | Main Bazar",
            expTe = "10 సంవత్సరాల అనుభవం | మెయిన్ బజార్",
            expHi = "10 साल का अनुभव | मेन बाज़ार"
        ),
        WorkerItem(
            skillEn = "Borewell & Plumbing Technician",
            skillTe = "బోర్‌వెల్ & ప్లంబింగ్ టెక్నీషియన్",
            skillHi = "बोरवेल और प्लंबर तकनीशियन",
            descEn = "Pipeline repairs, submersible pump installations, drip irrigation",
            descTe = "పైప్‌లైన్ రిపేర్లు, సబ్‌మెర్సిబుల్ పంపుల అమరిక, డ్రిప్ ఇరిగేషన్",
            descHi = "पाइपलाइन मरम्मत, सबमर्सिबल पंप इंस्टॉलेशन, ड्रिप सिंचाई",
            expEn = "5 Years Exp | Bus Stand Area",
            expTe = "5 సంవత్సరాల అనుభవం | బస్టాండ్ ప్రాంతం",
            expHi = "5 साल का अनुभव | बस स्टैंड क्षेत्र"
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(workers) { worker ->
            val skill = when (currentLang) {
                AppLanguage.TE -> worker.skillTe
                AppLanguage.HI -> worker.skillHi
                else -> worker.skillEn
            }
            val desc = when (currentLang) {
                AppLanguage.TE -> worker.descTe
                AppLanguage.HI -> worker.descHi
                else -> worker.descEn
            }
            val exp = when (currentLang) {
                AppLanguage.TE -> worker.expTe
                AppLanguage.HI -> worker.expHi
                else -> worker.expEn
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
                )
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = skill,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = if (isDark) Color(0xFFECEFF1) else Color(0xFF263238)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = desc,
                        fontSize = 12.sp,
                        color = if (isDark) Color(0xFFB0BEC5) else Color(0xFF455A64)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = exp,
                        fontSize = 11.sp,
                        color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
