package com.codingwithjks.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.codingwithjks.datastore.databinding.ActivityMainBinding
import com.codingwithjks.datastore.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        writeToLocal()

        lifecycleScope.launchWhenStarted {
            mainViewModel.readToLocal.collect { user->
                binding.apply {
                    preferenceValue.text = "your name is ${user.name} and age is ${user.age}"
                }
            }
        }

    }

    private fun writeToLocal() {
        binding.apply {
            ok.setOnClickListener {
                if(!TextUtils.isEmpty(name.text.toString()) && !TextUtils.isEmpty(age.text.toString())){
                    mainViewModel.writeToLocal(name.text.toString(),age.text.toString().toInt())
                }
                else{
                    Toast.makeText(this@MainActivity,"fields are empty",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}