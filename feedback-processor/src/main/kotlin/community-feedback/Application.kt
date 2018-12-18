package community-feedback

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("community-feedback")
                .mainClass(Application.javaClass)
                .start()
    }
}