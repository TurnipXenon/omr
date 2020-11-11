package jitbuilder.release.java.include;

public class BytecodeBuilder {
    public BytecodeBuilder(long implRet) {
        impl_initializeFromImpl(implRet);
    }

    public static BytecodeBuilder getClientObj(long implRet) {
        return new BytecodeBuilder(implRet);
    }

	public static void setClientObj(BytecodeBuilder bytecodeBuilder, long l) {
	}

    private native void impl_initializeFromImpl(long impl);
}
