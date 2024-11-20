package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effective_mobile.courses.databinding.FragmentMainScreenBinding
import ru.effective_mobile.courses.model.Course
import ru.effective_mobile.courses.recycle_view.CourseRvAdapter
import ru.effective_mobile.courses.viewmodel.MainScreenVM

internal class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel by viewModel<MainScreenVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainScreenRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CourseRvAdapter(
                itemList = MutableList(20) { Course.mock },
            )
        }
    }
}
