package com.example.novel

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GameScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
    }
}