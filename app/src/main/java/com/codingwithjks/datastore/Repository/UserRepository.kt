package com.codingwithjks.datastore.Repository

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.codingwithjks.datastore.data.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepository @Inject constructor(@ApplicationContext private val context: Context) {

   private val Context.dataStore : DataStore<com.codingwithjks.datastore.User> by dataStore(
        fileName = "user",
        serializer = DataStoreSetting
    )

    suspend fun writeToLocal(name:String,age:Int) = context.dataStore.updateData { user->
        user.toBuilder()
            .setName(name)
            .setAge(age)
            .build()
    }

    val readToLocal : Flow<User> = context.dataStore.data
        .catch {
            if(this is Exception){
                Log.d("main", "${this.message}")
            }
        }.map { 
           val  user = User(it.name,it.age)
            user
        }
}