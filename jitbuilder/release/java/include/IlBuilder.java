/*******************************************************************************
 * Copyright (c) 2020, 2020 IBM Corp. and others
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
        
package org.eclipse.omr.jitbuilder;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodTypes;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import sun.misc.Unsafe;
import jdk.internal.org.objectweb.asm.*;
import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class IlBuilder
{
    public class JBCase
    {
        JBCase(long impl) {
            impl_initializeFromImpl(impl);
        }

        public JBCase(int caseValue, IlBuilder caseBuilder, int caseFallsThrough) {
            _impl = newJBCase(caseValue, caseBuilder != null ? caseBuilder._impl : 0L, caseFallsThrough);
            impl_initializeFromImpl(_impl);
            IlBuilder.set_IlBuilder_JBCase_ClientObj(this, _impl);
        }

        private native void impl_initializeFromImpl(long impl);
        long _impl;
    }

    public class JBCondition
    {
        JBCondition(long impl) {
            impl_initializeFromImpl(impl);
        }

        public JBCondition(IlBuilder conditionBuilder, IlValue conditionValue) {
            _impl = newJBCondition(conditionBuilder != NULL ? conditionBuilder._impl : 0L, conditionValue != NULL ? conditionValue._impl : 0L);
            impl_initializeFromImpl(_impl);
            IlBuilder.set_IlBuilder_JBCondition_ClientObj(this, _impl);
        }

        private native void impl_initializeFromImpl(long impl);
        long _impl;
    }

    IlBuilder(long impl) {
        impl_initializeFromImpl(impl);
    }


    public ILValue OrphanBuilder() {
        long implRet = impl_OrphanBuilder();
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = OrphanBuilder.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue OrphanBytecodeBuilder(int bcIndex, String name) {
        long implRet = impl_OrphanBytecodeBuilder(bcIndex, name);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = OrphanBytecodeBuilder.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Copy(IlValue value) {
        long implRet = impl_Copy(value != NULL ? value._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Copy.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public TypeDictionary typeDictionary() {
        long implRet = impl_typeDictionary();
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = typeDictionary.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConstInteger(IlType type, long value) {
        long implRet = impl_ConstInteger(type != NULL ? type._impl : 0L, value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConstInteger.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConstAddress(long value) {
        long implRet = impl_ConstAddress(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConstAddress.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConstDouble(double value) {
        long implRet = impl_ConstDouble(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConstDouble.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConstFloat(float value) {
        long implRet = impl_ConstFloat(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConstFloat.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConstInt8(byte value) {
        long implRet = impl_ConstInt8(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConstInt8.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConstInt16(short value) {
        long implRet = impl_ConstInt16(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConstInt16.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConstInt32(int value) {
        long implRet = impl_ConstInt32(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConstInt32.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConstInt64(long value) {
        long implRet = impl_ConstInt64(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConstInt64.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConstString(String value) {
        long implRet = impl_ConstString(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConstString.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Const(long value) {
        long implRet = impl_Const(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Const.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Const(double value) {
        long implRet = impl_Const(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Const.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Const(float value) {
        long implRet = impl_Const(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Const.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Const(byte value) {
        long implRet = impl_Const(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Const.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Const(short value) {
        long implRet = impl_Const(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Const.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Const(int value) {
        long implRet = impl_Const(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Const.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Const(long value) {
        long implRet = impl_Const(value);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Const.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue NullAddress() {
        long implRet = impl_NullAddress();
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = NullAddress.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Add(IlValue left, IlValue right) {
        long implRet = impl_Add(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Add.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }



    public ILValue And(IlValue left, IlValue right) {
        long implRet = impl_And(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = And.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Div(IlValue left, IlValue right) {
        long implRet = impl_Div(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Div.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue UnsignedDiv(IlValue left, IlValue right) {
        long implRet = impl_UnsignedDiv(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = UnsignedDiv.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue IndexAt(IlType dt, IlValue base, IlValue index) {
        long implRet = impl_IndexAt(dt != NULL ? dt._impl : 0L, base != NULL ? base._impl : 0L, index != NULL ? index._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = IndexAt.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Mul(IlValue left, IlValue right) {
        long implRet = impl_Mul(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Mul.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }


    public ILValue Negate(IlValue v) {
        long implRet = impl_Negate(v != NULL ? v._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Negate.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Or(IlValue left, IlValue right) {
        long implRet = impl_Or(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Or.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Rem(IlValue left, IlValue right) {
        long implRet = impl_Rem(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Rem.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue UnsignedRem(IlValue left, IlValue right) {
        long implRet = impl_UnsignedRem(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = UnsignedRem.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ShiftL(IlValue left, IlValue right) {
        long implRet = impl_ShiftL(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ShiftL.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ShiftR(IlValue left, IlValue right) {
        long implRet = impl_ShiftR(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ShiftR.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Sub(IlValue left, IlValue right) {
        long implRet = impl_Sub(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Sub.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }



    public ILValue UnsignedShiftR(IlValue left, IlValue right) {
        long implRet = impl_UnsignedShiftR(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = UnsignedShiftR.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Xor(IlValue left, IlValue right) {
        long implRet = impl_Xor(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Xor.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue EqualTo(IlValue left, IlValue right) {
        long implRet = impl_EqualTo(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = EqualTo.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue LessOrEqualTo(IlValue left, IlValue right) {
        long implRet = impl_LessOrEqualTo(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = LessOrEqualTo.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue LessThan(IlValue left, IlValue right) {
        long implRet = impl_LessThan(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = LessThan.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue GreaterOrEqualTo(IlValue left, IlValue right) {
        long implRet = impl_GreaterOrEqualTo(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = GreaterOrEqualTo.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue GreaterThan(IlValue left, IlValue right) {
        long implRet = impl_GreaterThan(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = GreaterThan.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue NotEqualTo(IlValue left, IlValue right) {
        long implRet = impl_NotEqualTo(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = NotEqualTo.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue UnsignedLessOrEqualTo(IlValue left, IlValue right) {
        long implRet = impl_UnsignedLessOrEqualTo(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = UnsignedLessOrEqualTo.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue UnsignedLessThan(IlValue left, IlValue right) {
        long implRet = impl_UnsignedLessThan(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = UnsignedLessThan.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue UnsignedGreaterOrEqualTo(IlValue left, IlValue right) {
        long implRet = impl_UnsignedGreaterOrEqualTo(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = UnsignedGreaterOrEqualTo.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue UnsignedGreaterThan(IlValue left, IlValue right) {
        long implRet = impl_UnsignedGreaterThan(left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = UnsignedGreaterThan.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConvertBitsTo(IlType type, IlValue value) {
        long implRet = impl_ConvertBitsTo(type != NULL ? type._impl : 0L, value != NULL ? value._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConvertBitsTo.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ConvertTo(IlType type, IlValue value) {
        long implRet = impl_ConvertTo(type != NULL ? type._impl : 0L, value != NULL ? value._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ConvertTo.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue UnsignedConvertTo(IlType type, IlValue value) {
        long implRet = impl_UnsignedConvertTo(type != NULL ? type._impl : 0L, value != NULL ? value._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = UnsignedConvertTo.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue AtomicAdd(IlValue baseAddress, IlValue value) {
        long implRet = impl_AtomicAdd(baseAddress != NULL ? baseAddress._impl : 0L, value != NULL ? value._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = AtomicAdd.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue CreateLocalArray(int numElements, IlType elementType) {
        long implRet = impl_CreateLocalArray(numElements, elementType != NULL ? elementType._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = CreateLocalArray.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue CreateLocalStruct(IlType structType) {
        long implRet = impl_CreateLocalStruct(structType != NULL ? structType._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = CreateLocalStruct.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Load(String name) {
        long implRet = impl_Load(name);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Load.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue LoadAt(IlType type, IlValue address) {
        long implRet = impl_LoadAt(type != NULL ? type._impl : 0L, address != NULL ? address._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = LoadAt.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue LoadIndirect(String type, String field, IlValue object) {
        long implRet = impl_LoadIndirect(type, field, object != NULL ? object._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = LoadIndirect.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public void Store(String name, IlValue value) {
        impl_Store(name, value != NULL ? value._impl : 0L);
    }

    public void StoreAt(IlValue address, IlValue value) {
        impl_StoreAt(address != NULL ? address._impl : 0L, value != NULL ? value._impl : 0L);
    }

    public void StoreIndirect(String type, String field, IlValue object, IlValue value) {
        impl_StoreIndirect(type, field, object != NULL ? object._impl : 0L, value != NULL ? value._impl : 0L);
    }

    public void StoreOver(IlValue dest, IlValue value) {
        impl_StoreOver(dest != NULL ? dest._impl : 0L, value != NULL ? value._impl : 0L);
    }


    public void TransactionAbort() {
        impl_TransactionAbort();
    }

    public ILValue StructFieldInstanceAddress(String structName, String fieldName, IlValue obj) {
        long implRet = impl_StructFieldInstanceAddress(structName, fieldName, obj != NULL ? obj._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = StructFieldInstanceAddress.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue UnionFieldInstanceAddress(String unionName, String fieldName, IlValue obj) {
        long implRet = impl_UnionFieldInstanceAddress(unionName, fieldName, obj != NULL ? obj._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = UnionFieldInstanceAddress.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue VectorLoad(String name) {
        long implRet = impl_VectorLoad(name);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = VectorLoad.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue VectorLoadAt(IlType type, IlValue address) {
        long implRet = impl_VectorLoadAt(type != NULL ? type._impl : 0L, address != NULL ? address._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = VectorLoadAt.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public void VectorStore(String name, IlValue value) {
        impl_VectorStore(name, value != NULL ? value._impl : 0L);
    }

    public void VectorStoreAt(IlValue address, IlValue value) {
        impl_VectorStoreAt(address != NULL ? address._impl : 0L, value != NULL ? value._impl : 0L);
    }

    public void AppendBuilder(IlBuilder b) {
        impl_AppendBuilder(b != NULL ? b._impl : 0L);
    }

    public ILValue Call(String name, int numArgs, IlValue[] arguments) {
        long implRet = impl_Call(name, numArgs, argumentsArg);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Call.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue Call(MethodBuilder name, int numArgs, IlValue[] arguments) {
        long implRet = impl_Call(name != NULL ? name._impl : 0L, numArgs, argumentsArg);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Call.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }

    public ILValue ComputedCall(String name, int numArgs, IlValue[] arguments) {
        long implRet = impl_ComputedCall(name, numArgs, argumentsArg);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = ComputedCall.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }





    public void Goto(IlBuilder b) {
        impl_Goto(b != NULL ? b._impl : 0L);
    }


    public ILValue MakeCondition(IlBuilder conditionBuilder, IlValue conditionValue) {
        long implRet = impl_MakeCondition(conditionBuilder != NULL ? conditionBuilder._impl : 0L, conditionValue != NULL ? conditionValue._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = MakeCondition.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }


    public void IfCmpEqual(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpEqual(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpLessOrEqual(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpLessOrEqual(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpLessThan(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpLessThan(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpGreaterOrEqual(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpGreaterOrEqual(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpGreaterThan(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpGreaterThan(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpNotEqual(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpNotEqual(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpUnsignedLessOrEqual(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpUnsignedLessOrEqual(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpUnsignedLessThan(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpUnsignedLessThan(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpUnsignedGreaterOrEqual(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpUnsignedGreaterOrEqual(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpUnsignedGreaterThan(IlBuilder target, IlValue left, IlValue right) {
        impl_IfCmpUnsignedGreaterThan(target != NULL ? target._impl : 0L, left != NULL ? left._impl : 0L, right != NULL ? right._impl : 0L);
    }


    public void IfCmpEqualZero(IlBuilder target, IlValue condition) {
        impl_IfCmpEqualZero(target != NULL ? target._impl : 0L, condition != NULL ? condition._impl : 0L);
    }


    public void IfCmpNotEqualZero(IlBuilder target, IlValue condition) {
        impl_IfCmpNotEqualZero(target != NULL ? target._impl : 0L, condition != NULL ? condition._impl : 0L);
    }





    public ILValue Select(IlValue condition, IlValue trueValue, IlValue falseValue) {
        long implRet = impl_Select(condition != NULL ? condition._impl : 0L, trueValue != NULL ? trueValue._impl : 0L, falseValue != NULL ? falseValue._impl : 0L);
        IlBuilder clientRet = null;
        if (implRet != 0L) {
            clientRet = Select.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlBuilder(implRet);
            }
        }
        return clientRet;
    }






    public void Return() {
        impl_Return();
    }

    public void Return(IlValue value) {
        impl_Return(value != NULL ? value._impl : 0L);
    }







    private native void impl_initializeFromImpl(long impl);

    private static long[] transformArray(IlValue[] clientArray) {
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
    private static native long newJBCase(int caseValue, IlBuilder caseBuilder, int caseFallsThrough);
    private static native long newJBCondition(IlBuilder conditionBuilder, IlValue conditionValue);
    native static IlBuilder getClientObj(long implObj);
    native static void setClientObj(ILBuilder clientObj, long implObj);
    native static JBCase get_IlBuilder_JBCase_name(long implObj);
    native static void set_IlBuilder_JBCase_name(JBCase clientObj, long implObj);
    native static JBCondition get_IlBuilder_JBCondition_name(long implObj);
    native static void set_IlBuilder_JBCondition_name(JBCondition clientObj, long implObj);
    private native long impl_OrphanBuilder();
    private native long impl_OrphanBytecodeBuilder(int bcIndex, String name);
    private native long impl_Copy(IlValue value);
    private native long impl_typeDictionary();
    private native long impl_ConstInteger(IlType type, long value);
    private native long impl_ConstAddress(long value);
    private native long impl_ConstDouble(double value);
    private native long impl_ConstFloat(float value);
    private native long impl_ConstInt8(byte value);
    private native long impl_ConstInt16(short value);
    private native long impl_ConstInt32(int value);
    private native long impl_ConstInt64(long value);
    private native long impl_ConstString(String value);
    private native long impl_Const(long value);
    private native long impl_Const(double value);
    private native long impl_Const(float value);
    private native long impl_Const(byte value);
    private native long impl_Const(short value);
    private native long impl_Const(int value);
    private native long impl_Const(long value);
    private native long impl_NullAddress();
    private native long impl_Add(IlValue left, IlValue right);
    private native long impl_And(IlValue left, IlValue right);
    private native long impl_Div(IlValue left, IlValue right);
    private native long impl_UnsignedDiv(IlValue left, IlValue right);
    private native long impl_IndexAt(IlType dt, IlValue base, IlValue index);
    private native long impl_Mul(IlValue left, IlValue right);
    private native long impl_Negate(IlValue v);
    private native long impl_Or(IlValue left, IlValue right);
    private native long impl_Rem(IlValue left, IlValue right);
    private native long impl_UnsignedRem(IlValue left, IlValue right);
    private native long impl_ShiftL(IlValue left, IlValue right);
    private native long impl_ShiftR(IlValue left, IlValue right);
    private native long impl_Sub(IlValue left, IlValue right);
    private native long impl_UnsignedShiftR(IlValue left, IlValue right);
    private native long impl_Xor(IlValue left, IlValue right);
    private native long impl_EqualTo(IlValue left, IlValue right);
    private native long impl_LessOrEqualTo(IlValue left, IlValue right);
    private native long impl_LessThan(IlValue left, IlValue right);
    private native long impl_GreaterOrEqualTo(IlValue left, IlValue right);
    private native long impl_GreaterThan(IlValue left, IlValue right);
    private native long impl_NotEqualTo(IlValue left, IlValue right);
    private native long impl_UnsignedLessOrEqualTo(IlValue left, IlValue right);
    private native long impl_UnsignedLessThan(IlValue left, IlValue right);
    private native long impl_UnsignedGreaterOrEqualTo(IlValue left, IlValue right);
    private native long impl_UnsignedGreaterThan(IlValue left, IlValue right);
    private native long impl_ConvertBitsTo(IlType type, IlValue value);
    private native long impl_ConvertTo(IlType type, IlValue value);
    private native long impl_UnsignedConvertTo(IlType type, IlValue value);
    private native long impl_AtomicAdd(IlValue baseAddress, IlValue value);
    private native long impl_CreateLocalArray(int numElements, IlType elementType);
    private native long impl_CreateLocalStruct(IlType structType);
    private native long impl_Load(String name);
    private native long impl_LoadAt(IlType type, IlValue address);
    private native long impl_LoadIndirect(String type, String field, IlValue object);
    private native long impl_Store(String name, IlValue value);
    private native long impl_StoreAt(IlValue address, IlValue value);
    private native long impl_StoreIndirect(String type, String field, IlValue object, IlValue value);
    private native long impl_StoreOver(IlValue dest, IlValue value);
    private native long impl_TransactionAbort();
    private native long impl_StructFieldInstanceAddress(String structName, String fieldName, IlValue obj);
    private native long impl_UnionFieldInstanceAddress(String unionName, String fieldName, IlValue obj);
    private native long impl_VectorLoad(String name);
    private native long impl_VectorLoadAt(IlType type, IlValue address);
    private native long impl_VectorStore(String name, IlValue value);
    private native long impl_VectorStoreAt(IlValue address, IlValue value);
    private native long impl_AppendBuilder(IlBuilder b);
    private native long impl_Call(String name, int numArgs, IlValue[] arguments);
    private native long impl_Call(MethodBuilder name, int numArgs, IlValue[] arguments);
    private native long impl_ComputedCall(String name, int numArgs, IlValue[] arguments);
    private native long impl_Goto(IlBuilder b);
    private native long impl_MakeCondition(IlBuilder conditionBuilder, IlValue conditionValue);
    private native long impl_IfCmpEqual(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpLessOrEqual(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpLessThan(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpGreaterOrEqual(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpGreaterThan(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpNotEqual(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpUnsignedLessOrEqual(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpUnsignedLessThan(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpUnsignedGreaterOrEqual(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpUnsignedGreaterThan(IlBuilder target, IlValue left, IlValue right);
    private native long impl_IfCmpEqualZero(IlBuilder target, IlValue condition);
    private native long impl_IfCmpNotEqualZero(IlBuilder target, IlValue condition);
    private native long impl_Select(IlValue condition, IlValue trueValue, IlValue falseValue);
    private native long impl_Return();
    private native long impl_Return(IlValue value);
    long _impl;
}
