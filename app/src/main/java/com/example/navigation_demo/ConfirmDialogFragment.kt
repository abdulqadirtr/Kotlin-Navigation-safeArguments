package com.example.navigation_demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_confirm_dialog.*

class ConfirmDialogFragment : BottomSheetDialogFragment() {

    private val args: ConfirmDialogFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       return inflater.inflate(R.layout.fragment_confirm_dialog, container, false  )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receiverName = args.recieverName
        val amount = args.amount.toString().toLong()
        tv_message.text = "Do you want to receive money from {$receiverName} of amount {$amount}"

        btn_yes.setOnClickListener {
            dismiss()
        }

        btn_no.setOnClickListener {
            dismiss()
        }

    }
}