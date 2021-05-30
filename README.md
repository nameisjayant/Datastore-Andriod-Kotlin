# Datastore-Andriod-Kotlin

Jetpack DataStore is a data storage solution that allows you to store key-value pairs or typed objects with protocol buffers. DataStore uses Kotlin coroutines and Flow to store data asynchronously, consistently, and transactionally.

If you're currently using SharedPreferences to store data, consider migrating to DataStore instead.


Preferences DataStore and Proto DataStore
DataStore provides two different implementations: Preferences DataStore and Proto DataStore.

Preferences DataStore stores and accesses data using keys. This implementation does not require a predefined schema, and it does not provide type safety.
Proto DataStore stores data as instances of a custom data type. This implementation requires you to define a schema using protocol buffers, but it provides type safety.

So in this project we will learn about preferences Datastore
