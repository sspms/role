package com.shanshui.smartcommunity.community.domain
/**
 * Created by I336253 on 12/25/2017.
 */
enum RoleType {

    PLT_ADMIN(
            'PLT_ADMIN',
            'platform administrator, could certify property company and PROPERTY_ADMIN'
    ),
    PROPERTY_ADMIN(
            'PROPERTY_ADMIN',
            'property company administrator, could certify property owners'
    ),
    PROPERTY_WORKER(
            'PROPERTY_WORKER',
            'property company workers, could take repairment orders'
    ),
    NEIGHBORHOOD_COMMITTEE_MEMBER(
            'NEIGHBORHOOD_COMMITTEE_MEMBER',
            'member of neighborhood committee, which is lead by government, supervisor of the owner committee and property company'
    ),
    PROPERTY_OWNER_COMMITTEE_LEAD(
            'PROPERTY_OWNER_COMMITTEE_LEAD',
            'lead of property owner committee, could vote for some decision on behave of owners'
    ),
    PROPERTY_OWNER_COMMITTEE_MEMEBER(
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
    ),
    USER(
            'USER',
            'user of the software, could consume some service for user'
    );

    String name
    String description

    RoleType(String name, String description) {
        this.name = name
        this.description = description
    }

}