// package jitbuilder.release.java.samples;

public class IlType {
    public static long _impl = 0L;

    public IlType() {

    }

    public IlType(long impl) {
        impl_initializeFromImpl(impl);
    }

    public static IlType getClientObj(long implRet) {
        return new IlType(implRet);
    }

	public native static void setClientObj(IlType ilType, long l);
    
    private native void impl_initializeFromImpl(long impl);
}
