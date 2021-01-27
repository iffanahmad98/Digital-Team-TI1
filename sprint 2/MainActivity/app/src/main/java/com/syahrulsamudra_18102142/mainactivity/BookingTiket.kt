package com.syahrulsamudra_18102142.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_booking_tiket.*
import kotlinx.android.synthetic.main.activity_login.*

class BookingTiket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_tiket)

        btnBooking.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Booking Berhasil", Toast.LENGTH_SHORT).show()
        }
    }
}