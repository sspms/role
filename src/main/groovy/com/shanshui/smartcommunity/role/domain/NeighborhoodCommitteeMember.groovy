package com.shanshui.smartcommunity.role.domain

import javax.persistence.*

/**
 * Created by I336253 on 11/26/2017.
 */
@Entity
class NeighborhoodCommitteeMember extends Role {
    @Enumerated(EnumType.STRING)
    @Column(updatable = false, insertable = false)
    RoleType role = RoleType.NEIGHBORHOOD_COMMITTEE

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
