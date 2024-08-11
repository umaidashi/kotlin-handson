package com.example.spring_helloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SpringHelloWorldController {
    @GetMapping
    fun helloWorld(): String {
        return "Hello World"
    }
}
