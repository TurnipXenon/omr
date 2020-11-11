package jitbuilder.release.java.include;

public class IlValue {
    public long _impl;

    public IlValue(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    public static IlValue getClientObj(long implRet) {
        return null;
    }

	public static void setClientObj(IlValue ilValue, long l) {
        // todo: implement
    }

    private native void impl_initializeFromImpl(long impl);
}