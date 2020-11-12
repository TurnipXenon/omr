package java.include;

public class IlType {
    IlType(long impl) {
        impl_initializeFromImpl(impl);
    }


    public IlValue baseType() {
        long implRet = impl_baseType();
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public String getName() {
        String ret = impl_getName();
        return ret;
    }

    public IlValue primitiveType(TypeDictionary d) {
        long implRet = impl_primitiveType((d != null ? d._impl : 0L));
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public long getSize() {
        long ret = impl_getSize();
        return ret;
    }

    public boolean isPointer() {
        boolean ret = impl_isPointer();
        return ret;
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
    native static IlType getClientObj(long implObj);
    native static void setClientObj(IlBuilder clientObj, long implObj);
    private native long impl_baseType();
    private native String impl_getName();
    private native long impl_primitiveType(long l);
    private native long impl_getSize();
    private native boolean impl_isPointer();
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
