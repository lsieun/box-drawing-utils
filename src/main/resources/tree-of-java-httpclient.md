# Java HttpClient

- java.net.http
    - HttpClient
        - Builder
        - Redirect
            - NEVER
            - ALWAYS
            - NORMAL
        - Version
            - HTTP_1_1
            - HTTP_2
    - HttpHeaders
    - HttpRequest
        - BodyPublisher
        - BodyPublishers
        - Builder
    - HttpResponse
        - BodyHandler
        - BodyHandlers
        - BodySubscriber
        - BodySubscribers
        - PushPromiseHandler
        - ResponseInfo
    - WebSocket
        - Builder
        - Listener

## HttpClient

- HttpClient
    - instance
        - newHttpClient()
        - newBuilder()
        - newWebSocketBuilder()
    - data
        - send
        - sendAsync

## HttpRequest

- HttpRequest.Builder
    - builder
        - uri
            - uri(URI uri)
        - version
            - version(HttpClient.Version version)
        - header
            - header(String name, String value)
            - headers(String... headers)
            - setHeader(String name, String value)
        - method
            - GET()
            - POST(BodyPublisher bodyPublisher)
            - PUT(BodyPublisher bodyPublisher)
            - DELETE()
            - method(String method, BodyPublisher bodyPublisher)
        - connection
            - timeout(Duration duration)
        - copy
            - copy()
    - request
        - build()

## HttpResponse

- HttpResponse
    - response
        - version()
        - statusCode()
        - uri()
        - headers()
        - body()
    - request
        - request()

