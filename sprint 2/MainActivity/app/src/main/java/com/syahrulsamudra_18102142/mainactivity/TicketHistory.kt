package com.syahrulsamudra_18102142.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syahrulsamudra_18102142.mainactivity.adapter.HistoryAdapter
import com.syahrulsamudra_18102142.mainactivity.firestore.FirestoreTiket
import kotlinx.android.synthetic.main.activity_ticket_history.*

class TicketHistory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_history)

        FirestoreTiket.getAllTicket { b, list ->
            rvTiket.adapter = HistoryAdapter(this, list)
        }
    }
}