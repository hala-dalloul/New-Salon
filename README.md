<div align="center">

<img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/>
<img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"/>
<img src="https://img.shields.io/badge/UI-Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white"/>
<img src="https://img.shields.io/badge/Architecture-MVVM-FF6B6B?style=for-the-badge"/>
<img src="https://img.shields.io/badge/Pattern-Repository-F7B731?style=for-the-badge"/>

<br/><br/>

# 💄 Beauty App

### A modern, feature-rich Android e-commerce application for beauty products — built with Jetpack Compose, clean MVVM architecture, and a fully reactive UI layer.

<br/>

</div>

---

## 📸 Screenshots

| Splash | Login | Home | Categories |
|--------|-------|------|------------|
| Clean branded entry screen | Phone-based auth with social options | Product grid with favorites | Category browsing with imagery |

| Cart | Favorites | Product Details | Profile |
|------|-----------|-----------------|---------|
| Item management & checkout summary | Filtered loved products | Full details + quantity + buy | Editable user profile |

---

## 🏗️ Architecture Overview

This project follows a strict **Clean Architecture** approach with **MVVM** pattern, separating concerns across three layers:

```
com.beautyapp/
├── data/
│   ├── repo/               # Repository implementations (CartRepoImp, ProductRepoImp, ...)
│   └── source/             # FakeData — mock data layer (mutableStateListOf for reactivity)
├── domain/
│   ├── model/              # Pure Kotlin data models (Product, CartItem, Category, User)
│   └── repo/               # Repository interfaces (CartRepo, ProductRepo, AuthRepo, ...)
└── presentation/
    ├── screens/             # All Composable screens
    ├── viewmodels/          # Screen-scoped ViewModels with state management
    └── navigation/          # NavGraph + BottomNavFun
```

> Every feature module owns its **ViewModel → Repository Interface → Repository Implementation** chain, ensuring zero cross-feature coupling and maximum testability.

---

## ✨ Features

### 🔐 Authentication
- Phone number-based login with session persistence via `AuthRepoImp`
- `loggedInPhone` stored in a `companion object` to survive across repository instances
- Social login UI (Google, Facebook, Twitter)

### 🏠 Home
- Reactive product grid powered by `HomeViewModel` with `mutableStateListOf`
- Inline **favorite toggling** without full recomposition
- `ProductCard` with discount pricing, strike-through formatting, and category resolution

### 🗂️ Categories
- `LazyVerticalGrid` category browser with gradient card overlays
- Deep-linked navigation: `CategoryScreen → CategoryProductsScreen` via `categoryId` path parameter
- `Snackbar` feedback when a category contains zero products
- State-driven loading via `CategoryViewModel` + `StateFlow`

### 🛍️ Product Details
- Full product view: image, description, price breakdown, quantity picker
- `ProductDetailsViewModel` manages product state, quantity tracking, and favorite toggling
- **Add to Cart** persists through `CartRepo`, handling both new items and quantity updates for existing ones
- Instant navigation to cart post-purchase

### 🛒 Cart
- `CartScreen` with `LazyVerticalGrid` and `CartCard` components
- Per-item quantity controls and removal — all routed through `CartRepo`
- Live subtotal calculation in the summary section
- Dynamic cart item count badge in `BeautyTopBar`

### ❤️ Favorites
- Dedicated favorites screen filtered via `getFavoriteProducts` in `ProductRepoImp`
- Reactive updates — toggling favorite on any screen instantly reflects here

### 👤 Profile
- `ConstraintLayout`-based header with profile image + camera overlay
- **Edit Profile BottomSheet** — `ModalBottomSheet` to update name, phone, and email
- `ProfileViewModel` uses `mutableStateOf` for fine-grained state updates
- "My Orders" row navigates directly to the Cart screen

---

## 🧱 Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Kotlin |
| UI Framework | Jetpack Compose |
| State Management | `mutableStateOf`, `mutableStateListOf`, `StateFlow` |
| Architecture | MVVM + Repository Pattern |
| Navigation | Jetpack Navigation Compose (`NavGraph`) |
| Layout | `ConstraintLayout`, `LazyVerticalGrid`, `Scaffold` |
| DI Approach | Manual injection (ViewModel factory pattern) |
| Data Layer | `FakeData` with mutable state collections |

---

## 🚦 Navigation Graph

```
SplashScreen
    └── LoginScreen
            └── HomeScreen ──────────────────────────────────────────┐
                    │                                                │
            ┌───────┴────────┐                                       │
            │                │                                       │
     CategoryScreen    FavoriteScreen    CartScreen    ProfileScreen─┘
            │
     CategoryProductsScreen (categoryId: String)
            │
     ProductDetailsScreen (productId: String)
            │
         CartScreen
```

Bottom navigation persists across: **Home · Categories · Cart · Favorites · Profile**  
with `popUpTo` and state restoration configured in `BottomNavFun`.

---

## 🔄 State Flow — Add to Cart Example

```
ProductDetailsScreen
    │  onClick: "Buy Now"
    ▼
ProductDetailsViewModel.addToCart()
    │  injects CartRepo
    ▼
CartRepoImp.addToCart(product, quantity)
    │  checks FakeData.cartItems for existing entry
    │  → updates quantity if exists
    │  → adds new CartItem if new
    ▼
FakeData.cartItems (mutableStateListOf)
    │  Compose observes state change
    ▼
CartScreen recomposes with updated list
```

---

## 📁 Key Files Reference

| File | Responsibility |
|------|---------------|
| `NavGraph.kt` | Central navigation host with all route definitions |
| `BottomNavFun.kt` | Bottom navigation bar with state restoration logic |
| `FakeData.kt` | Centralized mock data using mutable Compose state |
| `BeautyTopBar.kt` | Reusable top bar with optional back button and cart badge |
| `CartRepoImp.kt` | Cart CRUD logic — add, update quantity, remove, subtotal |
| `ProductRepoImp.kt` | Product retrieval, favorite filtering, favorite toggling |
| `AuthRepoImp.kt` | Session management via companion object `loggedInPhone` |
| `ProfileViewModel.kt` | User state + `updateUser` mutating `FakeData.users` |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- Kotlin 2.x
- Minimum SDK: 24 | Target SDK: 34

### Run Locally

```bash
# Clone the repository
git clone https://github.com/hala-dalloul/beauty-app.git

# Open in Android Studio
# Let Gradle sync complete

# Run on emulator or physical device
./gradlew assembleDebug
```

> **Note:** The project uses a local `FakeData` layer — no backend or API keys required to run.

---

## 🗺️ Roadmap

- [ ] Replace `FakeData` with a real REST API (Retrofit + OkHttp)
- [ ] Integrate Room Database for offline cart persistence
- [ ] Add Hilt for dependency injection
- [ ] Implement real authentication (Firebase Auth / OTP)
- [ ] Add unit tests for all ViewModels and Repositories
- [ ] Dark mode support
- [ ] Localization (Arabic / English)

---

## 🤝 Contributing

Pull requests are welcome.

---

## 👩‍💻 Author

**Hala Dalloul**  
Flutter & Android Developer · Full-Stack Engineer (Java / Kotlin / Python)  
[GitHub @hala-dalloul](https://github.com/hala-dalloul)

---

<div align="center">
  <sub>Built with ❤️ using Jetpack Compose</sub>
</div>
