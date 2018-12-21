package community.feedback.repository

import community.feedback.model.FeedbackRequest

interface Repository {

    fun insertAttendance(feedbackRequest: FeedbackRequest)
}