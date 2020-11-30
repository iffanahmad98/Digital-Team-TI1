package com.syahrulsamudra_18102142.mainactivity.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.syahrulsamudra_18102142.mainactivity.ArtikelActivity
import com.syahrulsamudra_18102142.mainactivity.MyData
import com.syahrulsamudra_18102142.mainactivity.R

class CardViewMyDataAdapter(private val listMyDatas: ArrayList<MyData>, val context: Context) :
    RecyclerView.Adapter<CardViewMyDataAdapter.CardViewViewHolder>() {

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMyDatas.size
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val myData = listMyDatas[position]
        Glide.with(holder.itemView.context)
            .load(myData.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = myData.name
        holder.tvDetail.text = myData.description

        holder.itemView.setOnClickListener {
            val moveWithObjectIntent = Intent(context, ArtikelActivity::class.java)
            moveWithObjectIntent.putExtra(ArtikelActivity.EXTRA_MYDATA, myData)
            context.startActivity(moveWithObjectIntent) }
    }
}