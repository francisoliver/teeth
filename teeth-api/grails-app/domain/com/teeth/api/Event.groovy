package com.teeth.api

class Event {
    User host
    String description
    String code

    static hasMany = [users: UserEvent]

    static constraints = {
        host nullable: false
        code nullable: false, unique: true
        description nullable: false, blank: false
    }
}
