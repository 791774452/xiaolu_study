# JVM



> OOM异常与JVM调优

1. 可以通过参数dump堆内存快照

 -XX:+HeapDumpOnOutOfMemoryError 发生OOM时，理解dump堆内存 

 -XX:HeapDumpPath=E:\Temp 堆内存快照保存路径



2. 也可以通过 JPS 获取虚拟机进程ID， 通过jmap 命令dump堆内存快照 jmap -dump:format=b,file=E:\Temp\dump.hprof 4676。



3. 将dump下来的堆内存快照进行分析。此处介绍 jvisualvm 可视化分析方式。 



````shell
groovyScript("def result = '';def params = \"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList(); for(i = 0; i < params.size(); i++) {if(params[i] != '')result+='* @param ' + params[i] + ' '+ params[i]+ ((i < params.size() - 1) ? ' \\r\\n ' : '')}; return result == '* @param null null' ? null : '\\r\\n ' + result", methodParameters())
````

````shell
groovyScript("def result='\\r\\n * @return ';  def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split('<').toList(); for(i = 0; i < params.size(); i++) {if(i!=0){result+='<';};  def p1=params[i].split(',').toList();  for(i2 = 0; i2 < p1.size(); i2++)  { def p2=p1[i2].split('\\\\.').toList();  result+=p2[p2.size()-1]; if(i2!=p1.size()-1){result+=','}  } ; };  return result=='\\r\\n * @return null' ? '' :result", methodReturnType())  
````

