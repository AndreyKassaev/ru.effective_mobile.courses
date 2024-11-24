package ru.effective_mobile.courses.data.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Meta(

    @SerialName("page") var page: Int? = null,
    @SerialName("has_next") var hasNext: Boolean? = null,
    @SerialName("has_previous") var hasPrevious: Boolean? = null

)