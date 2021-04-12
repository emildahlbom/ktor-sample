package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import java.sql.*
import java.util.Properties
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*

object MySQLDatabaseExampleKotlin {

    internal var conn: Connection? = null
    internal var username = "system"
    internal var password = "password"

    fun connection() {
        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance()
        conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe",
            "system",
            "password"
        )
        var stmt: Statement? = null
        stmt = conn!!.createStatement()
        var rs: ResultSet? = null
        rs = stmt!!.executeQuery("SELECT * FROM books")
        if(stmt.execute("SELECT * FROM books")){
            rs = stmt.resultSet
        }
        while(rs!!.next()) {
            println((rs.getString("title")))
        }
    }
}