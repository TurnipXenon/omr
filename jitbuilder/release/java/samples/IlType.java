// package jitbuilder.release.java.samples;

public class IlType {
    public static long _impl = 0L;

    public IlType() {

    }

    public IlType(long clientRet) {

    }

    public static IlType getClientObj(long implRet) {
        return new IlType(implRet);
    }
}
