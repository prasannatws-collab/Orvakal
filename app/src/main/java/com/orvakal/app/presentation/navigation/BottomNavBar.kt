package com.orvakal.app.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.material.icons.outlined.Storefront
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.orvakal.app.domain.language.AppStrings
import com.orvakal.app.domain.language.LanguageManager

data class BottomNavItem(
    val label: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@Composable
fun BottomNavBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentLang = LanguageManager.currentLanguage

    val items = remember(currentLang) {
        listOf(
            BottomNavItem(
                label = AppStrings.navHome,
                route = Screen.Home.route,
                selectedIcon = Icons.Filled.GridView,
                unselectedIcon = Icons.Outlined.GridView
            ),
            BottomNavItem(
                label = AppStrings.navGovtInfo,
                route = Screen.InfoHub.route,
                selectedIcon = Icons.Filled.AccountBalance,
                unselectedIcon = Icons.Outlined.AccountBalance
            ),
            BottomNavItem(
                label = AppStrings.navFarmer,
                route = Screen.FarmerDesk.route,
                selectedIcon = Icons.Filled.Spa,
                unselectedIcon = Icons.Outlined.Spa
            ),
            BottomNavItem(
                label = AppStrings.navServices,
                route = Screen.Services.route,
                selectedIcon = Icons.Filled.Storefront,
                unselectedIcon = Icons.Outlined.Storefront
            ),
            BottomNavItem(
                label = AppStrings.navJobs,
                route = Screen.Jobs.route,
                selectedIcon = Icons.Filled.Work,
                unselectedIcon = Icons.Outlined.WorkOutline
            )
        )
    }

    val isDark = com.orvakal.app.presentation.theme.ThemeManager.isDarkMode

    Surface(
        color = if (isDark) Color(0xFF1E1E1E) else Color.White,
        shadowElevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                val selected = currentRoute == item.route
                val activeColor = if (isDark) Color(0xFF80CBC4) else Color(0xFF006778)
                val inactiveColor = if (isDark) Color(0xFF94A3B8) else Color(0xFF546E7A)
                val label = item.label

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .clickable {
                            if (item.route == Screen.Home.route) {
                                navController.navigate(Screen.Home.route) {
                                    popUpTo(Screen.Home.route) { inclusive = false }
                                    launchSingleTop = true
                                }
                            } else if (currentRoute != item.route) {
                                navController.navigate(item.route) {
                                    popUpTo(Screen.Home.route) { inclusive = false }
                                    launchSingleTop = true
                                }
                            }
                        }
                        .padding(vertical = 6.dp)
                ) {
                    // Active top indicator bar (Screenshot matching)
                    Box(
                        modifier = Modifier
                            .size(width = 34.dp, height = 3.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(if (selected) activeColor else Color.Transparent)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Icon(
                        imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = label,
                        tint = if (selected) activeColor else inactiveColor,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = label,
                        fontSize = 11.sp,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                        color = if (selected) {
                            if (isDark) Color(0xFFFFFFFF) else Color(0xFF004D5A)
                        } else {
                            if (isDark) Color(0xFFCBD5E1) else Color(0xFF546E7A)
                        }
                    )
                }
            }
        }
    }
}
