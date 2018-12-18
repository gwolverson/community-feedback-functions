package community-feedback

import io.micronaut.function.FunctionBean
import java.util.function.Supplier

@FunctionBean("feedback-processor")
class FeedbackProcessorFunction : Supplier<String> {

    override fun get(): String {
        return "feedback-processor"
    }
}