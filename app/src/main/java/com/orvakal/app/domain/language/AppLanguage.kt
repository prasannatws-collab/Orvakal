package com.orvakal.app.domain.language

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

enum class AppLanguage(val code: String, val label: String) {
    EN("EN", "English"),
    TE("TE", "తెలుగు"),
    HI("HI", "हिंदी")
}

object LanguageManager {
    var currentLanguage by mutableStateOf(AppLanguage.EN)

    fun setLanguage(lang: AppLanguage) {
        currentLanguage = lang
    }

    fun setLanguageByCode(code: String) {
        currentLanguage = when (code.uppercase()) {
            "TE" -> AppLanguage.TE
            "HI" -> AppLanguage.HI
            else -> AppLanguage.EN
        }
    }
}

object AppStrings {
    val portalTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "ORVAKAL"
            AppLanguage.TE -> "ఓర్వకల్లు"
            AppLanguage.HI -> "ओरवाकल"
        }

    val portalSubtitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Village & Smart Digital Hub"
            AppLanguage.TE -> "గ్రామీణ & స్మార్ట్ డిజిటల్ హబ్"
            AppLanguage.HI -> "ग्रामीण और स्मार्ट डिजिटल हब"
        }

    val dashboard: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Dashboard"
            AppLanguage.TE -> "హోమ్"
            AppLanguage.HI -> "डैशबोर्ड"
        }

    // Navigation Tabs
    val navHome: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Home"
            AppLanguage.TE -> "హోమ్"
            AppLanguage.HI -> "होम"
        }

    val navGovtInfo: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Public Services"
            AppLanguage.TE -> "ప్రజా సేవలు"
            AppLanguage.HI -> "सार्वजनिक सेवाएं"
        }

    val navFarmer: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Farmer"
            AppLanguage.TE -> "రైతు"
            AppLanguage.HI -> "किसान"
        }

    val navServices: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Explore"
            AppLanguage.TE -> "అన్వేషణ"
            AppLanguage.HI -> "एक्सप्लोर"
        }

    val navJobs: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Jobs"
            AppLanguage.TE -> "ఉద్యోగాలు"
            AppLanguage.HI -> "रोजगार"
        }

    // Home Screen
    val searchPlaceholder: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Search services, shops, locations..."
            AppLanguage.TE -> "సేవలు, దుకాణాలు, చిరునామాలు వెతకండి..."
            AppLanguage.HI -> "सेवाएं, दुकानें, स्थान खोजें..."
        }

    val emergencySos: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "EMERGENCY SOS HOTLINES"
            AppLanguage.TE -> "అత్యవసర సహాయ హాట్‌లైన్లు"
            AppLanguage.HI -> "आपातकालीन एसओएस हेल्पलाइन"
        }

    val getHelp: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "GET HELP"
            AppLanguage.TE -> "సహాయం"
            AppLanguage.HI -> "मदद लें"
        }

    val liveBadge: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "LIVE"
            AppLanguage.TE -> "ప్రత్యక్షం"
            AppLanguage.HI -> "लाइव"
        }

    val bannerDesc: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Andhra Pradesh's fast-growing mega industrial hub. Solar parks, flight transit & agri services at your fingertips."
            AppLanguage.TE -> "ఆంధ్రప్రదేశ్‌లో వేగంగా ఎదుగుతున్న మెగా పారిశ్రామిక హబ్. సోలార్ పార్కులు, విమాన ప్రయాణం & వ్యవసాయ సేవలు మీ వేలికొనలపై."
            AppLanguage.HI -> "आंध्र प्रदेश का तेजी से बढ़ता मेगा औद्योगिक केंद्र। सौर पार्क, उड़ान पारगमन और कृषि सेवाएं आपकी उंगलियों पर।"
        }

    val activePanchayat: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Active Panchayat"
            AppLanguage.TE -> "చురుకైన పంచాయతీ"
            AppLanguage.HI -> "सक्रिय पंचायत"
        }

    val airportKjb: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Airport KJB"
            AppLanguage.TE -> "విమానాశ్రయం KJB"
            AppLanguage.HI -> "हवाई अड्डा KJB"
        }

    val overcast: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Overcast"
            AppLanguage.TE -> "మేఘావృతం"
            AppLanguage.HI -> "बादल"
        }

    val localTime: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "LOCAL TIME"
            AppLanguage.TE -> "స్థానిక సమయం"
            AppLanguage.HI -> "स्थानीय समय"
        }

    val investorCardTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Orvakal Industrial Hub Insights"
            AppLanguage.TE -> "ఓర్వకల్లు పారిశ్రామిక హబ్ సమాచారం"
            AppLanguage.HI -> "ओरवाकल औद्योगिक हब इनसाइट्स"
        }

    val investorZone: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "INVESTOR ZONE"
            AppLanguage.TE -> "పెట్టుబడిదారుల జోన్"
            AppLanguage.HI -> "निवेशक क्षेत्र"
        }

    val exploreMandalProfile: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Explore Mandal Profile ℹ️"
            AppLanguage.TE -> "మండల సమగ్ర సమాచారం ℹ️"
            AppLanguage.HI -> "मंडल प्रोफाइल देखें ℹ️"
        }

    val mandalInfoHint: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Geography, Leaders & 23 Villages"
            AppLanguage.TE -> "భౌగోళికం, నాయకులు & 23 గ్రామాలు"
            AppLanguage.HI -> "भूगोल, नेता एवं 23 गांव"
        }

    val quickRecTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Quick Links"
            AppLanguage.TE -> "త్వరిత లింకులు"
            AppLanguage.HI -> "त्वरित लिंक"
        }

    val selectPersona: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Select a persona to navigate:"
            AppLanguage.TE -> "వర్గాన్ని ఎంచుకోండి:"
            AppLanguage.HI -> "श्रेणी चुनें:"
        }

    // Personas
    val personaFarmer: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Farmer"
            AppLanguage.TE -> "రైతు"
            AppLanguage.HI -> "किसान"
        }

    val personaStudent: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Student"
            AppLanguage.TE -> "విద్యార్థి"
            AppLanguage.HI -> "छात्र"
        }

    val personaVillager: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Villager"
            AppLanguage.TE -> "గ్రామస్థుడు"
            AppLanguage.HI -> "ग्रामीण"
        }

    val personaVisitor: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Visitor"
            AppLanguage.TE -> "సందర్శకుడు"
            AppLanguage.HI -> "पर्यटक"
        }

    val personaOfficials: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Officials"
            AppLanguage.TE -> "అధికారులు"
            AppLanguage.HI -> "अधिकारी"
        }

    // Quick Tiles
    val emergency: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Emergency"
            AppLanguage.TE -> "అత్యవసరం"
            AppLanguage.HI -> "आपातकाल"
        }

    val transport: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Transport"
            AppLanguage.TE -> "రవాణా"
            AppLanguage.HI -> "परिवहन"
        }

    val hotelStays: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Hotel Stays"
            AppLanguage.TE -> "హోటల్ బస"
            AppLanguage.HI -> "होटल / स्टे"
        }

    val villageCommittees: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Village Committees"
            AppLanguage.TE -> "గ్రామ కమిటీలు"
            AppLanguage.HI -> "ग्राम समितियां"
        }

    val searchJobs: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Search Jobs"
            AppLanguage.TE -> "ఉద్యోగాలు"
            AppLanguage.HI -> "रोजगार खोजें"
        }

    val mandiRates: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Mandi Rates"
            AppLanguage.TE -> "మార్కెట్ ధరలు"
            AppLanguage.HI -> "मंडी भाव"
        }

    val govtSchemes: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Govt Schemes"
            AppLanguage.TE -> "ప్రభుత్వ పథకాలు"
            AppLanguage.HI -> "सरकारी योजनाएं"
        }

    val govtOffices: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Govt Offices"
            AppLanguage.TE -> "ప్రభుత్వ ఆఫీసులు"
            AppLanguage.HI -> "सरकारी दफ्तर"
        }

    // Utilities
    val dailyUtilities: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Utilities"
            AppLanguage.TE -> "ఉపయోగాలు"
            AppLanguage.HI -> "उपयोगिताएं"
        }

    val handyTools: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Handy tools for everyday use"
            AppLanguage.TE -> "గ్రామీణ అవసరాల కోసం సాధనాలు"
            AppLanguage.HI -> "दैनिक उपयोग के आसान उपकरण"
        }

    val interestCalc: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Interest Calculator"
            AppLanguage.TE -> "వడ్డీ కాలిక్యులేటర్"
            AppLanguage.HI -> "ब्याज कैलकुलेटर"
        }

    val unitConv: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Unit Conv"
            AppLanguage.TE -> "భూమి కొలతలు"
            AppLanguage.HI -> "भूमि माप परिवर्तक"
        }

    val stopwatchTimer: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Stopwatch & Timer"
            AppLanguage.TE -> "పంపు టైమర్"
            AppLanguage.HI -> "स्टॉपवॉच व टाइमर"
        }

    val moreTools: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "More Tools"
            AppLanguage.TE -> "మరిన్ని సాధనాలు"
            AppLanguage.HI -> "अन्य उपकरण"
        }

    val noticeBoard: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "NOTICE BOARD"
            AppLanguage.TE -> "సమాచార పలక"
            AppLanguage.HI -> "सूचना पट्ट"
        }

    // Screen Titles
    val govtInfoTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Public Services"
            AppLanguage.TE -> "ప్రజా సేవలు"
            AppLanguage.HI -> "सार्वजनिक सेवाएं"
        }

    val farmerDeskTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Farmer Desk"
            AppLanguage.TE -> "రైతు డెస్క్"
            AppLanguage.HI -> "किसान डेस्क"
        }

    val servicesCatalogTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Explore Orvakal"
            AppLanguage.TE -> "ఓర్వకల్లు అన్వేషణ"
            AppLanguage.HI -> "ओरवाकल एक्सप्लोर"
        }

    val jobsCommerceTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Jobs & Commerce"
            AppLanguage.TE -> "ఉద్యోగాలు & పరిశ్రమలు"
            AppLanguage.HI -> "रोजगार एवं वाणिज्य"
        }

    val tabJobBoard: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Job Board"
            AppLanguage.TE -> "ఉద్యోగ బోర్డు"
            AppLanguage.HI -> "जॉब बोर्ड"
        }

    val tabLabourRegistry: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Labour Registry"
            AppLanguage.TE -> "శ్రామిక నమోదు"
            AppLanguage.HI -> "श्रम पंजीयन"
        }

    val tabMegaIndustries: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Mega Industries"
            AppLanguage.TE -> "మెగా పరిశ్రమలు"
            AppLanguage.HI -> "मेगा उद्योग"
        }

    val viewIndustryDesk: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "View Industry Desk Details"
            AppLanguage.TE -> "పరిశ్రమ వివరాలు చూడండి"
            AppLanguage.HI -> "उद्योग विवरण देखें"
        }

    val searchSectorPlaceholder: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Search factory sector..."
            AppLanguage.TE -> "పరిశ్రమ విభాగాన్ని వెతకండి..."
            AppLanguage.HI -> "उद्योग क्षेत्र खोजें..."
        }

    // Schemes strings
    val schemesPortalTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Government & Financial Schemes"
            AppLanguage.TE -> "ప్రభుత్వ & ఆర్థిక పథకాలు"
            AppLanguage.HI -> "सरकारी और वित्तीय योजनाएं"
        }

    val allSchemesTab: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "All"
            AppLanguage.TE -> "అన్నీ"
            AppLanguage.HI -> "सभी"
        }

    val stateGovtTab: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "AP State Govt"
            AppLanguage.TE -> "ఆంధ్రప్రదేశ్ ప్రభుత్వం"
            AppLanguage.HI -> "आंध्र प्रदेश सरकार"
        }

    val centralGovtTab: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Central Govt"
            AppLanguage.TE -> "కేంద్ర ప్రభుత్వం"
            AppLanguage.HI -> "केंद्र सरकार"
        }

    val bankSchemesTab: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Bank Loans"
            AppLanguage.TE -> "బ్యాంకు రుణాలు"
            AppLanguage.HI -> "बैंक ऋण"
        }

    val postalSchemesTab: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Post Office"
            AppLanguage.TE -> "పోస్టల్ పథకాలు"
            AppLanguage.HI -> "डाक योजनाएं"
        }

    val searchSchemesPlaceholder: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Search by scheme name, benefits, keywords..."
            AppLanguage.TE -> "పథకం పేరు, ప్రయోజనాలు, అర్హత వెతకండి..."
            AppLanguage.HI -> "योजना का नाम, लाभ, पात्रता खोजें..."
        }

    val schemeBenefits: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Benefits & Financial Assistance"
            AppLanguage.TE -> "ప్రయోజనాలు & ఆర్థిక సహాయం"
            AppLanguage.HI -> "लाभ और वित्तीय सहायता"
        }

    val schemeEligibility: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Eligibility Criteria"
            AppLanguage.TE -> "అర్హత నిబంధనలు"
            AppLanguage.HI -> "पात्रता मानदंड"
        }

    val schemeHowToApply: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "How to Apply / Process"
            AppLanguage.TE -> "దరఖాస్తు విధానం / ప్రక్రియ"
            AppLanguage.HI -> "आवेदन प्रक्रिया"
        }

    // Google Play Policy Disclaimers & Privacy
    val civicDisclaimerTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Public Civic & Government Disclaimer"
            AppLanguage.TE -> "ప్రజాసేవ & ప్రభుత్వ సమాచార ప్రకటన"
            AppLanguage.HI -> "नागरिक सूचना एवं सरकारी अस्वीकरण"
        }

    val civicDisclaimerBody: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Orvakal: Village & Smart Digital Hub is an independent community initiative developed for informational purposes. This application is NOT affiliated with, authorized by, endorsed by, or representing any government entity or political organisation. Public schemes, helplines, and government data are referenced from official public websites."
            AppLanguage.TE -> "ఓర్వకల్లు: గ్రామీణ & స్మార్ట్ డిజిటల్ హబ్ అనేది ప్రజల సమాచార అవసరాల కోసం రూపొందించబడిన స్వతంత్ర సమాచార వేదిక. ఈ యాప్‌కు ఏ ప్రభుత్వ శాఖతోనూ ప్రత్యక్ష అనుబంధం లేదా ప్రాతినిధ్యం లేదు. ప్రభుత్వ పథకాలు, హెల్ప్‌లైన్లు మరియు పౌర సమాచారం అధికారిక పబ్లిక్ పోర్టల్స్ నుండి మాత్రమే సేకరించబడ్డాయి."
            AppLanguage.HI -> "ओरवाकल: विलेज और स्मार्ट डिजिटल हब एक स्वतंत्र सामुदायिक सूचना ऐप है। यह एप्लिकेशन किसी भी सरकारी विभाग या संस्था से संबद्ध, अधिकृत या उनका आधिकारिक प्रतिनिधि नहीं है। सरकारी योजनाएं, हेल्पलाइन और नागरिक डेटा आधिकारिक सार्वजनिक पोर्टलों से प्राप्त किए गए हैं।"
        }

    val viewPrivacyPolicy: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Privacy Policy & Disclaimers"
            AppLanguage.TE -> "గోప్యతా విధానం & నిబంధనలు"
            AppLanguage.HI -> "गोपनीयता नीति एवं अस्वीकरण"
        }

    // New Health & Medical Action Buttons
    val phcTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Primary Health Center (PHC)"
            AppLanguage.TE -> "ప్రాథమిక ఆరోగ్య కేంద్రం (PHC)"
            AppLanguage.HI -> "प्राथमिक स्वास्थ्य केंद्र (PHC)"
        }

    val phcSubtitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "24/7 Emergency & OPD ↗"
            AppLanguage.TE -> "24/7 అత్యవసర సేవలు & ఓపీడీ ↗"
            AppLanguage.HI -> "24/7 आपातकालीन एवं ओपीडी ↗"
        }

    val medicalStoresTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Medical Stores & Chemist"
            AppLanguage.TE -> "మెడికల్ స్టోర్స్ & మందులు"
            AppLanguage.HI -> "मेडिकल स्टोर्स एवं फार्मेसी"
        }

    val medicalStoresSubtitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Pharmacies & Medicines ↗"
            AppLanguage.TE -> "స్థానిక మందుల దుకాణాలు ↗"
            AppLanguage.HI -> "दवाइयां एवं केमिस्ट ↗"
        }

    // Picture Gallery
    val pictureGalleryTitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Scenic & Heritage Gallery"
            AppLanguage.TE -> "దర్శనీయ ప్రదేశాల ఫొటో గ్యాలరీ"
            AppLanguage.HI -> "दर्शनीय स्थल एवं चित्र वीथिका"
        }

    val pictureGallerySubtitle: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Orvakal Rock Garden & Kethavaram Prehistoric Art"
            AppLanguage.TE -> "ఓర్వకల్లు రాతి ఉద్యానవనం & కేతవరం పురాతన శైల చిత్రాలు"
            AppLanguage.HI -> "ओरवाकल रॉक गार्डन एवं केतवरम प्राचीन शैल चित्र"
        }

    val openInMaps: String
        get() = when (LanguageManager.currentLanguage) {
            AppLanguage.EN -> "Open in Google Maps ↗"
            AppLanguage.TE -> "గూగుల్ మ్యాప్స్‌లో చూడండి ↗"
            AppLanguage.HI -> "गूगल मैप्स में देखें ↗"
        }
}
