package java.include;

// import org.eclipse.omr.jitbuilder.IlBuilder;

public class MethodBuilder extends IlBuilder
{

    MethodBuilder(long impl) {
        super(impl);
        impl_initializeFromImpl(impl);
    }

    public MethodBuilder(TypeDictionary dict) {
        super(newMethodBuilder((dict != null ? dict._impl : 0L)));
        impl_initializeFromImpl(_impl);
        setClientObj(this, _impl);
    }

    public MethodBuilder(TypeDictionary dict, VirtualMachineState vmState) {
        super(newMethodBuilder((dict != null ? dict._impl : 0L), (vmState != null ? vmState._impl : 0L));
        impl_initializeFromImpl(_impl);
        setClientObj(this, _impl);
    }

    public MethodBuilder(MethodBuilder callerMB) {
        super(newMethodBuilder((callerMB != null ? callerMB._impl : 0L));
        impl_initializeFromImpl(_impl);
        setClientObj(this, _impl);
    }
    
    public MethodBuilder(MethodBuilder callerMB, VirtualMachineState vmState) {
        super(newMethodBuilder((callerMB != null ? callerMB._impl : 0L), (vmState != null ? vmState._impl : 0L));
        impl_initializeFromImpl(_impl);
        setClientObj(this, _impl);
    }

	public void AllLocalsHaveBeenDefined() {
        impl_AllLocalsHaveBeenDefined();
    }

    public void AppendBuilder(IlBuilder b) {
        impl_AppendBuilder((b != null ? b._impl : 0L));
    }

    public void AppendBuilder(BytecodeBuilder b) {
        impl_AppendBuilder((b != null ? b._impl : 0L));
    }

    public void AppendBytecodeBuilder(BytecodeBuilder b) {
        impl_AppendBytecodeBuilder((b != null ? b._impl : 0L));
    }

    public void DefineFile(String fileName) {
        impl_DefineFile(fileName);
    }

    public void DefineLine(String line) {
        impl_DefineLine(line);
    }

    public void DefineLine(int line) {
        impl_DefineLine(line);
    }

    public void DefineName(String name) {
        impl_DefineName(name);
    }

    public void DefineParameter(String name, IlType type) {
        impl_DefineParameter(name, (type != null ? type._impl : 0L));
    }

    public void DefineArrayParameter(String name, IlType type) {
        impl_DefineArrayParameter(name, (type != null ? type._impl : 0L));
    }

    public void DefineReturnType(IlType type) {
        impl_DefineReturnType((type != null ? type._impl : 0L));
    }

    public void DefineLocal(String name, IlType type) {
        impl_DefineLocal(name, (type != null ? type._impl : 0L));
    }

    public void DefineGlobal(String name, IlType type, long location) {
        impl_DefineGlobal(name, (type != null ? type._impl : 0L), location);
    }

    public void DefineMemory(String name, IlType type, long location) {
        impl_DefineMemory(name, (type != null ? type._impl : 0L), location);
    }

    public void DefineFunction(String name, String fileName, String lineNumber, long entryPoint, IlType returnType, int numParms, IlType[] parmTypes) {
        impl_DefineFunctionWithArgArray(name, fileName, lineNumber, entryPoint, (returnType != null ? returnType._impl : 0L), numParms, transformArray(parmTypes));
    }

    private void impl_DefineFunctionWithArgArray(String name, String fileName, String lineNumber, long entryPoint,
            long l, int numParms, long[] transformArray) {
    }

    public IlValue GetMethodName() {
        return impl_GetMethodName();
    }

    public IlValue GetNextBytecodeFromWorklist() {
        return impl_GetNextBytecodeFromWorklist();
    }

    public void setVMState(VirtualMachineState vmState) {
        impl_setVMState((vmState != null ? vmState._impl : 0L));
    }

    private static long[] transformArray(IlType[] clientArray) {
        long implArray[] = new long[clientArray.length];
        for (int i=0;i < clientArray.length; i++) {
            IlType o = clientArray[i];
            implArray[i] = (o != null) ? (o._impl) : 0L;
        }
        return implArray;
    }

    private native static long newMethodBuilder(long impl);
    private native static long newMethodBuilder(long impl1, long impl2d);

    private native void impl_initializeFromImpl(long impl);
    native static MethodBuilder getClientObj(long implObj);
    native static void setClientObj(IlBuilder clientObj, long implObj);
    private native void impl_AllLocalsHaveBeenDefined();
    private native void impl_AppendBuilder(long b);
    private native void impl_AppendBuilder(BytecodeBuilder b);
    private native void impl_AppendBytecodeBuilder(long l);
    private native void impl_DefineFile(String fileName);
    private native void impl_DefineLine(String line);
    private native void impl_DefineLine(int line);
    private native void impl_DefineName(String name);
    private native void impl_DefineParameter(String name, long type);
    private native void impl_DefineArrayParameter(String name, long type);
    private native void impl_DefineReturnType(long type);
    private native void impl_DefineLocal(String name, long type);
    private native void impl_DefineGlobal(String name, long type, long location);
    private native void impl_DefineMemory(String name, long type, long location);
    private native void impl_DefineFunction(String name, String fileName, String lineNumber, long entryPoint, long returnType, int numParms, long[] parmTypes);
    private native IlValue impl_GetMethodName();
    private native IlValue impl_GetNextBytecodeFromWorklist();
    private native void impl_setVMState(long l);
    protected IlType NoType;
    protected IlType Int8;
    protected IlType Int16;
    protected IlType Int32;
    protected IlType Int64;
    protected IlType Float;
    protected IlType Double;
    protected IlType Address;
    protected IlType VectorInt8;
    protected IlType VectorInt16;
    protected IlType VectorInt32;
    protected IlType VectorInt64;
    protected IlType VectorFloat;
    protected IlType VectorDouble;
    protected IlType Word;
    long _impl;
}