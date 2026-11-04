package com.orvakal.app.presentation.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.presentation.common.OrvakalSubHeader
import com.orvakal.app.presentation.common.OrvakalTeal
import com.orvakal.app.presentation.common.OrvakalTealDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrievanceDeskDetailView(
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val context = LocalContext.current
    val currentLang = LanguageManager.currentLanguage

    var citizenName by remember { mutableStateOf("") }
    var citizenMobile by remember { mutableStateOf("") }
    var selectedCategoryIndex by remember { mutableIntStateOf(0) }
    var complaintDetails by remember { mutableStateOf("") }
    var generatedTicketId by remember { mutableStateOf<String?>(null) }

    val categories = when (currentLang) {
        AppLanguage.TE -> listOf(
            "💧 తాగునీరు / RO ప్లాంట్",
            "💡 వీధి దీపాలు / విద్యుత్",
            "🧹 మురుగు కాలువలు / పారిశుధ్యం",
            "🛣️ రోడ్ల మరమ్మతులు",
            "🍚 రేషన్ కార్డు / PDS",
            "🌾 రైతు భరోసా / పంట నష్టం",
            "📜 భూ సర్వే / పట్టాదారు"
        )
        AppLanguage.HI -> listOf(
            "💧 पेयजल / आरओ प्लांट",
            "💡 स्ट्रीट लाइट / बिजली",
            "🧹 नाली / स्वच्छता",
            "🛣️ सड़क मरम्मत",
            "🍚 राशन / पीडीएस",
            "🌾 किसान कल्याण / फसल क्षति",
            "📜 भूमि सर्वेक्षण / पट्टा"
        )
        AppLanguage.EN -> listOf(
            "💧 Drinking Water / RO",
            "💡 Streetlights / Power",
            "🧹 Drainage & Sanitation",
            "🛣️ Road Repairs",
            "🍚 Ration / PDS",
            "🌾 Farmer Support / Crop",
            "📜 Land Survey & Revenue"
        )
    }

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "గ్రామ పంచాయతీ ఫిర్యాదుల విభాగం"
        AppLanguage.HI -> "ग्राम पंचायत शिकायत निवारण"
        AppLanguage.EN -> "Panchayat Grievance Desk"
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
            // Toll Free Helpline 1902 Hero Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEBEE)),
                    border = CardDefaults.outlinedCardBorder().copy(
                        brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFFFCDD2))
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("📞", fontSize = 28.sp)
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "AP Govt Spandana / Helpline 1902",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFB71C1C)
                            )
                            Text(
                                text = "CM Public Grievance Redressal System (Toll-Free 24/7)",
                                fontSize = 11.sp,
                                color = Color(0xFFC62828)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFFB71C1C))
                                .clickable {
                                    val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:1902"))
                                    context.startActivity(dialIntent)
                                }
                                .padding(horizontal = 14.dp, vertical = 8.dp)
                        ) {
                            Text("Call 1902", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        }
                    }
                }
            }

            // Key Village Administration Contacts
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "🏛️ Orvakal Village Administration Contacts",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = OrvakalTealDark
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        GrievanceOfficerRow(
                            role = "Panchayat Secretary (పంచాయతీ కార్యదర్శి)",
                            name = "Sri K. Madhava Rao",
                            phone = "+91 94409 01245",
                            onCall = { phone ->
                                context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
                            }
                        )
                        GrievanceOfficerRow(
                            role = "Village Revenue Officer (VRO)",
                            name = "Sri B. Chennaiah",
                            phone = "+91 94409 01246",
                            onCall = { phone ->
                                context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
                            }
                        )
                        GrievanceOfficerRow(
                            role = "Engineering Assistant (Water & Roads)",
                            name = "Smt. G. Swathi",
                            phone = "+91 94409 01247",
                            onCall = { phone ->
                                context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
                            }
                        )
                        GrievanceOfficerRow(
                            role = "Welfare & Sanitation Assistant",
                            name = "Sri M. Ravi Kumar",
                            phone = "+91 94409 01248",
                            onCall = { phone ->
                                context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")))
                            }
                        )
                    }
                }
            }

            // Interactive Grievance Lodging Form
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "📝 Lodge Online Grievance (ఫిర్యాదు నమోదు చేయండి)",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = OrvakalTealDark
                        )
                        Text(
                            text = "Direct submission to Orvakal Grama Sachivalayam Desk with 72h SLA",
                            fontSize = 11.sp,
                            color = Color(0xFF78909C)
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        OutlinedTextField(
                            value = citizenName,
                            onValueChange = { citizenName = it },
                            label = { Text("Your Full Name (పేరు)") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = OrvakalTeal,
                                unfocusedBorderColor = Color(0xFFCFD8DC)
                            )
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = citizenMobile,
                            onValueChange = { citizenMobile = it.filter { ch -> ch.isDigit() }.take(10) },
                            label = { Text("Mobile Number (మొబైల్ సంఖ్య)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = OrvakalTeal,
                                unfocusedBorderColor = Color(0xFFCFD8DC)
                            )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text("Select Grievance Category (ఫిర్యాదు రకం):", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF455A64))
                        Spacer(modifier = Modifier.height(6.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            categories.forEachIndexed { idx, cat ->
                                FilterChip(
                                    selected = selectedCategoryIndex == idx,
                                    onClick = { selectedCategoryIndex = idx },
                                    label = { Text(cat, fontSize = 11.sp) },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = OrvakalTeal,
                                        selectedLabelColor = Color.White
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = complaintDetails,
                            onValueChange = { complaintDetails = it },
                            label = { Text("Describe Your Grievance (సమస్య వివరాలు)") },
                            minLines = 3,
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = OrvakalTeal,
                                unfocusedBorderColor = Color(0xFFCFD8DC)
                            )
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(if (citizenName.isNotEmpty() && citizenMobile.length >= 10 && complaintDetails.isNotEmpty()) OrvakalTealDark else Color(0xFFCFD8DC))
                                .clickable(enabled = citizenName.isNotEmpty() && citizenMobile.length >= 10 && complaintDetails.isNotEmpty()) {
                                    val randomId = (1000..9999).random()
                                    generatedTicketId = "ORV-GRV-2026-$randomId"
                                }
                                .padding(vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Submit Grievance to Sachivalayam (ఫిర్యాదు సమర్పించండి)",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp
                            )
                        }
                    }
                }
            }

            // Ticket confirmation card if generated
            generatedTicketId?.let { ticket ->
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                        border = CardDefaults.outlinedCardBorder().copy(
                            brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFA5D6A7))
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = null, tint = Color(0xFF2E7D32), modifier = Modifier.size(24.dp))
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Grievance Registered Successfully!",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF1B5E20)
                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Grievance Ticket ID: $ticket",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Black,
                                color = Color(0xFF004D40)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Assigned to: Orvakal Grama Sachivalayam\nStatus: IN PROGRESS (Expected Resolution within 72 Hours)\nAn SMS confirmation has been simulated to $citizenMobile.",
                                fontSize = 12.sp,
                                lineHeight = 16.sp,
                                color = Color(0xFF2E7D32)
                            )
                        }
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
fun GrievanceOfficerRow(
    role: String,
    name: String,
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
            Text(text = role, fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF263238))
            Text(text = name, fontSize = 11.sp, color = Color(0xFF546E7A))
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
