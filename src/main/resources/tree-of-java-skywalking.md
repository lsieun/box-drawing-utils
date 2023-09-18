# SkyWalking

- Trace
    - TraceSegment
        - EntrySpan
        - LocalSpan
        - ExitSpan
    - TraceSegment
    - TraceSegment


- AsyncSpan
    - AbstractSpan
        - AbstractTracingSpan
            - StackBasedTracingSpan
                - EntrySpan
                - ExitSpan
            - LocalSpan

- AbstractTracerContext
    - TracingContext
    - IgnoredTracerContext

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

## apm-agent-core

- apm-agent-core
    - context
        - ContextManager
        - TracingContext
            - data
                - ContextCarrier  (Process)
                - ContextSnapshot (Thread)
        - trace
            - TraceSegment
            - EntrySpan
            - ExitSpan
            - LocalSpan

