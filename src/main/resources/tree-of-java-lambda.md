# Java Lambda

- graph
    - FunctionalInterface
    - CallSite
    - InnerClass
    - Caller
    - Impl

- functional interface
    - lambda expression
    - method reference

## java.util.function

- XXX
    - I: input
    - O: output
    - p: primitive
    - r: reference

- 1java.util.function
    - IrOr
        - I0O1
            - Supplier
        - I1O0
            - Consumer
        - I1O1
            - Function
            - UnaryOperator
        - I2O1
            - BiFunction
    - IpOr
        - I1O1
            - IntFunction
            - LongFunction
            - DoubleFunction
    - IrOp
        - I1O1
            - Predicate
            - ToIntFunction
            - ToLongFunction
            - ToDoubleFunction
        - I2O1
            - ToIntBiFunction
            - ToLongBiFunction
            - ToDoubleBiFunction
    - IpOp
        - I1O1
            - IntToDoubleFunction
            - IntToLongFunction
            - LongToIntFunction
            - LongToDoubleFunction
            - DoubleToIntFunction
            - DoubleToLongFunction

- java.util.function
    - predicate
        - Predicate
        - BiPredicate
        - DoublePredicate
        - IntPredicate
        - LongPredicate
    - function
        - Function
        - BiFunction
        - DoubleFunction
        - IntFunction
        - LongFunction
        - ToDoubleBiFunction
        - ToDoubleFunction
        - ToIntBiFunction
        - ToIntFunction
        - ToLongBiFunction
        - ToLongFunction
    - consumer
        - Consumer
        - BiConsumer
        - DoubleConsumer
        - IntConsumer
        - LongConsumer
        - ObjDoubleConsumer
        - ObjIntConsumer
        - ObjLongConsumer
    - supplier
        - Supplier
        - BooleanSupplier
        - DoubleSupplier
        - IntSupplier
        - LongSupplier
    - operator
        - UnaryOperator
        - BinaryOperator
        - DoubleBinaryOperator
        - DoubleUnaryOperator
        - IntBinaryOperator
        - IntUnaryOperator
        - LongBinaryOperator
        - LongUnaryOperator
    - primitive
        - DoubleToIntFunction
        - DoubleToLongFunction
        - IntToDoubleFunction
        - IntToLongFunction
        - LongToDoubleFunction
        - LongToIntFunction
    - legacy
        - Runnable
        - Callable

## Method Reference

- Method Reference
    - static method
    - instance method
        - a particular object
        - an arbitrary object
    - constructor

## Mechanism

### AbstractValidatingLambdaMetafactory

- AbstractValidatingLambdaMetafactory
    - caller
        - targetClass
    - call site
        - invokedType
    - functional interface
        - samBase
        - samMethodName
        - samMethodType
    - impl
        - implDefiningClass
        - implMethod
        - implMethodType
        - implInfo
        - implKind
        - implIsInstanceMethod
    - inner class
        - instantiatedMethodType
        - isSerializable
        - markerInterfaces
        - additionalBridges

### SerializedLambda

- SerializedLambda
    - interface
        - functionalInterfaceClass
        - functionalInterfaceMethodName
        - functionalInterfaceMethodSignature
    - impl
        - implMethodKind
        - implClass
        - implMethodName
        - implMethodSignature
    - capture
        - capturingClass
        - instantiatedMethodType
        - capturedArgs

