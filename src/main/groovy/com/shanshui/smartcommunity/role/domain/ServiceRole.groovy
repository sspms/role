package com.shanshui.smartcommunity.role.domain

import javax.persistence.Entity
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

/**
 * Created by I336253 on 1/10/2018.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class ServiceRole extends Role {
}
