package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effective_mobile.courses.databinding.FragmentFavoriteScreenBinding
import ru.effective_mobile.courses.model.Course
import ru.effective_mobile.courses.recycle_view.CourseRvAdapter
import ru.effective_mobile.courses.viewmodel.FavoriteScreenVM

internal class FavoriteScreenFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteScreenBinding
    private val viewModel by viewModel<FavoriteScreenVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFavoriteScreenBinding.inflate(inflater)

        binding.favoriteScreenRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CourseRvAdapter(MutableList(20) { Course.mock })
        }

        return binding.root
    }

}