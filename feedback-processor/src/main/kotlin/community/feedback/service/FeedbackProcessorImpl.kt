package community.feedback.service

import community.feedback.model.FeedbackRequest
import community.feedback.repository.RepositoryImpl

class FeedbackProcessorImpl : FeedbackProcessor {

    lateinit var repositoryImpl: RepositoryImpl

    override fun processFedback(data: FeedbackRequest) {
        println(data)

        repositoryImpl = RepositoryImpl()
        repositoryImpl.insertAttendance(data)
    }
}