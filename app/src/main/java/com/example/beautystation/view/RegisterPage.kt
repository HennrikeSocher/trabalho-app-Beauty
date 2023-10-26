package com.example.beautystation.view
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.beautystation.R
import com.example.beautystation.databinding.ActivityRegisterPageBinding
import com.google.android.material.snackbar.Snackbar

lateinit var binding: ActivityRegisterPageBinding

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#DC98C0")

        binding.buttonFinishRegister.setOnClickListener {
            val name = binding.registerUser.text.toString()
            val password = binding.registerPassowrd.text.toString()
            val confirmPassword = binding.registerConfirmPassowrd.text.toString()

            when {
                name.isEmpty() -> {
                    message(it, "Coloque seu Nome de usuário!")
                }
                password.isEmpty() -> {
                    message(it, "Coloque sua senha!")
                }
                confirmPassword.isEmpty() -> {
                    message(it, "Confirme sua senha!")
                }
                password.length <= 6 -> {
                    message(it, "Sua senha precisa ter pelo menos 6 caracteres")
                }
                password != confirmPassword -> {
                    message(it, "As senhas não coincidem")
                }
                else -> {
                    messageSucess(it, "Usuario Cadastrado")
                    Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this, LoginPage::class.java)
                        startActivity(intent)
                        finish()
                    },1000)
                }
            }
        }


    }

    private fun message(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#E41414"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

    private fun messageSucess(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#03fc0b"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }




    // Navegação para a activity de login
    private fun navToLoginPage() {
        val intent = Intent(this, LoginPage::class.java)
        startActivity(intent)
    }
}
