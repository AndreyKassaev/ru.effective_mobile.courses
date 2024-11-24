package ru.effective_mobile.courses.data.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class EditAdvancedSettings(

    @SerialName("enabled") var enabled: Boolean? = null,
    @SerialName("needs_permission") var needsPermission: String? = null

)