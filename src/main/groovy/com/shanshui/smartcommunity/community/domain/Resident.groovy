package com.shanshui.smartcommunity.community.domain

import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

/**
 * Created by I336253 on 12/25/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Resident extends Role {

    Building building
    Household household
}
