package com.example.beautystation.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beautystation.databinding.ServicesItemBinding
import com.example.beautystation.models.Services

class ServicesAdapter(private val context: Context , private val servicesList: MutableList<Services>): RecyclerView.Adapter<ServicesAdapter.ServiceViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val itemList = ServicesItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ServiceViewHolder(itemList)
    }

    override fun getItemCount() = servicesList.size

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.imgService.setImageResource(servicesList[position].img!!)
        holder.txtService.text = servicesList[position].nome
    }

    inner class ServiceViewHolder(binding: ServicesItemBinding): RecyclerView.ViewHolder(binding.root) {
        val imgService = binding.imageServices
        val txtService = binding.textServices

    }
}