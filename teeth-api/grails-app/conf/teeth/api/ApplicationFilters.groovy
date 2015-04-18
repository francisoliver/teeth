package teeth.api

class ApplicationFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {

                println "printing params " + params + "\n  params action :" + params.action + "\n request method " + request.method  +
                        "forwardURI" + request.forwardURI


            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
