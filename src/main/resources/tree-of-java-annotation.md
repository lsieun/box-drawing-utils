# Java Annotation

## java.lang.annotation

- java.lang.annotation
    - super
        - Annotation
    - meta
        - time
            - Retention
            - RetentionPolicy
        - space
            - Target
            - ElementType
        - other
            - Inherited
            - Repeatable
            - Documented
    - native
        - Native
    - error
        - AnnotationFormatError
        - AnnotationTypeMismatchException
        - IncompleteAnnotationException

## Annotation

- Annotation
    - Meta
        - @Retention
        - @Target
        - @Inherited
        - @Repeatable
    - Basic
        - @Override
        - @Deprecated
        - @SuppressWarnings
        - @SafeVarargs
    - Advanced
        - @CallerSensitive

## ElementType

- ElementType
    - boundary
        - PACKAGE
        - MODULE
    - type
        - TYPE
        - ANNOTATION_TYPE
        - TYPE_USE
    - field
        - FIELD
    - method
        - outer
            - CONSTRUCTOR
            - METHOD
        - inner
            - PARAMETER
            - LOCAL_VARIABLE
    - feature
        - generic
            - TYPE_PARAMETER
        - record
            - RECORD_COMPONENT
