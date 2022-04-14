# Java Reflection

## Class

- Class
    - annotation
        - getAnnotation()
    - enum
        - isEnum()
        - getEnumConstants()
    - record
        - isRecord()
    - sealed
        - isSealed()
        - getPermittedSubclasses()

## Field

- Field
    - class
        - getDeclaringClass()
    - name
        - getName()
    - access
        - getModifiers()
            - isEnumConstant()
            - isSynthetic()
    - type
        - getType()
        - getGenericType()
    - annotation
        - getAnnotation(Class<T> annotationClass)
        - getAnnotationsByType(Class<T> annotationClass)
        - getDeclaredAnnotations()
        - getAnnotatedType()
    - value
        - get
            - get(Object obj)
            - getBoolean(Object obj)
            - getByte(Object obj)
            - getChar(Object obj)
            - getShort(Object obj)
            - getInt(Object obj)
            - getLong(Object obj)
            - getFloat(Object obj)
            - getDouble(Object obj)
        - set
            - set(Object obj, Object value)
            - setBoolean(Object obj, boolean z)
            - setByte(Object obj, byte b)
            - setChar(Object obj, char c)
            - setShort(Object obj, short s)
            - setInt(Object obj, int i)
            - setLong(Object obj, long l)
            - setFloat(Object obj, float f)
            - setDouble(Object obj, double d)

