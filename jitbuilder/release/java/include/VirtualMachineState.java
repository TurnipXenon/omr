package java.include;

public class VirtualMachineState {
    public long _impl;

    public VirtualMachineState(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    private native void impl_initializeFromImpl(long impl);

    public native static IlValue getClientObj(long implRet);

	public native static void setClientObj(VirtualMachineState clientObj, long implObj);
}