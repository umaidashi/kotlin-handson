package com.example.crud_api

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

interface CustomerRepository {
    fun create(firstName: String, lastName: String)
    fun list(): List<Customer>
    fun update(id: Int, firstName: String, lastName: String)
    fun delete(id: Int)
}

@Repository
class CustomerRepositoryImpl(val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) : CustomerRepository {
    override fun create(firstName: String, lastName: String) {
        val sql = """
            insert into
                customers (
                    first_name
                    , last_name
                )
            values (
                :firstName, :lastName
            )
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
            .addValue("firstName", firstName)
            .addValue("lastName", lastName)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }

    override fun list(): List<Customer> {
        val sql = """
            select 
                id
                , first_name
                , last_name
            from
                customers
            order by
                id
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
        val customMap = namedParameterJdbcTemplate.queryForList(sql, sqlParams)
        return customMap.map {
            Customer(
                it["id"].toString().toInt().toLong(),
                it["first_name"].toString(),
                it["last_name"].toString()
            )
        }
    }

    override fun update(id: Int, firstName: String, lastName: String) {
        val sql = """
            UPDATE
                customers
            SET
                first_name = :first_name
                , last_name = :last_name
            WHERE
                id = :id
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
            .addValue("first_name", firstName)
            .addValue("last_name", lastName)
            .addValue("id", id)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }

    override fun delete(id: Int) {
        val sql = """
            DELETE FROM
                customers
            WHERE
                id = :id
            ;
        """.trimIndent()
        val sqlParams = MapSqlParameterSource()
            .addValue("id", id)
        namedParameterJdbcTemplate.update(sql, sqlParams)
        return
    }
}
