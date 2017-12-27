package com.shanshui.smartcommunity.community.controller

import com.shanshui.smartcommunity.community.domain.Building
import com.shanshui.smartcommunity.community.domain.Tenant
import com.shanshui.smartcommunity.community.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.bind.annotation.*

/**
 * Created by I336253 on 11/19/2017.
 */
@RestController
@RequestMapping('/community')
@EnableAutoConfiguration
@EnableCaching
class RoleController {

    @Autowired
    RoleService relationshipRepository

    public static void main(String[] args) {
        SpringApplication.run RoleController.class, args
    }
}
