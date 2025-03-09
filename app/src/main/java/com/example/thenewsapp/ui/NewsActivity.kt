package com.example.thenewsapp.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.thenewsapp.R
import com.example.thenewsapp.databinding.ActivityNewsBinding
import com.example.thenewsapp.db.ArticleDatabase
import com.example.thenewsapp.repository.NewsRepository
import com.example.thenewsapp.sensors.SensorHelper
import com.google.android.material.snackbar.Snackbar

class NewsActivity : AppCompatActivity() {

    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding
    private lateinit var sensorHelper: SensorHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        newsViewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        sensorHelper = SensorHelper(this, newsViewModel){
            refreshNews()
        }
    }

    override fun onResume() {
        super.onResume()
        sensorHelper.registerSensors()
    }

    override fun onPause() {
        super.onPause()
        sensorHelper.unregisterSensors()
    }

    // Funkcja odświeżania artykułów po potrząśnięciu
    private fun refreshNews() {
        newsViewModel.getHeadlines("us") // Możesz zmienić kraj na dowolny
        Snackbar.make(binding.root, "Odświeżono artykuły!", Snackbar.LENGTH_SHORT).show()
    }
}
