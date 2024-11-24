package ru.effective_mobile.courses.data.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class CanBeBought(

    @SerialName("enabled") var enabled: Boolean? = null

)