package com.cs473de.lab

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ShoppingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        val rv:RecyclerView=findViewById(R.id.rv)
        val adapter=Adapter()
        adapter.setList(getItemsList())
        rv.adapter=adapter
        findViewById<TextView>(R.id.welcome_email).text="Welcome "+intent.extras?.getString("userName")
    }

    private fun getItemsList():ArrayList<Item>{
        return arrayListOf(
            Item("ITem 1",R.drawable.logo,55.4),
            Item("ITem 1",R.drawable.logo,55.4),
            Item("ITem 1",R.drawable.logo,55.4)

        )
    }
}