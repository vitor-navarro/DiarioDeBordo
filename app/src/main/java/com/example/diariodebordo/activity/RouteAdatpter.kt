package com.example.diariodebordo.activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diariodebordo.R
import com.example.diariodebordo.data.database.entity.Route

class RouteAdapter(private val routes: List<Route>) : RecyclerView.Adapter<RouteAdapter.RouteViewHolder>() {

    class RouteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val routeInfoTextView: TextView = itemView.findViewById(R.id.routeInfoTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_route, parent, false)
        return RouteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        val currentRoute = routes[position]
        //holder.routeInfoTextView.text = "Placa: ${currentRoute.carPlate}, Km inicial: ${currentRoute.startKilometer}, Km final: ${currentRoute.endKilometer}"
        holder.routeInfoTextView.text = "Km inicial: ${currentRoute.initialMileage}, Km final: ${currentRoute.finalMileage}"

    }

    override fun getItemCount(): Int {
        return routes.size
    }
}
