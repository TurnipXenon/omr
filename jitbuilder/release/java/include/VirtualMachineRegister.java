package java.include;

public class VirtualMachineRegister extends VirtualMachineState
{

    VirtualMachineRegister(long impl) {
        super(impl);
    }

    public VirtualMachineRegister(IlBuilder b, String localName, IlType pointerToRegisterType, int adjustByStep, IlValue addressOfRegister) {
        super(newVirtualMachineRegister((b != null ? b._impl : 0L), localName, (pointerToRegisterType != null ? pointerToRegisterType._impl : 0L), adjustByStep, (addressOfRegister != null ? addressOfRegister._impl : 0L));
    }

    public void Adjust(IlBuilder b, IlValue amount) {
        impl_Adjust((b != null ? b._impl : 0L), (amount != null ? amount._impl : 0L));
    }

    public void Adjust(IlBuilder b, long amount) {
        impl_Adjust((b != null ? b._impl : 0L), amount);
    }

    public IlValue Load(IlBuilder b) {
        long implRet = impl_Load((b != null ? b._impl : 0L));
        IlValue clientRet=null;
        if (implRet != 0L) {
            clientRet = IlValue.getClientObj(implRet);
            if (clientRet == null) {
                clientRet = new IlValue(implRet);
            }
        }
        return clientRet;
    }

    public void Store(IlBuilder b, IlValue value) {
        impl_Store((b != null ? b._impl : 0L), (value != null ? value._impl : 0L));
    }
    
    private native void impl_initializeFromImpl(long impl);
    native static VirtualMachineRegister getClientObj(long implObj);
    native static void setClientObj(IlBuilder clientObj, long implObj);
    native static long newVirtualMachineRegister(long impl1);
    native static long newVirtualMachineRegister(long impl1, long impl2);
    native static long newVirtualMachineRegister(long impl1, long impl2, long impl3);
    native static long newVirtualMachineRegister(long impl1, long impl2, long impl3, long impl4);
    native static long newVirtualMachineRegister(long impl1, String impl2, long impl3, int impl4, long impl5);
    private native void impl_Adjust(long b, long amount);
    private native long impl_Load(long b);
    private native void impl_Store(long b, long value);
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