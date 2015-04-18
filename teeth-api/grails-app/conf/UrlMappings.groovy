class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/"(view:"/index")
        "500"(view:'/error')
        "/api/event"(controller: "eventRest", parseRequest: true) {
            action = [POST: "save", GET: "index"]
        }
        "/api/event/$code"(controller: "eventRest", parseRequest: true) {
            action = [GET: "show", PUT: "update"]
        }

        "/api/group"(controller: "groupRest", parseRequest: true) {
            action = [POST: "save", GET: "index"]
        }
        "/api/group/$name"(controller: "groupRest", parseRequest: true) {
            action = [GET: "show", PUT: "update"]
        }

        "/api/user"(controller: "userRest", parseRequest: true) {
            action = [POST: "save", GET: "index"]
        }

        "/api/user/$username"(controller: "userRest", parseRequest: true) {
            action = [GET: "show", PUT: "update"]
        }

        "/api/login"(controller: "login", parseRequest: true) {
            action = [POST: "login"]
        }
	}
}
