package community.feedback.model

data class ApiGatewayResponse(val statusCode: Int, val body: String, val headers: Map<String, String>, val isIsBase64Encoded: Boolean = false)