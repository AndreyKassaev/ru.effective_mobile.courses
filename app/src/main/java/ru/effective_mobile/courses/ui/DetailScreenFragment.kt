package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.effective_mobile.courses.databinding.FragmentDetailScreenBinding

class DetailScreenFragment : Fragment() {

    private lateinit var binding: FragmentDetailScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        courseDetailGoUp
        binding = FragmentDetailScreenBinding.inflate(inflater)

        binding.courseDetailGoUp.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

}