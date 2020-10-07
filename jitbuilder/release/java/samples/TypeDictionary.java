public class TypeDictionary {
    public TypeDictionary() {
        
    }

    public TypeDictionary(long clientRet) {
    }

    public static TypeDictionary getClientObj(long implRet) {
        return new TypeDictionary(implRet);
    }
}