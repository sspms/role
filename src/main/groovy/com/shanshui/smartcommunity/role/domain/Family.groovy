package com.shanshui.smartcommunity.role.domain

import com.shanshui.smartcommunity.user.domain.User

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by I336253 on 1/2/2018.
 */
@Entity
class Family implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id

    long adder
    long addee

    @Enumerated(EnumType.STRING)
    @Column(updatable = true, insertable = true)
    RelationType type

    boolean valid
}
