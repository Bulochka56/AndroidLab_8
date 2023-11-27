package com.example.lab8

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.PopupMenu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        val popupMenu = PopupMenu(this, imageView)
        popupMenu.inflate(R.menu.menu_main)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu1 -> {
                    textView.text = "Нажат пункт PopupMenu 1"
                    true
                }
                R.id.menu2 -> {
                    textView.text = "Нажат пункт PopupMenu 2"
                    true
                }
                R.id.menu3 -> {
                    textView.text = "Нажат пункт PopupMenu 3"
                    true
                }
                else -> false
            }
        }
        imageView.setOnClickListener {
            popupMenu.show()
        }
       val popupMenu2 = PopupMenu(this,button)
       popupMenu2.inflate(R.menu.menu2)
       popupMenu2.setOnMenuItemClickListener {
           when (it.itemId) {
               R.id.red -> {
                   textView.background = ColorDrawable(Color.RED)
                   textView.text = "Вы выбрали красный цвет"
               }
               R.id.yellow -> {
                   textView.background = ColorDrawable(Color.YELLOW)
                   textView.text = "Вы выбрали желтый цвет"
               }
               R.id.green -> {
                   textView.background = ColorDrawable(Color.GREEN)
                   textView.text = "Вы выбрали зеленый цвет"
               }
           }
           false
       }
       if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.Q) {
           popupMenu2.setForceShowIcon(true)
       }
        button.setOnClickListener {
            popupMenu2.show()
        }
        val popupMenu3 = PopupMenu(this,button)
        popupMenu3.inflate(R.menu.menu3)
        popupMenu3.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.one -> {
                    textView.textSize = 28.toFloat()
                }
                R.id.two -> {
                    textView.textSize = 32.toFloat()
                }
                R.id.three -> {
                    textView.textSize = 36.toFloat()
                }
            }
            false
        }
        textView.setOnClickListener {
            popupMenu3.show()
        }
    }
}