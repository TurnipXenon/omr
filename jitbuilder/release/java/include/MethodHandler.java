package java.include;

// import org.eclipse.omr.jitbuilder.IlValue;

public class MethodHandler extends IlBuilder {
    public MethodHandler(long impl) {
        super(impl);
    }

    public native int invoke(int value);
}
