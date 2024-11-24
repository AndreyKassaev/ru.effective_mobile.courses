package ru.effective_mobile.courses.data.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class EditTags(

    @SerialName("enabled") var enabled: Boolean? = null

)