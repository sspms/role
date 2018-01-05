package com.shanshui.smartcommunity.role.domain

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

import javax.transaction.Transactional

/**
 * Created by I336253 on 11/19/2017.
 */
public interface TenantRepository extends CrudRepository<Tenant, Long> {

    @Query('select r from Tenant r where r.community = ?1 and r.user = ?2 and r.valid = true')
    List<Tenant> findAll(long communityId, long userId)

    @Query('select r from Tenant r where r.user = ?1')
    List<Tenant> findAll(long userId)

    @Query('select r from Tenant r where r.addedBy = ?1')
    List<Tenant> getTenants(long userId)

    @Query('select r from Tenant r where r.household = ?1')
    List<Tenant> getAllByHousehold(long householdId)

    @Query('select r from Tenant r where r.building = ?1')
    List<Tenant> getAllByBuilding(long buildingId)

    @Query('select r from Tenant r where r.community = ?1')
    List<Tenant> getAllByCommunity(long communityId)

    @Query('select valid from Tenant where id = ?1')
    boolean isValid(long roleId)

    @Modifying
    @Query('update Tenant r set r.valid = ?2 where r.id = ?1')
    @Transactional
    void updateValid(long id, boolean valid)

    @Modifying
    @Query('update Tenant r set r.expireDate = ?2, r.valid = false where r.id = ?1')
    @Transactional
    void updateExpireDate(long id, Date expire)

}