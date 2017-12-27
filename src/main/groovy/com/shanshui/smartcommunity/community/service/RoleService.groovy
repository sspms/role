package com.shanshui.smartcommunity.community.service

import com.shanshui.smartcommunity.clients.UserClient
import com.shanshui.smartcommunity.community.domain.Household
import com.shanshui.smartcommunity.community.domain.Owner
import com.shanshui.smartcommunity.community.domain.OwnerRepository
import com.shanshui.smartcommunity.community.domain.SupervisorRepository
import com.shanshui.smartcommunity.community.domain.Supervisor
import com.shanshui.smartcommunity.community.domain.Tenant
import com.shanshui.smartcommunity.community.domain.TenantRepository
import com.shanshui.smartcommunity.user.domain.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.EnableCaching
import org.springframework.stereotype.Service

/**
 * Created by I336253 on 12/3/2017.
 */
@Service
@EnableCaching
class RoleService {

    @Autowired
    OwnerRepository ownershipRepository

    @Autowired
    TenantRepository tenantshipRepository

    @Autowired
    SupervisorRepository supervisorRepository

    @Autowired
    UserClient userClient

    def add(Owner role) {
        def id = role.id
        if (id) {
            ownershipRepository.findOne(id) ? null : ownershipRepository.save(role)
        } else {
            ownershipRepository.save(role)
        }
    }

    def add(Tenant role) {
        def id = role.id
        if (id) {
            tenantshipRepository.findOne(id) ? null : tenantshipRepository.save(role)
        } else {
            tenantshipRepository.save(role)
        }
    }

    def add(Supervisor role) {
        def id = role.id
        if (id) {
            supervisorRepository.findOne(id) ? null : supervisorRepository.save(role)
        } else {
            supervisorRepository.save(role)
        }
    }

    List<User> getHouseholdMemeber(Household household) {
        List<Owner> roles = household.id ? ownershipRepository.getAllByHousehold(household.id) : null
        if (!roles) {
            return null
        }
        List<User> family = []
        int[] ids = roles.user.id
        ids.each { final id ->
            family << userClient.get(id)
        }
        // TODO: fetch from user service to get entire user information
        family
    }

    List<User> getHouseholdTenant(Household household) {
        List<Tenant> roles = household.id ? tenantshipRepository.getAllByHousehold(household.id) : null
        if (!roles) {
            return null
        }
        List<User> family = []
        int[] ids = roles.user.id
        ids.each { final id ->
            family << userClient.get(id)
        }
        // TODO: fetch from user service to get entire user information
        family
    }

    List<User> getRenter(User user) {
        List<Tenant> roles = user.id ? tenantshipRepository.getTenants(user.id) : null
        if (!roles) {
            return null
        }
        List<User> family = []
        int[] ids = roles.user.id
        ids.each { final id ->
            family << userClient.get(id)
        }
        // TODO: fetch from user service to get entire user information
        family
    }
    //List<Owner>
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleService.class)
}
