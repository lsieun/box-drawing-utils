# Java Serialization

## Object Serialization Stream Protocol

- newClass
    - TC_CLASS
    - classDesc
        - newClassDesc
            - TC_CLASSDESC
                - TC_CLASSDESC
                - className(utf)
                - serialVersionUID(long)
                - newHandle
                - classDescInfo
                    - classDescFlags(byte)
                    - fields
                        - count(short)
                        - fieldDesc[count]
                            - primitiveDesc
                                - prim_typecode
                                - fieldName(utf)
                            - objectDesc
                                - obj_typecode
                                - fieldName(utf)
                                - className1
                    - classAnnotation
                        - contents(optional)
                        - endBlockData
                    - superClassDesc
            - TC_PROXYCLASSDESC
                - TC_PROXYCLASSDESC
                - newHandle
                - proxyClassDescInfo
        - nullReference
        - (ClassDesc)prevObject
    - newHandle

- learn-java-serialization
    - visitModifiedUTF8WithTitle
        - visitPlainText
            - addOneValue
        - visitModifiedUTF8
            - addThreeValue(length)
            - addThreeValue(content)

