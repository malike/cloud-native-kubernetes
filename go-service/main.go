package main

import (
	"net/http"
)

func main() {
	port := ":8079"
	http.HandleFunc("/goservice", goServiceHandler)
	http.HandleFunc("/goserviceroute", goServiceRouteHandler)
	err := http.ListenAndServe(port, nil)
	if err != nil {
		panic(err)
	}
}

func goServiceHandler(writer http.ResponseWriter, request *http.Request) {
	writer.Write([]byte("Go Service"))
}

func goServiceRouteHandler(writer http.ResponseWriter, request *http.Request) {
	writer.Write([]byte("Go Service Test For Tracing"))
}
