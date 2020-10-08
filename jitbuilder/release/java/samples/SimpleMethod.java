// import jdk.javadoc.internal.doclets.toolkit.builders.MethodBuilder;

public class SimpleMethod extends MethodBuilder {
    
    SimpleMethod(TypeDictionary types) {
        super(types);

        // ???
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
