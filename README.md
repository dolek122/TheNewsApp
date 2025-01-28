Opis projektu: TheNewsApp

TheNewsApp to aplikacja na Androida umożliwiająca użytkownikom przeglądanie najnowszych wiadomości z różnych kategorii.
Aplikacja wykorzystuje architekturę MVVM (Model-View-ViewModel), która zapewnia czytelność kodu oraz łatwość rozbudowy.
Dane są pobierane z publicznego API NewsAPI, a użytkownik ma możliwość zapisywania ulubionych artykułów.

Funkcje aplikacji:
-Wyświetlanie najnowszych wiadomości (Top Headlines).
-Wyszukiwanie wiadomości po słowach kluczowych.
-Przechowywanie ulubionych artykułów w lokalnej bazie danych (Room).
-Obsługa paginacji i ładowania kolejnych stron z wynikami.
-Obsługa błędów i braków połączenia internetowego.

Technologie i biblioteki:
Język: Kotlin
Architektura: MVVM

Biblioteki:
Retrofit – pobieranie danych z API.
Room – lokalna baza danych.
Coroutines – obsługa operacji asynchronicznych.
Navigation Component – zarządzanie nawigacją między ekranami.
ViewModel i LiveData – zarządzanie danymi UI.
Glide – ładowanie i wyświetlanie obrazów.

Interfejs użytkownika:
RecyclerView z adapterem do dynamicznego wyświetlania artykułów.
BottomNavigationView do łatwego poruszania się po aplikacji.

Struktura projektu:
Model:

Article – reprezentacja artykułu.
NewsResponse – struktura odpowiedzi API.
Repository:

NewsRepository – zarządzanie danymi (API i lokalna baza danych).
ViewModel:

NewsViewModel – logika biznesowa aplikacji.
UI (Fragmenty):

HeadlinesFragment – wyświetla najnowsze wiadomości.
SearchFragment – umożliwia wyszukiwanie wiadomości.
SavedNewsFragment – lista ulubionych artykułów.
Inne:

NewsAdapter – adapter do RecyclerView.
Resource – klasa pomocnicza do obsługi stanów odpowiedzi.
Wymagania:
Klucz API z NewsAPI (w pliku Constants.kt).
Minimalna wersja Androida: API 21 (Lollipop).
Instalacja:

Sklonuj repozytorium:

git clone https://github.com/dolek122/TheNewsApp.git

Wstaw klucz API w pliku Constants.kt:
const val API_KEY = "TWOJ_KLUCZ_API"
Uruchom projekt w Android Studio.
