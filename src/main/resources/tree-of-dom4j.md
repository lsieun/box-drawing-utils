- SAXReader
    - read
        - read(File file)
        - read(URL url)
        - read(String systemId)
        - read(InputStream in)
        - read(Reader reader)
        - read(InputStream in, String systemId)
        - read(Reader reader, String systemId)
        - read(InputSource in)

- Document
    - root
        - getRootElement()

- Element
    - root
        - isRootElement()
    - element
        - single
            - element(String name)
        - list
            - elements()
            - elements(String name)
        - iterator
            - elementIterator()
            - elementIterator(String name)
    - attribute
        - attributeValue(String name)
        - attribute(String name)
        - attributes()
        - attributeIterator()
    - text
        - getText()
        - getTextTrim()
        - elementText

- Attribute

