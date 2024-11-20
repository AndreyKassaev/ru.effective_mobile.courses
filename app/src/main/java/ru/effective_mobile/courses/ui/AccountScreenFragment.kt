package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.effective_mobile.courses.databinding.FragmentAccountScreenBinding
import ru.effective_mobile.courses.recycle_view.CourseCardModel
import ru.effective_mobile.courses.recycle_view.CourseRvAdapter

class AccountScreenFragment : Fragment() {

    lateinit var binding: FragmentAccountScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountScreenBinding.inflate(inflater)

        binding.accountScreenRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CourseRvAdapter(MutableList(20) { CourseCardModel.mock })
        }

        return binding.root
    }

}