# Orvakal

A production-ready Android application built with Jetpack Compose and Clean Architecture.

## Overview

Orvakal is a digital services hub that provides citizens with easy access to various services including Education, Healthcare, Agriculture, Government, Finance, and Transport.

## Architecture

This project follows **Clean Architecture** principles with three distinct layers:

```
app/
├── data/           # Data Layer
│   ├── remote/     # API services and DTOs
│   ├── local/      # Room database, DAOs, entities
│   └── repository/ # Repository implementations
├── domain/         # Domain Layer
│   ├── model/      # Domain entities
│   ├── repository/ # Repository interfaces
│   └── usecase/    # Business logic use cases
└── presentation/   # Presentation Layer
    ├── navigation/ # Navigation graph and components
    ├── theme/      # Material3 theme
    ├── splash/     # Splash screen
    ├── home/       # Home dashboard
    ├── services/   # Services grid
    ├── detail/     # Service detail
    └── profile/    # User profile
```

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Kotlin | 1.9.23 | Programming language |
| Jetpack Compose BOM | 2024.02.00 | UI framework |
| Material3 | BOM | Design system |
| Hilt | 2.51.1 | Dependency Injection |
| Retrofit | 2.11.0 | Network requests |
| OkHttp | 4.12.0 | HTTP client |
| Room | 2.6.1 | Local database |
| Navigation Compose | 2.7.7 | In-app navigation |
| Coil | 2.6.0 | Image loading |
| Coroutines | 1.8.0 | Async programming |

## Screens

1. **Splash Screen** — Animated app logo with branding
2. **Home Screen** — Dashboard with welcome card and service categories
3. **Services Screen** — Grid layout of all available services
4. **Detail Screen** — Detailed view of a selected service
5. **Profile Screen** — User profile with settings

## Getting Started

### Prerequisites
- Android Studio Hedgehog or newer
- JDK 17+
- Android SDK 34

### Setup
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle
4. Run on emulator or device (API 24+)

## Build

```bash
./gradlew assembleDebug
```

## License

Copyright © 2024 Orvakal. All rights reserved.
