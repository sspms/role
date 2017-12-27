package com.shanshui.smartcommunity.community

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ['com.shanshui.smartcommunity.clients'])
class RoleApplication {

    static void main(String[] args) {
        SpringApplication.run RoleApplication, args
    }
}
