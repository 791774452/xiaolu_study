# JVM



> OOM异常与JVM调优

1. 可以通过参数dump堆内存快照

 -XX:+HeapDumpOnOutOfMemoryError 发生OOM时，理解dump堆内存 

 -XX:HeapDumpPath=E:\Temp 堆内存快照保存路径



2. 也可以通过 JPS 获取虚拟机进程ID， 通过jmap 命令dump堆内存快照 jmap -dump:format=b,file=E:\Temp\dump.hprof 4676。



3. 将dump下来的堆内存快照进行分析。此处介绍 jvisualvm 可视化分析方式。 



