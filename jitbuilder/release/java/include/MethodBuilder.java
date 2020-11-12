package java.include;

// import org.eclipse.omr.jitbuilder.IlBuilder;

public class MethodBuilder extends IlBuilder {
    MethodBuilder(long impl) {
        super(impl);
        impl_initializeFromImpl(impl);
    }

    public MethodBuilder(TypeDictionary dict) {
        super(dict != null ? dict._impl : 0L);
        impl_initializeFromImpl(_impl);
        setClientObj(this, _impl);
    }

    public boolean buildIL() {
        return false;
    }

    public void DefineName(String name) {
        impl_DefineName(name);
    }

    public void DefineParameter(String name, IlType type) {
        impl_DefineParameter(name, type);
    }

    public void DefineReturnType(IlType type) {
        impl_DefineReturnType(type);
    }

    public long _impl;

    private native void impl_initializeFromImpl(long impl);
    private native void impl_DefineName(String name);
    private native void impl_DefineParameter(String name, IlType type);
    private native void impl_DefineReturnType(IlType ilType);
}
