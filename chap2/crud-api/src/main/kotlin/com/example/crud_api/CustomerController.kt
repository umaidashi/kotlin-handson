package com.example.crud_api

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController(val customerService: CustomerService) {
    @PostMapping("/customers")
    fun create(@RequestBody req: CustomerRequest): String {
        customerService.insertCustomer(req.firstName, req.lastName)
        return """
            {
                "message": "success",
            }
        """.trimIndent()
    }

    @GetMapping("/customers")
    fun read(): CustomerResponse {
        return CustomerResponse(customers = customerService.listCustomers())
    }

    @PutMapping("/customers/{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody request: CustomerRequest): String {
        customerService.updateCustomer(id, request.firstName, request.lastName)
        return """
            {
                "message": "success"
            }
        """.trimIndent()
    }

    @DeleteMapping("/customers/{id}")
    fun delete(@PathVariable("id") id: Int): String {
        customerService.deleteCustomer(id)
        return """
            {
                "message": "success"
            }
        """.trimIndent()
    }
}

data class CustomerRequest(
    @JsonProperty("first_name") val firstName: String,
    @JsonProperty("last_name") val lastName: String,
)

data class CustomerResponse(
    val customers: List<Customer>
)
