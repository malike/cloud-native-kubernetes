FROM golang:1.9-alpine as builder

ADD https://github.com/golang/dep/releases/download/v0.4.1/dep-linux-amd64 /usr/bin/dep
RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh
RUN chmod +x /usr/bin/dep

WORKDIR $GOPATH/src/github.com/malike/cloud-native-kubernetes/go-service
COPY Gopkg.toml Gopkg.lock ./
COPY configuration.json ./
RUN dep ensure --vendor-only
COPY . ./
RUN GOOS=linux go build -a -o /go-service .

FROM scratch
COPY --from=builder /go-service ./
COPY --from=builder . ./
ENTRYPOINT ["./go-service"]