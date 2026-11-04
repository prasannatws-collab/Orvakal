package com.orvakal.app.data.local

import com.orvakal.app.domain.model.CatalogCategory
import com.orvakal.app.domain.model.CropAdvisoryItem
import com.orvakal.app.domain.model.Industry
import com.orvakal.app.domain.model.LocalEntity
import com.orvakal.app.domain.model.LocalizedText
import com.orvakal.app.domain.model.MachineryRentItem
import com.orvakal.app.domain.model.MandiCropRate
import com.orvakal.app.domain.model.MspRateItem
import com.orvakal.app.domain.model.PowerFeederInfo
import com.orvakal.app.domain.model.TransportInfo

object OrvakalData {

    val allEntities: List<LocalEntity> = listOf(
        // Medical stores
        LocalEntity(
            id = 1,
            category = "medical_stores",
            name = "Sri Sri Medicals & General Stores",
            nameTe = "శ్రీ శ్రీ మెడికల్స్ & జనరల్ స్టోర్స్",
            nameHi = "श्री श्री मेडिकल्स एंड जनरल स्टोर्स",
            address = "Near Bus Stand, beside MR Mechanic, Orvakal, Kurnool, Andhra Pradesh 518010",
            addressTe = "బస్టాండ్ దగ్గర, MR మెకానిక్ పక్కన, ఓర్వకల్లు, కర్నూలు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "बस स्टैंड के पास, एमआर मैकेनिक के बगल में, ओरवाकल, कर्नूल, आंध्र प्रदेश 518010",
            timings = "7 am–9 pm",
            timingsTe = "ఉదయం 7 నుండి రాత్రి 9 వరకు",
            timingsHi = "सुबह 7 बजे से रात 9 बजे तक",
            description = "All essential prescription medicines, generic drugs, and daily healthcare supplies available.",
            descTe = "అన్ని రకాల ప్రాణరక్షక మందులు, జనరిక్ టాబ్లెట్లు మరియు నిత్యావసర హెల్త్ కేర్ ఉత్పత్తులు లభించును.",
            descHi = "सभी आवश्यक जीवन रक्षक दवाएं, जेनेरिक दवाएं और दैनिक स्वास्थ्य उत्पाद उपलब्ध हैं।",
            icon = "💊"
        ),
        LocalEntity(
            id = 2,
            category = "medical_stores",
            name = "Mohan Medical & General Stores",
            nameTe = "మోహన్ మెడికల్ & జనరల్ స్టోర్స్",
            nameHi = "मोहन मेडिकल एंड जनरल स्टोर्स",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            addressTe = "మెయిన్ బజార్, ప్రధాన మార్గం, ఓర్వకల్లు, కర్నూలు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "मेन बाज़ार, मुख्य मार्ग, ओरवाकल, कर्नूल, आंध्र प्रदेश 518010",
            timings = "7 am–9 pm",
            timingsTe = "ఉదయం 7 నుండి రాత్రి 9 వరకు",
            timingsHi = "सुबह 7 बजे से रात 9 बजे तक",
            description = "Reliable pharmacy in Main Bazar providing quality medicines, baby care, and first-aid supplies.",
            descTe = "మెయిన్ బజార్‌లోని నమ్మకమైన మెడికల్ షాపు, శిశు సంరక్షణ ఉత్పత్తులు మరియు ప్రథమ చికిత్స మందులు.",
            descHi = "मेन बाज़ार में विश्वसनीय फ़ार्मेसी, गुणवत्तापूर्ण दवाएं और प्राथमिक चिकित्सा सामग्री।",
            icon = "💊"
        ),
        LocalEntity(
            id = 3,
            category = "medical_stores",
            name = "Chennakesava Medical Stores",
            nameTe = "చెన్నకేశవ మెడికల్ స్టోర్స్",
            nameHi = "चेन्नकेशव मेडिकल स्टोर्स",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            addressTe = "మెయిన్ బజార్, ప్రధాన రహదారి, ఓర్వకల్లు, కర్నూలు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "मेन बाज़ार, मुख्य मार्ग, ओरवाकल, कर्नूल, आंध्र प्रदेश 518010",
            timings = "7 am–9 pm",
            timingsTe = "ఉదయం 7 నుండి రాత్రి 9 వరకు",
            timingsHi = "सुबह 7 बजे से रात 9 बजे तक",
            description = "Trusted medical store for branded formulations, OTC medicines, and health tonics.",
            descTe = "బ్రాండెడ్ మందులు, ఓటీసీ మాత్రలు మరియు హెల్త్ టానిక్‌ల విశ్వసనీయ దుకాణం.",
            descHi = "ब्रांडेड दवाएं, ओटीसी दवाएं और स्वास्थ्य टॉनिक की विश्वसनीय दुकान।",
            icon = "💊"
        ),
        LocalEntity(
            id = 4,
            category = "medical_stores",
            name = "Karthik Medical & General Stores",
            nameTe = "కార్తీక్ మెడికల్ & జనరల్ స్టోర్స్",
            nameHi = "कार्तिक मेडिकल एंड जनरल स्टोर्स",
            address = "M5PG+583, Main Bazar Road, Orvakal, Andhra Pradesh 518010",
            addressTe = "M5PG+583, మెయిన్ బజార్ రోడ్డు, ఓర్వకల్లు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "M5PG+583, मेन बाज़ार रोड, ओरवाकल, आंध्र प्रदेश 518010",
            timings = "8 am–9 pm",
            timingsTe = "ఉదయం 8 నుండి రాత్రి 9 వరకు",
            timingsHi = "सुबह 8 बजे से रात 9 बजे तक",
            description = "Comprehensive drug store catering to prescriptions, vitamins, and healthcare essentials.",
            descTe = "ప్రిస్క్రిప్షన్ మందులు, విటమిన్లు మరియు ఆరోగ్య సంరక్షణ ఉత్పత్తుల పూర్తి దుకాణం.",
            descHi = "पर्चे की दवाएं, विटामिन और स्वास्थ्य देखभाल उत्पादों का पूरा स्टोर।",
            icon = "💊"
        ),

        // Kiranam
        LocalEntity(
            id = 10,
            category = "kiranam",
            name = "Hariprasad Kiranam stores",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–9 pm",
            icon = "🛒"
        ),
        LocalEntity(
            id = 11,
            category = "kiranam",
            name = "Janardhan Kiranam Stores",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–9 pm",
            icon = "🛒"
        ),
        LocalEntity(
            id = 12,
            category = "kiranam",
            name = "Jaavaiah Kiranam Stores",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–9 pm",
            icon = "🛒"
        ),
        LocalEntity(
            id = 13,
            category = "kiranam",
            name = "Venkatesh Kiranam Stores",
            address = "Nandikotkuru Road, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–9 pm",
            icon = "🛒"
        ),
        LocalEntity(
            id = 14,
            category = "kiranam",
            name = "Sreedhar Kranam Stores",
            address = "Nandikotkuru Road, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–9 pm",
            icon = "🛒"
        ),

        // Hospital & PHC Clinics
        LocalEntity(
            id = 20,
            category = "hospital",
            name = "Governament Primary Health Center",
            nameTe = "ప్రభుత్వ ప్రాథమిక ఆరోగ్య కేంద్రం (PHC)",
            nameHi = "सरकारी प्राथमिक स्वास्थ्य केंद्र (PHC)",
            address = "Besindes National Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            addressTe = "జాతీయ రహదారి పక్కన, ఓర్వకల్లు, కర్నూలు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "राष्ट्रीय राजमार्ग के पास, ओरवाकल, कर्नूल, आंध्र प्रदेश 518010",
            timings = "10 am–5 pm (24/7 Emergency)",
            timingsTe = "ఉదయం 10 నుండి సాయంత్రం 5 వరకు (24/7 అత్యవసరం)",
            timingsHi = "सुबह 10 बजे से शाम 5 बजे तक (24/7 आपातकालीन)",
            description = "Primary Health Center with general OPD, maternal health, child immunization, and emergency basic care.",
            descTe = "సాధారణ ఓపీడీ, ప్రసూతి సేవలు, పిల్లల టీకాలు మరియు ఉచిత అత్యవసర ప్రాథమిక వైద్య చికిత్స అందించే ప్రభుత్వ కేంద్రం.",
            descHi = "सामान्य ओपीडी, मातृ स्वास्थ्य, बाल टीकाकरण और मुफ्त आपातकालीन प्राथमिक स्वास्थ्य देखभाल।",
            icon = "🏥"
        ),
        LocalEntity(
            id = 21,
            category = "hospital",
            name = "Ranganna Primary Health center",
            nameTe = "రంగన్న క్లినిక్ & హెల్త్ సెంటర్",
            nameHi = "रंगन्ना क्लिनिक एवं स्वास्थ्य केंद्र",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            addressTe = "మెయిన్ బజార్, ప్రధాన రహదారి, ఓర్వకల్లు, కర్నూలు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "मेन बाज़ार, मुख्य मार्ग, ओरवाकल, कर्नूल, आंध्र प्रदेश 518010",
            timings = "9 am–9 pm",
            timingsTe = "ఉదయం 9 నుండి రాత్రి 9 వరకు",
            timingsHi = "सुबह 9 बजे से रात 9 बजे तक",
            description = "General outpatient consultations, fever clinic, and basic health checks.",
            descTe = "జనరల్ ఓపీడీ కన్సల్టేషన్లు, జ్వరాల క్లినిక్ మరియు ప్రాథమిక ఆరోగ్య పరీక్షలు.",
            descHi = "सामान्य ओपीडी परामर्श, बुखार क्लिनिक और बुनियादी स्वास्थ्य जांच।",
            icon = "🏥"
        ),
        LocalEntity(
            id = 22,
            category = "hospital",
            name = "Yousuf Primary Health center",
            nameTe = "యూసుఫ్ క్లినిక్ & ప్రథమ చికిత్స కేంద్రం",
            nameHi = "यूसुफ क्लिनिक एवं प्राथमिक उपचार केंद्र",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            addressTe = "మెయిన్ బజార్, ప్రధాన రహదారి, ఓర్వకల్లు, కర్నూలు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "मेन बाज़ार, मुख्य मार्ग, ओरवाकल, कर्नूल, आंध्र प्रदेश 518010",
            timings = "9 am–9 pm",
            timingsTe = "ఉదయం 9 నుండి రాత్రి 9 వరకు",
            timingsHi = "सुबह 9 बजे से रात 9 बजे तक",
            description = "Experienced village physician providing first-aid, BP/sugar checks, and medical guidance.",
            descTe = "ప్రథమ చికిత్స, బీపీ/షుగర్ పరీక్షలు మరియు అనుభవజ్ఞులైన వైద్యుల సలహాలు.",
            descHi = "प्राथमिक चिकित्सा, बीपी/शुगर जांच और अनुभवी डॉक्टरों द्वारा चिकित्सा परामर्श।",
            icon = "🏥"
        ),
        LocalEntity(
            id = 23,
            category = "hospital",
            name = "Ramana Primary Health center",
            nameTe = "రమణ క్లినిక్ & మెడికల్ కేర్",
            nameHi = "रमण क्लिनिक एवं मेडिकल केयर",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            addressTe = "మెయిన్ బజార్, ప్రధాన రహదారి, ఓర్వకల్లు, కర్నూలు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "मेन बाज़ार, मुख्य मार्ग, ओरवाकल, कर्नूल, आंध्र प्रदेश 518010",
            timings = "9 am–9 pm",
            timingsTe = "ఉదయం 9 నుండి రాత్రి 9 వరకు",
            timingsHi = "सुबह 9 बजे से रात 9 बजे तक",
            description = "Community health clinic catering to seasonal illnesses and primary care.",
            descTe = "కమ్యూనిటీ హెల్త్ క్లినిక్, సీజనల్ వ్యాధుల చికిత్స మరియు ప్రాథమిక సంరక్షణ.",
            descHi = "सामुदायिक स्वास्थ्य क्लिनिक, मौसमी बीमारियों का उपचार और प्राथमिक देखभाल।",
            icon = "🏥"
        ),

        // Pesticides
        LocalEntity(
            id = 30,
            category = "pesticides",
            name = "Gromore",
            address = "Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–9 pm",
            icon = "🌱"
        ),
        LocalEntity(
            id = 31,
            category = "pesticides",
            name = "kissan agrimart",
            address = "Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–9 pm",
            icon = "🌱"
        ),
        LocalEntity(
            id = 32,
            category = "pesticides",
            name = "Kranthe Grama Abhivridhi - Rythu Pathakam",
            address = "Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–9 pm",
            icon = "🌱"
        ),
        LocalEntity(
            id = 33,
            category = "pesticides",
            name = "Srivari Traders",
            address = "Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–9 pm",
            icon = "🌱"
        ),

        // Milk
        LocalEntity(
            id = 40,
            category = "milk",
            name = "Bash Milk Parlour",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "6 am–7 pm",
            icon = "🥛"
        ),
        LocalEntity(
            id = 41,
            category = "milk",
            name = "Vasavi Milk Parlour",
            address = "Main Bazar, Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "6 am–7 pm",
            icon = "🥛"
        ),
        LocalEntity(
            id = 42,
            category = "milk",
            name = "Vasavi Milk Parlour",
            address = "Main route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "6 am–7 pm",
            icon = "🥛"
        ),

        // Mineral Water
        LocalEntity(
            id = 50,
            category = "mineral_water",
            name = "SLV Mineral Water",
            address = "Opp to Canara Bank, Main Bazar Route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "6 am–12:30 pm & 4:30 pm–8 pm",
            icon = "💧"
        ),
        LocalEntity(
            id = 51,
            category = "mineral_water",
            name = "Nagesh Mineral Water",
            address = "Main Bazar Route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "6 am–8 pm",
            icon = "💧"
        ),
        LocalEntity(
            id = 52,
            category = "mineral_water",
            name = "Grama Mineral water",
            address = "Main Bazar Route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "6 am–8 pm",
            icon = "💧"
        ),

        // Restaurants
        LocalEntity(
            id = 60,
            category = "restaurants",
            name = "Haritha Rock Gardens & Restaurants",
            address = "National Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9:30 am–8:30 pm",
            description = "Family restaurant located at the scenic Orvakal Rock Gardens offering South & North Indian cuisine.",
            icon = "🍕"
        ),
        LocalEntity(
            id = 61,
            category = "restaurants",
            name = "Reddy Dhaba Restaurent",
            address = "National Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9:30 am–8:30 pm",
            description = "Authentic highway dhaba meals, rotis, curries, and refreshments.",
            icon = "🍕"
        ),
        LocalEntity(
            id = 62,
            category = "restaurants",
            name = "H8 Restaurant",
            address = "National Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9:30 am–8:30 pm",
            icon = "🍕"
        ),
        LocalEntity(
            id = 63,
            category = "restaurants",
            name = "Aero One Restaurant",
            address = "National Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9:30 am–8:30 pm",
            description = "Modern multi-cuisine restaurant close to Kurnool Airport (KJB) on NH.",
            icon = "🍕"
        ),

        // Hardware
        LocalEntity(
            id = 70,
            category = "hardware",
            name = "Khaja Bande Nawaz Traders",
            address = "Besides Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9:30 am–8:30 pm",
            icon = "🔧"
        ),
        LocalEntity(
            id = 71,
            category = "hardware",
            name = "Veerabhadra Traders",
            address = "Main Bazar Route, Orvakal, Andhra Pradesh 518010",
            timings = "9:30 am–8:30 pm",
            icon = "🔧"
        ),

        // Hotels / Stays
        LocalEntity(
            id = 80,
            category = "hotels",
            name = "Aero One",
            address = "National Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9:30 am–8:30 pm",
            description = "Comfortable lodging, AC & Non-AC suites for travelers and business visitors to Orvakal Industrial Hub.",
            icon = "🏨"
        ),
        LocalEntity(
            id = 81,
            category = "hotels",
            name = "Haritha Rock Gardens & Resorts",
            address = "National Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9:30 am–8:30 pm",
            description = "APTDC tourist resort with comfortable cottages nestled in historic natural rock formations.",
            icon = "🏨"
        ),

        // Temples
        LocalEntity(
            id = 90,
            category = "temples",
            name = "Sri Chennakesava Swamy & Sri Rama Swamy Temple",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "6:30 am–11 am & 4:30 pm–8 pm",
            description = "Ancient historic village temple dedicated to Sri Chennakesava and Sri Rama.",
            icon = "🛕"
        ),
        LocalEntity(
            id = 91,
            category = "temples",
            name = "Sri Anjaneya Swamy Temple",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "6:30 am–11 am & 4:30 pm–8 pm",
            icon = "🛕"
        ),
        LocalEntity(
            id = 92,
            category = "temples",
            name = "Sri Jeeveswara Swamy Temple",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open daily",
            icon = "🛕"
        ),
        LocalEntity(
            id = 93,
            category = "temples",
            name = "Sri Nageswara Swamy Temple",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open daily",
            icon = "🛕"
        ),
        LocalEntity(
            id = 94,
            category = "temples",
            name = "Sunkulamma Temple",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open daily",
            icon = "🛕"
        ),
        LocalEntity(
            id = 95,
            category = "temples",
            name = "Kommu cheruvu Anjaneya Swamy Temple",
            address = "J642+9W8, Gudumbai Tanda, Komma Cheruvu, Kalva, Orvakal, Kurnool Andhra Pradesh 518010",
            timings = "Open daily",
            icon = "🛕"
        ),
        LocalEntity(
            id = 96,
            category = "temples",
            name = "Yaganteswara Swamy Temple",
            address = "J4JX+Q5C yaganteeswara swamy, N.Konthalapadu, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open daily",
            icon = "🛕"
        ),
        LocalEntity(
            id = 97,
            category = "temples",
            name = "Sri Bugga Rameswara Swamy Temple",
            address = "Kalvabugga, Kalva, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open daily",
            icon = "🛕"
        ),

        // Mosque & Dargahs
        LocalEntity(
            id = 100,
            category = "mosque",
            name = "Jamia masjid",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open for daily prayers",
            icon = "🕌"
        ),
        LocalEntity(
            id = 101,
            category = "mosque",
            name = "Masjid - E - Shareef",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open for daily prayers",
            icon = "🕌"
        ),
        LocalEntity(
            id = 102,
            category = "mosque",
            name = "Allah bhakhas Dargah",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open daily",
            icon = "🕌"
        ),
        LocalEntity(
            id = 103,
            category = "mosque",
            name = "Syed sha Sultan Mehemood Shah Qadri Dargah",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open daily",
            icon = "🕌"
        ),

        // Church
        LocalEntity(
            id = 110,
            category = "church",
            name = "RCM Church (Roman Catholic Church)",
            nameTe = "ఆర్.సి.ఎమ్ చర్చ్ (రోమన్ కాథలిక్ చర్చి)",
            nameHi = "आरसीएम चर्च (रोमन कैथोलिक चर्च)",
            address = "Near Bus Stand, Orvakal, Kurnool, Andhra Pradesh 518010",
            addressTe = "బస్టాండ్ దగ్గర, ఓర్వకల్లు, కర్నూలు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "बस स्टैंड के पास, ओरवाकल, कर्नूल, आंध्र प्रदेश 518010",
            timings = "Sunday Service: 8:00 AM & Daily Prayers",
            timingsTe = "ఆదివారం ఆరాధన: ఉదయం 8:00 & రోజువారీ ప్రార్థనలు",
            timingsHi = "रविवार प्रार्थना: सुबह 8:00 बजे और दैनिक प्रार्थना",
            description = "Prominent historic Roman Catholic church near Orvakal Bus Stand with vibrant community fellowship and worship.",
            descTe = "ఓర్వకల్లు బస్టాండ్ సమీపంలోని ప్రముఖ చారిత్రక రోమన్ కాథలిక్ చర్చి; క్రిస్మస్ మరియు పండుగ సమయాలలో ఘనంగా ప్రార్థనలు జరుగుతాయి.",
            descHi = "ओरवाकल बस स्टैंड के पास प्रमुख ऐतिहासिक रोमन कैथोलिक चर्च; रविवार प्रार्थना और पवित्र सभाएं।",
            icon = "⛪"
        ),
        LocalEntity(
            id = 111,
            category = "church",
            name = "ABM Church Orvakal",
            nameTe = "ఏ.బి.ఎమ్ చర్చ్ ఓర్వకల్లు",
            nameHi = "एबीएम चर्च ओरवाकल",
            address = "Village Center, Orvakal, Kurnool, Andhra Pradesh 518010",
            addressTe = "గ్రామ కేంద్రం, ఓర్వకల్లు, కర్నూలు, ఆంధ్రప్రదేశ్ 518010",
            addressHi = "गांव केंद्र, ओरवाकल, कर्नूल, आंध्र प्रदेश 518010",
            timings = "Sunday Service: 9:30 AM & Weekly Fellowship",
            timingsTe = "ఆదివారం ఆరాధన: ఉదయం 9:30 & వారంవారీ ప్రార్థన కూటములు",
            timingsHi = "रविवार प्रार्थना: सुबह 9:30 बजे और साप्ताहिक सभा",
            description = "Community Protestant/Baptist church serving local families with Sunday worship and youth spiritual programs.",
            descTe = "ఓర్వకల్లు గ్రామంలోని స్థానిక క్రైస్తవ కుటుంబాల ప్రార్థనా మందిరం; ఆదివారపు ఆరాధనలు మరియు యువజన కూటములు.",
            descHi = "स्थानीय परिवारों की सेवा करने वाला सामुदायिक चर्च; रविवार की आराधना और आध्यात्मिक कार्यक्रम।",
            icon = "⛪"
        ),

        // Veterinary
        LocalEntity(
            id = 120,
            category = "veterinary",
            name = "Veterinary dispensary",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–5 pm",
            description = "Government veterinary clinic for livestock health, vaccinations, and artificial insemination.",
            icon = "🐄"
        ),

        // School
        LocalEntity(
            id = 130,
            category = "school",
            name = "Mandal Parishad school",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–5 pm",
            icon = "🏫"
        ),
        LocalEntity(
            id = 131,
            category = "school",
            name = "Zilla parishad High school",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–5 pm",
            icon = "🏫"
        ),
        LocalEntity(
            id = 132,
            category = "school",
            name = "Bala Bharathi English Medium School",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–5 pm",
            icon = "🏫"
        ),
        LocalEntity(
            id = 133,
            category = "school",
            name = "Govt Girls Hostel",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–5 pm",
            icon = "🏫"
        ),
        LocalEntity(
            id = 134,
            category = "school",
            name = "Yella Reddy College",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–5 pm",
            icon = "🏫"
        ),
        LocalEntity(
            id = 135,
            category = "school",
            name = "Kasturba Gandhi Balika Vidyalaya (KGBV), Orvakal",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–5 pm",
            icon = "🏫"
        ),
        LocalEntity(
            id = 136,
            category = "school",
            name = "AP Model school orvakal kurnool",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–5 pm",
            icon = "🏫"
        ),
        LocalEntity(
            id = 137,
            category = "school",
            name = "Bugga remeswara college",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "7 am–5 pm",
            icon = "🏫"
        ),

        // Post Office
        LocalEntity(
            id = 140,
            category = "post_office",
            name = "Orvakal Post Office",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–5 pm",
            description = "Sub Post Office (SO) - PIN 518010. Speed post, parcel booking, saving bank accounts, and Sukanya Samriddhi Yojana.",
            icon = "📮"
        ),

        // Bank
        LocalEntity(
            id = 150,
            category = "bank",
            name = "Canara Bank",
            address = "Main Bazar Route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–4 pm (Mon-Sat, 2nd & 4th Sat holiday)",
            description = "Full banking services, crop loan counters, ATM facility, and deposit schemes.",
            icon = "🏦"
        ),
        LocalEntity(
            id = 151,
            category = "bank",
            name = "SBI Bank",
            address = "Nandi kotkur Route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–4 pm (Mon-Sat, 2nd & 4th Sat holiday)",
            description = "State Bank of India branch supporting PM KISAN, savings, gold loans, and UPI support.",
            icon = "🏦"
        ),
        LocalEntity(
            id = 152,
            category = "bank",
            name = "Andhra Pragathi Grameena Bank",
            address = "Main Bazar Route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–4 pm",
            description = "Dedicated rural and agricultural development bank branch.",
            icon = "🏦"
        ),
        LocalEntity(
            id = 153,
            category = "bank",
            name = "India1 ATM (Only ATM)",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "24 Hours Service",
            description = "24/7 White-label cash dispenser supporting all debit and Rupay cards.",
            icon = "🏧"
        ),

        // Shopping
        LocalEntity(
            id = 160,
            category = "shopping",
            name = "Lucky Kids & Mens Wear",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–9 pm",
            icon = "🛍️"
        ),
        LocalEntity(
            id = 161,
            category = "shopping",
            name = "Jeevaiha cloth store",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–9 pm",
            icon = "🛍️"
        ),

        // Govt offices
        LocalEntity(
            id = 170,
            category = "govt_offices",
            name = "Mandal Praja Parishat Office",
            address = "Beside Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–5 pm",
            icon = "🏛️"
        ),
        LocalEntity(
            id = 171,
            category = "govt_offices",
            name = "Mandal Agriculture office",
            address = "Beside Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–5 pm",
            icon = "🏛️"
        ),
        LocalEntity(
            id = 172,
            category = "govt_offices",
            name = "MGNERES office",
            address = "Beside Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–5 pm",
            icon = "🏛️"
        ),
        LocalEntity(
            id = 173,
            category = "govt_offices",
            name = "Orvakallu MRO Office (Tahsildar)",
            address = "Orvakal Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–5 pm",
            description = "Revenue and administrative head office for Orvakal Mandal.",
            icon = "🏛️"
        ),
        LocalEntity(
            id = 174,
            category = "govt_offices",
            name = "Grama Sachivalayam & RBK Office",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–5 pm",
            description = "Village secretariat and Rythu Bharosa Kendram for instant citizen and farmer services.",
            icon = "🏛️"
        ),
        LocalEntity(
            id = 175,
            category = "govt_offices",
            name = "Sub-Registrar Office",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–5 pm",
            icon = "🏛️"
        ),
        LocalEntity(
            id = 176,
            category = "govt_offices",
            name = "MSME Park",
            address = "Besides Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–6 pm",
            icon = "🏭"
        ),
        LocalEntity(
            id = 177,
            category = "govt_offices",
            name = "Power Grid Corporation of India Limited",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "24/7 Operations",
            icon = "⚡"
        ),
        LocalEntity(
            id = 178,
            category = "govt_offices",
            name = "Kurnool Ultra Mega Solar Park, Greenco (Pinnapuram)",
            address = "Sakunala Village (& Pinnapuram), Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "24/7 Operations",
            description = "1000+ MW solar and renewable energy hub in Orvakal Mandal.",
            icon = "☀️"
        ),
        LocalEntity(
            id = 179,
            category = "govt_offices",
            name = "MeeSeva Center (Near MRO office)",
            address = "Beside Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–6 pm",
            description = "Citizen certificates, encumbrance certificates, Aadhaar updates, and utility bills.",
            icon = "🖥️"
        ),
        LocalEntity(
            id = 180,
            category = "govt_offices",
            name = "Kranti Orvakal Grama Abhivridhi",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "10 am–5 pm",
            icon = "🤝"
        ),

        // Visiting places
        LocalEntity(
            id = 190,
            category = "visiting_places",
            name = "Orvakallu Rock Gardens",
            address = "Beside Highway, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "8 am–7 pm",
            description = "A 1000-acre natural wonder of silica and quartz rock formations, walking trails, boating lake, children's park, and film shooting locale.",
            icon = "🏞️"
        ),
        LocalEntity(
            id = 191,
            category = "visiting_places",
            name = "Ketavaram Rock Paintings",
            address = "Ketavaram Village, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Sunrise to Sunset",
            description = "Prehistoric rock art gallery depicting ancient deer, bulls, and human stick figures preserved on high cliffs.",
            icon = "🗿"
        ),

        // Market
        LocalEntity(
            id = 200,
            category = "market",
            name = "Rythu Market",
            address = "Main Bazar, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Saturday 4 pm to 8 pm",
            description = "Weekly farmers market for direct purchase of fresh vegetables, fruits, and dairy from local growers.",
            icon = "🧺"
        ),
        LocalEntity(
            id = 201,
            category = "market",
            name = "Tobacco Market (ITC)",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–6 pm",
            icon = "📦"
        ),
        LocalEntity(
            id = 202,
            category = "market",
            name = "Tobacco Market",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–6 pm",
            icon = "📦"
        ),
        LocalEntity(
            id = 203,
            category = "market",
            name = "ITC Tobacco Warehouse Masapeta",
            address = "Masapeta, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–6 pm",
            icon = "🏢"
        ),

        // Internet & Digital TV Services
        LocalEntity(
            id = 210,
            category = "internet_tv",
            name = "SRI VENKATESWARA CABLE NETWORK",
            address = "Main bazar, Orvakal, Andhra Pradesh 518010",
            timings = "9 am–8 pm",
            description = "Cable TV network and high-speed broadband fiber connections across Orvakal town.",
            icon = "📡"
        ),

        // Decors
        LocalEntity(
            id = 220,
            category = "decors",
            name = "DVR Decorations",
            address = "Guttapadu main road, Ongole - Kurnool Main Rd, Orvakal, Andhra Pradesh 518010",
            timings = "9 am–9 pm",
            description = "Wedding stage decor, flower decoration, sound system, and lighting sets.",
            icon = "🎪"
        ),
        LocalEntity(
            id = 221,
            category = "decors",
            name = "R S DECORATION",
            address = "Near Bustop, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "9 am–9 pm",
            icon = "🎪"
        ),

        // Banquet Halls
        LocalEntity(
            id = 230,
            category = "banquet_halls",
            name = "Sri Jeeveswara Swamy Kalyana Mandapam",
            address = "Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "Open for Marriage & Function Bookings",
            description = "Spacious community marriage hall with dining capacity, bride/groom rooms, and parking space.",
            icon = "🏛️"
        ),

        // Courier
        LocalEntity(
            id = 240,
            category = "courier",
            name = "DTDC COURIER EXPRESS LIMITED",
            address = "SHOP NO 1, BYREDDYNAGAR, Orvakal, Andhra Pradesh 518010",
            timings = "9 am–8 pm",
            description = "Domestic and international express parcel deliveries, tracking, and pickup services.",
            icon = "📦"
        ),

        // Village Committees
        LocalEntity(
            id = 250,
            category = "village_committees",
            name = "Temple Committee",
            address = "Main Bazar, Orvakal",
            description = "Oversees village temples, annual festivals, and dharmic cultural activities. Contact persons will be updated soon.",
            icon = "👥"
        ),
        LocalEntity(
            id = 251,
            category = "village_committees",
            name = "Watershed Committee",
            address = "Orvakal Mandal",
            description = "Manages water conservation, groundwater recharge structures, and check dams.",
            icon = "👥"
        ),
        LocalEntity(
            id = 252,
            category = "village_committees",
            name = "Guard (Kaavali) Committee",
            address = "Orvakal Village",
            description = "Village surveillance, night patrolling, and community watch coordination.",
            icon = "👥"
        ),
        LocalEntity(
            id = 253,
            category = "village_committees",
            name = "Cricket Club - Orvakallu",
            address = "Orvakal Playgrounds",
            description = "Youth cricket academy, seasonal league tournaments, and practice camps.",
            icon = "🏏"
        ),
        LocalEntity(
            id = 254,
            category = "village_committees",
            name = "Sports Club - Orvakallu",
            address = "Orvakal",
            description = "Promoting sports, athletic training, volleyball, and physical fitness in the mandal.",
            icon = "⚽"
        ),
        LocalEntity(
            id = 255,
            category = "village_committees",
            name = "Education / Library Club - Orvakallu",
            address = "Main Bazar Route, Orvakal",
            description = "Student career guidance, competitive exam study groups, and library initiatives.",
            icon = "📚"
        ),

        // Library
        LocalEntity(
            id = 260,
            category = "library",
            name = "Library - Orvakal ( శాఖా గ్రంథాలయం )",
            address = "Main Bazar Route, Orvakal, Kurnool, Andhra Pradesh 518010",
            timings = "8 am–11:30 am & 4 pm–7:30 pm",
            description = "Public branch library with daily newspapers, Telugu & English literature, competitive exams books, and reading room.",
            icon = "📖"
        )
    )

    // Mega Industries for Jobs & Commerce Screen (Screenshot 2)
    val megaIndustries: List<Industry> = listOf(
        Industry(
            id = 1,
            name = "Greenco Solar Park",
            nameTe = "గ్రీన్‌కో సోలార్ పార్క్ & క్లీన్ ఎనర్జీ",
            nameHi = "ग्रीनको सोलर पार्क एवं नवीकरणीय ऊर्जा",
            sector = "Renewable Energy (Solar & Storage)",
            sectorTe = "పునరుత్పాదక ఇంధనం (సోలార్ & స్టోరేజ్)",
            sectorHi = "नवीकरणीय ऊर्जा (सौर एवं भंडारण)",
            location = "Kurnool Solar Park Zone, Orvakal Mandal",
            locationTe = "కర్నూలు సోలార్ పార్క్ జోన్, ఓర్వకల్లు మండలం",
            locationHi = "कर्नूल सोलर पार्क ज़ोन, ओरवाकल मंडल",
            statusBadge = "Operational (1000+ MW Capacity)",
            statusBadgeTe = "పూర్తిగా పనిచేస్తోంది (1000+ MW)",
            statusBadgeHi = "पूर्णतः चालू (1000+ मेगावाट)",
            details = "One of the world's largest integrated renewable solar and pumped storage hubs situated in Orvakal mandal, generating clean power.",
            detailsTe = "ఓర్వకల్లు మండలంలో విస్తరించి ఉన్న ప్రపంచంలోనే అతిపెద్ద ఇంటిగ్రేటెడ్ సౌర మరియు గ్రీన్ ఎనర్జీ ప్రాజెక్టులలో ఒకటి.",
            detailsHi = "ओरवाकल मंडल में स्थित दुनिया के सबसे बड़े एकीकृत सौर और हरित ऊर्जा संयंत्रों में से एक।"
        ),
        Industry(
            id = 2,
            name = "UltraTech Cement Plant",
            nameTe = "అల్ట్రాటెక్ సిమెంట్ ప్లాంట్",
            nameHi = "अल्ट्राटेक सीमेंट प्लांट",
            sector = "Heavy Manufacturing & Infrastructure",
            sectorTe = "భారీ తయారీ & మౌలిక వసతులు",
            sectorHi = "भारी विनिर्माण एवं बुनियादी ढांचा",
            location = "Industrial Corridor Phase-1, Budawada Road",
            locationTe = "ఇండస్ట్రియల్ కారిడార్ ఫేజ్-1, బుడవడ రోడ్డు",
            locationHi = "औद्योगिक गलियारा चरण-1, बुडवड़ा रोड",
            statusBadge = "Operational (Mega Cement Plant)",
            statusBadgeTe = "పనిచేస్తోంది (మెగా సిమెంట్ ప్లాంట్)",
            statusBadgeHi = "चालू (मेगा सीमेंट प्लांट)",
            details = "Advanced state-of-the-art limestone processing and high-grade cement production facility providing direct regional employment.",
            detailsTe = "కర్నూలు సున్నపురాయి నిల్వలను ఉపయోగించి అత్యున్నత నాణ్యత గల సిమెంట్ తయారుచేసే భారీ పారిశ్రామిక యూనిట్.",
            detailsHi = "कर्नूल के समृद्ध चूना पत्थर का उपयोग कर उच्च श्रेणी का सीमेंट उत्पादन करने वाला प्रमुख संयंत्र।"
        ),
        Industry(
            id = 3,
            name = "Ramco Cement Grinding Unit",
            nameTe = "రామ్కో సిమెంట్ గ్రైండింగ్ యూనిట్",
            nameHi = "रामको सीमेंट ग्राइंडिंग यूनिट",
            sector = "Building Materials & Cement",
            sectorTe = "నిర్మాణ సామాగ్రి & సిమెంట్",
            sectorHi = "निर्माण सामग्री एवं सीमेंट",
            location = "Nandyal Highway, Orvakal Bypass",
            locationTe = "నంద్యాల హైవే, ఓర్వకల్లు బైపాస్",
            locationHi = "नंद्याल हाईवे, ओरवाकल बाईपास",
            statusBadge = "Operational (Grinding Unit)",
            statusBadgeTe = "పనిచేస్తోంది (గ్రైండింగ్ యూనిట్)",
            statusBadgeHi = "चालू (ग्राइंडिंग यूनिट)",
            details = "Modern packaging and grinding unit catering to infrastructure and construction needs across Rayalaseema.",
            detailsTe = "రాయలసీమ అంతటా మౌలిక సదుపాయాల అవసరాలకు సరఫరా చేసే ఆధునిక ప్యాకేజింగ్ మరియు గ్రైండింగ్ యూనిట్.",
            detailsHi = "बुनियादी ढांचे की जरूरतों के लिए आधुनिक पैकेजिंग और ग्राइंडिंग यूनिट।"
        ),
        Industry(
            id = 4,
            name = "Kurnool Mega Food Park",
            nameTe = "కర్నూలు మెగా ఫుడ్ పార్క్",
            nameHi = "कर्नूल मेगा फूड पार्क",
            sector = "Food Processing & Agro Industries",
            sectorTe = "ఆహార ప్రాసెసింగ్ & ఆగ్రో పరిశ్రమలు",
            sectorHi = "खाद्य प्रसंस्करण एवं कृषि उद्योग",
            location = "APIIC Industrial Area, Orvakal Bypass",
            locationTe = "APIIC ఇండస్ట్రియల్ ఏరియా, ఓర్వకల్లు బైపాస్",
            locationHi = "APIIC औद्योगिक क्षेत्र, ओरवाकल बाईपास",
            statusBadge = "Under Execution (Allotments Active)",
            statusBadgeTe = "నిర్మాణంలో ఉంది (కేటాయింపులు జరుగుతున్నాయి)",
            statusBadgeHi = "निर्माणाधीन (आवंटन सक्रिय)",
            details = "Sprawling agro-processing park offering cold storage, grain silos, sorting, and packaging for farmers and food entrepreneurs.",
            detailsTe = "రైతులకు, వ్యవసాయ పారిశ్రామికవేత్తలకు కోల్డ్ స్టోరేజ్, ధాన్యపు నిల్వ కేంద్రాలు మరియు ప్యాకేజింగ్ సదుపాయాలు.",
            detailsHi = "किसानों और खाद्य उद्यमियों के लिए कोल्ड स्टोरेज, अनाज साइलो और सॉर्टिंग हब।"
        ),
        Industry(
            id = 5,
            name = "MSME Industrial Hub",
            nameTe = "MSME ఇండస్ట్రియల్ హబ్",
            nameHi = "एमएसएमई औद्योगिक हब",
            sector = "Micro, Small & Medium Manufacturing",
            sectorTe = "సూక్ష్మ, చిన్న & మధ్య తరహా పరిశ్రమలు",
            sectorHi = "सूक्ष्म, लघु एवं मध्यम विनिर्माण",
            location = "Industrial Corridor, Orvakal",
            locationTe = "ఇండస్ట్రియల్ కారిడార్, ఓర్వకల్లు",
            locationHi = "औद्योगिक गलियारा, ओरवाकल",
            statusBadge = "Allotments Open",
            statusBadgeTe = "ప్లాట్ల కేటాయింపులు ప్రారంభం",
            statusBadgeHi = "भूखंड आवंटन खुला",
            details = "Plug-and-play manufacturing units, tool rooms, warehousing, and logistics plots developed by APIIC.",
            detailsTe = "APIIC అభివృద్ధి చేసిన ప్లగ్-అండ్-ప్లే తయారీ షెడ్లు, గిడ్డంగులు మరియు లాజిస్టిక్స్ ప్లాట్లు.",
            detailsHi = "एपीआईआईसी द्वारा विकसित प्लग-एंड-प्ले विनिर्माण इकाइयां और वेयरहाउसिंग।"
        ),
        Industry(
            id = 6,
            name = "Power Grid 765kV Substation",
            nameTe = "పవర్ గ్రిడ్ 765kV సబ్‌స్టేషన్",
            nameHi = "पावर ग्रिड 765kV सबस्टेशन",
            sector = "Power Transmission & Grid",
            sectorTe = "విద్యుత్ ప్రసారం & జాతీయ గ్రిడ్",
            sectorHi = "बिजली पारेषण एवं राष्ट्रीय ग्रिड",
            location = "Near Bus Stop, Orvakal",
            locationTe = "బస్టాండ్ దగ్గర, ఓర్వకల్లు",
            locationHi = "बस स्टैंड के पास, ओरवाकल",
            statusBadge = "Critical National Asset",
            statusBadgeTe = "కీలకమైన జాతీయ మౌలిక ఆస్తి",
            statusBadgeHi = "महत्वपूर्ण राष्ट्रीय संपत्ति",
            details = "Major high-voltage electrical grid substation connecting southern interstate transmission corridors.",
            detailsTe = "దక్షిణ భారత అంతర్రాష్ట్ర విద్యుత్ కారిడార్లను అనుసంధానించే అత్యున్నత ఓల్టేజ్ సబ్‌స్టేషన్.",
            detailsHi = "दक्षिण भारत के अंतरराज्यीय ट्रांसमिशन कॉरिडोर को जोड़ने वाला मुख्य हाई-वोल्टेज ग्रिड सबस्टेशन।"
        )
    )

    // Explore Services Catalog categories (Ordered by civic & daily importance)
    val servicesCatalog: List<CatalogCategory> = listOf(
        CatalogCategory(
            id = "medical_stores",
            title = "Medical Stores & Chemist",
            titleTe = "మెడికల్ స్టోర్స్ & మందుల దుకాణాలు",
            titleHi = "मेडिकल स्टोर और दवाइयां",
            description = "Local pharmacies, chemists, and 24/7 emergency medicine counters.",
            descTe = "స్థానిక ఫార్మసీలు, కెమిస్ట్‌లు మరియు 24/7 అత్యవసర మందుల కౌంటర్లు.",
            descHi = "स्थानीय फ़ार्मेसी, केमिस्ट और 24/7 आपातकालीन दवा काउंटर।",
            icon = "💊",
            categoryKey = "medical_stores"
        ),
        CatalogCategory(
            id = "kiranam",
            title = "Kiranam & Provisions",
            titleTe = "కిరాణా & నిత్యావసరాలు",
            titleHi = "किराना और दैनिक वस्तुएं",
            description = "Grocery stores, spices, daily provisions, and staples.",
            descTe = "కిరాణా దుకాణాలు, మసాలాలు, రోజువారీ సరుకులు మరియు ఆహార ధాన్యాలు.",
            descHi = "किराना दुकानें, मसाले, दैनिक राशन और खाद्य सामग्री।",
            icon = "🛒",
            categoryKey = "kiranam"
        ),
        CatalogCategory(
            id = "milk",
            title = "Milk Dairies & Centers",
            titleTe = "పాల డెయిరీలు & కేంద్రాలు",
            titleHi = "दुग्ध डेयरियां और केंद्र",
            description = "Fresh cow/buffalo milk booths, dairies, and milk cooperatives.",
            descTe = "తాజా ఆవు/గేదె పాల బూత్‌లు, డెయిరీలు మరియు పాల సహకార కేంద్రాలు.",
            descHi = "ताजा गाय/भैंस दूध बूथ, डेयरियां और दुग्ध सहकारी समितियां।",
            icon = "🥛",
            categoryKey = "milk"
        ),
        CatalogCategory(
            id = "mineral_water",
            title = "Mineral Water Plants",
            titleTe = "మినరల్ వాటర్ ప్లాంట్లు",
            titleHi = "मिनरल वाटर प्लांट",
            description = "RO water cans, purified cold drinking water supply stations.",
            descTe = "RO వాటర్ క్యాన్లు, శుద్ధి చేసిన తాగునీటి సరఫరా కేంద్రాలు.",
            descHi = "आरओ पानी के कैन, शुद्ध ठंडा पेयजल आपूर्ति स्टेशन।",
            icon = "💧",
            categoryKey = "mineral_water"
        ),
        CatalogCategory(
            id = "restaurants",
            title = "Food & Restaurants",
            titleTe = "భోజనశాలలు & రెస్టారెంట్లు",
            titleHi = "भोजनालय और रेस्तरां",
            description = "Local restaurants, fast food, dhabas, and dining centers.",
            descTe = "స్థానిక రెస్టారెంట్లు, ఫాస్ట్ ఫుడ్, ధాబాలు మరియు భోజన కేంద్రాలు.",
            descHi = "स्थानीय रेस्तरां, फास्ट फूड, ढाबे और भोजन केंद्र।",
            icon = "🍕",
            categoryKey = "restaurants"
        ),
        CatalogCategory(
            id = "hotels",
            title = "Hotel & Stays",
            titleTe = "హోటళ్ళు & బస",
            titleHi = "होटल और ठहरने की व्यवस्था",
            description = "Lodging, hotels, guest houses, and Rock Garden resort cottages.",
            descTe = "లాడ్జింగ్, హోటళ్ళు, అతిథి గృహాలు మరియు రాక్ గార్డెన్ రిసార్ట్ కాటేజీలు.",
            descHi = "लॉजिंग, होटल, गेस्ट हाउस और रॉक गार्डन रिसॉर्ट कॉटेज।",
            icon = "🏨",
            categoryKey = "hotels"
        ),
        CatalogCategory(
            id = "breakdown",
            title = "Motor & Vehicle Breakdown",
            titleTe = "మోటార్ & వాహన బ్రేక్‌డౌన్",
            titleHi = "मोटर और वाहन ब्रेकडाउन",
            description = "24/7 highway towing, car/tractor mechanics, puncture and rewinding.",
            descTe = "24/7 హైవే టోయింగ్, కారు/ట్రాక్టర్ మెకానిక్‌లు, పంక్చర్ మరియు రీవైండింగ్.",
            descHi = "24/7 हाईवे टोइंग, कार/ट्रैक्टर मैकेनिक, पंचर और रीवाइंडिंग।",
            icon = "🔧",
            categoryKey = "breakdown"
        ),
        CatalogCategory(
            id = "tuitions",
            title = "Tuitions & Coaching",
            titleTe = "ట్యూషన్లు & కోచింగ్",
            titleHi = "ट्यूशन और कोचिंग",
            description = "Academic tuitions, coding classes, and school guidance.",
            descTe = "అకడమిక్ ట్యూషన్లు, కంప్యూటర్ క్లాసులు మరియు పాఠశాల మార్గదర్శకత్వం.",
            descHi = "अकादमिक ट्यूशन, कोडिंग कक्षाएं और स्कूली मार्गदर्शन।",
            icon = "📖",
            categoryKey = "school"
        ),
        CatalogCategory(
            id = "rentals",
            title = "Home Rentals & PGs",
            titleTe = "ఇళ్ల అద్దెలు & పీజీలు",
            titleHi = "मकान किराया और पीजी",
            description = "Houses for rent, PG accommodations, and hostel facilities.",
            descTe = "అద్దె ఇళ్ళు, పిజి వసతి మరియు హాస్టల్ సౌకర్యాలు.",
            descHi = "किराए के मकान, पीजी आवास और छात्रावास सुविधाएं।",
            icon = "🏠",
            categoryKey = "school"
        ),
        CatalogCategory(
            id = "hardware",
            title = "Hardware & Electricals",
            titleTe = "హార్డ్‌వేర్ & ఎలక్ట్రికల్స్",
            titleHi = "हार्डवेयर और इलेक्ट्रिकल्स",
            description = "Building materials, electrical motors, pipes, and tools.",
            descTe = "భవన నిర్మాణ సామగ్రి, విద్యుత్ మోటార్లు, పైపులు మరియు సాధనాలు.",
            descHi = "भवन निर्माण सामग्री, विद्युत मोटर, पाइप और औजार।",
            icon = "⚙️",
            categoryKey = "hardware"
        ),
        CatalogCategory(
            id = "decors",
            title = "Boutiques & Tailors",
            titleTe = "బొటిక్‌లు & టైలర్స్",
            titleHi = "बुटीक और दर्जी",
            description = "Ladies tailors, designer boutiques, and apparel stitchers.",
            descTe = "లేడీస్ టైలర్స్, డిజైనర్ బోటిక్‌లు మరియు దుస్తుల కుట్టు కేంద్రాలు.",
            descHi = "महिला दर्जी, डिजाइनर बुटीक और परिधान सिलाई।",
            icon = "🧵",
            categoryKey = "decors"
        ),
        CatalogCategory(
            id = "shopping",
            title = "Cloth Shopping",
            titleTe = "బట్టల దుకాణాలు & షాపింగ్",
            titleHi = "कपड़ों की खरीदारी",
            description = "Readymade apparel shops, sarees, and clothing stores.",
            descTe = "రెడీమేడ్ దుస్తుల దుకాణాలు, చీరలు మరియు వస్త్ర కేంద్రాలు.",
            descHi = "तैयार वस्त्र दुकानें, साड़ियां और कपड़ों के स्टोर।",
            icon = "🛍️",
            categoryKey = "shopping"
        ),
        CatalogCategory(
            id = "banquet_halls",
            title = "Banquet & Event Halls",
            titleTe = "కళ్యాణ మండపాలు & ఫంక్షన్ హాళ్లు",
            titleHi = "कल्याण मंडप और फंक्शन हॉल",
            description = "Function halls, marriage convention halls, and event organizers.",
            descTe = "ఫంక్షన్ హాళ్లు, వివాహ సభా మందిరాలు మరియు ఈవెంట్ ఆర్గనైజర్లు.",
            descHi = "फंक्शन हॉल, विवाह सम्मेलन हॉल और कार्यक्रम आयोजक।",
            icon = "🎪",
            categoryKey = "banquet_halls"
        ),
        CatalogCategory(
            id = "temples",
            title = "Temples & Holy Shrines",
            titleTe = "దేవాలయాలు & పుణ్యక్షేత్రాలు",
            titleHi = "मंदिर और धार्मिक स्थल",
            description = "Historical Hindu temples, pujas, and darshan timings.",
            descTe = "చారిత్రక హిందూ దేవాలయాలు, పూజలు మరియు దర్శన సమయాలు.",
            descHi = "ऐतिहासिक हिंदू मंदिर, पूजा और दर्शन का समय।",
            icon = "🛕",
            categoryKey = "temples"
        ),
        CatalogCategory(
            id = "mosques",
            title = "Mosques & Dargahs",
            titleTe = "మసీదులు & దర్గాలు",
            titleHi = "मस्जिदें और दरगाहें",
            description = "Jamia Masjid, Dargahs, and Islamic prayer centers.",
            descTe = "జామియా మసీదు, దర్గాలు మరియు ప్రార్థనా కేంద్రాలు.",
            descHi = "जामिया मस्जिद, दरगाहें और प्रार्थना केंद्र।",
            icon = "🕌",
            categoryKey = "mosque"
        ),
        CatalogCategory(
            id = "churches",
            title = "Churches",
            titleTe = "చర్చ్‌లు (క్రైస్తవ ప్రార్థనా మందిరాలు)",
            titleHi = "चर्च (गिरजाघर)",
            description = "RCM Church near Bus Stop and Village ABM Church.",
            descTe = "బస్ స్టాండ్ సమీపంలోని RCM చర్చ్ మరియు గ్రామ ABM చర్చ్.",
            descHi = "बस स्टॉप के पास आरसीएम चर्च और ग्राम एबीएम चर्च।",
            icon = "⛪",
            categoryKey = "church"
        ),
        CatalogCategory(
            id = "courier",
            title = "Courier & Logistics",
            titleTe = "కొరియర్ & లాజిస్టిక్స్",
            titleHi = "कूरियर और लॉजिस्टिक्स",
            description = "Speed parcels, document couriers, and cargo dispatch.",
            descTe = "స్పీడ్ పార్శిళ్లు, డాక్యుమెంట్ కొరియర్లు మరియు సరుకు రవాణా.",
            descHi = "स्पीड पार्सल, दस्तावेज कूरियर और कार्गो प्रेषण।",
            icon = "📦",
            categoryKey = "courier"
        ),
        CatalogCategory(
            id = "library",
            title = "Public Library",
            titleTe = "ప్రజా గ్రంథాలయం (శాఖా గ్రంథాలయం)",
            titleHi = "सार्वजनिक पुस्तकालय",
            description = "Village reading room, competitive books, and newspapers.",
            descTe = "గ్రామ పఠన మందిరం, పోటీ పరీక్షల పుస్తకాలు మరియు వార్తాపత్రికలు.",
            descHi = "ग्राम वाचनालय, प्रतियोगी पुस्तकें और समाचार पत्र।",
            icon = "📚",
            categoryKey = "library"
        )
    )

    // Govt & Info categories (Screenshot 4)
    val govtCatalog: List<CatalogCategory> = listOf(
        CatalogCategory(
            id = "grievance",
            title = "Panchayat Grievance Desk",
            titleTe = "పంచాయతీ ఫిర్యాదుల డెస్క్",
            titleHi = "पंचायत शिकायत डेस्क",
            description = "File and track civic complaints directly with village administration.",
            descTe = "గ్రామ పరిపాలనతో పౌర సమస్యలను నేరుగా నమోదు చేసి ట్రాక్ చేయండి.",
            descHi = "ग्राम प्रशासन के पास सीधे नागरिक शिकायतें दर्ज और ट्रैक करें।",
            icon = "📝",
            categoryKey = "grievance"
        ),
        CatalogCategory(
            id = "offices",
            title = "Govt Offices & Officers",
            titleTe = "ప్రభుత్వ కార్యాలయాలు & అధికారులు",
            titleHi = "सरकारी कार्यालय और अधिकारी",
            description = "Contact details for Panchayat, SRO, Tahsildar, and agricultural coordinators.",
            descTe = "పంచాయతీ, సబ్-రిజిస్ట్రార్, తహశీల్దార్ మరియు వ్యవసాయ అధికారుల వివరాలు.",
            descHi = "पंचायत, एसआरओ, तहसीलदार और कृषि समन्वयकों के संपर्क विवरण।",
            icon = "🏛️",
            categoryKey = "govt_offices"
        ),
        CatalogCategory(
            id = "schools",
            title = "Schools & Education Centers",
            titleTe = "పాఠశాలలు & విద్యా కేంద్రాలు",
            titleHi = "स्कूल और शिक्षा केंद्र",
            description = "Government schools, private tuition modules, and facilities.",
            descTe = "ప్రభుత్వ పాఠశాలలు, ప్రైవేట్ విద్యా కేంద్రాలు మరియు వసతులు.",
            descHi = "सरकारी स्कूल, निजी ट्यूशन मॉड्यूल और सुविधाएं।",
            icon = "🏫",
            categoryKey = "school"
        ),
        CatalogCategory(
            id = "post",
            title = "Post Office & Services",
            titleTe = "పోస్ట్ ఆఫీస్ & సేవలు",
            titleHi = "डाकघर और सेवाएं",
            description = "Speed post details, pin codes, and savings schemes.",
            descTe = "స్పీడ్ పోస్ట్ వివరాలు, పిన్ కోడ్ మరియు పొదుపు పథకాలు.",
            descHi = "स्पीड पोस्ट विवरण, पिन कोड और बचत योजनाएं।",
            icon = "📮",
            categoryKey = "post_office"
        ),
        CatalogCategory(
            id = "banks",
            title = "Banks & ATMs",
            titleTe = "బ్యాంకులు & ఏటీఎంలు",
            titleHi = "बैंक और एटीएम",
            description = "SBI, APGB, Canara branch details with 24/7 cash status and crop loan interest rates.",
            descTe = "SBI, APGB, కెనరా బ్యాంక్ బ్రాంచ్‌లు, 24/7 నగదు స్థితి మరియు పంట రుణాలు.",
            descHi = "एसबीआई, एपीजीवीबी, केनरा बैंक शाखाएं, 24/7 कैश स्थिति और फसल ऋण।",
            icon = "🏦",
            categoryKey = "bank"
        ),
        CatalogCategory(
            id = "schemes",
            title = "Government Schemes",
            titleTe = "ప్రభుత్వ పథకాలు & ప్రయోజనాలు",
            titleHi = "सरकारी योजनाएं और लाभ",
            description = "State and Central government schemes for farmers, women, and students.",
            descTe = "రైతులు, మహిళలు మరియు విద్యార్థుల కోసం రాష్ట్ర & కేంద్ర ప్రభుత్వ పథకాలు.",
            descHi = "किसानों, महिलाओं और छात्रों के लिए राज्य और केंद्र सरकार की योजनाएं।",
            icon = "📜",
            categoryKey = "govt_schemes"
        ),
        CatalogCategory(
            id = "police",
            title = "Police Station & Security",
            titleTe = "పోలీస్ స్టేషన్ & భద్రత",
            titleHi = "पुलिस स्टेशन और सुरक्षा",
            description = "Orvakal police station phone directory and Sub-Inspector contact.",
            descTe = "ఓర్వకల్లు పోలీస్ స్టేషన్ ఫోన్ డైరెక్టరీ మరియు ఎస్.ఐ సంప్రదింపు నంబర్.",
            descHi = "ओरवाकल पुलिस स्टेशन फोन डायरेक्टरी और सब-इंस्पेक्टर संपर्क।",
            icon = "👮",
            categoryKey = "police"
        ),
        CatalogCategory(
            id = "hospital",
            title = "Hospital & PHC Clinics",
            titleTe = "ఆసుపత్రి & ప్రాథమిక ఆరోగ్య కేంద్రం",
            titleHi = "अस्पताल और प्राथमिक स्वास्थ्य केंद्र",
            description = "Primary Health Center beds count, doctors list, and OPD timings.",
            descTe = "ప్రాథమిక ఆరోగ్య కేంద్రం పడకల సంఖ్య, వైద్యుల జాబితా మరియు ఓపీడీ సమయాలు.",
            descHi = "प्राथमिक स्वास्थ्य केंद्र में बेड की संख्या, डॉक्टरों की सूची और ओपीडी समय।",
            icon = "🏥",
            categoryKey = "hospital"
        ),
        CatalogCategory(
            id = "committees",
            title = "Village Committees",
            titleTe = "గ్రామ కమిటీలు & మండళ్లు",
            titleHi = "ग्राम समितियां और मंडल",
            description = "Temple, youth, security and commercial advisory panels.",
            descTe = "ఆలయం, యువజన, భద్రత మరియు వాణిజ్య సలహా సంఘాలు.",
            descHi = "मंदिर, युवा, सुरक्षा और वाणिज्यिक सलाहकार समितियां।",
            icon = "👥",
            categoryKey = "village_committees"
        )
    )

    // Farmer Desk categories (Screenshot 5)
    val farmerCatalog: List<CatalogCategory> = listOf(
        CatalogCategory(
            id = "farmer_schemes",
            title = "Farmer Schemes & Subsidies",
            titleTe = "రైతు పథకాలు & రాయితీలు",
            titleHi = "किसान योजनाएं और सब्सिडी",
            description = "Annadata Sukhibhava, PM-KISAN, PMFBY, and KCC credit schemes.",
            descTe = "అన్నదాత సుఖీభవ, పీఎం-కిసాన్, పంట బీమా మరియు కేసీసీ రుణాలు.",
            descHi = "अन्नदाता सुखीभव, पीएम-किसान, पीएमएफबीवाई और केसीसी ऋण।",
            icon = "📜",
            categoryKey = "farmer_schemes"
        ),
        CatalogCategory(
            id = "power",
            title = "Power Feeder Schedule",
            titleTe = "కరెంట్ ఫీడర్ షెడ్యూల్",
            titleHi = "बिजली फीडर शेड्यूल",
            description = "Agricultural electricity timings (3-phase day/night schedule).",
            descTe = "వ్యవసాయ విద్యుత్ సమయాలు (3-ఫేజ్ పగలు/రాత్రి సరఫరా షెడ్యూల్).",
            descHi = "कृषि बिजली आपूर्ति समय (3-फेज दिन/रात शेड्यूल)।",
            icon = "⚡",
            categoryKey = "power_schedule"
        ),
        CatalogCategory(
            id = "mandi",
            title = "Agri Mandi Rates",
            titleTe = "వ్యవసాయ మార్కెట్ ధరలు",
            titleHi = "कृषि मंडी भाव",
            description = "Real-time crop & vegetable rates with daily price trends.",
            descTe = "రోజువారీ ధర మార్పులతో నిజ సమయ పంట & కూరగాయల ధరలు.",
            descHi = "दैनिक मूल्य रुझान के साथ वास्तविक समय फसल और सब्जी दरें।",
            icon = "🌾",
            categoryKey = "mandi_rates"
        ),
        CatalogCategory(
            id = "msp",
            title = "Minimum Support Price",
            titleTe = "కనీస మద్దతు ధర (MSP)",
            titleHi = "न्यूनतम समर्थन मूल्य (MSP)",
            description = "Government mandated minimum support prices for major crops.",
            descTe = "ప్రధాన పంటలకు ప్రభుత్వం నిర్ణయించిన కనీస మద్దతు ధరలు.",
            descHi = "प्रमुख फसलों के लिए सरकार द्वारा निर्धारित न्यूनतम समर्थन मूल्य।",
            icon = "🏷️",
            categoryKey = "msp_rates"
        ),
        CatalogCategory(
            id = "machinery",
            title = "Tractor & Machinery Rent",
            titleTe = "ట్రాక్టర్ & యంత్రాల అద్దె",
            titleHi = "ट्रैक्टर और मशीनरी किराया",
            description = "Tractors, rotavators, and harvesters available for local sharing.",
            descTe = "స్థానికంగా అద్దెకు లభించే ట్రాక్టర్లు, రోటవేటర్లు మరియు హార్వెస్టర్లు.",
            descHi = "स्थानीय स्तर पर किराए के लिए उपलब्ध ट्रैक्टर, रोटावेटर और हार्वेस्टर।",
            icon = "🚜",
            categoryKey = "machinery_rent"
        ),
        CatalogCategory(
            id = "crop",
            title = "Crop Advisories",
            titleTe = "పంట సలహాలు & సూచనలు",
            titleHi = "फसल सलाह और सुझाव",
            description = "Pest controls, fertilizer dosages, and seasonal advisories.",
            descTe = "పురుగు మందుల నివారణ, ఎరువుల మోతాదు మరియు కాలానుగుణ సూచనలు.",
            descHi = "कीट नियंत्रण, उर्वरक की खुराक और मौसमी सलाह।",
            icon = "🌱",
            categoryKey = "crop_advisory"
        ),
        CatalogCategory(
            id = "water",
            title = "Water Levels",
            titleTe = "జలాశయ నీటి మట్టాలు",
            titleHi = "जल स्तर और जलाशय",
            description = "Reservoirs capacities, current levels, and inflow updates.",
            descTe = "జలాశయాల సామర్థ్యం, ప్రస్తుత నీటి మట్టాలు మరియు వరద ప్రవాహం.",
            descHi = "जलाशयों की क्षमता, वर्तमान जल स्तर और आवक की जानकारी।",
            icon = "💧",
            categoryKey = "water_levels"
        ),
        CatalogCategory(
            id = "repairs",
            title = "Motor & Tractor Repairs",
            titleTe = "మోటార్ & ట్రాక్టర్ మరమ్మతులు",
            titleHi = "मोटर और ट्रैक्टर मरम्मत",
            description = "Local borewell, motor, and tractor mechanics sorted by proximity.",
            descTe = "స్థానిక బోరుబావి, మోటారు వైండింగ్ మరియు ట్రాక్టర్ మెకానిక్‌లు.",
            descHi = "स्थानीय बोरवेल, मोटर वाइंडिंग और ट्रैक्टर मैकेनिक।",
            icon = "🔧",
            categoryKey = "tractor_repairs"
        ),
        CatalogCategory(
            id = "officers",
            title = "Agricultural Support Officers",
            titleTe = "వ్యవసాయ సహాయక అధికారులు",
            titleHi = "कृषि सहायता अधिकारी",
            description = "Contact details for Mandal Agricultural Officer and Rythu Bharosa Kendras.",
            descTe = "మండల వ్యవసాయ అధికారి (MAO) మరియు రైతు భరోసా కేంద్రాల సంప్రదింపులు.",
            descHi = "मंडल कृषि अधिकारी (एमएओ) और रायथू भरोसा केंद्रों के संपर्क विवरण।",
            icon = "👩‍🌾",
            categoryKey = "agri_officers"
        )
    )

    // Live Mandi Rates for Kurnool APMC, Adoni, and Rayalaseema Yards
    val mandiRates: List<MandiCropRate> = listOf(
        MandiCropRate(
            id = "groundnut",
            cropName = LocalizedText(
                en = "Groundnut Pods (Peanuts)",
                te = "వేరుశనగ కాయలు",
                hi = "मूंगफली फली"
            ),
            variety = "JL-24 / K-6 Bold",
            marketYard = "Kurnool APMC Yard",
            minPrice = 6350,
            maxPrice = 8900,
            modalPrice = 8200,
            arrivalTons = "420 Quintals",
            trend = "+₹120",
            isPositiveTrend = true,
            category = "Oilseeds"
        ),
        MandiCropRate(
            id = "chana",
            cropName = LocalizedText(
                en = "Bengal Gram (Desi Chana)",
                te = "శనగలు (దేశీ చనా)",
                hi = "चना (देसी चना)"
            ),
            variety = "JG-11 / Annigeri",
            marketYard = "Kurnool APMC Yard",
            minPrice = 5400,
            maxPrice = 7650,
            modalPrice = 7450,
            arrivalTons = "580 Quintals",
            trend = "+₹50",
            isPositiveTrend = true,
            category = "Pulses"
        ),
        MandiCropRate(
            id = "cotton",
            cropName = LocalizedText(
                en = "Cotton (Kapas)",
                te = "పత్తి (కాపాస్)",
                hi = "कपास (कॉटन)"
            ),
            variety = "Medium/Long Staple Hybrid",
            marketYard = "Adoni Market Yard",
            minPrice = 6200,
            maxPrice = 9450,
            modalPrice = 8850,
            arrivalTons = "1,120 Quintals",
            trend = "-₹40",
            isPositiveTrend = false,
            category = "Commercial"
        ),
        MandiCropRate(
            id = "onion",
            cropName = LocalizedText(
                en = "Onion (Kurnool Red)",
                te = "ఉల్లిపాయలు (కర్నూలు ఎరుపు)",
                hi = "प्याज (कर्नूल लाल)"
            ),
            variety = "Bellary / Kurnool Red",
            marketYard = "Kurnool APMC Vegetable Yard",
            minPrice = 950,
            maxPrice = 4590,
            modalPrice = 3300,
            arrivalTons = "860 Quintals",
            trend = "+₹200",
            isPositiveTrend = true,
            category = "Vegetables"
        ),
        MandiCropRate(
            id = "red_chilli",
            cropName = LocalizedText(
                en = "Dry Red Chilli",
                te = "ఎండిన ఎర్ర మిరపకాయలు",
                hi = "सूखी लाल मिर्च"
            ),
            variety = "Teja / Byadgi Type",
            marketYard = "Kurnool APMC Yard",
            minPrice = 13500,
            maxPrice = 22500,
            modalPrice = 19200,
            arrivalTons = "230 Quintals",
            trend = "+₹350",
            isPositiveTrend = true,
            category = "Commercial"
        ),
        MandiCropRate(
            id = "toor",
            cropName = LocalizedText(
                en = "Red Gram (Toor / Arhar)",
                te = "కందులు (తువర్ పప్పు)",
                hi = "अरहर / तूर दाल"
            ),
            variety = "Maruti / Asha",
            marketYard = "Kurnool APMC Yard",
            minPrice = 8500,
            maxPrice = 10800,
            modalPrice = 10250,
            arrivalTons = "180 Quintals",
            trend = "+₹100",
            isPositiveTrend = true,
            category = "Pulses"
        ),
        MandiCropRate(
            id = "maize",
            cropName = LocalizedText(
                en = "Maize (Corn)",
                te = "మొక్కజొన్న",
                hi = "मक्का (भुट्टा)"
            ),
            variety = "Yellow Hybrid",
            marketYard = "Kurnool APMC Yard",
            minPrice = 2050,
            maxPrice = 2480,
            modalPrice = 2320,
            arrivalTons = "640 Quintals",
            trend = "Stable",
            isPositiveTrend = true,
            category = "Cereals"
        ),
        MandiCropRate(
            id = "jowar",
            cropName = LocalizedText(
                en = "Jowar (Sorghum)",
                te = "తెల్ల జొన్నలు",
                hi = "ज्वार (सफेद ज्वार)"
            ),
            variety = "Maldandi White",
            marketYard = "Kurnool APMC Yard",
            minPrice = 3200,
            maxPrice = 4100,
            modalPrice = 3850,
            arrivalTons = "150 Quintals",
            trend = "+₹80",
            isPositiveTrend = true,
            category = "Cereals"
        ),
        MandiCropRate(
            id = "sunflower",
            cropName = LocalizedText(
                en = "Sunflower Seed",
                te = "పొద్దుతిరుగుడు గింజలు",
                hi = "सूरजमुखी बीज"
            ),
            variety = "High Oil Hybrid",
            marketYard = "Adoni Market Yard",
            minPrice = 5800,
            maxPrice = 7400,
            modalPrice = 6950,
            arrivalTons = "90 Quintals",
            trend = "Stable",
            isPositiveTrend = true,
            category = "Oilseeds"
        ),
        MandiCropRate(
            id = "tomato",
            cropName = LocalizedText(
                en = "Tomato (Hybrid Local)",
                te = "టమోటా (హైబ్రిడ్)",
                hi = "टमाटर (हाइब्रिड)"
            ),
            variety = "Vaishnavi / Saaho",
            marketYard = "Kurnool APMC Vegetable Yard",
            minPrice = 1400,
            maxPrice = 2800,
            modalPrice = 2200,
            arrivalTons = "340 Crates",
            trend = "-₹150",
            isPositiveTrend = false,
            category = "Vegetables"
        ),
        MandiCropRate(
            id = "green_chilli",
            cropName = LocalizedText(
                en = "Green Chilli",
                te = "పచ్చి మిర్చి",
                hi = "हरी मिर्च"
            ),
            variety = "G-4 Hot",
            marketYard = "Kurnool APMC Vegetable Yard",
            minPrice = 3200,
            maxPrice = 4800,
            modalPrice = 4100,
            arrivalTons = "190 Quintals",
            trend = "+₹100",
            isPositiveTrend = true,
            category = "Vegetables"
        ),
        MandiCropRate(
            id = "castor",
            cropName = LocalizedText(
                en = "Castor Seed",
                te = "ఆముదాలు",
                hi = "अरंडी के बीज"
            ),
            variety = "GCH-7",
            marketYard = "Adoni Market Yard",
            minPrice = 5100,
            maxPrice = 6300,
            modalPrice = 5850,
            arrivalTons = "75 Quintals",
            trend = "+₹40",
            isPositiveTrend = true,
            category = "Oilseeds"
        )
    )

    // Official Minimum Support Price (MSP) 2024-25 / 2025-26 (GOI & AP)
    val mspRates: List<MspRateItem> = listOf(
        MspRateItem(
            cropName = LocalizedText(en = "Groundnut in Shell", te = "వేరుశనగ కాయలు", hi = "मूंगफली"),
            variety = "FAQ Grade",
            season = "Kharif 2024-25",
            msp2024 = 6783,
            msp2023 = 6377,
            absoluteIncrease = 406,
            costA2FL = 4522,
            marginPercent = "+50%",
            icon = "🥜"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Bengal Gram (Chana)", te = "శనగలు (గ్రామ్)", hi = "चना"),
            variety = "Desi / FAQ",
            season = "Rabi 2024-25",
            msp2024 = 5650,
            msp2023 = 5440,
            absoluteIncrease = 210,
            costA2FL = 3460,
            marginPercent = "+63%",
            icon = "🫘"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Cotton (Medium Staple)", te = "పత్తి (మీడియం స్టేపుల్)", hi = "कपास (मध्यम स्टेपल)"),
            variety = "Staple Length 24.5-25.5mm",
            season = "Kharif 2024-25",
            msp2024 = 7121,
            msp2023 = 6620,
            absoluteIncrease = 501,
            costA2FL = 4747,
            marginPercent = "+50%",
            icon = "☁️"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Cotton (Long Staple)", te = "పత్తి (లాంగ్ స్టేపుల్)", hi = "कपास (लंबा स्टेपल)"),
            variety = "Staple Length 29.5-30.5mm",
            season = "Kharif 2024-25",
            msp2024 = 7521,
            msp2023 = 7020,
            absoluteIncrease = 501,
            costA2FL = 5014,
            marginPercent = "+50%",
            icon = "☁️"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Paddy (Common)", te = "వరి ధాన్యం (సాధారణ)", hi = "धान (सामान्य)"),
            variety = "Grade FAQ",
            season = "Kharif 2024-25",
            msp2024 = 2300,
            msp2023 = 2183,
            absoluteIncrease = 117,
            costA2FL = 1533,
            marginPercent = "+50%",
            icon = "🌾"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Paddy (Grade A)", te = "వరి ధాన్యం (గ్రేడ్-ఎ)", hi = "धान (ग्रेड-ए)"),
            variety = "Fine Grain / BPT",
            season = "Kharif 2024-25",
            msp2024 = 2320,
            msp2023 = 2203,
            absoluteIncrease = 117,
            costA2FL = 1533,
            marginPercent = "+51%",
            icon = "🌾"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Maize (Corn)", te = "మొక్కజొన్న", hi = "मक्का"),
            variety = "Yellow Hybrid",
            season = "Kharif 2024-25",
            msp2024 = 2225,
            msp2023 = 2090,
            absoluteIncrease = 135,
            costA2FL = 1483,
            marginPercent = "+50%",
            icon = "🌽"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Jowar (Hybrid)", te = "హైబ్రిడ్ జొన్నలు", hi = "ज्वार (हाइब्रिड)"),
            variety = "Grain Sorghum",
            season = "Kharif 2024-25",
            msp2024 = 3371,
            msp2023 = 3180,
            absoluteIncrease = 191,
            costA2FL = 2247,
            marginPercent = "+50%",
            icon = "🌾"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Jowar (Maldandi)", te = "మాల్దండి జొన్నలు", hi = "ज्वार (मालदंडी)"),
            variety = "Rabi White Maldandi",
            season = "Kharif 2024-25",
            msp2024 = 3421,
            msp2023 = 3225,
            absoluteIncrease = 196,
            costA2FL = 2280,
            marginPercent = "+50%",
            icon = "🌾"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Red Gram (Toor / Arhar)", te = "కందులు (తువర్)", hi = "अरहर (तूर)"),
            variety = "FAQ Standard",
            season = "Kharif 2024-25",
            msp2024 = 7550,
            msp2023 = 7000,
            absoluteIncrease = 550,
            costA2FL = 5033,
            marginPercent = "+50%",
            icon = "🥣"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Sunflower Seed", te = "పొద్దుతిరుగుడు", hi = "सूरजमुखी"),
            variety = "Black Seed FAQ",
            season = "Kharif 2024-25",
            msp2024 = 7280,
            msp2023 = 6760,
            absoluteIncrease = 520,
            costA2FL = 4853,
            marginPercent = "+50%",
            icon = "🌻"
        ),
        MspRateItem(
            cropName = LocalizedText(en = "Soybean (Yellow)", te = "సోయాబీన్", hi = "सोयाबीन"),
            variety = "Yellow Grain",
            season = "Kharif 2024-25",
            msp2024 = 4892,
            msp2023 = 4600,
            absoluteIncrease = 292,
            costA2FL = 3261,
            marginPercent = "+50%",
            icon = "🌱"
        )
    )

    // Complete Transport Directory for Orvakal (Airport, Bus Stand, Railways, Autos)
    val transportHub: List<TransportInfo> = listOf(
        TransportInfo(
            id = "airport_kjb",
            type = "flight",
            title = LocalizedText(
                en = "Kurnool Airport (KJB) - Orvakal",
                te = "కర్నూలు విమానాశ్రయం (KJB) - ఓర్వకల్లు",
                hi = "कर्नूल हवाई अड्डा (KJB) - ओरवाकल"
            ),
            subtitle = LocalizedText(
                en = "Commercial Domestic Passenger Airport (IndiGo 6E)",
                te = "వాణిజ్య దేశీయ ప్రయాణీకుల విమానాశ్రయం (ఇండిగో)",
                hi = "वाणिज्यिक घरेलू यात्री हवाई अड्डा (इंडिगो)"
            ),
            location = "NH-40 Highway, Thummalapenta, Orvakal Mandal",
            distance = "Right inside Orvakal (4 km from Village Center)",
            timingsOrFrequency = LocalizedText(
                en = "Operating Daily Flight Connections",
                te = "ప్రతిరోజూ విమాన సర్వీసులు అందుబాటులో ఉన్నాయి",
                hi = "प्रतिदिन सीधी उड़ान सेवाएं"
            ),
            keyRoutes = listOf(
                "✈️ Bengaluru (BLR): IndiGo 6E-7911 (10:45 AM - Mon, Wed, Fri, Sun)",
                "✈️ Visakhapatnam (VTZ): IndiGo 6E-7923 (01:20 PM - Mon, Wed, Fri)",
                "✈️ Chennai (MAA): IndiGo 6E-7925 (02:40 PM - Tue, Thu, Sat)",
                "✈️ Return Flight from BLR: IndiGo 6E-7912 (09:15 AM)"
            ),
            contactPhone = "08518-285001",
            details = LocalizedText(
                en = "Equipped with passenger lounge, baggage scanners, pre-paid taxi counter, VIP lounge, and parking space.",
                te = "విమానాశ్రయంలో ప్యాసింజర్ లాంజ్, లగేజ్ స్కానర్లు, ప్రీ-పెయిడ్ టాక్సీ కౌంటర్, విశాలమైన పార్కింగ్ కలవు.",
                hi = "यात्री लाउंज, बैगेज स्कैनर, प्रीपेड टैक्सी काउंटर और पार्किंग से सुसज्जित।"
            ),
            icon = "✈️"
        ),
        TransportInfo(
            id = "bus_stand",
            type = "bus",
            title = LocalizedText(
                en = "APSRTC Orvakal Bus Stand (NH-40 Junction)",
                te = "ఏపీఎస్ ఆర్టీసీ ఓర్వకల్లు బస్టాండ్ (NH-40 జంక్షన్)",
                hi = "एपीएसआरटीसी ओरवाकल बस स्टैंड (एनएच-40 जंक्शन)"
            ),
            subtitle = LocalizedText(
                en = "Continuous Express, Ultra Deluxe & Palle Velugu Services",
                te = "నిరంతర ఎక్స్‌ప్రెస్, అల్ట్రా డీలక్స్ మరియు పల్లె వెలుగు బస్సులు",
                hi = "निरंतर एक्सप्रेस और पल्ले वेलुगु बस सेवाएं"
            ),
            location = "Beside NH-40 Kurnool-Nandyal Highway, Orvakal",
            distance = "0 km (Main Village Highway Entrance)",
            timingsOrFrequency = LocalizedText(
                en = "24 Hours Continuous Frequency",
                te = "24 గంటలు నిరంతర బస్సు సౌకర్యం",
                hi = "24 घंटे निरंतर बस सुविधा"
            ),
            keyRoutes = listOf(
                "🚌 Kurnool City: Every 10-15 Minutes (Fare: ₹30, 22 km ~30 mins)",
                "🚌 Nandyal (via Panyam): Every 20 Minutes (Fare: ₹55, 50 km)",
                "🚌 Betamcherla & Banaganapalle: Every 30 Minutes",
                "🚌 Hyderabad (MGBS/Jubilee): Every 1 Hour (Deluxe/Super Luxury stops)",
                "🚌 Tirupati & Kadapa: Regular Express & Night Sleeper buses",
                "🚌 Bengaluru (Majestic): Night Deluxe & Super Luxury services"
            ),
            contactPhone = "08518-220022",
            details = LocalizedText(
                en = "Main transit point with passenger waiting hall, refreshment stalls, digital inquiry, and RTC student pass renewal facility.",
                te = "ప్రయాణీకుల వేచి ఉండే హాల్, టీ స్టాల్స్, ఆర్టీసీ స్టూడెంట్ పాస్ సమాచార కేంద్రం కలదు.",
                hi = "यात्री प्रतीक्षालय, जलपान स्टॉल और छात्र बस पास सहायता केंद्र।"
            ),
            icon = "🚌"
        ),
        TransportInfo(
            id = "railway_kurnool",
            type = "train",
            title = LocalizedText(
                en = "Kurnool City Railway Station (KLU)",
                te = "కర్నూలు సిటీ రైల్వే స్టేషన్ (KLU)",
                hi = "कर्नूल सिटी रेलवे स्टेशन (KLU)"
            ),
            subtitle = LocalizedText(
                en = "A-Category Major Station on Hyderabad-Dhone-Bengaluru Line",
                te = "హైదరాబాద్-డోన్-బెంగళూరు మార్గంలో ప్రధాన రైల్వే స్టేషన్",
                hi = "हैदराबाद-धोने-बेंगलुरु लाइन पर प्रमुख स्टेशन"
            ),
            location = "Station Road, Kurnool City, AP",
            distance = "22 km from Orvakal (~25 mins via NH-40)",
            timingsOrFrequency = LocalizedText(
                en = "Over 60+ Express & Superfast Trains Daily",
                te = "రోజుకు 60 కంటే ఎక్కువ ఎక్స్‌ప్రెస్ రైళ్లు",
                hi = "प्रतिदिन 60 से अधिक एक्सप्रेस ट्रेनें"
            ),
            keyRoutes = listOf(
                "🚆 Vande Bharat Express: Kacheguda (HYD) ⇄ Yesvantpur (BLR)",
                "🚆 Tungabhadra Express: Kurnool ⇄ Secunderabad (Daily Morning)",
                "🚆 Hundry Express: Kurnool ⇄ Gunadala/Vijayawada",
                "🚆 Venkatadri & Rayalaseema Express: To Tirupati, Chittor & Nizamabad",
                "🚆 AP Sampark Kranti Express: To New Delhi Hazrat Nizamuddin",
                "🚆 Prashanti & Amaravati Express: To Visakhapatnam & Bhubaneswar"
            ),
            contactPhone = "139",
            details = LocalizedText(
                en = "Equipped with computerized PRS reservation counters, escalators, IRCTC food plaza, waiting lounges, and 24/7 taxi service.",
                te = "కంప్యూటరైజ్డ్ రిజర్వేషన్ కౌంటర్లు, ఎస్కలేటర్లు, ఫుడ్ ప్లాజా మరియు 24/7 టాక్సీ సౌకర్యం కలదు.",
                hi = "कम्प्यूटरीकृत आरक्षण काउंटर, एस्केलेटर, आईआरसीटीसी फूड प्लाजा और 24/7 टैक्सी।"
            ),
            icon = "🚆"
        ),
        TransportInfo(
            id = "railway_betamcherla",
            type = "train",
            title = LocalizedText(
                en = "Betamcherla Railway Station (BMH)",
                te = "బేతంచెర్ల రైల్వే స్టేషన్ (BMH)",
                hi = "बेतमचेरला रेलवे स्टेशन (BMH)"
            ),
            subtitle = LocalizedText(
                en = "Guntur-Guntakal Railway Route Station",
                te = "గుంటూరు-గుంతకల్లు రైల్వే మార్గ స్టేషన్",
                hi = "गुंटूर-गुंतकल रेलवे लाइन स्टेशन"
            ),
            location = "Betamcherla Town",
            distance = "30 km from Orvakal (~35 mins)",
            timingsOrFrequency = LocalizedText(
                en = "Daily Passenger & Express Train Stoppages",
                te = "రోజువారీ ప్యాసింజర్ మరియు ఎక్స్‌ప్రెస్ రైళ్లు",
                hi = "दैनिक पैसेंजर और एक्सप्रेस ट्रेन ठहराव"
            ),
            keyRoutes = listOf(
                "🚆 Guntur - Guntakal Passenger: Morning & Evening Services",
                "🚆 Nandyal - Dhone Passenger: Connects all local mandal towns",
                "🚆 Hubli - Vijayawada Express: Connecting Coastal AP & Karnataka"
            ),
            contactPhone = "139",
            details = LocalizedText(
                en = "Ideal station for freight movement of slab stone and passenger access toward Guntakal & Nandyal junctions.",
                te = "స్లాబ్ రాళ్ళ రవాణా మరియు గుంతకల్లు, నంద్యాల వైపు ప్రయాణానికి సమీప స్టేషన్.",
                hi = "गुंतकल और नंद्याल जंक्शन के लिए सुविधाजनक निकटतम स्टेशन।"
            ),
            icon = "🚉"
        ),
        TransportInfo(
            id = "railway_dhone",
            type = "train",
            title = LocalizedText(
                en = "Dhone Junction Railway Station (DHNE)",
                te = "డోన్ జంక్షన్ రైల్వే స్టేషన్ (DHNE)",
                hi = "धोने जंक्शन रेलवे स्टेशन (DHNE)"
            ),
            subtitle = LocalizedText(
                en = "Major Four-Line Railway Junction",
                te = "నాలుగు మార్గాల ప్రధాన రైల్వే జంక్షన్",
                hi = "चार दिशाओं को जोड़ने वाला प्रमुख रेलवे जंक्शन"
            ),
            location = "Dhone, Kurnool District",
            distance = "45 km from Orvakal (~45 mins via NH)",
            timingsOrFrequency = LocalizedText(
                en = "Connecting Hyderabad, Bengaluru, Guntur & Guntakal",
                te = "హైదరాబాద్, బెంగళూరు, గుంటూరు మరియు గుంతకల్లు మార్గాలు",
                hi = "हैदराबाद, बेंगलुरु, गुंटूर और गुंतकल को जोड़ने वाला जंक्शन"
            ),
            keyRoutes = listOf(
                "🚆 Bangalore Express & Superfast Services",
                "🚆 Goa Express (Vasco Da Gama ⇄ Hazrat Nizamuddin)",
                "🚆 Direct trains to Tirupati, Coimbatore, Hubli and Mumbai"
            ),
            contactPhone = "139",
            details = LocalizedText(
                en = "Crucial railway interchange offering extensive long-distance train options across India.",
                te = "దక్షిణ మరియు ఉత్తర భారతదేశంలోని పలు నగరాలకు నేరుగా రైలు ప్రయాణ సౌకర్యం కలదు.",
                hi = "देश भर में लंबी दूरी की ट्रेनों के लिए महत्वपूर्ण रेलवे जंक्शन।"
            ),
            icon = "🚉"
        ),
        TransportInfo(
            id = "local_auto_taxi",
            type = "auto",
            title = LocalizedText(
                en = "Local Auto Stands & Airport Taxis",
                te = "స్థానిక ఆటో స్టాండ్‌లు & ఎయిర్‌పోర్ట్ టాక్సీలు",
                hi = "स्थानीय ऑटो स्टैंड और हवाई अड्डा टैक्सी"
            ),
            subtitle = LocalizedText(
                en = "Shared Autos & Private Hire for Villages & Industrial Hub",
                te = "గ్రామాలు మరియు ఇండస్ట్రియల్ హబ్ కోసం షేరింగ్ మరియు ప్రైవేట్ ఆటోలు",
                hi = "गांवों और औद्योगिक हब के लिए शेयरिंग और प्राइवेट ऑटो"
            ),
            location = "1. Main Bazar Stand, 2. Highway Bus Stop, 3. Airport Gate",
            distance = "Available across all central points",
            timingsOrFrequency = LocalizedText(
                en = "05:30 AM to 10:30 PM (24/7 on call for airport)",
                te = "ఉదయం 5:30 నుండి రాత్రి 10:30 వరకు (ఎయిర్‌పోర్ట్ కోసం 24/7 అందుబాటు)",
                hi = "सुबह 5:30 से रात 10:30 तक (हवाई अड्डे के लिए 24/7 कॉल पर)"
            ),
            keyRoutes = listOf(
                "🛺 Main Bazar ⇄ Highway Bus Stand: ₹15 shared",
                "🛺 Orvakal ⇄ Kurnool Airport (KJB): ₹100-₹150 private auto / ₹300 cab",
                "🛺 Orvakal ⇄ Kalva / Kalvabugga: ₹20 shared",
                "🛺 Orvakal ⇄ Sakunala Solar Park: ₹25 shared / ₹200 private",
                "🛺 Orvakal ⇄ Guttapadu / Budawada Industrial Zone: ₹25 shared"
            ),
            contactPhone = "+91 98492 11022",
            details = LocalizedText(
                en = "Local union auto stands provide safe, economical transport connecting interior thandas, villages, farmlands, and factory premises.",
                te = "గ్రామీణ తండాలు, వ్యవసాయ పొలాలు మరియు పరిశ్రమలకు సురక్షితమైన ప్రయాణ సేవలు.",
                hi = "स्थानीय गांवों, खेतों और कारखानों के लिए किफायती और सुरक्षित ऑटो सेवा।"
            ),
            icon = "🛺"
        )
    )

    // Agricultural 3-Phase Power Feeder Schedule (APSPDCL Orvakal 33/11kV)
    val powerFeeders: List<PowerFeederInfo> = listOf(
        PowerFeederInfo(
            groupName = LocalizedText(
                en = "Feeder Group A (Day Shift - Orvakal & Kalva)",
                te = "ఫీడర్ గ్రూప్-ఎ (పగటి పూట - ఓర్వకల్లు & కాల్వ)",
                hi = "फीडर ग्रुप-ए (दिन की पाली - ओरवाकल और कालवा)"
            ),
            villagesCovered = "Orvakal South, Kalva, Sakunala, N.Konthalapadu",
            supplySlot1 = "06:00 AM – 03:00 PM (Continuous 9 Hours Daytime)",
            supplySlot2 = "Single Phase lighting available 24/7",
            totalHours = "9 Hours Free Ag Power",
            phase = "3-Phase Agricultural",
            status = "Supply Active (Normal Voltage)",
            icon = "⚡"
        ),
        PowerFeederInfo(
            groupName = LocalizedText(
                en = "Feeder Group B (Split Shift - Budawada & Guttapadu)",
                te = "ఫీడర్ గ్రూప్-బి (విభజిత సమయం - బుడవాడ & గుట్టపాడు)",
                hi = "फीडर ग्रुप-बी (विभाजित पाली - बुडावाड़ा और गुट्टापाडू)"
            ),
            villagesCovered = "Budawada, Guttapadu, Lodipalle, Pudicherla",
            supplySlot1 = "08:30 AM – 01:30 PM (5 Hours Day)",
            supplySlot2 = "10:30 PM – 02:30 AM (4 Hours Night)",
            totalHours = "9 Hours Free Ag Power",
            phase = "3-Phase Agricultural",
            status = "Supply Active (Rotational)",
            icon = "⚡"
        ),
        PowerFeederInfo(
            groupName = LocalizedText(
                en = "Feeder Group C (Pinnapuram & Thummalapenta)",
                te = "ఫీడర్ గ్రూప్-సి (పిన్నాపురం & తుమ్మలపెంట)",
                hi = "फीडर ग्रुप-सी (पिन्नापुरम और थुम्मलापेंटा)"
            ),
            villagesCovered = "Pinnapuram, Thummalapenta, Komma Cheruvu, Gudumbai Tanda",
            supplySlot1 = "07:00 AM – 04:00 PM (Continuous 9 Hours)",
            supplySlot2 = "Single Phase 24/7",
            totalHours = "9 Hours Free Ag Power",
            phase = "3-Phase Agricultural",
            status = "Supply Active",
            icon = "⚡"
        )
    )

    // Tractor & Farm Machinery Rental Catalog
    val machineryRentList: List<MachineryRentItem> = listOf(
        MachineryRentItem(
            name = LocalizedText(en = "Rotavator (రోటవేటర్)", te = "రోటవేటర్ (Rotavator)", hi = "रोटावेटर"),
            category = "Soil Preparation",
            rentPerHour = "₹1,100 / Hour",
            ownerName = "Venkateswarlu Reddy",
            village = "Orvakal Main Bazar",
            phone = "+91 98492 45671",
            details = LocalizedText(
                en = "Heavy-duty 42-blade rotavator suitable for breaking hard clods and puddle preparation.",
                te = "గట్టి నేలలను దున్నడానికి 42 బ్లేడ్ల హెవీ డ్యూటీ రోటవేటర్. డీజిల్ మరియు ఆపరేటర్ కలిపి.",
                hi = "मिट्टी को भुरभुरा करने के लिए 42-ब्लेड रोटावेटर।"
            ),
            icon = "🚜"
        ),
        MachineryRentItem(
            name = LocalizedText(en = "9-Tyne Cultivator (గుంటిక)", te = "9-టైన్ కల్టివేటర్ (గుంటిక)", hi = "कल्टीवेटर (9-टाइन)"),
            category = "Tilling & Weeding",
            rentPerHour = "₹850 / Hour",
            ownerName = "K. Ramanjaneyulu",
            village = "Near Bus Stand, Orvakal",
            phone = "+91 94408 33219",
            details = LocalizedText(
                en = "Spring loaded 9-tyne cultivator for primary tilling, weed clearing, and soil aeration.",
                te = "పొలం దున్నడానికి, కలుపు తీయడానికి స్ప్రింగ్ లోడెడ్ కల్టివేటర్.",
                hi = "खेत की जुताई और खरपतवार निकालने के लिए।"
            ),
            icon = "🚜"
        ),
        MachineryRentItem(
            name = LocalizedText(en = "Combine Harvester (హార్వెస్టర్)", te = "కంబైన్ హార్వెస్టర్", hi = "कंबाइन हार्वेस्टर"),
            category = "Harvesting",
            rentPerHour = "₹2,400 / Hour",
            ownerName = "Srinivasa Agro Machinery",
            village = "Highway Road, Orvakal",
            phone = "+91 99891 77654",
            details = LocalizedText(
                en = "Multicrop track harvester for Paddy, Bengal Gram (Chana), and Maize with minimal grain loss.",
                te = "వరి, శనగలు, మొక్కజొన్న కోత కోయడానికి మరియు ధాన్యం నూర్పిడికి అనుకూలం.",
                hi = "धान, चना और मक्का कटाई व थ्रेशिंग के लिए।"
            ),
            icon = "🌾"
        ),
        MachineryRentItem(
            name = LocalizedText(en = "Groundnut Pod Digger & Thresher", te = "వేరుశనగ కోత & ఊడదీసే యంత్రం", hi = "मूंगफली डिगर व थ्रेशर"),
            category = "Harvesting & Threshing",
            rentPerHour = "₹1,400 / Hour",
            ownerName = "B. Mallikarjuna",
            village = "Kalva Road, Orvakal",
            phone = "+91 94901 88723",
            details = LocalizedText(
                en = "Tractor PTO driven groundnut digger and clean pod separation thresher unit.",
                te = "వేరుశనగ కాయలు రాలకుండా మట్టి వేరుచేసి శుభ్రపరిచే అత్యాధునిక యంత్రం.",
                hi = "मूंगफली उखाड़ने और फली अलग करने की मशीन।"
            ),
            icon = "🥜"
        ),
        MachineryRentItem(
            name = LocalizedText(en = "Seed-cum-Fertilizer Drill (గొర్రు)", te = "విత్తనం & ఎరువుల గొర్రు", hi = "सीड ड्रिल (बीज व खाद)"),
            category = "Sowing",
            rentPerHour = "₹950 / Hour",
            ownerName = "Chandra Sekhar",
            village = "Orvakal Village",
            phone = "+91 96180 55432",
            details = LocalizedText(
                en = "Automatic seed and fertilizer spacing drill for Groundnut, Bengal Gram, and Jowar.",
                te = "వేరుశనగ, శనగలు సమాన దూరంలో విత్తనాలు మరియు ఎరువు ఒకేసారి వేయుటకు.",
                hi = "सटीक दूरी पर बीज और खाद डालने के लिए।"
            ),
            icon = "🌱"
        )
    )

    // Seasonal Regional Crop Advisories
    val cropAdvisories: List<CropAdvisoryItem> = listOf(
        CropAdvisoryItem(
            crop = LocalizedText(en = "Groundnut (వేరుశనగ)", te = "వేరుశనగ (Groundnut)", hi = "मूंगफली"),
            stage = LocalizedText(en = "Flowering to Pegging (35-50 Days)", te = "పూత మరియు ఊడలు దిగే దశ (35-50 రోజులు)", hi = "फूल और खूंटी बनने की अवस्था"),
            problem = LocalizedText(
                en = "Tikka Leaf Spot & Stem Rot (కాండం కుళ్లు తెగులు)",
                te = "తిక్కా ఆకుమచ్చ మరియు కాండం కుళ్లు తెగులు",
                hi = "टिक्का पत्ती धब्बा और तना सड़न"
            ),
            solution = LocalizedText(
                en = "Spray Mancozeb @ 2.5 g/L or Tebuconazole @ 1 ml/L. Apply Gypsum @ 200 kg/acre at 45th day near root zone.",
                te = "మ్యాంకోజెబ్ 2.5 గ్రా. లేదా టెబుకోనాజోల్ 1 మి.లీ. లీటరు నీటికి కలిపి పిచికారీ చేయాలి. 45వ రోజు ఎకరాకు 200 కిలోల జిప్సం వేయాలి.",
                hi = "मैंकोजेब 2.5 ग्राम प्रति लीटर पानी में मिलाकर छिड़कें। 45वें दिन 200 किग्रा जिप्सम डालें।"
            ),
            recommendedDosage = "Mancozeb 500g + Gypsum 200kg/acre",
            icon = "🥜"
        ),
        CropAdvisoryItem(
            crop = LocalizedText(en = "Bengal Gram (శనగలు)", te = "శనగలు (Bengal Gram)", hi = "चना"),
            stage = LocalizedText(en = "Pod Formation Stage (45-65 Days)", te = "కాయ తయారయ్యే దశ (45-65 రోజులు)", hi = "फली बनने की अवस्था"),
            problem = LocalizedText(
                en = "Helicoverpa Pod Borer (శనగ పచ్చ పురుగు)",
                te = "శనగ పచ్చ పురుగు (హెలికోవెర్ప)",
                hi = "फली छेदक कीट (हेलिकोवर्पा)"
            ),
            solution = LocalizedText(
                en = "Install 4 pheromone traps/acre. Spray Emamectin Benzoate 5% SG @ 80 g/acre or Chlorantraniliprole 18.5% SC @ 60 ml/acre in 200 L water.",
                te = "ఎకరాకు 4 లింగాకర్షక బుట్టలు పెట్టండి. ఎమామెక్టిన్ బెంజోయేట్ 80 గ్రా లేదా కోరాజెన్ 60 మి.లీ. 200 లీటర్ల నీటిలో కలిపి పిచికారీ చేయాలి.",
                hi = "इमामेक्टिन बेंजोएट 80 ग्राम या कोराजन 60 मिली प्रति एकड़ 200 लीटर पानी में छिड़कें।"
            ),
            recommendedDosage = "Emamectin Benzoate 80g / acre",
            icon = "🫘"
        ),
        CropAdvisoryItem(
            crop = LocalizedText(en = "Cotton (పత్తి)", te = "పత్తి (Cotton)", hi = "कपास"),
            stage = LocalizedText(en = "Boll Development (60-90 Days)", te = "కాయలు ఎదిగే దశ (60-90 రోజులు)", hi = "टिंडे बनने की अवस्था"),
            problem = LocalizedText(
                en = "Pink Bollworm & Sucking Pests (గులాబీ రంగు పురుగు)",
                te = "గులాబీ రంగు కాయ తొలుచు పురుగు మరియు రసం పీల్చే పురుగులు",
                hi = "गुलाबी सुंडी और रस चूसक कीट"
            ),
            solution = LocalizedText(
                en = "Install Pheromone traps @ 5/acre. Spray Profenophos 50% EC @ 400 ml/acre or Spinetoram 11.7% SC @ 170 ml/acre.",
                te = "ఎకరాకు 5 గులాబీ పురుగు బుట్టలు ఏర్పాటు చేయండి. ప్రోఫెనోఫాస్ 400 మి.లీ. లేదా స్పైనిటోరామ్ 170 మి.లీ. పిచికారీ చేయాలి.",
                hi = "फेरोमोन ट्रैप लगाएं। प्रोफेनोफॉस 400 मिली प्रति एकड़ छिड़कें।"
            ),
            recommendedDosage = "Profenophos 400 ml / acre",
            icon = "☁️"
        )
    )
}

