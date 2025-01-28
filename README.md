# TheNewsApp

TheNewsApp to aplikacja na Androida umożliwiająca użytkownikom przeglądanie najnowszych wiadomości z różnych kategorii. Aplikacja wykorzystuje architekturę MVVM (Model-View-ViewModel), co zapewnia czytelność kodu oraz łatwość rozbudowy. Dane są pobierane z publicznego API NewsAPI, a użytkownicy mogą zapisywać ulubione artykuły.

---

## Funkcje aplikacji:
- Wyświetlanie najnowszych wiadomości (Top Headlines).
- Wyszukiwanie wiadomości po słowach kluczowych.
- Zapisywanie ulubionych artykułów w lokalnej bazie danych (Room).
- Obsługa paginacji i dynamicznego ładowania kolejnych stron wyników.
- Obsługa błędów i braków połączenia internetowego.

---

## Technologie i biblioteki:
- **Język:** Kotlin
- **Architektura:** MVVM
- **Biblioteki:**
  - [Retrofit](https://square.github.io/retrofit/) – pobieranie danych z API.
  - [Room](https://developer.android.com/training/data-storage/room) – lokalna baza danych.
  - [Coroutines](https://developer.android.com/kotlin/coroutines) – obsługa operacji asynchronicznych.
  - [Navigation Component](https://developer.android.com/guide/navigation) – zarządzanie nawigacją między ekranami.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) i [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) – zarządzanie danymi UI.
  - [Glide](https://github.com/bumptech/glide) – ładowanie i wyświetlanie obrazów.
- **Interfejs użytkownika:**
  - RecyclerView z adapterem do dynamicznego wyświetlania artykułów.
  - BottomNavigationView do łatwego poruszania się po aplikacji.

---

## Struktura projektu:
1. **Model:**
   - `Article` – reprezentacja artykułu.
   - `NewsResponse` – struktura odpowiedzi API.
2. **Repository:**
   - `NewsRepository` – zarządzanie danymi (API i lokalna baza danych).
3. **ViewModel:**
   - `NewsViewModel` – logika biznesowa aplikacji.
4. **UI (Fragmenty):**
   - `HeadlinesFragment` – wyświetla najnowsze wiadomości.
   - `SearchFragment` – umożliwia wyszukiwanie wiadomości.
   - `SavedNewsFragment` – lista ulubionych artykułów.
5. **Inne:**
   - `NewsAdapter` – adapter do RecyclerView.
   - `Resource` – klasa pomocnicza do obsługi stanów odpowiedzi.

---

## Wymagania:
1. Klucz API z [NewsAPI](https://newsapi.org/).
2. Minimalna wersja Androida: API 21 (Lollipop).

---

## Instalacja:
1. Sklonuj repozytorium:
   ```bash
   git clone https://github.com/TwojeRepozytorium/TheNewsApp.git
