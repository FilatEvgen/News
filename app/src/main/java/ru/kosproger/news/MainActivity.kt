package ru.kosproger.news

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import ru.kosproger.news.databinding.ActivityMainBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.myLooper()!!).postDelayed({
            setContentView(binding.root)
            binding.bottonNavMenu.setupWithNavController(
                navController = binding.bottonNavMenu.findNavController()
            )
        }, 5000)
    }
}

