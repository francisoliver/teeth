package com.teeth.api

class Event {
    User host
    String description
    String eventCode

    static hasMany = [users: UserEvent]

    static constraints = {
        host nullable: false
        eventCode nullable: false, unique: true
        description nullable: false, blank: false
    }
}
