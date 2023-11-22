# Java Annotation

## AnnotatedElement

- AnnotatedElement
    - use
        - isAnnotationPresent(Class<? extends Annotation> annotationClass)
        - getAnnotation(Class<T> annotationClass)
        - getAnnotations()
        - getAnnotationsByType(Class<T> annotationClass)
    - declare
        - getDeclaredAnnotation(Class<T> annotationClass)
        - getDeclaredAnnotationsByType(Class<T> annotationClass)
        - getDeclaredAnnotations()
