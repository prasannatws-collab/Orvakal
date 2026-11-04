package com.orvakal.app.presentation.mandal

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.AppStrings
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.presentation.common.OrvakalDarkGreen
import com.orvakal.app.presentation.common.OrvakalTopHeader
import com.orvakal.app.presentation.theme.ThemeManager

/**
 * Helper to retrieve localized strings according to active AppLanguage.
 */
private fun tr(en: String, te: String, hi: String): String = when (LanguageManager.currentLanguage) {
    AppLanguage.TE -> te
    AppLanguage.HI -> hi
    AppLanguage.EN -> en
}

data class VillageInfo(
    val id: Int,
    val nameEn: String,
    val nameTe: String,
    val nameHi: String,
    val distanceKm: String,
    val tagEn: String,
    val tagTe: String,
    val tagHi: String,
    val population: String,
    val highlightsEn: String,
    val highlightsTe: String,
    val highlightsHi: String
) {
    fun localizedName(): String = when (LanguageManager.currentLanguage) {
        AppLanguage.TE -> nameTe
        AppLanguage.HI -> nameHi
        AppLanguage.EN -> nameEn
    }

    fun localizedTag(): String = when (LanguageManager.currentLanguage) {
        AppLanguage.TE -> tagTe
        AppLanguage.HI -> tagHi
        AppLanguage.EN -> tagEn
    }

    fun localizedHighlights(): String = when (LanguageManager.currentLanguage) {
        AppLanguage.TE -> highlightsTe
        AppLanguage.HI -> highlightsHi
        AppLanguage.EN -> highlightsEn
    }
}

val orvakalVillages = listOf(
    VillageInfo(
        1, "Orvakal", "ఓర్వకల్లు", "ओरवाकल", "0 km (HQ)",
        "Mandal Headquarters", "మండల కేంద్రం", "मंडल मुख्यालय",
        "11,850",
        "Gram Panchayat HQ, Main Bazar, Police Station, Govt PHC, Rock Garden entrance, Sub-Registrar & Tahsildar offices.",
        "గ్రామ పంచాయతీ ప్రధాన కేంద్రం, మెయిన్ బజార్, పోలీస్ స్టేషన్, ప్రభుత్వ ప్రాథమిక ఆరోగ్య కేంద్రం, రాక్ గార్డెన్ ప్రవేశద్వారం, తహశీల్దార్ కార్యాలయం.",
        "ग्राम पंचायत मुख्यालय, मुख्य बाजार, पुलिस स्टेशन, प्राथमिक स्वास्थ्य केंद्र, रॉक गार्डन प्रवेश द्वार, तहसील कार्यालय।"
    ),
    VillageInfo(
        2, "Kalva", "కాల్వ", "कालवा", "8.5 km",
        "Solar & Agricultural Belt", "సోలార్ & వ్యవసాయ క్లస్టర్", "सौर एवं कृषि क्षेत्र",
        "3,420",
        "Solar park substation zone, Kommu Cheruvu Anjaneya Swamy Temple, groundnut and cotton farming.",
        "సోలార్ పార్క్ సబ్‌స్టేషన్ జోన్, కొమ్ము చెరువు ఆంజనేయ స్వామి ఆలయం, వేరుశనగ మరియు పత్తి సాగు.",
        "सौर पार्क सबस्टेशन जोन, कोम्मु चेरुवु आंजनेय स्वामी मंदिर, मूंगफली और कपास की खेती।"
    ),
    VillageInfo(
        3, "Budawada", "బుడవాడ", "बुडावाडा", "6.2 km",
        "Industrial Phase-1", "పారిశ్రామిక ఫేజ్-1", "औद्योगिक चरण-1",
        "2,980",
        "UltraTech & Ramco cement proximity, rural milk producers cooperative society, primary health clinic.",
        "అల్ట్రాటెక్ & రాంకో సిమెంట్ యూనిట్ల సమీపం, గ్రామీణ పాల ఉత్పత్తిదారుల సహకార సంఘం, హెల్త్ క్లినిక్.",
        "अल्ट्राटेक और रामको सीमेंट उद्योग, ग्रामीण दुग्ध सहकारी समिति, प्राथमिक स्वास्थ्य क्लिनिक।"
    ),
    VillageInfo(
        4, "Brahmanapalle", "బ్రాహ్మణపల్లె", "ब्राह्मणापल्ले", "7.1 km",
        "Canal Agri Zone", "కాలువ ఆయకట్టు జోన్", "नहर कृषि क्षेत्र",
        "1,850",
        "Kundu river basin canal feeder, chilli and onion farms, Rythu Bharosa Kendra service point.",
        "కుందూ నదీ పరివాహక కాలువ ఆయకట్టు, మిర్చి మరియు ఉల్లి తోటలు, రైతు భరోసా కేంద్రం.",
        "कुंदू नदी बेसिन नहर क्षेत्र, मिर्च और प्याज की खेती, रायथू भरोसा केंद्र।"
    ),
    VillageInfo(
        5, "Chennakothapalle", "చెన్నకొత్తపల్లె", "चेन्नाकोथापल्ले", "9.4 km",
        "Panchayat Cluster", "పంచాయతీ క్లస్టర్", "पंचायत क्लस्टर",
        "2,140",
        "Cotton growers association, ZP High school, solar feeder grid coverage, veterinary dispensary.",
        "పత్తి రైతుల సంఘం, జిల్లా పరిషత్ ఉన్నత పాఠశాల, వ్యవసాయ సోలార్ ఫీడర్, పశు వైద్య కేంద్రం.",
        "कपास उत्पादक संघ, जिला परिषद हाई स्कूल, सौर फीडर ग्रिड, पशु चिकित्सालय।"
    ),
    VillageInfo(
        6, "Gutlapadu", "గుట్లపాడు", "गुटलापाडु", "5.8 km",
        "Dairy & Livestock Hub", "పాడిపరిశ్రమ & పశుసంవర్ధక కేంద్రం", "डेयरी एवं पशुपालन केंद्र",
        "1,670",
        "Milk procurement center, livestock veterinary outpost, organic dryland farming.",
        "పాల సేకరణ కేంద్రం, పశు వైద్య సేవలు, సేంద్రీయ మెట్ట వ్యవసాయం.",
        "दुग्ध संग्रहण केंद्र, पशु चिकित्सालय चौकी, जैविक वर्षा आधारित खेती।"
    ),
    VillageInfo(
        7, "Hussenapuram", "హుస్సేనాపురం", "हुस्सैनापुरम", "11.2 km",
        "Western Rural Zone", "పశ్చిమ గ్రామీణ జోన్", "पश्चिमी ग्रामीण क्षेत्र",
        "2,310",
        "Community hall, groundwater recharge tanks, Bengal gram and jowar cultivation.",
        "కమ్యూనిటీ హాల్, భూగర్భ జలాల రీఛార్జ్ చెరువులు, శనగ మరియు జొన్న సాగు.",
        "सामुदायिक भवन, भूजल संचयन तालाब, चना और ज्वार की खेती।"
    ),
    VillageInfo(
        8, "Kannamadakala", "కన్నమడకల", "कन्नमडकळा", "12.0 km",
        "Historic Agri Village", "చారిత్రక వ్యవసాయ గ్రామం", "ऐतिहासिक कृषि गांव",
        "1,940",
        "Ancient village irrigation tank, heritage temple complex, groundnut decorticating units.",
        "పురాతన సాగునీటి చెరువు, చారిత్రక దేవాలయాలు, వేరుశనగ ప్రాసెసింగ్ యూనిట్లు.",
        "प्राचीन सिंचाई तालाब, ऐतिहासिक मंदिर परिसर, मूंगफली प्रसंस्करण इकाइयां।"
    ),
    VillageInfo(
        9, "Kethavaram", "కేతవరం", "केथावरम", "14.5 km",
        "Heritage & Cave Art", "చారిత్రక గుహ చిత్రాల ప్రాంతం", "शैल चित्रकला धरोहर",
        "1,720",
        "Famous prehistoric rock art caves, natural rock shelters, scenic tourist plateau terrain.",
        "ప్రసిద్ధ చరిత్రపూర్వ రాతి చిత్రాల గుహలు, సహజ రాతి ఆశ్రయాలు, సుందరమైన పీఠభూమి పర్యాటక ప్రాంతం.",
        "प्रसिद्ध प्रागैतिहासिक शैल चित्रकला गुफाएं, प्राकृतिक रॉक शेल्टर, सुरम्य पठार।"
    ),
    VillageInfo(
        10, "Komarolu", "కొమరోలు", "कोमरोलु", "8.0 km",
        "Agricultural Belt", "వ్యవసాయ క్లస్టర్", "कृषि क्षेत्र",
        "2,280",
        "Rythu Bharosa Kendra, red gram farming, community borewell network, self-help groups.",
        "రైతు భరోసా కేంద్రం, కంది సాగు, కమ్యూనిటీ బోర్ల నెట్‌వర్క్, పొదుపు సంఘాలు.",
        "रायथू भरोसा केंद्र, अरहर की खेती, सामुदायिक नलकूप प्रणाली, स्वयं सहायता समूह।"
    ),
    VillageInfo(
        11, "Lodipalle", "లోడిపల్లె", "लोडीपल्ले", "4.3 km",
        "Highway Corridor", "హైవే కారిడార్", "राजमार्ग गलियारा",
        "2,650",
        "NH-40 roadside growth belt, warehouse logistics, petrol stations, highway food courts.",
        "NH-40 జాతీయ రహదారి విస్తరణ జోన్, వేర్‌హౌస్ లాజిస్టిక్స్, ఇంధన కేంద్రాలు, హోటళ్లు.",
        "NH-40 सड़क विकास क्षेत्र, गोदाम रसद, पेट्रोल पंप, हाईवे फूड कोर्ट।"
    ),
    VillageInfo(
        12, "Meenavolu", "మీనవోలు", "मीनावोलु", "10.6 km",
        "Horticulture Cluster", "ఉద్యానవన క్లస్టర్", "बागवानी क्लस्टर",
        "1,530",
        "Tomato, chilli and vegetable cultivation, micro-drip irrigation farmer clusters.",
        "టమోటా, మిర్చి మరియు కూరగాయల సాగు, బిందు సేద్యం ఆధారిత రైతు సంఘాలు.",
        "टमाटर, मिर्च और सब्जियों की खेती, ड्रिप सिंचाई किसान समूह।"
    ),
    VillageInfo(
        13, "Nannur", "నన్నూరు", "नन्नूर", "7.8 km",
        "Transit & Infrastructure", "రవాణా & మౌలిక కేంద్రం", "पारगमन एवं अवसंरचना",
        "3,100",
        "Major road junction towards Kurnool city, 33/11kV electrical substation, engineering college zone.",
        "కర్నూలు నగరానికి ప్రధాన జంక్షన్, 33/11kV విద్యుత్ సబ్‌స్టేషన్, ఇంజనీరింగ్ కళాశాలల ప్రాంతం.",
        "कुरनूल शहर की ओर प्रमुख सड़क जंक्शन, 33/11kV विद्युत सबस्टेशन, कॉलेज क्षेत्र।"
    ),
    VillageInfo(
        14, "Palakolanu", "పాలకొలను", "पालकोलानु", "13.2 km",
        "Major Gram Panchayat", "ప్రధాన గ్రామ పంచాయతీ", "प्रमुख ग्राम पंचायत",
        "4,120",
        "Large agriculture hub, chilli mandi collection center, weekly cattle market, rural bank branch.",
        "అతిపెద్ద వ్యవసాయ కేంద్రం, మిర్చి మార్కెట్ సేకరణ, వారపు పశువుల సంత, గ్రామీణ బ్యాంకు శాఖ.",
        "बड़ा कृषि केंद्र, मिर्च मंडी संग्रहण केंद्र, साप्ताहिक पशु हाट, ग्रामीण बैंक शाखा।"
    ),
    VillageInfo(
        15, "Pudicherla", "పుడిచెర్ల", "पुडीचेरला", "9.7 km",
        "Industrial Peripheral Zone", "పారిశ్రామిక సరిహద్దు జోన్", "औद्योगिक परिधीय क्षेत्र",
        "2,050",
        "Solar farm access road, industrial labour cluster, youth skill and training center.",
        "సోలార్ ఫామ్ రహదారి, పారిశ్రామిక కార్మిక కేంద్రం, యువజన నైపుణ్య శిక్షణ కేంద్రం.",
        "सौर पार्क संपर्क मार्ग, औद्योगिक श्रमिक क्लस्टर, युवा कौशल प्रशिक्षण केंद्र।"
    ),
    VillageInfo(
        16, "Sakunala", "శకునాల", "शकुनाला", "6.9 km",
        "Dairy & Farming Village", "పాడి & వ్యవసాయ గ్రామం", "दुग्ध एवं कृषि गांव",
        "1,880",
        "Village milk parlor, primary school, solar power feeder coverage, groundnut farms.",
        "పాల సేకరణ కేంద్రం, ప్రాథమిక పాఠశాల, వ్యవసాయ సోలార్ ఫీడర్, వేరుశనగ తోటలు.",
        "दुग्ध पार्लर, प्राथमिक विद्यालय, सौर विद्युत फीडर, मूंगफली के खेत।"
    ),
    VillageInfo(
        17, "Somayajulapalle", "సోమయాజులపల్లె", "सोमयाजुलपल्ले", "10.1 km",
        "Temple & Cultural Center", "ఆలయ & సాంస్కృతిక కేంద్రం", "सांस्कृतिक एवं धार्मिक केंद्र",
        "2,410",
        "Sri Chennakesava Swamy annual jathara, historic stone architecture, community festival grounds.",
        "శ్రీ చెన్నకేశవ స్వామి వార్షిక బ్రహ్మోత్సవాలు, చారిత్రక శిలా కట్టడాలు, ఉత్సవ మైదానం.",
        "श्री चेन्नाकेशव स्वामी वार्षिक मेला, ऐतिहासिक पत्थर की संरचनाएं, उत्सव मैदान।"
    ),
    VillageInfo(
        18, "Thippayapalle", "తిప్పాయపల్లె", "थिप्पायपल्ले", "8.9 km",
        "Rural Community", "గ్రామీణ సముదాయం", "ग्रामीण समुदाय",
        "1,490",
        "Watershed development project, dryland farming, women self-help credit groups.",
        "వాటర్‌షెడ్ అభివృద్ధి పథకం, మెట్ట వ్యవసాయం, మహిళా స్వయం సహాయక పొదుపు సంఘాలు.",
        "वाटरशेड विकास परियोजना, शुष्क भूमि कृषि, महिला स्वयं सहायता समूह।"
    ),
    VillageInfo(
        19, "Uyyalawada", "ఉయ్యాలవాడ", "उय्यालावाड़ा", "5.0 km",
        "Airport Zone", "విమానాశ్రయ జోన్", "हवाई अड्डा क्षेत्र",
        "3,650",
        "Home to Kurnool Airport (KJB), industrial corridor logistics gateway, agro-processing cold storage.",
        "కర్నూలు విమానాశ్రయం (KJB) నెలవైన ప్రాంతం, పారిశ్రామిక లాజిస్టిక్స్ ముఖద్వారం, కోల్డ్ స్టోరేజ్.",
        "कुरनूल हवाई अड्डे (KJB) का स्थल, औद्योगिक रसद प्रवेश द्वार, कृषि कोल्ड स्टोरेज।"
    ),
    VillageInfo(
        20, "Varakur", "వారకూరు", "वारकूर", "12.8 km",
        "Artisans & Handloom", "చేతివృత్తులు & వ్యవసాయం", "दस्तकार एवं कृषि",
        "1,870",
        "Gram Panchayat office, local artisan weavers, sunflower cultivation, veterinary sub-center.",
        "గ్రామ పంచాయతీ కార్యాలయం, చేనేత కళాకారులు, ప్రొద్దుతిరుగుడు సాగు, పశు వైద్య ఉపకేంద్రం.",
        "ग्राम पंचायत कार्यालय, स्थानीय बुनकर, सूरजमुखी की खेती, पशु चिकित्सा उप-केंद्र।"
    ),
    VillageInfo(
        21, "Gani", "గని", "गनी", "15.0 km",
        "Mega Solar Field", "మెగా సోలార్ విద్యుత్ క్షేత్రం", "मेगा सौर ऊर्जा क्षेत्र",
        "2,840",
        "Greenko Ultra Mega Solar Park high-voltage 400kV transmission grid gateway, sunflower farms.",
        "గ్రీన్‌కో అల్ట్రా మెగా సోలార్ పార్క్ 400kV హై-వోల్టేజ్ ట్రాన్స్‌మిషన్ గ్రిడ్, ప్రొద్దుతిరుగుడు సాగు.",
        "ग्रीनको अल्ट्रा मेगा सोलर पार्क 400kV ट्रांसमिशन ग्रिड, सूरजमुखी की खेती।"
    ),
    VillageInfo(
        22, "Byreddynagar", "బైరెడ్డినగర్", "बायरेड्डीनगर", "2.5 km",
        "Urbanizing Suburb", "విస్తరిస్తున్న ఉపనగరం", "उपनगरीय विस्तार",
        "2,760",
        "Main residential extension of Orvakal, commercial retail market, housing layouts, clinic.",
        "ఓర్వకల్లు ప్రధాన నివాస ప్రాంతం, వాణిజ్య మార్కెట్, నూతన కాలనీలు, క్లినిక్లు.",
        "ओरवाकल का आवासीय विस्तार, वाणिज्यिक बाजार, नई कॉलोनियां, स्वास्थ्य केंद्र।"
    ),
    VillageInfo(
        23, "Hussainapuram Thanda", "హుస్సేనాపురం తాండా", "हुस्सैनापुरम तांडा", "12.5 km",
        "Tribal Settlement", "గిరిజన ఆవాసం", "जनजातीय बस्ती",
        "920",
        "Lambadi cultural heritage, traditional handicraft embroidery, sheep and goat rearing.",
        "లంబాడీ సంస్కృతి, సాంప్రదాయ అద్దకం & ఎంబ్రాయిడరీ కళలు, గొర్రెలు & మేకల పెంపకం.",
        "लमबाडी सांस्कृतिक धरोहर, पारंपरिक कढ़ाई व हस्तशिल्प, भेड़ एवं बकरी पालन।"
    )
)

@Composable
fun OrvakalMandalProfileScreen(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var villageSearchQuery by remember { mutableStateOf("") }

    val tabs = listOf(
        tr("Geography & Map", "భౌగోళికం & పటాలు", "भूगोल एवं मानचित्र"),
        tr("Constituency & Leaders", "నియోజకవర్గం & నాయకులు", "निर्वाचन एवं नेता"),
        tr("Villages (23)", "గ్రామాలు (23)", "गांवों की सूची (23)"),
        tr("Demographics", "జనాభా & ఓటర్లు", "जनसांख्यिकी एवं मतदाता")
    )

    val isDark = ThemeManager.isDarkMode

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDark) Color(0xFF121212) else Color(0xFFF3F7F8))
    ) {
        // Screen Header Bar: Back Button, Title, Dashboard Pill
        Surface(
            color = OrvakalDarkGreen,
            shadowElevation = 2.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.size(38.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Column {
                        Text(
                            text = tr(
                                en = "Orvakal Mandal Profile",
                                te = "ఓర్వకల్లు మండల సమగ్ర సమాచారం",
                                hi = "ओरवाकल मंडल प्रोफाइल"
                            ),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = tr(
                                en = "Kurnool District, AP | 23 Villages",
                                te = "కర్నూలు జిల్లా, ఆంధ్రప్రదేశ్ | 23 గ్రామాలు",
                                hi = "कुरनूल जिला, आंध्र प्रदेश | 23 गांव"
                            ),
                            fontSize = 11.sp,
                            color = Color(0xFFE0F2F1)
                        )
                    }
                }

                // Dashboard Pill
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF00332C))
                        .border(
                            1.dp,
                            Color(0xFF00796B),
                            RoundedCornerShape(8.dp)
                        )
                        .clickable { onNavigateToHome() }
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("🏠", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = AppStrings.dashboard,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }

        // Tab Selector Row
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White,
            contentColor = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778),
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778),
                    height = 3.dp
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            text = title,
                            fontSize = 12.sp,
                            fontWeight = if (selectedTabIndex == index) FontWeight.Bold else FontWeight.Medium,
                            color = if (selectedTabIndex == index) {
                                if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                            } else {
                                if (isDark) Color(0xFFCFD8DC) else Color(0xFF546E7A)
                            }
                        )
                    }
                )
            }
        }

        // Tab Content
        when (selectedTabIndex) {
            0 -> GeographyAndMapTab()
            1 -> ConstituencyAndLeadersTab()
            2 -> VillagesListTab(searchQuery = villageSearchQuery, onSearchChange = { villageSearchQuery = it })
            3 -> DemographicsTab()
        }
    }
}

// ═══════════════════════════════════════════════════════════════════════════
// COMPLIANCE: NON-GOVERNMENT AFFILIATION DISCLAIMER (PLAY STORE POLICY)
// ═══════════════════════════════════════════════════════════════════════════
@Composable
private fun PlayStorePolicyDisclaimerBanner() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF8E1)),
        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFFFD54F)))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = Icons.Filled.Shield,
                contentDescription = null,
                tint = Color(0xFFF57F17),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = tr(
                        en = "Non-Governmental Entity Disclaimer (Google Play Policy)",
                        te = "ప్రభుత్వేతర స్వతంత్ర సమాచార వేదిక గమనిక (Google Play పాలసీ)",
                        hi = "गैर-सरकारी स्वतंत्र मंच अस्वीकरण (Google Play नीति)"
                    ),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFE65100)
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = tr(
                        en = "This app is an independent community portal developed by the Orvakal Community & Civic Portal Team. It does NOT represent, and is NOT affiliated with, authorized by, or endorsed by the Government of Andhra Pradesh or the Government of India. All civic & government public data is compiled for public convenience from official public domain records.",
                        te = "ఈ యాప్ ఓర్వకల్లు కమ్యూనిటీ & సివిక్ పోర్టల్ బృందంచే రూపొందించబడిన స్వతంత్ర పౌర వేదిక. ఇది ఆంధ్రప్రదేశ్ ప్రభుత్వం లేదా భారత ప్రభుత్వానికి చెందిన అధికారిక యాప్ కాదు మరియు ప్రభుత్వంతో ఎలాంటి అనుబంధం లేదు. ప్రభుత్వ సమాచారం ప్రజల సౌలభ్యం కోసం అధికారిక పబ్లిక్ రికార్డుల నుండి సేకరించబడింది.",
                        hi = "यह ऐप ओरवाकल कम्युनिटी एवं सिविक पोर्टल टीम द्वारा विकसित एक स्वतंत्र नागरिक मंच है। यह आंध्र प्रदेश सरकार या भारत सरकार से संबद्ध, अधिकृत या उनका आधिकारिक ऐप नहीं है। सरकारी जानकारी केवल जनसुविधा हेतु सार्वजनिक डोमेन स्रोतों से संकलित की गई है।"
                    ),
                    fontSize = 10.sp,
                    color = Color(0xFF5D4037),
                    lineHeight = 14.sp
                )
            }
        }
    }
}

// ═══════════════════════════════════════════════════════════════════════════
// COMPLIANCE: INSTITUTIONAL DATA SOURCE ATTRIBUTION CARD
// ═══════════════════════════════════════════════════════════════════════════
@Composable
private fun DataSourceAttributionCard() {
    val context = LocalContext.current
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("📚", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = tr(
                        en = "Official Data Sources & Transparency",
                        te = "అధికారిక సమాచార మూలాలు & పరిశీలన",
                        hi = "आधिकारिक डेटा स्रोत एवं पारदर्शिता"
                    ),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF004D5A)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = tr(
                    en = "In compliance with Google Play Store Developer Policies, all data within this profile is sourced directly and transparently from publicly published government archives:",
                    te = "Google Play Store నిబంధనలకు అనుగుణంగా, ఈ ప్రొఫైల్‌లోని వివరాలు క్రింది అధికారిక పబ్లిక్ పోర్టల్‌ల నుండి సేకరించబడ్డాయి:",
                    hi = "Google Play Store नीतियों के अनुपालन में, यह समस्त डेटा निम्नलिखित आधिकारिक सार्वजनिक पोर्टलों से संकलित है:"
                ),
                fontSize = 11.sp,
                color = Color(0xFF546E7A),
                lineHeight = 15.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            val sources = listOf(
                Triple(
                    tr("Demographics & Census", "జనాభా గణాంకాలు", "जनसांख्यिकी एवं जनगणना"),
                    tr("Census of India (Office of Registrar General) & AP DES", "భారత జనాభా లెక్కలు (సెన్సస్ ఇండియా) & ఎపి డిఈఎస్", "भारत की जनगणना (रजिस्ट्रार जनरल कार्यालय) एवं एपी डीईएस"),
                    "https://censusindia.gov.in"
                ),
                Triple(
                    tr("Electoral & Voter Rolls", "ఓటర్ల జాబితా & కేంద్రాలు", "मतदाता सूची एवं निर्वाचन"),
                    tr("Election Commission of India (ECI) & CEO Andhra Pradesh (AC-138 / PC-19)", "భారత ఎన్నికల సంఘం (ECI) & చీఫ్ ఎలక్టోరల్ ఆఫీసర్ ఎపి", "भारत निर्वाचन आयोग (ECI) एवं मुख्य निर्वाचन अधिकारी एपी"),
                    "https://eci.gov.in"
                ),
                Triple(
                    tr("Administration & Governance", "పరిపాలన & అధికారుల సమాచారం", "प्रशासन एवं अधिकारी विवरण"),
                    tr("Kurnool District Administration Portal & State Gazette", "కర్నూలు జిల్లా అధికారిక పోర్టల్ & రాష్ట్ర గెజిట్", "कुरनूल जिला प्रशासन पोर्टल एवं राज्य राजपत्र"),
                    "https://kurnool.ap.gov.in"
                ),
                Triple(
                    tr("Geography, Terrain & Highways", "భౌగోళికం & రహదారులు", "भूगोल, मानचित्र एवं राजमार्ग"),
                    tr("Survey of India, ISRO Bhuvan Portal & MoRTH (NH-40)", "సర్వే ఆఫ్ ఇండియా, ఇస్రో భువన్ పోర్టల్ & జాతీయ రహదారుల విభాగం", "सर्वे ऑफ इंडिया, इसरो भुवन पोर्टल एवं सड़क परिवहन मंत्रालय"),
                    "https://bhuvan.nrsc.gov.in"
                ),
                Triple(
                    tr("Industrial Corridor & Airport", "పారిశ్రామిక హబ్ & విమానాశ్రయం", "औद्योगिक हब एवं हवाई अड्डा"),
                    tr("APIIC, APSPCL (Solar Park) & Airports Authority of India (KJB)", "ఏపీఐఐసీ, ఏపీఎస్పీసీఎల్ & ఎయిర్‌పోర్ట్స్ అథారిటీ ఆఫ్ ఇండియా", "एपीआईआईसी, सौर ऊर्जा निगम एवं भारतीय विमानपत्तन प्राधिकरण"),
                    "https://apiic.in"
                )
            )

            sources.forEach { (category, description, url) ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFF5F9FA))
                        .padding(10.dp)
                ) {
                    Text(
                        text = category,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF006778)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = description,
                        fontSize = 10.sp,
                        color = Color(0xFF455A64),
                        lineHeight = 14.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier
                            .clickable {
                                try {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    context.startActivity(intent)
                                } catch (_: Exception) { }
                            },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🔗 $url",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF0288D1)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Filled.OpenInNew,
                            contentDescription = null,
                            tint = Color(0xFF0288D1),
                            modifier = Modifier.size(11.dp)
                        )
                    }
                }
            }
        }
    }
}

// ═══════════════════════════════════════════════════════════════════════════
// TAB 1: GEOGRAPHY & MAPS (PROPER ROAD MAP + HD TOPOLOGY CANVAS)
// ═══════════════════════════════════════════════════════════════════════════
@Composable
private fun GeographyAndMapTab() {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Policy Disclaimer Banner
        item { PlayStorePolicyDisclaimerBanner() }

        // Introduction Card (Fully localized)
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("📍", fontSize = 20.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = tr(
                                    en = "Introduction to Orvakal",
                                    te = "ఓర్వకల్లు మండల పరిచయం",
                                    hi = "ओरवाकल मंडल परिचय"
                                ),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF004D5A)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFFE0F2F1))
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = tr("Mandal Code: 5086", "మండల కోడ్: 5086", "मंडल कोड: 5086"),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF00695C)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = tr(
                            en = "Orvakal (ఓర్వకల్లు) is a major revenue and development mandal in Kurnool District of Andhra Pradesh, India. Situated at an elevation of 360 meters on the Rayalaseema plateau along National Highway 40 (NH-40), Orvakal is renowned globally for its 3-billion-year-old natural quartzite rock formations, its strategic Kurnool Airport (KJB), and as home to the Greenko Kurnool Ultra Mega Solar Park (1000+ MW capacity) — transforming it into one of Andhra Pradesh's premier industrial and clean energy hubs.",
                            te = "ఓర్వకల్లు ఆంధ్రప్రదేశ్ రాష్ట్రం, కర్నూలు జిల్లాలోని ప్రముఖ రెవెన్యూ మరియు అభివృద్ధి మండలం. రాయలసీమ పీఠభూమిపై సముద్ర మట్టానికి 360 మీటర్ల ఎత్తులో, జాతీయ రహదారి 40 (NH-40) వెంట విస్తరించి ఉంది. 300 కోట్ల సంవత్సరాల పురాతన సహజ రాతి శిల్పాల రాక్ గార్డెన్, కర్నూలు విమానాశ్రయం (KJB), మరియు 1000+ మెగావాట్ల గ్రీన్‌కో అల్ట్రా మెగా సోలార్ పార్కుతో ఇది ఆంధ్రప్రదేశ్‌లోనే అగ్రగామి పారిశ్రామిక మరియు హరిత ఇంధన కేంద్రంగా ప్రసిద్ధి చెందింది.",
                            hi = "ओरवाकल आंध्र प्रदेश के कुरनूल जिले का एक प्रमुख राजस्व एवं विकास मंडल है। रायलसीमा पठार पर समुद्र तल से 360 मीटर की ऊंचाई पर राष्ट्रीय राजमार्ग 40 (NH-40) पर स्थित यह क्षेत्र 3 अरब वर्ष पुरानी प्राकृतिक चट्टानों के रॉक गार्डन, सामरिक कुरनूल हवाई अड्डे (KJB) और 1000+ मेगावाट क्षमता वाले ग्रीनको अल्ट्रा मेगा सोलर पार्क के लिए विश्वविख्यात है।"
                        ),
                        fontSize = 12.sp,
                        color = Color(0xFF37474F),
                        lineHeight = 18.sp
                    )
                }
            }
        }

        // ══════════════════════════════════════════════════════════════════════
        // PROPER REALISTIC ROAD MAP & TRANSIT CORRIDOR CARD (BEFORE TOPOLOGY)
        // ══════════════════════════════════════════════════════════════════════
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🧭", fontSize = 18.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = tr(
                                    en = "Regional Road Map & Connectivity",
                                    te = "ప్రాంతీయ రహదారి పటం & రవాణా మార్గాలు",
                                    hi = "क्षेत्रीय सड़क मानचित्र एवं कनेक्टिविटी"
                                ),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF004D5A)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFFFFF3E0))
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = "NH-40 Expressway",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFE65100)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Realistic Visual Vector Road Map
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFE8F0F2))
                            .border(1.dp, Color(0xFFCFD8DC), RoundedCornerShape(12.dp))
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            val w = size.width
                            val h = size.height

                            // Background terrain shading
                            drawRect(color = Color(0xFFEBF2F3))

                            // Secondary rural roads
                            val secRoad1 = Path().apply {
                                moveTo(w * 0.50f, h * 0.48f)
                                quadraticBezierTo(w * 0.70f, h * 0.35f, w * 0.85f, h * 0.15f)
                            }
                            drawPath(secRoad1, Color(0xFFB0BEC5), style = Stroke(width = 3.dp.toPx()))

                            val secRoad2 = Path().apply {
                                moveTo(w * 0.50f, h * 0.48f)
                                quadraticBezierTo(w * 0.35f, h * 0.65f, w * 0.20f, h * 0.85f)
                            }
                            drawPath(secRoad2, Color(0xFFB0BEC5), style = Stroke(width = 3.dp.toPx()))

                            // Main NH-40 Highway (4-lane corridor)
                            val mainHighway = Path().apply {
                                moveTo(w * 0.05f, h * 0.20f)
                                quadraticBezierTo(w * 0.45f, h * 0.48f, w * 0.95f, h * 0.80f)
                            }
                            // Asphalt base
                            drawPath(mainHighway, Color(0xFF37474F), style = Stroke(width = 8.dp.toPx()))
                            // White dashed dividing line
                            drawPath(
                                mainHighway,
                                Color.White,
                                style = Stroke(
                                    width = 1.5.dp.toPx(),
                                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(14f, 10f), 0f)
                                )
                            )

                            // Nodes & Pins
                            // 1. Kurnool City (NW)
                            drawCircle(Color(0xFF0288D1), radius = 7.dp.toPx(), center = Offset(w * 0.10f, h * 0.23f))
                            drawCircle(Color.White, radius = 3.dp.toPx(), center = Offset(w * 0.10f, h * 0.23f))

                            // 2. Orvakal HQ (Center)
                            drawCircle(Color(0xFFD32F2F), radius = 9.dp.toPx(), center = Offset(w * 0.50f, h * 0.50f))
                            drawCircle(Color.White, radius = 4.dp.toPx(), center = Offset(w * 0.50f, h * 0.50f))

                            // 3. Kurnool Airport (West of Orvakal)
                            drawCircle(Color(0xFF00796B), radius = 6.dp.toPx(), center = Offset(w * 0.38f, h * 0.42f))

                            // 4. Solar Park (North East)
                            drawCircle(Color(0xFFFBC02D), radius = 6.dp.toPx(), center = Offset(w * 0.78f, h * 0.22f))

                            // 5. Nandyal City (SE)
                            drawCircle(Color(0xFF5E35B1), radius = 7.dp.toPx(), center = Offset(w * 0.90f, h * 0.77f))
                            drawCircle(Color.White, radius = 3.dp.toPx(), center = Offset(w * 0.90f, h * 0.77f))
                        }

                        // Highway label badge overlay
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .padding(8.dp)
                                .background(Color(0xFF37474F).copy(alpha = 0.9f), RoundedCornerShape(6.dp))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text("🛣️ NH-40 (Kurnool ⟷ Nandyal)", fontSize = 9.sp, color = Color.White, fontWeight = FontWeight.Bold)
                        }

                        // Distance overlays on the map
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(8.dp)
                                .background(Color.White.copy(alpha = 0.92f), RoundedCornerShape(8.dp))
                                .padding(6.dp)
                        ) {
                            Text("📍 Kurnool: 24 km (NW)", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0288D1))
                            Text("📍 Orvakal HQ (Center)", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFFD32F2F))
                            Text("📍 Nandyal: 45 km (SE)", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF5E35B1))
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Transit Connectivity Description
                    Text(
                        text = tr(
                            en = "Strategic Corridor: Orvakal lies directly on the 4-lane NH-40 Expressway, serving as the commercial and aviation gateway between Kurnool District headquarters and Nandyal. It provides direct expressway access to Hyderabad (235 km), Bengaluru (340 km), and Amaravati (310 km).",
                            te = "వ్యూహాత్మక రవాణా మార్గం: ఓర్వకల్లు 4-వరుసల NH-40 జాతీయ రహదారిపై ఉంది. ఇది కర్నూలు జిల్లా కేంద్రం మరియు నంద్యాల మధ్య కీలక విమానయాన మరియు పారిశ్రామిక కూడలి. హైదరాబాద్ (235 కి.మీ), బెంగళూరు (340 కి.మీ), అమరావతి (310 కి.మీ) నగరాలకు ప్రత్యక్ష రవాణా అనుసంధానం ఉంది.",
                            hi = "सामरिक गलियारा: ओरवाकल 4-लेन NH-40 राष्ट्रीय राजमार्ग पर स्थित है, जो कुरनूल जिला मुख्यालय और नंद्याल के बीच विमानन और व्यापारिक प्रवेश द्वार है। यहां से हैदराबाद (235 किमी), बेंगलुरु (340 किमी) और अमरावती (310 किमी) हेतु सीधा एक्सप्रेसवे संपर्क है।"
                        ),
                        fontSize = 11.sp,
                        color = Color(0xFF455A64),
                        lineHeight = 16.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Interactive Action Buttons to Open Real Google Maps
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(
                            onClick = {
                                try {
                                    val gmmIntentUri = Uri.parse("geo:15.6833,78.2167?q=Orvakal,+Kurnool+District,+Andhra+Pradesh")
                                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                                    context.startActivity(mapIntent)
                                } catch (_: Exception) {
                                    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/?api=1&query=Orvakal,+Andhra+Pradesh"))
                                    context.startActivity(webIntent)
                                }
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006778))
                        ) {
                            Icon(Icons.Filled.Map, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = tr("Open Google Maps", "గూగుల్ మ్యాప్స్", "गूगल मैप्स खोलें"),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        OutlinedButton(
                            onClick = {
                                try {
                                    val navUri = Uri.parse("google.navigation:q=15.6833,78.2167")
                                    val navIntent = Intent(Intent.ACTION_VIEW, navUri)
                                    context.startActivity(navIntent)
                                } catch (_: Exception) {
                                    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir/?api=1&destination=Orvakal,+Andhra+Pradesh"))
                                    context.startActivity(webIntent)
                                }
                            },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF006778))
                        ) {
                            Icon(Icons.Filled.Navigation, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = tr("Directions (NH-40)", "రూట్ గైడ్", "दिशानिर्देश लें"),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        // ══════════════════════════════════════════════════════════════════════
        // HD GEOGRAPHICAL TOPOLOGY MAP VISUAL
        // ══════════════════════════════════════════════════════════════════════
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF002730)),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🗺️", fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = tr(
                                    en = "HD Geographical Topology Map",
                                    te = "హెచ్‌డీ భౌగోళిక టోపోలాజీ పటం",
                                    hi = "एचडी भौगोलिक स्थलाकृति मानचित्र"
                                ),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF80DEEA)
                            )
                        }
                        Text(
                            text = "15.6833° N, 78.2167° E",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF4DD0E1)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // HD Canvas Drawing of Orvakal Mandal Boundary & Topology
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF003844))
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            val w = size.width
                            val h = size.height

                            // Draw subtle topographic grid
                            val gridSpacing = 30.dp.toPx()
                            for (x in 0..(w / gridSpacing).toInt()) {
                                drawLine(
                                    color = Color(0xFF004D5A).copy(alpha = 0.4f),
                                    start = Offset(x * gridSpacing, 0f),
                                    end = Offset(x * gridSpacing, h),
                                    strokeWidth = 1f
                                )
                            }
                            for (y in 0..(h / gridSpacing).toInt()) {
                                drawLine(
                                    color = Color(0xFF004D5A).copy(alpha = 0.4f),
                                    start = Offset(0f, y * gridSpacing),
                                    end = Offset(w, y * gridSpacing),
                                    strokeWidth = 1f
                                )
                            }

                            // Draw Mandal Boundary
                            val mandalPath = Path().apply {
                                moveTo(w * 0.15f, h * 0.35f)
                                cubicTo(w * 0.25f, h * 0.10f, w * 0.55f, h * 0.08f, w * 0.82f, h * 0.22f)
                                cubicTo(w * 0.95f, h * 0.40f, w * 0.88f, h * 0.75f, w * 0.75f, h * 0.88f)
                                cubicTo(w * 0.50f, h * 0.96f, w * 0.25f, h * 0.85f, w * 0.10f, h * 0.65f)
                                close()
                            }

                            // Interior Area glow
                            drawPath(mandalPath, color = Color(0xFF006778).copy(alpha = 0.35f))
                            // Boundary Border
                            drawPath(
                                mandalPath,
                                color = Color(0xFF26A69A),
                                style = Stroke(
                                    width = 3.dp.toPx(),
                                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 10f), 0f)
                                )
                            )

                            // NH-40 Rayalaseema 4-Lane Highway
                            val highwayPath = Path().apply {
                                moveTo(w * 0.05f, h * 0.70f)
                                quadraticBezierTo(w * 0.45f, h * 0.48f, w * 0.95f, h * 0.28f)
                            }
                            drawPath(highwayPath, color = Color(0xFFFFB300), style = Stroke(width = 5.dp.toPx()))
                            drawPath(
                                highwayPath,
                                color = Color.White,
                                style = Stroke(
                                    width = 1.5.dp.toPx(),
                                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 8f), 0f)
                                )
                            )

                            // Solar Park Zone (Gani / Kalva) in North-East
                            drawCircle(color = Color(0xFFFFD54F).copy(alpha = 0.3f), radius = 28.dp.toPx(), center = Offset(w * 0.68f, h * 0.28f))
                            drawCircle(color = Color(0xFFFFC107), radius = 6.dp.toPx(), center = Offset(w * 0.68f, h * 0.28f))

                            // Kurnool Airport Runway (Uyyalawada)
                            val runwayStart = Offset(w * 0.32f, h * 0.42f)
                            val runwayEnd = Offset(w * 0.42f, h * 0.36f)
                            drawLine(color = Color(0xFF4FC3F7), start = runwayStart, end = runwayEnd, strokeWidth = 5.dp.toPx())
                            drawCircle(color = Color(0xFF0288D1), radius = 6.dp.toPx(), center = Offset(w * 0.37f, h * 0.39f))

                            // Rock Garden Landmark
                            drawCircle(color = Color(0xFFFF7043), radius = 6.dp.toPx(), center = Offset(w * 0.52f, h * 0.50f))

                            // Orvakal Mandal Headquarter Pin
                            drawCircle(color = Color.White, radius = 8.dp.toPx(), center = Offset(w * 0.48f, h * 0.48f))
                            drawCircle(color = Color(0xFFE53935), radius = 5.dp.toPx(), center = Offset(w * 0.48f, h * 0.48f))

                            // Palakolanu Village in South-East
                            drawCircle(color = Color(0xFF81C784), radius = 4.dp.toPx(), center = Offset(w * 0.70f, h * 0.72f))

                            // Kethavaram Caves in North-West
                            drawCircle(color = Color(0xFFBA68C8), radius = 4.dp.toPx(), center = Offset(w * 0.22f, h * 0.25f))
                        }

                        // Map Legend overlay (Localized)
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(8.dp)
                                .background(Color(0xFF001F26).copy(alpha = 0.85f), RoundedCornerShape(8.dp))
                                .padding(6.dp)
                        ) {
                            Text(tr("🔴 Orvakal HQ", "🔴 ఓర్వకల్లు హెడ్‌క్వార్టర్", "🔴 ओरवाकल मुख्यालय"), fontSize = 9.sp, color = Color.White, fontWeight = FontWeight.Bold)
                            Text(tr("✈️ Kurnool Airport (KJB)", "✈️ కర్నూలు విమానాశ్రయం", "✈️ कुरनूल हवाई अड्डा"), fontSize = 9.sp, color = Color(0xFF81D4FA))
                            Text(tr("☀️ 1000MW Solar Park", "☀️ 1000MW సోలార్ పార్క్", "☀️ 1000MW सौर पार्क"), fontSize = 9.sp, color = Color(0xFFFFD54F))
                            Text(tr("🛣️ NH-40 Expressway", "🛣️ NH-40 ఎక్స్‌ప్రెస్‌వే", "🛣️ NH-40 एक्सप्रेसवे"), fontSize = 9.sp, color = Color(0xFFFFD54F))
                            Text(tr("🪨 Rock Garden & Canyons", "🪨 రాక్ గార్డెన్ గుహలు", "🪨 रॉक गार्डन एवं घाटी"), fontSize = 9.sp, color = Color(0xFFFF8A65))
                        }

                        // Compass & Altitude badge
                        Column(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(8.dp)
                                .background(Color(0xFF001F26).copy(alpha = 0.85f), RoundedCornerShape(8.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            horizontalAlignment = Alignment.End
                        ) {
                            Text("▲ NORTH", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color(0xFF26A69A))
                            Text(tr("Elev: 360m MSL", "ఎత్తు: 360 మీ", "ऊंचाई: 360m MSL"), fontSize = 9.sp, color = Color(0xFFB0BEC5))
                            Text(tr("Area: 270.4 km²", "విస్తీర్ణం: 270.4 కి.మీ²", "क्षेत्र: 270.4 वर्ग किमी"), fontSize = 9.sp, color = Color(0xFFB0BEC5))
                        }
                    }
                }
            }
        }

        // Geographical Parameters & Terrain Card (Fully Localized)
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = tr(
                            en = "Geographical Parameters & Terrain",
                            te = "భౌగోళిక పారామితులు & భౌగోళిక స్వరూపం",
                            hi = "भौगोलिक मानक एवं भूभाग"
                        ),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF263238)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    val geoFacts = listOf(
                        Triple(
                            tr("Geographic Area", "మండల విస్తీర్ణం", "भौगोलिक क्षेत्रफल"),
                            tr("270.43 sq km (66,825 Acres)", "270.43 చ.కి.మీ (66,825 ఎకరాలు)", "270.43 वर्ग किमी (66,825 एकड़)"),
                            "🗺️"
                        ),
                        Triple(
                            tr("Elevation", "సముద్ర మట్టం నుండి ఎత్తు", "समुद्र तल से ऊंचाई"),
                            tr("360 meters (1,180 feet) MSL", "360 మీటర్లు (1,180 అడుగులు)", "360 मीटर (1,180 फीट) MSL"),
                            "⛰️"
                        ),
                        Triple(
                            tr("Coordinates", "అక్షాంశ, రేఖాంశాలు", "अक्षांश एवं देशांतर"),
                            "15°41'00\" N, 78°13'00\" E",
                            "🌐"
                        ),
                        Triple(
                            tr("District", "జిల్లా", "जिला"),
                            tr("Kurnool District, Andhra Pradesh", "కర్నూలు జిల్లా, ఆంధ్రప్రదేశ్", "कुरनूल जिला, आंध्र प्रदेश"),
                            "🏛️"
                        ),
                        Triple(
                            tr("Revenue Division", "రెవెన్యూ డివిజన్", "राजस्व मंडल"),
                            tr("Kurnool Division", "కర్నూలు డివిజన్", "कुरनूल मंडल"),
                            "🏢"
                        ),
                        Triple(
                            tr("Mandal HQ", "మండల ప్రధాన కేంద్రం", "मंडल मुख्यालय"),
                            tr("Orvakal Village (Pin: 518010)", "ఓర్వకల్లు గ్రామం (పిన్: 518010)", "ओरवाकल गांव (पिन: 518010)"),
                            "📍"
                        ),
                        Triple(
                            tr("Primary Highway", "ప్రధాన రహదారి", "मुख्य राजमार्ग"),
                            tr("NH-40 (Kurnool - Nandyal - Chennai)", "NH-40 (కర్నూలు - నంద్యాల - చెన్నై)", "NH-40 (कुरनूल - नंद्याल - चेन्नई)"),
                            "🛣️"
                        ),
                        Triple(
                            tr("Airport Distance", "విమానాశ్రయం దూరం", "हवाई अड्डा दूरी"),
                            tr("5.0 km to Kurnool Airport (KJB)", "5.0 కి.మీ (కర్నూలు ఎయిర్‌పోర్ట్ KJB)", "5.0 किमी (कुरनूल हवाई अड्डा KJB)"),
                            "✈️"
                        ),
                        Triple(
                            tr("Climate & Rain", "వాతావరణం & వర్షపాతం", "जलवायु एवं वर्षा"),
                            tr("Semi-arid tropical (Annual avg: 670 mm)", "అర్ధ-శుష్క ఉష్ణమండలం (సగటు: 670 మి.మీ)", "अर्ध-शुष्क उष्णकटिबंधीय (वार्षिक औसत: 670 मिमी)"),
                            "🌦️"
                        ),
                        Triple(
                            tr("Dominant Soil", "ప్రధాన నేలల రకాలు", "प्रमुख मिट्टी"),
                            tr("Black Cotton Soil & Red Sandy Loam", "నల్లరేగడి & ఎర్ర నేలలు", "काली कपास मिट्टी एवं लाल रेतीली दोमट"),
                            "🌱"
                        )
                    )

                    geoFacts.forEach { (label, value, icon) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFF5F9FA))
                                .padding(horizontal = 10.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(icon, fontSize = 14.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(label, fontSize = 12.sp, color = Color(0xFF546E7A))
                            }
                            Text(value, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                        }
                    }
                }
            }
        }

        // Data Source Attribution Card
        item { DataSourceAttributionCard() }
    }
}

// ═══════════════════════════════════════════════════════════════════════════
// TAB 2: CONSTITUENCY & LEADERS
// ═══════════════════════════════════════════════════════════════════════════
@Composable
private fun ConstituencyAndLeadersTab() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Policy Disclaimer Banner
        item { PlayStorePolicyDisclaimerBanner() }

        // Constituency Representation Card
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🗳️", fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = tr(
                                en = "Constituency Representation",
                                te = "శాసనసభ & లోక్‌సభ ప్రాతినిధ్యం",
                                hi = "विधानसभा एवं संसदीय प्रतिनिधित्व"
                            ),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF004D5A)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Assembly Constituency Card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2F1)),
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(Color(0xFF80CBC4)))
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = tr("Assembly Constituency", "శాసనసభ నియోజకవర్గం", "विधानसभा निर्वाचन क्षेत्र"),
                                    fontSize = 11.sp,
                                    color = Color(0xFF004D40)
                                )
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(Color(0xFF006778))
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text("AC No. 138", fontSize = 10.sp, color = Color.White, fontWeight = FontWeight.Bold)
                                }
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = tr(
                                    en = "Panyam Assembly Constituency (పాణ్యం)",
                                    te = "పాణ్యం అసెంబ్లీ నియోజకవర్గం (AC-138)",
                                    hi = "पाण्यम विधानसभा निर्वाचन क्षेत्र (AC-138)"
                                ),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFF004D5A)
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = tr(
                                    en = "Orvakal Mandal is one of the key segments of Panyam AC along with Panyam, Gadivemula, and Kallur.",
                                    te = "ఓర్వకల్లు మండలం పాణ్యం అసెంబ్లీ నియోజకవర్గంలో పాణ్యం, గడివేముల మరియు కల్లూరు మండలాలతో పాటు ప్రధాన భాగం.",
                                    hi = "ओरवाकल मंडल पाण्यम विधानसभा क्षेत्र के प्रमुख खंडों में से एक है।"
                                ),
                                fontSize = 11.sp,
                                color = Color(0xFF004D40)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Parliamentary Constituency Card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8EAF6)),
                        border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(Color(0xFF9FA8DA)))
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = tr("Lok Sabha Parliamentary Constituency", "లోక్‌సభ పార్లమెంటరీ నియోజకవర్గం", "लोकसभा संसदीय क्षेत्र"),
                                    fontSize = 11.sp,
                                    color = Color(0xFF1A237E)
                                )
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(Color(0xFF283593))
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text("PC No. 19", fontSize = 10.sp, color = Color.White, fontWeight = FontWeight.Bold)
                                }
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = tr(
                                    en = "Nandyal Lok Sabha Constituency (నంద్యాల)",
                                    te = "నంద్యాల లోక్‌సభ నియోజకవర్గం (PC-19)",
                                    hi = "नंद्याल लोकसभा निर्वाचन क्षेत्र (PC-19)"
                                ),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFF1A237E)
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = tr(
                                    en = "Orvakal mandal electors vote in the Nandyal parliamentary constituency general elections.",
                                    te = "ఓర్వకల్లు మండల ఓటర్లు నంద్యాల లోక్‌సభ సాధారణ ఎన్నికలలో ఓటు హక్కు వినియోగించుకుంటారు.",
                                    hi = "ओरवाकल मंडल के मतदाता नंद्याल लोकसभा निर्वाचन क्षेत्र में मतदान करते हैं।"
                                ),
                                fontSize = 11.sp,
                                color = Color(0xFF283593)
                            )
                        }
                    }
                }
            }
        }

        // Leaders Directory Card
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = tr(
                            en = "Elected Representatives & Administration",
                            te = "ప్రజాప్రతినిధులు & పాలనా యంత్రాంగం",
                            hi = "निर्वाचित प्रतिनिधि एवं प्रशासनिक अधिकारी"
                        ),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF263238)
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    val leaders = listOf(
                        LeaderItem(
                            tr("Chief Minister of Andhra Pradesh", "ఆంధ్రప్రదేశ్ ముఖ్యమంత్రి", "आंध्र प्रदेश के मुख्यमंत्री"),
                            tr("Sri Nara Chandrababu Naidu", "శ్రీ నారా చంద్రబాబు నాయుడు", "श्री नारा चंद्रबाबू नायडू"),
                            tr("Government of Andhra Pradesh", "ఆంధ్రప్రదేశ్ ప్రభుత్వం", "आंध्र प्रदेश सरकार"),
                            "🏛️",
                            Color(0xFFFFF3E0)
                        ),
                        LeaderItem(
                            tr("Member of Legislative Assembly (MLA)", "శాసనసభ్యురాలు (ఎమ్మెల్యే)", "विधानसभा सदस्य (विधायक)"),
                            tr("Smt. Gouru Charitha Reddy", "శ్రీమతి గౌరు చరితా రెడ్డి", "श्रीमती गौरु चरिता रेड्डी"),
                            tr("Panyam Assembly Constituency (NDA/TDP)", "పాణ్యం నియోజకవర్గం (ఎన్డీఏ/టిడిపి)", "पाण्यम विधानसभा क्षेत्र (एनडीए/टीडीपी)"),
                            "🗳️",
                            Color(0xFFE0F2F1)
                        ),
                        LeaderItem(
                            tr("Member of Parliament (MP)", "పార్లమెంట్ సభ్యురాలు (ఎంపీ)", "संसद सदस्य (सांसद)"),
                            tr("Dr. Byreddy Shabari", "డాక్టర్ బైరెడ్డి శబరి", "डॉ. बायरेड्डी शबरी"),
                            tr("Nandyal Lok Sabha Constituency (NDA/TDP)", "నంద్యాల లోక్‌సభ నియోజకవర్గం (ఎన్డీఏ/టిడిపి)", "नंद्याल लोकसभा क्षेत्र (एनडीए/टीडीपी)"),
                            "🇮🇳",
                            Color(0xFFE8EAF6)
                        ),
                        LeaderItem(
                            tr("District Collector & District Magistrate", "జిల్లా కలెక్టర్ & జిల్లా మేజిస్ట్రేట్", "जिला कलेक्टर एवं जिला मजिस्ट्रेट"),
                            tr("Sri P. Ranjit Basha, IAS", "శ్రీ పి. రంజిత్ బాషా, ఐఏఎస్", "श्री पी. रंजीत बाशा, आईएएस"),
                            tr("Kurnool District Administration", "కర్నూలు జిల్లా పరిపాలన యంత్రాంగం", "कुरनूल जिला प्रशासन"),
                            "🏢",
                            Color(0xFFF1F8E9)
                        ),
                        LeaderItem(
                            tr("Superintendent of Police (SP)", "జిల్లా ఎస్పీ (పోలీస్ సూపరింటెండెంట్)", "पुलिस अधीक्षक (एसपी)"),
                            tr("Sri G. Bindu Madhav, IPS", "శ్రీ జి. బిందు మాధవ్, ఐపీఎస్", "श्री जी. बिंदु माधव, आईपीएस"),
                            tr("Kurnool District Police", "కర్నూలు జిల్లా పోలీస్ విభాగం", "कुरनूल जिला पुलिस"),
                            "👮",
                            Color(0xFFFFEBEE)
                        ),
                        LeaderItem(
                            tr("Tahsildar / Executive Magistrate", "తహశీల్దార్ / ఎగ్జిక్యూటివ్ మేజిస్ట్రేట్", "तहसीलदार / कार्यपालक मजिस्ट्रेट"),
                            tr("Smt. P. Lakshmi Devi", "శ్రీమతి పి. లక్ష్మీదేవి", "श्रीमती पी. लक्ष्मी देवी"),
                            tr("Mandal Revenue Office (MRO), Orvakal", "మండల రెవెన్యూ కార్యాలయం, ఓర్వకల్లు", "मंडल राजस्व कार्यालय, ओरवाकल"),
                            "📜",
                            Color(0xFFFFF8E1)
                        ),
                        LeaderItem(
                            tr("Mandal Parishad Dev. Officer (MPDO)", "ఎంపీడీఓ (మండల పరిషత్ అభివృద్ధి అధికారి)", "मंडल परिषद विकास अधिकारी (एमपीडीओ)"),
                            tr("Sri K. Venkataswamy", "శ్రీ కె. వెంకటస్వామి", "श्री के. वेंकटस्वामी"),
                            tr("Mandal Praja Parishad Office, Orvakal", "మండల ప్రజా పరిషత్ కార్యాలయం, ఓర్వకల్లు", "मंडल प्रजा परिषद कार्यालय, ओरवाकल"),
                            "🌾",
                            Color(0xFFE0F7FA)
                        ),
                        LeaderItem(
                            tr("Station House Officer (SI of Police)", "ఎస్ఐ (సబ్-ఇన్‌స్పెక్టర్ ఆఫ్ పోలీస్)", "थाना प्रभारी (सब-इंस्पेक्टर)"),
                            tr("Sri M. Mallikarjuna", "శ్రీ ఎం. మల్లికార్జున", "श्री एम. मल्लिकार्जुन"),
                            tr("Orvakal Police Station (24/7 Desk)", "ఓర్వకల్లు పోలీస్ స్టేషన్", "ओरवाकल पुलिस स्टेशन"),
                            "🚔",
                            Color(0xFFEDE7F6)
                        )
                    )

                    leaders.forEach { leader ->
                        LeaderCardRow(leader = leader)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }

        // Data Source Attribution Card
        item { DataSourceAttributionCard() }
    }
}

data class LeaderItem(
    val designation: String,
    val name: String,
    val office: String,
    val icon: String,
    val bgColor: Color
)

@Composable
private fun LeaderCardRow(leader: LeaderItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(leader.bgColor)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(leader.icon, fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = leader.designation,
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF546E7A)
            )
            Text(
                text = leader.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF263238)
            )
            Text(
                text = leader.office,
                fontSize = 11.sp,
                color = Color(0xFF455A64)
            )
        }
    }
}

// ═══════════════════════════════════════════════════════════════════════════
// TAB 3: VILLAGES IN ORVAKAL MANDAL (ALL 23 VILLAGES)
// ═══════════════════════════════════════════════════════════════════════════
@Composable
private fun VillagesListTab(
    searchQuery: String,
    onSearchChange: (String) -> Unit
) {
    val filteredVillages = remember(searchQuery) {
        if (searchQuery.isBlank()) {
            orvakalVillages
        } else {
            orvakalVillages.filter {
                it.nameEn.contains(searchQuery, ignoreCase = true) ||
                it.nameTe.contains(searchQuery, ignoreCase = true) ||
                it.nameHi.contains(searchQuery, ignoreCase = true) ||
                it.tagEn.contains(searchQuery, ignoreCase = true) ||
                it.tagTe.contains(searchQuery, ignoreCase = true) ||
                it.highlightsEn.contains(searchQuery, ignoreCase = true) ||
                it.highlightsTe.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Policy Disclaimer Banner
        item { PlayStorePolicyDisclaimerBanner() }

        // Summary & Search Card
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = tr(
                                    en = "Villages in Orvakal Mandal",
                                    te = "ఓర్వకల్లు మండలంలోని గ్రామాలు",
                                    hi = "ओरवाकल मंडल के गांव"
                                ),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF004D5A)
                            )
                            Text(
                                text = tr(
                                    en = "23 Gram Panchayats & Revenue Settlements",
                                    te = "23 గ్రామ పంచాయతీలు & రెవెన్యూ గ్రామాలు",
                                    hi = "23 ग्राम पंचायतें एवं राजस्व गांव"
                                ),
                                fontSize = 11.sp,
                                color = Color(0xFF78909C)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFF006778))
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = tr("Total: 23", "మొత్తం: 23", "कुल: 23"),
                                color = Color.White,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = onSearchChange,
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = tr(
                                    en = "Search village name or landmark...",
                                    te = "గ్రామం పేరు లేదా ప్రాంతాన్ని వెతకండి...",
                                    hi = "गांव का नाम या स्थान खोजें..."
                                ),
                                fontSize = 12.sp
                            )
                        },
                        leadingIcon = {
                            Icon(Icons.Filled.Search, contentDescription = null, tint = Color(0xFF006778))
                        },
                        shape = RoundedCornerShape(10.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFF5F9FA),
                            unfocusedContainerColor = Color(0xFFF5F9FA),
                            focusedBorderColor = Color(0xFF006778),
                            unfocusedBorderColor = Color(0xFFCFD8DC)
                        ),
                        singleLine = true
                    )
                }
            }
        }

        // List of Villages
        items(filteredVillages) { village ->
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (village.id == 1) Color(0xFFE0F2F1) else Color.White
                ),
                border = if (village.id == 1) CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(Color(0xFF80CBC4))) else null
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
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .background(if (village.id == 1) Color(0xFF006778) else Color(0xFFF0F4F6)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${village.id}",
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (village.id == 1) Color.White else Color(0xFF37474F)
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = village.localizedName(),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF263238)
                                    )
                                    if (LanguageManager.currentLanguage != AppLanguage.EN) {
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "(${village.nameEn})",
                                            fontSize = 11.sp,
                                            color = Color(0xFF78909C)
                                        )
                                    } else {
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = "(${village.nameTe})",
                                            fontSize = 12.sp,
                                            color = Color(0xFF006778),
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                }
                                Text(
                                    text = village.localizedTag(),
                                    fontSize = 11.sp,
                                    color = Color(0xFF00695C),
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFFE8F5E9))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(village.distanceKm, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = village.localizedHighlights(),
                        fontSize = 11.sp,
                        color = Color(0xFF546E7A),
                        lineHeight = 15.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = tr(
                                en = "Est. Population: ${village.population}",
                                te = "అంచనా జనాభా: ${village.population}",
                                hi = "अनुमानित जनसंख्या: ${village.population}"
                            ),
                            fontSize = 10.sp,
                            color = Color(0xFF78909C),
                            fontWeight = FontWeight.Medium
                        )
                        if (village.id == 1) {
                            Text(
                                text = tr("⭐ Mandal Headquarter", "⭐ మండల ప్రధాన కేంద్రం", "⭐ मंडल मुख्यालय"),
                                fontSize = 10.sp,
                                color = Color(0xFFD84315),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        // Data Source Attribution Card
        item { DataSourceAttributionCard() }
    }
}

// ═══════════════════════════════════════════════════════════════════════════
// TAB 4: DEMOGRAPHICS & VOTER STATISTICS
// ═══════════════════════════════════════════════════════════════════════════
@Composable
private fun DemographicsTab() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Policy Disclaimer Banner
        item { PlayStorePolicyDisclaimerBanner() }

        // Population Overview
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("👥", fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = tr(
                                en = "Total Population Statistics",
                                te = "మొత్తం జనాభా గణాంకాలు",
                                hi = "कुल जनसंख्या सांख्यिकी"
                            ),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF004D5A)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        StatTile(
                            title = tr("Total Population", "మొత్తం జనాభా", "कुल जनसंख्या"),
                            value = "45,620",
                            subtext = tr("2011 Census: 40,759", "2011 సెన్సస్: 40,759", "2011 जनगणना: 40,759"),
                            bgColor = Color(0xFFE0F2F1),
                            textColor = Color(0xFF004D5A),
                            modifier = Modifier.weight(1f)
                        )
                        StatTile(
                            title = tr("Households", "గృహాల సంఖ్య", "परिवार संख्या"),
                            value = "9,850",
                            subtext = tr("Across 23 Panchayats", "23 పంచాయతీలలో", "23 पंचायतों में"),
                            bgColor = Color(0xFFE8F5E9),
                            textColor = Color(0xFF1B5E20),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        StatTile(
                            title = tr("Male Population", "పురుషుల జనాభా", "पुरुष जनसंख्या"),
                            value = "23,180",
                            subtext = tr("50.8% of total", "మొత్తంలో 50.8%", "कुल का 50.8%"),
                            bgColor = Color(0xFFE3F2FD),
                            textColor = Color(0xFF0D47A1),
                            modifier = Modifier.weight(1f)
                        )
                        StatTile(
                            title = tr("Female Population", "స్త్రీల జనాభా", "महिला जनसंख्या"),
                            value = "22,440",
                            subtext = tr("49.2% (Sex ratio: 968)", "49.2% (లింగ నిష్పత్తి: 968)", "49.2% (लिंगानुपात: 968)"),
                            bgColor = Color(0xFFFCE4EC),
                            textColor = Color(0xFF880E4F),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        // Voter Electorate Statistics
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("🗳️", fontSize = 20.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = tr(
                                    en = "Voters Count & Electorate",
                                    te = "ఓటర్ల సంఖ్య & పోలింగ్ వివరాలు",
                                    hi = "मतदाता संख्या एवं निर्वाचन"
                                ),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF263238)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color(0xFFE8EAF6))
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text(
                                text = tr("42 Polling Stations", "42 పోలింగ్ కేంద్రాలు", "42 मतदान केंद्र"),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF283593)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        StatTile(
                            title = tr("Total Registered Voters", "మొత్తం రిజిస్టర్డ్ ఓటర్లు", "कुल पंजीकृत मतदाता"),
                            value = "36,840",
                            subtext = tr("Electorate Count", "మొత్తం ఓటర్ల సంఖ్య", "मतदाता सूची संख्या"),
                            bgColor = Color(0xFFFFF8E1),
                            textColor = Color(0xFFE65100),
                            modifier = Modifier.weight(1f)
                        )
                        StatTile(
                            title = tr("Polling Booths", "పోలింగ్ కేంద్రాలు", "मतदान बूथ"),
                            value = "42 Booths",
                            subtext = tr("Across 23 Villages", "23 గ్రామాల పరిధిలో", "23 गांवों में"),
                            bgColor = Color(0xFFF3E5F5),
                            textColor = Color(0xFF4A148C),
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        StatTile(
                            title = tr("Male Voters", "పురుష ఓటర్లు", "पुरुष मतदाता"),
                            value = "18,320",
                            subtext = tr("49.7% of electorate", "49.7% ఓటర్లు", "49.7% मतदाता"),
                            bgColor = Color(0xFFE1F5FE),
                            textColor = Color(0xFF0277BD),
                            modifier = Modifier.weight(1f)
                        )
                        StatTile(
                            title = tr("Female Voters", "మహిళా ఓటర్లు", "महिला मतदाता"),
                            value = "18,520",
                            subtext = tr("50.3% (Voter ratio: 1010)", "50.3% (ఓటర్ నిష్పత్తి: 1010)", "50.3% (मतदाता अनुपात: 1010)"),
                            bgColor = Color(0xFFF8BBD0),
                            textColor = Color(0xFFC2185B),
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }

        // Literacy & Occupational Profile
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = tr(
                            en = "Literacy & Socio-Economic Profile",
                            te = "అక్షరాస్యత & సామాజిక-ఆర్థిక వివరాలు",
                            hi = "साक्षरता एवं सामाजिक-आर्थिक प्रोफाइल"
                        ),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF263238)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    val socioFacts = listOf(
                        Triple(
                            tr("Overall Literacy Rate", "మొత్తం అక్షరాస్యత రేటు", "कुल साक्षरता दर"),
                            tr("61.5% (~25,000 Literates)", "61.5% (~25,000 మంది అక్షరాస్యులు)", "61.5% (~25,000 साक्षर)"),
                            "📖"
                        ),
                        Triple(
                            tr("Male Literacy", "పురుషుల అక్షరాస్యత", "पुरुष साक्षरता"),
                            "72.8%",
                            "👨‍🎓"
                        ),
                        Triple(
                            tr("Female Literacy", "మహిళల అక్షరాస్యత", "महिला साक्षरता"),
                            "49.8%",
                            "👩‍🎓"
                        ),
                        Triple(
                            tr("Primary Occupation", "ప్రధాన జీవనోపాధి", "मुख्य व्यवसाय"),
                            tr("Agriculture & Farming (64%)", "వ్యవసాయం & పాడిపరిశ్రమ (64%)", "कृषि एवं खेती (64%)"),
                            "🌾"
                        ),
                        Triple(
                            tr("Industrial & Technical", "పారిశ్రామిక & సాంకేతిక", "औद्योगिक एवं तकनीकी"),
                            tr("Solar Park & Factory Workers (18%)", "సోలార్ పార్క్ & కర్మాగారాల కార్మికులు (18%)", "सौर पार्क एवं कारखाना श्रमिक (18%)"),
                            "🏭"
                        ),
                        Triple(
                            tr("Services & Commerce", "సేవారంగం & వాణిజ్యం", "सेवाएं एवं व्यापार"),
                            tr("Retail, Transport & Small Business (18%)", "చిల్లర వర్తకం, రవాణా & వ్యాపారం (18%)", "व्यापार, परिवहन एवं छोटे उद्यम (18%)"),
                            "🚚"
                        ),
                        Triple(
                            tr("Scheduled Castes (SC)", "షెడ్యూల్డ్ కులాలు (SC)", "अनुसूचित जाति (SC)"),
                            tr("21.4% of total population", "మొత్తం జనాభాలో 21.4%", "कुल जनसंख्या का 21.4%"),
                            "🤝"
                        ),
                        Triple(
                            tr("Scheduled Tribes (ST)", "షెడ్యూల్డ్ తెగలు (ST)", "अनुसूचित जनजाति (ST)"),
                            tr("3.8% of total population", "మొత్తం జనాభాలో 3.8%", "कुल जनसंख्या का 3.8%"),
                            "⛰️"
                        )
                    )

                    socioFacts.forEach { (label, value, icon) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 3.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFF5F9FA))
                                .padding(horizontal = 10.dp, vertical = 7.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(icon, fontSize = 13.sp)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(label, fontSize = 12.sp, color = Color(0xFF546E7A))
                            }
                            Text(value, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
                        }
                    }
                }
            }
        }

        // Data Source Attribution Card
        item { DataSourceAttributionCard() }
    }
}

@Composable
private fun StatTile(
    title: String,
    value: String,
    subtext: String,
    bgColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = bgColor)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(title, fontSize = 11.sp, color = textColor.copy(alpha = 0.8f), fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(2.dp))
            Text(value, fontSize = 18.sp, fontWeight = FontWeight.Black, color = textColor)
            Spacer(modifier = Modifier.height(2.dp))
            Text(subtext, fontSize = 10.sp, color = textColor.copy(alpha = 0.7f))
        }
    }
}
