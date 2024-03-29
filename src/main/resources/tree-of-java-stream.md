# Java Stream

## Stream

- Stream
    - source
        - empty
        - value
            - of
            - ofNullable
        - function
            - iterate
            - generate
        - builder
            - accept
            - add
            - build
        - stream
          - concat
        - collection
        - array
        - I/O resource
    - operation
        - intermediate
            - filter
            - slice
                - peek
                - skip (stateful-bounded)
                - limit (stateful-bounded)
            - mapping
                - map
                - mapToInt
                - mapToLong
                - mapToDouble
                - flatMap
                - flatMapToInt
                - flatMapToLong
                - flatMapToDouble
                - mapMulti
                - mapMultiToInt
                - mapMultiToLong
                - mapMultiToDouble
            - stateful
                - sorted (stateful-unbounded)
                - distinct (stateful-unbounded)
            - while
                - takeWhile
                - dropWhile
        - terminal
            - match
                - anyMatch
                - allMatch
                - noneMatch
            - find
                - findFirst
                - findAny
            - reducing
                - reduce (stateful-bounded)
                - collect
                - toList
                - count
                - min
                - max
            - for
                - forEach
                - forEachOrdered
            - array
                - toArray

## IntStream

- IntStream
    - builder
        - empty
        - int
            - of
            - range
            - rangeClosed
        - builder
            - add
            - build
        - func
            - generate
            - iterate
        - stream
            - concat
    - operation
        - intermediate
            - filter
            - map
                - map
                - flatMap
                - mapMulti
            - stateful
                - distinct
                - sorted
            - peek
            - slice
                - limit
                - skip
            - while
                - takeWhile
                - dropWhile
            - concurrent
                - sequential
                - parallel
            - transform
                - mapToObj
                - mapToLong
                - mapToDouble
                - asLongStream
                - asDoubleStream
                - boxed
        - terminal
            - reduce
            - collect
            - for
                - forEach
                - forEachOrdered
            - math
                - sum
                - min
                - max
                - count
                - average
                - IntSummaryStatistics
            - match
                - anyMatch
                - allMatch
                - noneMatch
            - find
                - findFirst
                - findAny
            - array
                - toArray
