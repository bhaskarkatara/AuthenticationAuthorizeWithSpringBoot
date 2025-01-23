package com.example.authenticationauthorizewithspringboot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _userState = MutableStateFlow<Result<User>?>(null)
    val userState: StateFlow<Result<User>?> = _userState

    fun getUser(id: String) {
        viewModelScope.launch {
            _userState.value = userRepository.getUser(id)
        }
    }
    fun updateUser(id: String, user: User) {
        viewModelScope.launch {
            _userState.value = userRepository.updateUser(id, user)
        }
    }

}