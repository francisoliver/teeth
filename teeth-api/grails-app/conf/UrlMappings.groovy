class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/"(view:"/index")
        "500"(view:'/error')
        "/event"(controller: "event", parseRequest: true) {
            action = [POST: "save", GET: "index"]
        }
        "/event/$code"(controller: "event", parseRequest: true) {
            action = [GET: "show", PUT: "update"]
        }

        "/group"(controller: "group", parseRequest: true) {
            action = [POST: "save", GET: "index"]
        }
        "/group/$name"(controller: "group", parseRequest: true) {
            action = [GET: "show", PUT: "update"]
        }

        "/user"(controller: "user", parseRequest: true) {
            action = [POST: "save", GET: "index"]
        }
        "/user/$username"(controller: "user", parseRequest: true) {
            action = [GET: "show", PUT: "update"]
        }
	}
}
