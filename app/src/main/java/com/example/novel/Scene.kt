package com.example.novel

import android.content.Context
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

abstract class Scene(val id: Int, val layout: ConstraintLayout, val context: Context) {

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

    abstract fun show()

    abstract fun clear()
}


class SimpleScene(id: Int, layout: ConstraintLayout, context: Context): Scene(id, layout, context) {
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

    override fun show() {
        layout.addView(background)
        layout.addView(text)
    }

    override fun clear() {
        layout.removeView(background)
        layout.removeView(text)
    }
}


class DecisionOptions(context: Context): LinearLayout(context) {
    val opt1: Button = Button(context)
    val opt2: Button = Button(context)

    init {
        orientation = VERTICAL
    }

    init {
        opt1.text = "Huy"; opt2.text = "Jopa"
        opt1.setOnClickListener { println("Huy pressed!") }
        opt2.setOnClickListener { println("Jopa pressed!") }
        val opt1LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 0)
        val opt2LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 0)
        opt1LayoutParams.weight = 1F; opt2LayoutParams.weight = 1F
        opt1.layoutParams = opt1LayoutParams; opt2.layoutParams = opt2LayoutParams
        addView(opt1); addView(opt2)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        val parentHeight = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(parentWidth/2, parentHeight/2)
        layoutParams.width = parentWidth/2;layoutParams.height = parentHeight/2
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}


class DecisionScene(id: Int, layout: ConstraintLayout, context: Context): Scene(id, layout, context) {

    val options = DecisionOptions(context)

    override fun show() {
        println("Privet!")
        layout.addView(background)
        layout.addView(options)
        println("Showed!")
    }

    override fun clear() {
        layout.removeView(background)
        layout.removeView(options)
    }
}