package com.example.beautystation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
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

        val name = intent.getStringExtra("nome")

        val textViewName = findViewById<TextView>(R.id.textViewName)


        textViewName.text = "Bem-Vindo, $name"

        val recyclerViewServices = binding.viewServices
        recyclerViewServices.layoutManager = GridLayoutManager(this, 2)
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