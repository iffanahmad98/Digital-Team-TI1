package com.syahrulsamudra_18102142.mainactivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syahrulsamudra_18102142.mainactivity.adapter.TicketAdapter
import com.syahrulsamudra_18102142.mainactivity.firestore.FirestoreTiket
import kotlinx.android.synthetic.main.fragment_ticket.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_ticket.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_ticket : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FirestoreTiket.getActiveTicket { b, list ->
            rvTiket.adapter = TicketAdapter(requireContext(), list)
        }
    }


}