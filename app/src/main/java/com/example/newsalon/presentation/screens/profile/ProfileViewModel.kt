package com.example.newsalon.presentation.screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.newsalon.data.fakeData.FakeData
import com.example.newsalon.data.repository.AuthRepoImp
import com.example.newsalon.domain.models.User
import com.example.newsalon.domain.repository.AuthRepo

class ProfileViewModel(private val authRepo: AuthRepo = AuthRepoImp()) : ViewModel() {
    fun getUserPhone()=authRepo.getCurrentUserPhone()?:"No Number"
    var userState by mutableStateOf<User?>(null)
        private set

    init {
        loadUserData()
    }

    fun loadUserData() {
        val phone = authRepo.getCurrentUserPhone()
        userState = FakeData.users.find { it.phone == phone }
    }
    fun updateUser(name: String, phone: String, email: String) {
        val currentPhone = authRepo.getCurrentUserPhone()
        val index = FakeData.users.indexOfFirst { it.phone == currentPhone }
        if (index != -1) {
            val currentUser = FakeData.users[index]
            FakeData.users[index] = currentUser.copy(name = name, phone = phone, email = email)
            loadUserData()
        }
    }
}