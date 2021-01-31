package com.example.navigation_demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.NavGraph
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_notification.*
import kotlinx.android.synthetic.main.fragment_setting.*

class NotificationFragment : Fragment(R.layout.fragment_notification) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lv_notifications.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,getNotifications())

    }

    private fun getNotifications():List<String>{
        val notifications = mutableListOf<String>()

        for(i in 1..20){
            notifications.add("Notification # $i")
        }
        return notifications
    }
}