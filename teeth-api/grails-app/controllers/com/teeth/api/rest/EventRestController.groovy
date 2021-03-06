package com.teeth.api.rest

import com.teeth.api.Event
import com.teeth.api.User
import grails.plugin.springsecurity.SpringSecurityService

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EventRestController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    SpringSecurityService springSecurityService

    def index(Integer max) {
        User user = (User)springSecurityService.currentUser

        if(user == null) {
            render status: UNAUTHORIZED
            return
        }

        respond Event.findAllByHost(user), [status: OK]
    }

    def show() {
        String code = params.code as String
        Event event = Event.findByEventCode(code)
        if (event == null) {
            render status: NOT_FOUND
            return
        }
        respond event, [status: OK]
    }

    @Transactional
    def save(Event eventInstance) {
        User user = (User)springSecurityService.currentUser

        if(user == null) {
            render status: UNAUTHORIZED
            return
        }

        eventInstance.host = user

        eventInstance.validate()
        if (eventInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        eventInstance.save flush:true
        respond eventInstance, [status: CREATED]
    }

    @Transactional
    def update(Event eventInstance) {
        if (eventInstance == null) {
            render status: NOT_FOUND
            return
        }

        eventInstance.validate()
        if (eventInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        eventInstance.save flush:true
        respond eventInstance, [status: OK]
    }
}
