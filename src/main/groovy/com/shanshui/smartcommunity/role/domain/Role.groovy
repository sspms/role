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

    User user

    Community community

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, insertable = false)
    RoleType role

    @Column(updatable = false)
    User addedBy

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, insertable = false)
    RoleType addedByRole

    @Column(updatable = false, insertable = false)
    @DateTimeFormat(style = 'yyyy-MM-dd HH:mm:ss.SSS')
    Date startDate
    @Column(updatable = true, insertable = true)
    @DateTimeFormat(style = 'yyyy-MM-dd HH:mm:ss.SSS')
    Date expireDate
    boolean valid
}
