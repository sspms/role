package com.shanshui.smartcommunity.role.domain

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by I336253 on 11/19/2017.
 */
public interface RoleRepository extends CrudRepository<Owner, Long> {

    @Query('select r from Owner r where r.community.id = ?1 and r.user.id = ?2 and r.valid = true')
    List<RoleType> findAll(long communityId, long userId)

}