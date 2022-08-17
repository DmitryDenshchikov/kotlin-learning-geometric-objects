package denshchikov.dmitry

import com.auth0.jwk.JwkProviderBuilder
import denshchikov.dmitry.model.plugins.configureRouting
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import java.net.URL
import java.util.concurrent.TimeUnit

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {

    val issuer = environment.config.property("jwt.issuer").getString()
    val jwkProviderUrl = environment.config.property("jwk.providerUrl").getString()

    install(Authentication) {
        val jwkProvider = JwkProviderBuilder(URL(jwkProviderUrl))
            .cached(10, 24, TimeUnit.HOURS)
            .rateLimited(10, 1, TimeUnit.MINUTES)
            .build()

        jwt("auth-jwt") {
            verifier(jwkProvider, issuer) {
                acceptLeeway(3)
            }

            validate { credential ->
                if (credential.payload.getClaim("name").asString() != "") {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
            challenge { defaultScheme, realm ->
                call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has expired")
            }
        }

    }
    configureRouting()
}