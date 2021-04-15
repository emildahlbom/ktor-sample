@file:Suppress("DEPRECATION")

package com.example

import java.sql.*

object MySQLDatabaseExampleKotlin {

    private var conn: Connection? = null
    // username = "system"
    // password = "password"

    fun connection() {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "password"
            )
        }catch(ex: SQLException){
            ex.printStackTrace()
        }
        put()
    }

    private fun put() {
        val rs: ResultSet?
        rs = putSQL("INSERT INTO j_transport\n" +
                "  VALUES (\n" +
                "    SYS_GUID(),\n" +
                "    SYSTIMESTAMP,\n" +
                "    SYSTIMESTAMP,\n" +
                "    '{  \"User\"  : \"Alex\", \n" +
                "        \"newValue\"  : {\n" +
                "        \"jobValidityDuration\"   : \"P5D\",\n" +
                "        \"sms\"   : {\"smOtaValidityDuration\": \"PT6H\"},\n" +
                "        \"httpOta\"   : { \"smHttpTrigEnabled\" : false, \"smHttpTrigValidityDuration\" : \"PT6H\", \"smHttpTrigBlacklistedCardProfiles\" : [{\"type\" : \"Mobile\", \"number\" : \"415-555-1234\"}]}\n" +
                "        },\n" +
                "        \"changeComment\": \"Changed jobValidity Duration to P6D from P5D.\"\n" +
                "    }')")
    }

    private fun putSQL(query: String): ResultSet{
        val stmt: Statement?
        var rs: ResultSet? = null
        try{
            stmt = conn!!.createStatement()
            rs = stmt!!.executeQuery(query)
        }catch(ex: SQLException){
            ex.printStackTrace()
        }
        return rs!!
    }
}