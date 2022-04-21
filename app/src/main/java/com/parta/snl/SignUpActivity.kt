package com.parta.snl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class SignUpActivity : AppCompatActivity() {


    private val sharedPrefFile = "kotlinsharedpreference"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()

        button.setOnClickListener{

            if(validatePassword(password.text.toString())) {
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra(Keys.USERNAME.key, username.text.toString())
                intent.putExtra(Keys.PASSWORD.key, password.text.toString())
                startActivity(intent)
            }else {
                password.error = " Please provide 1 Cap letter, 1 number, 1 special character, 8 characters"
            }

        }
    }

    private fun setup() {
        button.text = getString(R.string.sign_up)
        titleText.text = getString(R.string.sign_up_acitivty)
    }


    private fun validatePassword(password: String): Boolean {
        val pattern = Regex("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
        return pattern.containsMatchIn(password)
    }

}