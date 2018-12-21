package community.feedback.service

import community.feedback.model.FeedbackRequest

interface FeedbackProcessor {

    fun processFedback(data: FeedbackRequest)
}