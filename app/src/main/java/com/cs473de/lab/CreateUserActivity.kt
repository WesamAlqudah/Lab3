package com.cs473de.lab

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateUserActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_user_layout)
    }

    fun createAccount(view: View) {

        val fName=findViewById<EditText>(R.id.edt_fNameR).text.toString()
        val lName=findViewById<EditText>(R.id.edt_lNameR).text.toString()
        val email=findViewById<EditText>(R.id.edt_emailR).text.toString()
        val pass=findViewById<EditText>(R.id.edt_passR).text.toString()
        if (fName.isNotBlank()&&lName.isNotBlank()&&email.isNotBlank()&&pass.isNotBlank()){
            val intentt= Intent(this,MainActivity::class.java)
            val bundle=Bundle()
            intentt.putExtra("user",User(6,fName,lName,email,email,pass))
            setResult(1, intentt)

        }

    }
}