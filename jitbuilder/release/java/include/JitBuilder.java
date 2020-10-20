package jitbuilder.release.java.include;

// import org.eclipse.omr.jitbuilder.VirtualMachineOperandArray;
// import org.eclipse.omr.jitbuilder.VirtualMachineOperandStack;

// import jitbuilder.release.java.include.JitBuilder.TypeDictionary;


public class JitBuilder {
    public static boolean initializeJit() {
        setAllocators();
        // todo: what does internal_initializeJit(); mean???
        return true;
    }

    public static boolean shutdownJit() {
        return true;
    }

    private static void setAllocators() {
        // todo: what does impl obj mean???
        // todo: uncomment
        // BytecodeBuilder.setClientObj(new BytecodeBuilder(0L), 0L);
        // IlBuilder.set_IlBuilder_JBCase_ClientObj(new IlBuilder(0L).new JBCase(0L), 0L);
        // IlBuilder.set_IlBuilder_JBCondition_ClientObj(new IlBuilder(0L).new JBCondition(0L), 0L);
        // IlBuilder.setClientObj(new IlBuilder(0L) , 0L);
        // MethodBuilder.setClientObj(new MethodBuilder(0L), 0L);
        // IlType.setClientObj(new IlType(0L), 0L);
        // IlValue.setClientObj(new IlValue(0L), 0L);
        // ThunkBuilder.setClientObj(new ThunkBuilder(0L), 0L);
        // TypeDictionary.setClientObj(new TypeDictionary(0L), 0L);
        // VirtualMachineOperandArray.setClientObj(new VirtualMachineOperandArray(0L), 0L);
        // VirtualMachineOperandStack.setClientObj(new VirtualMachineOperandStack(0L), 0L);
        // VirtualMachineRegister.setClientObj(new VirtualMachineRegister(0L), 0L);
        // VirtualMachineRegisterInStruct.setClientObj(new VirtualMachineRegisterInStruct(0L), 0L);
        // VirtualMachineState.setClientObj(new VirtualMachineState(0L), 0L);
    }
}
