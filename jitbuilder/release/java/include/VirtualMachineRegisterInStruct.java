package java.include;

public class VirtualMachineRegisterInStruct extends VirtualMachineRegister
{
    VirtualMachineRegisterInStruct(long impl) {
        super(impl);
    }

    public VirtualMachineRegisterInStruct(IlBuilder b, String structName, String localNameHoldingStructAddress, String fieldName, String localName) {
        super(newVirtualMachineRegisterInStruct((b != null ? b._impl : 0L), structName, localNameHoldingStructAddress, fieldName, localName));
    }
    
    private native void impl_initializeFromImpl(long impl);
    native static void setClientObj(IlBuilder clientObj, long implObj);
    native static long newVirtualMachineRegisterInStruct(long l, String structName, String localNameHoldingStructAddress, String fieldName, String localName);
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