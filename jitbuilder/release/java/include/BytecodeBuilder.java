package java.include;

public class BytecodeBuilder extends IlBuilder {
    BytecodeBuilder(long impl) {
        super(impl);
        impl_initializeFromImpl(impl);
    }

    public long bcIndex() {
        long ret = impl_bcIndex();
        return ret;
    }

    public String name() {
        String ret = impl_name();
        return ret;
    }

    // todo: check if IlValue return or vmState
    public IlValue vmState() {
        long implRet = impl_vmState();
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public void AddFallThroughBuilder(BytecodeBuilder ftb) {
        impl_AddFallThroughBuilder((ftb != null ? ftb._impl : 0L));
    }

    public void AddSuccessorBuilders(int numBuilders, BytecodeBuilder[] builders) {
        impl_AddSuccessorBuildersWithArgArray(numBuilders, transformArray(builders));
    }

    public void AddSuccessorBuilder(BytecodeBuilder b) {
        impl_AddSuccessorBuilder((b != null ? b._impl : 0L));
    }

    public void Goto(BytecodeBuilder b) {
        impl_Goto((b != null ? b._impl : 0L));
    }

    public void IfCmpEqual(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpEqual((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpLessOrEqual(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpLessOrEqual((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpLessThan(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpLessThan((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpGreaterOrEqual(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpGreaterOrEqual((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpGreaterThan(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpGreaterThan((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpNotEqual(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpNotEqual((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpUnsignedLessOrEqual(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpUnsignedLessOrEqual((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpUnsignedLessThan(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpUnsignedLessThan((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpUnsignedGreaterOrEqual(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpUnsignedGreaterOrEqual((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpUnsignedGreaterThan(BytecodeBuilder target, IlValue left, IlValue right) {
        impl_IfCmpUnsignedGreaterThan((target != null ? target._impl : 0L), (left != null ? left._impl : 0L), (right != null ? right._impl : 0L));
    }

    public void IfCmpEqualZero(BytecodeBuilder target, IlValue condition) {
        impl_IfCmpEqualZero((target != null ? target._impl : 0L), (condition != null ? condition._impl : 0L));
    }

    public void IfCmpNotEqualZero(BytecodeBuilder target, IlValue condition) {
        impl_IfCmpNotEqualZero((target != null ? target._impl : 0L), (condition != null ? condition._impl : 0L));
    }

    private static long[] transformArray(IlValue[] clientArray) {
        long implArray[] = new long[clientArray.length];
        for (int i=0;i < clientArray.length; i++) {
            IlValue o = clientArray[i];
            implArray[i] = (o != null) ? (o._impl) : 0L;
        }
        return implArray;
    }
    private static long[] transformArray(BytecodeBuilder[] clientArray) {
        long implArray[] = new long[clientArray.length];
        for (int i=0;i < clientArray.length; i++) {
            BytecodeBuilder o = clientArray[i];
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
    native static BytecodeBuilder getClientObj(long implObj);
    native static void setClientObj(IlBuilder clientObj, long implObj);
    private native long impl_bcIndex();
    private native String impl_name();
    private native long impl_vmState();
    private native void impl_AddFallThroughBuilder(long l);
    private native void impl_AddSuccessorBuilders(int numBuilders, BytecodeBuilder[] builders);
    private native void impl_AddSuccessorBuilder(long l);
    private native void impl_AddSuccessorBuildersWithArgArray(int numBuilders, long[] ls);
    private native void impl_Goto(BytecodeBuilder b);
    private native void impl_IfCmpEqual(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpLessOrEqual(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpLessThan(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpGreaterOrEqual(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpGreaterThan(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpNotEqual(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpUnsignedLessOrEqual(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpUnsignedLessThan(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpUnsignedGreaterOrEqual(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpUnsignedGreaterThan(BytecodeBuilder target, long left, long right);
    private native void impl_IfCmpEqualZero(BytecodeBuilder target, long condition);
    private native void impl_IfCmpNotEqualZero(BytecodeBuilder target, long condition);
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
