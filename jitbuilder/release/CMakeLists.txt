###############################################################################
# Copyright (c) 2017, 2020 IBM Corp. and others
#
# This program and the accompanying materials are made available under
# the terms of the Eclipse Public License 2.0 which accompanies this
# distribution and is available at https://www.eclipse.org/legal/epl-2.0/
# or the Apache License, Version 2.0 which accompanies this distribution and
# is available at https://www.apache.org/licenses/LICENSE-2.0.
#
# This Source Code may also be made available under the following
# Secondary Licenses when the conditions for such availability set
# forth in the Eclipse Public License, v. 2.0 are satisfied: GNU
# General Public License, version 2 with the GNU Classpath
# Exception [1] and GNU General Public License, version 2 with the
# OpenJDK Assembly Exception [2].
#
# [1] https://www.gnu.org/software/classpath/license.html
# [2] http://openjdk.java.net/legal/assembly-exception.html
#
# SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR LicenseRef-GPL-2.0 WITH Assembly-exception
###############################################################################


set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED TRUE)
set(CMAKE_CXX_EXTENSIONS OFF)

# java side
find_package(Java REQUIRED)
find_package(JNI REQUIRED)
include(UseJava)

set(CMAKE_JAVA_COMPILE_FLAGS "-source" "1.6" "-target" "1.6")

macro(create_jitbuilder_test target)
    omr_add_executable(${target} NOWARNINGS ${ARGN})
    target_include_directories(${target} PUBLIC cpp/include)
    target_link_libraries(${target}
        jitbuilder
        ${CMAKE_DL_LIBS})
    add_test(NAME ${target}_example_as_test COMMAND ${target})
endmacro(create_jitbuilder_test)

macro(create_jitbuilder_test_java target src_path entry_point)
    # ../../build/
    add_jar(JNI${target} ${src_path}
        java/include/BytecodeBuilder.java
        java/include/IlBuilder.java
        java/include/IlType.java
        java/include/IlValue.java
        java/include/JitBuilder.java
        java/include/MethodBuilder.java
        java/include/MethodHandler.java
        java/include/ThunkBuilder.java
        java/include/TypeDictionary.java
        java/include/VirtualMachineOperandArray.java
        java/include/VirtualMachineOperandStack.java
        java/include/VirtualMachineRegister.java
        java/include/VirtualMachineRegisterInStruct.java
        java/include/VirtualMachineState.java
        ENTRY_POINT ${entry_point})
    get_target_property(_jarFile JNI${target} JAR_FILE)
    get_target_property(_classDir JNI${target} CLASSDIR)
    
    # based on https://stackoverflow.com/questions/18994344/cmake-jni-error
    # generate header
    set(_stubDir ${CMAKE_CURRENT_BINARY_DIR})
    add_custom_command(
        OUTPUT JNI${target}.h
        COMMAND ${Java_JAVAG_EXECUTABLE} -verbose
        -classpath ${_classDir}
        -d ${_stubDir}
        -jni JNI${target}
    DEPENDS JNI${target}
    )

    # generate jni library
    include_directories(${JNI_INCLUDE_DIRS} ${_classDir} ${_stubDir})
    add_library(${target} MODULE ${target}.c JNI${target}.h)
    set_target_properties(${target} PROPERTIES SUFFIX ".jnilib")
    target_link_libraries(${target} ${JNI_LIBRARIES})
    
    add_test(NAME ${target}_example_as_test 
        COMMAND ${Java_JAVA_EXECUTABLE} 
        -Djava.library.path=${CMAKE_CURRENT_BINARY_DIR}
        -cp ${_jarFile} ${target})
endmacro(create_jitbuilder_test_java)

# source-only jar file
# based on https://gitlab.kitware.com/cmake/cmake/-/issues/18905 suggestion


# Basic Tests: These should run properly on all platforms.
create_jitbuilder_test(conditionals         cpp/samples/Conditionals.cpp)
create_jitbuilder_test(isSupportedType      cpp/samples/IsSupportedType.cpp)
create_jitbuilder_test(iterfib              cpp/samples/IterativeFib.cpp)
create_jitbuilder_test(nestedloop           cpp/samples/NestedLoop.cpp)
create_jitbuilder_test(pow2                 cpp/samples/Pow2.cpp)
create_jitbuilder_test(simple               cpp/samples/Simple.cpp)
create_jitbuilder_test(worklist             cpp/samples/Worklist.cpp)
              
create_jitbuilder_test_java(simpleJava      java/samples/Simple.java       jitbuilder.release.java.samples.Simple)

# Extended JitBuilder Tests: These may not run properly on all platforms
# Opt in by setting OMR_JITBUILDER_TEST_EXTENDED
if(OMR_JITBUILDER_TEST_EXTENDED)
    create_jitbuilder_test(call              cpp/samples/Call.cpp)
    create_jitbuilder_test(conststring       cpp/samples/ConstString.cpp)
    create_jitbuilder_test(dotproduct        cpp/samples/DotProduct.cpp)
    create_jitbuilder_test(inliningrecfib    cpp/samples/InliningRecFib.cpp)
    create_jitbuilder_test(fieldaddress      cpp/samples/FieldAddress.cpp)
    create_jitbuilder_test(linkedlist        cpp/samples/LinkedList.cpp)
    create_jitbuilder_test(localarray        cpp/samples/LocalArray.cpp)
    create_jitbuilder_test(operandarraytests cpp/samples/OperandArrayTests.cpp)
    create_jitbuilder_test(operandstacktests cpp/samples/OperandStackTests.cpp)
    create_jitbuilder_test(pointer           cpp/samples/Pointer.cpp)
    create_jitbuilder_test(recfib            cpp/samples/RecursiveFib.cpp)
    create_jitbuilder_test(structArray       cpp/samples/StructArray.cpp)
    create_jitbuilder_test(switch            cpp/samples/Switch.cpp)
    create_jitbuilder_test(tableswitch       cpp/samples/TableSwitch.cpp)
    create_jitbuilder_test(toiltype          cpp/samples/ToIlType.cpp)
    create_jitbuilder_test(union             cpp/samples/Union.cpp)
    create_jitbuilder_test(vmregister        cpp/samples/VMRegister.cpp)
endif()

# Experimental Tests: These are still on the experimental side
# Opt in by setting OMR_JITBUILDER_EXPERIMENTAL
if(OMR_JITBUILDER_EXPERIMENTAL)
    create_jitbuilder_test(atomicoperations             cpp/samples/AtomicOperations.cpp)
    create_jitbuilder_test(transactionaloperations      cpp/samples/TransactionalOperations.cpp)
endif()


# Additional Tests: These may not run properly on all platforms
# Mandelbrot takes arguments for its test so will require we enhance create_jitbuilder_test
#create_jitbuilder_test(mandelbrot cpp/samples/Mandelbrot.cpp)