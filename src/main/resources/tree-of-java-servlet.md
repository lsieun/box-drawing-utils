# Java Tomcat

## Directory

- Tomcat
    - bin
        - startup.bat
        - shutdown.bat
        - startup.sh
        - shutdown.sh
        - tomcat8.exe
        - tomcat8w.exe
    - conf
        - server.xml
        - web.xml
    - lib
    - logs
    - temp
    - webapps
        - ROOT
    - work

## webapp

- web-app
    - servlet
        - servlet-name
        - servlet-class
        - init-param
            - param-name
            - param-value
        - load-on-startup
    - servlet-mapping
        - servlet-name
        - url-pattern
    - filter
        - filter-name
        - filter-class
        - init-param
            - param-name
            - param-value
    - filter-mapping
        - filter-name
        - url-pattern

## javax.servlet

### AsyncListener

- AsyncListener
    - success
        - onStartAsync(AsyncEvent event)
        - onComplete(AsyncEvent event)
    - fail
        - onTimeout(AsyncEvent event)
        - onError(AsyncEvent event)
