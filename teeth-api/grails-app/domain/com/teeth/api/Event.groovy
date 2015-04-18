package com.teeth.api

class Event {
    User host
    String description

    static hasMany = [users: UserEvent]

    static constraints = {
        host nullable: false
        description nullable: false, blank: false
    }
}
