package jitbuilder.release.java.include;

import org.eclipse.omr.jitbuilder.IlBuilder;

// placeholder

public abstract class MethodBuilder extends IlBuilder {
    public static class MethodWrapper {
        public native int invoke(int num);
    }

    public MethodBuilder(JitBuilder.TypeDictionary typeDictionary) {
        super(0); // place holder
    }

    public abstract boolean buildIL();

    public MethodWrapper compile(){
        return null;
    }
}
