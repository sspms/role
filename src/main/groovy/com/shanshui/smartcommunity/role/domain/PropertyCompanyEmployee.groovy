package com.shanshui.smartcommunity.role.domain

import javax.persistence.*

/**
 * Created by I336253 on 11/22/2017.
 */
@Entity
class PropertyCompanyEmployee extends ServiceRole {

    int employeeId

    @Enumerated(EnumType.STRING)
    RoleType role = RoleType.PROPERTY_MANAGEMENT

    @ManyToOne(fetch = FetchType.LAZY)
    PropertyCompany company

    @Enumerated(EnumType.STRING)
    JobTitle jobTitle

    enum JobTitle {
        MANAGER,
        FULL_TIME_EMPLOYEE,
        PART_TIME_EMPLOYEE
    }
}
