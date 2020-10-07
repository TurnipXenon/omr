// package jitbuilder.release.java.samples;

// import jitbuilder.release.java.include.JitBuilder;
// import jitbuilder.release.java.include.MethodBuilder;

public class Simple {
    static {
        System.loadLibrary("native");
    }

    static class SimpleMethod extends MethodBuilder {
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

    public static void main(String args[]) {
        System.out.println("Step 1: initialize JIT");
        boolean success = JitBuilder.initializeJit();
        if (!success) {
            System.out.println("FAIL: could not initialized JIT");
            System.exit(-1);
        }

        System.out.println("Step 2: define type dictionary");
        TypeDictionary types = new TypeDictionary();

        System.out.println("Step 3: compile method builder");
        SimpleMethod method = new SimpleMethod(types);
        MethodHandler methodWrapper = method.compile();

        System.out.println("Step 4: invoke compiled code and print results");
        int v;
        v = 0;
        System.out.println(String.format("increment(%d) == %d", v, methodWrapper.invoke(v)));
        
        v = 1;
        System.out.println(String.format("increment(%d) == %d", v, methodWrapper.invoke(v)));
        
        v = 10;
        System.out.println(String.format("increment(%d) == %d", v, methodWrapper.invoke(v)));

        v = -15;
        System.out.println(String.format("increment(%d) == %d", v, methodWrapper.invoke(v)));

        System.out.println("Step 5: shutdown JIT");
        JitBuilder.shutdownJit();
    }
}