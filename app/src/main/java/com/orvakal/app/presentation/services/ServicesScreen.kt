package com.orvakal.app.presentation.services

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orvakal.app.data.local.OrvakalData
import com.orvakal.app.domain.language.AppStrings
import com.orvakal.app.domain.model.CatalogCategory
import com.orvakal.app.presentation.common.ScreenHeaderRow
import com.orvakal.app.presentation.theme.ThemeManager

@Composable
fun ServicesScreen(
    onNavigateToCategory: (String) -> Unit,
    onNavigateToHome: () -> Unit
) {
    val isDark = ThemeManager.isDarkMode

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isDark) Color(0xFF121212) else Color(0xFFF3F7F8))
    ) {
        // Screen title row: 🏠 Services Catalog | 🏠 Dashboard
        ScreenHeaderRow(
            title = AppStrings.servicesCatalogTitle,
            icon = "🏠",
            onDashboardClick = onNavigateToHome
        )

        // List of Service Catalog cards (matching Screenshot 6)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(OrvakalData.servicesCatalog) { category ->
                ServiceCatalogCard(
                    category = category,
                    onClick = { onNavigateToCategory(category.categoryKey) }
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ServiceCatalogCard(
    category: CatalogCategory,
    onClick: () -> Unit
) {
    val isDark = ThemeManager.isDarkMode

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDark) Color(0xFF1E1E1E) else Color(0xFFEDF7F9)
        ),
        border = CardDefaults.outlinedCardBorder().copy(
            brush = androidx.compose.ui.graphics.SolidColor(
                if (isDark) Color(0xFF004D40) else Color(0xFFBCE3E8)
            )
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isDark) Color(0xFF004D40) else Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = category.icon,
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            // Text Info
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = category.localizedTitle,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (isDark) Color.White else Color(0xFF003740)
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = category.localizedDesc,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    color = if (isDark) Color(0xFFCFD8DC) else Color(0xFF455A64)
                )
            }
        }
    }
}
