package com.teeth.api


class User {
    String username
    String mobile
    String firstName
    String lastName
    String password
    String token

    static constraints = {
        username nullable: false, blank: false, email: true
        mobile nullable: true
        firstName nullable: false, blank: false
        lastName nullable:  false, blank: false
        password nullable: false, blank: false, password: true, minSize: 6, maxSize: 10
        token nullable:  true
    }
}
