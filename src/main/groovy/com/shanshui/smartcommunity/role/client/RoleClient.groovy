package com.shanshui.smartcommunity.role.client

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpServletRequest

/**
 * Created by I336253 on 1/8/2018.
 */
@FeignClient("role")
interface RoleClient {

    @RequestMapping(value = '/{id}/user/{uid}', method = RequestMethod.GET)
    @ResponseBody
    def getRole(@PathVariable('id') Long cid, @PathVariable('uid') Long uid)

    @RequestMapping(value = '/{id}/user/{uid}', method = RequestMethod.POST)
    @ResponseBody
    def addRole(
            @PathVariable('id') Long cid,
            @PathVariable('uid') Long uid, @RequestHeader('class') String cls, HttpServletRequest req)

    @RequestMapping(value = '/{id}/user/{uid}/invalidate', method = RequestMethod.POST)
    @ResponseBody
    def invalidateRole(
            @PathVariable('id') Long cid,
            @PathVariable('uid') Long uid, @RequestHeader('class') String cls, HttpServletRequest req)

    @RequestMapping(value = '/{id}/user/{uid}/tenants', method = RequestMethod.GET)
    @ResponseBody
    def getTenants(@PathVariable('id') Long cid, @PathVariable('uid') Long uid)
}