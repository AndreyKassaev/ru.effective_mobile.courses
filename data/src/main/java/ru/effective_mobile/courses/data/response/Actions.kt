package ru.effective_mobile.courses.data.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Actions(

    @SerialName("view_reports") var viewReports: ViewReports? = ViewReports(),
    @SerialName("edit_reports") var editReports: EditReports? = EditReports(),
    @SerialName("view_grade_book_page") var viewGradeBookPage: ViewGradeBookPage? = ViewGradeBookPage(),
    @SerialName("view_grade_book") var viewGradeBook: ViewGradeBook? = ViewGradeBook(),
    @SerialName("edit_lti") var editLti: EditLti? = EditLti(),
    @SerialName("edit_advanced_settings") var editAdvancedSettings: EditAdvancedSettings? = EditAdvancedSettings(),
    @SerialName("manage_permissions") var managePermissions: ManagePermissions? = ManagePermissions(),
    @SerialName("view_revenue") var viewRevenue: ViewRevenue? = ViewRevenue(),
    @SerialName("can_be_bought") var canBeBought: CanBeBought? = CanBeBought(),
    @SerialName("can_be_price_changed") var canBePriceChanged: CanBePriceChanged? = CanBePriceChanged(),
    @SerialName("can_be_deleted") var canBeDeleted: CanBeDeleted? = CanBeDeleted(),
    @SerialName("edit_tags") var editTags: EditTags? = EditTags()

)