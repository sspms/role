package com.shanshui.smartcommunity.community.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by I336253 on 12/25/2017.
 */
@Entity
class Supervisor extends Role {
    @Enumerated(EnumType.STRING)
    @Column(updatable = false, insertable = false)
    RoleType role = RoleType.NEIGHBORHOOD_COMMITTEE_MEMBER
}
