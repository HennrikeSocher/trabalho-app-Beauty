package com.example.beautystation.view

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.beautystation.databinding.ActivityScheduleBinding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class Schedule : AppCompatActivity() {

    private lateinit var binding: ActivityScheduleBinding
    private val calendar: Calendar = Calendar.getInstance()
    private var data: String =""
    private var hour: String = ""
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#DC98C0")

        val name = intent.extras?.getString("nome").toString()

        val datePicker = binding.datePicker
        datePicker.setOnDateChangedListener{_, year, monthOfYear, dayOfmonth ->
            calendar.set(Calendar.YEAR,year)
            calendar.set(Calendar.MONTH,monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH,dayOfmonth)

            var day = dayOfmonth.toString()
            val month: String

            if(dayOfmonth < 10){
                day = "0$dayOfmonth"
            }
            if (monthOfYear < 10) {
                month = "" + (monthOfYear+1)
            }else {
                month = (monthOfYear +1).toString()
            }

            data = "$day / $month / $year"


        }

        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            val minutes: String

            if(minute <10){
                minutes = "0$minute"

            }else {
                minutes = minute.toString()
            }

            hour = "$hourOfDay:$minutes"


        }

        binding.timePicker.setIs24HourView(true) // formatacao para 24 horas

        binding.buttonSchedule.setOnClickListener{
            val profissional1 = binding.profissional1
            val profissional2 = binding.profissional2
            val profissional3 = binding.profissional3


        when{
            hour.isEmpty() -> {
                message(it, "Marque um horario", "#FF0000")
            }
            hour <"8:00" && hour > "19:00" -> {
                message(it, "A Beauty Station nao esta aberta nesse horario - horario de atendimento das 08:00 ate as 18:00!", "#FF0000")

            }
            data.isEmpty() -> {
                message(it, "Marque uma data!", "#FF0000")
            }
            profissional1.isChecked && data.isNotEmpty() && hour.isNotEmpty() -> {
                message(it, "Agendamento realizado!", "#0CFF00")

            }
            profissional2.isChecked && data.isNotEmpty() && hour.isNotEmpty() -> {
                message(it, "Agendamento realizado!", "#0CFF00")

            }
            profissional3.isChecked && data.isNotEmpty() && hour.isNotEmpty() -> {
                message(it, "Agendamento realizado!", "#0CFF00")

            }
            else -> {
                message(it, "Escolha um Profissional!", "#FF0000")
            }
        }
        }
    }
    private fun message (view: View, message: String, color: String) {
        val snackbar = Snackbar.make(view,message,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(color))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()

    }
}