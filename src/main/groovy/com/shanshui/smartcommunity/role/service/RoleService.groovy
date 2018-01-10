package com.shanshui.smartcommunity.role.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.shanshui.smartcommunity.community.domain.Household
import com.shanshui.smartcommunity.role.domain.*
import com.shanshui.smartcommunity.user.client.UserClient
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
    OwnerRepository ownerRepository

    @Autowired
    TenantRepository tenantRepository

    @Autowired
    NeighborhoodCommitteeMemberRepository supervisorRepository

    @Autowired
    FamilyRepository familyRepository

    @Autowired
    UserClient userClient

    def addRole(Reader reader, String cls) {
        Class clz = Class.forName(cls)
        if (clz) {
            ObjectMapper om = new ObjectMapper()
            add(om.readValue(reader, clz))
        }
    }

    def addRole(Role role, String cls) {
        Class clz = Class.forName(cls)
        if (clz && role.class == clz) {
            add(clz.cast(role))
        }
    }

    def add(Owner role) {
        def id = role.id
        if (id) {
            ownerRepository.findOne(id) ? null : ownerRepository.save(role)
        } else {
            ownerRepository.save(role)
        }
    }

    def add(Tenant role) {
        def id = role.id
        if (id) {
            tenantRepository.findOne(id) ? null : tenantRepository.save(role)
        } else {
            tenantRepository.save(role)
        }
    }

    def add(NeighborhoodCommitteeMember role) {
        def id = role.id
        if (id) {
            supervisorRepository.findOne(id) ? null : supervisorRepository.save(role)
        } else {
            supervisorRepository.save(role)
        }
    }

    def addFamily(Family family) {
        def id = family.id
        if (id) {
            familyRepository.findOne(id) ? null : familyRepository.save(family)
        } else {
            familyRepository.save(family)
        }
    }

    List<User> getHouseholdOwners(Household household) {
        List<Owner> roles = household.id ? ownerRepository.getAllByHousehold(household.id) : null
        if (!roles || roles.isEmpty()) {
            return null
        }
        userClient.get(roles.user.id)
    }

    List<User> getHouseholdTenants(Household household) {
        List<Tenant> roles = household.id ? tenantRepository.getAllByHousehold(household.id) : null
        if (!roles || roles.isEmpty()) {
            return null
        }
        userClient.get(roles.user.id)
    }

    @Cacheable(value = 'role')
    List<Role> getRoles(long cid, long uid) {

        // TODO: more efficient way
        // @Query("select jobinfo.queuename from Jobinfo jobinfo,Taskinfo taskinfo where taskinfo.jobid=jobinfo.id and (shenweistatus=1 or shenweistatus=3) and jobinfo.queuename like ?1 group by jobinfo.queuename")
        // or native query, @Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1",countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",nativeQuery = true)
        List<Role> roles = []
        roles.addAll(ownerRepository.findAll(cid, uid))
        roles.addAll(tenantRepository.findAll(cid, uid))
        roles.addAll(supervisorRepository.findAll(cid, uid))
        roles
    }

    void setInvalid(Reader reader, String cls) {
        Class clz = Class.forName(cls)
        Role role
        if (clz) {
            ObjectMapper om = new ObjectMapper()
            role = om.readValue(reader, clz)
        }
        if (role) {
            invalidate(role)
        }
    }

    def invalidate(Owner role) {
        def id = role.id
        if (id) {
            ownerRepository.updateExpireDate(role.id, new Date())
        }
    }

    def invalidate(Tenant role) {
        def id = role.id
        if (id) {
            tenantRepository.updateExpireDate(role.id, new Date())
        }
    }

    def invalidate(NeighborhoodCommitteeMember role) {
        def id = role.id
        if (id) {
            supervisorRepository.updateExpireDate(role.id, new Date())
        }
    }
    //List<Owner>
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleService.class)
}
