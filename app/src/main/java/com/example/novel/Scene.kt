package com.example.novel

import android.content.Context
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Scene(val id: Int, val layout: ConstraintLayout, val context: Context) {

    val manager = SceneManager()

    val background = run {
        val backgroundId =
            context.resources.getIdentifier(manager.sceneBackground(id), "drawable", "com.example.novel")
        val background = ImageView(context)
        background.layoutParams= layout.layoutParams
        background.layoutParams.height = layout.layoutParams.width
        background.adjustViewBounds = true
        background.scaleType = ImageView.ScaleType.CENTER_CROP
        background.setImageResource(backgroundId)
        background
    }

    val text = run {
        val text = TextView(context)
        text.text = manager.sceneText(id)
        val textLayoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, 100)
        textLayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        textLayoutParams.bottomMargin = 10; textLayoutParams.leftMargin = 50
        text.layoutParams = textLayoutParams
        text.textSize = 28F
        text
    }

    fun show() {
        layout.addView(background)
        layout.addView(text)
    }

    fun clear() {
        layout.removeView(background)
        layout.removeView(text)
    }
}