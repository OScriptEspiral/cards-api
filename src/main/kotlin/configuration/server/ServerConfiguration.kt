package configuration.server

import configuration.exceptions.exceptions
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.jackson.jackson
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.websocket.WebSockets
import kotlinx.coroutines.ExperimentalCoroutinesApi
import routing.cardRoutes
import java.time.Duration

@ExperimentalCoroutinesApi
fun ktorServer() = embeddedServer(Netty, port = 8080) {
    installExceptions()
    installRequestPayloadDeserializer()
    cardRoutes()
}

fun Application.installRequestPayloadDeserializer() = install(ContentNegotiation) {
    jackson {  }
}

fun Application.installExceptions() = install(StatusPages) {
    exceptions()
}