package com.teeth.api.rest

import com.teeth.api.User
import com.teeth.api.ExternalApiService
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.SpringSecurityService

@Transactional(readOnly = true)
class UserRestController {

    ExternalApiService externalApiService
    static responseFormats = ['json']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    SpringSecurityService springSecurityService

    def index(Integer max) {

        println("showing!!!")
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), [status: OK]
    }

    def show() {
        String username = params.username as String
        User userInstance = User.findByUsername(username)
        if (userInstance == null) {
            render status: NOT_FOUND
            return
        }
        respond userInstance, [status: OK]
    }
    @Transactional
    def save(User userInstance) {
        userInstance.validate()
        if (userInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        userInstance.save flush:true

        respond userInstance, [status: CREATED]
    }

    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            render status: NOT_FOUND
            return
        }

        userInstance.validate()
        if (userInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        userInstance.save flush:true
        respond userInstance, [status: OK]
    }
}
