package com.shanshui.smartcommunity.role.service

import com.shanshui.smartcommunity.clients.UserClient
import com.shanshui.smartcommunity.community.domain.Household
import com.shanshui.smartcommunity.role.domain.OwnerRepository
import com.shanshui.smartcommunity.role.domain.FamilyRepository
import com.shanshui.smartcommunity.role.domain.SupervisorRepository
import com.shanshui.smartcommunity.role.domain.Owner
import com.shanshui.smartcommunity.role.domain.Role
import com.shanshui.smartcommunity.role.domain.Supervisor
import com.shanshui.smartcommunity.role.domain.Tenant
import com.shanshui.smartcommunity.role.domain.TenantRepository
import com.shanshui.smartcommunity.user.domain.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
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
    FamilyRepository relationRepository

    @Autowired
    UserClient userClient

    def addRole(Role role){
        if(role instanceof Owner){
            add(Owner.cast(role))
        }else if(role instanceof Tenant){
            add(Tenant.cast(role))
        }else if(role instanceof Supervisor){
            add(Supervisor.cast(role))
        }
    }
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

    List<User> getHouseholdOwners(Household household) {
        List<Owner> roles = household.id ? ownershipRepository.getAllByHousehold(household.id) : null
        if (!roles || roles.isEmpty()) {
            return null
        }
        userClient.get(roles.user.id)
    }

    List<User> getHouseholdTenants(Household household) {
        List<Tenant> roles = household.id ? tenantshipRepository.getAllByHousehold(household.id) : null
        if (!roles || roles.isEmpty()) {
            return null
        }
        userClient.get(roles.user.id)
    }

    @Cacheable(value = 'role', key = '#p0:#p1')
    List<Role> getRoles(long cid, long uid) {

        // TODO: more efficient way
        // @Query("select jobinfo.queuename from Jobinfo jobinfo,Taskinfo taskinfo where taskinfo.jobid=jobinfo.id and (shenweistatus=1 or shenweistatus=3) and jobinfo.queuename like ?1 group by jobinfo.queuename")
        // or native query, @Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1",countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",nativeQuery = true)
        List<Role> roles = []
        roles << ownershipRepository.findAll(cid, uid)
        roles << tenantshipRepository.findAll(cid, uid)
        roles << supervisorRepository.findAll(cid, uid)
        roles
    }

    void setInvalid(Role role) {
        if (!role.id)
            return
        if (role instanceof Owner) {
            ownershipRepository.updateExpireDate(role.id, new Date())
        } else if (role instanceof Tenant) {
            tenantshipRepository.updateExpireDate(role.id, new Date())
        } else if (role instanceof Supervisor) {
            supervisorRepository.updateExpireDate(role.id, new Date())
        }
    }
    //List<Owner>
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleService.class)
}
