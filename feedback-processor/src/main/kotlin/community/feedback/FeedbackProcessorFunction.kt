package community.feedback

import community.feedback.model.ApiGatewayResponse
import community.feedback.model.FeedbackRequest
import community.feedback.service.FeedbackProcessor
import community.feedback.service.FeedbackProcessorImpl
import io.micronaut.function.FunctionBean
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import java.util.function.Function

@FunctionBean("feedback-processor")
class FeedbackProcessorFunction : Function<FeedbackRequest, ApiGatewayResponse> {

    lateinit var feedbackProcessor: FeedbackProcessor

    @Consumes(MediaType.APPLICATION_JSON)
    override fun apply(req: FeedbackRequest): ApiGatewayResponse {
        feedbackProcessor = FeedbackProcessorImpl()
        feedbackProcessor.processFedback(req)

        return ApiGatewayResponse(200)
    }
}