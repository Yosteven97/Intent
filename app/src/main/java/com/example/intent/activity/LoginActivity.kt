package com.example.intent.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.intent.R
import com.example.intent.model.User
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var userModel: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLgn.setOnClickListener(this@LoginActivity)
        btnSgnUp.setOnClickListener(this@LoginActivity)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLgn -> {
                when {
                    edtTxtUsrNme.text.isEmpty() -> {
                        edtTxtUsrNme.error = "Input Your Username!!"
                        edtTxtUsrNme.requestFocus()
                    }
                    edtTxtPsd.text.isEmpty() -> {
                        edtTxtPsd.error = "Input Your Password!!"
                        edtTxtPsd.requestFocus()
                    }
                    else -> {
                        userModel = (User(edtTxtUsrNme.text.toString(), edtTxtPsd.text.toString()))

                        /**
                         * Explicit Intent
                         * Can be used to call another activity by referring to the name of the activity class.
                         */

                        //Calling another activity with parsing data
                        startActivity(
                            Intent(
                                MainActivity.getDataFromLogin(
                                    applicationContext,
                                    userModel
                                )
                            )
                        )
                    }
                }


            }
            R.id.btnSgnUp -> {
                /**
                 * Implicit Intent
                 * Do not name a specific component, but instead
                 * declare a general action to perform, which allows a
                 * component from another app to handle it
                 */

                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/yosteven97")
                    )
                )
            }
        }
    }


}
