

## Project Overview

This repository demonstrates **Authentication** and **Authorization** using the **Spring Boot Framework**, integrated with an **Android** application (Kotlin-based frontend).

---

## Code Flow

The application follows a clean architecture pattern to ensure modularity and scalability. The flow of data is structured as follows:

1. **UI Layer (Jetpack Compose)**  
   - Contains the user interface logic.
   - Defines functions to handle user interactions (e.g., login, signup).
   - These functions invoke methods in the **ViewModel**.

2. **ViewModel Layer**  
   - Acts as a bridge between the UI and the data layers.
   - Contains business logic and exposes state to the UI via `StateFlow` or `LiveData`.
   - Calls appropriate methods in the **Repository** layer.

3. **Repository Layer**  
   - Handles data operations and acts as a single source of truth for the app.
   - Implements **suspend functions** to make API requests via the **ApiService**.
   - Processes and returns the results (e.g., success or error).

4. **ApiService (Retrofit)**  
   - Defines the REST API endpoints using Retrofit.
   - Responsible for making GET, POST, PUT, and DELETE requests to the backend.

---

## Data Flow Example: GET and PUT Requests

1. **GET Request**  
   - The **UI** triggers a `getUser` call from the **ViewModel**.  
   - The **ViewModel** calls the `getUser` function in the **Repository**.  
   - The **Repository** uses the **ApiService** to fetch user data from the backend.

2. **PUT Request**  
   - The **UI** triggers an `updateUser` call with updated user data.  
   - The **ViewModel** calls the `updateUser` function in the **Repository**.  
   - The **Repository** sends the updated data to the backend via the **ApiService**.

---
