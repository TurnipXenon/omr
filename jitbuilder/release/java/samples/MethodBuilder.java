// package jitbuilder.release.java;

public abstract class MethodBuilder {
    public MethodBuilder(TypeDictionary types) {}

    public abstract boolean buildIL();
    
    public MethodHandler compile(){
        new MethodHandler();
    }
}
