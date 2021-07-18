package com.example.novel

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout

class GameScreen : AppCompatActivity() {
    var curScene: Scene? = null
    var flag: Boolean = true
    val sceneManager = SceneManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        val layout = findViewById<ConstraintLayout>(R.id.game_screen_layout)

        curScene = Scene(0, layout, this)
        curScene!!.show()
    }

    fun buttonPress(view: View) {
        curScene!!.clear()
        curScene = sceneManager.nextScene(curScene!!)
        curScene!!.show()
    }
}