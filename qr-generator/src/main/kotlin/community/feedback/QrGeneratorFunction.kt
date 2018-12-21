package community.feedback

import community.feedback.service.QrGeneratorService
import community.feedback.service.QrGeneratorServiceImpl
import io.micronaut.function.FunctionBean
import io.micronaut.http.annotation.Produces
import java.nio.charset.StandardCharsets
import java.util.*
import java.util.function.Supplier

@FunctionBean("qr-generator")
class QrGeneratorFunction : Supplier<ByteArray?> {

    lateinit var qrGeneratorService : QrGeneratorService

    @Produces("image/png")
    override fun get(): ByteArray? {
        qrGeneratorService = QrGeneratorServiceImpl()

        val headers = HashMap<String, String>()
        headers["Accept"] = "image/png"

        return qrGeneratorService.generateQrCode()
    }
}