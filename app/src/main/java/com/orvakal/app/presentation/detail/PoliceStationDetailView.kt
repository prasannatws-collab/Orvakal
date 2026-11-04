package com.orvakal.app.presentation.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Directions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.presentation.common.OrvakalSubHeader
import com.orvakal.app.presentation.common.OrvakalTeal
import com.orvakal.app.presentation.common.OrvakalTealDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PoliceStationDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "పోలీస్ స్టేషన్ & భద్రత"
        AppLanguage.HI -> "पुलिस स्टेशन व सुरक्षा"
        AppLanguage.EN -> "Police Station & Security"
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
            // Orvakal Police Station Primary Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFE8EAF6)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("👮", fontSize = 26.sp)
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(
                                    text = "Orvakal Police Station (ఓర్వకల్లు పోలీస్ స్టేషన్)",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1A237E)
                                )
                                Text(
                                    text = "Law & Order, Highway Security & Citizen Safety",
                                    fontSize = 11.sp,
                                    color = Color(0xFF3F51B5),
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Text(
                            text = "📍 Location: Beside MRO Office, Highway Road, Orvakal, Kurnool - 518010",
                            fontSize = 12.sp,
                            color = Color(0xFF37474F)
                        )
                        Text(
                            text = "👮 Sub-Inspector (SI): Sri M. Subba Rao, SI of Police",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF263238),
                            modifier = Modifier.padding(top = 4.dp)
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFF1A237E))
                                    .clickable {
                                        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:08518285233"))
                                        context.startActivity(dialIntent)
                                    }
                                    .padding(vertical = 10.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Filled.Call, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Station: 08518-285233", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color(0xFF006778))
                                    .clickable {
                                        val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919440795561"))
                                        context.startActivity(dialIntent)
                                    }
                                    .padding(vertical = 10.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(imageVector = Icons.Filled.Call, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("SI CUG: 9440795561", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }

            // Highway Patrol Mobile Vehicle
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF3E0)),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFFFCC80))
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("🚓", fontSize = 26.sp)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "NH-40 Highway Patrol Mobile",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFE65100)
                            )
                            Text(
                                text = "24/7 Accident & Breakdown Response on Orvakal Highway",
                                fontSize = 11.sp,
                                color = Color(0xFFBF360C)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color(0xFFE65100))
                                .clickable {
                                    context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919440795599")))
                                }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text("Call Patrol", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            // Emergency SOS Grid (100, 112, 1930, 181)
            item {
                Text(
                    text = "🚨 24/7 Emergency SOS Contacts",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF263238)
                )
            }

            val emergencyNumbers = listOf(
                Pair("🚔 Police Emergency", "100 / 112"),
                Pair("🛡️ Disha Women Safety", "181 / 1091"),
                Pair("💻 Cyber Crime Helpline", "1930"),
                Pair("👶 Childline India", "1098"),
                Pair("🚑 Ambulance Emergency", "108"),
                Pair("🚒 Fire & Rescue", "101")
            )

            item {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    emergencyNumbers.chunked(2).forEach { rowList ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            rowList.forEach { (label, number) ->
                                Card(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable {
                                            val cleanNum = number.split("/").first().trim()
                                            context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$cleanNum")))
                                        },
                                    shape = RoundedCornerShape(12.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White)
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Text(label, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF37474F))
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(number, fontSize = 15.sp, fontWeight = FontWeight.Black, color = Color(0xFFC62828))
                                            Icon(imageVector = Icons.Filled.Call, contentDescription = null, tint = Color(0xFFC62828), modifier = Modifier.size(16.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Senior District Police Officers
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "⭐ Senior Police Administration (Kurnool District)",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = OrvakalTealDark
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        SeniorOfficerRow(
                            designation = "Superintendent of Police (SP), Kurnool",
                            office = "District Police Office, Kurnool",
                            phone = "+91 94407 95500",
                            onCall = { p -> context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$p"))) }
                        )

                        SeniorOfficerRow(
                            designation = "Deputy Superintendent of Police (DSP), Rural",
                            office = "Kurnool Rural Sub-Division",
                            phone = "+91 94407 95505",
                            onCall = { p -> context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$p"))) }
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
fun SeniorOfficerRow(
    designation: String,
    office: String,
    phone: String,
    onCall: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(designation, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
            Text(office, fontSize = 11.sp, color = Color(0xFF546E7A))
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFE0F2F1))
                .clickable { onCall(phone) }
                .padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Filled.Call, contentDescription = null, tint = OrvakalTealDark, modifier = Modifier.size(12.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Call", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = OrvakalTealDark)
            }
        }
    }
}
