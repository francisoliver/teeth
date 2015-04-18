package com.teeth.api.rest

import com.teeth.api.User
import com.teeth.api.ExternalApiService
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserRestController {

    ExternalApiService externalApiService
    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

//        def response = externalApiService.register()
        def response = externalApiService.login()

        render response
//        respond User.list(params), [status: OK]
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
