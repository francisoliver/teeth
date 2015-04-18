package com.teeth.api



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class GroupController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Group.list(params), [status: OK]
    }


    def show() {
        String name = params.name as String
        Group group = Group.findByName(name)
        if (group == null) {
            render status: NOT_FOUND
            return
        }
        respond group, [status: OK]
    }

    @Transactional
    def save(Group groupInstance) {
        if (groupInstance == null) {
            render status: NOT_FOUND
            return
        }

        groupInstance.validate()
        if (groupInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        groupInstance.save flush:true
        respond groupInstance, [status: CREATED]
    }

    @Transactional
    def update(Group groupInstance) {
        if (groupInstance == null) {
            render status: NOT_FOUND
            return
        }

        groupInstance.validate()
        if (groupInstance.hasErrors()) {
            render status: NOT_ACCEPTABLE
            return
        }

        groupInstance.save flush:true
        respond groupInstance, [status: OK]
    }
}