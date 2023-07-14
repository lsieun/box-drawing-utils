
- type safety
  - compile time
    - fully qualified class name
  - runtime
    - fully qualified class name
    - defining class loader


- Java 5
  - foreach
  - autoboxing
  - varargs
  - enum
  - annotation
  - static import
  - generics

- Java Interface
  - Prior Java 8
    - Marker Interface
    - Constant Interface
  - Java 8
    - Default Method
    - Static Method
    - @FunctionalInterface
  - Java 9
    - Private Method


- Java Resource
  - Resource Info
    - Resource Name
      - absolute name
      - relative name
    - Resource Type
      - System Resources
      - Non-System Resources
  - Find Resource
    - Resource Name
    - How to Find
      - Class
        - getResource():URL
        - getResourceAsStream():InputStream
      - ClassLoader
        - getBootstrapResource():URL
        - getSystemResource():URL
        - getSystemResourceAsStream():InputStream
        - getResource():URL
        - getResourceAsStream():InputStream


- Java NIO File
  - FileSystem
    - Get Instance
      - FileSystems.getDefault()
  - Path


- ClassLoader
  - getBootstrapResource(String name):URL
  - getResource(String name):URL
    - getBootstrapResource(name)
    - parent.getResource(name)
    - findResource(name)
  - getSystemResource(String name):URL
    - getBootstrapResource(name)
    - systemClassLoader.getResource(name)

- Translation of Lambda Expressions
  - compile-time
    - lambda expression itself
    - functional interface type
  - runtime

- invokedynamic
  - the binary representation of lambda creation in the bytecode
  - the mechanics of evaluating the lambda expression at runtime

- invokedynamic call site
  - static parameters
    - lambda body
    - lambda descriptor
  - dynamic parameters
    - captured values

- JEP
  - JSR
    - Specification
      - JLS
      - JVM Specification
      - Servlet Specification
      - JSP Specification
      - EJB Specification

