package com.shanshui.smartcommunity.role.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

/**
 * Created by I336253 on 1/9/2018.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Organizaton implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id
    Long community
    int memberCount
    String contactNumber
    Date start
    Date end
    boolean valid = true
}
