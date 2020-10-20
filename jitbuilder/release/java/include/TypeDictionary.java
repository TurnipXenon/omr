package jitbuilder.release.java.include;

// import org.eclipse.omr.jitbuilder.IlBuilder;

public class TypeDictionary {
    public long _impl;

    public TypeDictionary() {
        // todo
    }

    public TypeDictionary(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    private native void impl_initializeFromImpl(long impl);

    public native static TypeDictionary getClientObj(long implRet);

	public native static void setClientObj(TypeDictionary clientObj, long implObj);
}