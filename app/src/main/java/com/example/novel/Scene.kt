package com.example.novel

import android.content.Context
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class Scene(val id: Int, val layout: ConstraintLayout, val context: Context) {

    val manager = SceneManager()

    val background = run {
        val backgroundId =
            context.resources.getIdentifier(manager.idBackgorundMap[id], "drawable", "com.example.novel")
        val background = ImageView(context)
        background.layoutParams = layout.layoutParams
        background.setImageResource(backgroundId)
        background
    }

    fun show() {
        layout.addView(background)
    }

    fun clear() {
        layout.removeView(background)
    }
}