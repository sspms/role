package com.shanshui.smartcommunity.role.domain
/**
 * Created by I336253 on 12/25/2017.
 */
enum RoleType {

    PLT_ADMIN(
            'PLT_ADMIN',
            'platform administrator, could certify property company and PROPERTY_ADMIN'
    ),
    PROPERTY_MANAGEMENT(
            'PROPERTY_WORKER',
            'property company workers, could take repairment orders'
    ),
    NEIGHBORHOOD_COMMITTEE(
            'NEIGHBORHOOD_COMMITTEE_MEMBER',
            'member of neighborhood committee, which is lead by government, supervisor of the owner committee and property company'
    ),
    PROPERTY_OWNER_COMMITTEE(
            'PROPERTY_OWNER_COMMITTEE_MEMEBER',
            'member of property owner committee, could vote for some decision on behave of owners'
    ),
    PROPERTY_OWNER(
            'PROPERTY_OWNER',
            'property owner, certified by PROPERTY_ADMIN, could consume some services provided for owner'
    ),
    PROPERTY_OWNER_DELEGATE(
            'PROPERTY_OWNER_DELEGATE',
            'property owner delegate, certified by PROPERTY_OWNER_DELEGATE, could consume some services provided for owner'
    ),
    PROPERTY_RENTER(
            'PROPERTY_RENTER',
            'property renter, certified by PROPERTY_OWNER, could consume some services provided for renter, could not consume some service for owner'
    );

    String name
    String description

    RoleType(String name, String description) {
        this.name = name
        this.description = description
    }

}