package com.shanshui.smartcommunity.role.domain

import javax.persistence.Entity

/**
 * Created by I336253 on 11/22/2017.
 */
@Entity
class PropertyCompany extends Organizaton {
    String name
    String information
    long[] accounts
    String location
    boolean certified
}
