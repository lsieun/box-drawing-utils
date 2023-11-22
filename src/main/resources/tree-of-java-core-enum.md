# Java Enum

## EnumSet

- EnumSet
    - static
        - of
            - of(E e)
            - of(E e1, E e2)
            - of(E e1, E e2, E e3)
            - of(E e1, E e2, E e3, E e4)
            - of(E e1, E e2, E e3, E e4, E e5)
            - of(E first, E... rest)
        - range
            - range(E from, E to)
        - coll
            - noneOf(Class<E> elementType)
            - allOf(Class<E> elementType)
            - copyOf(EnumSet<E> s)
            - copyOf(Collection<E> c)
            - complementOf(EnumSet<E> s)
    - non-static
        - addAll()
        - addRange(E from, E to)
        - complement()
        - clone()


