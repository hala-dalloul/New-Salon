package com.example.newsalon.presentation.screens.profile

import androidx.lifecycle.ViewModel
import com.example.newsalon.data.repository.AuthRepoImp
import com.example.newsalon.domain.repository.AuthRepo

class ProfileViewModel(private val authRepo: AuthRepo = AuthRepoImp()) : ViewModel() {
    fun getUserPhone()=authRepo.getCurrentUserPhone()?:"No Number"
}