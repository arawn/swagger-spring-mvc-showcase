package shopping.common.lang;


public interface CodeEncodableEnum {

    public String getCode();
    
    static abstract class CodeEncodableEnumUtils {
        public static <T extends CodeEncodableEnum> T valueFromCode(Class<T> enumClass, String code) {
            for(T type : enumClass.getEnumConstants()) {
                if(type.getCode().equals(code))
                    return type;
            }
            throw new IllegalArgumentException("Unknown code '"+code+"' for enum type " + enumClass.getName());
        }
    }
    
}