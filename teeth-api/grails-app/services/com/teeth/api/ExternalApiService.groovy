package com.teeth.api

import com.opensymphony.sitemesh.Content
import grails.converters.JSON
import grails.transaction.Transactional
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import groovyx.net.http.RESTClient
import groovyx.net.http.URIBuilder

@Transactional
class ExternalApiService {

    def register() {


        def data
        URIBuilder uri = new URIBuilder("http://206.80.55.76:8080")
//        uri.addQueryParam(getCredentials())

        HTTPBuilder httpBuilder = new HTTPBuilder(uri)

        httpBuilder.request(Method.POST) { req ->
            uri.path = "/HackathonWSAPI/hackathon/loginservice/register"

            requestContentType = ContentType.TEXT

            body = """{
                    "email": "chester.troy@email.com",
                    "password": "12345",
                    "firstname": "chester",
                    "lastname": "troy",
                    "gender": "male",
                    "alias": "teroy",
                    "birthdate": "09221987",
                    "mobile":"09091234444"
            }"""

            response?.success = { resp, json ->
//
//              data = json.data
                resp
                json
            }


        }

        data
    }

    def login() {
//        RESTClient client = new RESTClient("http://206.80.55.76:8080")
//        def data = client.post(path: '/HackathonWSAPI/hackathon/loginservice/login', requestContentType: ContentType.JSON,
//                body:
//                        """{
//                "email": "chester.troy@email.com",
//                "password": "12345",
//            }"""
//        )
        def data
        URIBuilder uri = new URIBuilder("http://206.80.55.76:8080")
//        uri.addQueryParam(getCredentials())


        HTTPBuilder httpBuilder = new HTTPBuilder(uri)

        httpBuilder.request(Method.POST) { req ->
            uri.path = "/HackathonWSAPI/hackathon/loginservice/login"



            requestContentType = ContentType.TEXT

            body = """{
                "email": "chester.troy@email.com",
                "password": "12345",
            }"""

            response?.success = { resp, reader ->
//
//              data = json.data
                resp
                data = getData(resp.responseBase.entity.wrappedEntity.getContent())
            }

            response.failure = {resp, reader ->
                resp
                reader
            }


        }

        data
    }

    private static String getData(def content) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(content));
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        catch (Exception e) { e.printStackTrace(); }

        sb.toString()
    }
}
