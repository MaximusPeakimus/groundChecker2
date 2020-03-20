package com.example.groundchecker

import android.view.LayoutInflater
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.squareup.picasso.Picasso

class ListAdapter(val context: Context, val list: ArrayList<Teams>):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false)

        val teamName = view.findViewById(R.id.team_name) as AppCompatTextView
        val teamBadge = view.findViewById(R.id.team_badge) as AppCompatImageView
        val teamFounded = view.findViewById(R.id.team_founded) as AppCompatTextView
        val stadiumName = view.findViewById(R.id.stadium_name) as AppCompatTextView

        teamName.text = list[position].name
        Picasso.get().load(list[position].badge).into(teamBadge);
        teamFounded.text = list[position].founded
        stadiumName.text = list[position].stadium

        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}