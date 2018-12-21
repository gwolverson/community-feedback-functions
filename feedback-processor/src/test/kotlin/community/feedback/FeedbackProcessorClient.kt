package community.feedback

import community.feedback.model.FeedbackRequest
import io.micronaut.function.client.FunctionClient
import io.micronaut.http.annotation.Body
import io.reactivex.Single
import javax.inject.Named

@FunctionClient
interface FeedbackProcessorClient {

    @Named("feedback-processor")
    fun apply(@Body feedbackRequest: FeedbackRequest): Single<String>

}
