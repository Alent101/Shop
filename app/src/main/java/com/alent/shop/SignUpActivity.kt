package com.alent.shop

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btn_signup.setOnClickListener {
            val strEmail = ed_email.text.toString()
            val strPassword = ed_password.text.toString()
            Log.d("Signup", "email: $strEmail| password: $strPassword")
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(strEmail, strPassword)
                .addOnCompleteListener {
                    if (it.isSuccessful()) {
                        AlertDialog.Builder(this)
                            .setTitle("Sign Up")
                            .setMessage("Account created")
                            .setPositiveButton("OK") { dialog, which ->
                                setResult(Activity.RESULT_OK)
                                finish()
                            }
                            .show()
                    } else {
                        AlertDialog.Builder(this)
                            .setTitle("Sign Uo")
                            .setMessage(it.exception?.message)
                            .setPositiveButton("OK", null)
                            .show()

                    }
                }
        }
    }
}
