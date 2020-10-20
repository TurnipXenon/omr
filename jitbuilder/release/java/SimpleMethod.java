// import jdk.javadoc.internal.doclets.toolkit.builders.MethodBuilder;

public class SimpleMethod extends MethodBuilder {
    
    SimpleMethod(TypeDictionary types) {
        super(types);
        DefineName("increment");
        DefineParameter("value", Int32);
        DefineReturnType(Int32);
    }

    @Override
    public boolean buildIL() {
        Return(
            Add(
                Load("value"), 
                ConstInt32(1))
        );
        return true;
    }
}
