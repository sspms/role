package com.shanshui.smartcommunity.role.domain

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

import javax.management.relation.Relation

/**
 * Created by I336253 on 11/19/2017.
 */
public interface FamilyRepository extends CrudRepository<Relation, Long> {

    @Query('select r from Relation r where r.adder.id = ?1 and r.valid = ?2')
    List<Relation> findAll(long userId, boolean isValid)

    @Query('select r from Relation r where r.addee.id = ?1 and r.valid = ?2')
    List<Relation> findAdder(long userId, boolean isValid)

    @Query('select r from Relation r where r.adder.id = ?1 and r.valid = ?2 and (r.type = SPOUSE or r.type = PARENT or r.type = CHILDREN)')
    List<Relation> findAllFamilyMemeber(long userId, boolean isValid)
}