package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonThirdNext.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_FourthFragment)
        }

        binding.buttonThirdPrev.setOnClickListener {
            findNavController().navigate(R.id.action_ThirdFragment_to_SecondFragment)
        }

        (activity as MainActivity).operation = "Null" // каждый раз, когда пользователь попадает на эту страницу, знак будет приравниваться к Null

        // кнопки мат. операций
        binding.buttonOperationPlus.setOnClickListener {
            (activity as MainActivity).operation = "+"
        }

        binding.buttonOperationMinus.setOnClickListener {
            (activity as MainActivity).operation = "-"
        }

        binding.buttonOperationMultiplication.setOnClickListener {
            (activity as MainActivity).operation = "*"
        }

        binding.buttonOperationDivision.setOnClickListener {
            (activity as MainActivity).operation = "/"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}