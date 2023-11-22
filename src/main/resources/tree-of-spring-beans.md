# spring-beans

## before bean, after bean

- BeanDefinition
    - basic
        - parent
            - setParentName(String parentName)
            - getParentName()
        - name
            - setBeanClassName(String beanClassName)
            - getBeanClassName()
        - description
            - setDescription(String description)
            - getDescription()
    - type
        - getResolvableType()
    - object
    - explicit
    - instance
        - constructor
            - hasConstructorArgumentValues()
            - getConstructorArgumentValues()
        - property
            - hasPropertyValues()
            - getPropertyValues()
        - depend
            - setDependsOn(String... dependsOn)
            - getDependsOn()
        - factory
            - setFactoryBeanName(String factoryBeanName)
            - getFactoryBeanName()
            - setFactoryMethodName(String factoryMethodName)
            - getFactoryMethodName()
    - auto inject
        - autowire
            - setAutowireCandidate(boolean autowireCandidate)
            - isAutowireCandidate()
        - primary
            - setPrimary(boolean primary)
            - isPrimary()
    - scope: space
        - setScope(String scope)
        - getScope()
        - isSingleton()
        - isPrototype()
    - lazy: time
        - setLazyInit(boolean lazyInit)
        - isLazyInit()
    - hook
        - init
            - setInitMethodName(String initMethodName)
            - getInitMethodName()
        - destroy
            - setDestroyMethodName(String destroyMethodName)
            - getDestroyMethodName()
    - other
        - role
            - setRole(int role)
            - getRole()
        - description
            - getResourceDescription()
        - xxx
            - isAbstract()
            - getOriginatingBeanDefinition()

## BeanDefinitionRegistry

- BeanDefinitionRegistry
    - single
    - exist
        - containsBeanDefinition(String beanName)
        - isBeanNameInUse(String beanName)
    - CRUD
        - registerBeanDefinition(String beanName, BeanDefinition beanDefinition): Create
        - removeBeanDefinition(String beanName)                                 : Delete
        - getBeanDefinition(String beanName)                                    : Read
    - multiple
        - getBeanDefinitionNames()
        - getBeanDefinitionCount()

## BeanFactory

- BeanFactory
    - bean
    - exist
        - containsBean(String name)
    - name
        - getAliases(String name)
    - type
        - isTypeMatch(String name, Class<?> typeToMatch)
        - isTypeMatch(String name, ResolvableType typeToMatch)
        - getType(String name)
        - getType(String name, boolean allowFactoryBeanInit)
    - instance
        - getBean(String name)
        - getBean(Class<T> requiredType)
        - getBean(String name, Class<T> requiredType)
        - getBean(String name, Object... args)
        - getBean(Class<T> requiredType, Object... args)
    - scope
        - isSingleton(String name)
        - isPrototype(String name)
    - provider
        - getBeanProvider(Class<T> requiredType)
        - getBeanProvider(ResolvableType requiredType)

