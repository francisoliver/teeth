class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/"(view:"/index")
        "500"(view:'/error')
        "/event"(controller: "eventRest", parseRequest: true) {
            action = [POST: "save", GET: "index"]
        }
        "/event/$code"(controller: "eventRest", parseRequest: true) {
            action = [GET: "show", PUT: "update"]
        }

        "/group"(controller: "groupRest", parseRequest: true) {
            action = [POST: "save", GET: "index"]
        }
        "/group/$name"(controller: "groupRest", parseRequest: true) {
            action = [GET: "show", PUT: "update"]
        }

        "/user"(controller: "userRest", parseRequest: true) {
            action = [POST: "save", GET: "index"]
        }
        "/user/$username"(controller: "userRest", parseRequest: true) {
            action = [GET: "show", PUT: "update"]
        }
	}
}
