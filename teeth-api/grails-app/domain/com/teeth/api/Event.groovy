package com.teeth.api

class Event {
    User host
    String description

    static constraints = {
        host nullable: false
    }
}
