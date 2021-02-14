package com.syahrulsamudra_18102142.mainactivity

import com.google.firebase.firestore.DocumentId

data class TiketModel(
    @DocumentId
    val idTiket: String = "",
    val date: String = "",
    val totalTiket: Int = 0,
    val totalBayar: Int = 0,
    val metodePembayaran: String = "",
    val dataWisata: MyData? = MyData("", "", "", 0.toDouble(), 0.toDouble(), 0),
    val idUser: String = "",
    val taken: Boolean = false
)