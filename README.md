# 🧪 Rick and Morty Characters App

A simple **Rick and Morty character viewer** built with **Jetpack Compose**, **Kotlin**, and the **Rick and Morty API**.

> 📚 **This project was developed for learning purposes**, with a focus on practicing how to **consume a REST API using Retrofit**, structure a **clean Jetpack Compose UI**, and load images with **Coil**.

## 🚀 Features
- 👾 **Character List**: Displays characters with name, species, gender, and image.
- 🌐 **API Integration**: Fetches data from [rickandmortyapi.com](https://rickandmortyapi.com/).
- 🖼️ **Coil Image Loading**: Loads character images efficiently.
- 📱 **Modern UI**: Built with Jetpack Compose and Material 3.

## 📂 Project Structure
- `MainActivity.kt` → Sets up the UI theme and entry point.
- `Character.kt` → Defines the character data model.
- `Result.kt` → Wraps the character list from the API.
- `RetrofitFactory.kt` → Creates the Retrofit instance and base URL.
- `CharacterService.kt` → Retrofit service with endpoints.
- `CharacterListScreen.kt` → Composable that displays the character list and handles API responses.

## 🛠 Tech Stack
- **Kotlin** 🟡
- **Jetpack Compose** 🧩
- **Material 3** 🎨
- **Retrofit** 📡
- **Coil** 🖼️

## 🔧 Setup
1. Clone the repo:
   ```sh
   git clone https://github.com/vicmazzola/rick-morty-app-.git
