package jitbuilder.release.java.include;

public class VirtualMachineRegisterInStruct {
    public long _impl;

    public VirtualMachineRegisterInStruct(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    private native void impl_initializeFromImpl(long impl);

    public native static IlValue getClientObj(long implRet);

	public native static void setClientObj(VirtualMachineRegisterInStruct clientObj, long implObj);
}