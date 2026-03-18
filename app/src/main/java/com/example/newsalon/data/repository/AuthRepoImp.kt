package com.example.newsalon.data.repository

import com.example.newsalon.domain.repository.AuthRepo
import kotlinx.coroutines.delay

class AuthRepoImp : AuthRepo {
    override suspend fun loginWithPhone(
        phone: String,
        password: String
    ): Result<Boolean> {
        delay(1000L)
        return if(phone.length == 8){
            Result.success(true)
        }else{
            Result.failure(Exception("This invalid phone"))
        }
    }

    override suspend fun verifyOtp(
        phone: String,
        otp: String
    ): Result<Boolean> {
        delay(2000L)
        /**
         *TODO ==> هنا الرمز هو عبارة عن النص المقتطع من الرقم من الخانة 4 للخانة الأخيرة
         */
        return if(otp == (phone.substring(3))){
            Result.success(true)
        }else{
            Result.failure(Exception("This invalid otp"))
        }
    }


}