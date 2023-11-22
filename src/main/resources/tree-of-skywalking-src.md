# SkyWalking Source

## Trace

- AsyncSpan
    - AbstractSpan
        - AbstractTracingSpan
            - StackBasedTracingSpan
                - EntrySpan
                - ExitSpan
            - LocalSpan
        - NoopSpan
            - NoopExitSpan

## Data Carrier

- QueueBuffer
    - write
        - save(T data)
        - setStrategy(BufferStrategy strategy);
    - read
        - obtain(List<T> consumeList)
        - int getBufferSize();


- Channels
    - write
        - save(T data)
    - read
        - getChannelSize()
        - getBuffer(int index)


- IConsumer
    - start
        - init(Properties properties)
    - process
        - consume(List<T> data);
        - nothingToConsume()
        - onError(List<T> data, Throwable t);
    - stop
        - onExit()

- IDriver
    - begin(Channels channels)
    - close(Channels channels)

- IDriver (I)
    - ConsumeDriver (C)
    - ConsumerPool (I)
        - BulkConsumePool (C)

- ConsumerThread
    - data
        - DataSource_1
            - Buffer
        - DataSource_2
            - Buffer
        - ...
        - DataSource_n
            - Buffer
    - consumer
        - IConsumer

- MultipleChannelsConsumer
    - Group_1
        - Channels
            - Buffer_1
            - Buffer_2
            - ...
            - Buffer_n
        - IConsumer
    - Group_2
        - Channels
            - Buffer_1
            - Buffer_2
            - ...
            - Buffer_n
        - IConsumer
    - ...
    - Group_n
        - Channels
            - Buffer_1
            - Buffer_2
            - ...
            - Buffer_n
        - IConsumer


- IDriver
    - ConsumeDriver
        - boolean running
        - ConsumerThread
            - boolean running
    - BulkConsumePool
        - boolean isStarted
        - MultipleChannelsConsumer
            - boolean running

