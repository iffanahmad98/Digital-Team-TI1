package com.syahrulsamudra_18102142.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.syahrulsamudra_18102142.mainactivity.firestore.FirestoreTiket
import kotlinx.android.synthetic.main.activity_booking_tiket.*
import kotlinx.android.synthetic.main.activity_login.*

class BookingTiket : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_tiket)

        val myData = intent.getParcelableExtra<MyData>(EXTRA_DATA)
        var price = 0;
        var totalPay = 0;
        myData?.price?.let {
            price = it
            hargaTiket.text = "Harga Tiket : ${it}"
        }

        btnBooking.setOnClickListener {

            btnBooking.text = "Loading"
            val metodeBayar = when {
                rb_dana.isChecked -> "Dana"
                rb_link.isChecked -> "Link Aja"
                rb_ovo.isChecked -> "OVO"
                rb_banking.isChecked -> "Mobile Banking"
                else -> ""
            }

            totalPay = price * totalTiket.text.toString().toInt()

            val tiketModel = TiketModel(
                date = "${date_Picker.dayOfMonth}-${date_Picker.month}-${date_Picker.year}",
                totalTiket = totalTiket.text.toString().toInt(),
                totalBayar = totalPay,
                metodePembayaran = metodeBayar,
                dataWisata = myData,
                idUser = Firebase.auth.currentUser?.uid?:""
            )

            FirestoreTiket.createTicket(tiketModel) {
                if (it) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finishAffinity()
                    Toast.makeText(this, "Booking Berhasil", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Booking Gagal", Toast.LENGTH_SHORT).show()
                }
                btnBooking.text = "Booking Berhasil"
            }


        }
    }
}