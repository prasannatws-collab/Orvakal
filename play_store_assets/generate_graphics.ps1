Add-Type -AssemblyName System.Drawing

# 1. GENERATE APP ICON (512x512 PNG)
$iconSize = 512
$iconBmp = New-Object System.Drawing.Bitmap $iconSize, $iconSize
$g = [System.Drawing.Graphics]::FromImage($iconBmp)
$g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
$g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::AntiAliasGridFit
$g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic

# Background: Rounded modern deep teal container
$pt1 = New-Object System.Drawing.PointF 0.0, 0.0
$pt2 = New-Object System.Drawing.PointF ([float]$iconSize), ([float]$iconSize)
$bgBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    $pt1,
    $pt2,
    [System.Drawing.ColorTranslator]::FromHtml("#003840"),
    [System.Drawing.ColorTranslator]::FromHtml("#001B22")
)
$g.FillRectangle($bgBrush, 0, 0, $iconSize, $iconSize)

# Center point for the Orvakal Sun/Leaf Emblem
[float]$cx = 256.0
[float]$cy = 226.0
[float]$radius = 160.0
[float]$strokeW = 28.0

# Circular 12-segment ring
$segmentColors = @(
    "#00ACC1", "#0097A7", "#00897B", "#26A69A",
    "#43A047", "#7CB342", "#9E9D24", "#C0CA33",
    "#80CBC4", "#4DD0E1", "#26C6DA", "#00BCD4"
)

for ($i = 0; $i -lt 12; $i++) {
    [float]$startAngle = ($i * 30.0) + 5.0
    [float]$sweepAngle = 20.0
    $col = [System.Drawing.ColorTranslator]::FromHtml($segmentColors[$i])
    $pen = New-Object System.Drawing.Pen $col, $strokeW
    $pen.StartCap = [System.Drawing.Drawing2D.LineCap]::Round
    $pen.EndCap = [System.Drawing.Drawing2D.LineCap]::Round
    $g.DrawArc($pen, [float]($cx - $radius), [float]($cy - $radius), [float]($radius * 2.0), [float]($radius * 2.0), $startAngle, $sweepAngle)
    $pen.Dispose()
}

# Inner Sun Circle with Radial Gradient
[float]$sunRadius = 100.0
$sunPath = New-Object System.Drawing.Drawing2D.GraphicsPath
$sunPath.AddEllipse([float]($cx - $sunRadius), [float]($cy - $sunRadius), [float]($sunRadius * 2.0), [float]($sunRadius * 2.0))
$sunBrush = New-Object System.Drawing.Drawing2D.PathGradientBrush($sunPath)
$sunBrush.CenterColor = [System.Drawing.ColorTranslator]::FromHtml("#FFA726")
$sunBrush.SurroundColors = @([System.Drawing.ColorTranslator]::FromHtml("#E65100"))
$g.FillEllipse($sunBrush, [float]($cx - $sunRadius), [float]($cy - $sunRadius), [float]($sunRadius * 2.0), [float]($sunRadius * 2.0))
$sunBrush.Dispose()
$sunPath.Dispose()

# Green Leaf in Center
$leafBrush = New-Object System.Drawing.SolidBrush([System.Drawing.ColorTranslator]::FromHtml("#2E7D32"))
$leafPath = New-Object System.Drawing.Drawing2D.GraphicsPath
$p1 = New-Object System.Drawing.PointF $cx, ($cy - 45.0)
$p2 = New-Object System.Drawing.PointF ($cx + 45.0), ($cy - 10.0)
$p3 = New-Object System.Drawing.PointF ($cx + 45.0), ($cy + 55.0)
$p4 = New-Object System.Drawing.PointF $cx, ($cy + 65.0)
$leafPath.AddBezier($p1, $p2, $p3, $p4)

$p5 = New-Object System.Drawing.PointF $cx, ($cy + 65.0)
$p6 = New-Object System.Drawing.PointF ($cx - 45.0), ($cy + 55.0)
$p7 = New-Object System.Drawing.PointF ($cx - 45.0), ($cy - 10.0)
$p8 = New-Object System.Drawing.PointF $cx, ($cy - 45.0)
$leafPath.AddBezier($p5, $p6, $p7, $p8)
$g.FillPath($leafBrush, $leafPath)
$leafBrush.Dispose()
$leafPath.Dispose()

# Leaf Contour accent
$sproutPen = New-Object System.Drawing.Pen([System.Drawing.ColorTranslator]::FromHtml("#81C784"), 8.0)
$g.DrawEllipse($sproutPen, [float]($cx - 15.0), [float]($cy + 5.0), 45.0, 45.0)
$sproutPen.Dispose()

# Text: "ORVAKAL"
$fontFamily = [System.Drawing.FontFamily]::GenericSansSerif
$titleFont = New-Object System.Drawing.Font($fontFamily, 34, [System.Drawing.FontStyle]::Bold)
$titleBrush = New-Object System.Drawing.SolidBrush([System.Drawing.ColorTranslator]::FromHtml("#80DEEA"))
$format = New-Object System.Drawing.StringFormat
$format.Alignment = [System.Drawing.StringAlignment]::Center
$format.LineAlignment = [System.Drawing.StringAlignment]::Center
$ptTitle = New-Object System.Drawing.PointF $cx, ([float]($iconSize - 75))
$g.DrawString("ORVAKAL", $titleFont, $titleBrush, $ptTitle, $format)

# Subtitle: "VILLAGE & SMART HUB"
$subFont = New-Object System.Drawing.Font($fontFamily, 14, [System.Drawing.FontStyle]::Bold)
$subBrush = New-Object System.Drawing.SolidBrush([System.Drawing.ColorTranslator]::FromHtml("#B2DFDB"))
$ptSub = New-Object System.Drawing.PointF $cx, ([float]($iconSize - 35))
$g.DrawString("VILLAGE & SMART HUB", $subFont, $subBrush, $ptSub, $format)

$titleFont.Dispose()
$titleBrush.Dispose()
$subFont.Dispose()
$subBrush.Dispose()
$format.Dispose()
$bgBrush.Dispose()
$g.Dispose()

$iconPath = Join-Path (Get-Location) "play_store_assets\app_icon_512x512.png"
$iconBmp.Save($iconPath, [System.Drawing.Imaging.ImageFormat]::Png)
$iconBmp.Dispose()
Write-Output "SUCCESS: $iconPath"


# 2. GENERATE FEATURE GRAPHIC (1024x500 PNG)
$fw = 1024
$fh = 500
$featBmp = New-Object System.Drawing.Bitmap $fw, $fh
$g2 = [System.Drawing.Graphics]::FromImage($featBmp)
$g2.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
$g2.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::AntiAliasGridFit

# Rich modern gradient background
$fpt1 = New-Object System.Drawing.PointF 0.0, 0.0
$fpt2 = New-Object System.Drawing.PointF ([float]$fw), ([float]$fh)
$featBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    $fpt1,
    $fpt2,
    [System.Drawing.ColorTranslator]::FromHtml("#00242B"),
    [System.Drawing.ColorTranslator]::FromHtml("#004754")
)
$g2.FillRectangle($featBrush, 0, 0, $fw, $fh)
$featBrush.Dispose()

# Decorative diagonal circuit/corridor lines
$decPen = New-Object System.Drawing.Pen([System.Drawing.ColorTranslator]::FromHtml("#005D6E"), 2.0)
for ($d = -200; $d -lt ($fw + 400); $d += 80) {
    $g2.DrawLine($decPen, $d, 0, ($d + 300), $fh)
}
$decPen.Dispose()

# Dark overlay panel for text readability
$panelBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(220, 0, 32, 38))
$g2.FillRectangle($panelBrush, 30, 30, ($fw - 60), ($fh - 60))
$panelBrush.Dispose()

$panelBorder = New-Object System.Drawing.Pen([System.Drawing.ColorTranslator]::FromHtml("#006778"), 2.0)
$g2.DrawRectangle($panelBorder, 30, 30, ($fw - 60), ($fh - 60))
$panelBorder.Dispose()

# Left Emblem
[float]$ecx = 160.0
[float]$ecy = 210.0
[float]$eradius = 95.0
[float]$estroke = 16.0

for ($i = 0; $i -lt 12; $i++) {
    [float]$startAngle = ($i * 30.0) + 5.0
    $col = [System.Drawing.ColorTranslator]::FromHtml($segmentColors[$i])
    $pen = New-Object System.Drawing.Pen $col, $estroke
    $pen.StartCap = [System.Drawing.Drawing2D.LineCap]::Round
    $pen.EndCap = [System.Drawing.Drawing2D.LineCap]::Round
    $g2.DrawArc($pen, [float]($ecx - $eradius), [float]($ecy - $eradius), [float]($eradius * 2.0), [float]($eradius * 2.0), $startAngle, 20.0)
    $pen.Dispose()
}

[float]$esunRadius = 60.0
$esunPt1 = New-Object System.Drawing.PointF ($ecx - $esunRadius), ($ecy - $esunRadius)
$esunPt2 = New-Object System.Drawing.PointF ($ecx + $esunRadius), ($ecy + $esunRadius)
$esunBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    $esunPt1,
    $esunPt2,
    [System.Drawing.ColorTranslator]::FromHtml("#FFA726"),
    [System.Drawing.ColorTranslator]::FromHtml("#E65100")
)
$g2.FillEllipse($esunBrush, [float]($ecx - $esunRadius), [float]($ecy - $esunRadius), [float]($esunRadius * 2.0), [float]($esunRadius * 2.0))
$esunBrush.Dispose()

# Emblem inner leaf
$eleafBrush = New-Object System.Drawing.SolidBrush([System.Drawing.ColorTranslator]::FromHtml("#2E7D32"))
$eleafPath = New-Object System.Drawing.Drawing2D.GraphicsPath
$ep1 = New-Object System.Drawing.PointF $ecx, ($ecy - 25.0)
$ep2 = New-Object System.Drawing.PointF ($ecx + 25.0), ($ecy - 5.0)
$ep3 = New-Object System.Drawing.PointF ($ecx + 25.0), ($ecy + 30.0)
$ep4 = New-Object System.Drawing.PointF $ecx, ($ecy + 38.0)
$eleafPath.AddBezier($ep1, $ep2, $ep3, $ep4)

$ep5 = New-Object System.Drawing.PointF $ecx, ($ecy + 38.0)
$ep6 = New-Object System.Drawing.PointF ($ecx - 25.0), ($ecy + 30.0)
$ep7 = New-Object System.Drawing.PointF ($ecx - 25.0), ($ecy - 5.0)
$ep8 = New-Object System.Drawing.PointF $ecx, ($ecy - 25.0)
$eleafPath.AddBezier($ep5, $ep6, $ep7, $ep8)
$g2.FillPath($eleafBrush, $eleafPath)
$eleafBrush.Dispose()
$eleafPath.Dispose()

# Right Side Typography
$h1Font = New-Object System.Drawing.Font($fontFamily, 36, [System.Drawing.FontStyle]::Bold)
$h1Brush = New-Object System.Drawing.SolidBrush([System.Drawing.ColorTranslator]::FromHtml("#FFFFFF"))
$g2.DrawString("ORVAKAL", $h1Font, $h1Brush, 290, 75)

$h2Font = New-Object System.Drawing.Font($fontFamily, 22, [System.Drawing.FontStyle]::Bold)
$h2Brush = New-Object System.Drawing.SolidBrush([System.Drawing.ColorTranslator]::FromHtml("#80CBC4"))
$g2.DrawString("Village & Smart Digital Hub", $h2Font, $h2Brush, 290, 135)

$h3Font = New-Object System.Drawing.Font($fontFamily, 14, [System.Drawing.FontStyle]::Regular)
$h3Brush = New-Object System.Drawing.SolidBrush([System.Drawing.ColorTranslator]::FromHtml("#B0BEC5"))
$g2.DrawString("Rayalaseema's Premier Industrial & Rural Community Portal", $h3Font, $h3Brush, 290, 185)
$g2.DrawString("Kurnool District, Andhra Pradesh • 23 Villages Connected", $h3Font, $h3Brush, 290, 215)

# Badges across the bottom
$badgeFont = New-Object System.Drawing.Font($fontFamily, 11, [System.Drawing.FontStyle]::Bold)
$badgeBg = New-Object System.Drawing.SolidBrush([System.Drawing.ColorTranslator]::FromHtml("#004D5A"))
$badgeBorder = New-Object System.Drawing.Pen([System.Drawing.ColorTranslator]::FromHtml("#00838F"), 1.5)
$badgeText = New-Object System.Drawing.SolidBrush([System.Drawing.ColorTranslator]::FromHtml("#E0F7FA"))

$badges = @(
    "🌾 Farmer Desk & Live Mandi",
    "🏭 Industrial Hub & Jobs",
    "🏛️ 23-Village Civic Directory",
    "🌐 Eng • Telugu • Hindi"
)

$bx = 60
$by = 365
$bw = 215
$bh = 55
$bsp = 15

for ($b = 0; $b -lt $badges.Length; $b++) {
    $curX = $bx + ($b * ($bw + $bsp))
    $g2.FillRectangle($badgeBg, $curX, $by, $bw, $bh)
    $g2.DrawRectangle($badgeBorder, $curX, $by, $bw, $bh)

    $sf = New-Object System.Drawing.StringFormat
    $sf.Alignment = [System.Drawing.StringAlignment]::Center
    $sf.LineAlignment = [System.Drawing.StringAlignment]::Center
    $rect = New-Object System.Drawing.RectangleF $curX, $by, $bw, $bh
    $g2.DrawString($badges[$b], $badgeFont, $badgeText, $rect, $sf)
    $sf.Dispose()
}

$badgeFont.Dispose()
$badgeBg.Dispose()
$badgeBorder.Dispose()
$badgeText.Dispose()

$h1Font.Dispose()
$h1Brush.Dispose()
$h2Font.Dispose()
$h2Brush.Dispose()
$h3Font.Dispose()
$h3Brush.Dispose()
$g2.Dispose()

$featPath = Join-Path (Get-Location) "play_store_assets\feature_graphic_1024x500.png"
$featBmp.Save($featPath, [System.Drawing.Imaging.ImageFormat]::Png)
$featBmp.Dispose()
Write-Output "SUCCESS: $featPath"
