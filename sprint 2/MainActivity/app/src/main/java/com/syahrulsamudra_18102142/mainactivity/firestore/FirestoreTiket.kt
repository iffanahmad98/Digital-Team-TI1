package com.syahrulsamudra_18102142.mainactivity.firestore

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.syahrulsamudra_18102142.mainactivity.TiketModel

object FirestoreTiket {
    private val instance = FirebaseFirestore.getInstance()
    private const val collection = "tickets"

    fun createTicket(tiketModel: TiketModel, callback: (Boolean) -> Unit) {
        instance.collection(collection).document().set(tiketModel)
            .addOnSuccessListener {
                callback(true)
            }.addOnFailureListener {
                callback(false)
            }
    }

    fun getActiveTicket(callback: (Boolean, MutableList<TiketModel>) -> Unit) {
        val idUser = Firebase.auth.currentUser?.uid
        instance.collection(collection).whereEqualTo("idUser", idUser)
            .whereEqualTo("taken", false).get().addOnSuccessListener {
                callback(true, it.toObjects(TiketModel::class.java))
            }.addOnFailureListener {
                callback(false, mutableListOf())
            }


    }

    fun takeTiket(idTiket: String, callback: (Boolean) -> Unit) {
        instance.collection(collection).document(idTiket).update("taken", true)
            .addOnSuccessListener {
                callback(true)
            }.addOnFailureListener {
                callback(false)
            }
    }

    fun getAllTicket(callback: (Boolean, MutableList<TiketModel>) -> Unit) {
        val idUser = Firebase.auth.currentUser?.uid
        instance.collection(collection).whereEqualTo("idUser", idUser).get().addOnSuccessListener {
            callback(true, it.toObjects(TiketModel::class.java))
        }.addOnFailureListener {
            callback(false, mutableListOf())
        }


    }
}