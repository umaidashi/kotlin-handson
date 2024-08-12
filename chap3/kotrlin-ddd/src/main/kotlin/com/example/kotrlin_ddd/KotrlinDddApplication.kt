package com.example.kotrlin_ddd

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
    info = Info(
        title = "Implementing Server Side Kotlin",
        version = "0.0",
        description = "Sample API of Hands On Server Side Kotlin",
    ),
    servers = [
        Server(
            description = "Local Server",
            url = "http://localhost:8080",
        ),
   ],
)
class ImplementingServerSideKotlinDevelopmentApplication

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<ImplementingServerSideKotlinDevelopmentApplication>(*args)
}
