package jitbuilder.release.java.include;

// import org.eclipse.omr.jitbuilder.IlBuilder;

public class TypeDictionary {
    private long _impl;

    public TypeDictionary() {
        _impl = 0L; // todo: should not be 0L
        TypeDictionary.setClientObj(this, _impl);
    }

    public TypeDictionary(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    private native void impl_initializeFromImpl(long impl);

    public native static TypeDictionary getClientObj(long implRet);

	public native static void setClientObj(TypeDictionary clientObj, long implObj);
}