package com.teeth.api

class Group {
    User owner
    String name

    static hasMany = [users: User]
    static constraints = {
        owner nullable: false
        name nullable: false, unique: true
    }
    static mapping = {
        owner column: "owner"
    }
}
