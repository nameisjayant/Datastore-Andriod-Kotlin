package com.codingwithjks.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.codingwithjks.datastore.ViewModel.MainViewModel
import com.codingwithjks.datastore.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        saveToLocal()
        lifecycleScope.launchWhenStarted {
            mainViewModel.readFromLocal.collect { data ->
                binding.preferenceValue.text = "Preference Value is : $data"
            }
        }
    }

    private fun saveToLocal() {
        binding.apply {
            ok.setOnClickListener {
                if (!TextUtils.isEmpty(name.text.toString())) {
                    Log.d("main", "saveToLocal: ${name.text}")
                    mainViewModel.saveToLocal(name = name.text.toString())
                } else {
                    Toast.makeText(this@MainActivity, "fill the field", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}