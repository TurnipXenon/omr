// import org.eclipse.omr.jitbuilder.IlValue;

// package jitbuilder.release.java.samples;

public class MethodHandler extends IlBuilder {
    public MethodHandler(long impl) {
        super(impl);
    }

    public native int invoke(int value);
}
