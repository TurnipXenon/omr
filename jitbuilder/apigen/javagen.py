#! /usr/bin/env python

###############################################################################
# Copyright (c) 2020, 2020 IBM Corp. and others
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

"""
A module for generating the JitBuilder Java client API.

By convention, functions in this module that start with "generate_"
or "get_" return generated code as a string. Functions that start with
"write_" take as first argument a writer-like object whose `write()`
method is called to write the generated code. Passing a file handle
as this object will therefore write the generated code to a the
corresponding file. The documentation for several "writer_" services
also describes how the generated code works.
"""

import os
import datetime
import json
from os import replace
import shutil
import argparse
from genutils import *

class JavaGenerator:

    def __init__(self, api, headerdir, extras):
        self.api = api

        # Mapping between API type descriptions and Java data types
        self.java_client_type_map = { "none": "void"
                                    , "boolean": "boolean"
                                    , "integer": "long"
                                    , "int8": "byte"
                                    , "int16": "short"
                                    , "int32": "int"
                                    , "int64": "long"
                                    , "uint32": "int"
                                    , "float": "float"
                                    , "double": "double"
                                    , "pointer": "long"
                                    , "ppointer": "long"
                                    , "unsignedInteger": "long"
                                    , "constString": "String"
                                    , "string": "String"
                                    }
        # Mapping between API type descriptions and implementation native function types
        self.java_impl_type_map = { "none": "void"
                                  , "boolean": "boolean"
                                  , "integer": "long"
                                  , "int8": "byte"
                                  , "int16": "short"
                                  , "int32": "int"
                                  , "int64": "long"
                                  , "uint32": "int"
                                  , "float": "float"
                                  , "double": "double"
                                  , "pointer": "long"
                                  , "ppointer": "long"
                                  , "unsignedInteger": "long"
                                  , "constString": "String"
                                  , "string": "String"
                                  }
        # Mapping between API type descriptions and CPP data types
        self.cpp_type_map = { "none": "void"
                            , "boolean": "bool"
                            , "integer": "long long"
                            , "int8": "byte"
                            , "int16": "short"
                            , "int32": "int"
                            , "int64": "long"
                            , "uint32": "int"
                            , "float": "float"
                            , "double": "double"
                            , "pointer": "long"
                            , "ppointer": "long"
                            , "unsignedInteger": "long"
                            , "constString": "char *"
                            , "string": "char *"
                            }
        # Mapping between API type descriptions and JNI data types
        self.jni_native_type_map = { "none": "void"
                                   , "boolean": "jboolean"
                                   , "integer": "jlong"
                                   , "int8": "jbyte"
                                   , "int16": "jshort"
                                   , "int32": "jint"
                                   , "int64": "jlong"
                                   , "uint32": "jint"
                                   , "float": "jfloat"
                                   , "double": "jdouble"
                                   , "pointer": "jlong"
                                   , "ppointer": "jlong"
                                   , "unsignedInteger": "jlong"
                                   , "constString": "jstring"
                                   , "string": "jstring"
                                   }
        self.jni_type_api_name_map = { "none": "void"
                                     , "boolean": "Boolean"
                                     , "integer": "Int"
                                     , "int8": "Byte"
                                     , "int16": "Short"
                                     , "int32": "Int"
                                     , "int64": "Long"
                                     , "uint32": "Int"
                                     , "float": "Float"
                                     , "double": "Double"
                                     , "pointer": "Object"
                                     , "ppointer": "Object"
                                     , "unsignedInteger": "Long"
                                     , "constString": "Object"
                                     , "string": "Object"
                                     }
        self.jni_type_signature_string_map = { "none": "V"
                                             , "boolean": "Z"
                                             , "integer": "I"
                                             , "int8": "B"
                                             , "int16": "S"
                                             , "int32": "I"
                                             , "int64": "J"
                                             , "uint32": "I"
                                             , "float": "F"
                                             , "double": "D"
                                             , "pointer": "Ljava/lang/Object;"
                                             , "ppointer": "Ljava/lang/Object;"
                                             , "unsignedInteger": "J"
                                             , "constString": "L/java/lang/String;"
                                             , "string": "L/java/lang/String;"
                                             }
        self.jni_type_names = ("NoType", "Int8", "Int16", "Int32"
        , "Int64", "Float", "Double", "Address", "VectorInt8"
        , "VectorInt16", "VectorInt32", "VectorInt64", "VectorFloat"
        , "VectorDouble", "Word")
        self.simple_java_types = ("long", "String", "int", "long[]")

        # List of files to be included in the client API implementation.
        self.impl_include_files = self.gen_api_impl_includes(api.classes(), headerdir)

        # Classes that have extra APIs, not covered in the main description
        self.classes_with_extras = extras

        self.allocator_setter_name = "setAllocators"

    
    # Generic utilities ##################################################

    def get_copyright_header(self):
        return """\
/*******************************************************************************
 * Copyright (c) {0}, {0} IBM Corp. and others
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution and is available at http://eclipse.org/legal/epl-2.0
 * or the Apache License, Version 2.0 which accompanies this distribution
 * and is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License, v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception [1] and GNU General Public
 * License, version 2 with the OpenJDK Assembly Exception [2].
 *
 * [1] https://www.gnu.org/software/classpath/license.html
 * [2] http://openjdk.java.net/legal/assembly-exception.html
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR LicenseRef-GPL-2.0 WITH Assembly-exception
 *******************************************************************************/
        """.format(datetime.datetime.now().year)


    def get_common_system_imports(self):
        return ["stdint.h", "stddef.h"]

    def gen_api_impl_includes(self, classes_desc, api_headers_dir):
        """
        Generates a list of files to be included in the client
        API implementation.

        Two headers are included for each top-level (non-nested) class
        in the API description: one is the implementation header in `ilgen/`,
        the other is the header produced by this generator. In addition,
        a `Macros.hpp` is included as it contains some utilities used
        in the generated code.
        """
        files = [os.path.join("ilgen", c.name() + ";") for c in classes_desc]
        return files

    def generate_import(self, path):
        """Returns an import directive for a given path."""
        return 'import {};\n'.format(path)

    def get_class_name(self, c):
        """
        Returns the name of a given class in the client API implementation.

        If the class is a nested class, then the name is prefixed with name
        of all containing classes, separated by the scope resolution operator.
        """
        return c.name()

    def get_client_class_name(self, c):
        """
        Returns the name of a given class in the client API implementation,
        prefixed with the name of all contianing classes.
        """
        return self.get_class_name(c)

    def get_client_type(self, t, namespace=""):
        """
        Returns the Java type to be used in the client API implementation
        for a given type name, prefixing with a given namespace if needed.
        """
        # todo: consider remove
        return "{ns}{t} ".format(ns=namespace,t=self.get_client_class_name(t.as_class())) if t.is_class() else self.java_client_type_map[t.name()]

    def get_impl_type(self, c):
        """
        Returns the C++ type to be used in the JitBuilder implementation
        for a given type name, prefixing with a given namespace if needed.
        """
        return "{} *".format(self.get_impl_class_name(c.as_class())) if c.is_class() else self.builtin_type_map[c.name()]

    def generate_static_cast(self, t, v):
        """Generate a static cast of the value `v` to type `t`."""
        return "({v})".format(t=t,v=v)

    def to_impl_cast(self, c, v):
        """
        Constructs a cast of the value `v` to the type of the
        implementation class `c`.
        """
        b = c.base()
        v = v
        return v

    def grab_impl(self, v, t):
        """
        Constructs an expression that grabs the implementation object
        from a client API object `v` and with type name `t`.
        """
        return self.to_impl_cast(t.as_class(), "({v} != null ? {v}._impl : 0L)".format(v=v)) if t.is_class() else v

    def generate_parm(self, parm_desc, namespace="", is_client=True, simplified=False):
        """
        Produces a parameter declaration from a given parameter description.
        The parameter declaration is usable in a function declaration.
        """
        fmt = "{t}{b} {n}"
        t = parm_desc.type()
        t = self.get_client_type(t, namespace)
        t = t.strip() # todo(Allan): investigate better ways
        if simplified and t not in self.simple_java_types:
            t = "long"
        b = "[]" if parm_desc.can_be_vararg() else ""
        return fmt.format(t=t,n=parm_desc.name(),b=b)

    def generate_parm_list(self, parms_desc, namespace="", is_client=True, simplified=False):
        """
        Produces a stringified comma seperated list of parameter
        declarations from a list of parameter descriptions. The list
        is usable as the parameter listing of a function declaration.
        """
        return ", ".join([ self.generate_parm(p, namespace=namespace, is_client=is_client, simplified=simplified) for p in parms_desc ])

    def generate_vararg_parm_list(self, parms_desc):
        """
        Produces a stringified comma separated list of parameter
        declarations for a vararg function.
        """
        return ", ".join([self.generate_parm(p) for p in parms_desc])

    def generate_arg(self, parm_desc):
        """
        Produces an argument variable from a parameter description.
        The produced value is usable as the "variable" for accessing
        the specified parameter.
        """
        n = parm_desc.name()
        t = parm_desc.type()
        return "transformArray({n})".format(n=n) if parm_desc.is_array() else self.grab_impl(n,t)

    def generate_arg_list(self, parms_desc):
        """
        Produces a stringified comma separated list of argument
        variables, given a list of parameter descriptions. The
        produced list can be used to forward the arguments from
        a caller to a callee function.
        """
        return ", ".join([ self.generate_arg(a) for a in parms_desc ])

    def impl_getter_name(self, class_desc):
        """
        Produces the name of the callback that, given a client object,
        returns the corresponding JitBuilder implementation of the object.
        """
        return "getImpl_{}".format(class_desc.name())

    # source utilities ###################################################

    def write_ctor_impl(self, writer, ctor_desc):
        """
        Write the definition of a client API class constructor from
        its description and its class description.

        Client API constructors first construct an instance of the
        corresponding JitBuilder class by invoking the corresponding
        construct and saving a pointer to the object in a private
        field. Constructors then set themselves (the current
        object) as client object of the implementation object and
        call the common initialization function. An abstract example:

        ```
        Constructor(...) {
            arg_set
            _impl = Constructor;
            arg_return
            impl->setClient(this);
            initializeFromImpl(impl);
        }
        ```
        """
        name = ctor_desc.name()
        class_desc = ctor_desc.owning_class()
        parms = self.generate_parm_list(ctor_desc.parameters())
        full_name = self.get_class_name(class_desc)
        
        writer.write("public {name}({parms}) {{\n".format(cname=full_name, name=name, parms=parms))
        writer.indent()

        # if class has parent, invoke super constructor
        args = self.generate_arg_list(ctor_desc.parameters())
        if class_desc.has_parent():
            if parms != "":
                writer.write("super(new{name}({args});\n".format(name=name, args=args))
            else:
                writer.write("super(impl);\n")
                writer.write("_impl = new{name}({args});\n".format(name=name, args=args))

        writer.write("impl_initializeFromImpl(_impl);\n")

        for parm in ctor_desc.parameters():
            self.write_arg_return(writer, parm)

        containing_classes = class_desc.containing_classes()
        containing_class = containing_classes[0] if len(containing_classes) > 0 else ""
        outer_class_prefix = "" if containing_class == "" else "{cc}.".format(cc=containing_class)

        extended_func_name = ""
        if len(containing_classes) > 0:
            extended_func_name = "{name}_".format(name=name)
            for c in containing_classes:
                extended_func_name = "{c_name}_{previous}".format(c_name=c, previous=extended_func_name)
            extended_func_name = "_" + extended_func_name

        writer.write("{ocp}set{efn}ClientObj(this, _impl);\n".format(ocp=outer_class_prefix, efn=extended_func_name, name=name))
        # writer.write("initializeFromImpl({});\n".format(self.to_opaque_cast("impl",class_desc)))
        writer.outdent()
        writer.write("}\n")

    def write_arg_return(self, writer, parm):
        """
        Writes the argument reconstruction for in-out parameters
        and array parameters.

        Since calling the implementation function can alter the
        arguments passed, the client arguments must be reconstructed
        from the implementation objects. After the implementation
        function is called, the implementation arguments must be
        transformed back into client objects, which must then be
        assigned to the client arguments. Effectively, the
        generated code undoes what the code generated by
        `write_arg_setup()` does.
        """
        if parm.is_in_out():
            # todo: modify this part
            assert parm.type().is_class()
            t = self.get_class_name(parm.type().as_class())
        elif parm.is_array():
            assert parm.type().is_class()
            t = self.get_class_name(parm.type().as_class())

    def write_class_service_impl(self, writer, desc, class_desc, signatures):
        """
        Writes the implementation of a client API class service.

        Services simply forward their arguments to the corresponding
        functions on the implementation object and forward returned
        values. Special setup for the arguments that require it is
        done before the implementation function  is called and the
        corresponding reconstruction is done after.
        """
        rtype = self.get_client_type(desc.return_type())
        name = desc.name()
        parms = self.generate_parm_list(desc.parameters())
        class_name = self.get_class_name(class_desc)

        # make sure that we don't have a parameter that is a pointer
        # todo(Allan): fix hardcode, check exclusion vs inclusion
        # if name not in ("AddWithOverflow", 
        # "AddWithUnsignedOverflow", "MulWithOverflow", 
        # "SubWithOverflow", "SubWithUnsignedOverflow", 
        # "Transaction", "DoWhileLoop", "DoWhileLoopWithBreak",
        # "DoWhileLoopWithContinue", "IfAnd", "IfOr", "IfThen",
        # "IfThenElse", "ForLoop", "ForLoopDown", "ForLoopUp",
        # "ForLoopWithBreak", "ForLoopWithContinue", "Switch","TableSwitch",
        # "MakeCase", "WhileDoLoop", "WhileDoLoopWithBreak", "WhileDoLoopWithContinue"):
        #     for parm in desc.parameters():
        #         if parm.is_in_out():
        #             return

        ret_type = desc.return_type().name()
        if ret_type == "none":
            ret_type = "void"
        elif ret_type not in ("IlBuilder", "BytecodeBuilder", "TypeDictionary", "JBCondition", "JBCase"):
            ret_type = "IlValue"
        current_signature = "{name}({parms})".format(name=name, parms=parms)
        if (current_signature in signatures):
            return
        
        signatures.append(current_signature)
        
        writer.write("public {return_type} {name}({parms}) {{\n".format(return_type=ret_type, name=name, parms=parms))
        
        writer.indent()

        if desc.is_impl_default():
            writer.write("return 0;\n")
        else:
            # for parm in desc.parameters():
            #     self.write_arg_setup(writer, parm)

            args = self.generate_arg_list(desc.parameters())
            #todo(Allan): improve
            in_out = ""
            if "transformArray(" in args:
                if "MethodBuilder" in parms:
                    in_out = "MethodBuilder"
                else:
                    in_out = "WithArgArray"
            bc_ext = ""
            if "ForLoop" != name and "breakBuilder" in args and "WithBreak" not in name:
                bc_ext += "WithBreak"
            if "ForLoop" != name and "continueBuilder" in args and "WithContinue" not in name:
                bc_ext += "AndContinue"
            
            impl_call = "impl_{sname}{in_out}{bc_ext}({args})".format("_impl",sname=name,args=args,in_out=in_out,bc_ext=bc_ext)
            if "none" == desc.return_type().name():
                writer.write(impl_call + ";\n")
            elif desc.return_type().is_class():
                writer.write("long implRet = {call};\n".format(call=impl_call))
                writer.write("{ret} clientRet=null;\n".format(ret=ret_type))
                for parm in desc.parameters():
                    self.write_arg_return(writer, parm)
                writer.write("if (implRet != 0L) {\n")
                writer.indent()

                if ret_type == "JBCondition":
                    src_get_client = "IlBuilder"
                    cond_ext = "_IlBuilder_JBCondition_"
                elif ret_type == "JBCase":
                    src_get_client = "IlBuilder"
                    cond_ext = "_IlBuilder_JBCase_"
                else:
                    src_get_client = ret_type
                    cond_ext = ""
                writer.write("clientRet = {src_get_client}.get{cond_ext}ClientObj(implRet);\n".format(src_get_client=src_get_client, cond_ext=cond_ext))

                writer.write("if (clientRet == null) {\n")
                writer.indent()
                writer.write("clientRet = new {ret}(implRet);\n".format(ret=ret_type))
                writer.outdent()
                writer.write("}\n")
                writer.outdent()
                writer.write("}\n")
                writer.write("return clientRet;\n")
            else:
                writer.write("long ret = " + impl_call + ";\n")
                for parm in desc.parameters():
                    self.write_arg_return(writer, parm)
                writer.write("return ret;\n")

        writer.outdent()
        writer.write("}\n\n")
    
    def get_parent_class_name(self, class_desc):
        if class_desc.has_parent():
            return class_desc.parent().name()
        else:
            return None

    def format_extension(self, class_desc):
        ext = self.get_parent_class_name(class_desc)
        if ext is not None:
            return "extends {ext}".format(ext=ext)
        else:
            return ""

    def write_class_impl(self, writer, class_desc):
        """Write the implementation of a client API class."""

        name = class_desc.name()
        full_name = self.get_class_name(class_desc)
        extension = self.format_extension(class_desc)

        writer.write("\npublic class {class_name} {extension}\n{{\n".format(class_name=name, extension=extension))
        writer.indent()

        # write source for inner classes first (Allan)
        for c in class_desc.inner_classes():
            self.write_class_impl(writer, c)
            writer.write("\n")
        
        # write default constructor
        writer.write("\n{class_name}(long impl) {{\n".format(class_name=name))
        writer.indent()
        if class_desc.has_parent():
            writer.write("super(impl);\n")
        writer.write("impl_initializeFromImpl(impl);\n")
        writer.outdent()
        writer.write("}\n\n")

        # write other constructor definitions
        for ctor in class_desc.constructors():
            self.write_ctor_impl(writer, ctor)
        writer.write("\n")

        # # write service definitions
        signatures = [] # check if we already had the signature
        for s in class_desc.services():
            # todo(Allan): improve
            if s.name() in ("Const", "Select"):
                continue
            
            self.write_class_service_impl(writer, s, class_desc, signatures)

        # Java part (Allan)

        # for the parent class
        if len(class_desc.containing_classes()) == 0:
            # todo(Allan): hard code improve
            writer.write("""private static long[] transformArray(IlValue[] clientArray) {
    long implArray[] = new long[clientArray.length];
    for (int i=0;i < clientArray.length; i++) {
        IlValue o = clientArray[i];
        implArray[i] = (o != null) ? (o._impl) : 0L;
    }
    return implArray;
}
private static long[] transformArray(JBCondition[] clientArray) {
    long implArray[] = new long[clientArray.length];
    for (int i=0;i < clientArray.length; i++) {
        JBCondition o = clientArray[i];
        implArray[i] = (o != null) ? (o._impl) : 0L;
    }
    return implArray;
}
private static long[] transformArray(JBCase[] clientArray) {
    long implArray[] = new long[clientArray.length];
    for (int i=0;i < clientArray.length; i++) {
        JBCase o = clientArray[i];
        implArray[i] = (o != null) ? (o._impl) : 0L;
    }
    return implArray;
}
private native void impl_initializeFromImpl(long impl);\n""")

            # todo(Allan): improve by handling deeper inner classes
            for inner_class in class_desc.inner_classes():
                inner_name = inner_class.name()
                args = self.generate_parm_list(inner_class.constructors()[0].parameters())
                args = args.replace("IlBuilder", "long")
                args = args.replace("IlValue", "long")
                writer.write("private static native long new{name}({args});\n".format(name=inner_name, args=args))
            
            writer.write("native static {name} getClientObj(long implObj);\n".format(name=name))
            writer.write("native static void setClientObj(IlBuilder clientObj, long implObj);\n")

            # Handle constructor-related native functions
            # Naive way: find the most number of parameters
            # Then create one for each count???
            max_param_count = 0
            for ctor in class_desc.constructors():
                max_param_count = max(max_param_count, len(ctor.parameters()))
            
            for i in range(max_param_count):
                ctor_parms_list = []
                for j in range(i+1):
                    ctor_parms_list.append("long impl{j}".format(j=(j+1)))
                ctor_parms = ", ".join(ctor_parms_list)
                writer.write("native static long new{name}({ctor_parms});\n".format(name=name, ctor_parms=ctor_parms))

            # todo(Allan): improve by handling deeper inner classes
            replacements = (("IlValue", "long"),("IlType","long"), ("IlBuilder", "long"))
            for inner_class in class_desc.inner_classes():
                inner_name = inner_class.name()
                args = self.generate_parm_list(inner_class.constructors()[0].parameters())
                writer.write("native static {inner} get_{parent}_{inner}_ClientObj(long implObj);\n".format(inner=inner_name, parent=name, args=args))
                writer.write("native static void set_{parent}_{inner}_ClientObj({inner} clientObj, long implObj);\n".format(inner=inner_name, parent=name, args=args))
            
            for s in class_desc.services():
                param_is_in_out = False
                parms = self.generate_parm_list(s.parameters(), simplified=False)

                # remove duplicates
                current_signature = "{name}({parms})".format(name=s.name(), parms=parms)
                if current_signature in signatures:
                    signatures.remove(current_signature)
                else:
                    continue

                # remove impl_Const
                if "impl_Const" in current_signature:
                    continue

                # replace the parameters with simple types
                for r in replacements:
                    parms = parms.replace(r[0], r[1])

                ret_type = s.return_type().name()
                if (ret_type != "none"):
                    ret_type = "long"
                else:
                    ret_type = "void"
                writer.write("private native {ret_type} impl_{name}({parms});\n".format(name=s.name(), parms=parms, ret_type=ret_type))

            for n in self.jni_type_names:
                writer.write("protected IlType {n};\n".format(n=n))

        writer.write("long _impl;\n")
        writer.outdent()
        writer.write("}")

    # common utilities ##############################################

    def write_allocators_setter(self, writer, api_desc):
        """
        Writes the implementation of a function that sets the
        allocator functions for all client API classes.

        The generated function will be called by any service
        that has the `sets-allocators` flag.
        """
        writer.write("static void {}() {{\n".format(self.allocator_setter_name))
        writer.indent()
        for c in api_desc.classes():
            writer.write("".join(self.generate_allocator_setting(c)))
        writer.outdent()
        writer.write("}\n")

    def write_class_source(self, writer, class_desc, namespaces, class_names):
        """
        Writes the implementation (source) for a client API class
        from the class description.
        """
        writer.write(self.get_copyright_header())
        writer.write("\n")
        writer.write(""" /*
  * This file is automatically generated. Do not modify!!
  */
        \n""")

        writer.write("package org.eclipse.omr.jitbuilder;\n")
        packages = (
              "java.lang.invoke.MethodHandle"
            , "java.lang.invoke.MethodHandles"
            , "java.lang.invoke.MethodType"
            , "java.lang.reflect.Field"
            , "java.lang.reflect.Method"
            , "java.util.*"
            , "sun.misc.Unsafe"
            , "jdk.internal.org.objectweb.asm.*"
            , "static jdk.internal.org.objectweb.asm.Opcodes.*"
        )
        for p in packages:
            writer.write(self.generate_import(p))

        self.write_class_impl(writer, class_desc)

    def write_class(self, header_dir, source_dir, class_desc, namespaces, class_names):
        """Generates and writes a client API class from its description."""

        cname = class_desc.name()
        source_path = os.path.join(source_dir, cname + ".java")
        with open(source_path, "w") as writer:
            self.write_class_source(PrettyPrinter(writer), class_desc, namespaces, class_names)

# main generator #####################################################

if __name__ == "__main__":
    default_dest = os.path.join(os.getcwd(), "client")
    parser = argparse.ArgumentParser()
    parser.add_argument("--sourcedir", type=str, default=default_dest,
                        help="destination directory for the generated source files")
    parser.add_argument("--headerdir", type=str, default=default_dest,
                        help="destination directory for the generated header files")
    parser.add_argument("description", help="path to the API description file")
    args = parser.parse_args()

    with open(args.description) as api_src:
        api_description = APIDescription.load_json_file(api_src)

    generator = JavaGenerator(api_description, args.headerdir, ["TypeDictionary"])

    namespaces = api_description.namespaces()
    class_names = api_description.get_class_names()

    for class_desc in api_description.classes():
        generator.write_class(args.headerdir, args.sourcedir, class_desc, namespaces, class_names)

    extras_dir = os.path.join(os.path.dirname(os.path.abspath(__file__)), "extras", "cpp")
    names = os.listdir(extras_dir)