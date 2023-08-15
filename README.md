# ShoplistApp
Welcome to the Simple Shopping App repository! This project demonstrates the implementation of a basic shopping application using the MVVM architectural pattern along with several modern Android technologies. The app utilizes Room, Hilt, MVVM, Flow, Coroutines, and Jetpack Compose to create a seamless and efficient shopping experience.


# Technologies Used

MVVM Architecture: The app follows the Model-View-ViewModel architectural pattern, which separates the concerns of data, UI, and business logic.

Room: A powerful SQLite abstraction library that makes it easy to work with local databases. It's used to cache product data and shopping cart information.

Hilt: A dependency injection library for Android, providing a standardized way to manage dependencies throughout the app.

Flow: A modern replacement for LiveData that allows for reactive programming with asynchronous data streams.

Coroutines: Kotlin's concurrency framework used for managing asynchronous operations and background tasks.

Jetpack Compose: A modern and declarative UI toolkit for building native Android user interfaces with less boilerplate code.

# Installation

Clone this repository to your local machine using:

bash
Copy code

git clone https://github.com/kprl884/ShoplistApp.git

Open the project in Android Studio.

Build and run the app on an emulator or physical device.

# Getting Started

The app is structured with the following packages:

data: Contains data-related classes, including data models, Room database setup, and data source implementations.
di: Holds classes related to dependency injection setup using Hilt.
ui: Contains the Jetpack Compose UI components and screens.
viewmodel: Houses the ViewModel classes responsible for managing UI-related data and interactions.
Feel free to explore and modify these packages to understand how different components of the app interact.

# Contributing

If you'd like to contribute to the project, you can follow these steps:

Fork the repository.
Create a new branch for your feature or bug fix: git checkout -b feature/your-feature-name.
Make your changes and commit them with descriptive messages.
Push your changes to your forked repository.
Create a pull request targeting the main branch of this repository.
Please ensure your code follows the existing coding style and includes appropriate tests for your changes.
