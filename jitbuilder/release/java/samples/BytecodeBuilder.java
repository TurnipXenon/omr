// package build.jitbuilderclient.java;

public class BytecodeBuilder {
    public BytecodeBuilder(long implRet) {

    }

    public static BytecodeBuilder getClientObj(long implRet) {
        return new BytecodeBuilder(implRet);
    }
}
