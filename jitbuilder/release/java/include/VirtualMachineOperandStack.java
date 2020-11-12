package java.include;

public class VirtualMachineOperandStack extends VirtualMachineState
{

    VirtualMachineOperandStack(long impl) {
        super(impl);
    }

    public VirtualMachineOperandStack(MethodBuilder mb, int sizeHint, IlType elementType, VirtualMachineRegister stackTopRegister) {
        super(newVirtualMachineOperandStack((mb != null ? mb._impl : 0L), sizeHint, (elementType != null ? elementType._impl : 0L), (stackTopRegister != null ? stackTopRegister._impl : 0L)));
    }
    public VirtualMachineOperandStack(MethodBuilder mb, int sizeHint, IlType elementType, VirtualMachineRegister stackTopRegister, boolean growsUp) {
        super(newVirtualMachineOperandStack((mb != null ? mb._impl : 0L), sizeHint, (elementType != null ? elementType._impl : 0L), (stackTopRegister != null ? stackTopRegister._impl : 0L), growsUp));
    }
    public VirtualMachineOperandStack(MethodBuilder mb, int sizeHint, IlType elementType, VirtualMachineRegister stackTopRegister, boolean growsUp, int stackInitialOffset) {
        super(newVirtualMachineOperandStack((mb != null ? mb._impl : 0L), sizeHint, (elementType != null ? elementType._impl : 0L), (stackTopRegister != null ? stackTopRegister._impl : 0L), growsUp, stackInitialOffset);
    }

    public void Drop(IlBuilder b, int depth) {
        impl_Drop((b != null ? b._impl : 0L), depth);
    }

    public void Dup(IlBuilder b) {
        impl_Dup((b != null ? b._impl : 0L));
    }

    public IlValue Pick(int depth) {
        long implRet = impl_Pick(depth);
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public IlValue Pop(IlBuilder b) {
        long implRet = impl_Pop((b != null ? b._impl : 0L));
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public void Push(IlBuilder b, IlValue value) {
        impl_Push((b != null ? b._impl : 0L), (value != null ? value._impl : 0L));
    }

    public IlValue Top() {
        long implRet = impl_Top();
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public void UpdateStack(IlBuilder b, IlValue array) {
        impl_UpdateStack((b != null ? b._impl : 0L), (array != null ? array._impl : 0L));
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
    native static VirtualMachineOperandStack getClientObj(long implObj);
    native static void setClientObj(IlBuilder clientObj, long implObj);
    native static long newVirtualMachineOperandStack(long impl1);
    native static long newVirtualMachineOperandStack(long impl1, long impl2);
    native static long newVirtualMachineOperandStack(long impl1, long impl2, long impl3);
    native static long newVirtualMachineOperandStack(long impl1, long impl2, long impl3, long impl4);
    native static long newVirtualMachineOperandStack(long impl1, int impl2, long impl3, long impl4, boolean impl5);
    native static long newVirtualMachineOperandStack(long impl1, int impl2, long impl3, long impl4, boolean impl5, int impl6);
    private native void impl_Drop(long b, int depth);
    private native void impl_Dup(long b);
    private native long impl_Pick(int depth);
    private native long impl_Pop(long b);
    private native void impl_Push(long b, long value);
    private native long impl_Top();
    private native void impl_UpdateStack(long b, long array);
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