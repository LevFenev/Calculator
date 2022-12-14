package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {

    private var _binding: FragmentFourthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!! // getter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    // показывает в какую переменную будут складываться все связи с компонентами данного фрагмента
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = (activity as MainActivity)
        val firstNum = activity.firstNum
        val secondNum = activity.secondNum
        val operation = activity.operation
        var result = "Unknown Error"

        if (operation == "+") {
            result = (firstNum + secondNum).toString()
            result = "$firstNum + $secondNum = $result"
        }

        view.findViewById<TextView>(R.id.textview_fourth).text = result

        /*binding.buttonFourthNext.setOnClickListener {
            findNavController().navigate(R.id.action_FourthFragment_to_FirstFragment)
        }*/

        binding.buttonFourthPrev.setOnClickListener {
            findNavController().navigate(R.id.action_FourthFragment_to_ThirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}