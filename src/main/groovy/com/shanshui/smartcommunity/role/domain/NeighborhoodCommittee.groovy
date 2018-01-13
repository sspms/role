package com.shanshui.smartcommunity.role.domain

import javax.persistence.Entity

/**
 * Created by I336253 on 11/26/2017.
 */
@Entity
class NeighborhoodCommittee extends Organizaton {
    String location
    String workingHour
    //List<OwnerCommittee> ownerCommittees
    //List<NeighborhoodCommitteeMember> memebers
}
