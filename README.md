# Beauty App

A native Android e-commerce application for browsing beauty products, managing favorites and cart items, and maintaining a user profile.

## Overview

Beauty App is a Kotlin-based Android application built with Jetpack Compose. It focuses on modern Android UI development, reactive state management, MVVM, and separation of data access through the Repository Pattern.

The current implementation uses local fake data rather than a remote backend, so the project can run without external API credentials.

## Features

- Phone-number-based login flow with session state persistence.
- Social login interface for Google, Facebook, and Twitter.
- Reactive home product grid.
- Category browsing and category-specific product lists.
- Product details with pricing, descriptions, quantity selection, and favorites.
- Add, update, and remove cart items.
- Live cart subtotal and item count.
- Favorites management.
- Editable user profile.
- Profile image interface.
- Bottom navigation across the main application sections.

## Architecture

The project uses MVVM with the Repository Pattern and separates responsibilities into data, domain, and presentation layers.

```text
com.beautyapp
├── data
│   ├── repo
│   └── source
├── domain
│   ├── model
│   └── repo
└── presentation
    ├── screens
    ├── viewmodels
    └── navigation
```

## State Management

The project uses `mutableStateOf`, `mutableStateListOf`, and `StateFlow` to propagate state changes from the data layer through ViewModels to Compose screens.

## Navigation

```text
Splash
  |
Login
  |
Home
├── Categories
│   └── Category Products
│       └── Product Details
├── Favorites
├── Cart
└── Profile
```

## Technology Stack

| Area | Technology |
|---|---|
| Language | Kotlin |
| UI | Jetpack Compose |
| Architecture | MVVM |
| Data Access | Repository Pattern |
| State | Compose State, StateFlow |
| Navigation | Navigation Compose |
| Data Source | Local FakeData |
| Dependency Injection | Manual ViewModel factory approach |

## Getting Started

### Prerequisites

- Android Studio
- Kotlin-compatible Android tooling
- Android SDK
- Android emulator or physical device

### Clone

```bash
git clone https://github.com/hala-dalloul/New-Salon.git
cd New-Salon
```

Open the project in Android Studio and allow Gradle synchronization to complete.

### Build

```bash
./gradlew assembleDebug
```

Windows:

```powershell
.\gradlew.bat assembleDebug
```

No external backend or API key is required by the current fake-data implementation.

## Development Notes

The local `FakeData` source is isolated behind repository interfaces, allowing it to be replaced with a remote implementation without coupling Compose screens directly to a backend.

Potential improvements include Retrofit/OkHttp API integration, Room persistence, Hilt, unit tests, real authentication, dark mode, and localization.

## What This Project Demonstrates

- Kotlin Android development.
- Jetpack Compose.
- MVVM architecture.
- Repository-based data access.
- Reactive state management.
- Navigation Compose.
- Reusable composable components.
- Cart and favorites state handling.
- Feature-oriented project organization.

## Contributing

1. Fork the repository.
2. Create a focused branch.
3. Implement and test the change.
4. Keep commits descriptive.
5. Open a pull request explaining the change.

Do not commit credentials or generated build artifacts.

## License

No open-source license is currently defined for this repository.

If external reuse or contributions are intended, an explicit license should be added.

## Author

Hala Dalloul

GitHub: https://github.com/hala-dalloul
