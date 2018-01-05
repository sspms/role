package com.shanshui.smartcommunity.role.controller

import com.shanshui.smartcommunity.role.domain.Family
import com.shanshui.smartcommunity.role.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.bind.annotation.*

/**
 * Created by I336253 on 11/19/2017.
 */
@RestController
@RequestMapping('/api/v1/family')
@EnableAutoConfiguration
@EnableCaching
class FamilyController {

    @Autowired
    RoleService roleService

    @RequestMapping(value = '/{id}', method = RequestMethod.GET)
    @ResponseBody
    def getFamily(@PathVariable('id') Long id) {
        id ? roleService.familyRepository.findAllFamilyMemeber(id, true) : null
    }

    @RequestMapping(value = '/{id}', method = RequestMethod.POST)
    @ResponseBody
    def addFamily(@PathVariable('id') Long id, @RequestBody Family family) {
        id && family ? roleService.addFamily(family) : new IllegalArgumentException('user id or family could not be null')
    }

    @RequestMapping(value = '/{id}/adder', method = RequestMethod.GET)
    @ResponseBody
    def getFamilyAdder(@PathVariable('id') Long id) {
        id ? roleService.familyRepository.findAdder(id, true) : null
    }

    public static void main(String[] args) {
        SpringApplication.run FamilyController.class, args
    }
}
