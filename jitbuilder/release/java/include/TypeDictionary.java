package java.include;

// import org.eclipse.omr.jitbuilder.IlBuilder;

public class TypeDictionary 
{

    TypeDictionary(long impl) {
        impl_initializeFromImpl(impl);
    }

    public TypeDictionary() {
        impl_initializeFromImpl(_impl);
        setClientObj(this, _impl);
    }

    public void CloseStruct(String structName) {
        impl_CloseStruct(structName);
    }

    public void CloseStruct(String structName, long size) {
        impl_CloseStruct(structName, size);
    }

    public void CloseUnion(String unionName) {
        impl_CloseUnion(unionName);
    }

    public void DefineField(String structName, String fieldName, IlType type) {
        impl_DefineField(structName, fieldName, (type != null ? type._impl : 0L));
    }

    public void DefineField(String structName, String fieldName, IlType type, long offset) {
        impl_DefineField(structName, fieldName, (type != null ? type._impl : 0L), offset);
    }

    public IlValue DefineStruct(String structName) {
        long implRet = impl_DefineStruct(structName);
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public IlValue DefineUnion(String unionName) {
        long implRet = impl_DefineUnion(unionName);
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public IlValue GetFieldType(String structName, String fieldName) {
        long implRet = impl_GetFieldType(structName, fieldName);
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public IlValue LookupStruct(String structName) {
        long implRet = impl_LookupStruct(structName);
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public IlValue LookupUnion(String unionName) {
        long implRet = impl_LookupUnion(unionName);
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public IlValue OffsetOf(String structName, String fieldName) {
        long ret = impl_OffsetOf(structName, fieldName);
        return ret;
    }

    public IlValue PointerTo(IlType baseType) {
        long implRet = impl_PointerTo((baseType != null ? baseType._impl : 0L));
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public IlValue PointerTo(String structName) {
        long implRet = impl_PointerTo(structName);
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public void UnionField(String unionName, String fieldName, IlType fieldType) {
        impl_UnionField(unionName, fieldName, (fieldType != null ? fieldType._impl : 0L));
    }

    public IlValue UnionFieldType(String unionName, String fieldName) {
        long implRet = impl_UnionFieldType(unionName, fieldName);
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    private static long[] transformArray(IlValue[] clientArray) {
        long implArray[] = new long[clientArray.length];
        for (int i=0;i < clientArray.length; i++) {
            IlValue o = clientArray[i];
            implArray[i] = (o != null) ? (o._impl) : 0L;
        }
        return implArray;
    }
    
    private native void impl_initializeFromImpl(long impl);
    native static TypeDictionary getClientObj(long implObj);
    native static void setClientObj(TypeDictionary typeDictionary, long implObj);
    private native void impl_CloseStruct(String structName);
    private native void impl_CloseStruct(String structName, long size);
    private native void impl_CloseUnion(String unionName);
    private native void impl_DefineField(String structName, String fieldName, long type);
    private native void impl_DefineField(String structName, String fieldName, long type, long offset);
    private native long impl_DefineStruct(String structName);
    private native long impl_DefineUnion(String unionName);
    private native long impl_GetFieldType(String structName, String fieldName);
    private native long impl_LookupStruct(String structName);
    private native long impl_LookupUnion(String unionName);
    private native long impl_OffsetOf(String structName, String fieldName);
    private native long impl_PointerTo(long baseType);
    private native long impl_PointerTo(String structName);
    private native void impl_UnionField(String unionName, String fieldName, long fieldType);
    private native long impl_UnionFieldType(String unionName, String fieldName);
    protected IlType NoType;
    protected IlType Int8;
    protected IlType Int16;
    protected IlType Int32;
    protected IlType Int64;
    protected IlType Float;
    protected IlType Double;
    protected IlType Address;
    protected IlType VectorInt8;
    protected IlType VectorInt16;
    protected IlType VectorInt32;
    protected IlType VectorInt64;
    protected IlType VectorFloat;
    protected IlType VectorDouble;
    protected IlType Word;
    long _impl;
}