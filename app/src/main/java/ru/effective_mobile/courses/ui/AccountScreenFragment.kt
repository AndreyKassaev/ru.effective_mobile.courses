package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effective_mobile.courses.databinding.FragmentAccountScreenBinding
import ru.effective_mobile.courses.recycle_view.CourseRvAdapter
import ru.effective_mobile.courses.viewmodel.AccountScreenVM

internal class AccountScreenFragment : Fragment() {

    private lateinit var binding: FragmentAccountScreenBinding
    private val viewModel by viewModel<AccountScreenVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountScreenBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            viewModel.getCourseListFlow().collectLatest { courseList ->
                binding.accountScreenRV.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = CourseRvAdapter(courseList)
                }
            }
        }

        return binding.root
    }

}