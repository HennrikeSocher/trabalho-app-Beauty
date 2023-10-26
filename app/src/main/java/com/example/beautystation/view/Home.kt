package com.example.beautystation.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beautystation.R
import com.example.beautystation.adpter.ServicesAdapter
import com.example.beautystation.databinding.ActivityHomeBinding
import com.example.beautystation.models.Services

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicesAdapter: ServicesAdapter
    private val servicesList: MutableList<Services> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#DC98C0")

        val name = intent.getStringExtra("nome")

        val textViewName = findViewById<TextView>(R.id.textViewName)


        textViewName.text = "Bem-Vindo, $name"

        val recyclerViewServices = binding.viewServices
        val layoutManager = LinearLayoutManager(this) // Crie um LinearLayoutManager
        layoutManager.orientation = LinearLayoutManager.VERTICAL // Configure a orientação para vertical
        recyclerViewServices.layoutManager = layoutManager

        servicesAdapter = ServicesAdapter(this, servicesList)
        recyclerViewServices.setHasFixedSize(true)
        recyclerViewServices.adapter = servicesAdapter

        getServices()


        binding.buttonSchedule.setOnClickListener {
            val  intent = Intent(this, Schedule::class.java)
            intent.putExtra("nome",name)
            startActivity(intent)
        }
    }

    private  fun getServices () {
        val service1 = Services(R.drawable.haircut, "Corte de cabelo")
        servicesList.add(service1)

        val service2 = Services(R.drawable.hairpaint, "Pintura de cabelo")
        servicesList.add(service2)

        val service3 = Services(R.drawable.hairwash, "Lavagem de cabelo")
        servicesList.add(service3)

        val service4 = Services(R.drawable.manicure, "Manicure")
        servicesList.add(service4)

    }

}