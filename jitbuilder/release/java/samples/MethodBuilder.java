// import org.eclipse.omr.jitbuilder.IlBuilder;

// package jitbuilder.release.java;

public abstract class MethodBuilder extends IlBuilder {
    public long _impl;

    public MethodBuilder(TypeDictionary types) {
        super(0L);
    }

    public abstract boolean buildIL();

    public MethodHandler compile() {
        return new MethodHandler(0L);
    }
}
