# 💰 ZennyLedger

<div align="center">

![ZennyLedger Logo](https://img.shields.io/badge/ZennyLedger-Personal%20Finance%20App-blue?style=for-the-badge&logo=android)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%230095D5.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpack-compose&logoColor=white)

*A modern, elegant personal finance management app built with cutting-edge Android technologies*

[![GitHub stars](https://img.shields.io/github/stars/abstractednick/ZennyLedger?style=social)](https://github.com/abstractednick/ZennyLedger/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/abstractednick/ZennyLedger?style=social)](https://github.com/abstractednick/ZennyLedger/network)
[![License](https://img.shields.io/badge/license-MIT-green.svg?style=for-the-badge)](LICENSE)

</div>

---

## 🌟 Features

### 💳 **Core Functionality**
- 📊 **Transaction Tracking** - Record income and expenses with detailed categorization
- 📈 **Financial Analytics** - Beautiful charts and insights into your spending patterns
- 💱 **Multi-Currency Support** - Real-time currency conversion with live exchange rates
- 🏦 **Account Management** - Multiple bank accounts and wallet support
- 📱 **Offline First** - Full functionality without internet connection

### 🎨 **Modern UI/UX**
- 🌙 **Dark/Light Theme** - Adaptive theming with Material Design 3
- 📱 **Responsive Design** - Optimized for all Android screen sizes
- 🎯 **Intuitive Navigation** - Clean, user-friendly interface
- ⚡ **Smooth Animations** - Delightful micro-interactions and transitions

### 🔧 **Technical Excellence**
- 🏗️ **Modern Architecture** - MVVM with Jetpack Compose
- 💉 **Dependency Injection** - Hilt for clean, testable code
- 🗄️ **Local Database** - Room for reliable data persistence
- 🌐 **API Integration** - Retrofit with Moshi for currency data
- 🔄 **Background Sync** - WorkManager for seamless data synchronization

---

## 🛠️ Tech Stack

<div align="center">

| Category | Technology | Version |
|----------|------------|---------|
| **Language** | Kotlin | 2.0.0 |
| **UI Framework** | Jetpack Compose | Latest |
| **Architecture** | MVVM + Clean Architecture | - |
| **Dependency Injection** | Hilt | 2.48 |
| **Database** | Room | 2.6.1 |
| **Networking** | Retrofit + Moshi | 2.11.0 |
| **Image Loading** | Coil | 2.5.0 |
| **Background Tasks** | WorkManager | 2.9.0 |
| **Settings** | DataStore | 1.1.1 |
| **Permissions** | Accompanist | 0.32.0 |

</div>

---

## 📱 Screenshots

<div align="center">

| Dashboard | Transactions | Analytics |
|-----------|--------------|-----------|
| ![Dashboard](https://via.placeholder.com/300x600/4285F4/FFFFFF?text=Dashboard+View) | ![Transactions](https://via.placeholder.com/300x600/34A853/FFFFFF?text=Transactions) | ![Analytics](https://via.placeholder.com/300x600/EA4335/FFFFFF?text=Analytics) |

*Screenshots coming soon as development progresses*

</div>

---

## 🚀 Getting Started

### Prerequisites

- **Android Studio** Hedgehog (2023.1.1) or later
- **JDK 11** or higher
- **Android SDK** API Level 24+ (Android 7.0)
- **Git** for version control

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/abstractednick/ZennyLedger.git
   cd ZennyLedger
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned repository folder

3. **Sync Project**
   - Android Studio will automatically sync Gradle files
   - Wait for dependency downloads to complete

4. **Build and Run**
   - Connect an Android device or start an emulator
   - Click the "Run" button or press `Ctrl+R` (Windows/Linux) or `Cmd+R` (Mac)

---

## 📁 Project Structure

```
ZennyLedger/
├── app/
│   ├── src/main/java/com/abstractednick/zennyledger/
│   │   ├── data/           # Data layer (Repository, API, Database)
│   │   ├── domain/         # Business logic and use cases
│   │   ├── presentation/   # UI layer (ViewModels, Composables)
│   │   └── di/            # Dependency injection modules
│   ├── src/main/res/      # Resources (layouts, strings, drawables)
│   └── build.gradle.kts   # App-level dependencies
├── gradle/
│   └── libs.versions.toml # Version catalog
└── build.gradle.kts       # Project-level configuration
```

---

## 🎯 Roadmap

### Phase 1: Core Features ✅
- [x] Project setup with modern Android stack
- [x] Basic UI structure with Jetpack Compose
- [ ] Transaction CRUD operations
- [ ] Local data persistence with Room
- [ ] Basic analytics and reporting

### Phase 2: Enhanced Features 🚧
- [ ] Multi-currency support with live rates
- [ ] Category management and customization
- [ ] Export/Import functionality
- [ ] Advanced analytics with charts
- [ ] Search and filtering

### Phase 3: Advanced Features 📋
- [ ] Budget planning and alerts
- [ ] Recurring transactions
- [ ] Data backup and sync
- [ ] Widget support
- [ ] Material You theming

---

## 🤝 Contributing

We welcome contributions to ZennyLedger! Here's how you can help:

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. **Commit your changes**
   ```bash
   git commit -m 'Add some amazing feature'
   ```
4. **Push to the branch**
   ```bash
   git push origin feature/amazing-feature
   ```
5. **Open a Pull Request**

### Development Guidelines

- Follow [Kotlin Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use [Material Design 3](https://m3.material.io/) principles
- Write unit tests for business logic
- Update documentation for new features

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**abstractednick**
- GitHub: [@abstractednick](https://github.com/abstractednick)
- Email: [your-email@example.com]

---

## 🙏 Acknowledgments

- [Material Design 3](https://m3.material.io/) for design inspiration
- [Android Developers](https://developer.android.com/) for excellent documentation
- [Jetpack Compose](https://developer.android.com/jetpack/compose) for modern UI toolkit
- Open source community for amazing libraries

---

<div align="center">

### ⭐ Star this repository if you found it helpful!

**Built with ❤️ for the Android community**

[![GitHub stars](https://img.shields.io/github/stars/abstractednick/ZennyLedger?style=for-the-badge)](https://github.com/abstractednick/ZennyLedger/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/abstractednick/ZennyLedger?style=for-the-badge)](https://github.com/abstractednick/ZennyLedger/network)

</div>
