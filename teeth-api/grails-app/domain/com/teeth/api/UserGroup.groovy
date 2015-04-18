package com.teeth.api

class UserGroup {
    static belongsTo = [user: User, group: Organization]
    static constraints = {
        user nullable: false
        group nullable: false
    }
}
