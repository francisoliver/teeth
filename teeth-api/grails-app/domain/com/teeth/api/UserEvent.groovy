package com.teeth.api

class UserEvent {
    static belongsTo = [user: User, event: Event]
    static constraints = {
        user nullable: false
        event nullable: false
    }
}
