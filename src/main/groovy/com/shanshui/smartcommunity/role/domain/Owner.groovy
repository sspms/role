package com.shanshui.smartcommunity.role.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class Owner extends Resident {
    @Enumerated(EnumType.STRING)
    @Column(updatable = false, insertable = false)
    RoleType role = RoleType.PROPERTY_OWNER
}
