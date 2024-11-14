package com.example.homework_month4.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.homework_month4.R
import com.example.homework_month4.databinding.FragmentHomeBinding
import com.example.homework_month4.ui.User


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener(): View? {
        binding.buttonSend.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (email.contains("@")) {
                val user = User(name, email, password)
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToSecondFragment(user)
                )
            } else {
                Toast.makeText(requireContext(), "Некорректный адрес эл. почты", Toast.LENGTH_LONG)
                    .show()
            }
        }
        return view
    }
}