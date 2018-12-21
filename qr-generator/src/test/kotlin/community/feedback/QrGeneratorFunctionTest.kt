package community-feedback

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals


class QrGeneratorFunctionTest: Spek({

    describe("qr-generator function") {
        val server = ApplicationContext.run(EmbeddedServer::class.java)
        val client = server.applicationContext.getBean(QrGeneratorClient::class.java)

        it("should return 'qr-generator'") {
            assertEquals(client.index().blockingGet(), "qr-generator")
        }

        afterGroup {
            server.stop()
        }
    }
})
