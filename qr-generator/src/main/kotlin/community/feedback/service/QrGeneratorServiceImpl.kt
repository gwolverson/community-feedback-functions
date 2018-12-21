package community.feedback.service

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import java.io.ByteArrayOutputStream

class QrGeneratorServiceImpl : QrGeneratorService {

    val localEndpoint = "http://localhost:8080"
    val awsEndpoint = "http://community-feedback-frontend.s3-website.eu-west-2.amazonaws.com/"

    override fun generateQrCode(): ByteArray? {
        val qrCodeWriter = QRCodeWriter()
        val bitMatrix = qrCodeWriter.encode(
                awsEndpoint,
                BarcodeFormat.QR_CODE,
                350, 350) // width x height

        val pngStream = ByteArrayOutputStream()
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngStream)
        return pngStream.toByteArray()
    }
}