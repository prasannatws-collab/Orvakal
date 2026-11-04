package com.orvakal.app.presentation.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun OrvakalLogo(
    modifier: Modifier = Modifier,
    size: Dp = 36.dp
) {
    Canvas(modifier = modifier.size(size)) {
        val w = this.size.width
        val h = this.size.height
        val center = Offset(w / 2f, h / 2f)
        val outerRadius = w * 0.44f
        val strokeWidth = w * 0.08f

        // 12 circular dashed segments
        val segments = 12
        val sweepAngle = 20f
        val segmentColors = listOf(
            Color(0xFF00ACC1), // Cyan/Teal
            Color(0xFF0097A7),
            Color(0xFF00897B),
            Color(0xFF26A69A),
            Color(0xFF43A047),
            Color(0xFF7CB342),
            Color(0xFF9E9D24),
            Color(0xFFC0CA33),
            Color(0xFF80CBC4),
            Color(0xFF4DD0E1),
            Color(0xFF26C6DA),
            Color(0xFF00BCD4)
        )

        for (i in 0 until segments) {
            val startAngle = i * (360f / segments) + 5f
            val color = segmentColors[i % segmentColors.size]
            drawArc(
                color = color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = Offset(center.x - outerRadius, center.y - outerRadius),
                size = Size(outerRadius * 2, outerRadius * 2),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }

        // Inner Sun Circle
        val sunRadius = w * 0.28f
        val sunCenter = Offset(center.x, center.y * 0.95f)
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color(0xFFFFA726), Color(0xFFF57C00), Color(0xFFE65100)),
                center = sunCenter,
                radius = sunRadius
            ),
            radius = sunRadius,
            center = sunCenter
        )

        // Green Leaf in the center/bottom
        val leafPath = Path().apply {
            val lx = center.x
            val ly = center.y + (w * 0.08f)
            val lw = w * 0.16f
            val lh = w * 0.22f

            moveTo(lx, ly - lh * 0.5f)
            cubicTo(
                lx + lw, ly - lh * 0.2f,
                lx + lw, ly + lh * 0.5f,
                lx, ly + lh * 0.6f
            )
            cubicTo(
                lx - lw, ly + lh * 0.5f,
                lx - lw, ly - lh * 0.2f,
                lx, ly - lh * 0.5f
            )
            close()
        }
        drawPath(
            path = leafPath,
            color = Color(0xFF2E7D32)
        )

        // Loop / Sprout contour
        val loopRadius = w * 0.09f
        drawCircle(
            color = Color(0xFF81C784),
            radius = loopRadius,
            center = Offset(center.x + w * 0.05f, center.y + w * 0.02f),
            style = Stroke(width = w * 0.035f)
        )
    }
}
