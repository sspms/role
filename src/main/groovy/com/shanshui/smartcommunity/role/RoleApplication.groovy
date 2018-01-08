package com.shanshui.smartcommunity.role

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.feign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ['com.shanshui.smartcommunity.user.client'])
@EnableDiscoveryClient
class RoleApplication {

    static void main(String[] args) {
        SpringApplication.run RoleApplication, args
    }
}
