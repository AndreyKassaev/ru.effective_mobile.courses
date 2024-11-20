package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effective_mobile.courses.databinding.FragmentDetailScreenBinding
import ru.effective_mobile.courses.viewmodel.DetailScreenVM

internal class DetailScreenFragment : Fragment() {

    private lateinit var binding: FragmentDetailScreenBinding
    private val viewModel by viewModel<DetailScreenVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.courseDetailGoUp.setOnClickListener {
            findNavController().popBackStack()
        }
        lifecycleScope.launch {
            viewModel.getCourseFlow().collectLatest { course ->
                binding.courseDetailTitle.text = course.title
            }
        }
    }
}