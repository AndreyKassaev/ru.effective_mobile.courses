package ru.effective_mobile.courses.recycle_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.effective_mobile.courses.R
import ru.effective_mobile.courses.databinding.CourseCardBinding
import ru.effective_mobile.courses.domain.model.Course
import ru.effective_mobile.courses.ui.MainScreenFragmentDirections

class CourseRvAdapter(
    val itemList: List<Course>,
) : RecyclerView.Adapter<CourseRvAdapter.ViewHolder>() {

    private lateinit var binding: CourseCardBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseRvAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = CourseCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseRvAdapter.ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.size

    inner class ViewHolder(itemView: CourseCardBinding) : RecyclerView.ViewHolder(itemView.root) {

        fun bind(item: Course) {
            binding.apply {
                cardDetailTitle.text = item.title
                cardDetailAds.text = item.ads
                cardDetailPrice.text = item.price
                cardDetailRate.text = item.rate
                cardDetailDate.text = item.date
                cardDetailFavoriteIcon.setImageResource(if (item.isFavorite) R.drawable.bookmark_fill else R.drawable.bookmark_card)
                cardDetailImageUrl.load(item.imageUrl) {
                    crossfade(true)
                    placeholder(R.color.stroke)
                    error(R.drawable.search)
                }
            }

            binding.courseCardContainer.setOnClickListener {
                it.findNavController().navigate(
                    MainScreenFragmentDirections.actionMainScreenFragmentToDetailScreenFragment(
                        item.title
                    )
                )
            }
        }
    }
}