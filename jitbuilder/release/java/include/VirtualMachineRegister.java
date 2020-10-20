package jitbuilder.release.java.include;

public class VirtualMachineRegister {
    public long _impl;

    public VirtualMachineRegister(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    private native void impl_initializeFromImpl(long impl);

    public native static IlValue getClientObj(long implRet);

	public native static void setClientObj(VirtualMachineRegister clientObj, long implObj);
}