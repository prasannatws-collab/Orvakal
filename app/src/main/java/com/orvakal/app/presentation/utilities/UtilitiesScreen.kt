package com.orvakal.app.presentation.utilities

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.presentation.common.OrvakalSubHeader
import com.orvakal.app.presentation.common.OrvakalTeal
import com.orvakal.app.presentation.common.OrvakalTealDark
import com.orvakal.app.presentation.theme.ThemeManager
import kotlinx.coroutines.delay
import java.text.NumberFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UtilitiesScreen(
    initialTab: Int = 0,
    onBack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val isDark = ThemeManager.isDarkMode
    var selectedTab by remember(initialTab) { mutableIntStateOf(initialTab.coerceIn(0, 6)) }
    val currentLang = LanguageManager.currentLanguage

    val tabs = when (currentLang) {
        AppLanguage.TE -> listOf(
            "💰 వడ్డీ కాలిక్యులేటర్",
            "📐 భూమి కొలతలు",
            "🌱 ఎరువుల మోతాదు",
            "🥛 పాల ఫ్యాట్ రేటు",
            "🚜 ట్రాక్టర్ ఖర్చు",
            "💡 కరెంట్ బిల్లు",
            "⏱️ పంపు టైమర్"
        )
        AppLanguage.HI -> listOf(
            "💰 ब्याज कैलकुलेटर",
            "📐 भूमि परिवर्तक",
            "🌱 खाद कैलकुलेटर",
            "🥛 दूध फैट व मूल्य",
            "🚜 जुताई खर्च",
            "💡 बिजली बिल",
            "⏱️ पंप टाइमर"
        )
        AppLanguage.EN -> listOf(
            "💰 Interest Calculator",
            "📐 Land Units",
            "🌱 Fertilizer Calc",
            "🥛 Milk Fat & SNF",
            "🚜 Tractor Cost",
            "💡 Electricity Bill",
            "⏱️ Pump Timer"
        )
    }

    val screenTitle = when (currentLang) {
        AppLanguage.TE -> "ఉపయోగాలు"
        AppLanguage.HI -> "उपयोगिताएं"
        AppLanguage.EN -> "Utilities"
    }

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

        ScrollableTabRow(
            selectedTabIndex = selectedTab,
            containerColor = if (isDark) Color(0xFF1E1E1E) else Color.White,
            contentColor = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark,
            edgePadding = 12.dp,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                    color = if (isDark) Color(0xFF80CBC4) else OrvakalTealDark,
                    height = 3.dp
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            fontSize = 13.sp,
                            fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Medium,
                            color = if (selectedTab == index) {
                                if (isDark) Color(0xFF80CBC4) else OrvakalTealDark
                            } else {
                                if (isDark) Color(0xFFCFD8DC) else Color(0xFF546E7A)
                            }
                        )
                    }
                )
            }
        }

        when (selectedTab) {
            0 -> RuralInterestCalculator()
            1 -> LandUnitConverter()
            2 -> FertilizerCalculator()
            3 -> MilkFatCalculator()
            4 -> TractorTillingCalculator()
            5 -> ElectricityBillEstimator()
            6 -> PumpTimerTool()
        }
    }
}

@Composable
fun RuralInterestCalculator() {
    var principalText by remember { mutableStateOf("100000") }
    var rateText by remember { mutableStateOf("2.0") }
    var monthsText by remember { mutableStateOf("12") }
    var daysText by remember { mutableStateOf("0") }
    var isCompound by remember { mutableStateOf(false) }

    val principal = principalText.toDoubleOrNull() ?: 0.0
    val ratePerMonth = rateText.toDoubleOrNull() ?: 0.0 // rate per ₹100 per month
    val months = monthsText.toDoubleOrNull() ?: 0.0
    val days = daysText.toDoubleOrNull() ?: 0.0

    val totalTimeMonths = months + (days / 30.0)
    val monthlyInterest = (principal / 100.0) * ratePerMonth

    val totalInterest = if (!isCompound) {
        monthlyInterest * totalTimeMonths
    } else {
        val annualRate = ratePerMonth * 12.0 / 100.0
        val years = totalTimeMonths / 12.0
        (principal * Math.pow(1.0 + annualRate, years)) - principal
    }

    val totalPayable = principal + totalInterest
    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "💰 Interest Calculator (వడ్డీ కాలిక్యులేటర్)",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = OrvakalTealDark
                    )
                    Text(
                        text = "Calculates village monthly rate (₹ per ₹100 per month / నూటికి నెలకు వడ్డీ)",
                        fontSize = 11.sp,
                        color = Color(0xFF78909C)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Calculation type selector
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilterChip(
                            selected = !isCompound,
                            onClick = { isCompound = false },
                            label = { Text("Simple (సాధారణ వడ్డీ)") },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = OrvakalTeal,
                                selectedLabelColor = Color.White
                            )
                        )
                        FilterChip(
                            selected = isCompound,
                            onClick = { isCompound = true },
                            label = { Text("Chakravaddi (చక్రవడ్డీ)") },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = OrvakalTeal,
                                selectedLabelColor = Color.White
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = principalText,
                        onValueChange = { principalText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                        label = { Text("Principal Amount (అసలు సొమ్ము ₹)") },
                        leadingIcon = { Text("₹", fontWeight = FontWeight.Bold, color = OrvakalTeal) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = OrvakalTeal,
                            unfocusedBorderColor = Color(0xFFCFD8DC)
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = rateText,
                        onValueChange = { rateText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                        label = { Text("Rate per ₹100/month (నూటికి నెలకు వడ్డీ - ఉదా: 1.5, 2.0, 3.0)") },
                        leadingIcon = { Text("%", fontWeight = FontWeight.Bold, color = OrvakalTeal) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = OrvakalTeal,
                            unfocusedBorderColor = Color(0xFFCFD8DC)
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedTextField(
                            value = monthsText,
                            onValueChange = { monthsText = it.filter { ch -> ch.isDigit() } },
                            label = { Text("Months (నెలలు)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = OrvakalTeal,
                                unfocusedBorderColor = Color(0xFFCFD8DC)
                            )
                        )

                        OutlinedTextField(
                            value = daysText,
                            onValueChange = { daysText = it.filter { ch -> ch.isDigit() } },
                            label = { Text("Days (రోజులు)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = OrvakalTeal,
                                unfocusedBorderColor = Color(0xFFCFD8DC)
                            )
                        )
                    }
                }
            }
        }

        // Result Card
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
                    Text(
                        text = "📊 Calculation Summary (లెక్క వివరాలు)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B5E20)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Monthly Interest (నెలకు వడ్డీ):", fontSize = 12.sp, color = Color(0xFF2E7D32))
                        Text(formatter.format(monthlyInterest), fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Total Interest (మొత్తం వడ్డీ):", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF2E7D32))
                        Text(formatter.format(totalInterest), fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFA5D6A7)))
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Total Payable (అసలు + వడ్డీ):", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF004D40))
                        Text(formatter.format(totalPayable), fontSize = 18.sp, fontWeight = FontWeight.Black, color = Color(0xFF004D40))
                    }
                }
            }
        }
    }
}

@Composable
fun LandUnitConverter() {
    var inputValueText by remember { mutableStateOf("1.0") }
    var selectedUnitIndex by remember { mutableIntStateOf(0) } // 0: Acres, 1: Cents, 2: Guntas, 3: Gajalu

    val unitNames = listOf("Acres (ఎకరాలు)", "Cents (సెంట్లు)", "Guntas (కుంటలు)", "Sq Yards / Gajalu (గజాలు)")
    val value = inputValueText.toDoubleOrNull() ?: 0.0

    // Convert everything to Cents as base unit
    val cents = when (selectedUnitIndex) {
        0 -> value * 100.0 // 1 Acre = 100 Cents
        1 -> value // 1 Cent = 1 Cent
        2 -> value * 2.5 // 1 Gunta = 2.5 Cents
        3 -> value / 48.4 // 1 Cent = 48.4 Gajalu
        else -> value
    }

    val acres = cents / 100.0
    val guntas = cents / 2.5
    val sqYards = cents * 48.4
    val sqFeet = cents * 435.6
    val hectares = acres * 0.404686

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "📐 Rural Land Measurement Converter (భూమి కొలతలు)",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = OrvakalTealDark
                    )
                    Text(
                        text = "Convert between Acres, Cents, Guntas, Gajalu & Sq Feet for Passbooks",
                        fontSize = 11.sp,
                        color = Color(0xFF78909C)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = inputValueText,
                        onValueChange = { inputValueText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                        label = { Text("Enter Quantity (విలువ)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = OrvakalTeal,
                            unfocusedBorderColor = Color(0xFFCFD8DC)
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text("Select Input Unit (ప్రస్తుత యూనిట్ ఎంచుకోండి):", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF455A64))
                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        unitNames.forEachIndexed { idx, name ->
                            FilterChip(
                                selected = selectedUnitIndex == idx,
                                onClick = { selectedUnitIndex = idx },
                                label = { Text(name, fontSize = 12.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = OrvakalTeal,
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }
                }
            }
        }

        // Result Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0F2F1)),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = androidx.compose.ui.graphics.SolidColor(Color(0xFF80CBC4))
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "🔄 Converted Measurements (మార్పిడి వివరాలు)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF004D40)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    val conversions = listOf(
                        "Cents (సెంట్లు)" to String.format(Locale.US, "%.3f Cents", cents),
                        "Acres (ఎకరాలు)" to String.format(Locale.US, "%.4f Acres", acres),
                        "Guntas (కుంటలు)" to String.format(Locale.US, "%.2f Guntas", guntas),
                        "Sq Yards / Gajalu (గజాలు)" to String.format(Locale.US, "%.1f Sq Yards", sqYards),
                        "Square Feet (చదరపు అడుగులు)" to String.format(Locale.US, "%.1f Sq Ft", sqFeet),
                        "Hectares (హెక్టార్లు)" to String.format(Locale.US, "%.4f Ha", hectares)
                    )

                    conversions.forEach { (unitName, valueStr) ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = unitName, fontSize = 12.sp, color = Color(0xFF004D40))
                            Text(text = valueStr, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = OrvakalTealDark)
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFF80CBC4)))
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "💡 1 Acre = 100 Cents = 4,840 Gajalu = 43,560 Sq Ft\n💡 1 Cent = 48.4 Gajalu = 435.6 Sq Ft\n💡 1 Gunta = 2.5 Cents = 121 Gajalu",
                        fontSize = 11.sp,
                        color = Color(0xFF004D40),
                        lineHeight = 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun FertilizerCalculator() {
    var acresText by remember { mutableStateOf("2.0") }
    var selectedCropIndex by remember { mutableIntStateOf(0) }

    val crops = listOf(
        "వేరుశనగ (Groundnut)",
        "శనగలు (Bengal Gram)",
        "పత్తి (Cotton)",
        "వరి (Paddy)",
        "మొక్కజొన్న (Maize)"
    )

    val acres = acresText.toDoubleOrNull() ?: 0.0

    // Per acre bag requirements (Urea 45kg, DAP 50kg, MOP 50kg, Gypsum 50kg)
    val (ureaBagsPerAcre, dapBagsPerAcre, mopBagsPerAcre, gypsumBagsPerAcre) = when (selectedCropIndex) {
        0 -> listOf(0.5, 1.0, 0.5, 4.0) // Groundnut needs Gypsum 200kg (4 bags)
        1 -> listOf(0.4, 1.0, 0.3, 0.0) // Bengal Gram (rhizobium + phosphate)
        2 -> listOf(2.5, 1.5, 1.0, 0.0) // Cotton (heavy nitrogen & potassium)
        3 -> listOf(2.0, 1.0, 0.8, 0.0) // Paddy
        4 -> listOf(2.2, 1.2, 0.8, 0.0) // Maize
        else -> listOf(1.0, 1.0, 0.5, 0.0)
    }

    val totalUrea = ureaBagsPerAcre * acres
    val totalDap = dapBagsPerAcre * acres
    val totalMop = mopBagsPerAcre * acres
    val totalGypsum = gypsumBagsPerAcre * acres

    // Estimated cost at subsidized RBK rates: Urea ~₹266.50/bag, DAP ~₹1,350/bag, MOP ~₹1,700/bag, Gypsum ~₹180/bag
    val estCost = (totalUrea * 266.5) + (totalDap * 1350.0) + (totalMop * 1700.0) + (totalGypsum * 180.0)
    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "🌱 Fertilizer & Nutrient Dosage Calculator (ఎరువుల మోతాదు)",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = OrvakalTealDark
                    )
                    Text(
                        text = "Calculate exact number of bags for your land based on ANGRAU recommendations",
                        fontSize = 11.sp,
                        color = Color(0xFF78909C)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text("Select Crop (పంటను ఎంచుకోండి):", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF455A64))
                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        crops.forEachIndexed { idx, cropName ->
                            FilterChip(
                                selected = selectedCropIndex == idx,
                                onClick = { selectedCropIndex = idx },
                                label = { Text(cropName, fontSize = 12.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = OrvakalTeal,
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    OutlinedTextField(
                        value = acresText,
                        onValueChange = { acresText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                        label = { Text("Total Land Area in Acres (ఎకరాల సంఖ్య)") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = OrvakalTeal,
                            unfocusedBorderColor = Color(0xFFCFD8DC)
                        )
                    )
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F8E9)),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFC5E1A5))
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "📦 Recommended Bags for ${String.format(Locale.US, "%.1f", acres)} Acres",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF33691E)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    FertilizerRow("Urea (45 kg bag)", String.format(Locale.US, "%.1f Bags", totalUrea), "₹266.50 / bag")
                    FertilizerRow("DAP (50 kg bag)", String.format(Locale.US, "%.1f Bags", totalDap), "₹1,350.00 / bag")
                    FertilizerRow("MOP Potash (50 kg bag)", String.format(Locale.US, "%.1f Bags", totalMop), "₹1,700.00 / bag")
                    if (totalGypsum > 0) {
                        FertilizerRow("Gypsum (50 kg bag)", String.format(Locale.US, "%.1f Bags", totalGypsum), "₹180.00 / bag (Essential for pods)")
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFC5E1A5)))
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Estimated Cost at RBK Rates:", fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF33691E))
                        Text(formatter.format(estCost), fontSize = 16.sp, fontWeight = FontWeight.Black, color = Color(0xFF1B5E20))
                    }
                }
            }
        }
    }
}

@Composable
fun FertilizerRow(name: String, qty: String, note: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = name, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF33691E))
            Text(text = note, fontSize = 10.sp, color = Color(0xFF689F38))
        }
        Text(text = qty, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
    }
}

@Composable
fun MilkFatCalculator() {
    var milkQuantityText by remember { mutableStateOf("15.0") } // Liters
    var fatPercentText by remember { mutableStateOf("7.5") } // %
    var snfPercentText by remember { mutableStateOf("8.8") } // %
    var baseRateText by remember { mutableStateOf("85.0") } // ₹ per 10% fat or per 100g TS

    val liters = milkQuantityText.toDoubleOrNull() ?: 0.0
    val fat = fatPercentText.toDoubleOrNull() ?: 0.0
    val snf = snfPercentText.toDoubleOrNull() ?: 0.0
    val baseRate = baseRateText.toDoubleOrNull() ?: 0.0

    // Standard AP Dairy / Heritage formula:
    // Rate per liter = (Fat * BaseRate / 10) + (SNF * 2.5)
    val ratePerLiter = (fat * (baseRate / 10.0)) + (snf * 1.8)
    val totalBill = liters * ratePerLiter
    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "🥛 Dairy Milk Fat & SNF Rate Calculator (పాల ఫ్యాట్ & ధర)",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = OrvakalTealDark
                    )
                    Text(
                        text = "Calculate price per liter and daily dairy payment based on Fat % & SNF %",
                        fontSize = 11.sp,
                        color = Color(0xFF78909C)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = milkQuantityText,
                        onValueChange = { milkQuantityText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                        label = { Text("Milk Quantity in Liters (పాల పరిమాణం లీటర్లలో)") },
                        leadingIcon = { Text("🥛", fontSize = 16.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = OrvakalTeal,
                            unfocusedBorderColor = Color(0xFFCFD8DC)
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedTextField(
                            value = fatPercentText,
                            onValueChange = { fatPercentText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                            label = { Text("Fat % (ఫ్యాట్)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = OrvakalTeal,
                                unfocusedBorderColor = Color(0xFFCFD8DC)
                            )
                        )

                        OutlinedTextField(
                            value = snfPercentText,
                            onValueChange = { snfPercentText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                            label = { Text("SNF % (ఎస్.ఎన్.ఎఫ్)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = OrvakalTeal,
                                unfocusedBorderColor = Color(0xFFCFD8DC)
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = baseRateText,
                        onValueChange = { baseRateText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                        label = { Text("Base Fat Rate ₹ (కేంద్రం నిర్ణయించిన బేస్ ధర)") },
                        leadingIcon = { Text("₹", fontWeight = FontWeight.Bold, color = OrvakalTeal) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = OrvakalTeal,
                            unfocusedBorderColor = Color(0xFFCFD8DC)
                        )
                    )
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE1F5FE)),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = androidx.compose.ui.graphics.SolidColor(Color(0xFF81D4FA))
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "🧾 Milk Payment Calculation (పాల బిల్లు)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF01579B)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Calculated Rate per Liter (లీటరు ధర):", fontSize = 13.sp, color = Color(0xFF0277BD))
                        Text(String.format(Locale.US, "₹%.2f / L", ratePerLiter), fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF01579B))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Total Solids (Fat + SNF):", fontSize = 12.sp, color = Color(0xFF0277BD))
                        Text(String.format(Locale.US, "%.2f %%", fat + snf), fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Color(0xFF0277BD))
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFF81D4FA)))
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Total Daily Earning (మొత్తం ఆదాయం):", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF004D40))
                        Text(formatter.format(totalBill), fontSize = 18.sp, fontWeight = FontWeight.Black, color = Color(0xFF004D40))
                    }
                }
            }
        }
    }
}

@Composable
fun TractorTillingCalculator() {
    var hoursText by remember { mutableStateOf("4.0") }
    var dieselPriceText by remember { mutableStateOf("94.5") }
    var selectedImplementIndex by remember { mutableIntStateOf(0) }

    val implements = listOf(
        Pair("రోటవేటర్ (Rotavator)", 1100),
        Pair("కల్టివేటర్ (9-Tyne Cultivator)", 850),
        Pair("కంబైన్ హార్వెస్టర్ (Harvester)", 2400),
        Pair("నాగలి దుక్కి (Mouldboard Plough)", 1200),
        Pair("విత్తనం గొర్రు (Seed Drill)", 950)
    )

    val hours = hoursText.toDoubleOrNull() ?: 0.0
    val hourlyRate = implements[selectedImplementIndex].second
    val totalHiringCost = hours * hourlyRate

    // Estimated diesel consumed (approx 4.5 liters per hour for 50HP tractor)
    val dieselPrice = dieselPriceText.toDoubleOrNull() ?: 94.5
    val estDieselLiters = hours * 4.5
    val estDieselCost = estDieselLiters * dieselPrice

    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "🚜 Tractor Tilling & Machinery Hire Cost (ట్రాక్టర్ దుక్కి లెక్క)",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = OrvakalTealDark
                    )
                    Text(
                        text = "Calculate hiring charges and diesel expenses for ploughing & harvesting",
                        fontSize = 11.sp,
                        color = Color(0xFF78909C)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text("Select Machinery Implement (పనిముట్టును ఎంచుకోండి):", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF455A64))
                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        implements.forEachIndexed { idx, pair ->
                            FilterChip(
                                selected = selectedImplementIndex == idx,
                                onClick = { selectedImplementIndex = idx },
                                label = { Text("${pair.first} (₹${pair.second}/hr)", fontSize = 12.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = OrvakalTeal,
                                    selectedLabelColor = Color.White
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedTextField(
                            value = hoursText,
                            onValueChange = { hoursText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                            label = { Text("Running Hours (గంటలు)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = OrvakalTeal,
                                unfocusedBorderColor = Color(0xFFCFD8DC)
                            )
                        )

                        OutlinedTextField(
                            value = dieselPriceText,
                            onValueChange = { dieselPriceText = it.filter { ch -> ch.isDigit() || ch == '.' } },
                            label = { Text("Diesel Price ₹/L (డీజిల్ ధర)") },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = OrvakalTeal,
                                unfocusedBorderColor = Color(0xFFCFD8DC)
                            )
                        )
                    }
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF8E1)),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFFFE082))
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "🚜 Hire Cost Breakdown (అద్దె వివరాలు)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF57F17)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Machine Hourly Rate:", fontSize = 12.sp, color = Color(0xFF795548))
                        Text("₹$hourlyRate / Hour", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF5D4037))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Estimated Diesel (4.5 L/hr):", fontSize = 12.sp, color = Color(0xFF795548))
                        Text(String.format(Locale.US, "%.1f Liters (~%s)", estDieselLiters, formatter.format(estDieselCost)), fontSize = 13.sp, color = Color(0xFF5D4037))
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFFFE082)))
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Total Machine Hiring Cost:", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFFE65100))
                        Text(formatter.format(totalHiringCost), fontSize = 18.sp, fontWeight = FontWeight.Black, color = Color(0xFFE65100))
                    }
                }
            }
        }
    }
}

@Composable
fun ElectricityBillEstimator() {
    var unitsText by remember { mutableStateOf("125") }
    val units = unitsText.toDoubleOrNull() ?: 0.0

    // APSPDCL Domestic Slabs:
    // 0-50 units: ₹1.45/unit
    // 51-100 units: ₹2.60/unit
    // 101-200 units: ₹3.60/unit
    // >200 units: ₹6.90/unit
    var energyCharges = 0.0
    var remainingUnits = units

    if (remainingUnits > 0) {
        val u1 = remainingUnits.coerceAtMost(50.0)
        energyCharges += u1 * 1.45
        remainingUnits -= u1
    }
    if (remainingUnits > 0) {
        val u2 = remainingUnits.coerceAtMost(50.0)
        energyCharges += u2 * 2.60
        remainingUnits -= u2
    }
    if (remainingUnits > 0) {
        val u3 = remainingUnits.coerceAtMost(100.0)
        energyCharges += u3 * 3.60
        remainingUnits -= u3
    }
    if (remainingUnits > 0) {
        energyCharges += remainingUnits * 6.90
    }

    val customerCharges = if (units <= 50) 25.0 else if (units <= 100) 35.0 else if (units <= 200) 50.0 else 75.0
    val electricityDuty = units * 0.06 // 6 paise per unit
    val totalBill = energyCharges + customerCharges + electricityDuty
    val formatter = NumberFormat.getCurrencyInstance(Locale("en", "IN"))

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "💡 APSPDCL Domestic Electricity Bill Estimator (కరెంట్ బిల్లు)",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = OrvakalTealDark
                    )
                    Text(
                        text = "Estimate your monthly residential electricity bill according to AP slab tariffs",
                        fontSize = 11.sp,
                        color = Color(0xFF78909C)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = unitsText,
                        onValueChange = { unitsText = it.filter { ch -> ch.isDigit() } },
                        label = { Text("Monthly Consumed Units (నెలవారీ యూనిట్లు)") },
                        leadingIcon = { Text("⚡", fontSize = 16.sp) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = OrvakalTeal,
                            unfocusedBorderColor = Color(0xFFCFD8DC)
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "⚡ Agricultural borewells with 3-phase connection receive 9 Hours of FREE electricity under AP State Policy.",
                        fontSize = 11.sp,
                        color = Color(0xFF2E7D32),
                        lineHeight = 15.sp
                    )
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEDE7F6)),
                border = CardDefaults.outlinedCardBorder().copy(
                    brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFD1C4E9))
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "💡 Bill Breakdown for ${String.format(Locale.US, "%.0f", units)} Units",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4A148C)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Energy Charges (కరెంట్ చార్జీలు):", fontSize = 12.sp, color = Color(0xFF6A1B9A))
                        Text(formatter.format(energyCharges), fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color(0xFF4A148C))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Customer / Fixed Charges:", fontSize = 12.sp, color = Color(0xFF6A1B9A))
                        Text(formatter.format(customerCharges), fontSize = 13.sp, color = Color(0xFF4A148C))
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Electricity Duty (ED @ 6 ps):", fontSize = 12.sp, color = Color(0xFF6A1B9A))
                        Text(formatter.format(electricityDuty), fontSize = 13.sp, color = Color(0xFF4A148C))
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xFFD1C4E9)))
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Estimated Total Bill (మొత్తం బిల్లు):", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF311B92))
                        Text(formatter.format(totalBill), fontSize = 18.sp, fontWeight = FontWeight.Black, color = Color(0xFF311B92))
                    }
                }
            }
        }
    }
}

@Composable
fun PumpTimerTool() {
    var isRunning by remember { mutableStateOf(false) }
    var elapsedSeconds by remember { mutableLongStateOf(0L) }
    var targetHours by remember { mutableIntStateOf(0) }

    LaunchedEffect(isRunning) {
        while (isRunning) {
            delay(1000L)
            elapsedSeconds++
        }
    }

    val hours = elapsedSeconds / 3600
    val minutes = (elapsedSeconds % 3600) / 60
    val seconds = elapsedSeconds % 60

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "⚡ Borewell & Pump Running Timer (పంపు టైమర్)",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = OrvakalTealDark
                )
                Text(
                    text = "Track farm 3-phase electricity hours & irrigation timing",
                    fontSize = 11.sp,
                    color = Color(0xFF78909C)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Big digital display
                Text(
                    text = String.format(Locale.US, "%02d:%02d:%02d", hours, minutes, seconds),
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Black,
                    color = if (isRunning) Color(0xFF2E7D32) else OrvakalTealDark
                )

                Text(
                    text = if (isRunning) "Running (మోటార్ ఆన్ లో ఉంది)" else "Paused (ఆపివేయబడింది)",
                    fontSize = 12.sp,
                    color = if (isRunning) Color(0xFF2E7D32) else Color(0xFF78909C),
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(18.dp))

                // Preset hour chips
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(1, 2, 3, 4).forEach { h ->
                        FilterChip(
                            selected = targetHours == h,
                            onClick = {
                                targetHours = h
                                elapsedSeconds = 0L
                                isRunning = true
                            },
                            label = { Text("${h}h Run") },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = OrvakalTeal,
                                selectedLabelColor = Color.White
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(if (isRunning) Color(0xFFE53935) else Color(0xFF2E7D32))
                            .clickable { isRunning = !isRunning }
                            .padding(horizontal = 24.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = if (isRunning) "Pause (ఆపు)" else "Start (ప్రారంభించు)",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFECEFF1))
                            .clickable {
                                isRunning = false
                                elapsedSeconds = 0L
                                targetHours = 0
                            }
                            .padding(horizontal = 24.dp, vertical = 12.dp)
                    ) {
                        Text(
                            text = "Reset (మళ్ళీ)",
                            color = Color(0xFF37474F),
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}
