package com.cs473de.lab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class MainActivity :    AppCompatActivity() {
    private lateinit var users:HashMap<String,User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        users=initialUsers()
    }

    private fun initialUsers():HashMap<String,User>{
        val userss=HashMap<String,User>()
        userss["c@gmail.com"]=User(1,"test1","One","c@gmail.com","test-o","12345678")
        userss["cris-p@gmail.com"]=User(2,"test2","two","test-tw@gmail.com","test-tw","1234567899")
        userss["cris-p@gmail.com"]=User(3,"test3","thr","test-th@gmail.com","test-thr","12345")
        userss["cris-p@gmail.com"]=User(4,"test4","4th","test-fo@gmail.com","test-fo","123456")
        userss["cris-p@gmail.com"]=User(5,"test5","5th","test-fi@gmail.com","test-fi","1234567")
        userss["cris-p@gmail.com"]=User(6,"test6","sex","test-se@gmail.com","test-se","123456789")
        return userss
    }

    private fun validateUser(email:String,pass:String):Boolean{
        return if (users.containsKey(email))
            users[email]?.email==email && users[email]?.password==pass
        else false
    }

    private fun goToShoppingCategoryActivity(userName:String){
        val intent= Intent(this,ShoppingCategoryActivity::class.java)
        intent.putExtra("userName",userName)
        startActivity(intent)
        finish()
    }

    fun signIn(view: View) {
        val email=findViewById<EditText>(R.id.edt_email).text.toString()
        val pass=findViewById<EditText>(R.id.edt_pass).text.toString()

        if (validateUser(email,pass)) goToShoppingCategoryActivity(userName = users[email]?.userName!!)
        else Toast.makeText(this,"We don't have this user",Toast.LENGTH_SHORT).show()
    }

    fun goToRegisterActivity(view: View) {
        startActivityForResult(Intent(this,CreateUserActivity::class.java),1)
    }


}