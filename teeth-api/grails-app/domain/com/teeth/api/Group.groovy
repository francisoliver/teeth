package com.teeth.api

class Group {
    User owner
    static hasMany = [users: User]
    static constraints = {
        owner nullable: false
    }
    static mapping = {
        owner column: "owner"
    }
}
