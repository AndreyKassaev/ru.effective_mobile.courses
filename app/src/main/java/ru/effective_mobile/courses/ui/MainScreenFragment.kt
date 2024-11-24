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
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import courseAdapterDelegate
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effective_mobile.courses.databinding.FragmentMainScreenBinding
import ru.effective_mobile.courses.model.DisplayableItem
import ru.effective_mobile.courses.viewmodel.MainScreenVM

internal class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private lateinit var adapterMain: ListDelegationAdapter<List<DisplayableItem>>
    private val viewModel by viewModel<MainScreenVM>()
    private var scrollPosition: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterMain = ListDelegationAdapter(
            courseAdapterDelegate { courseId ->
                findNavController().navigate(
                    MainScreenFragmentDirections.actionMainScreenFragmentToDetailScreenFragment(
                        courseId
                    )
                )
            }
        )

        binding.mainScreenRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterMain
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == adapterMain.itemCount - 1) {
                        viewModel.getMoreCourseList()
                    }
                }
            })

        }


        lifecycleScope.launch {
            viewModel.getAllAvailableCourseListFlow().collectLatest { courseList ->
                adapterMain.items = courseList
                if (courseList.isNotEmpty()) binding.mainScreenRVProgressBar.visibility =
                    View.INVISIBLE
                adapterMain.notifyDataSetChanged()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val layoutManager = binding.mainScreenRV.layoutManager as LinearLayoutManager
        scrollPosition = layoutManager.findFirstCompletelyVisibleItemPosition()
    }

    override fun onResume() {
        super.onResume()
        binding.mainScreenRV.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (binding.mainScreenRV.layoutManager != null) {
                    binding.mainScreenRV.scrollToPosition(scrollPosition)
                    binding.mainScreenRV.viewTreeObserver.removeOnGlobalLayoutListener(this)
                }
            }
        })
    }
}
