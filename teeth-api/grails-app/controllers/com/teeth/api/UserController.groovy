package com.teeth.api

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
import com.teeth.api.User

class UserController {
    static scaffold =  User
}
