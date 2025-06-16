package com.orgs.myapplication.ui.Activitys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.arquivomobileoficialnitro.ui.screen.ScreenMaps

class MapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenMaps()
        }
    }
}