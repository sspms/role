package com.shanshui.smartcommunity.role.domain

import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by I336253 on 11/19/2017.
 */
public interface SupervisorRepository extends CrudRepository<Supervisor, Long> {

    @Query('select r from Supervisor r where r.community.id = ?1 and r.user.id = ?2')
    List<Supervisor> findAll(long communityId, long userId)

    @Query('select r from Supervisor r where r.user.id = ?1')
    List<Supervisor> findAll(long userId)

    @Query('select r from Supervisor r where r.community.id = ?1')
    List<Supervisor> getAllByCommunity(long communityId)

    @Query('select valid from Supervisor where id = ?1')
    boolean isValid(long roleId)

    @Modifying
    @Query('update Supervisor r set r.valid = ?2 where r.id = ?1')
    void updateValid(long id, boolean valid)

    @Modifying
    @Query('update Supervisor r set r.expireDate = ?2 where r.id = ?1')
    void updateExpireDate(long id, Date expire)

    @Modifying
    @Query('update Supervisor r set r.valid = false, r.valid = false where r.id = ?1')
    void invalidate(long id)
}