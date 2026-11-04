$base = 'C:\Users\mlpkr\.gemini\antigravity-acp\brain\7eafd41c-f232-4cdb-aeb3-7b64d05a409d\.system_generated\steps'
$target = 'play_store_assets'

Copy-Item -Path "$base\2404\media_0.png" -Destination "$target\screenshot_01_home_dashboard.png" -Force
Copy-Item -Path "$base\2408\media_0.png" -Destination "$target\screenshot_02_industrial_hub_topology.png" -Force
Copy-Item -Path "$base\2418\media_0.png" -Destination "$target\screenshot_03_farmer_mandi_rates.png" -Force
Copy-Item -Path "$base\1924\media_0.png" -Destination "$target\screenshot_04_mandal_profile_23villages.png" -Force
Copy-Item -Path "$base\1661\media_0.png" -Destination "$target\screenshot_05_civic_services_explore.png" -Force
Copy-Item -Path "$base\1208\media_0.png" -Destination "$target\screenshot_06_daily_utilities.png" -Force
Copy-Item -Path "$base\2412\media_0.png" -Destination "$target\screenshot_07_dark_mode_theme.png" -Force

Get-ChildItem $target | Select-Object Name, Length
