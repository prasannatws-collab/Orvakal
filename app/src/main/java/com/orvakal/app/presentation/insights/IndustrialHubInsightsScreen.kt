package com.orvakal.app.presentation.insights

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Directions
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.presentation.common.OrvakalSubHeader
import com.orvakal.app.presentation.common.OrvakalTeal
import com.orvakal.app.presentation.common.OrvakalTealDark
import com.orvakal.app.presentation.theme.ThemeManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndustrialHubInsightsScreen(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage
    val isDark = ThemeManager.isDarkMode

    fun tr(en: String, te: String, hi: String): String = when (currentLang) {
        AppLanguage.TE -> te
        AppLanguage.HI -> hi
        else -> en
    }

    val screenTitle = tr(
        en = "Orvakal Industrial Hub Insights",
        te = "ఓర్వకల్లు పారిశ్రామిక హబ్ ముఖ్యాంశాలు",
        hi = "ओरवाकल औद्योगिक हब अंतर्दृष्टि"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDark) Color(0xFF121212) else Color(0xFFF3F7F8))
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
            // ══════════════════════════════════════════════════════════════════
            // HERO BANNER CARD
            // ══════════════════════════════════════════════════════════════════
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("🏭", fontSize = 24.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = tr(
                                            en = "Orvakal Mega Industrial Hub",
                                            te = "ఓర్వకల్లు మెగా పారిశ్రామిక హబ్",
                                            hi = "ओरवाकल मेगा औद्योगिक हब"
                                        ),
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark
                                    )
                                    Text(
                                        text = tr(
                                            en = "Hyderabad–Bengaluru Industrial Corridor (HBIC / NICDC)",
                                            te = "హైదరాబాద్-బెంగళూరు పారిశ్రామిక కారిడార్ (HBIC / NICDC)",
                                            hi = "हैदराबाद-बेंगलुरु औद्योगिक गलियारा (HBIC / NICDC)"
                                        ),
                                        fontSize = 11.sp,
                                        color = if (isDark) Color(0xFF4DB6AC) else Color(0xFF00796B),
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = tr(
                                en = "Orvakal is developed by APIIC & NICDC as Rayalaseema's premier multi-sector manufacturing and green industrial gateway, offering world-class plug-and-play infrastructure, airport connectivity, and dedicated utilities.",
                                te = "ఓర్వకల్లు APIIC & NICDC ద్వారా రాయలసీమలోనే అగ్రగామి బహుళ-రంగాల తయారీ మరియు గ్రీన్ పారిశ్రామిక ద్వారంగా అభివృద్ధి చేయబడుతోంది; ప్లగ్-అండ్-ప్లే మౌలిక వసతులు, విమానాశ్రయం మరియు నిరంతర విద్యుత్, నీటి సదుపాయాలు కలిగి ఉంది.",
                                hi = "ओरवाकल को एपीआईआईसी और एनआईसीडीसी द्वारा रायलसीमा के प्रमुख बहु-क्षेत्रीय विनिर्माण और हरित औद्योगिक प्रवेश द्वार के रूप में विकसित किया जा रहा है, जिसमें विश्व स्तरीय बुनियादी ढांचा, हवाई अड्डा और समर्पित सुविधाएं शामिल हैं।"
                            ),
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF455A64)
                        )
                    }
                }
            }

            // ══════════════════════════════════════════════════════════════════
            // TOPOLOGY & INTERNET MAP VISUAL CARD
            // ══════════════════════════════════════════════════════════════════
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("🗺️", fontSize = 18.sp)
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = tr(
                                        en = "Industrial Node Topology & Road Corridor",
                                        te = "పారిశ్రామిక నోడ్ టోపోలాజీ & రహదారి పటం",
                                        hi = "औद्योगिक नोड स्थलाकृति एवं सड़क गलियारा"
                                    ),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (isDark) Color(0xFF80CBC4) else Color(0xFF004D5A)
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(start = 24.dp)
                            ) {
                                Text(
                                    text = "📍 15.6888° N, 78.2144° E",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = if (isDark) Color(0xFF80DEEA) else Color(0xFF00796B)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "•  NH-40 Corridor",
                                    fontSize = 11.sp,
                                    color = if (isDark) Color(0xFFB0BEC5) else Color(0xFF546E7A)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        // Visual Master Topology Canvas Container (100% Offline HD Vector Layout)
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(230.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (isDark) Color(0xFF001F26) else Color(0xFF002730))
                                .border(1.dp, if (isDark) Color(0xFF004D40) else Color(0xFF004D5A), RoundedCornerShape(12.dp))
                        ) {

                            // Vector Topology Canvas of Orvakal Industrial Hub
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val w = size.width
                                val h = size.height

                                // Draw subtle layout grid lines
                                val gridStep = 28.dp.toPx()
                                for (x in 0..(w / gridStep).toInt()) {
                                    drawLine(
                                        color = Color(0xFF004D5A).copy(alpha = 0.35f),
                                        start = Offset(x * gridStep, 0f),
                                        end = Offset(x * gridStep, h),
                                        strokeWidth = 1f
                                    )
                                }
                                for (y in 0..(h / gridStep).toInt()) {
                                    drawLine(
                                        color = Color(0xFF004D5A).copy(alpha = 0.35f),
                                        start = Offset(0f, y * gridStep),
                                        end = Offset(w, y * gridStep),
                                        strokeWidth = 1f
                                    )
                                }

                                // Industrial Hub Core Node (2,621 Acres Boundary Polygon)
                                val hubZone = Path().apply {
                                    moveTo(w * 0.18f, h * 0.30f)
                                    lineTo(w * 0.65f, h * 0.22f)
                                    lineTo(w * 0.85f, h * 0.55f)
                                    lineTo(w * 0.70f, h * 0.82f)
                                    lineTo(w * 0.22f, h * 0.72f)
                                    close()
                                }
                                drawPath(hubZone, color = Color(0xFF00796B).copy(alpha = 0.28f))
                                drawPath(
                                    hubZone,
                                    color = Color(0xFF26A69A),
                                    style = Stroke(
                                        width = 2.dp.toPx(),
                                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 8f), 0f)
                                    )
                                )

                                // NH-40 4-Lane Industrial Highway Corridor
                                val nh40 = Path().apply {
                                    moveTo(0f, h * 0.20f)
                                    cubicTo(w * 0.30f, h * 0.35f, w * 0.60f, h * 0.55f, w, h * 0.75f)
                                }
                                drawPath(
                                    nh40,
                                    color = Color(0xFFFFA726),
                                    style = Stroke(width = 4.dp.toPx())
                                )

                                // Water Pipeline from Muchumarri (Blue Line)
                                val waterLine = Path().apply {
                                    moveTo(w * 0.10f, 0f)
                                    lineTo(w * 0.45f, h * 0.50f)
                                }
                                drawPath(
                                    waterLine,
                                    color = Color(0xFF29B6F6),
                                    style = Stroke(
                                        width = 2.dp.toPx(),
                                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 6f), 0f)
                                    )
                                )

                                // Key Hub Landmark Nodes
                                // 1. Airport Link
                                drawCircle(Color(0xFFE91E63), radius = 6.dp.toPx(), center = Offset(w * 0.82f, h * 0.28f))
                                // 2. Substation
                                drawCircle(Color(0xFFFFEB3B), radius = 5.dp.toPx(), center = Offset(w * 0.35f, h * 0.40f))
                                // 3. Solar Park (Pinnapuram)
                                drawCircle(Color(0xFF66BB6A), radius = 6.dp.toPx(), center = Offset(w * 0.72f, h * 0.70f))
                                // 4. Mega Food Park
                                drawCircle(Color(0xFF26C6DA), radius = 5.dp.toPx(), center = Offset(w * 0.48f, h * 0.60f))
                            }

                            // Overlay Labels
                            Box(modifier = Modifier.fillMaxSize().padding(10.dp)) {
                                // Airport Indicator
                                Row(
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(Color(0xCC002730))
                                        .padding(horizontal = 6.dp, vertical = 2.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("✈️", fontSize = 10.sp)
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text("Kurnool Airport (12 km)", color = Color(0xFFF8BBD0), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                }

                                // NH-40 Corridor
                                Text(
                                    text = "🛣️ NH-40 Corridor",
                                    color = Color(0xFFFFD54F),
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .align(Alignment.BottomStart)
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(Color(0xCC002730))
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                )

                                // Greenko Solar & Hydro Storage Zone
                                Row(
                                    modifier = Modifier
                                        .align(Alignment.BottomEnd)
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(Color(0xCC002730))
                                        .padding(horizontal = 6.dp, vertical = 2.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("☀️", fontSize = 10.sp)
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text("Pinnapuram Greenko (5,230 MW)", color = Color(0xFFA5D6A7), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                }

                                // Core Node Center Label
                                Column(
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(Color(0xDD003844))
                                        .border(1.dp, Color(0xFF26A69A), RoundedCornerShape(8.dp))
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "APIIC ORVAKAL INDUSTRIAL NODE",
                                        color = Color.White,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                    Text(
                                        text = "2,621 Acres Priority Phase",
                                        color = Color(0xFF80DEEA),
                                        fontSize = 8.5.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Interactive Map Action Buttons
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Google Maps Satellite View
                            Row(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isDark) Color(0xFF004D40) else Color(0xFFE0F2F1))
                                    .clickable {
                                        val mapIntent = Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("https://www.google.com/maps/search/?api=1&query=15.6888,78.2144")
                                        )
                                        context.startActivity(mapIntent)
                                    }
                                    .padding(vertical = 9.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Map,
                                    contentDescription = null,
                                    tint = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark,
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = tr(
                                        en = "Satellite Map ↗",
                                        te = "శాటిలైట్ మ్యాప్ ↗",
                                        hi = "सैटेलाइट मैप ↗"
                                    ),
                                    color = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            // GPS Directions
                            Row(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isDark) Color(0xFF004D40) else Color(0xFFE0F2F1))
                                    .clickable {
                                        val navIntent = Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse("google.navigation:q=15.6888,78.2144")
                                        )
                                        try {
                                            context.startActivity(navIntent)
                                        } catch (e: Exception) {
                                            val fallback = Intent(
                                                Intent.ACTION_VIEW,
                                                Uri.parse("https://www.google.com/maps/dir/?api=1&destination=15.6888,78.2144")
                                            )
                                            context.startActivity(fallback)
                                        }
                                    }
                                    .padding(vertical = 9.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Directions,
                                    contentDescription = null,
                                    tint = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark,
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = tr(
                                        en = "Directions ↗",
                                        te = "రూట్ మ్యాప్ ↗",
                                        hi = "दिशाएं ↗"
                                    ),
                                    color = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            // ══════════════════════════════════════════════════════════════════
            // KEY KPI GRID (4 CARDS)
            // ══════════════════════════════════════════════════════════════════
            item {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        HubKpiCard(
                            modifier = Modifier.weight(1f),
                            icon = "📐",
                            value = tr(en = "9,000+ Acres", te = "9,000+ ఎకరాలు", hi = "9,000+ एकड़"),
                            label = tr(en = "Acquired Land Bank", te = "సేకరించిన భూమి", hi = "अधिग्रहित भूमि बैंक"),
                            subLabel = tr(en = "2,621 Acres Core Node", te = "2,621 ఎకరాల కోర్ నోడ్", hi = "2,621 एकड़ मुख्य नोड"),
                            bg = if (isDark) Color(0xFF1E2D2B) else Color(0xFFE0F2F1)
                        )
                        HubKpiCard(
                            modifier = Modifier.weight(1f),
                            icon = "🏗️",
                            value = tr(en = "₹2,786 Cr", te = "₹2,786 కోట్లు", hi = "₹2,786 करोड़"),
                            label = tr(en = "Base Infrastructure", te = "మౌలిక సదుపాయాల వ్యయం", hi = "बुनियादी ढांचा परिव्यय"),
                            subLabel = tr(en = "Central & State Outlay", te = "కేంద్ర & రాష్ట్ర కేటాయింపులు", hi = "केंद्र व राज्य आवंटन"),
                            bg = if (isDark) Color(0xFF2E261A) else Color(0xFFFFF3E0)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        HubKpiCard(
                            modifier = Modifier.weight(1f),
                            icon = "💼",
                            value = tr(en = "₹50,000 Cr+", te = "₹50,000 కోట్లు+", hi = "₹50,000 करोड़+"),
                            label = tr(en = "Investment Target", te = "లక్ష్య పెట్టుబడులు", hi = "निवेश लक्ष्य"),
                            subLabel = tr(en = "Solar, EV, Pharma & Steel", te = "సోలార్, ఈవీ, ఫార్మా & స్టీల్", hi = "सोलर, ईवी, फार्मा व स्टील"),
                            bg = if (isDark) Color(0xFF1B2E1F) else Color(0xFFE8F5E9)
                        )
                        HubKpiCard(
                            modifier = Modifier.weight(1f),
                            icon = "👥",
                            value = tr(en = "45,000+", te = "45,000+", hi = "45,000+"),
                            label = tr(en = "Employment Potential", te = "ఉద్యోగ అవకాశాలు", hi = "रोजगार क्षमता"),
                            subLabel = tr(en = "Direct & Indirect Jobs", te = "ప్రత్యక్ష & పరోక్ష ఉపాధి", hi = "प्रत्यक्ष व अप्रत्यक्ष रोजगार"),
                            bg = if (isDark) Color(0xFF261D33) else Color(0xFFEDE7F6)
                        )
                    }
                }
            }

            // ══════════════════════════════════════════════════════════════════
            // STRATEGIC MULTI-MODAL CONNECTIVITY
            // ══════════════════════════════════════════════════════════════════
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = tr(
                                en = "🌐 Strategic Multi-Modal Connectivity",
                                te = "🌐 వ్యూహాత్మక మల్టీ-మోడల్ రవాణా అనుసంధానం",
                                hi = "🌐 रणनीतिक मल्टी-मॉडल कनेक्टिविटी"
                            ),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        ConnectivityRow(
                            icon = "✈️",
                            title = tr(
                                en = "Kurnool Airport (Oravakallu - KJB)",
                                te = "కర్నూలు విమానాశ్రయం (ఓర్వకల్లు - KJB)",
                                hi = "कर्नूल हवाई अड्डा (ओरवाकल - KJB)"
                            ),
                            desc = tr(
                                en = "Just 12 km from industrial node. Commercial flight routes to Bengaluru, Chennai, Visakhapatnam.",
                                te = "పారిశ్రామిక నోడ్ నుండి కేవలం 12 కి.మీ. బెంగళూరు, చెన్నై, విశాఖపట్నాలకు విమాన సర్వీసులు.",
                                hi = "औद्योगिक नोड से केवल 12 किमी। बेंगलुरु, चेन्नई और विशाखापत्तनम के लिए वाणिज्यिक उड़ानें।"
                            )
                        )
                        ConnectivityRow(
                            icon = "🛣️",
                            title = tr(
                                en = "Expressways & National Highways",
                                te = "ఎక్స్‌ప్రెస్‌వేలు & జాతీయ రహదారులు",
                                hi = "एक्सप्रेसवे और राष्ट्रीय राजमार्ग"
                            ),
                            desc = tr(
                                en = "Direct frontage on 4-lane NH-40 (Kurnool–Chennai). Direct intersection with NH-44 (Srinagar–Kanyakumari).",
                                te = "4-వరుసల NH-40 (కర్నూలు-చెన్నై) హైవే నేరుగా అనుసంధానం. NH-44 తో సులువైన జంక్షన్.",
                                hi = "4-लेन NH-40 (कर्नूल-चेन्नई) पर सीधा प्रवेश। NH-44 (श्रीनगर-कन्याकुमारी) के साथ सीधा जुड़ाव।"
                            )
                        )
                        ConnectivityRow(
                            icon = "🚆",
                            title = tr(
                                en = "Freight & Railway Junctions",
                                te = "సరుకు రవాణా & రైల్వే స్టేషన్లు",
                                hi = "माल ढुलाई और रेलवे जंक्शन"
                            ),
                            desc = tr(
                                en = "Betamcherla (28 km), Dupadu (30 km), and Kurnool City Junction (35 km).",
                                te = "బేతంచెర్ల (28 కి.మీ), దూపాడు (30 కి.మీ), మరియు కర్నూలు సిటీ జంక్షన్ (35 కి.మీ).",
                                hi = "बेतमचेरला (28 किमी), दुपडु (30 किमी), और कर्नूल सिटी जंक्शन (35 किमी)।"
                            )
                        )
                        ConnectivityRow(
                            icon = "💧",
                            title = tr(
                                en = "Dedicated Water Scheme",
                                te = "ప్రత్యేక పారిశ్రామిక తాగునీటి సరఫరా",
                                hi = "समर्पित औद्योगिक जल योजना"
                            ),
                            desc = tr(
                                en = "81+ MLD industrial pipeline drawing raw water from Muchumarri scheme on Srisailam reservoir.",
                                te = "శ్రీశైలం రిజర్వాయర్ ముచ్చుమర్రి పథకం నుండి 81+ MLD సామర్థ్యంతో ప్రత్యేక పారిశ్రామిక నీటి పైప్‌లైన్.",
                                hi = "श्रीशैलम जलाशय की मुचुमरी योजना से 81+ एमएलडी औद्योगिक पाइपलाइन द्वारा निर्बाध जलापूर्ति।"
                            )
                        )
                        ConnectivityRow(
                            icon = "⚡",
                            title = tr(
                                en = "Power Grid Substation",
                                te = "పవర్ గ్రిడ్ 765kV & 400kV సబ్‌స్టేషన్",
                                hi = "पावर ग्रिड सबस्टेशन"
                            ),
                            desc = tr(
                                en = "Dedicated 400/220/132 kV sub-stations developed with APTransco ensuring uninterrupted 24/7 power.",
                                te = "ఏపీట్రాన్స్‌కోతో కలిసి 400/220/132 kV ప్రత్యేక సబ్‌స్టేషన్లు; నిరంతర నాణ్యమైన 24/7 విద్యుత్ సరఫరా.",
                                hi = "एपीट्रांसको के साथ समर्पित 400/220/132 केवी सब-स्टेशन जो 24/7 निर्बाध बिजली सुनिश्चित करते हैं।"
                            )
                        )
                    }
                }
            }

            // ══════════════════════════════════════════════════════════════════
            // KEY FOCUS SECTORS & MAJOR ALLOTMENTS
            // ══════════════════════════════════════════════════════════════════
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = tr(
                                en = "⚡ Key Focus Sectors & Major Allotments",
                                te = "⚡ ప్రధాన రంగాలు & కీలక పరిశ్రమల కేటాయింపులు",
                                hi = "⚡ प्रमुख फोकस क्षेत्र और प्रमुख आवंटन"
                            ),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        SectorItem(
                            tag = tr(en = "Solar & Renewables", te = "సౌర & పునరుత్పాదక ఇంధనం", hi = "सौर और नवीकरणीय"),
                            name = tr(
                                en = "Agastya Green Energy (BN Group) & Grydonn",
                                te = "అగస్త్య గ్రీన్ ఎనర్జీ (BN గ్రూప్) & గ్రిడాన్",
                                hi = "अगस्त्य ग्रीन एनर्जी (बीएन ग्रुप) और ग्राइडॉन"
                            ),
                            desc = tr(
                                en = "12 GW solar ingot, wafer, cell & module manufacturing with ₹7,800+ Cr investment; Grydonn 3 GW solar cell facility.",
                                te = "₹7,800+ కోట్ల పెట్టుబడితో 12 GW సోలార్ వేఫర్, సెల్ & మాడ్యూల్ తయారీ ప్లాంట్; గ్రిడాన్ 3 GW సౌర కణాల యూనిట్.",
                                hi = "₹7,800+ करोड़ के निवेश से 12 गीगावाट सोलर सेल और मॉड्यूल विनिर्माण; ग्राइडॉन 3 गीगावाट सुविधा।"
                            )
                        )
                        SectorItem(
                            tag = tr(en = "Green Energy Storage", te = "గ్రీన్ ఎనర్జీ స్టోరేజ్", hi = "हरित ऊर्जा भंडारण"),
                            name = tr(
                                en = "Greenko Pinnapuram IREP",
                                te = "గ్రీన్‌కో పిన్నాపురం IREP",
                                hi = "ग्रीनको पिन्नापुरम आईआरईपी"
                            ),
                            desc = tr(
                                en = "5,230 MW Integrated Renewable Energy Project (Solar, Wind, Pumped Hydro Storage) — World's largest single-location setup.",
                                te = "5,230 మెగావాట్ల ఇంటిగ్రేటెడ్ పునరుత్పాదక ప్రాజెక్ట్ (సోలార్, విండ్, పంప్డ్ హైడ్రో స్టోరేజ్) — ప్రపంచంలోనే అతిపెద్ద ఏకైక కేంద్రం.",
                                hi = "5,230 मेगावाट एकीकृत नवीकरणीय ऊर्जा परियोजना (सौर, पवन, हाइड्रो स्टोरेज) — विश्व का सबसे बड़ा एकल-स्थान संयंत्र।"
                            )
                        )
                        SectorItem(
                            tag = tr(en = "Pharma & Bulk Drugs", te = "ఫార్మా & బల్క్ డ్రగ్స్", hi = "फार्मा और बल्क ड्रग्स"),
                            name = tr(
                                en = "Sigachi Industries & Bio-Tech Park",
                                te = "సిగాచి ఇండస్ట్రీస్ & బయో-టెక్ పార్క్",
                                hi = "सिगाची इंडस्ट्रीज और बायोटेक पार्क"
                            ),
                            desc = tr(
                                en = "High-precision pharmaceutical excipients, Large Volume Parenterals (IV fluids), and formulation plants.",
                                te = "హై-ప్రిసిషన్ ఫార్మాస్యూటికల్ ఎక్సిపియంట్లు, ఐవీ ఫ్లూయిడ్స్ మరియు మెడికల్ ఫార్ములేషన్ల భారీ కేంద్రాలు.",
                                hi = "सटीक फार्मास्यूटिकल एक्सीसिएंट्स, आईवी तरल पदार्थ और चिकित्सा निर्माण संयंत्र।"
                            )
                        )
                        SectorItem(
                            tag = tr(en = "Steel & Metallurgy", te = "స్టీల్ & లోహ పరిశ్రమ", hi = "स्टील और धातुकर्म"),
                            name = tr(en = "Jai Raj Ispat Limited", te = "జై రాజ్ ఇస్పాత్ లిమిటెడ్", hi = "जय राज इस्पात लिमिटेड"),
                            desc = tr(
                                en = "Steel and heavy metallurgical manufacturing unit.",
                                te = "స్టీల్ మరియు భారీ లోహ నిర్మాణ ఉత్పత్తుల తయారీ పరిశ్రమ.",
                                hi = "स्टील और भारी धातुकर्म निर्माण इकाई।"
                            )
                        )
                        SectorItem(
                            tag = tr(en = "Heavy Manufacturing", te = "భారీ తయారీ & సిమెంట్", hi = "भारी विनिर्माण"),
                            name = tr(en = "UltraTech & Ramco Cements", te = "అల్ట్రాటెక్ & రామ్కో సిమెంట్స్", hi = "अल्ट्राटेक और रामको सीमेंट्स"),
                            desc = tr(
                                en = "Mega cement plants and grinding units capitalizing on Kurnool's rich limestone belt.",
                                te = "కర్నూలు సున్నపురాయి నిక్షేపాల ఆధారంగా పనిచేస్తున్న భారీ సిమెంట్ తయారీ మరియు గ్రైండింగ్ ప్లాంట్లు.",
                                hi = "कर्नूल के चूना पत्थर पर आधारित विशाल सीमेंट विनिर्माण और ग्राइंडिंग इकाइयां।"
                            )
                        )
                        SectorItem(
                            tag = tr(en = "Agro & Food Processing", te = "వ్యవసాయ & ఫుడ్ ప్రాసెసింగ్", hi = "कृषि एवं खाद्य प्रसंस्करण"),
                            name = tr(en = "Kurnool Mega Food Park", te = "కర్నూలు మెగా ఫుడ్ పార్క్", hi = "कर्नूल मेगा फूड पार्क"),
                            desc = tr(
                                en = "APIIC food processing cluster, cold chain storage, and agricultural produce export hub.",
                                te = "APIIC ఫుడ్ ప్రాసెసింగ్ క్లస్టర్, కోల్డ్ స్టోరేజ్ గిడ్డంగులు మరియు వ్యవసాయ ఉత్పత్తుల ఎగుమతి హబ్.",
                                hi = "एपीआईआईसी खाद्य प्रसंस्करण क्लस्टर, कोल्ड स्टोरेज और कृषि उपज निर्यात केंद्र।"
                            )
                        )
                        SectorItem(
                            tag = tr(en = "MSME & Drone City", te = "MSME & డ్రోన్ సిటీ", hi = "एमएसएमई और ड्रोन सिटी"),
                            name = tr(en = "MSME Park & Aerospace Testing", te = "MSME పార్క్ & ఏరోస్పేస్ టెస్టింగ్", hi = "एमएसएमई पार्क और एयरोस्पेस परीक्षण"),
                            desc = tr(
                                en = "Over 100 industrial plots allocated beside NH-40 for local ancillary suppliers, machine shops, and drone testing.",
                                te = "NH-40 పక్కన స్థానిక సప్లయర్లు, మెషిన్ షాపులు మరియు డ్రోన్ టెస్టింగ్ కోసం 100కి పైగా పారిశ్రామిక ప్లాట్లు.",
                                hi = "स्थानीय सहायक आपूर्तिकर्ताओं, मशीन की दुकानों और ड्रोन परीक्षण के लिए एनएच-40 के पास 100+ भूखंड।"
                            )
                        )
                    }
                }
            }

            // ══════════════════════════════════════════════════════════════════
            // AP INDUSTRIAL POLICY & SINGLE DESK PORTAL
            // ══════════════════════════════════════════════════════════════════
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isDark) Color(0xFF1B2E1F) else Color(0xFFE8F5E9)
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        1.dp,
                        if (isDark) Color(0xFF2E7D32) else Color(0xFFA5D6A7)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = tr(
                                en = "📜 AP Industrial Policy & Single Desk Portal",
                                te = "📜 ఏపీ పారిశ్రామిక విధానం & సింగిల్ డెస్క్ పోర్టల్",
                                hi = "📜 एपी औद्योगिक नीति और सिंगल डेस्क पोर्टल"
                            ),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isDark) Color(0xFFA5D6A7) else Color(0xFF1B5E20)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = tr(
                                en = "• 21-Day time-bound statutory clearances via AP Single Desk Portal.\n• 100% Stamp Duty exemption on land lease/purchase.\n• ₹1.00 per unit power subsidy for eligible manufacturing units for 5 years.\n• 100% Net SGST reimbursement for anchor projects.",
                                te = "• ఏపీ సింగిల్ డెస్క్ ద్వారా 21 రోజుల్లోనే చట్టబద్ధమైన అన్ని అనుమతులు.\n• భూమి కొనుగోలు/లీజుపై 100% స్టాంప్ డ్యూటీ మినహాయింపు.\n• అర్హత గల తయారీ యూనిట్లకు 5 సంవత్సరాల పాటు యూనిట్‌కు ₹1.00 విద్యుత్ సబ్సిడీ.\n• ప్రధాన యాంకర్ ప్రాజెక్టులకు 100% నికర SGST రీయింబర్స్‌మెంట్.",
                                hi = "• एपी सिंगल डेस्क पोर्टल के माध्यम से 21 दिनों में समयबद्ध वैधानिक मंजूरी।\n• भूमि पट्टे/खरीद पर 100% स्टांप शुल्क छूट।\n• पात्र विनिर्माण इकाइयों को 5 वर्षों के लिए ₹1.00 प्रति यूनिट बिजली सब्सिडी।\n• प्रमुख एंकर परियोजनाओं के लिए 100% शुद्ध एसजीएसटी प्रतिपूर्ति।"
                            ),
                            fontSize = 12.sp,
                            lineHeight = 18.sp,
                            color = if (isDark) Color(0xFFC8E6C9) else Color(0xFF2E7D32)
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            // Call DIC Officer
                            Row(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFF2E7D32))
                                    .clickable {
                                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08518277255"))
                                        context.startActivity(intent)
                                    }
                                    .padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Call,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = tr(en = "Contact DIC", te = "DIC అధికారికి కాల్", hi = "DIC संपर्क"),
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            // Open APIIC Portal
                            Row(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isDark) Color(0xFF1E1E1E) else Color.White)
                                    .border(1.dp, Color(0xFF2E7D32), RoundedCornerShape(8.dp))
                                    .clickable {
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://apiic.in"))
                                        context.startActivity(intent)
                                    }
                                    .padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Language,
                                    contentDescription = null,
                                    tint = if (isDark) Color(0xFFA5D6A7) else Color(0xFF2E7D32),
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = tr(en = "APIIC Portal", te = "APIIC పోర్టల్", hi = "एपीआईआईसी पोर्टल"),
                                    color = if (isDark) Color(0xFFA5D6A7) else Color(0xFF2E7D32),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun HubKpiCard(
    modifier: Modifier = Modifier,
    icon: String,
    value: String,
    label: String,
    subLabel: String,
    bg: Color
) {
    val isDark = ThemeManager.isDarkMode

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = bg),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = icon, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                color = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark
            )
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (isDark) Color.White else Color(0xFF37474F)
            )
            Text(
                text = subLabel,
                fontSize = 9.sp,
                color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF546E7A)
            )
        }
    }
}

@Composable
fun ConnectivityRow(
    icon: String,
    title: String,
    desc: String
) {
    val isDark = ThemeManager.isDarkMode

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(if (isDark) Color(0xFF004D40) else Color(0xFFE0F2F1)),
            contentAlignment = Alignment.Center
        ) {
            Text(icon, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = if (isDark) Color.White else Color(0xFF263238)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = desc,
                fontSize = 11.sp,
                lineHeight = 15.sp,
                color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF546E7A)
            )
        }
    }
}

@Composable
fun SectorItem(
    tag: String,
    name: String,
    desc: String
) {
    val isDark = ThemeManager.isDarkMode

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = if (isDark) Color.White else Color(0xFF263238),
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(if (isDark) Color(0xFF004D40) else Color(0xFFE0F2F1))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                Text(
                    text = tag,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                )
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = desc,
            fontSize = 11.sp,
            lineHeight = 15.sp,
            color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF546E7A)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(if (isDark) Color(0xFF333333) else Color(0xFFECEFF1))
        )
    }
}
