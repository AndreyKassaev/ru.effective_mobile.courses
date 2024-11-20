package ru.effective_mobile.courses.recycle_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.effective_mobile.courses.R
import ru.effective_mobile.courses.databinding.CourseCardBinding
import ru.effective_mobile.courses.ui.MainScreenFragmentDirections

class CourseRvAdapter(
    val itemList: MutableList<CourseCardModel>,
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

        fun bind(item: CourseCardModel) {
            binding.apply {
                cardDetailTitleTV.text = item.title
                cardDetailTextBodyTV.text = item.textBody
                cardDetailPriceTV.text = item.price
                cardDetailRateTV.text = item.rate
                cardDetailDateTV.text = item.date
                cardDetailFavoriteIcon.setImageResource(if (item.isFavorite) R.drawable.bookmark_fill else R.drawable.bookmark_card)
                cardDetailImageUrl.load(item.imageUrl) {
                    crossfade(true)
                    placeholder(R.color.stroke)
                    error(R.drawable.search)
                }
            }

            val direction =
                MainScreenFragmentDirections.actionMainScreenFragmentToDetailScreenFragment(item.title)
            binding.courseCardContainer.setOnClickListener {
                it.findNavController().navigate(direction)
            }
        }

    }

}