# Java Generics

- Generics
    - supertype-subtype
    - array
    -

- Generic Concepts
    - generic type
        - type parameter
        - type variable
    - parameterized type
        - type argument

- Java Generics
    - Design
        - Container Type
            - Generic Type
                - Generic Class
                - Generic Interface
            - Parameterized Type
        - Payload Type
            - Type Parameter
                - Unbounded Type Parameter
                - Bounded Type Parameter
            - Type Argument
                - Concrete Type Argument
                - Wildcard
    - Java File
        - Diamond Syntax
        - Type Inference
    - Compiler
        - Type Erasure
    - Class File

## Java File

### Generic Type

- Generic Type
    - Generic Class
    - Generic Interface

### Type Parameter

- Type Parameter
    - Unbounded Type Parameter
        - `<T>`
    - Bounded Type Parameter
        - Upper Bounded Type Parameter: <T extends TypeName>
        - Lower Bounded Type Parameter: NOT SUPPORTED

### Type Argument

- Type Argument
    - Concrete Type Argument
        - <String>, <Integer>
    - Wildcard
        - Unbounded Wildcard: <?>
        - Bounded Wildcard
            - Upper Bounded Wildcard: <? extends TypeName>
            - Lower Bounded Wildcard: <? super TypeName>

### Parameterized Type

- Parameterized Type
    - Type Argument
        - concrete type
            - Concrete Parameterized Type
        - wildcard
            - Wildcard Parameterized Type

### Generic Extension

- Generic Extension
    - Subtype
        - Covariance
        - Contravariance
    - Collection
    - Reflection
    - Annotation
    - Array

## Array

- array
    - element
        - type parameter
        - generic type

## Class File

