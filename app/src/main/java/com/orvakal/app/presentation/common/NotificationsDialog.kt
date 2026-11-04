package com.orvakal.app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.LanguageManager

data class NotificationItem(
    val icon: String,
    val titleEn: String,
    val titleTe: String,
    val titleHi: String,
    val descEn: String,
    val descTe: String,
    val descHi: String,
    val timeEn: String,
    val timeTe: String,
    val timeHi: String,
    val tag: String,
    val tagBg: Color,
    val tagTextColor: Color
)

@Composable
fun NotificationsDialog(
    onDismiss: () -> Unit
) {
    val currentLang = LanguageManager.currentLanguage

    val dialogTitle = when (currentLang) {
        AppLanguage.TE -> "గ్రామ సమాచారం & నోటిఫికేషన్లు"
        AppLanguage.HI -> "ग्राम सूचनाएं एवं अलर्ट"
        AppLanguage.EN -> "Village Notices & Broadcasts"
    }

    val closeText = when (currentLang) {
        AppLanguage.TE -> "ముగించు"
        AppLanguage.HI -> "बंद करें"
        AppLanguage.EN -> "Close"
    }

    val notifications = listOf(
        NotificationItem(
            icon = "💧",
            titleEn = "Jal Jeevan Mission Water Timings",
            titleTe = "జల జీవన్ మిషన్ తాగునీటి సరఫరా వేళలు",
            titleHi = "जल जीवन मिशन पेयजल आपूर्ति समय",
            descEn = "Morning supply active 6:00 AM – 8:30 AM. Evening supply 5:00 PM – 7:00 PM across Main Bazar & Byreddynagar.",
            descTe = "ఉదయం 6:00 నుండి 8:30 వరకు, సాయంత్రం 5:00 నుండి 7:00 వరకు మెయిన్ బజార్ & బైరెడ్డినగర్ కాలనీలలో తాగునీటి సరఫరా.",
            descHi = "सुबह 6:00 से 8:30 एवं शाम 5:00 से 7:00 बजे तक मुख्य बाजार एवं बायरेड्डीनगर में पेयजल आपूर्ति चालू है।",
            timeEn = "Today • Active",
            timeTe = "నేడు • ప్రత్యక్షం",
            timeHi = "आज • सक्रिय",
            tag = "Water",
            tagBg = Color(0xFFE0F7FA),
            tagTextColor = Color(0xFF006064)
        ),
        NotificationItem(
            icon = "⚡",
            titleEn = "Agri 3-Phase Power Feeder Update",
            titleTe = "వ్యవసాయ 3-ఫేజ్ విద్యుత్ ఫీడర్ సమాచారం",
            titleHi = "कृषि 3-फेज बिजली फीडर अपडेट",
            descEn = "Group-A agricultural feeders energized from 7:00 AM to 4:00 PM today. Domestic single phase is 24/7 continuous.",
            descTe = "గ్రూప్-A వ్యవసాయ ఫీడర్లు ఉదయం 7:00 నుండి సాయంత్రం 4:00 వరకు చార్జ్ చేయబడ్డాయి. గృహ విద్యుత్ 24/7 సరఫరా.",
            descHi = "ग्रुप-ए कृषि फीडर सुबह 7:00 से शाम 4:00 बजे तक चालू हैं। घरेलू एकल-फेज आपूर्ति 24/7 जारी है।",
            timeEn = "Today • Day Schedule",
            timeTe = "నేడు • పగటి షెడ్యూల్",
            timeHi = "आज • दिन का समय",
            tag = "Power",
            tagBg = Color(0xFFFFF3E0),
            tagTextColor = Color(0xFFE65100)
        ),
        NotificationItem(
            icon = "🌾",
            titleEn = "Rythu Bharosa Kendra (RBK) Groundnut Seeds",
            titleTe = "రైతు భరోసా కేంద్రం (RBK) వేరుశనగ విత్తనాల పంపిణీ",
            titleHi = "रायथु भरोसा केंद्र मूंगफली बीज वितरण",
            descEn = "K-6 and Kadiri variety groundnut certified seed subsidy distribution counter open at Orvakal Panchayat RBK office.",
            descTe = "ఓర్వకల్లు ఆర్బీకే వద్ద కె-6 మరియు కదిరి రకం వేరుశనగ సబ్సిడీ విత్తనాల పంపిణీ కౌంటర్ ప్రారంభమైనది. ఆధార్ తప్పనిసరి.",
            descHi = "ओरवाकल आरबीके कार्यालय में सब्सिडी वाले मूंगफली प्रमाणित बीजों का वितरण शुरू हो गया है। आधार कार्ड अनिवार्य है।",
            timeEn = "Counters Open",
            timeTe = "కౌంటర్లు తెరిచి ఉన్నాయి",
            timeHi = "काउंटर खुले हैं",
            tag = "Agri",
            tagBg = Color(0xFFE8F5E9),
            tagTextColor = Color(0xFF1B5E20)
        ),
        NotificationItem(
            icon = "🏥",
            titleEn = "PHC Free Medical Camp & Screening",
            titleTe = "పీహెచ్‌సీ ఉచిత వైద్య శిబిరం & పరీక్షలు",
            titleHi = "पीएचसी निःशुल्क स्वास्थ्य जांच शिविर",
            descEn = "Weekly Maternal Health, BP & Sugar checkup camp at Orvakal Primary Health Center. Free essential medicines provided.",
            descTe = "ఓర్వకల్లు ప్రాథమిక ఆరోగ్య కేంద్రంలో ఉచిత గర్భిణీ తనిఖీలు, బిపి & షుగర్ పరీక్షలు మరియు ఉచిత మందుల పంపిణీ.",
            descHi = "ओरवाकल प्राथमिक स्वास्थ्य केंद्र पर निःशुल्क मातृ स्वास्थ्य, बीपी व शुगर जांच शिविर। निःशुल्क दवाइयां उपलब्ध।",
            timeEn = "This Friday • 9 AM - 2 PM",
            timeTe = "ఈ శుక్రవారం • ఉదయం 9 - మధ్యాహ్నం 2",
            timeHi = "इस शुक्रवार • सुबह 9 - दोपहर 2",
            tag = "Health",
            tagBg = Color(0xFFFFEBEE),
            tagTextColor = Color(0xFFC62828)
        ),
        NotificationItem(
            icon = "✈️",
            titleEn = "Kurnool Airport (KJB) Flight Schedule",
            titleTe = "కర్నూలు విమానాశ్రయం (KJB) విమాన వేళలు",
            titleHi = "कुरनूल हवाई अड्डा (KJB) उड़ान समय सारिणी",
            descEn = "Daily flights to Bengaluru (BLR) and Visakhapatnam (VTZ) operating on standard winter schedule from Orvakal airport.",
            descTe = "ఓర్వకల్లు సమీపంలోని కర్నూలు విమానాశ్రయం నుండి బెంగళూరు మరియు విశాఖపట్నంకు విమాన సర్వీసులు నిరంతరం నడుస్తున్నాయి.",
            descHi = "ओरवाकल स्थित कुरनूल हवाई अड्डे से बेंगलुरु एवं विशाखापट्टनम के लिए दैनिक उड़ानें सामान्य रूप से संचालित हैं।",
            timeEn = "Daily Flights",
            timeTe = "రోజువారీ విమానాలు",
            timeHi = "दैनिक उड़ानें",
            tag = "Transit",
            tagBg = Color(0xFFE1F5FE),
            tagTextColor = Color(0xFF0277BD)
        )
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFE0F2F1)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = null,
                            tint = Color(0xFF006778),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = dialogTitle,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF004D5A)
                    )
                }

                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close",
                        tint = Color(0xFF78909C),
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 420.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                notifications.forEach { item ->
                    val title = when (currentLang) {
                        AppLanguage.TE -> item.titleTe
                        AppLanguage.HI -> item.titleHi
                        AppLanguage.EN -> item.titleEn
                    }
                    val desc = when (currentLang) {
                        AppLanguage.TE -> item.descTe
                        AppLanguage.HI -> item.descHi
                        AppLanguage.EN -> item.descEn
                    }
                    val time = when (currentLang) {
                        AppLanguage.TE -> item.timeTe
                        AppLanguage.HI -> item.timeHi
                        AppLanguage.EN -> item.timeEn
                    }

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9FBFB)),
                        border = CardDefaults.outlinedCardBorder().copy(
                            brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFCFD8DC))
                        )
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(item.icon, fontSize = 16.sp)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = title,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF263238)
                                    )
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(item.tagBg)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = item.tag,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = item.tagTextColor
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = desc,
                                fontSize = 11.sp,
                                lineHeight = 15.sp,
                                color = Color(0xFF546E7A)
                            )

                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "⏱️ $time",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF78909C)
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006778))
            ) {
                Text(closeText, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        },
        shape = RoundedCornerShape(18.dp),
        containerColor = Color.White
    )
}
