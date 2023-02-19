# MQTT

- MQTT Control Packet
    - Fixed header
        - MQTT Control Packet type
        - Flags
        - Remaining Length
    - Variable header
        - Packet Identifier
    - Payload


- IMqttClient
    - conn
        - connect()
        - disconnect()
        - isConnected()
        - reconnect()
    - topic
        - subscribe(topicFilter)
        - unsubscribe(topicFilter)
        - publish(topic, message)
        - getTopic(topic)
        - setCallback(callback)
    - other
        - getClientId()
        - getServerURI()
        - setManualAcks(manualAcks)
        - close()
