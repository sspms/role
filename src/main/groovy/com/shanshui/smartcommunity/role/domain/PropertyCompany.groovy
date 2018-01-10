package com.shanshui.smartcommunity.role.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by I336253 on 11/22/2017.
 */
@Entity
class PropertyCompany extends Organizaton {
    @Id
    @GeneratedValue
    Long id

    String name
    String information
    List<Long> accounts
    String location
    boolean certified
    
    List<PropertyCompanyEmployee> employees
}
