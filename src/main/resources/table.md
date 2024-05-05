# Morse-Code
A, • −, N, − •
B, − • • •, O, − − −
C, − • − •, P, • − − •
D, − • •, Q, − − • −
E, •, R, • − •
F, • • − •, S, • • •
G, − − •, T, −
H, • • • •, U, • • −
I, • •, V, • • • −
J, • − − −, W, • − −
K, − • −, X, − • • −
L, • − • •, Y, − • − −
M, − −, Z, − − • •

# Common System Properties
System property, Meaning
java.vendor, Vendor-specific string
java.vendor.url, URL of vendor
java.version, Java version
java.home, Java installation directory
java.class.version, Java class version
java.class.path, The classpath
os.name, Operating system name
os.arch, Operating system architecture
os.version, Operating system version
file.separator, File separator (such as / or \)
path.separator, Path separator (such as : or ;)
line.separator, Line separator (such as \n or \r\n)
user.name, User account name
user.home, User's home directory

# Platform MXBeans
Interface | Part of VM Managed | Object Name | Instances per VM
ClassLoadingMXBean | Class loading system | java.lang:type=ClassLoading | One
CompilationMXBean | Compilation system | java.lang:type=Compilation | Zero or one
GarbageCollectorMXBean | Garbage collector | java.lang:type=GarbageCollector,name=collectorName | One or more
LoggingMXBean | Logging system | java.util.logging:type=Logging | One
MemoryManagerMXBean | Memory pool | java.lang:type=MemoryManager,name=managerName | One or more
MemoryPoolMXBean | Memory | java.lang:type=MemoryPool,name=poolName | One or more
MemoryMXBean | Memory system | java.lang:type=Memory | One
OperatingSystemMXBean | Underlying operating system | java.lang:type=OperatingSystem | One
RuntimeMXBean | Runtime system | java.lang:type=Runtime | One
ThreadMXBean | Thread system | java.lang:type=Threading | One
