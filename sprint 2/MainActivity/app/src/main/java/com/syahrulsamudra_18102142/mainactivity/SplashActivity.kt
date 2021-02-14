package com.syahrulsamudra_18102142.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            //start main activity
            if(Firebase.auth.currentUser == null) {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finishAffinity()
            } else {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finishAffinity()
            }
            //finish this activity
        },2500)
    }
}