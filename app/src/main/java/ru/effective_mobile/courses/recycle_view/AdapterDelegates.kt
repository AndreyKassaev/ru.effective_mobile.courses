import coil.load
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.effective_mobile.courses.R
import ru.effective_mobile.courses.databinding.CourseCardBinding
import ru.effective_mobile.courses.model.Course
import ru.effective_mobile.courses.model.DisplayableItem

fun courseAdapterDelegate(itemClickedListener: (String) -> Unit) =
    adapterDelegateViewBinding<Course, DisplayableItem, CourseCardBinding>(
        { layoutInflater, root -> CourseCardBinding.inflate(layoutInflater, root, false) }
    ) {
        binding.courseCardContainer.setOnClickListener {
            itemClickedListener(item.courseId)
        }
        bind {
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
        }
    }