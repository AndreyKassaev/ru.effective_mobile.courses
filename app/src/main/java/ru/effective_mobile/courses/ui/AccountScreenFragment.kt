package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effective_mobile.courses.databinding.FragmentAccountScreenBinding
import ru.effective_mobile.courses.model.Course
import ru.effective_mobile.courses.recycle_view.CourseRvAdapter
import ru.effective_mobile.courses.viewmodel.AccountScreenVM

internal class AccountScreenFragment : Fragment() {

    private lateinit var binding: FragmentAccountScreenBinding
    private val viewModel by viewModel<AccountScreenVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountScreenBinding.inflate(inflater)

        binding.accountScreenRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CourseRvAdapter(MutableList(20) { Course.mock })
        }

        return binding.root
    }

}