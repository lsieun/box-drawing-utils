# JavaFX

- JavaFX
    - source code
        - Application
            - Stage
                - Scene
                    - Node
    - command line
        - launch
            - Application.launch(Class<? extends Application>, String...)
            - Application.launch(String...)
        - parameter
            - Parameters
                - getNamed()
                - getUnnamed()
                - getRaw()
    - runtime
        - life cycle
            - constructor
            - init()
            - start()
            - stop()
        - thread
            - JavaFX-Launcher Thread
            - JavaFX Application Thread
    - exit
        - Platform.exit()

- javafx
    - application
        - Application
        - Platform
    - scene
        - Scene
        - control
            - Button
            - Label
            - TextField
        - layout
            - VBox
    - stage
        - Stage

## Thread

- JavaFX runtime
    - JavaFX-Launcher Thread
        - init()
    - JavaFX Application Thread
        - constructor()
        - start()
        - stop()

## javafx.stage

- javafx.stage

### Window

- Window
    - Stage
    - PopupWindow
        - Popup
        - PopupControl
            - ContextMenu
            - Tooltip

## javafx.scene

- Node
    - Parent
        - Region
            - Pane
                - FlowPane
                - GridPane
                - TilePane
                - HBox
                - VBox
            - Control
                - TextInputControl
                    - TextField
                    - TextArea
        - Group
    - Shape
        - Text

## Properties And Bindings

- javafx.beans.property
    - ReadOnlyProperty
        - ReadOnlyIntegerProperty
        - Property
            - BooleanProperty
            - IntegerProperty
                - IntegerPropertyBase
                    - SimpleIntegerProperty
                        - ReadOnlyIntegerWrapper
            - LongProperty
            - FloatProperty
            - DoubleProperty
            - StringProperty
            - ObjectProperty
            - ListProperty
            - MapProperty





