# SampleApp - Learning Project

Welcome to **TestSimpleApp**! This project is designed as a modern Android development showcase, implementing best practices and the latest Jetpack libraries. It serves as a great reference for learners and developers looking to understand how to build a scalable, maintainable Android application.

## 🚀 Architecture Overview

The project follows **Clean Architecture** principles and the **MVI (Model-View-Intent)** pattern to ensure a clear separation of concerns and a unidirectional data flow.

### 📂 Layered Structure
- **UI Layer (`com.uday.testsimpleapp.ui`)**: Contains Compose screens, ViewModels, and state definitions.
- **Domain Layer (`com.uday.testsimpleapp.domain`)**: Contains Business Logic (UseCases) and Repository Interfaces.
- **Data Layer (`com.uday.testsimpleapp.data`)**: Handles data fetching from network/local sources and implements Repository Interfaces.
- **DI (`com.uday.testsimpleapp.di`)**: Hilt modules for providing dependencies.

---

## 🛠️ Key Components & Libraries

### 1. Jetpack Compose & Material 3
- **Declarative UI**: Built entirely with Jetpack Compose.
- **Material 3**: Uses the latest Material Design components (Scaffold, Cards, TopAppBar, etc.).
- **Theme**: Custom theme implementation in `ui.theme`.

### 2. Dependency Injection (Hilt)
- Uses **Dagger Hilt** for dependency management.
- `@HiltAndroidApp`: Application class setup.
- `@AndroidEntryPoint`: Activity/Fragment setup.
- `@HiltViewModel`: ViewModel dependency injection.
- `hiltViewModel()`: Compose-specific injection in NavHost.

### 3. Navigation Compose
- Implements **Type-safe-like Navigation** (passing arguments via strings).
- `NavHost` and `composable` destinations are managed in `MyApp.kt`.

### 4. MVI Pattern (Model-View-Intent)
- **State**: `UiState` holds the entire screen state (loading, data, error).
- **Intent**: `UserIntent` represents user actions (e.g., `FetchUsers`).
- **Effect**: `SharedFlow` used for one-time events like Toasts or Navigation.

### 5. Networking (Retrofit & OkHttp)
- **Retrofit**: Type-safe HTTP client for Android.
- **OkHttp**: Underlying client for network requests, including logging interceptors.
- **GSON**: JSON serialization/deserialization.

### 6. Image Loading (Coil)
- **AsyncImage**: Efficient and lifecycle-aware image loading for Compose.

### 7. Asynchronous Programming (Coroutines & Flow)
- **Coroutines**: For non-blocking background tasks.
- **StateFlow**: Reactive state updates to the UI.
- **collectAsStateWithLifecycle**: Lifecycle-aware state collection in Composables.

---

## 📖 What You Can Learn Here
1. **How to structure a multi-module style project** within a single module using packages.
2. **How to implement MVI** to manage complex UI states predictably.
3. **How to use Hilt** to decouple your code and make it testable.
4. **How to pass data between screens** using Compose Navigation.
5. **How to handle Network requests** and map them to domain models.

---

## 🛠️ Getting Started
1. Clone the repository.
2. Open in **Android Studio**.
3. Sync Gradle and run the `:app` module.

Happy Coding! 🚀
