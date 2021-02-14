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

class TicketAdapter(val context: Context, private val tickets: MutableList<TiketModel>) :
    RecyclerView.Adapter<TicketAdapter.TicketViewHolder>() {

    inner class TicketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            tiketModel: TiketModel,
            position: Int,
            context: Context,
            callback: (TiketModel) -> Unit
        ) {
            itemView.apply {
                tv_item_name.text = tiketModel.dataWisata?.name
                tv_item_price.text = "${tiketModel.totalBayar} (${tiketModel.totalTiket})"
                Glide.with(itemView).load(tiketModel.dataWisata?.photo).into(img_item_photo)

                btn_set_use.setOnClickListener {
                    FirestoreTiket.takeTiket(tiketModel.idTiket) {
                        if (it) {
                            Toast.makeText(context, "Tiket Berhasil Dipakai", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            Toast.makeText(context, "Tiket Gagal Dipakai", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_ticket, parent, false)
        return TicketViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tickets.size

    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        holder.bind(tickets[position], position, context){
            tickets.remove(it)
            notifyDataSetChanged()
        }
    }


}