package com.shanshui.smartcommunity.role.domain

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.ManyToOne

/**
 * Created by I336253 on 11/22/2017.
 */
@Entity
class OwnerCommitteeMember extends ServiceRole {
    @ManyToOne
    OwnerCommittee committee
    RoleType role = RoleType.PROPERTY_OWNER_COMMITTEE

    @Enumerated(EnumType.STRING)
    MembershipTitle title
    enum MembershipTitle {
        DIRECTOR,
        VICE_DIRECTOR,
        MEMBER
    }
}
