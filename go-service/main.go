package main

import (
	"net/http"
)

func main() {

	port := ":8079"
	http.HandleFunc("/goservice", goServiceHandler)
	err := http.ListenAndServe(port, nil)
	if err != nil {
		panic(err)
	}
}

func goServiceHandler(writer http.ResponseWriter, request *http.Request) {
	writer.Write([]byte("Go Service"))
}
