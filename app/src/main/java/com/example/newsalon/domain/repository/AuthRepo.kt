package com.example.newsalon.domain.repository

interface AuthRepo {

    fun getCurrentUserPhone(): String?
    fun setCurrentUser(phone: String)

    suspend fun loginWithPhone(phone: String, password: String): Result<Boolean>
    suspend fun verifyOtp(phone: String, otp: String): Result<Boolean>

}