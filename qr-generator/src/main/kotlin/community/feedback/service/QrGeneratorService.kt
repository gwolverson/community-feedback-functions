package community.feedback.service

interface QrGeneratorService {

    fun generateQrCode(): ByteArray?
}