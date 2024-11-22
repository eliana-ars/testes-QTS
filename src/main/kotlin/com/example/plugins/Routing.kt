package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.HttpStatusCode

fun Application.configureRouting() {

    configurarRotasCalculadora()
}

fun Application.configurarRotasCalculadora() {
    routing {

        get("/") {
            call.respondText("Olá, iniciando o programa!")
        }


        get("/somar") {
            val numero1 = call.request.queryParameters["numero1"]?.toDoubleOrNull()
            val numero2 = call.request.queryParameters["numero2"]?.toDoubleOrNull()

            if (numero1 != null && numero2 != null) {
                val resultado = numero1 + numero2
                call.respond(mapOf("resultado" to resultado)) // Resposta com chave "resultado"
            } else {
                call.respondText(
                    "Parâmetros inválidos: 'numero1' e 'numero2' devem ser números válidos.",
                    status = HttpStatusCode.BadRequest
                )
            }
        }


        get("/subtrair") {
            val numero1 = call.request.queryParameters["numero1"]?.toDoubleOrNull()
            val numero2 = call.request.queryParameters["numero2"]?.toDoubleOrNull()

            if (numero1 != null && numero2 != null) {
                val resultado = numero1 - numero2
                call.respond(mapOf("resultado" to resultado)) // Resposta com chave "resultado"
            } else {
                call.respondText(
                    "Parâmetros inválidos: 'numero1' e 'numero2' devem ser números válidos.",
                    status = HttpStatusCode.BadRequest
                )
            }
        }


        get("/multiplicar") {
            val numero1 = call.request.queryParameters["numero1"]?.toDoubleOrNull()
            val numero2 = call.request.queryParameters["numero2"]?.toDoubleOrNull()

            if (numero1 != null && numero2 != null) {
                val resultado = numero1 * numero2
                call.respond(mapOf("resultado" to resultado)) // Resposta com chave "resultado"
            } else {
                call.respondText(
                    "Parâmetros inválidos: 'numero1' e 'numero2' devem ser números válidos.",
                    status = HttpStatusCode.BadRequest
                )
            }
        }


        get("/dividir") {
            val numero1 = call.request.queryParameters["numero1"]?.toDoubleOrNull()
            val numero2 = call.request.queryParameters["numero2"]?.toDoubleOrNull()

            if (numero1 != null && numero2 != null) {
                if (numero2 != 0.0) {
                    val resultado = numero1 / numero2
                    call.respond(mapOf("resultado" to resultado)) // Resposta com chave "resultado"
                } else {
                    call.respondText(
                        "Erro: Não é permitido dividir por zero.",
                        status = HttpStatusCode.BadRequest
                    )
                }
            } else {
                call.respondText(
                    "Parâmetros inválidos: 'numero1' e 'numero2' devem ser números válidos.",
                    status = HttpStatusCode.BadRequest
                )
            }
        }
    }
}
