package ru.effective_mobile.courses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import courseAdapterDelegate
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effective_mobile.courses.databinding.FragmentAccountScreenBinding
import ru.effective_mobile.courses.model.CourseMapper.mapToAppCourseList
import ru.effective_mobile.courses.model.DisplayableItem
import ru.effective_mobile.courses.viewmodel.AccountScreenVM

internal class AccountScreenFragment : Fragment() {

    private lateinit var binding: FragmentAccountScreenBinding
    private lateinit var adapterPersonal: ListDelegationAdapter<List<DisplayableItem>>
    private val viewModel by viewModel<AccountScreenVM>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterPersonal = ListDelegationAdapter(
            courseAdapterDelegate { courseId ->
                findNavController().navigate(
                    AccountScreenFragmentDirections.actionAccountScreenFragmentToDetailScreenFragment(
                        courseId
                    )
                )
            }
        )

        lifecycleScope.launch {
            viewModel.getCourseListFlow().collectLatest { courseList ->
                binding.accountScreenRV.apply {
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = adapterPersonal
                }
                adapterPersonal.items = mapToAppCourseList(courseList)
            }
        }
    }
}