package com.example.marketrf.ui

import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.marketrf.R

import com.example.marketrf.databinding.ActivityMainBinding
import com.example.marketrf.ui.fragments.ProductsListFragment
import com.example.marketrf.utils.Constants


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var mediaPlayer: MediaPlayer? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        // Handle the splash screen transition.
        installSplashScreen()
       // val splashScreen = installSplashScreen()

        /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
        } else {
            // Implement a traditional splash screen for older versions
            setContentView(R.drawable.splash_screen)
        }
*/
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Mostramos el fragment inicial ProductsListFragment
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProductsListFragment())
                .commit()

            mediaPlayer = MediaPlayer.create(this, R.raw.intro)
            mediaPlayer?.start()
        }

    }

}