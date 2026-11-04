package com.orvakal.app.data.local

import com.orvakal.app.domain.model.LocalizedText
import com.orvakal.app.domain.model.Scheme

object OrvakalSchemesData {
    val allSchemes: List<Scheme> = listOf(
        Scheme(
            id = "schm-1",
            title = LocalizedText(en = "Thalliki Vandanam", te = "తల్లికి వందనం", hi = "तल्लीकी वंदनम"),
            type = "state",
            category = "education",
            description = LocalizedText(en = "Provides annual financial assistance to mothers or guardians to support children's education, aimed at increasing literacy and reducing dropout rates.", te = "పిల్లల విద్యా వ్యయాలను భరించేందుకు తల్లులకు ఏటా ఆర్థిక సహాయం అందించడం, అక్షరాస్యతను పెంచడం మరియు పాఠశాల మానేసే వారిని తగ్గించడం ఈ పథకం లక్ష్యం.", hi = "बच्चों के शैक्षिक खर्चों में सहायता के लिए माताओं को वार्षिक वित्तीय सहायता प्रदान करता है, जिसका उद्देश्य साक्षरता बढ़ाना और ड्रॉपआउट दर को कम करना है।"),
            benefits = LocalizedText(en = "Financial assistance of ₹15,000 per year per eligible mother.", te = "అర్హులైన ప్రతి తల్లికి ఏడాదికి ₹15,000 ఆర్థిక సహాయం.", hi = "प्रति पात्र माता को ₹15,000 प्रति वर्ष की वित्तीय सहायता।"),
            eligibility = LocalizedText(en = "Mothers or guardians of children attending recognized schools (Class I to XII) in AP, with income and family land holding limits.", te = "ఆంధ్రప్రదేశ్‌లో గుర్తింపు పొందిన పాఠశాలల్లో (1వ తరగతి నుండి 12వ తరగతి వరకు) చదువుతున్న పిల్లల తల్లులు లేదా సంరక్షకులు.", hi = "आंध्र प्रदेश में मान्यता प्राप्त स्कूलों (कक्षा 1 से 12) में पढ़ने वाले बच्चों की माताएं या अभिभावक, जो आय और भूमि सीमा के मानदंडों को पूरा करते हैं।"),
            applyProcess = LocalizedText(en = "Apply through the local Gram/Ward Sachivalayam or designated government educational portals using Aadhaar-linked bank details.", te = "ఆధార్ అనుసంధానమైన బ్యాంక్ ఖాతా వివరాలతో స్థానిక గ్రామ/వార్డు సచివాలయం లేదా నిర్దేశిత ప్రభుత్వ విద్యా పోర్టల్‌ల ద్వారా దరఖాస్తు చేసుకోవచ్చు.", hi = "आधार-लिंक बैंक विवरणों का उपयोग करके स्थानीय ग्राम/वार्ड सचिवालय या निर्दिष्ट सरकारी शैक्षिक पोर्टल के माध्यम से आवेदन करें।")
        ),
        Scheme(
            id = "schm-2",
            title = LocalizedText(en = "NTR Bharosa Pension", te = "ఎన్టీఆర్ భరోసా పెన్షన్", hi = "एनटीआर भरोसा पेंशन"),
            type = "state",
            category = "social security",
            description = LocalizedText(en = "A social security pension scheme providing monthly financial support to senior citizens, widows, persons with disabilities, and other vulnerable groups.", te = "వృద్ధులు, వితంతువులు, దివ్యాంగులు మరియు ఇతర నిస్సహాయ వర్గాలకు నెలవారీ పెన్షన్ అందించే సామాజిక భద్రతా పథకం.", hi = "बुजुर्गों, विधवाओं, विकलांग व्यक्तियों और अन्य कमजोर समूहों को मासिक वित्तीय सहायता प्रदान करने वाली एक सामाजिक सुरक्षा पेंशन योजना।"),
            benefits = LocalizedText(en = "Monthly pension ranging from ₹4,000 to ₹15,000 depending on the category and disability level.", te = "లబ్ధిదారుని వర్గం మరియు వైకల్యం స్థాయిని బట్టి నెలకు ₹4,000 నుండి ₹15,000 వరకు ఆర్థిక సహాయం.", hi = "श्रेणी और विकलांगता के स्तर के आधार पर ₹4,000 से ₹15,000 तक की मासिक पेंशन।"),
            eligibility = LocalizedText(en = "BPL permanent residents of Andhra Pradesh, including specific categories like elderly (60+), widows, weavers, and disabled persons.", te = "ఆంధ్రప్రదేశ్ శాశ్వత నివాసితులైన బిపిఎల్ కుటుంబాలు, ఇందులో వృద్ధులు (60+), వితంతువులు, నేతన్నలు మరియు దివ్యాంగులు వంటి వివిధ వర్గాలు ఉన్నాయి.", hi = "आंध्र प्रदेश के बीपीएल निवासी, जिसमें बुजुर्ग (60+), विधवाएं, बुनकर और विकलांग व्यक्ति जैसे विशिष्ट वर्ग शामिल हैं।"),
            applyProcess = LocalizedText(en = "Apply through the Ward or Village Secretariat network with required identity and category-specific certificates.", te = "అవసరమైన గుర్తింపు మరియు వర్గ ధృవీకరణ పత్రాలతో వార్డు లేదా గ్రామ సచివాలయ వ్యవస్థ ద్వారా దరఖాస్తు చేసుకోవచ్చు.", hi = "आवश्यक पहचान और श्रेणी-विशिष्ट प्रमाण पत्रों के साथ वार्ड या ग्राम सचिवालय नेटवर्क के माध्यम से आवेदन करें।")
        ),
        Scheme(
            id = "schm-3",
            title = LocalizedText(en = "Annadata Sukhibhava", te = "అన్నదాత సుఖీభవ", hi = "अन्नदाता सुखीभव"),
            type = "state",
            category = "agriculture",
            description = LocalizedText(en = "Agricultural investment support for farmers to assist with input costs, often integrated with central PM-KISAN support.", te = "రైతులకు సాగు ఖర్చుల కోసం పెట్టుబడి సాయం అందించే పథకం, ఇది కేంద్ర ప్రభుత్వ పీఎం-కిసాన్ పథకంతో అనుసంధానించబడి ఉంటుంది.", hi = "किसानों को इनपुट लागत में सहायता के लिए कृषि निवेश सहायता, जिसे अक्सर केंद्रीय पीएम-किसान सहायता के साथ एकीकृत किया जाता है।"),
            benefits = LocalizedText(en = "Annual financial assistance of ₹20,000 per farmer family.", te = "ప్రతి రైతు కుటుంబానికి ఏటా ₹20,000 ఆర్థిక సహాయం.", hi = "प्रत्येक किसान परिवार को ₹20,000 की वार्षिक वित्तीय सहायता।"),
            eligibility = LocalizedText(en = "Cultivating farmers in Andhra Pradesh owning agricultural land and meeting BPL requirements.", te = "వ్యవసాయ భూమి కలిగి ఉండి, బిపిఎల్ నిబంధనలను పాటించే ఆంధ్రప్రదేశ్ రైతులు.", hi = "आंध्र प्रदेश में कृषि भूमि के मालिक और बीपीएल आवश्यकताओं को पूरा करने वाले किसान।"),
            applyProcess = LocalizedText(en = "Register via the Agriculture Department portal or visit your local Rythu Bharosa Kendra (RBK).", te = "వ్యవసాయ శాఖ పోర్టల్ ద్వారా లేదా స్థానిక రైతు భరోసా కేంద్రం (RBK) ద్వారా దరఖాస్తు చేసుకోండి.", hi = "कृषि विभाग पोर्टल के माध्यम से पंजीकरण करें या अपने स्थानीय 'रैतु भरोसा केंद्र' (RBK) पर जाएं।")
        ),
        Scheme(
            id = "schm-4",
            title = LocalizedText(en = "Deepam-2", te = "దీపం-2", hi = "दीपन-2"),
            type = "state",
            category = "women",
            description = LocalizedText(en = "Provides three free LPG cylinders annually to eligible female residents to reduce household expenditure and improve health.", te = "కుటుంబ ఖర్చులను తగ్గించడానికి మరియు ఆరోగ్యకరమైన వంట అలవాట్లను ప్రోత్సహించడానికి అర్హులైన మహిళలకు ఏడాదికి మూడు ఉచిత ఎల్‌పీజీ సిలిండర్లు అందించే పథకం.", hi = "घरेलू खर्च को कम करने और स्वास्थ्य में सुधार के लिए पात्र महिला निवासियों को सालाना तीन मुफ्त एलपीजी सिलेंडर प्रदान करता है।"),
            benefits = LocalizedText(en = "Three free LPG cylinders per year (one every four months).", te = "ఏడాదికి మూడు ఉచిత ఎల్‌పీజీ సిలిండర్లు (ప్రతి నాలుగు నెలలకు ఒకటి).", hi = "प्रति वर्ष तीन मुफ्त एलपीजी सिलेंडर (हर चार महीने में एक)।"),
            eligibility = LocalizedText(en = "Permanent female residents of Andhra Pradesh (aged 18+) without other LPG connections in the household.", te = "ఆంధ్రప్రదేశ్ శాశ్వత నివాసితులైన మహిళలు (18 ఏళ్లు పైబడిన వారు), వీరి ఇంట్లో ఇతర ఎల్‌పీజీ కనెక్షన్లు ఉండకూడదు.", hi = "आंध्र प्रदेश की स्थायी महिला निवासी (18+), जिनके घर में कोई अन्य एलपीजी कनेक्शन न हो।"),
            applyProcess = LocalizedText(en = "Apply through the official MeeSeva or state government beneficiary portal with KYC and address proof.", te = "కేవైసీ మరియు చిరునామా ధృవీకరణ పత్రాలతో మీసేవ లేదా రాష్ట్ర ప్రభుత్వ లబ్ధిదారుల పోర్టల్ ద్వారా దరఖాస్తు చేసుకోవచ్చు.", hi = "केवाईसी और पते के प्रमाण के साथ आधिकारिक 'मीसेवा' या राज्य सरकार के लाभार्थी पोर्टल के माध्यम से आवेदन करें।")
        ),
        Scheme(
            id = "schm-5",
            title = LocalizedText(en = "Anna Canteens", te = "అన్న క్యాంటీన్లు", hi = "अन्न कैंटीन"),
            type = "state",
            category = "welfare",
            description = LocalizedText(en = "Provides affordable, subsidized meals to the public to ensure food security for low-income citizens.", te = "తక్కువ ఆదాయం ఉన్న ప్రజలందరికీ ఆహార భద్రతను కల్పించేందుకు సబ్సిడీ ధరలతో కూడిన భోజన వసతిని కల్పించే పథకం.", hi = "कम आय वाले नागरिकों के लिए खाद्य सुरक्षा सुनिश्चित करने के लिए सार्वजनिक रूप से सस्ती और सब्सिडी वाली भोजन सेवा प्रदान करती है।"),
            benefits = LocalizedText(en = "Breakfast, lunch, and dinner at highly subsidized rates (typically ₹5 per meal).", te = "అత్యంత తక్కువ సబ్సిడీ ధరలకు (సాధారణంగా ₹5) అల్పాహారం, మధ్యాహ్న భోజనం మరియు రాత్రి భోజనం.", hi = "अत्यधिक सब्सिडी वाली दरों (आमतौर पर ₹5 प्रति भोजन) पर नाश्ता, दोपहर और रात का भोजन।"),
            eligibility = LocalizedText(en = "Open to all citizens, with a focus on daily wage workers, students, and low-income individuals.", te = "ప్రతి పౌరుడికి అందుబాటులో ఉంటుంది, ముఖ్యంగా దినసరి కూలీలు, విద్యార్థులు మరియు తక్కువ ఆదాయం ఉన్నవారికి ఇది ఎంతో ఉపయోగకరం.", hi = "सभी नागरिकों के लिए खुला है, जिसमें दैनिक वेतन भोगी श्रमिक, छात्र और कम आय वाले व्यक्तियों पर विशेष ध्यान दिया गया है।"),
            applyProcess = LocalizedText(en = "Walk-in service at any authorized Anna Canteen center across the state.", te = "రాష్ట్రవ్యాప్తంగా ఉన్న ఏదైనా అన్న క్యాంటీన్ కేంద్రంలో నేరుగా భోజనం పొందవచ్చు.", hi = "राज्य भर में किसी भी अधिकृत अन्न कैंटीन केंद्र पर जाकर सीधे सेवा प्राप्त करें।")
        ),
        Scheme(
            id = "schm-6",
            title = LocalizedText(en = "Stree Shakti Bus Scheme", te = "స్త్రీ శక్తి బస్సు పథకం", hi = "स्त्री शक्ति बस योजना"),
            type = "state",
            category = "women",
            description = LocalizedText(en = "Provides free bus travel for women, girls, and transgender individuals in state-operated buses to enhance mobility and safety.", te = "మహిళలు, బాలికలు మరియు ట్రాన్స్‌జెండర్ల ప్రయాణ సౌకర్యం మరియు భద్రతను మెరుగుపరిచేందుకు ప్రభుత్వ బస్సులలో ఉచిత ప్రయాణ పథకం.", hi = "महिलाओं, लड़कियों और ट्रांसजेंडर व्यक्तियों के लिए सरकारी बसों में मुफ्त यात्रा, ताकि गतिशीलता और सुरक्षा बढ़ाई जा सके।"),
            benefits = LocalizedText(en = "Free travel in specific categories of APSRTC and APPTD buses.", te = "ఏపీఎస్‌ఆర్‌టీసీ మరియు ఏపీపీటీడీకి చెందిన నిర్దిష్ట రకాల బస్సులలో ఉచిత ప్రయాణం.", hi = "एपीएसआरटीसी और एपीपीटीडी बसों की विशिष्ट श्रेणियों में मुफ्त यात्रा।"),
            eligibility = LocalizedText(en = "Women, girls, and transgender residents of Andhra Pradesh with valid identity proof.", te = "ఆంధ్రప్రదేశ్ నివాసితులైన మహిళలు, బాలికలు మరియు ట్రాన్స్‌జెండర్లు, వీరి వద్ద చెల్లుబాటు అయ్యే గుర్తింపు కార్డు ఉండాలి.", hi = "आंध्र प्रदेश की निवासी महिलाएं, लड़कियां और ट्रांसजेंडर व्यक्ति जिनके पास वैध पहचान पत्र हो।"),
            applyProcess = LocalizedText(en = "Present a valid state-issued photo ID (Aadhaar, Voter ID, etc.) to the bus conductor to receive a zero-fare ticket.", te = "ఉచిత టిక్కెట్ పొందేందుకు బస్సు కండక్టర్‌కు ప్రభుత్వ గుర్తింపు కార్డు (ఆధార్, ఓటర్ ఐడీ మొదలైనవి) చూపాలి.", hi = "शून्य-शुल्क टिकट प्राप्त करने के लिए बस कंडक्टर को राज्य द्वारा जारी वैध फोटो पहचान पत्र (आधार, वोटर आईडी, आदि) दिखाएं।")
        ),
        Scheme(
            id = "schm-7",
            title = LocalizedText(en = "AP Koushalam Scheme", te = "ఏపీ కౌశలం పథకం", hi = "एपी कौशलम योजना"),
            type = "state",
            category = "employment",
            description = LocalizedText(en = "A skill development initiative designed to enhance the employability of youth through training and bridge them to remote/work-from-home job opportunities.", te = "యువతలో నైపుణ్యాలను పెంపొందించి, వారికి శిక్షణ ద్వారా వర్క్-ఫ్రమ్-హోమ్ వంటి ఉద్యోగ అవకాశాలను కల్పించే నైపుణ్య అభివృద్ధి పథకం.", hi = "युवाओं की रोजगार क्षमता बढ़ाने और उन्हें रिमोट/वर्क-फ्रॉम-होम नौकरी के अवसरों से जोड़ने के लिए कौशल विकास पहल।"),
            benefits = LocalizedText(en = "Free skill training, access to a job placement portal, and certification for enhanced career opportunities.", te = "ఉచిత నైపుణ్య శిక్షణ, ఉద్యోగ పోర్టల్ ద్వారా అవకాశాలు మరియు కెరీర్ మెరుగుపరచుకోవడానికి గుర్తింపు సర్టిఫికెట్లు.", hi = "मुफ्त कौशल प्रशिक्षण, नौकरी पोर्टल तक पहुंच, और करियर के बेहतर अवसरों के लिए प्रमाणन।"),
            eligibility = LocalizedText(en = "Unemployed youth in AP, minimum 10th-class qualification, aged 18 years and above.", te = "ఆంధ్రప్రదేశ్‌లో నిరుద్యోగ యువత, కనీసం 10వ తరగతి ఉత్తీర్ణులై ఉండాలి, 18 ఏళ్లు పైబడి ఉండాలి.", hi = "आंध्र प्रदेश में बेरोजगार युवा, न्यूनतम 10वीं कक्षा उत्तीर्ण, आयु 18 वर्ष और उससे अधिक।"),
            applyProcess = LocalizedText(en = "Register through the official Koushalam portal (kaushalam.ap.gov.in) with Aadhaar and educational documents.", te = "అధికారిక కౌశలం పోర్టల్ (kaushalam.ap.gov.in) ద్వారా ఆధార్ మరియు విద్యా ధృవీకరణ పత్రాలతో దరఖాస్తు చేసుకోవాలి.", hi = "आधार और शैक्षिक दस्तावेजों के साथ आधिकारिक कौशलम पोर्टल (kaushalam.ap.gov.in) के माध्यम से पंजीकरण करें।")
        ),
        Scheme(
            id = "schm-8",
            title = LocalizedText(en = "Auto Driver Sevalo Scheme", te = "ఆటో డ్రైవర్ సేవాలో పథకం", hi = "ऑटो ड्राइवर सेवालो योजना"),
            type = "state",
            category = "employment",
            description = LocalizedText(en = "Provides financial assistance to self-employed auto, taxi, and cab drivers to meet maintenance and operational costs.", te = "స్వయం ఉపాధి పొందుతున్న ఆటో, టాక్సీ మరియు క్యాబ్ డ్రైవర్లకు నిర్వహణ ఖర్చుల కోసం ఆర్థిక సహాయం.", hi = "स्व-रोजगार करने वाले ऑटो, टैक्सी और कैब ड्राइवरों को रखरखाव और परिचालन लागत को पूरा करने के लिए वित्तीय सहायता प्रदान करता है।"),
            benefits = LocalizedText(en = "Annual financial assistance of ₹15,000 for vehicle insurance, fitness certificates, and repairs.", te = "వాహన భీమా, ఫిట్‌నెస్ సర్టిఫికెట్లు మరియు రిపేర్ల కోసం ఏడాదికి ₹15,000 ఆర్థిక సహాయం.", hi = "वाहन बीमा, फिटनेस प्रमाण पत्र और मरम्मत के लिए ₹15,000 की वार्षिक वित्तीय सहायता।"),
            eligibility = LocalizedText(en = "Eligible auto, taxi, and maxi-cab drivers who are BPL residents of Andhra Pradesh.", te = "ఆంధ్రప్రదేశ్‌లో బిపిఎల్ కుటుంబాలకు చెందిన అర్హులైన ఆటో, టాక్సీ మరియు మ్యాక్సీ క్యాబ్ డ్రైవర్లు.", hi = "आंध्र प्रदेश के बीपीएल निवासी पात्र ऑटो, टैक्सी और मैक्सी-कैब ड्राइवर।"),
            applyProcess = LocalizedText(en = "Apply through the official transport portal or via local municipal/rural body offices.", te = "అధికారిక రవాణా పోర్టల్ ద్వారా లేదా స్థానిక మున్సిపల్/గ్రామీణ కార్యాలయాల ద్వారా దరఖాస్తు చేసుకోవాలి.", hi = "आधिकारिक परिवहन पोर्टल या स्थानीय नगर/ग्रामीण निकाय कार्यालयों के माध्यम से आवेदन करें।")
        ),
        Scheme(
            id = "schm-9",
            title = LocalizedText(en = "Nethanna Bharosa", te = "నేతన్న భరోసా", hi = "नेथनना भरोसा"),
            type = "state",
            category = "employment",
            description = LocalizedText(en = "Financial support and welfare benefits for registered handloom weaver families to stabilize and increase their income.", te = "రిజిస్టర్డ్ నేతన్న కుటుంబాలకు ఆర్థిక స్థిరత్వం మరియు ఆదాయం పెంచేందుకు ఆర్థిక సహాయం మరియు సంక్షేమ ప్రయోజనాలు.", hi = "पंजीकृत बुनकर परिवारों के लिए वित्तीय स्थिरता और आय बढ़ाने के लिए वित्तीय सहायता और कल्याणकारी लाभ।"),
            benefits = LocalizedText(en = "Annual financial assistance of ₹25,000, 200 units of free electricity, and GST reimbursement.", te = "ఏటా ₹25,000 ఆర్థిక సహాయం, నెలకు 200 యూనిట్ల ఉచిత విద్యుత్ మరియు జీఎస్టీ రీయింబర్స్‌మెంట్.", hi = "₹25,000 की वार्षिक वित्तीय सहायता, 200 यूनिट मुफ्त बिजली, और जीएसटी प्रतिपूर्ति।"),
            eligibility = LocalizedText(en = "Registered handloom weaver families in Andhra Pradesh holding an APCO/Weavers Department membership card.", te = "ఏపీసీఓ/నేతన్న శాఖ మెంబర్‌షిప్ కార్డు కలిగిన ఆంధ్రప్రదేశ్ రిజిస్టర్డ్ నేతన్న కుటుంబాలు.", hi = "आंध्र प्रदेश में एपीसीओ (APCO) या बुनकर विभाग सदस्यता कार्ड रखने वाले पंजीकृत बुनकर परिवार।"),
            applyProcess = LocalizedText(en = "Registration with the state APCO/Weavers Department grants automatic enrollment in the beneficiary list.", te = "ఏపీసీఓ/నేతన్న శాఖలో నమోదు చేసుకోవడం ద్వారా లబ్ధిదారుల జాబితాలో ఆటోమేటిక్‌గా చేర్చబడతారు.", hi = "राज्य के एपीसीओ (APCO) या बुनकर विभाग में पंजीकरण लाभार्थी सूची में स्वतः नामांकन सुनिश्चित करता है।")
        ),
        Scheme(
            id = "schm-10",
            title = LocalizedText(en = "AP BOCW Welfare Board Scheme", te = "ఏపీ భవన నిర్మాణ కార్మికుల సంక్షేమ బోర్డు పథకం", hi = "एपी भवन और अन्य निर्माण श्रमिक कल्याण बोर्ड योजना"),
            type = "state",
            category = "employment",
            description = LocalizedText(en = "Social security and welfare measures for construction workers, including insurance, medical, and educational support.", te = "నిర్మాణ కార్మికులకు భీమా, వైద్య మరియు విద్యా సహాయంతో సహా సామాజిక భద్రత మరియు సంక్షేమ చర్యలు.", hi = "निर्माण श्रमिकों के लिए बीमा, चिकित्सा और शैक्षिक सहायता सहित सामाजिक सुरक्षा और कल्याणकारी उपाय।"),
            benefits = LocalizedText(en = "₹5 lakh accident insurance, ₹1,500/month pension (60+), education scholarships, and maternity benefits.", te = "₹5 లక్షల ప్రమాద భీమా, నెలకు ₹1,500 పెన్షన్ (60+), విద్యా ఉపకార వేతనాలు మరియు ప్రసూతి ప్రయోజనాలు.", hi = "₹5 लाख दुर्घटना बीमा, ₹1,500/माह पेंशन (60+), शैक्षिक छात्रवृत्ति और मातृत्व लाभ।"),
            eligibility = LocalizedText(en = "Registered construction workers (masons, carpenters, etc.) in AP who have worked 90 days in the previous year.", te = "గత సంవత్సరంలో 90 రోజులు పని చేసిన రిజిస్టర్డ్ నిర్మాణ కార్మికులు (మేస్త్రీలు, వడ్రంగులు మొదలైనవారు).", hi = "आंध्र प्रदेश में पंजीकृत निर्माण श्रमिक (राजमिस्त्री, बढ़ई, आदि) जिन्होंने पिछले वर्ष में 90 दिन काम किया हो।"),
            applyProcess = LocalizedText(en = "Apply through the official BOCW portal (bocwwb.ap.gov.in) or visit the nearest Labour Department office.", te = "అధికారిక BOCW పోర్టల్ (bocwwb.ap.gov.in) ద్వారా లేదా సమీపంలోని కార్మిక శాఖ కార్యాలయం ద్వారా దరఖాస్తు చేసుకోవాలి.", hi = "आधिकारिक BOCW पोर्टल (bocwwb.ap.gov.in) के माध्यम से आवेदन करें या निकटतम श्रम विभाग कार्यालय पर जाएं।")
        ),
        Scheme(
            id = "can-schm-1",
            title = LocalizedText(en = "Kisan Credit Card (Canara Bank)", te = "కిసాన్ క్రెడిట్ కార్డ్ (కనరా బ్యాంక్)", hi = "किसान क्रेडिट कार्ड (कनरा बैंक)"),
            type = "bank",
            category = "farmer",
            description = LocalizedText(en = "Short‑term credit facility for crop production and allied agricultural needs offered by Canara Bank.", te = "పంట ఉత్పత్తి మరియు అనుబంధ వ్యవసాయ అవసరాల కోసం కనరా బ్యాంక్ అందించే తాత్కాలిక క్రెడిట్ సౌకర్యం.", hi = "फसल उत्पादन और संबद्ध कृषि आवश्यकताओं के लिए कनरा बैंक द्वारा प्रदान की जाने वाली अल्पकालिक क्रेडिट सुविधा।"),
            benefits = LocalizedText(en = "Flexible limits, interest subvention schemes where applicable, overdraft and seasonal repayment options.", te = "సౌకర్యవంతమైన పరిమితులు, వర్తించగల వడ్డీ ఉపసంహరణలు, ఓవర్‌డ్రాఫ్ట్ మరియు సీజనల్ రీపేమెంట్ ఎంపికలు.", hi = "लचीली सीमाएँ, लागू होने पर ब्याज उपवेशन, ओवरड्राफ्ट और मौसमी पुनर्भुगतान विकल्प।"),
            eligibility = LocalizedText(en = "Individual farmers, tenant farmers and JLGs meeting Canara Bank norms and KYC requirements.", te = "కనరా బ్యాంక్ నిబంధనలు మరియు KYC అవసరాలు తీరిన వ్యక్తిగత/అద్దె రైతులు మరియు JLGలు.", hi = "कनरा बैंक मानदंड और KYC आवश्यकताएँ पूरी करने वाले व्यक्तिगत/किरायेदार किसान और JLG।"),
            applyProcess = LocalizedText(en = "Apply at nearest Canara Bank branch or via Agri desk; submit land documents, KYC and crop plan for sanction.", te = "సమీప కనరా బ్యాంక్ శాఖలో లేదా అగ్రి డెస్క్ ద్వారా దరఖాస్తు చేయండి; భూమి పత్రాలు, KYC మరియు పంట ప్రణాళిక సమర్పించండి.", hi = "निकटतम कनरा बैंक शाखा या एग्री डेस्क पर आवेदन करें; भूमि दस्तावेज़, KYC और फसल योजना जमा करें।")
        ),
        Scheme(
            id = "can-schm-2",
            title = LocalizedText(en = "Canara Stree Shakti (Women Entrepreneurs)", te = "కనరా స్ట్రీ శక్తి (మహిళా వ్యాపారులు)", hi = "कनरा स्त्री शक्ति (महिला उद्यमी)"),
            type = "bank",
            category = "women",
            description = LocalizedText(en = "Specialised lending and support package for women entrepreneurs including concessional loans and handholding.", te = "మహిళా వ్యాపారులకు సౌకర్యవంతమైన రుణాలు మరియు మద్దతు ప్యాకేజ్.", hi = "महिला उद्यमियों के लिए विशेष ऋण और सहायता पैकेज।"),
            benefits = LocalizedText(en = "Preferential interest rates, tailored loan products, and business advisory support through branches.", te = "ప్రాధాన్యత వడ్డీ రేట్లు, ప్రత్యేక రుణ ఉత్పత్తులు మరియు వ్యాపార సలహా మద్దతు.", hi = "प्राथमिकता ब्याज दरें, विशेष ऋण उत्पाद और व्यावसायिक परामर्श सहायता।"),
            eligibility = LocalizedText(en = "Women proprietors, SHGs and women‑led micro/small enterprises meeting bank criteria.", te = "మహిళా యజమానులు, SHGలు మరియు మహిళల ఆధ్వర్యంలోని సూక్ష్మ/చిన్న సంస్థలు.", hi = "महिला स्वामित्व वाले, SHG और महिला-नेतृत्व वाले सूक्ष्म/लघु उद्यम।"),
            applyProcess = LocalizedText(en = "Approach Canara Bank branch or MSME cell with business plan, KYC and financials for loan appraisal.", te = "వ్యాపార ప్రణాళిక, KYC మరియు ఆర్థిక పత్రాలతో శాఖకు సంప్రదించండి.", hi = "व्यवसाय योजना, KYC और वित्तीय दस्तावेज़ के साथ शाखा या MSME सेल से संपर्क करें।")
        ),
        Scheme(
            id = "sbi-schm-1",
            title = LocalizedText(en = "PM SVANidhi (via SBI)", te = "పీఎమ్ స్వనిధి (SBI ద్వారా)", hi = "पीएम स्वनिधि (SBI के माध्यम से)"),
            type = "bank",
            category = "micro_credit",
            description = LocalizedText(en = "SBI implements PM Street Vendor's Atma Nirbhar Nidhi loans and incentives for street vendors under the central scheme.", te = "SBI కేంద్ర పథకం PM SVANidhi క్రింద స్ట్రీట్ వెండర్లకు రుణాలు మరియు ప్రోత్సాహకాలు అమలు చేస్తుంది.", hi = "SBI केंद्रीय योजना PM SVANidhi के तहत स्ट्रीट वेंडरों के लिए ऋण और प्रोत्साहन लागू करता है।"),
            benefits = LocalizedText(en = "Collateral‑free working capital loans (tranches up to ₹50,000), interest subsidy and digital transaction cashback.", te = "కోలాటరల్‑రహిత వర్కింగ్ క్యాపిటల్ రుణాలు (₹50,000 వరకు), వడ్డీ ఉపసంహరణ మరియు డిజిటల్ క్యాష్‌బ్యాక్.", hi = "कोलैटरल-रहित वर्किंग कैपिटल ऋण (₹50,000 तक), ब्याज उपवेशन और डिजिटल कैशबैक।"),
            eligibility = LocalizedText(en = "Street vendors engaged in vending as on cut‑off date and meeting scheme documentation norms.", te = "కట్‑ఆఫ్ తేదీకి వెండింగ్‌లో ఉన్న స్ట్రీట్ వెండర్లు మరియు పత్రాల నిబంధనలు తీరాలి.", hi = "कट‑ऑफ तिथि तक वेंडिंग में लगे स्ट्रीट वेंडर और दस्तावेज़ मानदंड पूरा करें।"),
            applyProcess = LocalizedText(en = "Apply at SBI branch or via PM SVANidhi portal; submit vendor ID, KYC and business details for sanction.", te = "SBI శాఖలో లేదా PM SVANidhi పోర్టల్ ద్వారా దరఖాస్తు చేయండి; వెండర్ ID, KYC మరియు వ్యాపార వివరాలు సమర్పించండి.", hi = "SBI शाखा या PM SVANidhi पोर्टल पर आवेदन करें; वेंडर ID, KYC और व्यवसाय विवरण जमा करें।")
        ),
        Scheme(
            id = "sbi-schm-2",
            title = LocalizedText(en = "Stand-Up India (SBI)", te = "స్టాండ్-అప్ ఇండియా (SBI)", hi = "स्टैंड-अप इंडिया (SBI)"),
            type = "bank",
            category = "msme",
            description = LocalizedText(en = "SBI facilitates Stand‑Up India loans for SC/ST and women entrepreneurs to set up greenfield enterprises.", te = "SC/ST మరియు మహిళా వ్యాపారులకు గ్రీన్‌ఫీల్డ్ సంస్థలు స్థాపించడానికి SBI Stand‑Up India రుణాలను సౌకర్యవంతం చేస్తుంది.", hi = "SC/ST और महिला उद्यमियों के लिए ग्रीनफील्ड उद्यम स्थापित करने हेतु SBI Stand‑Up India ऋण प्रदान करता है।"),
            benefits = LocalizedText(en = "Bank loans between ₹10 lakh and ₹1 crore, handholding support and credit facilitation.", te = "₹10 లక్షల నుంచి ₹1 కోటి వరకు బ్యాంకు రుణాలు మరియు మద్దతు.", hi = "₹10 लाख से ₹1 करोड़ तक बैंक ऋण और सहायता।"),
            eligibility = LocalizedText(en = "SC/ST and women entrepreneurs above 18 years setting up new manufacturing/services/trading units.", te = "18 సంవత్సరాల పైబడిన SC/ST మరియు మహిళా వ్యాపారులు కొత్త యూనిట్లు స్థాపించాలి.", hi = "18 वर्ष से अधिक आयु के SC/ST और महिला उद्यमी जो नई इकाइयाँ स्थापित कर रहे हैं।"),
            applyProcess = LocalizedText(en = "Apply via Stand‑Up India portal or SBI branch with project report, KYC and collateral (if applicable).", te = "పోర్టల్ లేదా SBI శాఖ ద్వారా ప్రాజెక్ట్ రిపోర్ట్, KYC సమర్పించండి.", hi = "Stand‑Up India पोर्टल या SBI शाखा के माध्यम से परियोजना रिपोर्ट, KYC जमा करें।")
        ),
        Scheme(
            id = "apgb-schm-1",
            title = LocalizedText(en = "PMJDY & Financial Inclusion (APGB)", te = "PMJDY & ఆర్థిక సమగ్రత (APGB)", hi = "PMJDY और वित्तीय समावेशन (APGB)"),
            type = "bank",
            category = "financial_inclusion",
            description = LocalizedText(en = "APGB implements Jan Dhan accounts, zero‑balance savings and RuPay issuance to expand rural banking access.", te = "APGB గ్రామీణ బ్యాంకింగ్ యాక్సెస్ పెంచడానికి జనధన్ ఖాతాలు, జీరో‑బ్యాలెన్స్ సేవింగ్స్ మరియు RuPay కార్డులను అమలు చేస్తుంది.", hi = "APGB ग्रामीण बैंकिंग पहुँच बढ़ाने हेतु जन धन खाते, शून्य-बैलेंस बचत और RuPay कार्ड जारी करता है।"),
            benefits = LocalizedText(en = "Zero‑balance accounts, accidental insurance, RuPay debit card and overdraft facilities for eligible customers.", te = "జీరో‑బ్యాలెన్స్ ఖాతాలు, ప్రమాద బీమా, RuPay డెబిట్ కార్డ్ మరియు ఓవర్‌డ్రాఫ్ట్ సౌకర్యాలు.", hi = "शून्य-बैलेंस खाते, दुर्घटना बीमा, RuPay डेबिट कार्ड और ओवरड्राफ्ट सुविधाएँ।"),
            eligibility = LocalizedText(en = "Rural residents without bank accounts; KYC and Aadhaar recommended for full benefits.", te = "బ్యాంక్ ఖాతా లేని గ్రామీణ నివాసితులు; పూర్తి లాభాల కోసం KYC/ఆధార్ అవసరం.", hi = "बिना बैंक खाते वाले ग्रामीण निवासी; पूर्ण लाभ हेतु KYC/आधार आवश्यक।"),
            applyProcess = LocalizedText(en = "Open account at APGB branch or BC outlet with ID/address proof; receive RuPay card and register for mobile banking.", te = "APGB శాఖ లేదా BC అవుట్‌లెట్‌లో ID/చిరునామా పత్రాలతో ఖాతా తెరవండి; RuPay కార్డ్ పొందండి.", hi = "APGB शाखा या BC आउटलेट पर पहचान/पता प्रमाण के साथ खाता खोलें; RuPay कार्ड प्राप्त करें।")
        ),
        Scheme(
            id = "apgb-schm-2",
            title = LocalizedText(en = "Fixed Deposit & Special Tenure FDs (APGB)", te = "ఫిక్స్డ్ డిపాజిట్ & ప్రత్యేక వ్యవధి FDలు (APGB)", hi = "फिक्स्ड डिपॉज़िट और विशेष अवधि FD (APGB)"),
            type = "bank",
            category = "deposits",
            description = LocalizedText(en = "APGB offers term deposits with competitive interest rates and special short‑tenure products (e.g., 333/444 days variants).", te = "APGB పోస్ట్‌డ్ టర్మ్ డిపాజిట్లు మరియు ప్రత్యేక షార్ట్‑టెన్యూర్ ఉత్పత్తులు అందిస్తుంది.", hi = "APGB प्रतिस्पर्धी ब्याज दरों और विशेष अल्पावधि उत्पाद (जैसे 333/444 दिन) प्रदान करता है।"),
            benefits = LocalizedText(en = "Attractive rates (up to ~7.5% on select tenures), senior citizen additional rate and loan against FD facility.", te = "ఎంపికైన వ్యవధులపై ఆకర్షక రేట్లు (~7.5%), సీనియర్ సిటిజన్ అదనపు రేటు మరియు FDపై రుణం.", hi = "चयनित अवधियों पर आकर्षक दरें (~7.5%), वरिष्ठ नागरिक अतिरिक्त दर और FD के खिलाफ ऋण।"),
            eligibility = LocalizedText(en = "Resident individuals, HUFs and minors (via guardian) as per bank rules.", te = "నివాసి వ్యక్తులు, HUFలు మరియు చిన్నారులు (గార్డియన్ ద్వారా).", hi = "निवासी व्यक्ति, HUF और नाबालिग (अभिभावक के माध्यम से)।"),
            applyProcess = LocalizedText(en = "Open FD at APGB branch with KYC and deposit; premature withdrawal and loan against FD subject to bank rules.", te = "KYCతో APGB శాఖలో FD తెరవండి; ముందస్తు ఉపసంహరణ బ్యాంక్ నిబంధనలకు లోబడి ఉంటుంది.", hi = "KYC के साथ APGB शाखा में FD खोलें; पूर्व निकासी और FD के खिलाफ ऋण बैंक नियमों के अधीन।")
        ),
        Scheme(
            id = "schm-1",
            title = LocalizedText(en = "Pradhan Mantri Kisan Samman Nidhi (PM-KISAN)", te = "ప్రధాన మంత్రి కిసాన్ సమ్మాన్ నిధి (PM-KISAN)", hi = "प्रधानमंत्री किसान सम्मान निधि (पीएम-किसान)"),
            type = "central",
            category = "farmer",
            description = LocalizedText(en = "Central sector scheme providing direct income support to eligible landholding farmer families across India.", te = "దేశవ్యాప్తంగా అర్హత కలిగిన భూమి కలిగిన రైతు కుటుంబాలకు నేరుగా ఆదాయ మద్దతు అందించే కేంద్ర పథకం.", hi = "भारत भर में पात्र भूमिधारक किसान परिवारों को प्रत्यक्ष आय सहायता प्रदान करने वाली केंद्रीय योजना।"),
            benefits = LocalizedText(en = "Rs. 6,000 per year paid in three equal instalments via DBT to beneficiary bank accounts.", te = "సంవత్సరానికి రూ. 6,000 మూడు సమాన విడతలలో డీబీటీలో బ్యాంక్ ఖాతాలకు చెల్లించబడుతుంది.", hi = "रु. 6,000 प्रति वर्ष, तीन समान किस्तों में लाभार्थी के बैंक खाते में डीबीटी के माध्यम से भुगतान।"),
            eligibility = LocalizedText(en = "Landholding farmer families; institutional landholders and ineligible categories as per scheme guidelines excluded.", te = "భూమి కలిగిన రైతు కుటుంబాలు; పథక మార్గదర్శకాల్లో పేర్కొన్న అర్హతలలో బాహ్యులు తప్పించబడతారు.", hi = "भूमिधारक किसान परिवार; योजना दिशानिर्देशों के अनुसार संस्थागत भूमिधारक और अयोग्य श्रेणियाँ बाहर।"),
            applyProcess = LocalizedText(en = "Register on PM-KISAN portal or apply at local CSC/Meeseva with land documents and Aadhaar for verification.", te = "PM-KISAN పోర్టల్‌లో నమోదు లేదా స్థానిక CSC/మీ సేవా కేంద్రాలలో భూమి పత్రాలు, ఆధార్‌తో దరఖాస్తు చేయండి.", hi = "पीएम-किसान पोर्टल पर पंजीकरण करें या स्थानीय CSC/मीसेवा केंद्र पर भूमि दस्तावेज और आधार के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-2",
            title = LocalizedText(en = "Pradhan Mantri Fasal Bima Yojana (PMFBY)", te = "ప్రధాన మంత్రి ఫసల్ బీమా యోజన (PMFBY)", hi = "प्रधानमंत्री फसल बीमा योजना (PMFBY)"),
            type = "central",
            category = "farmer",
            description = LocalizedText(en = "Crop insurance scheme to provide financial support to farmers in case of crop loss due to natural calamities, pests, and diseases.", te = "ప్రाकृतिक విపత్తులు, పురుగులు, వ్యాధుల వల్ల పంట నష్టానికి రైతులకు ఆర్థిక మద్దతు అందించే పంట బీమా పథకం.", hi = "प्राकृतिक आपदाओं, कीटों और रोगों के कारण फसल हानि की स्थिति में किसानों को वित्तीय सहायता प्रदान करने वाली फसल बीमा योजना।"),
            benefits = LocalizedText(en = "Compensation for crop loss based on notified yields and actuarial calculations; premium sharing between Centre and State.", te = "నోటిఫై చేసిన దిగుబడి ఆధారంగా మరియు ఆక్యుయరియల్ లెక్కల ప్రకారం పంట నష్టానికి పరిహారం; ప్రీమియం కేంద్రం-రాష్ట్రం భాగస్వామ్యం.", hi = "सूचित उपज और प्रायिक गणनाओं के आधार पर फसल हानि के लिए मुआवजा; प्रीमियम केंद्र और राज्य के बीच साझा।"),
            eligibility = LocalizedText(en = "All farmers growing notified crops in notified areas who pay the prescribed premium or are covered under DBT arrangements.", te = "నోటిఫై చేసిన ప్రాంతాల్లో నోటిఫై చేసిన పంటలు పెంచే అన్ని రైతులు, నిర్దేశిత ప్రీమియం చెల్లించినవారు లేదా DBT కింద కవర్ అయినవారు.", hi = "सूचित क्षेत्रों में सूचित फसलें उगाने वाले सभी किसान जो निर्धारित प्रीमियम का भुगतान करते हैं या DBT के तहत कवर हैं।"),
            applyProcess = LocalizedText(en = "Enroll through implementing agency (insurance company/State nodal agency) via Kisan portal, bank branch, or CSC during enrolment window.", te = "కిసాన్ పోర్టల్, బ్యాంక్ శాఖ లేదా CSC ద్వారా బీమా సంస్థ/రాష్ట్ర nodal ఏజెన్సీ ద్వారా నమోదు చేయండి.", hi = "किसान पोर्टल, बैंक शाखा या CSC के माध्यम से बीमा कंपनी/राज्य नोडल एजेंसी के जरिए नामांकन विंडो में नामांकन करें।")
        ),
        Scheme(
            id = "schm-3",
            title = LocalizedText(en = "Kisan Credit Card (KCC)", te = "కిసాన్ క్రెడిట్ కార్డ్ (KCC)", hi = "किसान क्रेडिट कार्ड (KCC)"),
            type = "central",
            category = "farmer",
            description = LocalizedText(en = "Credit facility to farmers for short-term agricultural needs and allied activities at concessional interest rates.", te = "రైతులకు తక్కువ వడ్డీ రేట్లలో తాత్కాలిక వ్యవసాయ అవసరాల కోసం క్రెడిట్ సౌకర్యం.", hi = "किसानों को कम ब्याज दरों पर अल्पकालिक कृषि आवश्यकताओं और संबद्ध गतिविधियों के लिए क्रेडिट सुविधा।"),
            benefits = LocalizedText(en = "Short-term loans for crop production, post-harvest, and allied activities; interest subvention schemes may apply.", te = "పంట ఉత్పత్తి, పంటతర్వాత మరియు అనుబంధ కార్యకలాపాల కోసం తాత్కాలిక రుణాలు; వడ్డీ ఉపసంహరణ వర్తించవచ్చు.", hi = "फसल उत्पादन, कटाई के बाद और संबद्ध गतिविधियों के लिए अल्पकालिक ऋण; ब्याज उपवेशन योजनाएँ लागू हो सकती हैं।"),
            eligibility = LocalizedText(en = "Individual farmers, tenant farmers, and joint liability groups engaged in agriculture and allied activities as per bank norms.", te = "వ్యక్తిగత రైతులు, అద్దె రైతులు, మరియు బ్యాంక్ నిబంధనల ప్రకారం సంయుక్త బాధ్యత గుంపులు.", hi = "व्यक्तिगत किसान, किराये के किसान और बैंक मानदंडों के अनुसार संयुक्त देयता समूह।"),
            applyProcess = LocalizedText(en = "Apply at bank branch with land papers, KYC, Aadhaar; banks process and issue KCC with sanctioned limit.", te = "భూమి పత్రాలు, KYC, ఆధార్‌తో బ్యాంక్ శాఖలో దరఖాస్తు చేయండి; బ్యాంకులు పరిమితి మంజూరు చేసి KCC జారీ చేస్తాయి.", hi = "भूमि दस्तावेज, KYC, आधार के साथ बैंक शाखा में आवेदन करें; बैंक मंजूरी देकर KCC जारी करते हैं।")
        ),
        Scheme(
            id = "schm-4",
            title = LocalizedText(en = "Pradhan Mantri Krishi Sinchayee Yojana (PMKSY)", te = "ప్రధాన మంత్రి కృషి సింఛయి యోజన (PMKSY)", hi = "प्रधानमंत्री कृषि सिंचाई योजना (PMKSY)"),
            type = "central",
            category = "farmer",
            description = LocalizedText(en = "Integrated irrigation scheme to expand cultivable area under assured irrigation and improve water use efficiency.", te = "నిర్ధారిత సాగు కోసం సాగు ప్రాంతాన్ని విస్తరించడానికి మరియు నీటి వినియోగ సామర్థ్యాన్ని మెరుగుపరచడానికి సమగ్ర సింఛయి పథకం.", hi = "निश्चित सिंचाई के तहत कृषि योग्य क्षेत्र का विस्तार करने और जल उपयोग दक्षता में सुधार के लिए एकीकृत सिंचाई योजना।"),
            benefits = LocalizedText(en = "Support for micro-irrigation, water harvesting, command area development, and on-farm water management.", te = "మైక్రో-సింఛయి, నీటి సేకరణ, కమాండ్ ఏరియా అభివృద్ధి మరియు ఫార్మ్ నీటి నిర్వహణకు మద్దతు.", hi = "माइक्रो-सिंचाई, जल संचयन, कमांड एरिया विकास और ऑन-फार्म जल प्रबंधन के लिए सहायता।"),
            eligibility = LocalizedText(en = "Farmers and implementing agencies for projects under PMKSY components as per guidelines.", te = "PMKSY భాగాల కింద ప్రాజెక్టులకు రైతులు మరియు అమలు ఏజెన్సీలు మార్గదర్శకాలకు అనుగుణంగా అర్హులు.", hi = "PMKSY घटकों के तहत परियोजनाओं के लिए किसान और कार्यान्वयन एजेंसियाँ दिशानिर्देशों के अनुसार पात्र।"),
            applyProcess = LocalizedText(en = "Apply through State implementing agencies, agriculture department portals, or local water user associations as specified.", te = "రాష్ట్ర అమలు ఏజెన్సీలు, వ్యవసాయ శాఖ పోర్టల్స్ లేదా స్థానిక వాటర్ యూజర్ అసోసియేషన్ల ద్వారా దరఖాస్తు చేయండి.", hi = "राज्य कार्यान्वयन एजेंसियों, कृषि विभाग पोर्टल या स्थानीय जल उपयोगकर्ता संघों के माध्यम से आवेदन करें।")
        ),
        Scheme(
            id = "schm-5",
            title = LocalizedText(en = "Soil Health Card Scheme", te = "సాయిల్ హెల్త్ కార్డ్ పథకం", hi = "मृदा स्वास्थ्य कार्ड योजना"),
            type = "central",
            category = "farmer",
            description = LocalizedText(en = "Scheme to provide soil health cards to farmers with crop-wise recommendations on nutrient management.", te = "రైతులకు పంటల వారీగా పోషక నిర్వహణ సూచనలతో మట్టి ఆరోగ్య కార్డులు ఇవ్వడానికి పథకం.", hi = "किसानों को फसल-वार पोषक तत्व प्रबंधन सिफारिशों के साथ मृदा स्वास्थ्य कार्ड प्रदान करने की योजना।"),
            benefits = LocalizedText(en = "Free soil testing, nutrient recommendations, and guidance to improve productivity and reduce input costs.", te = "ఉచిత మట్టి పరీక్షలు, పోషక సూచనలు మరియు ఉత్పాదకత పెంపు కోసం మార్గదర్శకాలు.", hi = "मुफ्त मृदा परीक्षण, पोषक तत्व सिफारिशें और उत्पादकता बढ़ाने व इनपुट लागत घटाने के लिए मार्गदर्शन।"),
            eligibility = LocalizedText(en = "All farmers with cultivable land who opt for soil testing through designated labs or extension services.", te = "నిర్దేశిత ప్రయోగశాలలు లేదా విస్తరణ సేవల ద్వారా మట్టి పరీక్ష కోసం ఎంపిక చేసే అన్ని రైతులు.", hi = "निर्धारित प्रयोगशालाओं या विस्तार सेवाओं के माध्यम से मृदा परीक्षण के लिए आवेदन करने वाले सभी किसान।"),
            applyProcess = LocalizedText(en = "Submit soil samples at nearest soil testing lab or through Krishi Vigyan Kendra/online portals as per state process.", te = "సమీప మట్టి పరీక్షా ప్రయోగశాలలో లేదా Krishi Vigyan Kendra/ఆన్‌లైన్ పోర్టల్స్ ద్వారా నమూనాలు సమర్పించండి.", hi = "निकटतम मृदा परीक्षण प्रयोगशाला या Krishi Vigyan Kendra/ऑनलाइन पोर्टल के माध्यम से नमूने जमा करें।")
        ),
        Scheme(
            id = "schm-6",
            title = LocalizedText(en = "e-NAM (National Agriculture Market)", te = "e-NAM (నేషనల్ అగ్రికల్చర్ మార్కెట్)", hi = "e-NAM (नेशनल एग्रीकल्चर मार्केट)"),
            type = "central",
            category = "farmer",
            description = LocalizedText(en = "Pan-India electronic trading portal to create unified national market for agricultural commodities.", te = "వ్యవసాయ వస్తువుల కోసం ఏకీకృత జాతీయ మార్కెట్ సృష్టించడానికి పాన్-ఇండియా ఎలక్ట్రానిక్ ట్రేడింగ్ పోర్టల్.", hi = "कृषि वस्तुओं के लिए एकीकृत राष्ट्रीय बाजार बनाने हेतु पैन-इंडिया इलेक्ट्रॉनिक ट्रेडिंग पोर्टल।"),
            benefits = LocalizedText(en = "Online bidding, price discovery, transparent transactions, and better market access for farmers.", te = "ఆన్‌లైన్ బిడ్డింగ్, ధర కనుగొనడం, పారదర్శక లావాదేవీలు మరియు రైతులకు మెరుగైన మార్కెట్ యాక్సెస్.", hi = "ऑनलाइन बोली, मूल्य खोज, पारदर्शी लेनदेन और किसानों के लिए बेहतर बाजार पहुँच।"),
            eligibility = LocalizedText(en = "Farmers, traders, and commission agents registered with participating APMC mandis and e-NAM platform.", te = "భాగస్వామ్య APMC మండీల్లో మరియు e-NAM ప్లాట్‌ఫారమ్‌లో నమోదు అయిన రైతులు, వ్యాపారులు, కమిషన్ ఏజెంట్లు.", hi = "भाग लेने वाले APMC मंडियों और e-NAM प्लेटफ़ॉर्म पर पंजीकृत किसान, व्यापारी और कमीशन एजेंट।"),
            applyProcess = LocalizedText(en = "Register on e-NAM portal or through participating mandi; follow mandi-specific onboarding steps for sellers/buyers.", te = "e-NAM పోర్టల్‌లో లేదా భాగస్వామ్య మండీలో నమోదు చేయండి; విక్రేతలు/కొనుగోలుదారుల కోసం మండీ-నిర్దిష్ట ఆన్‌బోర్డింగ్ పాటించండి.", hi = "e-NAM पोर्टल पर या भाग लेने वाली मंडी के माध्यम से पंजीकरण करें; विक्रेता/खरीदार के लिए मंडी-विशिष्ट ऑनबोर्डिंग चरणों का पालन करें।")
        ),
        Scheme(
            id = "schm-7",
            title = LocalizedText(en = "PM-KUSUM (Solar Pumps and Grid-connected Solar)", te = "PM-KUSUM (సోలార్ పంపులు మరియు గ్రిడ్-కనెక్టెడ్ సోలార్)", hi = "PM-KUSUM (सोलर पंप और ग्रिड-संयोजित सोलर)"),
            type = "central",
            category = "farmer",
            description = LocalizedText(en = "Scheme to promote solarisation of agricultural pumps and decentralised solar power generation for farmers.", te = "రైతుల కోసం వ్యవసాయ పంపుల సోలార్ చేయడం మరియు వికేంద్రీకృత సోలార్ ఉత్పత్తిని ప్రోత్సహించే పథకం.", hi = "किसानों के लिए कृषि पंपों का सौरकरण और विकेन्द्रीकृत सौर ऊर्जा उत्पादन को बढ़ावा देने की योजना।"),
            benefits = LocalizedText(en = "Subsidy for solar pumps, incentives for grid-connected solar plants, and support for farmer adoption.", te = "సోలార్ పంపులకు సబ్సిడీ, గ్రిడ్-కనెక్టెడ్ సోలార్ ప్లాంట్లకు ప్రోత్సాహకాలు మరియు రైతుల దత్తతకు మద్దతు.", hi = "सोलर पंपों के लिए सब्सिडी, ग्रिड-संयोजित सोलर प्लांट्स के लिए प्रोत्साहन और किसान अपनाने के लिए सहायता।"),
            eligibility = LocalizedText(en = "Farmers owning or leasing agricultural land and meeting technical criteria specified by implementing agencies.", te = "వ్యవసాయ భూమి కలిగిన లేదా అద్దె తీసుకున్న రైతులు మరియు అమలు ఏజెన్సీలు పేర్కొన్న సాంకేతిక ప్రమాణాలు తీరినవారు.", hi = "कृषि भूमि के मालिक या पट्टे पर लेने वाले किसान और कार्यान्वयन एजेंसियों द्वारा निर्दिष्ट तकनीकी मानदंडों को पूरा करने वाले।"),
            applyProcess = LocalizedText(en = "Apply through State nodal agencies, DISCOMs, or designated implementing agencies with required documents and land proof.", te = "రాష్ట్ర నోడల్ ఏజెన్సీలు, డిస్కామ్‌లు లేదా నియమిత అమలు ఏజెన్సీల ద్వారా అవసరమైన పత్రాలు, భూమి సాక్ష్యాలతో దరఖాస్తు చేయండి.", hi = "राज्य नोडल एजेंसियों, DISCOMs या नामित कार्यान्वयन एजेंसियों के माध्यम से आवश्यक दस्तावेज और भूमि प्रमाण के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-8",
            title = LocalizedText(en = "National Scholarship Portal (NSP)", te = "నేషనల్ స్కాలర్‌షిప్ పోర్టల్ (NSP)", hi = "नेशनल स्कॉलरशिप पोर्टल (NSP)"),
            type = "central",
            category = "student",
            description = LocalizedText(en = "Unified portal for students to apply for various central government scholarships and track disbursals.", te = "వివిధ కేంద్ర ప్రభుత్వ స్కాలర్‌షిప్‌లకు దరఖాస్తు చేయడానికి మరియు చెల్లింపులను ట్రాక్ చేయడానికి ఏకీకృత పోర్టల్.", hi = "विभिन्न केंद्रीय सरकारी छात्रवृत्तियों के लिए आवेदन करने और भुगतान ट्रैक करने के लिए एकीकृत पोर्टल।"),
            benefits = LocalizedText(en = "Single-window application, status tracking, and DBT-enabled scholarship disbursal to student bank accounts.", te = "సింగిల్-విండో అప్లికేషన్, స్థితి ట్రాకింగ్ మరియు DBT ద్వారా విద్యార్థి బ్యాంక్ ఖాతాలకు స్కాలర్‌షిప్ చెల్లింపు.", hi = "सिंगल-विंडो आवेदन, स्थिति ट्रैकिंग और DBT सक्षम छात्रवृत्ति भुगतान।"),
            eligibility = LocalizedText(en = "Eligibility varies by scholarship; students must check individual scheme criteria (income, caste, course, marks).", te = "స్కాలర్‌షిప్ ప్రకారం అర్హత మారుతుంది; ఆదాయం, జాతి, కోర్సు, మార్కుల ఆధారంగా వ్యక్తిగత పథక ప్రమాణాలను పరిశీలించండి.", hi = "छात्रवृत्ति के अनुसार पात्रता भिन्न होती है; आय, जाति, कोर्स, अंकों के आधार पर व्यक्तिगत योजना मानदंड देखें।"),
            applyProcess = LocalizedText(en = "Register on NSP portal, fill scholarship-specific application, upload documents, and track status online.", te = "NSP పోర్టల్‌లో నమోదు చేసుకుని, స్కాలర్‌షిప్-స్పెసిఫిక్ ఫారమ్ పూరించండి, పత్రాలు అప్లోడ్ చేసి ఆన్‌లైన్‌లో స్థితిని ట్రాక్ చేయండి.", hi = "NSP पोर्टल पर पंजीकरण करें, छात्रवृत्ति-विशिष्ट आवेदन भरें, दस्तावेज़ अपलोड करें और ऑनलाइन स्थिति ट्रैक करें।")
        ),
        Scheme(
            id = "schm-9",
            title = LocalizedText(en = "PM-YASASVI Scholarship", te = "PM-YASASVI స్కాలర్‌షిప్", hi = "PM-YASASVI छात्रवृत्ति"),
            type = "central",
            category = "student",
            description = LocalizedText(en = "Scholarship scheme targeting OBC/EBC/DNT students for higher education support.", te = "OBC/EBC/DNT విద్యార్థులకు ఉన్నత విద్యకు మద్దతుగా స్కాలర్‌షిప్ పథకం.", hi = "OBC/EBC/DNT छात्रों के लिए उच्च शिक्षा सहायता हेतु छात्रवृत्ति योजना।"),
            benefits = LocalizedText(en = "Tuition fee support and maintenance allowance as per scheme norms for eligible students.", te = "అర్హత కలిగిన విద్యార్థులకు పథక నిబంధనల ప్రకారం ఫీజు మద్దతు మరియు నిర్వహణ అలవెన్స్.", hi = "पात्र छात्रों के लिए योजना मानदंडों के अनुसार ट्यूशन शुल्क सहायता और रखरखाव भत्ता।"),
            eligibility = LocalizedText(en = "Students belonging to specified backward or deprived categories meeting income and academic criteria.", te = "నిర్దిష్ట వెనుకబడిన లేదా పిరికిపడిన వర్గాలకు చెందిన విద్యార్థులు ఆదాయ మరియు అకాడెమిక్ ప్రమాణాలు తీరాలి.", hi = "निर्दिष्ट पिछड़े या वंचित वर्गों के छात्र जो आय और शैक्षणिक मानदंडों को पूरा करते हैं।"),
            applyProcess = LocalizedText(en = "Apply via NSP or designated portal with caste/income certificates and admission proof to institute.", te = "NSP లేదా నియమిత పోర్టల్ ద్వారా జాతి/ఆదాయ సర్టిఫికెట్లు మరియు ప్రవేశ సాక్ష్యాలతో దరఖాస్తు చేయండి.", hi = "NSP या नामित पोर्टल के माध्यम से जाति/आय प्रमाणपत्र और संस्थान में प्रवेश प्रमाण के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-10",
            title = LocalizedText(en = "Central Sector Scheme of Scholarships (CSSS)", te = "సెంట్రల్ సెక్టార్ స్కాలర్‌షిప్ పథకం (CSSS)", hi = "केंद्रीय क्षेत्र छात्रवृत्ति योजना (CSSS)"),
            type = "central",
            category = "student",
            description = LocalizedText(en = "Merit-based central scholarships for students pursuing higher education in India.", te = "భారతదేశంలో ఉన్నత విద్య పొందుతున్న విద్యార్థుల కోసం మెరిట్ ఆధారిత కేంద్ర స్కాలర్‌షిప్‌లు.", hi = "भारत में उच्च शिक्षा प्राप्त करने वाले छात्रों के लिए मेरिट-आधारित केंद्रीय छात्रवृत्तियाँ।"),
            benefits = LocalizedText(en = "Tuition fee coverage and maintenance allowance for selected meritorious students as per scheme rules.", te = "ఎంపికైన మెరిట్ విద్యార్థులకు పథక నిబంధనల ప్రకారం ఫీజు మరియు నిర్వహణ అలవెన్స్.", hi = "चयनित मेरिट छात्राओं के लिए योजना नियमों के अनुसार ट्यूशन शुल्क और रखरखाव भत्ता।"),
            eligibility = LocalizedText(en = "Students meeting merit cut-offs and other criteria specified in the scheme notification.", te = "మెరిట్ కట్-ఆఫ్‌లు మరియు పథక నోటిఫికేషన్‌లో పేర్కొన్న ఇతర ప్రమాణాలు తీరిన విద్యార్థులు.", hi = "मेरिट कट-ऑफ और योजना अधिसूचना में निर्दिष्ट अन्य मानदंडों को पूरा करने वाले छात्र।"),
            applyProcess = LocalizedText(en = "Apply through NSP or scheme portal with academic records, ID, and bank details for DBT.", te = "NSP లేదా పథక పోర్టల్ ద్వారా అకాడెమిక్ రికార్డులు, ID, బ్యాంక్ వివరాలతో దరఖాస్తు చేయండి.", hi = "NSP या योजना पोर्टल के माध्यम से शैक्षणिक रिकॉर्ड, पहचान और DBT के लिए बैंक विवरण के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-11",
            title = LocalizedText(en = "National Means-cum-Merit Scholarship (NMMS)", te = "నేషనల్ మీన్స్-కమ్-మెరిట్ స్కాలర్‌షిప్ (NMMS)", hi = "नेशनल मीन्स-कम-मेरिट छात्रवृत्ति (NMMS)"),
            type = "central",
            category = "student",
            description = LocalizedText(en = "Scholarship to prevent dropout of meritorious students from economically weaker sections at secondary level.", te = "ఆర్థికంగా బలహీన వర్గాల మెరిట్ విద్యార్థుల స్కూల్ డ్రాప్-అవుట్ నివారించడానికి స్కాలర్‌షిప్.", hi = "आर्थिक रूप से कमजोर वर्गों के मेरिट छात्राओं के माध्यमिक स्तर पर ड्रॉपआउट रोकने के लिए छात्रवृत्ति।"),
            benefits = LocalizedText(en = "Annual scholarship amount to support education at secondary stage as per scheme rates.", te = "సెకండరీ స్థాయిలో విద్యకు మద్దతుగా వార్షిక స్కాలర్‌షిప్ మొత్తం.", hi = "माध्यमिक स्तर पर शिक्षा का समर्थन करने के लिए वार्षिक छात्रवृत्ति राशि।"),
            eligibility = LocalizedText(en = "Students studying in Class IX/X from eligible income households who clear NMMS exam and selection criteria.", te = "అర్హ ఆదాయ గృహాల నుండి తరగతి IX/Xలో చదువుతున్న విద్యార్థులు NMMS పరీక్షను ఉత్తీర్ణత సాధించాలి.", hi = "अर्ह आय वाले परिवारों के कक्षा IX/X के छात्र जो NMMS परीक्षा और चयन मानदंड पास करते हैं।"),
            applyProcess = LocalizedText(en = "Apply through state education boards or NSP during notification window with income and school certificates.", te = "రాష్ట్ర విద్యా బోర్డులు లేదా NSP ద్వారా నోటిఫికేషన్ సమయంలో ఆదాయ, పాఠశాల సర్టిఫికెట్లతో దరఖాస్తు చేయండి.", hi = "राज्य शिक्षा बोर्ड या NSP के माध्यम से अधिसूचना विंडो में आय और स्कूल प्रमाणपत्रों के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-12",
            title = LocalizedText(en = "SWAYAM and NPTEL", te = "SWAYAM మరియు NPTEL", hi = "SWAYAM और NPTEL"),
            type = "central",
            category = "student",
            description = LocalizedText(en = "Government platforms offering free/low-cost online courses, MOOCs, and certification across disciplines.", te = "విభాగాల వారీగా ఉచిత/తక్కువ ఖర్చు ఆన్‌లైన్ కోర్సులు, MOOCs మరియు సర్టిఫికెట్లు అందించే ప్రభుత్వ ప్లాట్‌ఫారమ్‌లు.", hi = "विभिन्न विषयों में मुफ्त/कम-लागत ऑनलाइन पाठ्यक्रम, MOOCs और प्रमाणन प्रदान करने वाले सरकारी प्लेटफ़ॉर्म।"),
            benefits = LocalizedText(en = "Access to quality courses, video lectures, study material, and optional certification for learners nationwide.", te = "నాణ్యమైన కోర్సులు, వీడియో లెక్చర్లు, అధ్యయన పదార్థం మరియు ఐచ్ఛిక సర్టిఫికేషన్‌కు యాక్సెస్.", hi = "गुणवत्तापूर्ण पाठ्यक्रमों, वीडियो व्याख्यानों, अध्ययन सामग्री और वैकल्पिक प्रमाणन तक पहुँच।"),
            eligibility = LocalizedText(en = "Open to learners across India; some certification/exam components may have fees or eligibility rules.", te = "భారతదేశంలోని విద్యార్థులకు అందుబాటులో ఉంటుంది; కొన్ని సర్టిఫికేషన్/పరీక్ష భాగాలకు ఫీజు లేదా అర్హత నిబంధనలు ఉండవచ్చు.", hi = "भारत भर के शिक्षार्थियों के लिए खुला; कुछ प्रमाणन/परीक्षा घटकों के लिए शुल्क या पात्रता नियम हो सकते हैं।"),
            applyProcess = LocalizedText(en = "Register on SWAYAM/NPTEL portals, enroll in courses, complete assignments and exams for certification where required.", te = "SWAYAM/NPTEL పోర్టల్స్‌లో నమోదు చేసి కోర్సుల్లో చేరండి, అసైన్‌మెంట్లు, పరీక్షలు పూర్తి చేయండి.", hi = "SWAYAM/NPTEL पोर्टल पर पंजीकरण करें, पाठ्यक्रमों में नामांकन करें, आवश्यक होने पर असाइनमेंट और परीक्षा पूरी करें।")
        ),
        Scheme(
            id = "schm-13",
            title = LocalizedText(en = "Vidya Lakshmi Portal", te = "విద్యా లక్ష్మి పోర్టల్", hi = "विद्या लक्ष्मी पोर्टल"),
            type = "central",
            category = "student",
            description = LocalizedText(en = "Centralised portal for students to apply for education loans and view scholarship opportunities.", te = "విద్యా రుణాల కోసం దరఖాస్తు చేయడానికి మరియు స్కాలర్‌షిప్ అవకాశాలను చూడటానికి ఏకీకృత పోర్టల్.", hi = "छात्रों के लिए शिक्षा ऋण के लिए आवेदन करने और छात्रवृत्ति अवसर देखने के लिए केंद्रीकृत पोर्टल।"),
            benefits = LocalizedText(en = "Single-window loan application, tracking, and access to multiple lending institutions and schemes.", te = "సింగిల్-విండో రుణ దరఖాస్తు, ట్రాకింగ్ మరియు బహుళ రుణదాత సంస్థలు మరియు పథకాలకు యాక్సెస్.", hi = "सिंगल-विंडो ऋण आवेदन, ट्रैकिंग और कई ऋणदाता संस्थाओं व योजनाओं तक पहुँच।"),
            eligibility = LocalizedText(en = "Students seeking education loans for higher studies; eligibility depends on lender and scheme norms.", te = "ఉన్నత చదువుల కోసం విద్యా రుణాలు కోరుకునే విద్యార్థులు; అర్హత రుణదాత మరియు పథక నిబంధనలపై ఆధారపడి ఉంటుంది.", hi = "उच्च अध्ययन के लिए शिक्षा ऋण चाहने वाले छात्र; पात्रता ऋणदाता और योजना मानदंडों पर निर्भर।"),
            applyProcess = LocalizedText(en = "Register on Vidya Lakshmi portal, submit loan application, upload documents and track sanction process online.", te = "విద్యా లక్ష్మి పోర్టల్‌లో నమోదు చేసి రుణ దరఖాస్తు సమర్పించండి, పత్రాలు అప్లోడ్ చేసి ఆన్‌లైన్‌లో ట్రాక్ చేయండి.", hi = "विद्या लक्ष्मी पोर्टल पर पंजीकरण करें, ऋण आवेदन जमा करें, दस्तावेज़ अपलोड करें और ऑनलाइन स्वीकृति प्रक्रिया ट्रैक करें।")
        ),
        Scheme(
            id = "schm-14",
            title = LocalizedText(en = "Beti Bachao, Beti Padhao", te = "బేటి బచావో, బేటి పఢావో", hi = "बेटी बचाओ, बेटी पढ़ाओ"),
            type = "central",
            category = "student",
            description = LocalizedText(en = "Campaign and scheme to improve girl child survival, education, and empowerment across India.", te = "దేశవ్యాప్తంగా బాలికల జీవనశక్తి, విద్య మరియు సాధికారతను మెరుగుపరచడానికి ప్రచారం మరియు పథకం.", hi = "देश भर में बालिका के जीवन, शिक्षा और सशक्तिकरण में सुधार के लिए अभियान और योजना।"),
            benefits = LocalizedText(en = "Awareness, incentives, and targeted interventions to improve sex ratio at birth and girls' education outcomes.", te = "జనన సమయంలో లింగ నిష్పత్తి మరియు బాలికల విద్య ఫలితాలను మెరుగుపరచడానికి అవగాహన, ప్రోత్సాహకాలు మరియు లక్ష్యిత చర్యలు.", hi = "जन्म पर लिंग अनुपात और लड़कियों की शिक्षा परिणामों में सुधार के लिए जागरूकता, प्रोत्साहन और लक्षित हस्तक्षेप।"),
            eligibility = LocalizedText(en = "Nationwide campaign; benefits and incentives vary by state and specific sub-schemes under the programme.", te = "దేశవ్యాప్తంగా ప్రచారం; ప్రయోజనాలు మరియు ప్రోత్సాహకాలు రాష్ట్రం మరియు ఉప-పథకాల ప్రకారం మారవచ్చు.", hi = "देशव्यापी अभियान; लाभ और प्रोत्साहन राज्य और कार्यक्रम के उप-योजनाओं के अनुसार भिन्न होते हैं।"),
            applyProcess = LocalizedText(en = "Participate through local education and health departments; check state portals for scheme-specific application steps.", te = "స్థానిక విద్య మరియు ఆరోగ్య శాఖల ద్వారా పాల్గొనండి; పథక-నిర్దిష్ట దశల కోసం రాష్ట్ర పోర్టల్స్ చూడండి.", hi = "स्थानीय शिक्षा और स्वास्थ्य विभागों के माध्यम से भाग लें; योजना-विशिष्ट आवेदन चरणों के लिए राज्य पोर्टल देखें।")
        ),
        Scheme(
            id = "schm-15",
            title = LocalizedText(en = "Sukanya Samriddhi Yojana", te = "సుకన్య సమృద్ధి యోజన", hi = "सुकन्या समृद्धि योजना"),
            type = "central",
            category = "women",
            description = LocalizedText(en = "Small savings scheme for girl child to encourage parents to build a fund for future education and marriage expenses.", te = "భవిష్యత్ విద్య మరియు వివాహ ఖర్చుల కోసం తల్లిదండ్రులు నిధిని సృష్టించడానికి బాలికల కోసం చిన్న పొదుపు పథకం.", hi = "भविष्य की शिक्षा और विवाह खर्च के लिए माता-पिता को निधि बनाने के लिए बालिका के लिए छोटी बचत योजना।"),
            benefits = LocalizedText(en = "Attractive interest rate, tax benefits under Section 80C, and maturity payout for the girl beneficiary.", te = "ఆకర్షక వడ్డీ రేటు, సెక్షన్ 80C కింద పన్ను ప్రయోజనాలు మరియు లబ్ధిదారికి పరిపక్వత చెల్లింపు.", hi = "आकर्षक ब्याज दर, धारा 80C के तहत कर लाभ और लाभार्थी को परिपक्वता भुगतान।"),
            eligibility = LocalizedText(en = "Account can be opened by parent/guardian in the name of a girl child up to specified age limits; one account per girl.", te = "పేరెంట్/గార్డియన్ ద్వారా నిర్దిష్ట వయస్సు పరిమితుల వరకు బాలిక పేరులో ఖాతా తెరవవచ్చు; ఒక్కో బాలికకు ఒకే ఖాతా.", hi = "माता/अभिभावक द्वारा निर्दिष्ट आयु सीमा तक बालिका के नाम पर खाता खोला जा सकता है; प्रत्येक बालिका के लिए एक खाता।"),
            applyProcess = LocalizedText(en = "Open account at post office or authorized bank with birth certificate and ID of parent/guardian; deposit as per scheme rules.", te = "పోస్ట్ ఆఫీస్ లేదా అనుమతిప్రాప్త బ్యాంకులో జనన సర్టిఫికెట్ మరియు పేరెంట్/గార్డియన్ IDతో ఖాతా తెరవండి; పథక నిబంధనల ప్రకారం జమ చేయండి.", hi = "डाकघर या अधिकृत बैंक में जन्म प्रमाणपत्र और माता/अभिभावक की पहचान के साथ खाता खोलें; योजना नियमों के अनुसार जमा करें।")
        ),
        Scheme(
            id = "schm-16",
            title = LocalizedText(en = "Pradhan Mantri Matru Vandana Yojana (PMMVY)", te = "ప్రధాన మంత్రి మాతృ వందన యోజన (PMMVY)", hi = "प्रधानमंत्री मातृ वंदना योजना (PMMVY)"),
            type = "central",
            category = "women",
            description = LocalizedText(en = "Conditional cash transfer scheme for pregnant and lactating women to provide partial wage compensation.", te = "గర్భిణీ మరియు పాలిస్తున్న మహిళలకు భాగ వేతన పరిహారం అందించే షరతు ఆధారిత నగదు బదిలీ పథకం.", hi = "गर्भवती और स्तनपान कराने वाली महिलाओं के लिए आंशिक वेतन मुआवजा प्रदान करने वाली शर्तीय नकद हस्तांतरण योजना।"),
            benefits = LocalizedText(en = "Cash benefit paid in instalments to support nutrition and healthcare during pregnancy and after delivery.", te = "గర్భధారణ సమయంలో మరియు డెలివరీ తర్వాత పోషణ మరియు ఆరోగ్య సంరక్షణకు మద్దతుగా విడతలలో నగదు లాభం.", hi = "गर्भावस्था और प्रसव के बाद पोषण और स्वास्थ्य देखभाल का समर्थन करने के लिए किस्तों में नकद लाभ।"),
            eligibility = LocalizedText(en = "Pregnant women and lactating mothers meeting scheme conditions and registration requirements under ICDS/health system.", te = "ICDS/ఆరోగ్య వ్యవస్థ కింద పథక షరతులు మరియు నమోదు నిబంధనలు తీరిన గర్భిణీ మరియు పాలిస్తున్న తల్లులు.", hi = "ICDS/स्वास्थ्य प्रणाली के तहत योजना शर्तें और पंजीकरण आवश्यकताएँ पूरी करने वाली गर्भवती और स्तनपान कराने वाली माताएँ।"),
            applyProcess = LocalizedText(en = "Register at Anganwadi/health centre with pregnancy proof and Aadhaar; benefits disbursed via DBT to bank account.", te = "అంగన్‌వాడీ/ఆరోగ్య కేంద్రంలో గర్భధారణ సాక్ష్యంతో మరియు ఆధార్‌తో నమోదు చేయండి; DBT ద్వారా బ్యాంక్ ఖాతాకు లాభాలు చెల్లించబడతాయి.", hi = "अंगनवाड़ी/स्वास्थ्य केंद्र पर गर्भावस्था प्रमाण और आधार के साथ पंजीकरण करें; लाभ DBT के माध्यम से बैंक खाते में दिए जाते हैं।")
        ),
        Scheme(
            id = "schm-17",
            title = LocalizedText(en = "Pradhan Mantri Ujjwala Yojana (PMUY)", te = "ప్రధాన మంత్రి ఉజ్జ్వల యోజన (PMUY)", hi = "प्रधानमंत्री उज्ज्वला योजना (PMUY)"),
            type = "central",
            category = "women",
            description = LocalizedText(en = "Scheme to provide LPG connections to women from Below Poverty Line (BPL) households to reduce indoor pollution.", te = "ఇండోర్ కాలుష్యాన్ని తగ్గించడానికి BPL కుటుంబాల మహిళలకు LPG కనెక్షన్లు అందించే పథకం.", hi = "घरेलू प्रदूषण कम करने के लिए BPL परिवारों की महिलाओं को LPG कनेक्शन प्रदान करने की योजना।"),
            benefits = LocalizedText(en = "Free or subsidised LPG connection, initial cylinder subsidy, and support for refills under specified terms.", te = "ఉచిత లేదా సబ్సిడీ LPG కనెక్షన్, ప్రారంభ సిలిండర్ సబ్సిడీ మరియు నిర్దిష్ట షరతుల క్రింద రీఫిల్ మద్దతు.", hi = "मुफ्त या सब्सिडी वाला LPG कनेक्शन, प्रारंभिक सिलेंडर सब्सिडी और निर्दिष्ट शर्तों के तहत रिफिल सहायता।"),
            eligibility = LocalizedText(en = "Women from BPL households or identified beneficiary categories as per scheme guidelines.", te = "పథక మార్గదర్శకాలకు అనుగుణంగా BPL కుటుంబాల మహిళలు లేదా గుర్తించిన లబ్ధిదారులు.", hi = "योजना दिशानिर्देशों के अनुसार BPL परिवारों की महिलाएँ या पहचाने गए लाभार्थी वर्ग।"),
            applyProcess = LocalizedText(en = "Apply through LPG distributor or designated portal with beneficiary ID and required documents; subsidy processed accordingly.", te = "LPG డిస్ట్రిబ్యూటర్ లేదా నియమిత పోర్టల్ ద్వారా లబ్ధిదారు ID మరియు అవసరమైన పత్రాలతో దరఖాస్తు చేయండి.", hi = "LPG वितरक या नामित पोर्टल के माध्यम से लाभार्थी ID और आवश्यक दस्तावेज़ों के साथ आवेदन करें; सब्सिडी के अनुसार प्रोसेस।")
        ),
        Scheme(
            id = "schm-18",
            title = LocalizedText(en = "Stand-Up India", te = "స్టాండ్-అప్ ఇండియా", hi = "स्टैंड-अप इंडिया"),
            type = "central",
            category = "msme",
            description = LocalizedText(en = "Scheme to facilitate bank loans between Rs.10 lakh and Rs.1 crore to SC/ST and women entrepreneurs for setting up enterprises.", te = "SC/ST మరియు మహిళా వ్యాపారులకు సంస్థలు స్థాపించడానికి రూ.10 లక్షల నుంచి రూ.1 కోటి వరకు బ్యాంకు రుణాలను సులభతరం చేసే పథకం.", hi = "SC/ST और महिला उद्यमियों को उद्यम स्थापित करने के लिए रु.10 लाख से रु.1 करोड़ तक बैंक ऋण प्रदान करने की योजना।"),
            benefits = LocalizedText(en = "Access to bank credit, handholding support, and facilitation for setting up greenfield enterprises.", te = "బ్యాంకు క్రెడిట్ యాక్సెస్, హ్యాండ్‌హోల్డింగ్ మద్దతు మరియు గ్రీన్‌ఫీల్డ్ సంస్థల ఏర్పాటుకు సౌకర్యం.", hi = "बैंक क्रेडिट तक पहुँच, मार्गदर्शन सहायता और ग्रीनफील्ड उद्यम स्थापित करने के लिए सुविधा।"),
            eligibility = LocalizedText(en = "SC/ST entrepreneurs and women entrepreneurs above 18 years seeking to set up new enterprises in manufacturing/services/trading.", te = "ఉత్పత్తి/సేవలు/వాణిజ్యంలో కొత్త సంస్థలు స్థాపించదలచిన 18 సంవత్సరాల పైబడిన SC/ST మరియు మహిళా వ్యాపారులు.", hi = "उत्पादन/सेवाएँ/व्यापार में नई इकाइयाँ स्थापित करने वाले 18 वर्ष से अधिक आयु के SC/ST और महिला उद्यमी।"),
            applyProcess = LocalizedText(en = "Apply via Stand-Up India portal or approach scheduled commercial banks with project details and KYC documents.", te = "Stand-Up India పోర్టల్ ద్వారా లేదా షెడ్యూల్డ్ కమర్షియల్ బ్యాంకులకు ప్రాజెక్ట్ వివరాలు మరియు KYC పత్రాలతో సంప్రదించండి.", hi = "Stand-Up India पोर्टल के माध्यम से आवेदन करें या प्रोजेक्ट विवरण और KYC दस्तावेज़ों के साथ अनुसूचित वाणिज्यिक बैंकों से संपर्क करें।")
        ),
        Scheme(
            id = "schm-19",
            title = LocalizedText(en = "Mahila e-Haat", te = "మహిళా ఈ-హాట్", hi = "महिला ई-हाट"),
            type = "central",
            category = "women",
            description = LocalizedText(en = "Online marketing platform for women entrepreneurs and SHGs to sell products directly to consumers.", te = "మహిళా వ్యాపారులు మరియు SHGలు తమ ఉత్పత్తులను వినియోగదారులకు నేరుగా అమ్ముకునే ఆన్‌లైన్ మార్కెటింగ్ ప్లాట్‌ఫారమ్.", hi = "महिला उद्यमियों और SHG को अपने उत्पाद सीधे उपभोक्ताओं को बेचने के लिए ऑनलाइन मार्केटिंग प्लेटफ़ॉर्म।"),
            benefits = LocalizedText(en = "Market access, promotional support, and simplified onboarding for women-led enterprises and SHGs.", te = "మార్కెట్ యాక్సెస్, ప్రమోషనల్ మద్దతు మరియు మహిళల ఆధ్వర్యంలోని సంస్థలు/SHGలకు సులభ ఆన్‌బోర్డింగ్.", hi = "बाजार पहुँच, प्रचार समर्थन और महिला-नेतृत्व वाली इकाइयों/SHG के लिए सरल ऑनबोर्डिंग।"),
            eligibility = LocalizedText(en = "Women entrepreneurs, SHGs, and women-led producer groups registered as per portal requirements.", te = "పోర్టల్ అవసరాల ప్రకారం నమోదు అయిన మహిళా వ్యాపారులు, SHGలు మరియు మహిళల ఆధ్వర్యంలోని ఉత్పత్తిదారుల గుంపులు.", hi = "पोर्टल आवश्यकताओं के अनुसार पंजीकृत महिला उद्यमी, SHG और महिला-नेतृत्व वाले उत्पादक समूह।"),
            applyProcess = LocalizedText(en = "Register on Mahila e-Haat portal, create product listings, and follow portal onboarding for payments and logistics.", te = "Mahila e-Haat పోర్టల్‌లో నమోదు చేసి ఉత్పత్తి లిస్టింగ్స్ సృష్టించండి; చెల్లింపులు, లాజిస్టిక్స్ కోసం ఆన్‌బోర్డింగ్ పాటించండి.", hi = "Mahila e-Haat पोर्टल पर पंजीकरण करें, उत्पाद सूची बनाएं और भुगतान व लॉजिस्टिक्स के लिए पोर्टल ऑनबोर्डिंग का पालन करें।")
        ),
        Scheme(
            id = "schm-20",
            title = LocalizedText(en = "Lakhpati Didi Scheme", te = "లక్షపతి దిదీ పథకం", hi = "लाखपति दीदी योजना"),
            type = "central",
            category = "women",
            description = LocalizedText(en = "Income-generation initiative to enable women SHG members to earn sustainable livelihoods through training and market linkages.", te = "శిక్షణ మరియు మార్కెట్ లింకేజెస్ ద్వారా మహిళా SHG సభ్యులకు స్థిర ఆదాయం పొందే అవకాశాలను కల్పించే ఆదాయ సృష్టి కార్యక్రమం.", hi = "प्रशिक्षण और बाजार संबंधों के माध्यम से महिला SHG सदस्यों को स्थायी आजीविका कमाने में सक्षम करने की आय-उत्पादन पहल।"),
            benefits = LocalizedText(en = "Skill training, seed capital, market access support, and targets for SHG women to achieve specified income levels.", te = "నైపుణ్య శిక్షణ, ప్రారంభ మూలధనం, మార్కెట్ యాక్సెస్ మద్దతు మరియు నిర్దిష్ట ఆదాయ లక్ష్యాలు.", hi = "कौशल प्रशिक्षण, बीज पूंजी, बाजार पहुँच सहायता और SHG महिलाओं के लिए निर्दिष्ट आय स्तर प्राप्त करने के लक्ष्य।"),
            eligibility = LocalizedText(en = "Women members of registered Self Help Groups (SHGs) participating in scheme activities and training modules.", te = "నమోదైన Self Help Groups (SHG) మహిళా సభ్యులు పథక కార్యకలాపాలు మరియు శిక్షణలో పాల్గొనాలి.", hi = "पंजीकृत Self Help Groups (SHG) की महिलाएँ जो योजना गतिविधियों और प्रशिक्षण मॉड्यूल में भाग लेती हैं।"),
            applyProcess = LocalizedText(en = "SHGs register with implementing agency or state mission; members undergo training and receive support for enterprise creation.", te = "SHGలు అమలు ఏజెన్సీ లేదా రాష్ట్ర మిషన్‌లో నమోదు చేసుకుంటాయి; సభ్యులు శిక్షణ పొందుతారు మరియు సంస్థాపనకు మద్దతు పొందుతారు.", hi = "SHG कार्यान्वयन एजेंसी या राज्य मिशन के साथ पंजीकरण करते हैं; सदस्य प्रशिक्षण लेते हैं और उद्यम स्थापना के लिए सहायता प्राप्त करते हैं।")
        ),
        Scheme(
            id = "schm-21",
            title = LocalizedText(en = "Indira Gandhi National Old Age Pension Scheme (IGNOAPS)", te = "ఇందిరా గాంధీ జాతీయ వృద్ధాప్య పెన్షన్ పథకం (IGNOAPS)", hi = "इंदिरा गांधी राष्ट्रीय वृद्धावस्था पेंशन योजना (IGNOAPS)"),
            type = "central",
            category = "elderly",
            description = LocalizedText(en = "National social assistance pension scheme providing monthly pension to eligible elderly persons below poverty thresholds.", te = "పేదరిక పరిమితుల కింద అర్హత కలిగిన వృద్ధులకు నెలవారీ పెన్షన్ అందించే జాతీయ సామాజిక సహాయ పథకం.", hi = "गरीबी सीमा के नीचे पात्र वृद्ध व्यक्तियों को मासिक पेंशन प्रदान करने वाली राष्ट्रीय सामाजिक सहायता पेंशन योजना।"),
            benefits = LocalizedText(en = "Monthly pension amount as per central/state norms transferred via DBT to beneficiary bank accounts.", te = "కేంద్ర/రాష్ట్ర నిబంధనల ప్రకారం నెలవారీ పెన్షన్ DBT ద్వారా లబ్ధిదారు బ్యాంక్ ఖాతాలకు జమ చేయబడుతుంది.", hi = "केंद्र/राज्य मानदंडों के अनुसार मासिक पेंशन राशि DBT के माध्यम से लाभार्थी के बैंक खाते में स्थानांतरित।"),
            eligibility = LocalizedText(en = "Elderly persons meeting age and income criteria specified under NSAP and state supplementation rules.", te = "NSAP మరియు రాష్ట్ర అనుబంధ నిబంధనల ప్రకారం వయస్సు మరియు ఆదాయ ప్రమాణాలు తీరిన వృద్ధులు.", hi = "NSAP और राज्य पूरक नियमों के तहत आयु और आय मानदंडों को पूरा करने वाले वृद्ध व्यक्ति।"),
            applyProcess = LocalizedText(en = "Apply at local social welfare/gram panchayat office with ID, age proof, income certificate; pension sanctioned and disbursed via DBT.", te = "స్థానిక సామాజిక సంక్షేమ/గ్రామ పంచాయతీ కార్యాలయంలో ID, వయస్సు సాక్ష్యం, ఆదాయ సర్టిఫికెట్‌తో దరఖాస్తు చేయండి; DBT ద్వారా పెన్షన్ చెల్లించబడుతుంది.", hi = "स्थानीय सामाजिक कल्याण/ग्राम पंचायत कार्यालय में पहचान, आयु प्रमाण और आय प्रमाणपत्र के साथ आवेदन करें; पेंशन DBT के माध्यम से दी जाती है।")
        ),
        Scheme(
            id = "schm-22",
            title = LocalizedText(en = "PM Vaya Vandana Yojana (PMVVY)", te = "PM వాయ వందన యోజన (PMVVY)", hi = "PM वय वंदना योजना (PMVVY)"),
            type = "central",
            category = "elderly",
            description = LocalizedText(en = "Pension scheme administered through LIC offering guaranteed pension to senior citizens for a fixed period.", te = "LIC ద్వారా నిర్వహించబడే పెన్షన్ పథకం, నిర్దిష్ట కాలానికి వృద్ధులకు గ్యారంటీ పెన్షన్ అందిస్తుంది.", hi = "LIC के माध्यम से प्रशासित पेंशन योजना जो वरिष्ठ नागरिकों को निश्चित अवधि के लिए गारंटीकृत पेंशन देती है।"),
            benefits = LocalizedText(en = "Guaranteed pension payout options with assured returns as per scheme terms; lump-sum and pension choices available.", te = "పథక నిబంధనల ప్రకారం నిర్ధారిత రిటర్న్స్‌తో గ్యారంటీ పెన్షన్; లంప్-సమ్ మరియు పెన్షన్ ఎంపికలు.", hi = "योजना शर्तों के अनुसार सुनिश्चित रिटर्न के साथ गारंटीकृत पेंशन भुगतान विकल्प; एकमुश्त और पेंशन विकल्प उपलब्ध।"),
            eligibility = LocalizedText(en = "Senior citizens within specified age bracket who invest lump-sum premium as per scheme rules.", te = "పథక నిబంధనల ప్రకారం లంప్-సమ్ ప్రీమియం పెట్టుబడి చేసే నిర్దిష్ట వయస్సు పరిధిలో వృద్ధులు.", hi = "योजना नियमों के अनुसार एकमुश्त प्रीमियम का निवेश करने वाले निर्दिष्ट आयु वर्ग के वरिष्ठ नागरिक।"),
            applyProcess = LocalizedText(en = "Purchase PMVVY policy through LIC offices or empanelled agents with KYC and identity documents.", te = "LIC కార్యాలయాలు లేదా ఎంపనెల్డ్ ఏజెంట్ల ద్వారా KYC మరియు గుర్తింపు పత్రాలతో PMVVY పాలసీ కొనుగోలు చేయండి.", hi = "LIC कार्यालयों या पैनल एजेंटों के माध्यम से KYC और पहचान दस्तावेज़ों के साथ PMVVY पॉलिसी खरीदें।")
        ),
        Scheme(
            id = "schm-23",
            title = LocalizedText(en = "Senior Citizens Savings Scheme (SCSS)", te = "సీనియర్ సిటిజన్స్ సేవింగ్స్ స్కీమ్ (SCSS)", hi = "सीनियर सिटिज़न्स सेविंग्स स्कीम (SCSS)"),
            type = "central",
            category = "elderly",
            description = LocalizedText(en = "Government-backed savings instrument offering regular income and tax benefits for senior citizens.", te = "వృద్ధులకు రెగ్యులర్ ఆదాయం మరియు పన్ను ప్రయోజనాలు అందించే ప్రభుత్వ మద్దతు పొదుపు పరికరం.", hi = "वरिष्ठ नागरिकों के लिए नियमित आय और कर लाभ प्रदान करने वाला सरकारी समर्थित बचत साधन।"),
            benefits = LocalizedText(en = "Quarterly interest payouts at prescribed rate, capital protection, and tax benefits under specified sections.", te = "నిర్దిష్ట రేటు ప్రకారం త్రైమాసిక వడ్డీ చెల్లింపులు, మూలధన రక్షణ మరియు పన్ను ప్రయోజనాలు.", hi = "निर्धारित दर पर त्रैमासिक ब्याज भुगतान, पूंजी सुरक्षा और निर्दिष्ट धाराओं के तहत कर लाभ।"),
            eligibility = LocalizedText(en = "Individuals aged 60 years and above (with relaxations for certain categories) as per scheme rules.", te = "పథక నిబంధనల ప్రకారం 60 సంవత్సరాలు మరియు అంతకంటే పై వయస్సు ఉన్న వ్యక్తులు (కొన్ని వర్గాలకు రాహిత్యాలు).", hi = "योजना नियमों के अनुसार 60 वर्ष और उससे अधिक आयु के व्यक्ति (कुछ वर्गों के लिए छूट)।"),
            applyProcess = LocalizedText(en = "Open SCSS account at post office or authorised bank with ID, age proof and initial deposit as required.", te = "ID, వయస్సు సాక్ష్యం మరియు అవసరమైన ప్రారంభ జమతో పోస్ట్ ఆఫీస్ లేదా అనుమతిప్రాప్త బ్యాంకులో SCSS ఖాతా తెరవండి.", hi = "पहचान, आयु प्रमाण और आवश्यक प्रारंभिक जमा के साथ डाकघर या अधिकृत बैंक में SCSS खाता खोलें।")
        ),
        Scheme(
            id = "schm-24",
            title = LocalizedText(en = "ADIP Scheme (Assistance to Disabled Persons for Purchase/Fitting of Aids and Appliances)", te = "ADIP పథకం (సహాయ పరికరాల కొరకు విక్రయం/ఫిట్టింగ్ సహాయం)", hi = "ADIP योजना (सहायता उपकरणों की खरीद/फिटिंग के लिए सहायता)"),
            type = "central",
            category = "disabled",
            description = LocalizedText(en = "Scheme to provide assistive devices and appliances to Divyangjan to enhance mobility and independence.", te = "చలనం మరియు స్వతంత్రత పెంచడానికి దివ్యాంగులకు సహాయక పరికరాలు అందించే పథకం.", hi = "गतिशीलता और स्वतंत्रता बढ़ाने के लिए दिव्यांगों को सहायक उपकरण प्रदान करने की योजना।"),
            benefits = LocalizedText(en = "Free or subsidised assistive devices (wheelchairs, hearing aids, prosthetics) and fitting support through implementing agencies.", te = "ఉచిత లేదా సబ్సిడీ సహాయక పరికరాలు (వీల్చెయిర్లు, హియరింగ్ ఏడ్స్, ప్రోస్తెటిక్స్) మరియు ఫిట్టింగ్ మద్దతు.", hi = "मुफ्त या सब्सिडी वाले सहायक उपकरण (व्हीलचेयर, हियरिंग एड, प्रोस्थेटिक्स) और फिटिंग सहायता।"),
            eligibility = LocalizedText(en = "Persons with disabilities certified by competent medical authorities as per scheme norms.", te = "పథక నిబంధనల ప్రకారం అర్హ వైద్య అధికారుల ద్వారా ధృవీకరించబడిన దివ్యాంగులు.", hi = "योजना मानदंडों के अनुसार सक्षम चिकित्सा प्राधिकरणों द्वारा प्रमाणित विकलांग व्यक्ति।"),
            applyProcess = LocalizedText(en = "Apply at designated implementing agencies, rehabilitation centres or through state disability portals with disability certificate.", te = "నిర్దేశిత అమలు ఏజెన్సీలు, పునరావాస కేంద్రాలు లేదా రాష్ట్ర వికలాంగత పోర్టల్స్ ద్వారా దివ్యాంగత సర్టిఫికెట్‌తో దరఖాస్తు చేయండి.", hi = "नामित कार्यान्वयन एजेंसियों, पुनर्वास केंद्रों या राज्य विकलांगता पोर्टल के माध्यम से विकलांगता प्रमाणपत्र के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-25",
            title = LocalizedText(en = "Niramaya Health Insurance Scheme for Persons with Disabilities", te = "నిరామయ ఆరోగ్య బీమా పథకం (దివ్యాంగుల కోసం)", hi = "निरामय स्वास्थ्य बीमा योजना (विकलांगों के लिए)"),
            type = "central",
            category = "disabled",
            description = LocalizedText(en = "Health insurance scheme providing coverage for medical expenses of persons with disabilities.", te = "దివ్యాంగుల వైద్య ఖర్చుల కోసం కవర్ అందించే ఆరోగ్య బీమా పథకం.", hi = "विकलांग व्यक्तियों के चिकित्सा खर्च के लिए कवरेज प्रदान करने वाली स्वास्थ्य बीमा योजना।"),
            benefits = LocalizedText(en = "Cashless or reimbursement-based medical coverage up to specified limits for treatment and hospitalization.", te = "చికిత్స మరియు ఆసుపత్రి ఖర్చుల కోసం నిర్దిష్ట పరిమితుల వరకు క్యాష్‌లెస్ లేదా రీఇంబర్స్మెంట్ ఆధారిత కవర్.", hi = "इलाज और अस्पताल में भर्ती के लिए निर्दिष्ट सीमाओं तक कैशलेस या प्रतिपूर्ति-आधारित कवरेज।"),
            eligibility = LocalizedText(en = "Persons with disabilities as defined under the Rights of Persons with Disabilities Act and scheme rules.", te = "వికలాంగుల హక్కుల చట్టం మరియు పథక నిబంధనల ప్రకారం దివ్యాంగులు అర్హులు.", hi = "विकलांग व्यक्तियों के अधिकार अधिनियम और योजना नियमों के अनुसार विकलांग व्यक्ति पात्र।"),
            applyProcess = LocalizedText(en = "Enroll through implementing agency or state disability welfare department with disability certificate and KYC documents.", te = "అమలు ఏజెన్సీ లేదా రాష్ట్ర వికలాంగ సంక్షేమ శాఖ ద్వారా దివ్యాంగత సర్టిఫికెట్ మరియు KYC పత్రాలతో నమోదు చేయండి.", hi = "कार्यान्वयन एजेंसी या राज्य विकलांगता कल्याण विभाग के माध्यम से विकलांगता प्रमाणपत्र और KYC दस्तावेज़ों के साथ नामांकन करें।")
        ),
        Scheme(
            id = "schm-26",
            title = LocalizedText(en = "National Trust Schemes (DISHA, VIKAAS, SAMARTH, GHARAUNDA)", te = "నేషనల్ ట్రస్ట్ పథకాలు (DISHA, VIKAAS, SAMARTH, GHARAUNDA)", hi = "नेशनल ट्रस्ट योजनाएँ (DISHA, VIKAAS, SAMARTH, GHARAUNDA)"),
            type = "central",
            category = "disabled",
            description = LocalizedText(en = "Set of schemes by National Trust for welfare, rehabilitation, and capacity building of persons with autism, cerebral palsy, mental retardation and multiple disabilities.", te = "ఆటిజం, సెరెబ్రల్ పాల్సీ, మానసిక వికలాంగత మరియు బహుళ వికలాంగతలున్న వ్యక్తుల సంక్షేమం, పునరావాసం మరియు సామర్థ్య నిర్మాణానికి నేషనల్ ట్రస్ట్ పథకాలు.", hi = "ऑटिज़्म, सेरेब्रल पाल्सी, मानसिक अक्षमता और बहु विकलांगताओं वाले व्यक्तियों के कल्याण, पुनर्वास और क्षमता निर्माण के लिए नेशनल ट्रस्ट की योजनाएँ।"),
            benefits = LocalizedText(en = "Support for group homes, therapy centres, skill training, caregiver support and community-based rehabilitation.", te = "గ్రూప్ హోమ్స్, థెరపీ సెంటర్లు, నైపుణ్య శిక్షణ, కేర్‌గివర్ మద్దతు మరియు కమ్యూనిటీ పునరావాసానికి మద్దతు.", hi = "ग्रुप होम, थेरेपी केंद्र, कौशल प्रशिक्षण, देखभालकर्ता सहायता और समुदाय-आधारित पुनर्वास के लिए समर्थन।"),
            eligibility = LocalizedText(en = "Persons with specified disabilities and organisations registered with National Trust as per scheme norms.", te = "పథక నిబంధనల ప్రకారం నిర్దిష్ట వికలాంగతలున్న వ్యక్తులు మరియు నేషనల్ ట్రస్ట్‌లో నమోదు అయిన సంస్థలు.", hi = "योजना मानदंडों के अनुसार निर्दिष्ट विकलांगताओं वाले व्यक्ति और नेशनल ट्रस्ट में पंजीकृत संगठन।"),
            applyProcess = LocalizedText(en = "Apply through National Trust portal or designated implementing organisations with required certificates and documentation.", te = "నేషనల్ ట్రస్ట్ పోర్టల్ లేదా నియమిత అమలు సంస్థల ద్వారా అవసరమైన సర్టిఫికెట్లు మరియు పత్రాలతో దరఖాస్తు చేయండి.", hi = "नेशनल ट्रस्ट पोर्टल या नामित कार्यान्वयन संगठनों के माध्यम से आवश्यक प्रमाणपत्र और दस्तावेज़ों के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-27",
            title = LocalizedText(en = "Divyangjan Swayalamban Yojana", te = "దివ్యాంగజన్ స్వయలంబన్ యోజన", hi = "दिव्यांगजन स्वावलंबन योजना"),
            type = "central",
            category = "disabled",
            description = LocalizedText(en = "Scheme to provide concessional loans and support for self-employment and entrepreneurship among persons with disabilities.", te = "దివ్యాంగులలో స్వయం-ఉద్యోగం మరియు వ్యాపారానికి సౌకర్యవంతమైన రుణాలు మరియు మద్దతు అందించే పథకం.", hi = "विकलांग व्यक्तियों के बीच स्वरोजगार और उद्यमिता के लिए सुलभ ऋण और सहायता प्रदान करने की योजना।"),
            benefits = LocalizedText(en = "Concessional credit, interest subvention, and handholding support for setting up micro-enterprises.", te = "సౌకర్యవంతమైన క్రెడిట్, వడ్డీ ఉపసంహరణ మరియు సూక్ష్మ సంస్థలు స్థాపనకు మద్దతు.", hi = "सुलभ क्रेडिट, ब्याज उपवेशन और सूक्ष्म उद्यम स्थापित करने के लिए मार्गदर्शन सहायता।"),
            eligibility = LocalizedText(en = "Persons with disabilities meeting scheme criteria and viable project proposals for self-employment.", te = "పథక ప్రమాణాలు మరియు స్వయం-ఉద్యోగానికి అనువైన ప్రాజెక్ట్ ప్రతిపాదనలు తీరిన దివ్యాంగులు.", hi = "योजना मानदंडों और स्वरोजगार के लिए व्यवहार्य परियोजना प्रस्तावों को पूरा करने वाले विकलांग व्यक्ति।"),
            applyProcess = LocalizedText(en = "Apply through designated banks, implementing agencies or state disability missions with project plan and disability certificate.", te = "నిర్దేశిత బ్యాంకులు, అమలు ఏజెన్సీలు లేదా రాష్ట్ర వికలాంగ మిషన్ల ద్వారా ప్రాజెక్ట్ ప్లాన్ మరియు దివ్యాంగత సర్టిఫికెట్‌తో దరఖాస్తు చేయండి.", hi = "नामित बैंकों, कार्यान्वयन एजेंसियों या राज्य विकलांगता मिशन के माध्यम से परियोजना योजना और विकलांगता प्रमाणपत्र के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-28",
            title = LocalizedText(en = "Skill India / Pradhan Mantri Kaushal Vikas Yojana (PMKVY)", te = "స్కిల్ ఇండియా / ప్రధాన్ మంత్రి కౌశల్ వికాస్ యోజన (PMKVY)", hi = "स्किल इंडिया / प्रधानमंत्री कौशल विकास योजना (PMKVY)"),
            type = "central",
            category = "empowerment",
            description = LocalizedText(en = "National mission to provide skill training and certification to youth to enhance employability and entrepreneurship.", te = "ఉద్యోగ సామర్థ్యాన్ని మరియు వ్యాపార నైపుణ్యాన్ని పెంచడానికి యువతకు నైపుణ్య శిక్షణ మరియు సర్టిఫికేషన్ అందించే జాతీయ మిషన్.", hi = "रोजगार क्षमता और उद्यमिता बढ़ाने के लिए युवाओं को कौशल प्रशिक्षण और प्रमाणन प्रदान करने का राष्ट्रीय मिशन।"),
            benefits = LocalizedText(en = "Short-term training, assessment and certification, placement support, and monetary incentives for trainees in some courses.", te = "సంక్షిప్త శిక్షణ, మూల్యాంకనం మరియు సర్టిఫికేషన్, ప్లేస్‌మెంట్ మద్దతు మరియు కొన్ని కోర్సులలో శిక్షణార్థులకు ఆర్థిక ప్రోత్సాహకాలు.", hi = "लघु अवधि प्रशिक्षण, मूल्यांकन और प्रमाणन, प्लेसमेंट सहायता और कुछ पाठ्यक्रमों में प्रशिक्षुओं के लिए मौद्रिक प्रोत्साहन।"),
            eligibility = LocalizedText(en = "Youth and job-seekers meeting age and basic educational criteria as per specific training course requirements.", te = "వయస్సు మరియు ప్రాథమిక విద్యా ప్రమాణాలు కోర్సు అవసరాల ప్రకారం తీరిన యువత మరియు ఉద్యోగార్థులు.", hi = "विशिष्ट प्रशिक्षण पाठ्यक्रम आवश्यकताओं के अनुसार आयु और बुनियादी शैक्षिक मानदंडों को पूरा करने वाले युवा और नौकरी चाहने वाले।"),
            applyProcess = LocalizedText(en = "Register on PMKVY portal or at affiliated training centres, choose course, undergo training, assessment and certification.", te = "PMKVY పోర్టల్ లేదా అనుబంధ శిక్షణ కేంద్రాలలో నమోదు చేసి కోర్సు ఎంచుకుని శిక్షణ, మూల్యాంకనం మరియు సర్టిఫికేషన్ పొందండి.", hi = "PMKVY पोर्टल या संबद्ध प्रशिक्षण केंद्रों पर पंजीकरण करें, कोर्स चुनें, प्रशिक्षण, मूल्यांकन और प्रमाणन प्राप्त करें।")
        ),
        Scheme(
            id = "schm-29",
            title = LocalizedText(en = "Pradhan Mantri Mudra Yojana (PMMY)", te = "ప్రధాన్ మంత్రి ముద్రా యోజన (PMMY)", hi = "प्रधानमंत्री मुद्रा योजना (PMMY)"),
            type = "central",
            category = "empowerment",
            description = LocalizedText(en = "Scheme to provide collateral-free loans to micro and small enterprises for income generation and business expansion.", te = "ఆదాయ సృష్టి మరియు వ్యాపార విస్తరణ కోసం సూక్ష్మ మరియు చిన్న సంస్థలకు కోలాటరల్-రహిత రుణాలు అందించే పథకం.", hi = "आय सृजन और व्यवसाय विस्तार के लिए सूक्ष्म और लघु उद्यमों को बिना गिरवी ऋण प्रदान करने की योजना।"),
            benefits = LocalizedText(en = "Loans under Shishu, Kishore and Tarun categories up to specified limits with flexible repayment terms.", te = "Shishu, Kishore మరియు Tarun వర్గాల క్రింద నిర్దిష్ట పరిమితుల వరకు రుణాలు మరియు సౌకర్యవంతమైన తిరిగి చెల్లింపు షరతులు.", hi = "Shishu, Kishore और Tarun श्रेणियों के तहत निर्दिष्ट सीमाओं तक ऋण और लचीले पुनर्भुगतान शर्तें।"),
            eligibility = LocalizedText(en = "Micro and small entrepreneurs, proprietors, and small business owners meeting lender criteria and project viability.", te = "సూక్ష్మ మరియు చిన్న వ్యాపార యజమానులు, ప్రాజెక్ట్ సామర్థ్యాన్ని మరియు రుణదాత ప్రమాణాలను తీరాలి.", hi = "सूक्ष्म और लघु उद्यमी, स्वामित्वकर्ता और छोटे व्यवसाय के मालिक जो ऋणदाता मानदंड और परियोजना व्यवहार्यता को पूरा करते हैं।"),
            applyProcess = LocalizedText(en = "Apply at banks or NBFCs empanelled under MUDRA with business plan, KYC and required documents for sanction.", te = "MUDRA కింద ఎంపనెల్డ్ బ్యాంకులు లేదా NBFCల వద్ద వ్యాపార ప్రణాళిక, KYC మరియు అవసరమైన పత్రాలతో దరఖాస్తు చేయండి.", hi = "MUDRA के तहत पैनलबद्ध बैंकों या NBFC में व्यवसाय योजना, KYC और आवश्यक दस्तावेज़ों के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-30",
            title = LocalizedText(en = "CGTMSE (Credit Guarantee Fund Trust for Micro and Small Enterprises)", te = "CGTMSE (క్రెడిట్ గ్యారెంటీ ఫండ్ ట్రస్ట్ ఫర్ మైక్రో అండ్ స్మాల్ ఎంటర్ప్రైజెస్)", hi = "CGTMSE (क्रेडिट गारंटी फंड ट्रस्ट फॉर माइक्रो और स्मॉल एंटरप्राइजेज)"),
            type = "central",
            category = "msme",
            description = LocalizedText(en = "Credit guarantee scheme to enable collateral-free lending to micro and small enterprises by providing guarantee cover to lenders.", te = "రుణదాతలకు గ్యారెంటీ కవర్ అందించడం ద్వారా సూక్ష్మ మరియు చిన్న సంస్థలకు కోలాటరల్-రహిత రుణాలను సులభతరం చేసే క్రెడిట్ గ్యారెంటీ పథకం.", hi = "ऋणदाताओं को गारंटी कवरेज प्रदान करके सूक्ष्म और लघु उद्यमों को बिना गिरवी ऋण देने में सक्षम बनाने वाली क्रेडिट गारंटी योजना।"),
            benefits = LocalizedText(en = "Guarantee cover for eligible loans, improving access to credit for new and existing micro/small enterprises.", te = "అర్హ రుణాలకు గ్యారెంటీ కవర్, కొత్త మరియు ఉన్న సూక్ష్మ/చిన్న సంస్థలకు క్రెడిట్ యాక్సెస్ మెరుగుపరుస్తుంది.", hi = "पात्र ऋणों के लिए गारंटी कवरेज, नए और मौजूदा सूक्ष्म/लघु उद्यमों के लिए क्रेडिट पहुँच में सुधार।"),
            eligibility = LocalizedText(en = "Micro and small enterprises availing term loans or working capital limits from participating lending institutions.", te = "భాగస్వామ్య రుణదాత సంస్థల నుండి టర్మ్ లోన్స్ లేదా వర్కింగ్ క్యాపిటల్ పరిమితులను పొందే సూక్ష్మ మరియు చిన్న సంస్థలు.", hi = "भाग लेने वाले ऋणदाता संस्थानों से टर्म लोन या वर्किंग कैपिटल सीमा लेने वाले सूक्ष्म और लघु उद्यम।"),
            applyProcess = LocalizedText(en = "Approach participating bank/NBFC for loan; lender processes guarantee cover under CGTMSE during sanction.", te = "రుణానికి భాగస్వామ్య బ్యాంక్/NBFCకు సంప్రదించండి; బ్యాంక్ CGTMSE కింద గ్యారెంటీ కవర్‌ను ప్రాసెస్ చేస్తుంది.", hi = "ऋण के लिए भाग लेने वाले बैंक/NBFC से संपर्क करें; ऋणदाता स्वीकृति के दौरान CGTMSE के तहत गारंटी कवरेज प्रोसेस करता है।")
        ),
        Scheme(
            id = "schm-31",
            title = LocalizedText(en = "Prime Minister's Employment Generation Programme (PMEGP)", te = "ప్రధాన మంత్రి ఉపాధి సృష్టి కార్యక్రమం (PMEGP)", hi = "प्रधानमंत्री रोजगार सृजन कार्यक्रम (PMEGP)"),
            type = "central",
            category = "msme",
            description = LocalizedText(en = "Credit-linked subsidy scheme for setting up micro-enterprises in manufacturing, services and trading sectors.", te = "ఉత్పత్తి, సేవలు మరియు వాణిజ్య రంగాలలో సూక్ష్మ సంస్థలు స్థాపించడానికి క్రెడిట్-లింక్డ్ సబ్సిడీ పథకం.", hi = "उत्पादन, सेवाएँ और व्यापार क्षेत्रों में सूक्ष्म उद्यम स्थापित करने के लिए क्रेडिट-लिंक्ड सब्सिडी योजना।"),
            benefits = LocalizedText(en = "Margin money subsidy, bank loan facilitation and support for project implementation for eligible beneficiaries.", te = "మార్జిన్ మనీ సబ్సిడీ, బ్యాంకు రుణ సౌకర్యం మరియు అర్హులైన లబ్ధిదారులకు ప్రాజెక్ట్ అమలుకు మద్దతు.", hi = "मार्जिन मनी सब्सिडी, बैंक ऋण सुविधा और पात्र लाभार्थियों के लिए परियोजना कार्यान्वयन सहायता।"),
            eligibility = LocalizedText(en = "Individuals, SHGs, and institutions meeting age, educational and project criteria as per scheme guidelines.", te = "పథక మార్గదర్శకాల ప్రకారం వయస్సు, విద్య మరియు ప్రాజెక్ట్ ప్రమాణాలు తీరిన వ్యక్తులు, SHGలు మరియు సంస్థలు.", hi = "योजना दिशानिर्देशों के अनुसार आयु, शैक्षिक और परियोजना मानदंडों को पूरा करने वाले व्यक्ति, SHG और संस्थाएँ।"),
            applyProcess = LocalizedText(en = "Submit project proposal to District Industries Centre or nodal agency; bank processes loan with subsidy on sanction.", te = "జిల్లా ఇండస్ట్రీస్ సెంటర్ లేదా నోడల్ ఏజెన్సీకి ప్రాజెక్ట్ ప్రతిపాదన సమర్పించండి; బ్యాంక్ ఆమోద సమయంలో సబ్సిడీతో రుణాన్ని ప్రాసెస్ చేస్తుంది.", hi = "जिला उद्योग केंद्र या नोडल एजेंसी को परियोजना प्रस्ताव जमा करें; बैंक स्वीकृति पर सब्सिडी के साथ ऋण प्रोसेस करता है।")
        ),
        Scheme(
            id = "schm-32",
            title = LocalizedText(en = "PM Vishwakarma Yojana", te = "PM విశ్వకర్మ యోజన", hi = "PM विश्वकर्मा योजना"),
            type = "central",
            category = "msme",
            description = LocalizedText(en = "Scheme to provide financial support, toolkits and training to traditional artisans and craftspeople for enterprise creation.", te = "సాంప్రదాయ కళాకారులు మరియు శిల్పులకు సంస్థాపన కోసం ఆర్థిక మద్దతు, టూల్‌కిట్లు మరియు శిక్షణ అందించే పథకం.", hi = "पारंपरिक कारीगरों और शिल्पकारों को उद्यम स्थापना के लिए वित्तीय सहायता, टूलकिट और प्रशिक्षण प्रदान करने की योजना।"),
            benefits = LocalizedText(en = "Loans, grants for toolkits, skill upgradation, and market linkages to improve livelihoods of artisans.", te = "రుణాలు, టూల్‌కిట్‌లకు గ్రాంట్లు, నైపుణ్య అభివృద్ధి మరియు మార్కెట్ లింకేజెస్ ద్వారా జీవనోపాధి మెరుగుదల.", hi = "ऋण, टूलकिट के लिए अनुदान, कौशल उन्नयन और शिल्पकारों की आजीविका सुधारने के लिए बाजार संबंध।"),
            eligibility = LocalizedText(en = "Traditional artisans, craftspeople and micro-enterprises in the unorganised sector meeting scheme criteria.", te = "సాంప్రదాయ కళాకారులు, శిల్పకారులు మరియు పథక ప్రమాణాలు తీరిన సూక్ష్మ సంస్థలు.", hi = "पारंपरिक कारीगर, शिल्पकार और योजना मानदंडों को पूरा करने वाले असंगठित क्षेत्र के सूक्ष्म उद्यम।"),
            applyProcess = LocalizedText(en = "Register with implementing agency or through local artisan clusters; submit ID, craft proof and project details for support.", te = "అమలు ఏజెన్సీ లేదా స్థానిక కళాకారుల క్లస్టర్ల ద్వారా నమోదు చేసి ID, కళా సాక్ష్యం మరియు ప్రాజెక్ట్ వివరాలు సమర్పించండి.", hi = "कार्यान्वयन एजेंसी या स्थानीय कारीगर क्लस्टर के माध्यम से पंजीकरण करें; समर्थन के लिए पहचान, शिल्प प्रमाण और परियोजना विवरण जमा करें।")
        ),
        Scheme(
            id = "schm-33",
            title = LocalizedText(en = "Post-Matric Scholarships for SC/ST/OBC", te = "పోస్ట్-మెట్రిక్ స్కాలర్‌షిప్‌లు (SC/ST/OBC)", hi = "पोस्ट-मैट्रिक छात्रवृत्तियाँ (SC/ST/OBC)"),
            type = "central",
            category = "caste",
            description = LocalizedText(en = "Scholarships to support education of students from SC, ST and OBC communities at post-matriculation level.", te = "పోస్ట్-మెట్రిక్ స్థాయిలో SC, ST మరియు OBC సముదాయాల విద్యార్థుల విద్యకు మద్దతుగా స్కాలర్‌షిప్‌లు.", hi = "पोस्ट-मैट्रिक स्तर पर SC, ST और OBC समुदायों के छात्रों की शिक्षा का समर्थन करने वाली छात्रवृत्तियाँ।"),
            benefits = LocalizedText(en = "Tuition fee reimbursement, maintenance allowance and other support as per category-specific scheme rules.", te = "ఫీజు రీఇంబర్స్మెంట్, నిర్వహణ అలవెన్స్ మరియు వర్గ-నిర్దిష్ట నిబంధనల ప్రకారం ఇతర మద్దతు.", hi = "श्रेणी-विशिष्ट योजना नियमों के अनुसार ट्यूशन शुल्क प्रतिपूर्ति, रखरखाव भत्ता और अन्य सहायता।"),
            eligibility = LocalizedText(en = "Students belonging to SC/ST/OBC categories meeting income and academic criteria specified in scheme guidelines.", te = "పథక మార్గదర్శకాల్లో పేర్కొన్న ఆదాయ మరియు అకాడెమిక్ ప్రమాణాలు తీరిన SC/ST/OBC విద్యార్థులు.", hi = "योजना दिशानिर्देशों में निर्दिष्ट आय और शैक्षणिक मानदंडों को पूरा करने वाले SC/ST/OBC छात्र।"),
            applyProcess = LocalizedText(en = "Apply via NSP or state scholarship portals with caste certificate, income proof and academic records for verification.", te = "NSP లేదా రాష్ట్ర స్కాలర్‌షిప్ పోర్టల్స్ ద్వారా జాతి సర్టిఫికెట్, ఆదాయ సాక్ష్యం మరియు అకాడెమిక్ రికార్డులతో దరఖాస్తు చేయండి.", hi = "NSP या राज्य छात्रवृत्ति पोर्टल के माध्यम से जाति प्रमाणपत्र, आय प्रमाण और शैक्षणिक रिकॉर्ड के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-34",
            title = LocalizedText(en = "Top Class Education Scheme for SC/ST", te = "టాప్ క్లాస్ ఎడ్యుకేషన్ స్కీమ్ (SC/ST)", hi = "टॉप क्लास शिक्षा योजना (SC/ST)"),
            type = "central",
            category = "caste",
            description = LocalizedText(en = "Scheme to support meritorious SC/ST students for higher education in premier institutions with full financial assistance.", te = "ప్రధాన సంస్థల్లో ఉన్నత విద్య కోసం మెరిట్ ఆధారిత SC/ST విద్యార్థులకు పూర్తి ఆర్థిక సహాయం అందించే పథకం.", hi = "प्रमुख संस्थानों में उच्च शिक्षा के लिए मेरिट-आधारित SC/ST छात्रों को पूर्ण वित्तीय सहायता प्रदान करने वाली योजना।"),
            benefits = LocalizedText(en = "Tuition fees, maintenance allowance and other expenses covered as per scheme norms for selected students.", te = "ఎంపికైన విద్యార్థులకు పథక నిబంధనల ప్రకారం ఫీజు, నిర్వహణ అలవెన్స్ మరియు ఇతర ఖర్చులు కవర్ చేయబడతాయి.", hi = "चयनित छात्रों के लिए योजना मानदंडों के अनुसार ट्यूशन फीस, रखरखाव भत्ता और अन्य खर्च कवर।"),
            eligibility = LocalizedText(en = "SC/ST students who secure admission in premier institutions and meet merit and income criteria specified.", te = "ప్రధాన సంస్థల్లో ప్రవేశం పొందిన మరియు నిర్దిష్ట మెరిట్/ఆదాయ ప్రమాణాలు తీరిన SC/ST విద్యార్థులు.", hi = "प्रमुख संस्थानों में प्रवेश पाने वाले और निर्दिष्ट मेरिट/आय मानदंडों को पूरा करने वाले SC/ST छात्र।"),
            applyProcess = LocalizedText(en = "Apply through designated scholarship portal or institution with admission proof, caste certificate and income documents.", te = "నియమిత స్కాలర్‌షిప్ పోర్టల్ లేదా సంస్థ ద్వారా ప్రవేశ సాక్ష్యం, జాతి సర్టిఫికెట్ మరియు ఆదాయ పత్రాలతో దరఖాస్తు చేయండి.", hi = "नामित छात्रवृत्ति पोर्टल या संस्थान के माध्यम से प्रवेश प्रमाण, जाति प्रमाणपत्र और आय दस्तावेज़ों के साथ आवेदन करें।")
        ),
        Scheme(
            id = "schm-35",
            title = LocalizedText(en = "Ayushman Bharat Pradhan Mantri Jan Arogya Yojana (PM-JAY)", te = "ఆయుష్మాన్ భారత్ ప్రధాన్ మంత్రి జన ఆరోగ్య యోజన (PM-JAY)", hi = "आयुष्मान भारत प्रधानमंत्री जन आरोग्य योजना (PM-JAY)"),
            type = "central",
            category = "welfare",
            description = LocalizedText(en = "National health protection scheme providing health insurance coverage for secondary and tertiary care hospitalization to eligible families.", te = "అర్హ కుటుంబాలకు ద్వితీయ మరియు తృతీయ స్థాయి ఆసుపత్రి చికిత్సకు ఆరోగ్య బీమా కవర్ అందించే జాతీయ ఆరోగ్య రక్షణ పథకం.", hi = "पात्र परिवारों को द्वितीयक और तृतीयक देखभाल अस्पताल में भर्ती के लिए स्वास्थ्य बीमा कवरेज प्रदान करने वाली राष्ट्रीय स्वास्थ्य सुरक्षा योजना।"),
            benefits = LocalizedText(en = "Health cover up to Rs. 5 lakh per family per year for specified procedures and hospitalisation under empanelled hospitals.", te = "ఎంపనెల్డ్ ఆసుపత్రులలో నిర్దిష్ట ప్రక్రియలు మరియు ఆసుపత్రి చికిత్సలకు కుటుంబానికి సంవత్సరానికి రూ.5 లక్షల వరకు ఆరోగ్య కవర్.", hi = "नामांकित अस्पतालों में निर्दिष्ट प्रक्रियाओं और अस्पताल में भर्ती के लिए प्रति परिवार प्रति वर्ष रु.5 लाख तक स्वास्थ्य कवरेज।"),
            eligibility = LocalizedText(en = "Poor and vulnerable families identified through SECC or state-specific beneficiary lists as per scheme criteria.", te = "SECC లేదా రాష్ట్ర-నిర్దిష్ట లబ్ధిదారు జాబితాల ద్వారా గుర్తించిన పేద మరియు బలహీన కుటుంబాలు.", hi = "SECC या राज्य-विशिष्ट लाभार्थी सूचियों के माध्यम से पहचाने गए गरीब और कमजोर परिवार।"),
            applyProcess = LocalizedText(en = "Check eligibility on PM-JAY portal, obtain e-card through authorized centres or online, and avail treatment at empanelled hospitals.", te = "PM-JAY పోర్టల్‌లో అర్హత తనిఖీ చేసి, అధికృత కేంద్రాల ద్వారా లేదా ఆన్‌లైన్‌లో e-card పొందండి మరియు ఎంపనెల్డ్ ఆసుపత్రుల్లో చికిత్స పొందండి.", hi = "PM-JAY पोर्टल पर पात्रता जांचें, अधिकृत केंद्रों या ऑनलाइन के माध्यम से e-card प्राप्त करें और नामांकित अस्पतालों में उपचार प्राप्त करें।")
        ),
        Scheme(
            id = "schm-36",
            title = LocalizedText(en = "Pradhan Mantri Garib Kalyan Anna Yojana (PMGKAY)", te = "ప్రధాన్ మంత్రి గరీబ్ కల్యాణ అన్న యోజన (PMGKAY)", hi = "प्रधानमंत्री गरीब कल्याण अन्न योजना (PMGKAY)"),
            type = "central",
            category = "welfare",
            description = LocalizedText(en = "Food security scheme to provide free food grains to eligible beneficiaries under National Food Security Act and special relief measures.", te = "జాతీయ ఆహార భద్రత చట్టం మరియు ప్రత్యేక ఉపశమనం చర్యల కింద అర్హులైన లబ్ధిదారులకు ఉచిత ధాన్యాలు అందించే ఆహార భద్రత పథకం.", hi = "राष्ट्रीय खाद्य सुरक्षा अधिनियम और विशेष राहत उपायों के तहत पात्र लाभार्थियों को मुफ्त अनाज प्रदान करने वाली खाद्य सुरक्षा योजना।"),
            benefits = LocalizedText(en = "Free allocation of rice/wheat and other grains to eligible ration card holders as per scheme entitlements.", te = "పథక హక్కుల ప్రకారం అర్హ రేషన్ కార్డ్ హోల్డర్లకు ఉచితంగా బియ్యం/గోధుమ మరియు ఇతర ధాన్యాల కేటాయింపు.", hi = "योजना अधिकारों के अनुसार पात्र राशन कार्ड धारकों को चावल/गेहूँ और अन्य अनाज का मुफ्त आवंटन।"),
            eligibility = LocalizedText(en = "Households covered under NFSA and additional identified vulnerable households as per government notifications.", te = "NFSA కింద కవర్ అయిన కుటుంబాలు మరియు ప్రభుత్వ నోటిఫికేషన్ల ప్రకారం అదనపు గుర్తించిన బలహీన కుటుంబాలు.", hi = "NFSA के तहत कवर किए गए परिवार और सरकारी अधिसूचनाओं के अनुसार अतिरिक्त पहचाने गए कमजोर परिवार।"),
            applyProcess = LocalizedText(en = "Collect entitled food grains from designated Fair Price Shops (ration shops) using ration card and biometric/ID verification.", te = "రేషన్ కార్డ్ మరియు బయోమెట్రిక్/ID ధృవీకరణ ఉపయోగించి నియమిత ఫెయిర్ ప్రైస్ షాప్స్ నుండి ధాన్యాలు తీసుకోండి.", hi = "राशन कार्ड और बायोमेट्रिक/पहचान सत्यापन का उपयोग करके नामित फेयर प्राइस शॉप से अनाज प्राप्त करें।")
        ),
        Scheme(
            id = "schm-37",
            title = LocalizedText(en = "Pradhan Mantri Awas Yojana (Urban and Gramin)", te = "ప్రధాన్ మంత్రి ఆవాస్ యోజన (అర్బన్ & గ్రామీణ)", hi = "प्रधानमंत्री आवास योजना (शहरी और ग्रामीण)"),
            type = "central",
            category = "welfare",
            description = LocalizedText(en = "Mission to provide affordable housing to eligible urban and rural poor through subsidies, credit-linked support and beneficiary-led construction.", te = "సబ్సిడీలు, క్రెడిట్-లింక్డ్ మద్దతు మరియు లబ్ధిదారుల ఆధ్వర్య నిర్మాణం ద్వారా అర్హమైన పట్టణ మరియు గ్రామీణ పేదలకు సులభమైన గృహాలను అందించే మిషన్.", hi = "सब्सिडी, क्रेडिट-लिंक्ड सहायता और लाभार्थी-नेतृत्व वाली निर्माण के माध्यम से पात्र शहरी और ग्रामीण गरीबों को किफायती आवास प्रदान करने का मिशन।"),
            benefits = LocalizedText(en = "Interest subsidy, direct financial assistance for construction/augmentation, and support for slum rehabilitation under specified components.", te = "వడ్డీ సబ్సిడీ, నిర్మాణ/విస్తరణ కోసం ప్రత్యక్ష ఆర్థిక సహాయం మరియు నిర్దిష్ట భాగాల కింద స్లమ్ పునర్వాసానికి మద్దతు.", hi = "ब्याज सब्सिडी, निर्माण/विस्तार के लिए प्रत्यक्ष वित्तीय सहायता और निर्दिष्ट घटकों के तहत स्लम पुनर्वास के लिए समर्थन।"),
            eligibility = LocalizedText(en = "Urban and rural poor households meeting income, land and beneficiary criteria as per PMAY (Urban/Gramin) guidelines.", te = "PMAY (అర్బన్/గ్రామీణ) మార్గదర్శకాలకు అనుగుణంగా ఆదాయ, భూమి మరియు లబ్ధిదారు ప్రమాణాలు తీరిన కుటుంబాలు.", hi = "PMAY (शहरी/ग्रामीण) दिशानिर्देशों के अनुसार आय, भूमि और लाभार्थी मानदंडों को पूरा करने वाले परिवार।"),
            applyProcess = LocalizedText(en = "Apply via PMAY portal, local urban bodies or Gram Panchayat with required documents; subsidy/assistance processed after verification.", te = "PMAY పోర్టల్, స్థానిక అర్బన్ బాడీస్ లేదా గ్రామ పంచాయతీ ద్వారా అవసరమైన పత్రాలతో దరఖాస్తు చేయండి; ధృవీకరణ తర్వాత సబ్సిడీ/సహాయం ప్రాసెస్ అవుతుంది.", hi = "PMAY पोर्टल, स्थानीय शहरी निकाय या ग्राम पंचायत के माध्यम से आवश्यक दस्तावेज़ों के साथ आवेदन करें; सत्यापन के बाद सब्सिडी/सहायता प्रोसेस की जाती है।")
        ),
        Scheme(
            id = "schm-38",
            title = LocalizedText(en = "Jal Jeevan Mission", te = "జల్ జీవన్ మిషన్", hi = "जल जीवन मिशन"),
            type = "central",
            category = "welfare",
            description = LocalizedText(en = "Nationwide mission to provide safe and adequate drinking water through individual household tap connections by 2024 (ongoing operations and maintenance).", te = "వ్యక్తిగత గృహ ట్యాప్ కనెక్షన్ల ద్వారా సురక్షిత మరియు తగిన తాగునీటిని అందించడానికి జాతీయ మిషన్ (ఆపరేషన్లు మరియు నిర్వహణ కొనసాగుతున్నాయి).", hi = "व्यक्तिगत घरेलू नल कनेक्शन के माध्यम से सुरक्षित और पर्याप्त पेयजल प्रदान करने के लिए राष्ट्रीय मिशन (ऑपरेशन और रखरखाव जारी)।"),
            benefits = LocalizedText(en = "Household tap connections, community water supply infrastructure, and support for water quality monitoring and O&M.", te = "గృహ ట్యాప్ కనెక్షన్లు, కమ్యూనిటీ వాటర్ సప్లై ఇన్‌ఫ్రాస్ట్రక్చర్ మరియు నీటి నాణ్యత పర్యవేక్షణకు మద్దతు.", hi = "घरेलू नल कनेक्शन, सामुदायिक जल आपूर्ति अवसंरचना और जल गुणवत्ता निगरानी व O&M के लिए समर्थन।"),
            eligibility = LocalizedText(en = "All rural households; urban components handled under separate urban water supply programmes where applicable.", te = "అన్ని గ్రామీణ గృహాలు; పట్టణ భాగాలు అవసరమైతే వేరు పట్టణ జల సరఫరా కార్యక్రమాల ద్వారా నిర్వహించబడతాయి.", hi = "सभी ग्रामीण परिवार; शहरी घटक लागू होने पर अलग शहरी जल आपूर्ति कार्यक्रमों के तहत संभाले जाते हैं।"),
            applyProcess = LocalizedText(en = "Register household with Gram Panchayat or state portal; installation and O&M coordinated by local water supply agencies.", te = "గ్రామ పంచాయతీ లేదా రాష్ట్ర పోర్టల్‌లో గృహాన్ని నమోదు చేయండి; ఇన్‌స్టాలేషన్ మరియు O&M స్థానిక వాటర్ ఏజెన్సీలు సమన్వయం చేస్తాయి.", hi = "ग्राम पंचायत या राज्य पोर्टल पर घर का पंजीकरण करें; स्थापना और O&M स्थानीय जल आपूर्ति एजेंसियों द्वारा समन्वित।")
        ),
        Scheme(
            id = "schm-39",
            title = LocalizedText(en = "Pradhan Mantri Jan Dhan Yojana (PMJDY)", te = "ప్రధాన్ మంత్రి జన ధన్ యోజన (PMJDY)", hi = "प्रधानमंत्री जन धन योजना (PMJDY)"),
            type = "central",
            category = "welfare",
            description = LocalizedText(en = "Financial inclusion programme to ensure access to banking services, basic savings accounts, and financial products for all households.", te = "ప్రతి కుటుంబానికి బ్యాంకింగ్ సేవలు, ప్రాథమిక పొదుపు ఖాతాలు మరియు ఆర్థిక ఉత్పత్తులకు యాక్సెస్ కల్పించే ఆర్థిక సమగ్రత కార్యక్రమం.", hi = "सभी परिवारों के लिए बैंकिंग सेवाओं, बुनियादी बचत खाते और वित्तीय उत्पादों तक पहुँच सुनिश्चित करने वाला वित्तीय समावेशन कार्यक्रम।"),
            benefits = LocalizedText(en = "Zero-balance accounts, RuPay debit card, accidental insurance cover, overdraft facility and access to credit/insurance products.", te = "జీరో-బ్యాలెన్స్ ఖాతాలు, RuPay డెబిట్ కార్డ్, ప్రమాద బీమా కవర్, ఓవర్‌డ్రాఫ్ట్ సౌకర్యం మరియు క్రెడిట్/బీమా ఉత్పత్తులకు యాక్సెస్.", hi = "शून्य-बैलेंस खाते, RuPay डेबिट कार्ड, दुर्घटना बीमा कवरेज, ओवरड्राफ्ट सुविधा और क्रेडिट/बीमा उत्पादों तक पहुँच।"),
            eligibility = LocalizedText(en = "All individuals without a bank account; priority given to poor, women, and excluded groups as per outreach drives.", te = "బ్యాంక్ ఖాతా లేని అన్ని వ్యక్తులు; పేదలు, మహిళలు మరియు బహిష్కృత వర్గాలకు ప్రాధాన్యం.", hi = "बिना बैंक खाते वाले सभी व्यक्ति; आउटरीच अभियानों के अनुसार गरीबों, महिलाओं और बहिष्कृत समूहों को प्राथमिकता।"),
            applyProcess = LocalizedText(en = "Open account at bank branch or through BC/CSC with Aadhaar/KYC; receive RuPay card and register for mobile banking/DBT.", te = "బ్యాంక్ శాఖ లేదా BC/CSC ద్వారా ఆధార్/KYCతో ఖాతా తెరవండి; RuPay కార్డ్ పొందండి మరియు మొబైల్ బ్యాంకింగ్/DBT కోసం నమోదు చేయండి.", hi = "बैंक शाखा या BC/CSC के माध्यम से आधार/KYC के साथ खाता खोलें; RuPay कार्ड प्राप्त करें और मोबाइल बैंकिंग/DBT के लिए पंजीकरण करें।")
        ),
        Scheme(
            id = "schm-40",
            title = LocalizedText(en = "Atal Pension Yojana (APY)", te = "అటల్ పెన్షన్ యోజన (APY)", hi = "अटल पेंशन योजना (APY)"),
            type = "central",
            category = "welfare",
            description = LocalizedText(en = "Government-backed pension scheme to provide defined pension benefits to unorganised sector workers on attaining retirement age.", te = "పెన్షన్ వయస్సు చేరినప్పుడు అసంఘటిత రంగ కార్మికులకు నిర్వచిత పెన్షన్ లాభాలు అందించే ప్రభుత్వ మద్దతు పథకం.", hi = "सेवानिवृत्ति आयु प्राप्त करने पर असंगठित क्षेत्र के कामगारों को परिभाषित पेंशन लाभ प्रदान करने वाली सरकारी समर्थित पेंशन योजना।"),
            benefits = LocalizedText(en = "Guaranteed monthly pension ranging by contribution level after 60 years; spouse and nominee benefits on death.", te = "60 సంవత్సరాల తర్వాత కాంట్రిబ్యూషన్ స్థాయికి అనుగుణంగా గ్యారంటీ నెలవారీ పెన్షన్; మరణం సందర్భంలో భార్య/నామినీ లాభాలు.", hi = "योगदान स्तर के अनुसार 60 वर्ष के बाद गारंटीकृत मासिक पेंशन; मृत्यु पर पत्नी/नामांकित को लाभ।"),
            eligibility = LocalizedText(en = "Workers in unorganised sector aged 18–40 years at entry, with a savings bank account and Aadhaar for auto-debit.", te = "ప్రవేశ సమయంలో 18–40 సంవత్సరాల వయస్సు ఉన్న అసంఘటిత రంగ కార్మికులు, సేవింగ్స్ బ్యాంక్ ఖాతా మరియు ఆటో-డెబిట్ కోసం ఆధార్ అవసరం.", hi = "प्रवेश के समय 18–40 वर्ष आयु के असंगठित क्षेत्र के कामगार, बचत बैंक खाता और ऑटो-डेबिट के लिए आधार आवश्यक।"),
            applyProcess = LocalizedText(en = "Enroll through bank/post office or APY portal with KYC and Aadhaar; choose contribution slab and start auto-debit.", te = "బ్యాంక్/పోస్ట్ ఆఫీస్ లేదా APY పోర్టల్ ద్వారా KYC మరియు ఆధార్‌తో నమోదు చేయండి; కాంట్రిబ్యూషన్ స్లాబ్ ఎంచుకుని ఆటో-డెబిట్ ప్రారంభించండి.", hi = "बैंक/डाकघर या APY पोर्टल के माध्यम से KYC और आधार के साथ नामांकन करें; योगदान स्लैब चुनें और ऑटो-डेबिट शुरू करें।")
        ),
        Scheme(
            id = "schm-41",
            title = LocalizedText(en = "National Food Security Act (NFSA)", te = "నేషనల్ ఫుడ్ సెక్యూరిటీ చట్టం (NFSA)", hi = "राष्ट्रीय खाद्य सुरक्षा अधिनियम (NFSA)"),
            type = "central",
            category = "welfare",
            description = LocalizedText(en = "Legislative framework ensuring subsidised food grains to eligible households to ensure food security.", te = "అర్హ కుటుంబాలకు సబ్సిడీ ధాన్యాలు అందించే ద్వారా ఆహార భద్రతను నిర్ధారించే చట్టపరమైన ఫ్రేమ్‌వర్క్.", hi = "पात्र परिवारों को सब्सिडी वाले अनाज सुनिश्चित करके खाद्य सुरक्षा सुनिश्चित करने वाला विधायी ढांचा।"),
            benefits = LocalizedText(en = "Entitlement of subsidised rice/wheat and other grains to priority and Antyodaya households as per entitlements.", te = "ప్రాధాన్యత మరియు అంత్యోదయ కుటుంబాలకు హక్కుల ప్రకారం సబ్సిడీ ధాన్యాల హక్కు.", hi = "प्राथमिकता और अंत्योदय परिवारों को उनके अधिकारों के अनुसार सब्सिडी वाले अनाज का अधिकार।"),
            eligibility = LocalizedText(en = "Households identified under NFSA lists (priority households and Antyodaya Anna Yojana beneficiaries) as per state/central lists.", te = "రాష్ట్ర/కేంద్ర జాబితాల ప్రకారం NFSA కింద గుర్తించిన కుటుంబాలు (ప్రాధాన్యత కుటుంబాలు మరియు అంత్యోదయ లబ్ధిదారులు).", hi = "राज्य/केंद्र सूची के अनुसार NFSA के तहत पहचाने गए परिवार (प्राथमिकता परिवार और अंत्योदय लाभार्थी)।"),
            applyProcess = LocalizedText(en = "Obtain ration card from local authority; collect entitled grains from Fair Price Shops using card and biometric/ID verification.", te = "స్థానిక అధికారుల నుండి రేషన్ కార్డ్ పొందండి; కార్డ్ మరియు బయోమెట్రిక్/ID ధృవీకరణతో ఫెయిర్ ప్రైస్ షాప్స్ నుండి ధాన్యాలు తీసుకోండి.", hi = "स्थानीय प्राधिकरण से राशन कार्ड प्राप्त करें; कार्ड और बायोमेट्रिक/पहचान सत्यापन का उपयोग करके फेयर प्राइस शॉप से अनाज प्राप्त करें।")
        ),
        Scheme(
            id = "schm-42",
            title = LocalizedText(en = "Swachh Bharat Mission", te = "స్వచ్ఛ్ భారత్ మిషన్", hi = "स्वच्छ भारत मिशन"),
            type = "central",
            category = "welfare",
            description = LocalizedText(en = "Nationwide campaign to improve sanitation, eliminate open defecation and promote solid waste management.", te = "స్వచ్ఛతను మెరుగుపరచడానికి, ఓపెన్ డిఫికేషన్‌ను నిర్మూలించడానికి మరియు ఘన వ్యర్థ నిర్వహణను ప్రోత్సహించడానికి జాతీయ ప్రచారం.", hi = "स्वच्छता में सुधार, खुले में शौच उन्मूलन और ठोस अपशिष्ट प्रबंधन को बढ़ावा देने के लिए राष्ट्रीय अभियान।"),
            benefits = LocalizedText(en = "Construction of household and community toilets, behaviour change campaigns, and support for waste collection and processing.", te = "గృహ మరియు కమ్యూనిటీ టాయిలెట్లు నిర్మాణం, ప్రవర్తన మార్పు ప్రచారాలు మరియు వ్యర్థ సేకరణ/ప్రాసెసింగ్‌కు మద్దతు.", hi = "घरेलू और सामुदायिक शौचालयों का निर्माण, व्यवहार परिवर्तन अभियान और कचरा संग्रह व प्रसंस्करण के लिए समर्थन।"),
            eligibility = LocalizedText(en = "All households and communities; specific subsidies or support depend on state/urban local body implementation rules.", te = "అన్ని గృహాలు మరియు కమ్యూనిటీలకు; నిర్దిష్ట సబ్సిడీలు రాష్ట్ర/పట్టణ స్థానిక సంస్థల అమలుపై ఆధారపడి ఉంటాయి.", hi = "सभी परिवार और समुदाय; विशिष्ट सब्सिडी या सहायता राज्य/शहरी स्थानीय निकाय के कार्यान्वयन नियमों पर निर्भर करती है।"),
            applyProcess = LocalizedText(en = "Contact local ULB/Gram Panchayat or sanitation department for toilet construction subsidies and community sanitation programmes.", te = "టాయిలెట్ నిర్మాణ సబ్సిడీలు మరియు కమ్యూనిటీ శానిటేషన్ కార్యక్రమాల కోసం స్థానిక ULB/గ్రామ పంచాయతీ లేదా శానిటేషన్ శాఖను సంప్రదించండి.", hi = "शौचालय निर्माण सब्सिडी और सामुदायिक स्वच्छता कार्यक्रमों के लिए स्थानीय ULB/ग्राम पंचायत या स्वच्छता विभाग से संपर्क करें।")
        ),
        Scheme(
            id = "po-schm-1",
            title = LocalizedText(en = "Post Office Savings Account", te = "పోస్ట్ ఆఫీస్ సేవింగ్స్ ఖాతా", hi = "पोस्ट ऑफिस सेविंग्स खाता"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Basic savings bank account offered at post offices across India with deposit, withdrawal and remittance facilities.", te = "భారతదేశంలోని పోస్టాఫీసులలో అందించే ప్రాథమిక సేవింగ్స్ బ్యాంక్ ఖాతా; జమ, ఉపసంహరణ మరియు రిమిట్ సౌకర్యాలు కలిగి ఉంటుంది.", hi = "भारत भर के पोस्ट ऑफिस में उपलब्ध बुनियादी बचत बैंक खाता जिसमें जमा, निकासी और रेमिटेंस सुविधाएँ हैं।"),
            benefits = LocalizedText(en = "Low minimum balance requirements, interest on deposits, cheque facility at select offices, easy remittances and wide accessibility in rural areas.", te = "తక్కువ కనిష్ట బ్యాలెన్స్ అవసరాలు, జమలపై వడ్డీ, కొన్ని కార్యాలయాల్లో చెక్ సౌకర్యం, సులభ రిమిటెన్స్‌లు మరియు గ్రామీణ ప్రాంతాల్లో విస్తృత ప్రాప్యత.", hi = "कम न्यूनतम शेष राशि आवश्यकताएँ, जमा पर ब्याज, चुनिंदा कार्यालयों में चेक सुविधा, आसान रेमिटेंस और ग्रामीण क्षेत्रों में व्यापक पहुँच।"),
            eligibility = LocalizedText(en = "Any resident individual (adult) or minor (with guardian) can open an account; KYC and identity proof required.", te = "ఏదైనా నివాసి వ్యక్తి (వయస్కుడు) లేదా చిన్నారి (గార్డియన్‌తో) ఖాతా తెరవవచ్చు; KYC మరియు గుర్తింపు పత్రాలు అవసరం.", hi = "कोई भी निवासी व्यक्ति (वयस्क) या नाबालिग (अभिभावक के साथ) खाता खोल सकता है; KYC और पहचान प्रमाण आवश्यक।"),
            applyProcess = LocalizedText(en = "Visit nearest post office with ID, address proof and passport-size photos; fill account opening form and complete KYC; initial deposit as per office rules.", te = "సమీప పోస్టాఫీస్‌కు ID, చిరునామా సాక్ష్యం మరియు పాస్‌పోర్ట్ సైజు ఫోటోలతో వెళ్లి ఖాతా తెరవడానికి ఫారమ్ పూరించండి; KYC పూర్తి చేయండి; ప్రారంభ జమ చేయండి.", hi = "निकटतम पोस्ट ऑफिस में पहचान, पता प्रमाण और पासपोर्ट साइज फोटो लेकर जाएँ; खाता खोलने का फॉर्म भरें और KYC पूरा करें; प्रारंभिक जमा कार्यालय नियमों के अनुसार।")
        ),
        Scheme(
            id = "po-schm-2",
            title = LocalizedText(en = "Monthly Income Scheme (MIS)", te = "మంత్లీ ఇన్కమ్ స్కీమ్ (MIS)", hi = "मंथली इनकम स्कीम (MIS)"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Small‑saver scheme providing guaranteed monthly income through interest payouts on a fixed deposit with the post office.", te = "పోస్ట్ ఆఫీస్‌లో స్థిర జమపై వడ్డీ చెల్లింపుల ద్వారా గ్యారంటీ చేయబడిన నెలవారీ ఆదాయాన్ని అందించే చిన్న పొదుపుదారుల పథకం.", hi = "पोस्ट ऑफिस में फिक्स्ड डिपॉज़िट पर ब्याज भुगतान के माध्यम से सुनिश्चित मासिक आय प्रदान करने वाली लघु-निवेशक योजना।"),
            benefits = LocalizedText(en = "Monthly interest payout credited to account or paid via cheque; capital protection and government backing.", te = "నెలవారీ వడ్డీ చెల్లింపు ఖాతాకు జమ లేదా చెక్ ద్వారా చెల్లించబడుతుంది; మూలధన రక్షణ మరియు ప్రభుత్వ మద్దతు.", hi = "मासिक ब्याज भुगतान खाते में जमा या चेक द्वारा दिया जाता है; पूंजी सुरक्षा और सरकारी समर्थन।"),
            eligibility = LocalizedText(en = "Resident individuals, joint accounts and minors (with guardian) can invest; single account limits and maximum deposit per individual apply.", te = "నివాసి వ్యక్తులు, సంయుక్త ఖాతాలు మరియు చిన్నారులు (గార్డియన్‌తో) పెట్టుబడి పెట్టవచ్చు; వ్యక్తిగత పరిమితులు వర్తిస్తాయి.", hi = "निवासी व्यक्ति, संयुक्त खाते और नाबालिग (अभिभावक के साथ) निवेश कर सकते हैं; व्यक्तिगत सीमाएँ लागू।"),
            applyProcess = LocalizedText(en = "Open MIS account at post office by filling application and depositing lump sum; provide KYC documents; choose monthly payout mode.", te = "పోస్ట్ ఆఫీస్‌లో దరఖాస్తు పూరించి ఒకేసారి జమ చేయడం ద్వారా MIS ఖాతా తెరవండి; KYC పత్రాలు ఇవ్వండి; నెలవారీ చెల్లింపు విధానాన్ని ఎంచుకోండి.", hi = "पोस्ट ऑफिस में आवेदन भरकर और एकमुश्त जमा करके MIS खाता खोलें; KYC दस्तावेज़ प्रस्तुत करें; मासिक भुगतान मोड चुनें।")
        ),
        Scheme(
            id = "po-schm-3",
            title = LocalizedText(en = "Recurring Deposit (RD) — Post Office", te = "రెకరింగ్ డిపాజిట్ (RD) — పోస్టాఫీస్", hi = "रिकरिंग डिपॉज़िट (RD) — पोस्ट ऑफिस"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Monthly deposit scheme where subscribers deposit a fixed amount each month for a chosen tenure and receive maturity amount with interest.", te = "సబ్‌స్క్రైబర్లు ప్రతి నెలా ఒక నిర్దిష్ట మొత్తాన్ని నిర్ణీత వ్యవధి పాటు జమ చేయడం ద్వారా పరిపక్వతలో వడ్డీతో మొత్తం పొందే పథకం.", hi = "सदस्य हर महीने एक निश्चित राशि जमा करते हैं और चुनी गई अवधि के बाद परिपक्वता राशि ब्याज सहित प्राप्त करते हैं।"),
            benefits = LocalizedText(en = "Disciplined savings, guaranteed returns at post office RD rates, and flexible tenures; government-backed security.", te = "శ్రద్ధగా పొదుపు, పోస్టాఫీస్ RD రేట్లపై గ్యారంటీ రిటర్న్స్, మరియు అనుకూల వ్యవధులు; ప్రభుత్వ మద్దతు.", hi = "अनुशासित बचत, पोस्ट ऑफिस RD दरों पर सुनिश्चित रिटर्न और लचीली अवधि; सरकारी समर्थन।"),
            eligibility = LocalizedText(en = "Any resident individual or guardian for minors; single account per individual per post office rules unless otherwise allowed.", te = "ఏదైనా నివాసి వ్యక్తి లేదా చిన్నారుల కోసం గార్డియన్; పోస్టాఫీస్ నిబంధనల ప్రకారం ఖాతా పరిమితులు వర్తిస్తాయి.", hi = "कोई भी निवासी व्यक्ति या नाबालिग के लिए अभिभावक; पोस्ट ऑफिस नियमों के अनुसार खाते की सीमाएँ लागू।"),
            applyProcess = LocalizedText(en = "Submit RD application at post office, choose monthly deposit amount and tenure, complete KYC and start monthly deposits.", te = "RD దరఖాస్తును పోస్టాఫీస్‌లో సమర్పించి, నెలవారీ జమ మరియు వ్యవధి ఎంచుకుని KYC పూర్తి చేసి జమలు ప్రారంభించండి.", hi = "पोस्ट ऑफिस में RD आवेदन जमा करें, मासिक जमा राशि और अवधि चुनें, KYC पूरा करें और मासिक जमा शुरू करें।")
        ),
        Scheme(
            id = "po-schm-4",
            title = LocalizedText(en = "Time Deposit (Fixed Deposit) — Post Office", te = "టైమ్ డిపాజిట్ (ఫిక్స్డ్ డిపాజిట్) — పోస్టాఫీస్", hi = "टाइम डिपॉज़िट (फिक्स्ड डिपॉज़िट) — पोस्ट ऑफिस"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Fixed deposit scheme with multiple tenure options offering fixed interest rates and government security.", te = "వివిధ వ్యవధి ఎంపికలతో స్థిర వడ్డీ రేట్లు మరియు ప్రభుత్వ భద్రత కలిగిన ఫిక్స్డ్ డిపాజిట్ పథకం.", hi = "विभिन्न अवधि विकल्पों के साथ निश्चित ब्याज दर और सरकारी सुरक्षा वाला फिक्स्ड डिपॉज़िट योजना।"),
            benefits = LocalizedText(en = "Higher interest rates for longer tenures, guaranteed returns, and option for premature withdrawal subject to rules.", te = "దీర్ఘకాలిక వ్యవధులకు అధిక వడ్డీ రేట్లు, గ్యారంటీ రిటర్న్స్ మరియు నియమాల ప్రకారం ముందస్తు ఉపసంహరణ ఎంపిక.", hi = "लंबी अवधि के लिए उच्च ब्याज दरें, सुनिश्चित रिटर्न और नियमों के अनुसार पूर्व निकासी विकल्प।"),
            eligibility = LocalizedText(en = "Resident individuals, HUFs and minors (through guardian) as per post office rules; limits on maximum deposit per account apply.", te = "నివాసి వ్యక్తులు, HUFలు మరియు చిన్నారులు (గార్డియన్ ద్వారా) పోస్టాఫీస్ నిబంధనల ప్రకారం.", hi = "निवासी व्यक्ति, HUF और नाबालिग (अभिभावक के माध्यम से) पोस्ट ऑफिस नियमों के अनुसार।"),
            applyProcess = LocalizedText(en = "Fill time deposit form at post office, deposit lump sum for chosen tenure, provide KYC and receive deposit receipt; interest paid on maturity or per chosen payout mode.", te = "పోస్ట్ ఆఫీస్‌లో ఫారమ్ పూరించి ఒకేసారి జమ చేయండి, KYC ఇవ్వండి మరియు రసీదు పొందండి; వడ్డీ పరిపక్వతలో చెల్లించబడుతుంది.", hi = "पोस्ट ऑफिस में फॉर्म भरें, चुनी गई अवधि के लिए एकमुश्त जमा करें, KYC प्रस्तुत करें और रसीद प्राप्त करें; ब्याज परिपक्वता पर दिया जाता है।")
        ),
        Scheme(
            id = "po-schm-5",
            title = LocalizedText(en = "Public Provident Fund (PPF) — Post Office", te = "పబ్లిక్ ప్రావిడెంట్ ఫండ్ (PPF) — పోస్టాఫీస్", hi = "पब्लिक प्रोविडेंट फंड (PPF) — पोस्ट ऑफिस"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Long‑term small‑saver scheme with tax benefits, encouraging retirement savings through a 15‑year lock‑in (extendable).", te = "పన్ను ప్రయోజనాలతో దీర్ఘకాలిక పొదుపు పథకం; 15 సంవత్సరాల లాక్‑ఇన్ ద్వారా రిటైర్మెంట్ పొదుపును ప్రోత్సహిస్తుంది (విస్తరించవచ్చు).", hi = "कर लाभ के साथ दीर्घकालिक लघु-निवेशक योजना, 15 वर्ष की लॉक‑इन अवधि (विस्तारित करने योग्य) के साथ सेवानिवृत्ति बचत को प्रोत्साहित करती है।"),
            benefits = LocalizedText(en = "Tax‑free interest, tax deduction on contributions under Section 80C, government guarantee and safe returns.", te = "పన్ను‑రహిత వడ్డీ, సెక్షన్ 80C కింద విరాళాలపై పన్ను రాయితీ, ప్రభుత్వ గ్యారెంటీ మరియు భద్రతా రిటర్న్స్.", hi = "कर-मुक्त ब्याज, धारा 80C के तहत योगदान पर कर कटौती, सरकारी गारंटी और सुरक्षित रिटर्न।"),
            eligibility = LocalizedText(en = "Resident individuals only; single account per individual; minor accounts via guardian allowed as per rules.", te = "కేవలం నివాసి వ్యక్తులకు మాత్రమే; ఒక్కో వ్యక్తికి ఒకే ఖాతా; చిన్నారుల ఖాతాలు గార్డియన్ ద్వారా అనుమతించబడతాయి.", hi = "केवल निवासी व्यक्ति; प्रत्येक व्यक्ति के लिए एक खाता; नाबालिग खातों के लिए अभिभावक के माध्यम से अनुमति।"),
            applyProcess = LocalizedText(en = "Open PPF account at post office with KYC, initial deposit; maintain minimum annual contribution; follow extension/withdrawal rules at maturity.", te = "KYCతో PPF ఖాతా తెరవండి, ప్రారంభ జమ చేయండి; కనీస వార్షిక విరాళం పాటించండి; పరిపక్వతలో విస్తరణ/విత్‌డ్రా నియమాలు అనుసరించండి.", hi = "पोस्ट ऑफिस में KYC के साथ PPF खाता खोलें, प्रारंभिक जमा करें; न्यूनतम वार्षिक योगदान बनाए रखें; परिपक्वता पर विस्तार/निकासी नियमों का पालन करें।")
        ),
        Scheme(
            id = "po-schm-6",
            title = LocalizedText(en = "National Savings Certificate (NSC)", te = "నేషనల్ సేవింగ్స్ సర్టిఫికెట్ (NSC)", hi = "नेशनल सेविंग्स सर्टिफिकेट (NSC)"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Fixed‑income investment instrument with a fixed tenure and guaranteed returns, popular for small savers and tax planning.", te = "నిర్దిష్ట వ్యవధి మరియు గ్యారంటీ రిటర్న్స్ కలిగిన ఫిక్స్డ్‑ఇన్కమ్ పెట్టుబడి పరికరం; చిన్న పొదుపుదారులకు మరియు పన్ను ప్రణాళికకు ప్రసిద్ధి.", hi = "निश्चित अवधि और सुनिश्चित रिटर्न वाला फिक्स्ड-इनकम निवेश उपकरण, लघु-निवेशकों और कर योजना के लिए लोकप्रिय।"),
            benefits = LocalizedText(en = "Guaranteed returns, tax benefits under Section 80C (subject to prevailing rules), and government backing.", te = "గ్యారంటీ రిటర్న్స్, సెక్షన్ 80C కింద పన్ను ప్రయోజనాలు (ప్రచలిత నిబంధనల ప్రకారం) మరియు ప్రభుత్వ మద్దతు.", hi = "गारंटीकृत रिटर्न, धारा 80C के तहत कर लाभ (प्रचलित नियमों के अनुसार) और सरकारी समर्थन।"),
            eligibility = LocalizedText(en = "Resident individuals, HUFs and minors (through guardian) as per post office rules; single or joint holdings allowed where specified.", te = "నివాసి వ్యక్తులు, HUFలు మరియు చిన్నారులు (గార్డియన్ ద్వారా) పోస్టాఫీస్ నిబంధనల ప్రకారం.", hi = "निवासी व्यक्ति, HUF और नाबालिग (अभिभावक के माध्यम से) पोस्ट ऑफिस नियमों के अनुसार।"),
            applyProcess = LocalizedText(en = "Purchase NSC at post office by filling application and paying lump sum; obtain certificate and retain for maturity claim; KYC required.", te = "పోస్ట్ ఆఫీస్‌లో దరఖాస్తు పూరించి ఒకేసారి చెల్లించి NSC కొనండి; సర్టిఫికెట్ పొందండి; KYC అవసరం.", hi = "पोस्ट ऑफिस में आवेदन भरकर और एकमुश्त भुगतान करके NSC खरीदें; प्रमाणपत्र प्राप्त करें; KYC आवश्यक।")
        ),
        Scheme(
            id = "po-schm-7",
            title = LocalizedText(en = "Kisan Vikas Patra (KVP)", te = "కిసాన్ వికాస్ పత్రం (KVP)", hi = "किसान विकास पत्र (KVP)"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Small‑saver certificate that doubles investment over a pre‑defined period; safe government-backed instrument available at post offices.", te = "నిర్దిష్ట కాలంలో పెట్టుబడిని రెట్టింపు చేసే చిన్న పొదుపు సర్టిఫికెట్; పోస్టాఫీసుల్లో అందుబాటులో ఉన్న ప్రభుత్వ మద్దతు పరికరం.", hi = "निश्चित अवधि में निवेश को दोगुना करने वाला लघु-निवेशक प्रमाणपत्र; पोस्ट ऑफिस में उपलब्ध सरकारी समर्थित उपकरण।"),
            benefits = LocalizedText(en = "Guaranteed maturity value (doubling as per tenure), easy purchase and encashment at post offices, and government guarantee.", te = "పరిపక్వత విలువ గ్యారంటీ, పోస్టాఫీసుల్లో సులభంగా కొనుగోలు/నగదు చేయడం మరియు ప్రభుత్వ గ్యారెంటీ.", hi = "परिपक्वता मूल्य की गारंटी, पोस्ट ऑफिस में आसान खरीद और नकदीकरण, और सरकारी गारंटी।"),
            eligibility = LocalizedText(en = "Resident individuals, HUFs and minors (via guardian) as per post office rules; single or joint holdings allowed where specified.", te = "నివాసి వ్యక్తులు, HUFలు మరియు చిన్నారులు (గార్డియన్ ద్వారా) పోస్టాఫీస్ నిబంధనల ప్రకారం.", hi = "निवासी व्यक्ति, HUF और नाबालिग (अभिभावक के माध्यम से) पोस्ट ऑफिस नियमों के अनुसार।"),
            applyProcess = LocalizedText(en = "Buy KVP certificate at post office by paying required amount; retain certificate for maturity encashment; KYC and ID proof required.", te = "పోస్ట్ ఆఫీస్‌లో అవసరమైన మొత్తాన్ని చెల్లించి KVP కొనండి; పరిపక్వతలో నగదు కోసం సర్టిఫికెట్ ఉంచండి; KYC అవసరం.", hi = "पोस्ट ऑफिस में आवश्यक राशि देकर KVP प्रमाणपत्र खरीदें; परिपक्वता पर नकदीकरण के लिए प्रमाणपत्र रखें; KYC आवश्यक।")
        ),
        Scheme(
            id = "po-schm-8",
            title = LocalizedText(en = "Sukanya Samriddhi Account (Post Office)", te = "సుకన్య సమృద్ధి ఖాతా (పోస్ట్ ఆఫీస్)", hi = "सुकन्या समृद्धि खाता (पोस्ट ऑफिस)"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Small‑saver scheme for girl child with high interest and tax benefits, available at post offices as a preferred channel.", te = "బాలికల కోసం అధిక వడ్డీ మరియు పన్ను ప్రయోజనాలతో చిన్న పొదుపు పథకం; పోస్టాఫీస్‌లో అందుబాటులో ఉంటుంది.", hi = "लड़कियों के लिए उच्च ब्याज और कर लाभ वाली लघु-निवेशक योजना, पोस्ट ऑफिस में उपलब्ध।"),
            benefits = LocalizedText(en = "Attractive interest rate, tax benefits under Section 80C, long‑term lock‑in and maturity payout for girl beneficiary.", te = "ఆకర్షక వడ్డీ రేటు, సెక్షన్ 80C కింద పన్ను ప్రయోజనాలు, దీర్ఘకాలిక లాక్‑ఇన్ మరియు పరిపక్వత చెల్లింపు.", hi = "आकर्षक ब्याज दर, धारा 80C के तहत कर लाभ, दीर्घकालिक लॉक‑इन और परिपक्वता भुगतान।"),
            eligibility = LocalizedText(en = "Account opened by parent/guardian in name of girl child (up to specified age); one account per girl as per rules.", te = "పేరెంట్/గార్డియన్ ద్వారా బాలిక పేరులో ఖాతా తెరవవచ్చు; ఒక్కో బాలికకు ఒకే ఖాతా.", hi = "माता/अभिभावक द्वारा लड़की के नाम पर खाता खोला जा सकता है; प्रत्येक लड़की के लिए एक खाता।"),
            applyProcess = LocalizedText(en = "Open Sukanya Samriddhi account at post office with birth certificate of girl, parent ID and initial deposit; follow contribution schedule until maturity.", te = "పోస్ట్ ఆఫీస్‌లో బాలిక జనన సర్టిఫికెట్, పేరెంట్ ID మరియు ప్రారంభ జమతో ఖాతా తెరవండి; పరిపక్వత వరకు విరాళాల షెడ్యూల్ పాటించండి.", hi = "पोस्ट ऑफिस में लड़की के जन्म प्रमाणपत्र, माता/अभिभावक की पहचान और प्रारंभिक जमा के साथ खाता खोलें; परिपक्वता तक योगदान अनुसूची का पालन करें।")
        ),
        Scheme(
            id = "po-schm-9",
            title = LocalizedText(en = "Senior Citizens Savings Scheme (SCSS) — Post Office", te = "సీనియర్ సిటిజన్స్ సేవింగ్స్ స్కీమ్ (SCSS) — పోస్టాఫీస్", hi = "सीनियर सिटिज़न्स सेविंग्स स्कीम (SCSS) — पोस्ट ऑफिस"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Government-backed savings scheme for senior citizens offering regular interest payouts and capital protection, available at post offices.", te = "వృద్ధులకు రెగ్యులర్ వడ్డీ చెల్లింపులు మరియు మూలధన రక్షణను అందించే ప్రభుత్వ మద్దతు పొదుపు పథకం; పోస్టాఫీస్‌లో అందుబాటులో ఉంటుంది.", hi = "वरिष्ठ नागरिकों के लिए नियमित ब्याज भुगतान और पूंजी सुरक्षा प्रदान करने वाली सरकारी समर्थित बचत योजना, पोस्ट ऑफिस में उपलब्ध।"),
            benefits = LocalizedText(en = "Quarterly interest payouts at prescribed rates, safety of capital and easy access through post office network.", te = "నిర్దిష్ట రేట్లపై త్రైమాసిక వడ్డీ చెల్లింపులు, మూలధన భద్రత మరియు పోస్టాఫీస్ నెట్‌వర్క్ ద్వారా సులభ ప్రాప్యత.", hi = "निर्धारित दरों पर त्रैमासिक ब्याज भुगतान, पूंजी सुरक्षा और पोस्ट ऑफिस नेटवर्क के माध्यम से आसान पहुँच।"),
            eligibility = LocalizedText(en = "Individuals aged 60 years and above (with relaxations for certain categories) as per scheme rules; KYC required.", te = "పథక నిబంధనల ప్రకారం 60 సంవత్సరాలు మరియు పై వయస్సు ఉన్న వ్యక్తులు (కొన్ని వర్గాలకు రాహిత్యాలు).", hi = "योजना नियमों के अनुसार 60 वर्ष और उससे अधिक आयु के व्यक्ति (कुछ वर्गों के लिए छूट)।"),
            applyProcess = LocalizedText(en = "Open SCSS account at post office with age proof and KYC; deposit as per limits and choose payout mode for quarterly interest.", te = "వయస్సు సాక్ష్యం మరియు KYCతో SCSS ఖాతా తెరవండి; పరిమితుల ప్రకారం జమ చేయండి మరియు త్రైమాసిక వడ్డీ కోసం చెల్లింపు విధానాన్ని ఎంచుకోండి.", hi = "आयु प्रमाण और KYC के साथ पोस्ट ऑफिस में SCSS खाता खोलें; सीमाओं के अनुसार जमा करें और त्रैमासिक ब्याज के लिए भुगतान मोड चुनें।")
        ),
        Scheme(
            id = "po-schm-10",
            title = LocalizedText(en = "Postal Life Insurance (PLI) and Rural Postal Life Insurance (RPLI)", te = "పోస్టల్ లైఫ్ ఇన్సూరెన్స్ (PLI) మరియు రూరల్ పోస్టల్ లైఫ్ ఇన్సూరెన్స్ (RPLI)", hi = "पोस्टल लाइफ इंश्योरेंस (PLI) और रूरल पोस्टल लाइफ इंश्योरेंस (RPLI)"),
            type = "postal",
            category = "postal_insurance",
            description = LocalizedText(en = "Life insurance products offered by India Post for government employees, rural populations and general public with varied plans and premium options.", te = "భారత పోస్టా ద్వారా ప్రభుత్వ ఉద్యోగులు, గ్రామీణ జనాభా మరియు ప్రజలకు వివిధ ప్లాన్లు మరియు ప్రీమియం ఎంపికలతో లైఫ్ ఇన్సూరెన్స్ ఉత్పత్తులు.", hi = "भारत पोस्ट द्वारा सरकारी कर्मचारियों, ग्रामीण आबादी और आम जनता के लिए विभिन्न योजनाओं और प्रीमियम विकल्पों के साथ जीवन बीमा उत्पाद।"),
            benefits = LocalizedText(en = "Wide range of plans (endowment, whole life, term), affordable premiums, bonuses on certain plans and claim settlement through post office network.", te = "వివిధ ప్లాన్లు (ఎండోమెంట్, హోల్ లైఫ్, టర్మ్), సరసమైన ప్రీమియమ్లు, కొన్ని ప్లాన్లపై బోనస్‌లు మరియు పోస్టాఫీస్ నెట్‌వర్క్ ద్వారా క్లెయిమ్ సెటిల్‌మెంట్.", hi = "विभिन्न योजनाएँ (एंडोमेंट, होल लाइफ, टर्म), किफायती प्रीमियम, कुछ योजनाओं पर बोनस और पोस्ट ऑफिस नेटवर्क के माध्यम से दावा निपटान।"),
            eligibility = LocalizedText(en = "Eligibility varies by plan; generally residents of India, government employees (for PLI) and rural residents (for RPLI) can apply subject to age and health criteria.", te = "పథకానికి అనుగుణంగా అర్హత మారుతుంది; సాధారణంగా భారత నివాసితులు, ప్రభుత్వ ఉద్యోగులు (PLI కోసం) మరియు గ్రామీణ నివాసితులు (RPLI కోసం) వయస్సు మరియు ఆరోగ్య ప్రమాణాల మేరకు దరఖాస్తు చేయవచ్చు.", hi = "योजना के अनुसार पात्रता भिन्न होती है; सामान्यतः भारत निवासी, सरकारी कर्मचारी (PLI के लिए) और ग्रामीण निवासी (RPLI के लिए) आयु और स्वास्थ्य मानदंडों के अधीन आवेदन कर सकते हैं।"),
            applyProcess = LocalizedText(en = "Visit post office insurance counter, choose plan, fill proposal form, submit KYC and medical details (if required) and pay initial premium.", te = "పోస్ట్ ఆఫీస్ ఇన్సూరెన్స్ కౌంటర్‌కు వెళ్లి ప్లాన్ ఎంచుకుని దరఖాస్తు ఫారమ్ పూరించి KYC మరియు వైద్య వివరాలు సమర్పించి ప్రాథమిక ప్రీమియం చెల్లించండి.", hi = "पोस्ट ऑफिस बीमा काउंटर पर जाएँ, योजना चुनें, प्रस्ताव फॉर्म भरें, KYC और चिकित्सा विवरण (यदि आवश्यक) जमा करें और प्रारंभिक प्रीमियम का भुगतान करें।")
        ),
        Scheme(
            id = "po-schm-11",
            title = LocalizedText(en = "India Post Payments Bank (IPPB) Services", te = "ఇండియా పోస్ట్ పేమెంట్స్ బ్యాంక్ (IPPB) సేవలు", hi = "इंडिया पोस्ट पेमेंट्स बैंक (IPPB) सेवाएँ"),
            type = "postal",
            category = "postal_financial",
            description = LocalizedText(en = "Banking services delivered through the postal network including savings accounts, remittances, bill payments, micro‑loans and digital banking via IPPB.", te = "పోస్టల్ నెట్‌వర్క్ ద్వారా అందించే బ్యాంకింగ్ సేవలు: సేవింగ్స్ ఖాతాలు, రిమిటెన్స్‌లు, బిల్ చెల్లింపులు, మైక్రో‑లోన్లు మరియు డిజిటల్ బ్యాంకింగ్.", hi = "डाक नेटवर्क के माध्यम से प्रदान की जाने वाली बैंकिंग सेवाएँ जिनमें बचत खाते, रेमिटेंस, बिल भुगतान, माइक्रो-लोन और डिजिटल बैंकिंग शामिल हैं।"),
            benefits = LocalizedText(en = "Doorstep banking, low‑cost remittances, interoperable digital payments, Aadhaar‑enabled services and financial inclusion in underserved areas.", te = "డోర్‌స్టెప్ బ్యాంకింగ్, తక్కువ ఖర్చు రిమిటెన్స్‌లు, ఇంటర్‌ఓపరబుల్ డిజిటల్ పేమెంట్స్, ఆధార్‑సహాయిత సేవలు మరియు సేవల లేని ప్రాంతాల్లో ఆర్థిక సమగ్రత.", hi = "डोरस्टेप बैंकिंग, कम लागत रेमिटेंस, इंटरऑपरेबल डिजिटल भुगतान, आधार-सक्षम सेवाएँ और अविकसित क्षेत्रों में वित्तीय समावेशन।"),
            eligibility = LocalizedText(en = "Any resident individual can open IPPB savings account; KYC and Aadhaar linking recommended for full service access.", te = "ఏదైనా నివాసి వ్యక్తి IPPB సేవింగ్స్ ఖాతా తెరవవచ్చు; పూర్తి సేవల కోసం KYC మరియు ఆధార్ లింకింగ్ సిఫార్సు.", hi = "कोई भी निवासी व्यक्ति IPPB बचत खाता खोल सकता है; पूर्ण सेवा के लिए KYC और आधार लिंकिंग की सिफारिश।"),
            applyProcess = LocalizedText(en = "Open IPPB account at post office or via IPPB app/portal with KYC and Aadhaar; avail services at post office counters or through digital channels.", te = "KYC మరియు ఆధార్‌తో పోస్టాఫీస్ లేదా IPPB యాప్/పోర్టల్ ద్వారా ఖాతా తెరవండి; పోస్టాఫీస్ కౌంటర్లలో లేదా డిజిటల్ చానల్స్ ద్వారా సేవలు పొందండి.", hi = "KYC और आधार के साथ पोस्ट ऑफिस या IPPB ऐप/पोर्टल के माध्यम से खाता खोलें; पोस्ट ऑफिस काउंटर या डिजिटल चैनलों के माध्यम से सेवाएँ प्राप्त करें।")
        ),
        Scheme(
            id = "po-schm-12",
            title = LocalizedText(en = "Speed Post and Registered Post Services", te = "స్పీడ్ పోస్ట్ మరియు రిజిస్టర్డ్ పోస్ట్ సేవలు", hi = "स्पीड पोस्ट और रजिस्टर्ड पोस्ट सेवाएँ"),
            type = "postal",
            category = "postal_service",
            description = LocalizedText(en = "Premium and secure mail services provided by India Post for fast delivery (Speed Post) and legally verifiable delivery (Registered Post).", te = "త్వరిత డెలివరీ (స్పీడ్ పోస్ట్) మరియు చట్టపరంగా ధృవీకరించదగిన డెలివరీ (రిజిస్టర్డ్ పోస్ట్) కోసం భారత పోస్టా అందించే ప్రీమియం మరియు భద్రతా మెయిల్ సేవలు.", hi = "तेज़ डिलीवरी (स्पीड पोस्ट) और कानूनी रूप से सत्यापनीय डिलीवरी (रजिस्टर्ड पोस्ट) के लिए इंडिया पोस्ट द्वारा प्रदान की जाने वाली प्रीमियम और सुरक्षित मेल सेवाएँ।"),
            benefits = LocalizedText(en = "Faster delivery timelines, tracking facilities, proof of delivery, insurance options for valuable consignments and nationwide reach.", te = "త్వరిత డెలివరీ, ట్రాకింగ్ సౌకర్యాలు, డెలివరీ సాక్ష్యం, విలువైన సరుకుల కోసం బీమా ఎంపికలు మరియు దేశవ్యాప్తంగా ప్రాప్యత.", hi = "तेज़ डिलीवरी समय, ट्रैकिंग सुविधाएँ, डिलीवरी का प्रमाण, मूल्यवान पार्सलों के लिए बीमा विकल्प और देशव्यापी पहुँच।"),
            eligibility = LocalizedText(en = "Available to all individuals and businesses for sending documents and parcels; charges vary by weight, speed and insurance.", te = "డాక్యుమెంట్లు మరియు పార్సెల్‌లు పంపడానికి అన్ని వ్యక్తులు మరియు వ్యాపారాలకు అందుబాటులో ఉంటాయి; ఛార్జీలు బరువు, వేగం మరియు బీమా ఆధారంగా మారుతాయి.", hi = "दस्तावेज़ और पार्सल भेजने के लिए सभी व्यक्तियों और व्यवसायों के लिए उपलब्ध; शुल्क वजन, गति और बीमा के अनुसार भिन्न होते हैं।"),
            applyProcess = LocalizedText(en = "Visit post office counter, fill consignment form, pay postage and optional insurance; obtain tracking number and retain receipt for claims.", te = "పోస్ట్ ఆఫీస్ కౌంటర్‌కు వెళ్లి కాన్సైన్‌మెంట్ ఫారమ్ పూరించి పోస్టేజ్ చెల్లించండి; ట్రాకింగ్ నంబర్ పొందండి.", hi = "पोस्ट ऑफिस काउंटर पर जाएँ, पार्सल फॉर्म भरें, पोस्टेज और वैकल्पिक बीमा का भुगतान करें; ट्रैकिंग नंबर प्राप्त करें और रसीद रखें।")
        )
    )
}
