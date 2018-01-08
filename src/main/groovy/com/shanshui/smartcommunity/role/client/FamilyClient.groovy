package com.shanshui.smartcommunity.role.client

import com.shanshui.smartcommunity.role.domain.Family
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

/**
 * Created by I336253 on 1/8/2018.
 */
@FeignClient("role")
interface FamilyClient {

    @RequestMapping(value = '/{id}', method = RequestMethod.GET)
    @ResponseBody
    def getFamily(@PathVariable('id') Long id)

    @RequestMapping(value = '/{id}', method = RequestMethod.POST)
    @ResponseBody
    def addFamily(@PathVariable('id') Long id, @RequestBody Family family)

    @RequestMapping(value = '/{id}/adder', method = RequestMethod.GET)
    @ResponseBody
    def getFamilyAdder(@PathVariable('id') Long id)

}