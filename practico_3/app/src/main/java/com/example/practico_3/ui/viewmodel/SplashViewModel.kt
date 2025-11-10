package com.example.practico_3.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SplashViewModel : ViewModel() {

    private val nameUser = MutableStateFlow("")
    val username: StateFlow<String> = nameUser.asStateFlow()

    fun updateUsername(newUsername: String) {
        nameUser.value = newUsername
    }

    fun isUsernameValid(): Boolean {
        return nameUser.value.isNotBlank()
    }
}
