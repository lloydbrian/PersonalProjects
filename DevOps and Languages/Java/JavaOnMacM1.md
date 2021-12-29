## Install openjdk
### installs the latesst compatible open jdk
```
-> % brew install openjdk
```

## Create softlink to the JavaVirtualMachines home directory
### You create multiple soft links for multiple openjdk versions in this folder.
```
-> % ln -sfn /opt/homebrew/opt/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk 

lloydbriantech@Lloyds-MB-Pro-M1 [17:53:08] [~] 
-> % java --version
openjdk 16 2021-03-16
OpenJDK Runtime Environment (build 16+14)
OpenJDK 64-Bit Server VM (build 16+14, mixed mode)
```
 
 ## List installed JDKs using the wrapper command from the OS
 ### Can have multiple java versions as well. Information is pulled from the JavaVirtualMachines folder
 ```
lloydbriantech@Lloyds-MB-Pro-M1 [17:53:10] [~] 
-> % /usr/libexec/java_home -V
Matching Java Virtual Machines (1):
    16 (arm64) "UNDEFINED" - "OpenJDK 16" /opt/homebrew/Cellar/openjdk/15.0.1/libexec/openjdk.jdk/Contents/Home
/opt/homebrew/Cellar/openjdk/15.0.1/libexec/openjdk.jdk/Contents/Home
 ```

