package ru.effective_mobile.courses.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.effective_mobile.courses.R
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
                binding.apply {
                    if (course.courseId == "-1") {
                        courseDetailProgressBar.visibility = View.VISIBLE
                        courseDetailScrollView.visibility = View.INVISIBLE
                    } else {
                        courseDetailProgressBar.visibility = View.INVISIBLE
                        courseDetailScrollView.visibility = View.VISIBLE
                    }
                    courseDetailFavoriteIcon.setOnClickListener { icon ->
                        viewModel.toggleFavorite(courseId = course.courseId)
                        courseDetailFavoriteIcon.setImageResource(R.drawable.bookmark_card_fill)
                    }
                    courseDetailTitle.text = course.title
                    courseDetailDesc.text = course.desc
                    courseDetailRate.text = course.rate
                    courseDetailDate.text = course.date
                    courseDetailFavoriteIcon.setImageResource(if (course.isFavorite) R.drawable.bookmark_card_fill else R.drawable.bookmark_detail)
                    courseDetailImage.load(course.imageUrl) {
                        crossfade(true)
                        placeholder(R.color.stroke)
                        error(R.drawable.search)
                    }
                    courseDetailVendorIcon.load(course.vendor.imageUrl) {
                        crossfade(true)
                        placeholder(R.color.stroke)
                        error(R.drawable.search)
                    }
                    courseDetailVendorName.text = course.vendor.name
                    goToCourseVendorBtn.setOnClickListener {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(course.canonicalUrl)
                            )
                        )
                    }
                    startCourseBtn.setOnClickListener {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(course.canonicalUrl)
                            )
                        )
                    }
                }
            }
        }
    }
}