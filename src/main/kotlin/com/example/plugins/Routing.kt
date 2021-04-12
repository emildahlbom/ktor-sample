package com.example.plugins

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!", ContentType.Text.Plain)
            call.respondText("Tjenare Världen!", ContentType.Text.Plain)
            call.respondText("Hola el mundo!", ContentType.Text.Plain)
        }
    }
}
