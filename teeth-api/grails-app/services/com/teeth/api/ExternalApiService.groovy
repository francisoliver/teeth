package com.teeth.api

import grails.converters.JSON
import grails.transaction.Transactional
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import groovyx.net.http.RESTClient
import groovyx.net.http.URIBuilder
import org.apache.http.entity.ContentType

@Transactional
class ExternalApiService {

    def register() {
        RESTClient client = new RESTClient("http://206.80.55.76:8080")
        def response = client.post(path: '/HackathonWSAPI/hackathon/loginservice/register', requestContentType: ContentType.APPLICATION_JSON,
              body: [
                email: "chester.troy@email.com",
                password: "12345",
                firstname: "chester",
                lastname: "troy",
                gender: "male",
                alias: "teroy",
                birthdate: "09221987",
                mobile:"09091234444"
            ]
        )

//        URIBuilder uri = new URIBuilder("https://api.github.com")
////        uri.addQueryParam(getCredentials())
//
//        HTTPBuilder httpBuilder = new HTTPBuilder(uri)
//
//        def response
//        httpBuilder.request(Method.GET, groovyx.net.http.ContentType.JSON) { req ->
//            uri.path = "https://api.github.com/user/cedrickimsarmenta"
//
//            response?.success = { resp, json ->
//                data = json.data
//            }
//        }

        response
    }
}
