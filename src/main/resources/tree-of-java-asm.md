## Java ASM

## Components

- ObjectWeb ASM
    - Core API
        - asm.jar
            - ClassReader
            - ClassVisitor
                - FieldVisitor
                - MethodVisitor
                    - visitLabel
                    - visitFrame
            - ClassWriter
                - FieldWriter
                - MethodWriter
        - asm-util.jar
        - asm-commons.jar
    - Tree API
        - asm-tree.jar
        - asm-analysis.jar

## What ASM Can Do

- What ASM Can Do
    - analysis
        - find potential bugs
        - detect unused code
        - reverse engineer code
    - generation
    - transformation
        - optimize programs
        - obfuscate programs
        - insert performance monitoring code

- method invocation
    - static method
        - invokestatic
    - instance method
        - invokevirtual (class)
        - invokespecial (class)
            - constructor
            - private
            - super
        - invokeinterface (interface)
    - dynamic method
        - invokedynamic

- Java: three basic control structures
    - sequence
    - selection (if, switch)
    - looping (for, while)

- Bytecode: control flow
    - sequence
    - jump
        - selection (if, switch)
        - looping (for, while)

### Core-Based Transformation

- ASM Transformation
    - stateless transformations
    - stateful transformations
        - state machine
            - a finite number of states
            - current state
            - state transitions
        - examples
            - iconst_0 iadd
            - aload_0 aload_0 getfield putfield
            - getstatic ldc invokevirtual

### Tree-Based Transformation

- Tree-Based Transformation
    - ClassNode
        - ClassTransformer
        - Two Common Patterns
    - MethodNode
        - MethodTransformer
        - Two Common Patterns

## asm-core

### ClassVisitor

- ClassVisitor
    - visit()
    - visitField()
    - visitMethod()
    - visitEnd()

### MethodVisitor

- MethodVisitor
    - visitCode()
    - visitXxxInsn()
    - visitMaxs()
    - visitEnd()

## asm-commons

### AdviceAdapter

- AdviceAdapter
    - onMethodEnter()
    - onMethodExit()

## asm-tree

### ClassNode

- ClassNode
    - FieldNode
    - MethodNode
        - InsnList
            - AbstractInsnNode
                - FieldInsnNode
                - IincInsnNode
                - InsnNode
                - IntInsnNode
                - InvokeDynamicInsnNode
                - JumpInsnNode
                - LabelNode
                - LdcInsnNode
                - LookupSwitchInsnNode
                - MethodInsnNode
                - MultiANewArrayInsnNode
                - TableSwitchInsnNode
                - TypeInsnNode
                - VarInsnNode
        - TryCatchBlockNode


