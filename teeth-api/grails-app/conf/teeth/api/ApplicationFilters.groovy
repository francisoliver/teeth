package teeth.api

class ApplicationFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                println "printing params " + params + "  params action :" + params.action + "request method " + request.method
            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
