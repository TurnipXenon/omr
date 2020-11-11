package jitbuilder.release.java.include;

public class IlType {
    public IlType(long impl) {
        impl_initializeFromImpl(impl);
    }

    public static IlType getClientObj(long implRet) {
        return new IlType(implRet);
    }

	public native static void setClientObj(IlType ilType, long l);
    
    private native void impl_initializeFromImpl(long impl);
}
