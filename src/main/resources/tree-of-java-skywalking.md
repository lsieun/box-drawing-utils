# SkyWalking

- Trace
    - TraceSegment
        - EntrySpan
        - LocalSpan
        - ExitSpan
    - TraceSegment
    - TraceSegment

- SkyWalking OAP
    - ApplicationStartUp
        - 8080
            - UI
    - OAPServerStartUp
        - 11800
            - gRPC APIs: Java, DotNetCore, Node.js
        - 12800
            - HTTP REST APIs
        - 12801
            - AWS Firehose receiver
        - 9090
            - Prometheus Data Source
