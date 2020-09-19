// import org.eclipse.omr.jitbuilder.IlBuilder;

// package jitbuilder.release.java;

public class MethodBuilder extends IlBuilder {
    public long _impl;

    public MethodBuilder(long impl) {
        super(impl);
    }

    public MethodBuilder(TypeDictionary types) {
        super(0L);
    }

    public boolean buildIL() {
        return false;
    }

    public MethodHandler compile() {
        return new MethodHandler(0L);
    }
}
