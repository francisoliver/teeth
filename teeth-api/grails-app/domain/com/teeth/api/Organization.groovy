package com.teeth.api

class Organization {
    User manager
    String name

    static hasMany = [users: User]
    static constraints = {
        manager nullable: false
        name nullable: false, unique: true
    }
    static mapping = {
        manager column: "manager"
    }
}
