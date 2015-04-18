package com.teeth.api.rest

import com.teeth.api.Organization
import com.teeth.api.User
import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

import javax.naming.AuthenticationException

import static org.springframework.http.HttpStatus.OK

class LoginController {
    SpringSecurityService springSecurityService
    AuthenticationManager authenticationManager
    def login() {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(params.username, params.password))
            render([status: OK] as JSON)
        } catch(AuthenticationException e) {
            render([status: HttpStatus.UNAUTHORIZED] as JSON)
        }
    }

    def logout() {
//        User user = (User)springSecurityService.
//
//
//        render([status: OK] as JSON)
    }
}
