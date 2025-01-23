package networlCall

import com.example.authenticationauthorizewithspringboot.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//The object keyword in Kotlin creates a singleton.
// This means only one instance of RetrofitInstance will exist in the app.
object RetrofitInstance {
    private const val BASE_URL = "https://your-backend-url.com/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    interface ApiService{
       @GET("users/{id}")
       fun getUser(@Path("id") id: String) : Response<User>

       @PUT("users/{id}")
       fun updateUser(@Path("id") id: String, @Body user: User) : Response<User>

    }

}
