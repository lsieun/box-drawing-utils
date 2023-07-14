- Spring Framework
- Core Container
- Core
- Beans
- BeanFactory
- Context
- ApplicationContext
- Expression Language
- Data Access
- JDBC
- ORM: Object Relational Mapping
- OXM: Object/XML
- JMS: Java Messaging Service
- Transaction
- Web

# create是创建对象

# inject是建立对象之间的关系

- Spring IOC
- container
- config
- XML
- Annotation
- function
- create
- inject (DI)
  - explicit wiring
    - constructor-ref
    - property
      - implicit wiring (autowire)
    - byName
    - byType
    - constructor
    - *mix
- lookup
- Event Handling
- Built-in Event
- Custom Event
  - public
  - receive
- bean
- id/name
- class
- object
- scope
  - prototype
  - singleton
- life-cycle







- ConfigurableBeanFactory
- parent
- setParentBeanFactory(BeanFactory parentBeanFactory)
- classloader
- setBeanClassLoader(ClassLoader beanClassLoader)
- getBeanClassLoader()
- setTempClassLoader(ClassLoader tempClassLoader)
- getTempClassLoader()
- cache
- setCacheBeanMetadata(boolean cacheBeanMetadata)
- isCacheBeanMetadata()
- expression
- setBeanExpressionResolver(BeanExpressionResolver resolver)
- getBeanExpressionResolver()
- conversion
- setConversionService(ConversionService conversionService)
- getConversionService()
- editor
- addPropertyEditorRegistrar(PropertyEditorRegistrar registrar)
- registerCustomEditor(Class<?> requiredType, Class<? extends PropertyEditor> propertyEditorClass)
- copyRegisteredEditorsTo(PropertyEditorRegistry registry)
- type converter
- setTypeConverter(TypeConverter typeConverter)
- getTypeConverter()
- post processor
- addBeanPostProcessor(BeanPostProcessor beanPostProcessor)
- getBeanPostProcessorCount()
- scope
- registerScope(String scopeName, Scope scope)
- getRegisteredScopeNames()
- getRegisteredScope(String scopeName)
- startup
- setApplicationStartup(ApplicationStartup applicationStartup)
- getApplicationStartup()

- resource
- Resource(I)
- ContextResource(I)
- WritableResource(I)
- FileUrlResource(C)
- AbstractResource(C)
- AbstractFileResolvingResource(C)
  - UrlResource
    - FileUrlResource
      - ClassPathResource
    - ClassPathContextResource
- ResourceLoader(I)
- ResourcePatternResolver(I)
- PathMatchingResourcePatternResolver(C)
- DefaultResourceLoader(C)


- DefaultBeanDefinitionDocumentReader.parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate)
- importBeanDefinitionResource(Element ele): <import>
- processAliasRegistration(Element ele): <alias>
- processBeanDefinition(Element ele, BeanDefinitionParserDelegate delegate): <bean>
- BeanDefinitionParserDelegate.parseBeanDefinitionElement(Element ele):BeanDefinitionHolder
- createBeanDefinition
  - BeanDefinitionReaderUtils.createBeanDefinition
- parseBeanDefinitionAttributes: singleton, scope, abstract, lazy-init, autowire, depends-on, primary, init-method,
  destroy-method, factory-method, factory-bean
- parseMetaElements: <meta>
- parseLookupOverrideSubElements: <lookup-method>
- parseReplacedMethodSubElements: <replace-method>
- parseConstructorArgElements: <constructor-arg>
- parsePropertyElements: <property>
- parseQualifierElements <qualifier>
- BeanDefinitionParserDelegate.decorateBeanDefinitionIfRequired(Element ele, BeanDefinitionHolder originalDef)
- BeanDefinitionReaderUtils.registerBeanDefinition(BeanDefinitionHolder definitionHolder, BeanDefinitionRegistry
  registry)
- BeanDefinitionRegistry.registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
- ReaderContext.fireComponentRegistered(ComponentDefinition componentDefinition)
- doRegisterBeanDefinitions(Element root)


- AbstractBeanFactory.getBean(String name)
- doGetBean(String name, Class<T> requiredType, Object[] args, boolean typeCheckOnly)
- String beanName = transformedBeanName(name)
- Object sharedInstance = getSingleton(beanName);
- if (sharedInstance != null && args == null)
- beanInstance = getObjectForBeanInstance(sharedInstance, name, beanName, null);
- else
- BeanFactory parentBeanFactory = getParentBeanFactory();
- createBean(beanName, mbd, args)
- getObjectForBeanInstance(Object beanInstance, String name, String beanName, RootBeanDefinition mbd)

