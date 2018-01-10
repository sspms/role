package com.shanshui.smartcommunity.role.controller

import com.shanshui.smartcommunity.role.client.RoleClient
import com.shanshui.smartcommunity.role.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cache.annotation.EnableCaching
import org.springframework.web.bind.annotation.*

import javax.servlet.http.HttpServletRequest

/**
 * Created by I336253 on 11/19/2017.
 */
@RestController
@RequestMapping('/api/v1/roles')
@EnableAutoConfiguration
@EnableCaching
class RoleController implements RoleClient {

    @Autowired
    RoleService roleService

    @RequestMapping(value = '/{id}/user/{uid}', method = RequestMethod.GET)
    @ResponseBody
    def getRole(@PathVariable('id') Long cid, @PathVariable('uid') Long uid) {
        cid && uid ? roleService.getRoles(cid, uid) : null
    }

    @RequestMapping(value = '/{id}/user/{uid}', method = RequestMethod.POST)
    @ResponseBody
    def addRole(
            @PathVariable('id') Long cid,
            @PathVariable('uid') Long uid, @RequestHeader('class') String cls, HttpServletRequest req) {
//@RequestBody Role role) {
        //def form = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        // TODO: validate first
        cid && uid && cls ? roleService.addRole(req.getReader(), cls) : null
    }

    @RequestMapping(value = '/{id}/user/{uid}/invalidate', method = RequestMethod.POST)
    @ResponseBody
    def invalidateRole(
            @PathVariable('id') Long cid,
            @PathVariable('uid') Long uid, @RequestHeader('class') String cls, HttpServletRequest req) {

        cid && uid ? roleService.setInvalid(req.getReader(), cls) : null
    }

    @RequestMapping(value = '/{id}/user/{uid}/tenants', method = RequestMethod.GET)
    @ResponseBody
    def getTenants(@PathVariable('id') Long cid, @PathVariable('uid') Long uid) {
        cid && uid ? roleService.tenantRepository.findAll(cid, uid) : null
    }

    public static void main(String[] args) {
        SpringApplication.run RoleController.class, args
    }
}
