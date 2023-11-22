# ByteBuddy

## net.bytebuddy

### package

- net.bytebuddy
    - ByteBuddy
    - dynamic
        - DynamicType
        - Builder
        - Unloaded
        - Loaded
        - Default
    - description
    - modifier
        - TypeManifestation
        - Visibility
    - type
        - TypeDescription
        - TypeDefinition
    - field
        - FieldDescription
        - FieldList
    - method
        - MethodDescription
        - MethodList
        - ParameterDescription
        - ParameterList
    - annotation
        - AnnotationDescription
        - AnnotationList
    - enumeration
        - EnumerationDescription
    - implementation
        - StubMethod
        - FixedValue
        - FieldAccessor
        - MethodCall
        - MethodDelegation
        - InvokeDynamic
    - matcher
        - ElementMatchers
        - ElementMatcher
            - Junction
    - asm
    - AsmVisitorWrapper
        - AbstractBase
        - ForDeclaredFields
            - FieldVisitorWrapper
                - ForDeclaredMethods
            - MethodVisitorWrapper
    - Advice
    - MemberRemoval
    - MemberAttributeExtension
        - ForField
        - ForMethod

### ByteBuddy

- ByteBuddy
    - config
        - with()
        - ignore()
    - type
        - class
            - subclass()
            - redefine()
            - rebase()
        - interface
            - makeInterface()
        - record
            - makeRecord()
        - annotation
            - makeAnnotation()
        - enum
            - makeEnumeration()
        - package
            - makePackage()
            - rebase()
        - special
            - decorate()


- ByteBuddy: buddy
    - with
        - with(ClassFileVersion)
        - with(NamingStrategy)
        - with(AuxiliaryType.NamingStrategy)
        - with(AnnotationValueFilter.Factory)
        - with(AnnotationRetention)
        - with(Implementation.Context.Factory)
        - with(MethodGraph.Compiler)
        - with(InstrumentedType.Factory)
        - with(TypeValidation)
        - with(VisibilityBridgeStrategy)
        - with(ClassWriterStrategy)
    - ignore
        - ignore(ElementMatcher<? super MethodDescription>)
        - ignore(LatentMatcher<? super MethodDescription>)

- ByteBuddy: builder
    - subclass
        - subclass(Class<T>)
        - subclass(Class<T>, ConstructorStrategy)
        - subclass(Type)
        - subclass(Type, ConstructorStrategy)
        - subclass(TypeDefinition)
        - subclass(TypeDefinition, ConstructorStrategy)
    - redefine
        - redefine(Class<T>)
        - redefine(Class<T>, ClassFileLocator)
        - redefine(TypeDescription, ClassFileLocator)
    - rebase
        - rebase(Class<T>)
        - rebase(Class<T>, ClassFileLocator)
        - rebase(Class<T>, ClassFileLocator, MethodNameTransformer)
        - rebase(TypeDescription, ClassFileLocator)
        - rebase(TypeDescription, ClassFileLocator, MethodNameTransformer)
        - rebase(Package, ClassFileLocator)
        - rebase(PackageDescription, ClassFileLocator)
    - interface
        - makeInterface()
        - makeInterface(Class<T>)
        - makeInterface(Type...)
        - makeInterface(List<? extends Type>)
        - makeInterface(TypeDefinition...)
        - makeInterface(Collection<? extends TypeDefinition>)
    - package
        - makePackage(String)
    - record
        - makeRecord()
    - annotation
        - makeAnnotation()
    - enumeration
        - makeEnumeration(String...)
        - makeEnumeration(Collection<? extends String>)
    - decorate
        - decorate(Class<T>)
        - decorate(Class<T>, ClassFileLocator)
        - decorate(TypeDescription, ClassFileLocator)

### NamingStrategy

- NamingStrategy
    - String subclass(TypeDescription.Generic superClass)
    - String redefine(TypeDescription typeDescription)
    - String rebase(TypeDescription typeDescription)

- NamingStrategy (I)
    - AbstractBase (A)
        - PrefixingRandom (C)
        - Suffixing (C)
            - SuffixingRandom (C)

## net.bytebuddy.dynamic

### DynamicType

- DynamicType
    - Builder
        - input
            - class
                - name()
                - modifiers()
                - implement()
            - field
                - defineField()
                - define()
                - serialVersionUid()
            - constructor
                - defineConstructor()
                - define()
            - method
                - defineMethod()
                - define()
                - defineProperty()
                - withHashCodeEquals()
                - withToString()
        - output
            - make(): DynamicType.Unloaded
    - Unloaded
        - input
            - include()
        - output
            - load(): DynamicType.Loaded
    - Loaded
        - output
            - getLoaded(): Class
            - getLoadedAuxiliaryTypes(): Map
            - getAllLoaded(): Map


- DynamicType.Builder
    - input
        - class
            - name()
            - modifiers()
            - implement()
        - field
            - defineField()
            - define()
            - serialVersionUid()
        - constructor
            - defineConstructor()
            - define()
        - method
            - defineMethod()
            - define()
            - defineProperty()
            - withHashCodeEquals()
            - withToString()
    - output
        - make(): DynamicType.Unloaded

### DynamicType.Builder

- DynamicType.Builder: member
    - common
        - define()
    - class info
        - access_flag
            - modifiers()
        - this_class
            - name()
            - suffix()()
        - interfaces
            - implement()
    - field
        - defineField()
        - serialVersionUid()
    - method
        - defineConstructor()
        - defineMethod()
        - defineProperty()
    - attribute
        - noNestMate()
        - nestHost()
        - nestMembers()
        - attribute()
    - annotation
        - annotateType()
    - generic
        - typeVariable()
        - transform()
    - asm
        - visit()
    - match
        - constructor()
        - field()
        - method()
        - invokable()
        - recordComponent()
        - ignoreAlso()
    - other
        - merge()
        - topLevelType()
        - innerTypeOf()
        - declaredTypes()
        - permittedSubclass()
        - unsealed()
        - initializer()
        - require()
        - withHashCodeEquals()
        - withToString()
        - defineRecordComponent()
        - toTypeDescription()
    - output
        - make()


- DynamicType.Builder: method
    - method head
        - name/return/access
            - defineMethod()
        - parameters
            - withParameter()
            - withParameters()
        - throws
            - throwing()
    - method body
        - withoutCode()
        - intercept()
            - StubMethod.INSTANCE
            - FixedValue
                - value()
                - nullValue()
                - argument()
            - FieldAccessor
                - ofField()
            - MethodCall
            - MethodDelegation
            - Advice

- DynamicType.Builder: generic
    - typeVariable()
        - typeVariable(String symbol)
        - typeVariable(String symbol, Type... bound)
        - typeVariable(String symbol, TypeDefinition... bound)
    - transform()
        - transform(ElementMatcher, Transformer)

- DynamicType.Builder: attribute
    - attribute
        - attribute(TypeAttributeAppender typeAttributeAppender)
    - annotation
        - annotateType(Annotation... annotation)
        - annotateType(List<? extends Annotation> annotations)
        - annotateType(AnnotationDescription... annotation)
        - annotateType(Collection<? extends AnnotationDescription> annotations)

### ClassFileLocator

- ClassFileLocator
    - single
        - none
            - NoOp
        - byte[]
            - Simple
                - of(String typeName, byte[] binaryRepresentation)
                - of(DynamicType dynamicType)
                - of(Map<TypeDescription, byte[]> binaryRepresentations)
                - ofResources(Map<String, byte[]> binaryRepresentations)
        - classloader
            - ForClassLoader
                - of
                    - ofSystemLoader()
                    - ofPlatformLoader()
                    - ofBootLoader()
                    - of(ClassLoader classLoader)
                - read
                    - read(Class<?> type)
                    - read(Class<?>... type)
                    - read(Collection<? extends Class<?>> types)
                    - readToNames(Class<?>... type)
                    - readToNames(Collection<? extends Class<?>> types)
            - ForModule
                - ofBootLayer()
                - of(JavaModule module)
            - ForUrl
        - file
            - ForJarFile
                - of(File file)
                - ofClassPath()
                - ofClassPath(String classPath)
                - ofRuntimeJar()
            - ForModuleFile
                - ofBootPath()
                - ofBootPath(File bootPath)
                - ofModulePath()
                - ofModulePath(String modulePath)
                - ofModulePath(String modulePath, String baseFolder)
                - of(File file)
            - ForFolder
        - agent
            - ForInstrumentation
                - fromInstalledAgent(ClassLoader classLoader)
                - of(Instrumentation instrumentation, Class<?> type)
    - multiple
        - PackageDiscriminating
        - Compound

## net.bytebuddy.dynamic.scaffold

### InstrumentedType

- InstrumentedType
    - hierarchy
        - withInterfaces(TypeList.Generic interfaceTypes)
    - class
        - modifier
            - withModifiers(int modifiers)
        - initializer
            - withInitializer(LoadedTypeInitializer loadedTypeInitializer)
            - withInitializer(ByteCodeAppender byteCodeAppender)
            - getLoadedTypeInitializer()
            - getTypeInitializer()
    - field
        - withField(FieldDescription.Token token)
        - withAuxiliaryField(FieldDescription.Token token, Object value)
    - method
        - withMethod(MethodDescription.Token token)
    - feature
        - annotation
            - withAnnotations(List<? extends AnnotationDescription> annotationDescriptions)
        - generic
            - withTypeVariable(TypeVariableToken typeVariable)
        - nested
            - withNestHost(TypeDescription nestHost)
            - withNestMembers(TypeList nestMembers)
        - enclose
            - withEnclosingType(TypeDescription enclosingType)
            - withEnclosingMethod(MethodDescription.InDefinedShape enclosingMethod)
            - withDeclaringType(@MaybeNull TypeDescription declaringType)
            - withDeclaredTypes(TypeList declaredTypes)
        - anonymous
            - withAnonymousClass(boolean anonymousClass)
        - local
            - withLocalClass(boolean localClass)
        - sealed
            - withPermittedSubclasses(@MaybeNull TypeList permittedSubclasses)
        - record
            - withRecordComponent(RecordComponentDescription.Token token)
            - withRecord(boolean record)
    - validate
        - validated()

## net.bytebuddy.description

### package

- net.bytebuddy.description
    - NamedElement
    - ByteCodeElement
    - ModifierReviewable
    - TypeVariableSource
    - type
        - TypeDescription
        - TypeDefinition
        - TypeList
    - field
        - FieldDescription
        - FieldList
    - method
        - MethodDescription
        - MethodList
        - ParameterDescription
        - ParameterList
    - enumeration
        - EnumerationDescription
    - annotation
        - AnnotationDescription
        - AnnotationList
        - AnnotationSource
        - AnnotationValue

### modifier

- net.bytebuddy.description.modifier: type
    - Visibility
        - PUBLIC
        - PROTECTED
        - PRIVATE
    - Ownership
        - STATIC
    - TypeManifestation
        - FINAL
        - ABSTRACT
        - INTERFACE
        - ANNOTATION
    - EnumerationState
        - ENUMERATION
    - SyntheticState
        - SYNTHETIC

---

- net.bytebuddy.description.modifier: field
    - Visibility
        - PUBLIC
        - PROTECTED
        - PRIVATE
    - Ownership
        - STATIC
    - FieldManifestation
        - FINAL
        - VOLATILE
    - EnumerationState
        - ENUMERATION
    - FieldPersistence
        - TRANSIENT
    - Mandate
        - MANDATED
    - SyntheticState
        - SYNTHETIC

---

- net.bytebuddy.description.modifier: method
    - Visibility
        - PUBLIC
        - PROTECTED
        - PRIVATE
    - Ownership
        - STATIC
    - MethodArguments
        - VARARGS
    - MethodManifestation
        - NATIVE
        - ABSTRACT
        - FINAL
        - BRIDGE
    - Mandate
        - MANDATED
    - MethodStrictness
        - STRICT
    - SynchronizationState
        - SYNCHRONIZED
    - SyntheticState
        - SYNTHETIC


- net.bytebuddy.description.modifier: parameter
    - Mandate
        - MANDATED
    - ParameterManifestation
        - FINAL
    - ProvisioningState
        - MANDATED
    - SyntheticState
        - SYNTHETIC

- net.bytebuddy.description.modifier
    - Visibility
        - PUBLIC
        - PROTECTED
        - PRIVATE
    - Ownership
        - STATIC
    - TypeManifestation
        - FINAL
        - ABSTRACT
        - INTERFACE
        - ANNOTATION
    - FieldManifestation
        - FINAL
        - VOLATILE
    - FieldPersistence
        - TRANSIENT
    - MethodManifestation
        - NATIVE
        - ABSTRACT
        - FINAL
        - BRIDGE
    - MethodArguments
        - VARARGS
    - MethodStrictness
        - STRICT
    - ParameterManifestation
        - FINAL
    - EnumerationState
        - ENUMERATION
    - SynchronizationState
        - SYNCHRONIZED
    - SyntheticState
        - SYNTHETIC
    - Mandate
        - MANDATED
    - ProvisioningState
        - MANDATED

### TypeDefinition

- TypeDefinition
    - TypeDescription
    - TypeDescription.Generic


- TypeDescription
    - instance
        - isInstance(Object value)
    - hierarchy
        - isAssignableFrom(Class<?> type)
        - isAssignableFrom(TypeDescription typeDescription)
        - isAssignableTo(Class<?> type)
        - isAssignableTo(TypeDescription typeDescription)
        - isInHierarchyWith(Class<?> type)
        - isInHierarchyWith(TypeDescription typeDescription)
    - array
        - getComponentType()
    - nested
        - getDeclaringType()
        - getDeclaredTypes()
        - getEnclosingMethod()
        - getEnclosingType()
    - ForLoadedType
        - of()
    - Generic.Builder
        - Builder
            - typeVariable()
            - parameterizedType()
                - Container Type
                    - Payload Type
        - Generic
            - build()
            - unboundWildcard()     : ?
            - asWildcardLowerBound(): ? super T
            - asWildcardUpperBound(): ? extends T

### TypeDescription.Generic.Builder

- TypeDescription.Generic.Builder
    - builder
        - type variable
            - typeVariable(String symbol)
        - of
            - of(java.lang.reflect.Type type)
            - of(TypeDescription.Generic typeDescription)
        - raw type
            - rawType(Class<?> type)
            - rawType(TypeDescription type)
            - rawType(Class<?> type, Generic ownerType)
            - rawType(TypeDescription type, Generic ownerType)
        - parameterized type
            - parameterizedType(Class<?> rawType, java.lang.reflect.Type... parameter)
        - array
            - asArray()
            - asArray(int arity)
        - annotation
            - annotate(Annotation... annotation)
            - annotate(List<? extends Annotation> annotations)
    - generic
        - build
            - build()
            - build(Annotation... annotation)
        - wildcard
            - unbound
                - unboundWildcard()
                - unboundWildcard(Annotation... annotation)
                - unboundWildcard(List<? extends Annotation> annotations)
            - bounded
                - asWildcardUpperBound()
                - asWildcardUpperBound(Annotation... annotation)
                - asWildcardLowerBound()
                - asWildcardLowerBound(Annotation... annotation)

### AnnotationDescription

- AnnotationDescription
    - type
        - getAnnotationType()
    - element
    - element value
        - getValue(String property)
        - getValue(MethodDescription.InDefinedShape property)
    - meta
        - getRetention()
        - getElementTypes()
        - isSupportedOn(ElementType elementType)
        - isSupportedOn(String elementType)
        - isInherited()
        - isDocumented()

- AnnotationDescription
    - AbstractBase
        - ForLoadedAnnotation
        - Latent

### AnnotationDescription.Builder

- AnnotationDescription.Builder
    - start
        - ofType(Class<? extends Annotation> annotationType)
        - ofType(TypeDescription annotationType)
    - define
        - common
            - define(String property, AnnotationValue<?, ?> value)
        - primitive
            - define(String property, boolean value)
            - define(String property, byte value)
            - define(String property, char value)
            - define(String property, short value)
            - define(String property, int value)
            - define(String property, long value)
            - define(String property, float value)
            - define(String property, double value)
        - string
            - define(String property, String value)
        - class
            - define(String property, Class<?> type)
            - define(String property, TypeDescription typeDescription)
        - enum
            - define(String property, Enum<?> value)
            - define(String property, TypeDescription enumerationType, String value)
            - define(String property, EnumerationDescription value)
        - annotation
            - define(String property, Annotation annotation)
            - define(String property, AnnotationDescription annotationDescription)
        - array
            - primitive
                - defineArray(String property, boolean... value)
                - defineArray(String property, byte... value)
                - defineArray(String property, char... value)
                - defineArray(String property, short... value)
                - defineArray(String property, int... value)
                - defineArray(String property, long... value)
                - defineArray(String property, float... value)
                - defineArray(String property, double... value)
            - string
                - defineArray(String property, String... value)
            - class
                - defineTypeArray(String property, Class<?>... type)
                - defineTypeArray(String property, TypeDescription... typeDescription)
            - enum
                - defineEnumerationArray(String property, Class<T> enumerationType, T... value)
                - defineEnumerationArray(String property, TypeDescription enumerationType, String... value)
                - defineEnumerationArray(String property, TypeDescription enumerationType, EnumerationDescription...
                  value)
            - annotation
                - defineAnnotationArray(String property, Class<T> annotationType, T... annotation)
                - defineAnnotationArray(String property, TypeDescription annotationType, AnnotationDescription...
                  annotationDescription)
    - output
        - build()

### NamedElement

- NamedElement
    - getActualName()
    - WithRuntimeName
        - getName()
        - getInternalName()
        - WithGenericName
            - toGenericString()
    - WithOptionalName
        - isNamed()
    - WithDescriptor
        - getDescriptor()
        - getGenericSignature()

### ModifierReviewable

- ModifierReviewable
    - OfByteCodeElement
        - OfAbstraction
            - ForTypeDefinition
            - ForMethodDescription
        - OfEnumeration
            - ForTypeDefinition
            - ForFieldDescription
    - ForParameterDescription

## net.bytebuddy.description.method

### MethodDescription

- MethodDescription
    - method head
        - modifier
            - getActualModifiers()
            - getActualModifiers(boolean manifest)
            - getActualModifiers(boolean manifest, Visibility visibility)
        - parameter
            - getParameters()
        - return
            - getReturnType()
        - exception
            - getExceptionTypes()
    - method body
        - stack
            - getStackSize()
    - is
        - isConstructor()
        - isMethod()
        - isTypeInitializer()
        - isVirtual()
        - isDefaultMethod()
        - isSpecializableFor(TypeDescription typeDescription)
        - isInvokableOn(TypeDescription typeDescription)
        - isInvokeBootstrap()
        - isInvokeBootstrap(List<? extends TypeDefinition> arguments)
        - isConstantBootstrap()
        - isConstantBootstrap(List<? extends TypeDefinition> arguments)
        - isBridgeCompatible(TypeToken typeToken)
    - represents
        - represents(Method method)
        - represents(Constructor<?> constructor)
    - invoke
        - getReceiverType()
    - annotation
        - getDefaultValue()
        - getDefaultValue(Class<T> type)
        - isDefaultValue()
        - isDefaultValue(AnnotationValue<?, ?> annotationValue)
    - other
        - asSignatureToken()
        - asTypeToken()

- MethodDescription
    - InGenericShape
    - InDefinedShape
    - AbstractBase

- MethodDescription
    - ForLoadedConstructor
        - ForLoadedConstructor(Constructor<?> constructor)
    - ForLoadedMethod
        - ForLoadedMethod(Method method)
    - Latent
        - TypeInitializer
            - TypeInitializer(TypeDescription typeDescription)

- MethodDescription
    - TypeSubstituting
    - Token
        - Token(int modifiers)
        - Token(String name, int modifiers, TypeDescription.Generic returnType)
        - Token(String name, int modifiers, TypeDescription.Generic returnType, List<? extends TypeDescription.Generic>
          parameterTypes)
    - SignatureToken
        - SignatureToken(String name, TypeDescription returnType, TypeDescription... parameterType)
        - SignatureToken(String name, TypeDescription returnType, List<? extends TypeDescription> parameterTypes)
    - TypeToken
        - TypeToken(TypeDescription returnType, List<? extends TypeDescription> parameterTypes)

## net.bytebuddy.implementation

### package structure

- net.bytebuddy.implementation
    - Implementation
    - Composable
    - FixedValue
    - FieldAccessor
    - StubMethod
    - MethodCall
    - SuperMethodCall
    - MethodDelegation
    - bytecode
        - ByteCodeAppender
        - StackManipulation
        - assign
            - Assigner

### Implementation

- Implementation: hierarchy
    - FixedValue
    - FieldAccessor
    - Composable
        - StubMethod
        - MethodCall
        - SuperMethodCall
        - MethodDelegation
        - InvokeDynamic
        - FieldSetting

---

### MethodCall

- MethodCall: component
    - opcode
        - MethodInvoker (invokespecial, invokevirtual, invokestatic)
    - method itself
        - MethodLocator
    - instance
        - TargetHandler
    - argument
        - ArgumentLoader
    - return
        - TerminationHandler

---

- MethodCall: method
    - method
        - invoke(Constructor<?> constructor)
        - invoke(Method method)
        - invoke(MethodDescription methodDescription)
        - invokeSelf()
        - invokeSuper()
    - instance
        - construct(Constructor<?> constructor)
        - construct(MethodDescription methodDescription)
    - parameter
        - basic
            - with(Object... argument)
            - with(TypeDescription... typeDescription)
            - with(JavaConstant... javaConstant)
            - withReference(Object... argument)
        - argument
            - withArgument(int... index)
            - withAllArguments()
            - withArgumentArray()
            - withArgumentArrayElements(int index)
            - withArgumentArrayElements(int index, int size)
            - withArgumentArrayElements(int index, int start, int size)
        - this
            - withThis()
        - class
            - withOwnType()
        - field
            - withField(String... name)
        - method
            - withMethodCall(MethodCall methodCall)
    - return
        - setsField(Field field)
        - setsField(FieldDescription fieldDescription)
        - setsField(ElementMatcher<? super FieldDescription> matcher)

---

- MethodCall: logic
    - logic
        - andThen(Implementation implementation)
        - andThen(Composable implementation)

---

- MethodCall: interface
    - interface
        - call(Callable<?> callable)
        - run(Runnable runnable)

---

- MethodCall: other
    - prepare
        - prepare(InstrumentedType instrumentedType)
        - appender(Target implementationTarget)

### WithoutSpecifiedTarget

- WithoutSpecifiedTarget
    - object
        - on(Object target)
        - on(T target, Class<? super T> type)
    - argument
        - onArgument(int index)
    - field
        - onField(String name)
        - onField(String name, FieldLocator.Factory fieldLocatorFactory)
        - onField(Field field)
        - onField(FieldDescription fieldDescription)
    - method
        - onMethodCall(MethodCall methodCall)
    - super
        - onSuper()
    - default
        - onDefault()
    - stack
        - on(StackManipulation stackManipulation, Class<?> type)
        - on(StackManipulation stackManipulation, TypeDescription typeDescription)

### FixedValue

- FixedValue
    - constant
        - value(JavaConstant fixedValue)
        - value(TypeDescription fixedValue)
    - method argument
        - argument(int index)
    - reference
        - nullValue()
        - self()
        - originType()
        - reference(Object value)
        - reference(Object value, String name)
    - mix
        - value(Object fixedValue)

- FixedValue
    - ForOriginType
    - ForThisValue
    - ForArgument
    - ForPoolValue
    - ForValue

### MethodDelegation

- MethodDelegation
    - class
        - to(Class<?> type)
        - to(TypeDescription typeDescription)
    - instance
        - to(Object target)
        - to(Object target, MethodGraph.Compiler methodGraphCompiler)
        - field
            - to(Object target, String fieldName)
            - to(Object target, String fieldName, MethodGraph.Compiler methodGraphCompiler)
        - type
            - to(Object target, Type type)
            - to(Object target, Type type, MethodGraph.Compiler methodGraphCompiler)
            - to(Object target, TypeDefinition typeDefinition)
            - to(Object target, TypeDefinition typeDefinition, MethodGraph.Compiler methodGraphCompiler)
            - to(Object target, Type type, String fieldName)
            - to(Object target, Type type, String fieldName, MethodGraph.Compiler methodGraphCompiler)
            - to(Object target, TypeDefinition typeDefinition, String fieldName)
            - to(Object target, TypeDefinition typeDefinition, String fieldName, MethodGraph.Compiler
              methodGraphCompiler)
        - constructor
            - toConstructor(Class<?> type)
            - toConstructor(TypeDescription typeDescription)
        - field
            - toField(String name)
            - toField(String name, FieldLocator.Factory fieldLocatorFactory)
            - toField(String name, MethodGraph.Compiler methodGraphCompiler)
            - toField(String name, FieldLocator.Factory fieldLocatorFactory, MethodGraph.Compiler methodGraphCompiler)
        - method
            - toMethodReturnOf(String name)
            - toMethodReturnOf(String name, MethodGraph.Compiler methodGraphCompiler)
    - config
        - withDefaultConfiguration()
        - withEmptyConfiguration()

- MethodDelegation Annotation
    - current class
        - class
            - @Origin
                - Class
                - Method
                - String
                - int
        - instance
            - @This
        - field
            - @FieldValue
        - method
            - @Argument
            - @AllArguments
    - class hierarchy
        - class
        - instance
            - @Super
        - method

## net.bytebuddy.implementation.bytecode

### ByteCodeAppender

- ByteCodeAppender
    - Simple
    - Compound

### StackManipulation

- StackManipulation
    - AbstractBase
        - Simple
        - Compound

## net.bytebuddy.implementation.bytecode.constant

### package

- net.bytebuddy.implementation.bytecode.constant
    - string
        - TextConstant
    - class

### ClassConstant

- ClassConstant
    - void
        - VOID(Void.class)
    - primitive
        - BOOLEAN(Boolean.class)
        - BYTE(Byte.class)
        - SHORT(Short.class)
        - CHARACTER(Character.class)
        - INTEGER(Integer.class)
        - LONG(Long.class)
        - FLOAT(Float.class)
        - DOUBLE(Double.class)
    - reference
        - of(TypeDescription typeDescription)

## net.bytebuddy.asm

### Advice

- Advice
    - method
        - @OnMethodEnter
        - @OnMethodExit
    - parameter
    - meta
        - @Origin
    - argument
        - @This
        - @Argument
        - @AllArguments
        - @Unused
    - local
        - @Local
    - exit
        - @Return
        - @Thrown
        - @StubValue
    - field
        - @FieldValue
    - advice
        - @Enter
        - @Exit

- Advice
    - Both
        - meta
            - @Advice.Origin
        - field
            - @Advice.FieldValue
        - method
            - instance
                - @Advice.This
            - arg
                - @Advice.Argument
                - @Advice.AllArguments
            - local
                - @Advice.Local
    - @OnMethodEnter
    - @OnMethodExit
        - local
            - @Advice.Enter
        - exit
            - return
                - @Advice.Return
                - @Advice.StubValue
            - exception
                - @Advice.Thrown

- Advice Annotation
    - common
        - @Origin
        - @This
        - @Argument
        - @AllArguments
        - @FieldValue
        - @Local
        - @StubValue
        - @Unused
        - @OnMethodEnter
        - @OnMethodExit
        - @Return
        - @Thrown
        - @Enter
        - @Exit

### AsmVisitorWrapper

- AsmVisitorWrapper
    - NoOp
    - AbstractBase
        - ForDeclaredFields
            - FieldVisitorWrapper
        - ForDeclaredMethods
            - MethodVisitorWrapper

- AsmVisitorWrapper
    - MemberRemoval

### MethodVisitorWrapper

- AsmVisitorWrapper.ForDeclaredMethods.MethodVisitorWrapper
    - MemberSubstitution

### MemberRemoval

- MemberRemoval
    - stripFields()
    - stripConstructors()
    - stripMethods()
    - stripInvokables()

### MemberAttributeExtension

- MemberAttributeExtension
    - ForField
        - annotation
            - annotate(Annotation... annotation)
            - annotate(List<? extends Annotation> annotations)
            - annotate(AnnotationDescription... annotation)
            - annotate(Collection<? extends AnnotationDescription> annotations)
            - attribute(FieldAttributeAppender.Factory attributeAppenderFactory)
        - on
            - on(ElementMatcher<? super FieldDescription.InDefinedShape> matcher)
    - ForMethod
        - annotation
            - method
                - annotateMethod(Annotation... annotation)
                - annotateMethod(List<? extends Annotation> annotations)
                - annotateMethod(AnnotationDescription... annotation)
                - annotateMethod(Collection<? extends AnnotationDescription> annotations)
            - parameter
                - annotateParameter(int index, Annotation... annotation)
                - annotateParameter(int index, List<? extends Annotation> annotations)
                - annotateParameter(int index, AnnotationDescription... annotation)
                - annotateParameter(int index, Collection<? extends AnnotationDescription> annotations)
            - common
                - attribute(MethodAttributeAppender.Factory attributeAppenderFactory)
        - on
            - on(ElementMatcher<? super MethodDescription> matcher)

## net.bytebuddy.matcher

### ElementMatcher

- ElementMatcher(I)
    - Junction(I)
        - AbstractBase(A)
            - Conjunction(C)
            - Disjunction(C)
            - ForNonNullValues(A)

### ElementMatchers

- ElementMatchers
    - common
        - name
            - named()
            - namedIgnoreCase()
            - nameStartsWith()
            - nameStartsWithIgnoreCase()
            - nameEndsWith()
            - nameEndsWithIgnoreCase()
            - nameContains()
            - nameContainsIgnoreCase()
            - nameMatches(regex)
            - namedOneOf()
        - access flag
            - isPublic()
            - isProtected()
            - isPackagePrivate()
            - isPrivate()
            - isStatic()
            - isFinal()
            - isVarArgs()
            - ...
        - annotation
            - isAnnotatedWith()
    - element
        - class
            - isInterface()
            - isAnnotation()
            - isDeclaredBy(Class<?> type)
        - constructor
            - isConstructor()
            - isDefaultConstructor()
        - field
            - fieldType()
        - method
            - basic
                - isMethod()
                - isGetter()
                - isSetter()
            - parameter
                - takesNoArguments()
                - takesArguments(length)
                - takesArgument(index,type)
                - takesArgument(type array)
                - takesGenericArgument()
                - hasParameters()
                - isOverriddenFrom()
            - return
                - returns()
                - returnsGeneric()
            - throws
                - canThrow()
    - logic
        - and
        - or
        - not
        - any()
        - anyOf()
        - none()

### ByteCodeElement

- ByteCodeElement
    - MethodDescription
    - FieldDescription
    - TypeDescription

- FilterableList
- FieldList
- MethodList
- AnnotationList

- ParameterDescription
- method
- getDeclaringMethod(): MethodDescription
- index
- getIndex()
- type
- getType(): TypeDescription.Generic
- annotation
- getDeclaredAnnotations()

## net.bytebuddy.utility

### JavaConstant

- JavaConstant
    - Simple
        - ofLoaded(Object)
        - wrap(Object)
    - MethodType
    - MethodHandle
    - Dynamic

## net.bytebuddy.pool

### TypePool

- TypePool
    - Empty
    - AbstractBase
        - Hierarchical
            - Default
                - ofSystemLoader()
                - ofPlatformLoader()
                - ofBootLoader()
                - of(ClassLoader classLoader)
                - of(ClassFileLocator classFileLocator)
            - LazyFacade
            - ClassLoading
                - of(ClassLoader classLoader)
                - of(ClassLoader classLoader, TypePool parent)
                - ofSystemLoader()
                - ofPlatformLoader()
                - ofBootLoader()
            - Explicit
