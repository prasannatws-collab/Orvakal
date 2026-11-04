package com.orvakal.app.presentation.common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Shield
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.domain.language.AppStrings

@Composable
fun PrivacyPolicyDialog(
    onDismiss: () -> Unit
) {
    val context = LocalContext.current

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
                            imageVector = Icons.Filled.Shield,
                            contentDescription = null,
                            tint = Color(0xFF006778),
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = AppStrings.viewPrivacyPolicy,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF004D5A)
                        )
                        Text(
                            text = "Legal Disclaimers & Data Safety",
                            fontSize = 11.sp,
                            color = Color(0xFF546E7A)
                        )
                    }
                }
                IconButton(onClick = onDismiss, modifier = Modifier.size(28.dp)) {
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
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Section 1: Non-Affiliation / Government Disclaimer
                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF8E1)),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFFFE082))
                    )
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("⚠️", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Government Non-Affiliation Disclaimer",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFE65100)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Orvakal: Village & Smart Digital Hub is an independent community and civic application developed to assist residents, farmers, students, workers, and visitors of Orvakal Mandal, Kurnool District, Andhra Pradesh. This application is NOT affiliated with, authorized by, endorsed by, or representing any government entity or political organisation.",
                            fontSize = 11.sp,
                            color = Color(0xFF4E342E),
                            lineHeight = 15.sp
                        )
                    }
                }

                // Section 2: Sources of Public & Government Information
                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8E9)),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFC5E1A5))
                    )
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "Sources of Public Information",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF2E7D32)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "All government welfare schemes, emergency helplines, electricity feeder details, and agriculture mandi prices displayed in this application are compiled from officially published, publicly accessible government domains:",
                            fontSize = 11.sp,
                            color = Color(0xFF33691E),
                            lineHeight = 14.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                        val sources = listOf(
                            "AP State Government Portal" to "https://ap.gov.in",
                            "National Portal of India" to "https://india.gov.in",
                            "Agmarknet Agri Market Prices" to "https://agmarknet.gov.in",
                            "APSPDCL Power Distribution" to "https://www.apspdcl.in",
                            "Kurnool District Portal" to "https://kurnool.ap.gov.in",
                            "AP Online / Meeseva" to "https://meeseva.gov.in"
                        )

                        sources.forEach { (name, url) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 3.dp)
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(Color.White)
                                    .clickable {
                                        try {
                                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                            context.startActivity(intent)
                                        } catch (_: Exception) {}
                                    }
                                    .padding(horizontal = 8.dp, vertical = 6.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(name, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1B5E20))
                                    Text(url, fontSize = 9.sp, color = Color(0xFF689F38))
                                }
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                                    contentDescription = null,
                                    tint = Color(0xFF2E7D32),
                                    modifier = Modifier.size(13.dp)
                                )
                            }
                        }
                    }
                }

                // Section 3: Data Safety & User Privacy
                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2F1)),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(Color(0xFF80CBC4))
                    )
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "Data Safety & Privacy Commitments",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF004D5A)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "• No Personal Data Collection: We do not collect, store, profile, or sell your name, phone number, location, or sensitive identifiers.\n• No User Accounts Required: The entire app is accessible anonymously without creating an account or signing in.\n• Permissions Hygiene: Only INTERNET permission is declared for reading public web links. No background location, microphone, or camera permissions are requested.\n• Native Phone Dialer: Clicking phone numbers dispatches an action to your device dialer (tel:) without requiring direct CALL_PHONE permissions.\n• Encryption: Network communications use HTTPS encryption in transit.",
                            fontSize = 11.sp,
                            color = Color(0xFF004D40),
                            lineHeight = 15.sp
                        )
                    }
                }

                // Section 4: Contact & Inquiries
                Card(
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFECEFF1))
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "Developer Contact & Policy Inquiries",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF263238)
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Developer: Orvakal Community & Civic Portal Team\nContact / Inquiries: prasanna.tws@gmail.com",
                            fontSize = 10.sp,
                            color = Color(0xFF455A64)
                        )
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006778)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Understood", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }
        }
    )
}
