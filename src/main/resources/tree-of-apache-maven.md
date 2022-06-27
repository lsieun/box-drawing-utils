# Apache Maven

- The clean lifecycle
    - Preclean
    - Clean
    - Postclean

## maven-plugin-api

### Log

- org.apache.maven.monitor.logging.Log
    - debug
        - isDebugEnabled()
        - debug(CharSequence content)
        - debug(CharSequence content, Throwable error)
        - debug(Throwable error)
    - info
        - isInfoEnabled()
        - info(CharSequence content)
        - info(CharSequence content, Throwable error)
        - info(Throwable error)
    - warn
        - isWarnEnabled()
        - warn(CharSequence content)
        - warn(CharSequence content, Throwable error)
        - warn(Throwable error)
    - error
        - isErrorEnabled()
        - error(CharSequence content)
        - error(CharSequence content, Throwable error)
        - error(Throwable error)

### mojo parameter

- mojo parameter
    - plugin configuration
        - <plugin>/<configuration>
    - property
        - command line
        - properties
    - default value

### @Mojo

- @Mojo
    - basic
        - goal
            - name()
        - phase
            - defaultPhase()
    - run
        - instance
            - instantiationStrategy()
        - execution
            - executionStrategy()
            - threadSafe()
        - parent-child
            - aggregator()
            - inheritByDefault()
    - condition
        - project
            - requiresProject()
            - requiresDirectInvocation()
        - report
            - requiresReports()
        - dependency
            - requiresDependencyResolution()
            - requiresDependencyCollection()
        - online
            - requiresOnline()
    - other
        - configurator()

### @Parameter

- @Parameter
    - value
        - configuration
            - name()
            - alias()
        - property
            - property()
        - default
            - defaultValue()
    - auxiliary
        - required()
        - readonly()

## plugin

- plugin configuration
    - plugin-level configuration
    - execution-level configuration
