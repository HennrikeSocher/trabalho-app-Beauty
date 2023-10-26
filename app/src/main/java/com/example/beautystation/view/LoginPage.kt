package com.example.beautystation.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.beautystation.databinding.ActivityLoginpageBinding // Importe a classe de vinculação gerada
import com.google.android.material.snackbar.Snackbar

class LoginPage : AppCompatActivity() {

    private lateinit var binding: ActivityLoginpageBinding // Declare a propriedade de vinculação

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialize a propriedade 'binding' usando DataBindingUtil
        binding = ActivityLoginpageBinding.inflate(layoutInflater)

        val view = binding.root// Obtenha a raiz do layout a partir da vinculação

        setContentView(view) // Defina a visualização raiz no conteúdo da atividade

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#DC98C0")

    //binding botao de login com os popups!
        binding.buttonLogin.setOnClickListener {
            val name = binding.loginUser.text.toString()
            val password = binding.loginPassword.text.toString()

            when {
                name.isEmpty() -> {
                    message(it,"Coloque seu username!")
                }password.isEmpty() -> {
                message(it, "Coloque sua senha!")
            }password.length <= 6 -> {
                message(it, "Sua senha precisa ter ao menos 6 caracteres")
            }else -> {
                navToHome(name)
            }
            }
        }

        binding.buttonRegister.setOnClickListener {
            navToRegister()
        }
    }

    private fun message(view: View, message: String) {
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#E41414"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

    //navegation para a activity de home
    private fun navToHome(name: String) {
        val intent = Intent(this, Home::class.java)
        intent.putExtra("nome", name)
        startActivity(intent)
    }

    //navegation para a activity de registro
    private fun navToRegister(){
        val intent = Intent(this, RegisterPage::class.java)
        startActivity(intent)
    }
}
