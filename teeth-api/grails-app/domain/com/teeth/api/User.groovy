package com.teeth.api

class User {
    String username
    String mobile
    String firstName
    String lastName
    String password
    String token

    transient springSecurityService
    boolean enabled = true
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false

    static hasMany = [groups: UserGroup, events: UserEvent]

    static constraints = {
        username nullable: false, blank: false, email: true, unique: true
        mobile nullable: true
        firstName nullable: false, blank: false
        lastName nullable:  false, blank: false
        password nullable: false, blank: false, password: true, minSize: 6
        token nullable:  true
    }

    @Override
    public String toString() {
        return username;
    }

    protected void encodePassword() {
        if (springSecurityService) {
            password = springSecurityService.encodePassword(password)
        }
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
        this.username = this.username.trim()
    }
}
