package ru.kosproger.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import ru.kosproger.news.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Получите NavController из NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.navigate(R.id.splashFragment)
        // Установите слушатель для навигации
        binding.bottomNavMenu.setOnItemSelectedListener { item ->
            when (val id = item.itemId) {
                R.id.mainFragment, R.id.searchFragment, R.id.favoriteFragment -> {
                    navController.navigate(id)
                    true
                }
                else -> false
            }
        }

    }
}