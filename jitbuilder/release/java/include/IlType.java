package java.include;

public class IlType {
    public long _impl;

	public IlType(long impl) {
        impl_initializeFromImpl(impl);
    }

    public static IlType getClientObj(long implRet) {
        return new IlType(implRet);
    }

	public native static void setClientObj(IlType ilType, long l);
    
    private native void impl_initializeFromImpl(long impl);
}
