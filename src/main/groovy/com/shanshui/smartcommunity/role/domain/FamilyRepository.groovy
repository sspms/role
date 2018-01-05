package com.shanshui.smartcommunity.role.domain

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


/**
 * Created by I336253 on 11/19/2017.
 */
public interface FamilyRepository extends CrudRepository<Family, Long> {

    @Query('select r from Family r where r.adder = ?1 and r.valid = ?2')
    List<Family> findAll(long userId, boolean isValid)

    @Query('select r from Family r where r.addee = ?1 and r.valid = ?2')
    List<Family> findAdder(long userId, boolean isValid)

    @Query("select r from Family r where r.adder = ?1 and r.valid = ?2 and (r.type = 'SPOUSE' or r.type = 'PARENT' or r.type = 'CHILDREN')")
    List<Family> findAllFamilyMemeber(long userId, boolean isValid)
}