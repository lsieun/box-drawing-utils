# Java Reflection

- java.lang.reflect
    - encapsulation
        - Module
        - Package
    - type
        - Type
            - Class
                - Member
                    - Field
                    - Executable
                        - Constructor
                        - Method
                        - Parameter
        - Array
    - feature
        - annotation
            - AnnotatedElement
                - AnnotatedType
                    - AnnotatedArrayType
                    - AnnotatedParameterizedType
                    - AnnotatedTypeVariable
                    - AnnotatedWildcardType
        - generic
            - GenericDeclaration
            - TypeVariable
            - GenericArrayType
            - ParameterizedType
            - WildcardType
        - record
            - RecordComponent
    - proxy
        - Proxy
        - InvocationHandler
    - security
        - ReflectPermission
        - AccessibleObject

## Module

- Module
    - classloader
        - loader
            - getClassLoader()
        - resource
            - getResourceAsStream(String name)
    - hierarchy
        - layer
            - getLayer()
        - module
            - name
                - isNamed()
                - getName()
            - descriptor
                - getDescriptor()
        - package
            - getPackages()
    - encapsulation
        - read
            - canRead(Module other)
            - addReads(Module other)
        - export
            - isExported(String pn)
            - isExported(String pn, Module other)
            - addExports(String pn, Module other)
        - open
            - isOpen(String pn)
            - isOpen(String pn, Module other)
            - addOpens(String pn, Module other)
        - use
            - canUse(Class<?> service)
            - addUses(Class<?> service)
    - annotation
        - getAnnotation(Class<T> annotationClass)
        - getAnnotations()
        - getDeclaredAnnotations()


## Package

- Package
    - static
        - getPackage(String name)
        - getPackages()
    - name
        - getName()
    - annotation
        - isAnnotationPresent(Class<? extends Annotation> annotationClass)
        - getAnnotation(Class<A> annotationClass)
        - getDeclaredAnnotation(Class<A> annotationClass)
        - getAnnotationsByType(Class<A> annotationClass)
        - getDeclaredAnnotationsByType(Class<A> annotationClass)
        - getAnnotations()
        - getDeclaredAnnotations()
    - sealed
        - isSealed()
        - isSealed(URL url)
    - compatible
        - isCompatibleWith(String desired)
    - specification
        - getSpecificationTitle()
        - getSpecificationVersion()
        - getSpecificationVendor()
        - getImplementationTitle()
        - getImplementationVersion()
        - getImplementationVendor()

## Type

- Type
    - Class
    - TypeVariable
    - ParameterizedType
    - WildcardType
    - GenericArrayType

- Type
    - non-generic
        - Class
    - generic
        - declare
            - Class (generic type)
            - TypeVariable
        - use
            - ParameterizedType
            - WildcardType
            - GenericArrayType

## Class

- Class: member
    - class info
        - name
            - getName()
            - getSimpleName()
            - getTypeName()
            - getCanonicalName()
        - modifier
            - getModifiers()
    - field
        - getFields()
        - getDeclaredFields()
        - getField(String name)
        - getDeclaredField(String name)
    - constructor
        - getConstructors()
        - getDeclaredConstructors()
        - getConstructor(Class<?>... parameterTypes)
        - getDeclaredConstructor(Class<?>... parameterTypes)
    - method
        - getMethods()
        - getDeclaredMethods()
        - getMethod(String name, Class<?>... parameterTypes)
        - getDeclaredMethod(String name, Class<?>... parameterTypes)

### feature

- Class: feature
    - generic
        - type parameter
            - getTypeParameters()
        - super
            - getGenericSuperclass()
        - str
            - toString()
            - toGenericString()
    - annotation
        - type
            - isAnnotation()
        - instance
            - single
                - getAnnotation(Class<A> annotationClass)
                - getDeclaredAnnotation(Class<A> annotationClass)
            - is
                - isAnnotationPresent(Class<? extends Annotation> annotationClass)
            - multiple
                - getAnnotationsByType(Class<A> annotationClass)
                - getDeclaredAnnotationsByType(Class<A> annotationClass)
                - getAnnotations()
                - getDeclaredAnnotations()
        - hierarchy
            - getAnnotatedSuperclass()
            - getAnnotatedInterfaces()

### type

- Class: type
    - array
        - isArray()
        - getComponentType()
        - componentType()
        - arrayType()
    - enum
        - isEnum()
        - getEnumConstants()
    - record
        - isRecord()
        - getRecordComponents()
    - nest
        - getNestHost()
        - isNestmateOf(Class<?> c)
        - getNestMembers()
    - sealed
        - isSealed()
        - getPermittedSubclasses()
    - hidden
        - isHidden()
    - nested
        - outer
            - getDeclaredClasses()
            - getClasses()
        - member
            - common
                - isMemberClass()
                - getDeclaringClass()
            - static nested class
            - inner class
                - local class
                    - isLocalClass()
                    - getEnclosingClass()
                    - getEnclosingMethod()
                    - getEnclosingConstructor()
                - anonymous class
                    - isAnonymousClass()
    - is
        - isPrimitive()
        - isSynthetic()

### classloader

- Class: loader
    - loader
        - getClassLoader()
    - load
        - forName(String className)
        - forName(String name, boolean initialize, ClassLoader loader)
        - forName(Module module, String name)
    - resource
        - getResourceAsStream(String name)
        - getResource(String name)
    - security
        - getProtectionDomain()
    - signer
        - getSigners()

### instance

- Class: instance
    - new
        - newInstance()
    - is
        - isInstance(Object obj)
    - cast
        - cast(Object obj)

### hierarchy

- Class: hierarchy
    - module
        - getModule()
    - package
        - getPackage()
        - getPackageName()
    - super
        - getSuperclass()
        - getGenericSuperclass()
    - interface
        - isInterface()
        - getInterfaces()
        - getGenericInterfaces()
    - compatible
        - isAssignableFrom(Class<?> cls)
        - asSubclass(Class<U> clazz)

### classfile

- Class: classfile
    - descriptor
        - descriptorString()
        - describeConstable()

## Field

- Field
    - class
        - getDeclaringClass()
    - field info
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
        - instance
            - getAnnotation(Class<T> annotationClass)
            - getAnnotationsByType(Class<T> annotationClass)
            - getDeclaredAnnotations()
        - source
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

## Executable

- Executable
    - class
        - getDeclaringClass()
    - self
        - name
            - getName()
        - modifiers
            - getModifiers()
        - parameter
            - getParameterCount()
            - getParameters()
            - getParameterTypes()
            - getGenericParameterTypes()
        - exception
            - getExceptionTypes()
            - getGenericExceptionTypes()
    - feature
        - generic
            - getTypeParameters()
        - annotation
            - parameter
                - getParameterAnnotations()
            - instance
                - getAnnotation(Class<T> annotationClass)
                - getAnnotationsByType(Class<T> annotationClass)
                - getDeclaredAnnotations()
            - source
                - getAnnotatedParameterTypes()
                - getAnnotatedReturnType()
                - getAnnotatedReceiverType()
                - getAnnotatedExceptionTypes()
    - is
        - isVarArgs()
        - isSynthetic()
    - str
        - toGenericString()

## Method

- Method
    - class
        - getDeclaringClass()
    - method info
        - name
            - getName()
        - modifier
            - getModifiers()
        - parameter
            - getParameterCount()
            - getParameterTypes()
            - getGenericParameterTypes()
        - return
            - getReturnType()
            - getGenericReturnType()
        - exception
            - getExceptionTypes()
            - getGenericExceptionTypes()
    - feature
        - generic
            - getTypeParameters()
        - annotation
            - getDefaultValue()
            - getDeclaredAnnotations()
            - getAnnotation()
            - getParameterAnnotations()
            - getAnnotatedReturnType()
    - is
        - isBridge()
        - isVarArgs()
        - isSynthetic()
        - isDefault()
    - invoke
        - invoke(Object obj, Object... args)
    - access
        - setAccessible()

## Constructor

- Constructor
    - class
        - getDeclaringClass()
    - constructor info
        - name
            - getName()
        - modifier
            - getModifiers()
        - parameter
            - getParameterCount()
            - getParameterTypes()
            - getGenericParameterTypes()
        - exception
            - getExceptionTypes()
            - getGenericExceptionTypes()
    - feature
        - generic
            - getTypeParameters()
        - annotation
            - getAnnotation(Class<T> annotationClass)
            - getDeclaredAnnotations()
            - getParameterAnnotations()
            - getAnnotatedReturnType()
            - getAnnotatedReceiverType()
    - access
        - setAccessible(boolean flag)
    - str
        - toString()
        - toGenericString()
    - is
        - isVarArgs()
        - isSynthetic()
    - instance
        - newInstance(Object ... initargs)

## Parameter

- Parameter
    - executable
        - getDeclaringExecutable()
    - param info
        - name
            - isNamePresent()
            - getName()
        - modifier
            - getModifiers()
        - type
            - getParameterizedType()
            - getType()
    - annotation
        - source
            - getAnnotatedType()
        - instance
            - getAnnotation(Class<T> annotationClass)
            - getDeclaredAnnotation(Class<T> annotationClass)
            - getAnnotationsByType(Class<T> annotationClass)
            - getDeclaredAnnotationsByType(Class<T> annotationClass)
            - getAnnotations()
            - getDeclaredAnnotations()
    - is
        - isImplicit()
        - isSynthetic()
        - isVarArgs()

## AccessibleObject

- AccessibleObject: member
    - access
        - is
            - isAccessible()
            - canAccess(Object obj)
        - try
            - trySetAccessible()
        - do
            - setAccessible(boolean flag)
            - setAccessible(AccessibleObject[] array, boolean flag)
    - annotation
        - is
            - isAnnotationPresent(Class<? extends Annotation> annotationClass)
        - single
            - getAnnotation(Class<T> annotationClass)
            - getDeclaredAnnotation(Class<T> annotationClass)
        - multiple
            - getAnnotationsByType(Class<T> annotationClass)
            - getDeclaredAnnotationsByType(Class<T> annotationClass)
            - getAnnotations()
            - getDeclaredAnnotations()

- AccessibleObject: hierarchy
    - Executable
        - Constructor
        - Method
    - Field

## Modifier

- Modifier
    - single
        - visibility
            - isPublic(int mod)
            - isPrivate(int mod)
            - isProtected(int mod)
        - owner
            - isStatic(int mod)
        - abstract
            - isFinal(int mod)
            - isAbstract(int mod)
            - isInterface(int mod)
        - synchronization
            - isSynchronized(int mod)
            - isVolatile(int mod)
        - serialization
            - isTransient(int mod)
        - other
            - isNative(int mod)
            - isStrict(int mod)
    - multiple
        - type
            - classModifiers()
            - interfaceModifiers()
        - member
            - fieldModifiers()
            - constructorModifiers()
            - methodModifiers()
            - parameterModifiers()
    - str
        - toString(int mod)

## Array

- Array
    - instance
        - newInstance(Class<?> componentType, int length)
        - newInstance(Class<?> componentType, int... dimensions)
    - length
        - getLength(Object array)
    - value
        - get
            - get(Object array, int index)
            - getBoolean(Object array, int index)
            - getByte(Object array, int index)
            - getChar(Object array, int index)
            - getShort(Object array, int index)
            - getInt(Object array, int index)
            - getLong(Object array, int index)
            - getFloat(Object array, int index)
            - getDouble(Object array, int index)
        - set
            - set(Object array, int index, Object value)
            - setBoolean(Object array, int index, boolean z)
            - setByte(Object array, int index, byte b)
            - setChar(Object array, int index, char c)
            - setShort(Object array, int index, short s)
            - setInt(Object array, int index, int i)
            - setLong(Object array, int index, long l)
            - setFloat(Object array, int index, float f)
            - setDouble(Object array, int index, double d)

## GenericDeclaration

- GenericDeclaration
    - Class
    - Executable
        - Constructor
        - Method

## RecordComponent

- RecordComponent
    - basic
        - name
            - getName()
        - type
            - getType()
            - getGenericType()
            - getGenericSignature()
    - class
        - getDeclaringRecord()
    - method
        - getAccessor()
    - annotation
        - getAnnotatedType()
        - getAnnotation(Class<T> annotationClass)
        - getAnnotations()
        - getDeclaredAnnotations()

## Proxy

- Proxy
    - class
        - getProxyClass(ClassLoader loader, Class<?>... interfaces)
        - isProxyClass(Class<?> cl)
    - instance
        - newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
    - handler
        - getInvocationHandler(Object proxy)

## AnnotatedElement

- AnnotatedElement
    - isAnnotationPresent(Class<? extends Annotation> annotationClass)
    - getAnnotation(Class<T> annotationClass)
    - getAnnotations()
    - getAnnotationsByType(Class<T> annotationClass)
    - getDeclaredAnnotation(Class<T> annotationClass)
    - getDeclaredAnnotationsByType(Class<T> annotationClass)
    - getDeclaredAnnotations()
