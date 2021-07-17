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
    var imageView: ImageView? = null
    var flag: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        imageView= ImageView(this)
        imageView!!.layoutParams= LinearLayout.LayoutParams(1000, 1000)
        imageView!!.x= 20F // setting margin from left
        imageView!!.y= 20F
        imageView!!.setImageResource(R.drawable.anime_tyan)

        val layout = findViewById<ConstraintLayout>(R.id.game_screen_layout)

        // Add ImageView to LinearLayout
        layout?.addView(imageView)
    }

    fun buttonPress(view: View) {
        if (flag) {
            imageView!!.setImageResource(R.drawable.renesans_tyan)
        } else {
            imageView!!.setImageResource(R.drawable.anime_tyan)
        }
        flag = !flag
    }
}