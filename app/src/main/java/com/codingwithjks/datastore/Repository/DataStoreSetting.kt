package com.codingwithjks.datastore.Repository

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.codingwithjks.datastore.User
import java.io.InputStream
import java.io.OutputStream

object DataStoreSetting : Serializer<User>{

    override val defaultValue: User
        get() = User.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): User {
      try {
          return User.parseFrom(input)
      }catch (e:InvalidProtocolBufferException){
          throw CorruptionException("cannot read protocol",e)
      }
    }

    override suspend fun writeTo(t: User, output: OutputStream)  = t.writeTo(output)



}