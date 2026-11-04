package com.orvakal.app.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.orvakal.app.domain.language.AppLanguage
import com.orvakal.app.domain.language.AppStrings
import com.orvakal.app.domain.language.LanguageManager
import com.orvakal.app.presentation.theme.ThemeManager

val OrvakalDarkGreen = Color(0xFF004D40) // Rich dark green (Teal 900) for sub-headers

val OrvakalTealDark: Color
    get() = if (ThemeManager.isDarkMode) Color(0xFF80DEEA) else Color(0xFF004D5A)
val OrvakalTeal = Color(0xFF006778)
val OrvakalTealLight = Color(0xFFE0F2F1)
val OrvakalBg: Color
    get() = if (ThemeManager.isDarkMode) Color(0xFF0F172A) else Color(0xFFF3F7F8)

@Composable
fun OrvakalSubHeader(
    title: String,
    onBack: () -> Unit,
    onNavigateToHome: (() -> Unit)? = null,
    actions: (@Composable () -> Unit)? = null
) {
    Surface(
        color = OrvakalDarkGreen,
        shadowElevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            if (actions != null) {
                actions()
            } else if (onNavigateToHome != null) {
                IconButton(
                    onClick = onNavigateToHome,
                    modifier = Modifier.size(38.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = "Home",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun OrvakalTopHeader(
    modifier: Modifier = Modifier,
    onLogoClick: (() -> Unit)? = null
) {
    val currentLang = LanguageManager.currentLanguage
    var showPrivacyDialog by remember { mutableStateOf(false) }
    var showNotificationsDialog by remember { mutableStateOf(false) }

    if (showPrivacyDialog) {
        PrivacyPolicyDialog(onDismiss = { showPrivacyDialog = false })
    }

    if (showNotificationsDialog) {
        NotificationsDialog(onDismiss = { showNotificationsDialog = false })
    }

    Surface(
        color = if (ThemeManager.isDarkMode) Color(0xFF1E293B) else Color.White,
        shadowElevation = 1.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
            // Left: Logo + Title (clickable for mandal profile or policy)
            Row(
                modifier = Modifier
                    .weight(1f, fill = false)
                    .clickable {
                        if (onLogoClick != null) {
                            onLogoClick()
                        } else {
                            showPrivacyDialog = true
                        }
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                OrvakalLogo(size = 36.dp)
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = AppStrings.portalTitle,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Black,
                        color = if (ThemeManager.isDarkMode) Color(0xFF80CBC4) else OrvakalTealDark,
                        letterSpacing = 0.5.sp
                    )
                    Text(
                        text = AppStrings.portalSubtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = if (ThemeManager.isDarkMode) Color(0xFFCBD5E1) else Color(0xFF5A737D),
                        fontSize = 10.sp
                    )
                }
            }

            // Right: Language Selector in Native Scripts + Theme Toggle + Shield (Privacy) + Notification
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                // Language selection buttons with text in native language
                val languages = listOf(
                    AppLanguage.EN to "Eng",
                    AppLanguage.TE to "తెలుగు",
                    AppLanguage.HI to "हिंदी"
                )

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (ThemeManager.isDarkMode) Color(0xFF334155) else Color(0xFFF0F4F6))
                        .padding(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    languages.forEach { (lang, nativeLabel) ->
                        val isSelected = currentLang == lang
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(if (isSelected) OrvakalTeal else Color.Transparent)
                                .clickable { LanguageManager.setLanguage(lang) }
                                .padding(horizontal = 6.dp, vertical = 3.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = nativeLabel,
                                fontSize = 10.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                color = if (isSelected) Color.White else if (ThemeManager.isDarkMode) Color(0xFFCBD5E1) else Color(0xFF455A64)
                            )
                        }
                    }
                }

                // Privacy / Disclaimers Shield icon
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .border(1.dp, if (ThemeManager.isDarkMode) Color(0xFF00796B) else Color(0xFFB2DFDB), CircleShape)
                        .background(if (ThemeManager.isDarkMode) Color(0xFF004D40) else Color(0xFFE0F2F1))
                        .clickable { showPrivacyDialog = true },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Shield,
                        contentDescription = "Privacy & Policy",
                        modifier = Modifier.size(16.dp),
                        tint = if (ThemeManager.isDarkMode) Color(0xFF80CBC4) else Color(0xFF006778)
                    )
                }

                // Dark mode theme toggle icon
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .border(1.dp, if (ThemeManager.isDarkMode) Color(0xFF475569) else Color(0xFFCFD8DC), CircleShape)
                        .background(if (ThemeManager.isDarkMode) Color(0xFF334155) else Color(0xFFF0F4F6))
                        .clickable { ThemeManager.toggleDarkMode() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (ThemeManager.isDarkMode) Icons.Outlined.LightMode else Icons.Outlined.DarkMode,
                        contentDescription = "Toggle Dark Mode",
                        modifier = Modifier.size(16.dp),
                        tint = if (ThemeManager.isDarkMode) Color(0xFFFFD54F) else Color(0xFF37474F)
                    )
                }

                // Notification bell icon with red dot
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .border(1.dp, if (ThemeManager.isDarkMode) Color(0xFF475569) else Color(0xFFCFD8DC), CircleShape)
                        .background(if (ThemeManager.isDarkMode) Color(0xFF334155) else Color(0xFFF0F4F6))
                        .clickable { showNotificationsDialog = true },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = "Notifications",
                        modifier = Modifier.size(16.dp),
                        tint = if (ThemeManager.isDarkMode) Color(0xFFE2E8F0) else Color(0xFF37474F)
                    )
                    // Red notification badge dot
                    Box(
                        modifier = Modifier
                            .size(7.dp)
                            .align(Alignment.TopEnd)
                            .offset(x = (-2).dp, y = 2.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFE53935))
                    )
                }
            }
        }
        }
    }
}

@Composable
fun ScreenHeaderRow(
    title: String,
    icon: String,
    onDashboardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = icon,
                fontSize = 22.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = if (ThemeManager.isDarkMode) Color(0xFFFFFFFF) else Color(0xFF0F172A)
            )
        }

        // Dashboard Pill Button
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(if (ThemeManager.isDarkMode) Color(0xFF004D40) else Color(0xFFE8F5F5))
                .border(1.dp, if (ThemeManager.isDarkMode) Color(0xFF00796B) else Color(0xFFB2DFDB), RoundedCornerShape(8.dp))
                .clickable { onDashboardClick() }
                .padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "🏠",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = AppStrings.dashboard,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = if (ThemeManager.isDarkMode) Color(0xFF80CBC4) else Color(0xFF006778)
            )
        }
    }
}
