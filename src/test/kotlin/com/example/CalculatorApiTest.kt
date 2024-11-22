package com.example

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals
import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.client.request.*
import io.ktor.client.statement.*

class CalculadoraApiTest {

    @Test
    fun `testar endpoint de soma`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val resposta = client.get("/somar?numero1=10&numero2=5")
        assertEquals(HttpStatusCode.OK, resposta.status)
        assertEquals("{\"resultado\":15.0}", resposta.bodyAsText())
    }

    @Test
    fun `testar endpoint de subtração`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val resposta = client.get("/subtrair?numero1=10&numero2=5")
        assertEquals(HttpStatusCode.OK, resposta.status)
        assertEquals("{\"resultado\":5.0}", resposta.bodyAsText())
    }

    @Test
    fun `testar endpoint de multiplicação`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val resposta = client.get("/multiplicar?numero1=10&numero2=5")
        assertEquals(HttpStatusCode.OK, resposta.status)
        assertEquals("{\"resultado\":50.0}", resposta.bodyAsText())
    }

    @Test
    fun `testar endpoint de divisão`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val resposta = client.get("/dividir?numero1=10&numero2=5")
        assertEquals(HttpStatusCode.OK, resposta.status)
        assertEquals("{\"resultado\":2.0}", resposta.bodyAsText())
    }

    @Test
    fun `testar divisão por zero`() = testApplication {
        application {
            configureSerialization()
            configureRouting()
        }
        val resposta = client.get("/dividir?numero1=10&numero2=0")
        assertEquals(HttpStatusCode.BadRequest, resposta.status)
        assertEquals("Erro: Não é permitido dividir por zero.", resposta.bodyAsText())
    }
}
