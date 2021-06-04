package com.springboot.eureka.client.controller

import com.springboot.eureka.client.domain.Parent
import com.springboot.eureka.client.domain.Student
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import kotlin.random.Random

@RestController
class TestController {

    @Value("\${student.information.address}")
    private val address: String? = null

    @Value("\${student.information.name}")
    private val name: String? = null

    @GetMapping("/getStudent")
    fun getStudent(@RequestParam("name")name: String,
                   @RequestParam("address") address: String,
                   request: HttpServletRequest): Student {

        println("authKey: ${request.getHeader("authKey")}")

        println("authKey2: ${request.getHeader("authKey2")}")

        println("name: $name")
        println("address: $address")

        val parent = Parent()
        parent.id = 10
        parent.name = "ParentName"
        parent.address = "ParentAddress"

        val student = Student()
        student.id = 200
        student.name = name
        student.address = address
        student.parent = parent

        return student
    }


    @GetMapping("/info")
    fun info(): String {

        val randomInt = Random.nextInt(1200)

        println("randomInt: $randomInt")

        Thread.sleep(randomInt.toLong())

        return "name: $name, address: $address"
    }
}

