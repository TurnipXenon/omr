package java.include;

public class VirtualMachineOperandArray extends VirtualMachineState
{

    VirtualMachineOperandArray(long impl) {
        super(impl);
        impl_initializeFromImpl(impl);
    }

    public VirtualMachineOperandArray(MethodBuilder mb, int numOfElements, IlType elementType, VirtualMachineRegister arrayBase) {
        super(newVirtualMachineOperandArray((mb != null ? mb._impl : 0L), numOfElements, (elementType != null ? elementType._impl : 0L), (arrayBase != null ? arrayBase._impl : 0L)));
    }
    public VirtualMachineOperandArray(VirtualMachineOperandArray other) {
        super(newVirtualMachineOperandArray((other != null ? other._impl : 0L));
    }

    public IlValue Get(int index) {
        long implRet = impl_Get(index);
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public void Move(IlBuilder b, int dstIndex, int srcIndex) {
        impl_Move((b != null ? b._impl : 0L), dstIndex, srcIndex);
    }

    public void Set(int index, IlValue value) {
        impl_Set(index, (value != null ? value._impl : 0L));
    }

    public void UpdateArray(IlBuilder b, IlValue array) {
        impl_UpdateArray((b != null ? b._impl : 0L), (array != null ? array._impl : 0L));
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
    native static VirtualMachineOperandArray getClientObj(long implObj);
    native static void setClientObj(IlBuilder clientObj, long implObj);
    native static long newVirtualMachineOperandArray(long impl1);
    native static long newVirtualMachineOperandArray(long impl1, long impl2);
    native static long newVirtualMachineOperandArray(long impl1, long impl2, long impl3);
    native static long newVirtualMachineOperandArray(long impl1, long impl2, long impl3, long impl4);
    private native long impl_Get(int index);
    private native void impl_Move(long b, int dstIndex, int srcIndex);
    private native void impl_Set(int index, long value);
    private native void impl_UpdateArray(long b, long array);
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