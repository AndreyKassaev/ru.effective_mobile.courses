package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.effective_mobile.courses.databinding.FragmentDetailScreenBinding

class DetailScreenFragment : Fragment() {

    private lateinit var binding: FragmentDetailScreenBinding
    private val args: DetailScreenFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)
        binding.apply {
            courseDetailTitle.text = args.courseId
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.courseDetailGoUp.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}