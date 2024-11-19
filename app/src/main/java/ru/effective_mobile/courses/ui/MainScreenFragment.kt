package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.effective_mobile.courses.R
import ru.effective_mobile.courses.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater)

        binding.sortByText.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_detailScreenFragment)
        }
        return binding.root
    }

}