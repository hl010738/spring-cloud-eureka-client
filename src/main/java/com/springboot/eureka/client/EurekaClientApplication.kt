package com.springboot.eureka.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class EurekaClientApplication {
}

fun main(args: Array<String>) {
    runApplication<EurekaClientApplication>(*args)
}
