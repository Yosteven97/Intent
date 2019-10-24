package com.example.intent.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intent.R
import com.example.intent.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // the map of all extras previously added with putExtra
        val bundle = intent.extras
        if (bundle == null) {
            //showing error text
            Toast.makeText(applicationContext, "Bundle is Null", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        val username = bundle.getString(username)
        txtUsrNme.text = "Hello!! " + username.toString()
    }

    companion object {
        // get used to use private in companion object class
        private const val username = "MainActivity.username"
        private const val password = "MainActivity.password"

        fun getDataFromLogin(context: Context, user: User?): Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(username, user?.username)
            return intent
        }
    }
}
