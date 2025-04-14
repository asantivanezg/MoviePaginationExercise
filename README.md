[ENG]

# 🎬 MovieApp – Movie Catalog using TheMovieDB

An Android application built with Kotlin that consumes [TheMovieDB](https://www.themoviedb.org/) API to display a movie catalog, including popular movies, categories, search, and detailed information. It follows a modern and robust multi-layer architecture using cutting-edge technologies.

---

## 🚀 Tech Stack

- **Jetpack Compose** – Modern, declarative UI toolkit.
- **Retrofit + OkHttp** – For REST API communication.
- **Room** – Local database for caching.
- **Navigation (Type-Safe)** – Safe and structured navigation using Compose Navigation.
- **Kotlin Coroutines + Flows** – For asynchronous and reactive programming.
- **Hilt** – Scalable dependency injection framework.
- **Paging 3 + RemoteMediator** – Efficient data loading with local caching and remote API.
- **Version Catalog** – Centralized dependency management.
- **Clean Architecture**:
  - **Data Layer**: API (Retrofit), database (Room), RemoteMediator.
  - **Domain Layer**: Use cases and domain models.
  - **Presentation Layer**: UI (Compose), ViewModels, Flows.

---

## 🧱 Project Structure

```
├── data
│   ├── local (Room)
│   ├── remote (Retrofit + DTOs)
│   └── repository
├── domain
│   ├── model
│   └── usecase
├── presentation
│   ├── navigation (type-safe)
│   ├── ui (Compose screens)
│   └── viewmodel
├── di (Hilt modules)
├── utils (extensions, helpers, etc.)
└── build.gradle.kts
```

---

## 🔧 Setup Instructions

1. **Get an Access Token**
   - Go to: https://www.themoviedb.org/settings/api
   - Create an account (if you don’t have one), then generate a **v4 Access Token**.

2. **Replace Access Token in `build.gradle.kts` (App-level)**

```kotlin
buildConfigField("String", "ACCESS_TOKEN", "\"INSERT_ACCESS_TOKEN\"")
```

➡️ Replace `"INSERT_ACCESS_TOKEN"` with your actual token:

```kotlin
buildConfigField("String", "ACCESS_TOKEN", "\"eyJhbGciOiJI...\"")
```

> 🔒 *For security reasons, **do not** commit your token to a public repository.*

[ESP]

# 🎬 MovieApp - Catálogo de Películas con TheMovieDB

Aplicación Android desarrollada en Kotlin que consume la API de [TheMovieDB](https://www.themoviedb.org/) para mostrar un catálogo de películas populares, detalladas por categorías, con posibilidad de búsqueda y detalles individuales. Está construida con una arquitectura robusta y moderna utilizando tecnologías de vanguardia.

---

## 🚀 Tecnologías y herramientas utilizadas

- **Jetpack Compose**: Para construir la UI de forma declarativa y moderna.
- **Retrofit + OkHttp**: Para la comunicación con la API REST.
- **Room**: Base de datos local para almacenamiento en caché.
- **Navigation Type-Safe (Compose Navigation + Safe Args-like)**: Navegación entre pantallas de forma segura y estructurada.
- **Coroutines + Flows**: Para programación asíncrona y reactiva.
- **Hilt**: Inyección de dependencias simplificada y escalable.
- **Paging 3**: Para cargar listas de películas de forma eficiente y paginada desde la red y caché local.
- **Version Catalog**: Gestión centralizada de dependencias.
- **Clean Architecture (Arquitectura en capas)**:
  - **Data Layer**: Retrofit, Room, RemoteMediator.
  - **Domain Layer**: Casos de uso (use cases) y modelos de dominio.
  - **Presentation Layer**: Jetpack Compose, ViewModels y Flows.

---

## 🧱 Estructura de la app

```
├── data
│   ├── local (Room)
│   ├── remote (Retrofit + DTOs)
│   └── repository
├── domain
│   ├── model
│   └── usecase
├── presentation
│   ├── navigation (type-safe)
│   ├── ui (pantallas Compose)
│   └── viewmodel
├── di (Hilt modules)
├── utils (extensiones, helpers, etc.)
└── build.gradle.kts
```

---

## 🛠️ Configuración inicial

1. **Obtener Access Token**
   - Dirígete a: https://www.themoviedb.org/settings/api
   - Crea una cuenta (si no tienes una) y genera un **Access Token**.

2. **Reemplazar en `build.gradle.kts` (nivel de app)**

```kotlin
buildConfigField("String", "ACCESS_TOKEN", "\"INSERT_ACCESS_TOKEN\"")
```

➡️ Reemplaza `"INSERT_ACCESS_TOKEN"` con tu token real:

```kotlin
buildConfigField("String", "ACCESS_TOKEN", "\"eyJhbGciOiJI...\"")
```

> 🔒 *Por seguridad, nunca subas tu token a un repositorio público.*
