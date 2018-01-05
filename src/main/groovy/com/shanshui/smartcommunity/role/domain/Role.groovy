package com.shanshui.smartcommunity.role.domain

import com.shanshui.smartcommunity.community.domain.Community
import com.shanshui.smartcommunity.user.domain.User
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.*

/**
 * Created by I336253 on 12/25/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id

    long user // user id

    long community // community id

    @Enumerated(EnumType.STRING)
    RoleType role

    @Column(updatable = false)
    long addedBy // user id

    @Enumerated(EnumType.STRING)
    RoleType addedByRole

    @DateTimeFormat(style = 'yyyy-MM-dd HH:mm:ss.SSS')
    Date startDate

    @Column(updatable = true, insertable = true)
    @DateTimeFormat(style = 'yyyy-MM-dd HH:mm:ss.SSS')
    Date expireDate
    boolean valid
}
