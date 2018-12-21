import community.feedback.FeedbackProcessorClient
import community.feedback.model.FeedbackRequest
import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals


class FeedbackProcessorFunctionTest: Spek({

    describe("feedback-processor function") {
        val server = ApplicationContext.run(EmbeddedServer::class.java)
        val client = server.applicationContext.getBean(FeedbackProcessorClient::class.java)

        it("should return 'success'") {
            val feedbackRequest = FeedbackRequest(name = "Bob")
            assertEquals(client.apply(feedbackRequest).blockingGet(), "Success")
            println(client.apply(feedbackRequest).blockingGet())
        }

        afterGroup {
            server.stop()
        }
    }
})
