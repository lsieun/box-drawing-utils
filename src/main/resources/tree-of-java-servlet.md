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

- webapp
    - WEB-INF
        - web.xml
        - classes/
        - lib/*.jar
        - jsp
    - assets
        - html
        - js
        - css
        - images

## javax.servlet

### ServletRequest

- ServletRequest
    - data
        - header
            - content-type
                - String getContentType();
            - param
                - String getParameter(String name);
                - Enumeration<String> getParameterNames();
                - String[] getParameterValues(String name);
                - Map<String, String[]> getParameterMap();
            - locale
                - Locale getLocale();
                - Enumeration<Locale> getLocales();
        - body
            - byte
                - int getContentLength();
                - long getContentLengthLong();
                - ServletInputStream getInputStream();
            - char
                - encoding
                    - String getCharacterEncoding();
                    - void setCharacterEncoding(String env)
                - content
                    - BufferedReader getReader()
    - container
        - context
            - ServletContext getServletContext();
        - path
            - String getRealPath(String path);
        - dispatch
            - RequestDispatcher getRequestDispatcher(String path);
            - DispatcherType getDispatcherType();
        - attr
            - Object getAttribute(String name);
            - void setAttribute(String name, Object o);
            - void removeAttribute(String name);
            - Enumeration<String> getAttributeNames();
        - async
            - AsyncContext startAsync();
            - AsyncContext startAsync(request, response);
            - boolean isAsyncStarted();
            - boolean isAsyncSupported();
            - AsyncContext getAsyncContext();
    - client-server
        - server
            - String getServerName();
            - int getServerPort();
        - local
            - String getLocalName();
            - String getLocalAddr();
            - int getLocalPort();
        - url
            - String getProtocol();
            - String getScheme();
            - boolean isSecure();
        - client
            - String getRemoteAddr();
            - String getRemoteHost();
            - int getRemotePort();

### ServletResponse

- ServletResponse
    - data
        - header
            - content-type
                - String getContentType();
                - void setContentType(String type);
            - locale
                - void setLocale(Locale loc);
                - Locale getLocale();
        - body
            - byte
                - void setContentLength(int len);
                - void setContentLengthLong(long len);
                - ServletOutputStream getOutputStream();
            - char
                - String getCharacterEncoding();
                - void setCharacterEncoding(String charset);
                - PrintWriter getWriter();
    - buffer
        - void setBufferSize(int size);
        - int getBufferSize();
        - void flushBuffer();
        - void resetBuffer();
        - void reset();
    - status
        - boolean isCommitted();

### AsyncListener

- AsyncListener
    - success
        - onStartAsync(AsyncEvent event)
        - onComplete(AsyncEvent event)
    - fail
        - onTimeout(AsyncEvent event)
        - onError(AsyncEvent event)

## Listener

- listeners
    - application
        - ServletContextListener
        - ServletContextAttributeListener
    - session
        - HttpSessionListener
        - HttpSessionAttributeListener
        - HttpSessionActivationListener
        - HttpSessionBindingListener
    - request
        - ServletRequestListener
        - ServletRequestAttributeListener
        - AsyncListener

## Part

- Part
    - form
        - getName()
    - header
        - getHeaderNames()
        - getHeader(String name)
        - getHeaders(String name)
        - getContentType()
    - file
        - getSize()
        - getInputStream()
        - write(String fileName)
        - delete()

