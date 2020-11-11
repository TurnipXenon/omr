package java.include;

// import jitbuilder.release.java.samples.Simple.SimpleMethod;

// import org.eclipse.omr.jitbuilder.VirtualMachineOperandArray;
// import org.eclipse.omr.jitbuilder.VirtualMachineOperandStack;

// import jitbuilder.release.java.include.JitBuilder.TypeDictionary;

public class JitBuilder {
    private static long implObj;

    public static boolean initializeJit() {
        setAllocators();
        // todo: what does internal_initializeJit(); mean???
        return true;
    }

    public static boolean shutdownJit() {
        return true;
    }

    private static void setAllocators() {
        implObj = 0;

        implObj++;
        BytecodeBuilder.setClientObj(new BytecodeBuilder(implObj), implObj);

        implObj++;
        IlBuilder ilBuilder = new IlBuilder(implObj);
        IlBuilder.setClientObj(ilBuilder, implObj);
        
        implObj++;
        IlBuilder.set_IlBuilder_JBCase_ClientObj(ilBuilder.new JBCase(implObj), implObj);

        implObj++;
        IlBuilder.set_IlBuilder_JBCondition_ClientObj(ilBuilder.new JBCondition(implObj), implObj);

        implObj++;
        MethodBuilder.setClientObj(new MethodBuilder(implObj), implObj);

        implObj++;
        IlType.setClientObj(new IlType(implObj), implObj);

        implObj++;
        IlValue.setClientObj(new IlValue(implObj), implObj);

        implObj++;
        ThunkBuilder.setClientObj(new ThunkBuilder(implObj), implObj);

        implObj++;
        TypeDictionary.setClientObj(new TypeDictionary(implObj), implObj);

        implObj++;
        VirtualMachineOperandArray.setClientObj(new VirtualMachineOperandArray(implObj), implObj);

        implObj++;
        VirtualMachineOperandStack.setClientObj(new VirtualMachineOperandStack(implObj), implObj);

        implObj++;
        VirtualMachineRegister.setClientObj(new VirtualMachineRegister(implObj), implObj);

        implObj++;
        VirtualMachineRegisterInStruct.setClientObj(new VirtualMachineRegisterInStruct(implObj), implObj);

        implObj++;
        VirtualMachineState.setClientObj(new VirtualMachineState(implObj), implObj);
    }

	public static MethodHandler compile(MethodBuilder method) {
		impl_compile(method);
    }
    
    private native static MethodHandler impl_compile(MethodBuilder methodBuilder);
}
