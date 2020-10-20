package jitbuilder.release.java.include;

public class ThunkBuilder {
    public long _impl;

    public ThunkBuilder(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    private native void impl_initializeFromImpl(long impl);

    public native static IlValue getClientObj(long implRet);

	public native static void setClientObj(ThunkBuilder clientObj, long implObj);
}