package com.example.navigation_demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_send_cash.*
import kotlinx.android.synthetic.main.fragment_send_cash.view.*

class SendCashFragment : Fragment() {
    private val args: SendCashFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_send_cash, container, false)
        val navControl = findNavController()
        val recieverName = args.receiverName

        view.et_amount.setText(SampleData.defaultAmount.value.toString())
        SampleData.defaultAmount.observe(viewLifecycleOwner) {
            view.et_amount.setText(it.toString())
        }


        Toast.makeText(requireContext(), recieverName, Toast.LENGTH_LONG).show()
        view.tv_receiver.text = "Send Cash to ${recieverName.toString()}"

        view.btn_send.setOnClickListener {
            if (view.et_amount.text.toString().isEmpty())
                return@setOnClickListener

            val amount = view.et_amount.text.toString().toLong()

            val action = SendCashFragmentDirections.actionSendCashFragmentToConfirmDialogFragment2(
                recieverName,
                amount
            )
            navControl.navigate(action)
        }

        view.btn_done.setOnClickListener {
            val action = SendCashFragmentDirections.actionSendCashFragmentToHomeFragment()
            navControl.navigate(action)

        }

        view.btn_cancel.setOnClickListener {
            findNavController().popBackStack(R.id.fragment_home, true)

        }

        return view
    }

}