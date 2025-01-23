package com.example.authenticationauthorizewithspringboot

class UserRepository(private val apiService: RetrofitInstance.ApiService){

    suspend fun getUser(id: String): Result<User> {
        return try{
            val response = apiService.getUser(id)
            if(response.isSuccessful){
                Result.success(response.body()!!)
            }else{
                Result.failure(Exception("Failed to fetch user"))
            }
        } catch (e:Exception){
            Result.failure(e)

        }
    }

    suspend fun updateUser(id: String, user: User): Result<User> {
        return try {
            val response = apiService.updateUser(id, user)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Failed to update user"))
            }
        } catch (e: Exception) {
            Result.failure(e)
            }
    }

}