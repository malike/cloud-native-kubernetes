FROM golang:1.9-alpine as builder
ADD https://github.com/golang/dep/releases/download/v0.4.1/dep-linux-amd64 /usr/bin/dep
RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh
RUN chmod +x /usr/bin/dep
RUN go build -o ./goservice ./main.go

FROM scratch
COPY --from=builder ./goservice ./
ENTRYPOINT ["./goservice"]