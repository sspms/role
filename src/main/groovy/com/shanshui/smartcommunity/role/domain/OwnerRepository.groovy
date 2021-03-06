package com.shanshui.smartcommunity.role.domain

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

import javax.transaction.Transactional

/**
 * Created by I336253 on 11/19/2017.
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    @Query('select r from Owner r where r.community = ?1 and r.user = ?2 and r.valid = true')
    List<Owner> findAll(long communityId, long userId)

    @Query('select r from Owner r where r.user = ?1')
    List<Owner> findAll(long userId)

    @Query('select r from Owner r where r.addedBy = ?1')
    List<Owner> getAllAdded(long userId)

    @Query('select r from Owner r where r.role = ?1')
    List<Owner> getAll(String type)

    @Query('select r from Owner r where r.household = ?1')
    List<Owner> getAllByHousehold(long householdId)

    @Query('select r from Owner r where r.building = ?1')
    List<Owner> getAllByBuilding(long buildingId)

    @Query('select r from Owner r where r.community = ?1')
    List<Owner> getAllByCommunity(long communityId)

    @Query('select valid from Owner where id = ?1')
    boolean isValid(long roleId)

    @Modifying
    @Query('update Owner r set r.expireDate = ?2, r.valid = false where r.id = ?1')
    @Transactional
    void updateExpireDate(long id, Date expire)

}