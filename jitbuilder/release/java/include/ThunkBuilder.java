package java.include;

public class ThunkBuilder extends MethodBuilder
{

    ThunkBuilder(long impl) {
        super(impl);
        impl_initializeFromImpl(impl);
    }

    public ThunkBuilder(TypeDictionary dict, String name, IlType returnType, int numCalleeParms, IlType calleeParms) {
        super(newThunkBuilder((dict != null ? dict._impl : 0L), name, (returnType != null ? returnType._impl : 0L), numCalleeParms, transformArray(calleeParms));
        impl_initializeFromImpl(_impl);
        setClientObj(this, _impl);
    }

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
    private native void impl_initializeFromImpl(long impl);
    native static ThunkBuilder getClientObj(long implObj);
    native static void setClientObj(IlBuilder clientObj, long implObj);
    native static long newThunkBuilder(long impl1);
    native static long newThunkBuilder(long impl1, long impl2);
    native static long newThunkBuilder(long impl1, long impl2, long impl3);
    native static long newThunkBuilder(long impl1, long impl2, long impl3, long impl4);
    native static long newThunkBuilder(long impl1, long impl2, long impl3, long impl4, long impl5);
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