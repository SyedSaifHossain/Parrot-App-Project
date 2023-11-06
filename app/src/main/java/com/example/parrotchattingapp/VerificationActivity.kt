package com.example.parrotchattingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerificationBinding
    var auth: FirebaseAuth ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)
        auth = FirebaseAuth.getInstance()
        if(auth!!.currentUser!=null){
            startActivity(Intent(this@VerificationActivity, MainActivity::class.java))
            finish()
        }

        binding.phoneTxt.requestFocus()
        binding.continueBtn.setOnClickListener {
            var intent = Intent(this@VerificationActivity, OTPActivity::class.java)
            intent.putExtra("phoneNumber", binding.phoneTxt.text.toString())
            startActivity(intent)
        }

    }
}