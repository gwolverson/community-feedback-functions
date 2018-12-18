package community-feedback

import io.micronaut.function.FunctionBean
import java.util.function.Supplier

@FunctionBean("qr-generator")
class QrGeneratorFunction : Supplier<String> {

    override fun get(): String {
        return "qr-generator"
    }
}