package com.example.newsalon.presentation.screens.auth

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.newsalon.data.fakeData.FakeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onPhoneChange(newPhone: String){
        _uiState.update { current->
            current.copy(
                phoneNumber = newPhone,
                errorMessage = "",
                isLoginSuccess = false
            )
        }
    }
    fun onLoginClicked(){
        val phone = _uiState.value.phoneNumber
        if(phone.isEmpty()){
            _uiState.update {
                it.copy(errorMessage = "Enter Phone Number")
            }
            return
        }

        // get phone number from user
        val isValidate = FakeData.users.any{it.phone == phone}


        _uiState.update {
            it.copy(
                isLoading = false,
                isLoginSuccess = isValidate,
                errorMessage = if(isValidate)"" else "This is number not found"
            )

        }
    }
}
data class LoginUiState(
    val phoneNumber : String = "",
    val errorMessage :String = "",
    val isLoading : Boolean = false,
    val isLoginSuccess : Boolean = false
)