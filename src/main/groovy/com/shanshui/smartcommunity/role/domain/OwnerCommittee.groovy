package com.shanshui.smartcommunity.role.domain

import javax.persistence.Entity
import javax.persistence.ManyToOne

/**
 * Created by I336253 on 11/21/2017.
 */
@Entity
class OwnerCommittee extends Organizaton {
    @ManyToOne
    NeighborhoodCommittee supervisor

    //List<OwnerCommitteeMember> memebers
}
