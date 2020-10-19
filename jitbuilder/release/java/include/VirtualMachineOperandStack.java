public class VirtualMachineOperandStack {
    public long _impl;

    public VirtualMachineOperandStack(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    private native void impl_initializeFromImpl(long impl);

    public native static IlValue getClientObj(long implRet);

	public native static void setClientObj(VirtualMachineOperandStack clientObj, long implObj);
}