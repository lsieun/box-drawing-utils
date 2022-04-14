# ByteBuddy

## net.bytebuddy

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
  - subclass(Class<T>)                           : DynamicType.Builder
  - subclass(Class<T>, ConstructorStrategy)      : DynamicType.Builder
  - subclass(Type)                               : DynamicType.Builder
  - subclass(Type, ConstructorStrategy)          : DynamicType.Builder
  - subclass(TypeDefinition)                     : DynamicType.Builder
  - subclass(TypeDefinition, ConstructorStrategy): DynamicType.Builder
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
 - decorate
  - decorate(Class<T>)
  - decorate(Class<T>, ClassFileLocator)
  - decorate(TypeDescription, ClassFileLocator)

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

## net.bytebuddy.description

### package

- net.bytebuddy.description
    - NamedElement
    - ByteCodeElement
    - ModifierReviewable
    - type
        - TypeDescription
    - method
        - MethodDescription

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

### TypeDescription

- TypeDescription
- isAssignableFrom()
- isAssignableTo()
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

- AsmVisitorWrapper
- AbstractBase
- ForDeclaredFields
- MemberRemoval
- stripFields()
- stripConstructors()
- stripMethods()
- stripInvokables()
- ForDeclaredMethods

- ElementMatcher
- Junction
- AbstractBase
- Conjunction
- Disjunction
- ForNonNullValues

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
- constructor
- isConstructor()
- isDefaultConstructor()
- field
- fieldType
- method
- basic
    - isMethod()
    - isGetter()
    - isSetter()
- parameter
    - takesNoArguments()
    - takesArgument(length)
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
- anyOf()
- none()

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
