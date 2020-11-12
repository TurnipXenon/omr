package java.include;


public class VirtualMachineState
{

    VirtualMachineState(long impl) {
        impl_initializeFromImpl(impl);
    }

    public VirtualMachineState() {
        _impl = newVirtualMachineState();
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
    
    private native void impl_initializeFromImpl(long impl);
    native static long newVirtualMachineState();
    native static VirtualMachineState getClientObj(long implObj);
    native static void setClientObj(VirtualMachineState clientObj, long implObj);
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