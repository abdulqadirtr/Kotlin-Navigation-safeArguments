package com.example.navigation_demo

import android.app.NotificationManager
import android.app.PendingIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
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

            val pendingIntent = findNavController()
                .createDeepLink()
                .setGraph(R.navigation.nav_graph)
                .setDestination(R.id.sendCashFragment)
                .setArguments(SendCashFragmentArgs(receiverName).toBundle())
                .createPendingIntent()

            showNotificationPending(pendingIntent, receiverName)
            
            val action = ChoseReceiverFragmentDirections.actionChoseReceiverFragmentToSendCashFragment(receiverName)
       findNavController().navigate(action)
        }




        return view
    }

    private fun showNotificationPending(pendingIntent: PendingIntent, receiverName: String) {

        val notificatoin = NotificationCompat.Builder(requireContext(), channelId)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle("Complete Transaction")
            .setContentText("Send Money to $receiverName")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        return NotificationManagerCompat.from(requireContext()).notify(1002, notificatoin)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_cancel.setOnClickListener {

             findNavController().popBackStack()

        }
    }


    }
