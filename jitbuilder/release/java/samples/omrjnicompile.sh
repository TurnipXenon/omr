#!/bin/bash
 
# Declare a string array with type
declare -a StringArray=("echo \"Location is at: $(pwd)\""
"javac -h . *.java" 
"g++ -c -fPIC -I\${JAVA_HOME}/include -I\${JAVA_HOME}/include/linux MethodHandler.cpp -o MethodHandler.o" 
"g++ -shared -fPIC -o libnative.so MethodHandler.o -lc" 
"java -Djava.library.path=$(pwd) Simple")
 
# Read the array values with space
for val in "${StringArray[@]}"; do
  if eval $val; then
    printf "Success: %s\n" "$val"
  else
    printf "Failure: %s\n" "$val"
    exit
  fi
done