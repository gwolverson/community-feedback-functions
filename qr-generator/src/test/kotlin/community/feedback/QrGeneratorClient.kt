package community-feedback

import io.micronaut.function.client.FunctionClient
import io.reactivex.Single
import javax.inject.Named

@FunctionClient
interface QrGeneratorClient {

    @Named("qr-generator")
    fun index(): Single<String>

}
