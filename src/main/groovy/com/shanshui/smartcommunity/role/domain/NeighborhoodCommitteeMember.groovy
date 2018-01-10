package com.shanshui.smartcommunity.role.domain

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * Created by I336253 on 11/26/2017.
 */
@Entity
class NeighborhoodCommitteeMember extends Role {
    @ManyToOne
    NeighborhoodCommittee committee

    @Enumerated(EnumType.STRING)
    MembershipTitle title

    enum MembershipTitle {
        DIRECTOR,
        VICE_DIRECTOR,
        MEMBER,
        BUILDING_LEADER
    }
}
