# Google Play Console Submission Guide & Store Listing Package
**Application:** Orvakal: Village & Smart Digital Hub  
**Developer Team:** Orvakal Community & Civic Portal Team  
**Contact Email:** prasanna.tws@gmail.com  
**Package Name:** `com.digitalhub.orvakal`  
**Target SDK:** 36 (Android 16) — Complies with Google Play target API requirements  
**Minimum SDK:** 24 (Android 7.0+)  

---

## 1. App Store Listing Metadata

### A. App Title
*Official Title:*
```
Orvakal: Village & Smart Digital Hub
```

> [!NOTE] 
> **Google Play Console 30-Character Limit Notice:**  
> Google Play Console has a strict 30-character hard limit on the Store Listing "Title" input field (36 characters will trigger a warning in the console). If entering into the console's 30-character box, use:
> - **`Orvakal: Village & Smart Hub`** (28 chars — exact fit!)
> - or **`Orvakal: Smart Village Hub`** (26 chars)
> 
> The full title **"Orvakal: Village & Smart Digital Hub"** is prominently displayed in the Short Description, Full Description, and within the App itself.

### B. Short Description (Max 80 characters)
```
Orvakal: Village & Smart Digital Hub with farmer tools, industries & services.
```

### C. Full Description (Max 4000 characters)
*Copy and paste the exact text below into Google Play Console's Full Description box:*

```text
Welcome to Orvakal: Village & Smart Digital Hub — your all-in-one local community companion for Orvakal Mandal, Kurnool District, Andhra Pradesh.

Designed to serve villagers, farmers, youth, job seekers, small business owners, and industrial visitors, this smart digital portal brings essential village services, agricultural tools, industrial insights, and civic directories straight to your mobile phone in English, Telugu (తెలుగు), and Hindi (हिंदी).

═══════════════════════════════════════
⚠️ IMPORTANT GOVERNMENT DISCLAIMER
═══════════════════════════════════════
Orvakal: Village & Smart Digital Hub is an INDEPENDENT COMMUNITY APPLICATION developed for civic and informational purposes. 

This application is NOT affiliated with, authorized by, endorsed by, or in any way representing the Government of Andhra Pradesh, the Government of India, or any official government agency. 

All welfare schemes, public helpline contacts, electricity feeder schedules, and agricultural market rates provided in this app are referenced from officially published, publicly accessible government domains:
• AP State Portal: https://ap.gov.in
• National Portal of India: https://india.gov.in
• Agmarknet (Mandi Rates): https://agmarknet.gov.in
• APSPDCL Power Utility: https://www.apspdcl.in
• Kurnool District Administration: https://kurnool.ap.gov.in
• MeeSeva Citizen Services: https://meeseva.gov.in

═══════════════════════════════════════
KEY FEATURES
═══════════════════════════════════════

🌾 FARMER DESK & AGRICULTURE
• Agri Mandi Rates: Daily commodity rates and market price trends for Onion, Chilli, Groundnut, Cotton, Bengal Gram, Tomato, and Jowar.
• Minimum Support Price (MSP): Official central and state government benchmark rates.
• Power Feeder Schedule: 3-phase agricultural day and night power supply timings across Orvakal, Kalva, and Budawada feeders.
• Tractor & Machinery Sharing: Connect with local tractor and harvester operators.
• Local Borewell & Mechanic Directory: Quick assistance for pump repairs and farm implements.

🏭 ORVAKAL INDUSTRIAL HUB & JOBS
• Mega Industrial Directory: Profiles of Greenko Ultra Mega Solar Park (1000+ MW), UltraTech Cement, Ramco Cement, and Kurnool Mega Food Park.
• Local Job Board & Labour Registry: Employment notices for plant operators, logistics, drivers, and solar field technicians.
• Investor Desk: Industrial corridor connectivity, water allocation, and infrastructure data.

🏛️ CIVIC INFORMATION & SCHEMES
• Government Welfare Schemes Guide: Detailed eligibility, benefits, and application guidelines for YSR Rythu Bharosa / PM-KISAN, PM Awas Yojana, Deepam scheme, Post Office savings, and bank MSME loans.
• Panchayat & Citizen Desk: Guidance for filing civic requests, property records, and Rythu Bharosa Kendras.
• Emergency SOS Directory: 1-tap call access to Police (100), Ambulance (108), Fire (101), PHC Doctor, Tahsildar, and Feeder breakdowns.

🛠️ DAILY UTILITY SUITE
• Village Interest Calculator: Calculate local village finance interest (రూపాయి వడ్డీ / Rupees per 100 per month).
• Land Unit Converter: Convert Guntas, Cents, Acres, Bigha, and Square Yards instantly.
• Stopwatch & Count-up Timer for work and sports.
• Local Services Directory: Grocery (Kiranam), pharmacies, schools, milk booths, cloth stores, and function halls.

🌐 MULTILINGUAL & OFFLINE READY
• Switch seamlessly between English, Telugu, and Hindi at any time.
• Works quickly on low-bandwidth 2G/3G/4G rural networks.
• No account registration or login required — completely private and anonymous.

Download the Orvakal Village Portal today and stay connected with your local community!
```

---

## 2. Privacy Policy URL
Google Play Console requires a public URL pointing to your Privacy Policy.
- **Hosted HTML File:** We created `privacy_policy.html` in your project root.
- **Easy Free Hosting Options:**
  1. **GitHub Pages (Recommended):** If your project is on GitHub, push `privacy_policy.html` to a repository and enable GitHub Pages in Settings -> Pages. Your URL will be: `https://<username>.github.io/<repo>/privacy_policy.html`.
  2. **Google Sites / Firebase Hosting:** Paste the text into a free Google Site or host via Firebase (`firebase deploy`).

---

## 3. Play Console: Data Safety Form (Exact Answers)

When filling out the **Data safety** questionnaire in Google Play Console, select the following answers:

| Question | Answer | Explanation |
| :--- | :--- | :--- |
| **Does your app collect or share any of the required user data types?** | **No** | The app does not collect personal, device, or financial data. |
| **Is all user data collected by your app encrypted in transit?** | **Yes** | All network requests use HTTPS/TLS. |
| **Do you provide a way for users to request that their data be deleted?** | **No** (or choose: "No data is collected") | Because no user data is collected or stored, account/data deletion is not applicable. |

---

## 4. Play Console: App Content & Declarations

Go to **Policy** -> **App Content** in the Play Console sidebar and answer each questionnaire as follows:

1. **Government Apps:**
   - Select: **"No, this app does not represent a government entity"**.
   - *Note:* Because we have prominent disclaimers and public source citations both in the store description and inside the app, the app will pass the review smoothly.
2. **Financial Features:**
   - Select: **"My app does not provide any financial features"** (The interest calculator is an offline mathematical utility, not a banking or lending service).
3. **News App:**
   - Select: **"No"**.
4. **Ads:**
   - Select: **"No, my app does not contain ads"**.
   - In `AndroidManifest.xml`, no advertising ID permission (`com.google.android.gms.permission.AD_ID`) is declared.
5. **App Access:**
   - Select: **"All functionality is available without special access"** (no login credentials required).
6. **Target Audience & Content:**
   - Target age groups: Select **13-15**, **16-17**, and **18 and over** (or 18+).
   - Could your store listing appeal to children? Select **No**.
7. **COVID-19 Contact Tracing & Status:**
   - Select: **"My app is not a COVID-19 contact tracing or status app"**.

---

## 5. App Category & Tags

- **Application Type:** App
- **Category:** **Lifestyle** or **Books & Reference** or **Productivity**
- **Tags (Up to 5):**
  1. Community
  2. Agriculture
  3. Utilities
  4. Local
  5. Productivity
- **Store Listing Contact Details:**
  - Developer Team: `Orvakal Community & Civic Portal Team`
  - Email: `prasanna.tws@gmail.com`
  - Website: (Optional or your hosted policy URL)

---

## 6. How to Build & Sign the Release App Bundle (.aab)

Google Play requires an Android App Bundle (`.aab`) signed with a release keystore.

### Step 1: Generate a Release Keystore (Run once in PowerShell or CMD)
```powershell
keytool -genkey -v -keystore orvakal-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias orvakal -storepass YourPassword123 -keypass YourPassword123 -dname "CN=Orvakal Portal, OU=Mobile, O=Orvakal, L=Kurnool, ST=Andhra Pradesh, C=IN"
```

### Step 2: Configure Signing in `app/build.gradle.kts`
Add your keystore details into `app/build.gradle.kts`:
```kotlin
android {
    ...
    signingConfigs {
        create("release") {
            storeFile = file("orvakal-release-key.jks")
            storePassword = "YourPassword123"
            keyAlias = "orvakal"
            keyPassword = "YourPassword123"
        }
    }
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}
```

### Step 3: Build the Release Bundle
Run:
```powershell
./gradlew :app:bundleRelease
```
The final bundle is generated at:
```
app/build/outputs/bundle/release/app-release.aab
```
*Upload this `app-release.aab` file directly to Google Play Console under **Production** -> **Create new release**.*
