package community-feedback

import io.micronaut.function.client.FunctionClient
import io.reactivex.Single
import javax.inject.Named

@FunctionClient
interface FeedbackProcessorClient {

    @Named("feedback-processor")
    fun index(): Single<String>

}
