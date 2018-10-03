FROM golang:1.9-alpine as builder

ADD https://github.com/golang/dep/releases/download/v0.4.1/dep-linux-amd64 /usr/bin/dep
RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh
RUN chmod +x /usr/bin/dep

WORKDIR $GOPATH/src/github.com/malike/cloud-native-kubernetes/go-service
RUN go build -o ./go-service ./go-service/main.go

FROM scratch
COPY --from=builder ./go-service ./
ENTRYPOINT ["./go-service"]