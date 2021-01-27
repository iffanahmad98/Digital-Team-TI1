package com.syahrulsamudra_18102142.mainactivity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.syahrulsamudra_18102142.mainactivity.BC.MainActivitysms
import com.syahrulsamudra_18102142.mainactivity.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profil.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_profil.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_profil : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_lgout.setOnClickListener{
            activity?.let{
                val intent = Intent (it, LoginActivity::class.java)
                it.startActivity(intent)
            }
        }

        btnSMS.setOnClickListener{
            activity?.let {
                val intent = Intent(it, MainActivitysms::class.java)
                it.startActivity(intent)
            }
        }
    }



    companion object {
        fun newInstance(): fragment_profil{
            val fragment = fragment_profil()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}