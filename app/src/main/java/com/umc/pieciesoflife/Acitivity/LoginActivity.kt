package com.umc.pieciesoflife.Acitivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.umc.pieciesoflife.BottomNavBar.BottomNavBarActivity
import com.umc.pieciesoflife.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginBinding
    //앱 처음 실행?
    var isFirst : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.btnLogin.setOnClickListener {
            val intent = Intent(this, BottomNavBarActivity::class.java)
            startActivity(intent)
            // -> Spring Server
            // -> Firebase Server
            firebaseUser()
        }
    }

    private fun firebaseUser() {

    }
}