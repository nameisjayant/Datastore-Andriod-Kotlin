package com.codingwithjks.datastore.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithjks.datastore.Repository.DatastoreSetting
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val datastoreSetting: DatastoreSetting) : ViewModel() {


    fun saveToLocal(name:String) = viewModelScope.launch {
        datastoreSetting.saveToLocal(name)
    }

    val readFromLocal = datastoreSetting.readFromLocal

}