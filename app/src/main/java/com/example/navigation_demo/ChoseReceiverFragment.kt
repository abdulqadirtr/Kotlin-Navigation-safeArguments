package com.example.navigation_demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_chose_receiver.*
import kotlinx.android.synthetic.main.fragment_chose_receiver.view.*
import kotlinx.android.synthetic.main.fragment_send_cash.view.*

class ChoseReceiverFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =inflater.inflate(R.layout.fragment_chose_receiver, container, false)

        view.btn_next.setOnClickListener {
            val receiverName = view.et_receiver_name.text.toString()
           // val amount = view.et_amount.text.toString().toLong()

            val action = ChoseReceiverFragmentDirections.actionChoseReceiverFragmentToSendCashFragment(receiverName , 300)
       findNavController().navigate(action)
        }




        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_cancel.setOnClickListener {

             findNavController().popBackStack()

        }
    }


    }
