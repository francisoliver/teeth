package teeth.api

class ApplicationFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                println "==="
                println "printing params " + params + "\n  params action :" + params.action + "\n request method " + request.method  +
                        "forwardURI" + request.forwardURI + "<<<<<<<<<<<<<<<<<<<<"
                println "==="

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
