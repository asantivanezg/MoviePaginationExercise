package com.asantivanezg.paginationexercise.ui.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : ViewModel() {
    var username by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    var loginSuccess = MutableStateFlow(false)
        private set

    fun onLoginClick() {
        errorMessage = when {
            username.isBlank() -> "El campo Usuario no puede estar vacío"
            password.isBlank() -> "El campo Contraseña no puede estar vacío"
            else -> null
        }

        if (username == "Admin" && password == "Password*123") {
            loginSuccess.value = true
        } else {
            errorMessage = "Usuario o contraseña incorrecto"
        }
    }

    fun onUserNameValueChange(value: String) {
        errorMessage = null
        username = value
    }

    fun onPasswordValueChange(value: String) {
        errorMessage = null
        password = value
    }
}