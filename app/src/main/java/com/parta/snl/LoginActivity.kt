package com.parta.snl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
        val usernameInStore=intent.getStringExtra(Keys.USERNAME.key).toString()
        val passwordInStore=intent.getStringExtra(Keys.PASSWORD.key).toString()

        var count = 2
        button.setOnClickListener{
            if(username.text.toString()==usernameInStore && password.text.toString()==passwordInStore){
                titleText.text = getString(R.string.login_sucess)
            }
            else{
                count--
                titleText.text = "You have $count attempts left"
                if(count==0){
                    button.isEnabled=false
                }
            }
        }
    }

    private fun setup() {
        button.text = getString(R.string.login)
        titleText.text = getString(R.string.login_sac)
    }
}