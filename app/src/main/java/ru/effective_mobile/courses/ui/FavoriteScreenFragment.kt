package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import courseAdapterDelegate
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effective_mobile.courses.databinding.FragmentFavoriteScreenBinding
import ru.effective_mobile.courses.model.CourseMapper.mapToAppCourseList
import ru.effective_mobile.courses.model.DisplayableItem
import ru.effective_mobile.courses.viewmodel.FavoriteScreenVM

internal class FavoriteScreenFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteScreenBinding
    private lateinit var adapterFavorite: ListDelegationAdapter<List<DisplayableItem>>
    private val viewModel by viewModel<FavoriteScreenVM>()
    private var scrollPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterFavorite = ListDelegationAdapter(
            courseAdapterDelegate { courseId ->
                findNavController().navigate(
                    FavoriteScreenFragmentDirections.actionFavoriteScreenFragmentToDetailScreenFragment(
                        courseId
                    )
                )
            }
        )

        lifecycleScope.launch {
            viewModel.getCourseListFlow().collectLatest { courseList ->
                binding.favoriteScreenRv.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = adapterFavorite
                }
                adapterFavorite.items = courseList
                adapterFavorite.notifyDataSetChanged()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val layoutManager = binding.favoriteScreenRv.layoutManager as LinearLayoutManager
        scrollPosition = layoutManager.findFirstCompletelyVisibleItemPosition()
    }

    override fun onResume() {
        super.onResume()
        binding.favoriteScreenRv.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (binding.favoriteScreenRv.layoutManager != null) {
                    binding.favoriteScreenRv.scrollToPosition(scrollPosition)
                    binding.favoriteScreenRv.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            }
        })
    }
}