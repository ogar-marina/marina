package com.example.permissionsanddate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_location_info.view.*
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class LocationAdapter: RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private var locationList = emptyList<LocationInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_location_info, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = locationList[position]
        holder.setData(location)
    }

    override fun getItemCount(): Int {
        return locationList.size
    }

    fun setData(locationList: List<LocationInfo>){
        this.locationList = locationList
        notifyDataSetChanged()
    }

    class ViewHolder(item:View): RecyclerView.ViewHolder(item){

        private val formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy")
            .withZone(ZoneId.systemDefault())
        fun setData(locationInfo: LocationInfo){
            itemView.latitude.text = locationInfo.lat.toString()
            itemView.lng.text = locationInfo.lng.toString()
            itemView.idInfo.text = locationInfo.id
            itemView.time.text = formatter.format(locationInfo.time)
        }
    }
}