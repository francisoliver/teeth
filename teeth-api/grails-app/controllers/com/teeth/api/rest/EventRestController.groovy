package com.teeth.api.rest

import com.teeth.api.Event

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EventRestController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Event.list(params), [status: OK]
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
