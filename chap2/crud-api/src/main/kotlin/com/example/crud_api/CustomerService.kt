package com.example.crud_api

import org.springframework.stereotype.Service

interface CustomerService {
    fun insertCustomer(firstName: String, lastName: String)

    fun listCustomers(): List<Customer>

    fun updateCustomer(id: Int, firstName: String, lastName: String)

    fun deleteCustomer(id: Int)
}

@Service
class CustomerServiceImpl(val customerRepository: CustomerRepository) : CustomerService {
    override fun insertCustomer(firstName: String, lastName: String) {
        customerRepository.create(firstName, lastName)
        return
    }

    override fun listCustomers(): List<Customer> {
        return customerRepository.list()
    }

    override fun updateCustomer(id: Int, firstName: String, lastName: String) {
        customerRepository.update(id, firstName, lastName)
        return
    }

    override fun deleteCustomer(id: Int) {
        customerRepository.delete(id)
        return
    }
}
