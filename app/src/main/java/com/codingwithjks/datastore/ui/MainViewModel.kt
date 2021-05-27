package com.codingwithjks.datastore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithjks.datastore.Repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val userRepository: UserRepository) : ViewModel() {

    fun writeToLocal(name:String,age:Int) = viewModelScope.launch {
        userRepository.writeToLocal(name,age)
    }

    val readToLocal = userRepository.readToLocal

}