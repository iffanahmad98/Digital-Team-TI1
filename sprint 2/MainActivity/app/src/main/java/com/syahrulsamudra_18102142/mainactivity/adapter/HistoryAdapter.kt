package com.syahrulsamudra_18102142.mainactivity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.syahrulsamudra_18102142.mainactivity.R
import com.syahrulsamudra_18102142.mainactivity.TiketModel
import com.syahrulsamudra_18102142.mainactivity.firestore.FirestoreTiket
import kotlinx.android.synthetic.main.list_ticket.view.*

class HistoryAdapter(val context: Context, private val tickets: MutableList<TiketModel>) :
    RecyclerView.Adapter<HistoryAdapter.TicketViewHolder>() {

    inner class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            tiketModel: TiketModel
        ) {
            itemView.apply {
                tv_item_name.text = tiketModel.dataWisata?.name
                tv_item_price.text = "${tiketModel.totalBayar} (${tiketModel.totalTiket})"
                Glide.with(itemView).load(tiketModel.dataWisata?.photo).into(img_item_photo)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_history, parent, false)
        return TicketViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tickets.size

    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.bind(tickets[position])
    }


}