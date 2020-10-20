package jitbuilder.release.java.include;

public class VirtualMachineOperandArray {
    public long _impl;

    public VirtualMachineOperandArray(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    private native void impl_initializeFromImpl(long impl);

    public native static IlValue getClientObj(long implRet);

	public native static void setClientObj(VirtualMachineOperandArray clientObj, long implObj);
}