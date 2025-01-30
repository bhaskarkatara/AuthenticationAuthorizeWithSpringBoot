# 📌 Connecting Android Frontend to Spring Boot Backend

This guide explains how to connect an **Android (Kotlin) frontend** with a **Spring Boot backend** using **Retrofit** and provides key precautions to avoid common issues.

---

## 🚀 Steps to Connect Android with Spring Boot

### 1️⃣ Setup Spring Boot Backend  
- Ensure **Spring Boot** is configured to use a database like **MongoDB** or **MySQL**.  
- Create **REST API endpoints** for handling GET and POST requests.  
- Run the Spring Boot application and verify it is listening on the correct **port (e.g., 8080)**.  

---

### 2️⃣ Setup Retrofit in Android  
- Add **Retrofit and Gson dependencies** in `build.gradle`.  
- Configure **Retrofit instance** with the correct **BASE_URL** pointing to the backend.  
- Define API endpoints inside an **interface** for making GET and POST requests.  

---

### 3️⃣ Handle API Calls in Android  
- Use **Coroutines (`suspend` functions)** to perform network requests asynchronously.  
- Ensure API calls are made inside **`lifecycleScope.launch {}`** to prevent UI freezing.  
- Implement proper **error handling (`try-catch`)** to manage failed requests.  

---

## ⚠️ Precautions & Common Issues  

### ✅ 1. Allow HTTP Traffic in `AndroidManifest.xml`  
By default, Android blocks non-HTTPS requests. To enable HTTP traffic, add the following inside the `<application>` tag in `AndroidManifest.xml`:

```xml
<application
    android:usesCleartextTraffic="true">
</application>
```
##🎯 Final Checklist Before Running


✅ Backend is running on the correct port (8080).


✅ Android device and PC are on the same Wi-Fi.


✅ BASE_URL uses local IP (192.168.X.X), not localhost.


✅ android:usesCleartextTraffic="true" is added in AndroidManifest.xml.


✅ Using 10.0.2.2 for Emulator instead of localhost.


✅ All API calls are inside lifecycleScope.launch {} (CoroutineScope).

