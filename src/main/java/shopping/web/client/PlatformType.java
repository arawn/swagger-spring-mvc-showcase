package shopping.web.client;

import shopping.common.lang.CodeEncodableEnum;

public enum PlatformType implements CodeEncodableEnum {
    
    IOS("IOS", "iOS 플랫폼"), 
    ANDROID("ANDROID", "Android 플랫폼"), 
    ETC("ETC", "Window, Linux, Mac OSX 등...");
    
    private String code;
    private String description;
    
    PlatformType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
    
    public boolean isIOS() {
        return IOS.equals(this);
    }
    
    public boolean isAndroid() {
        return ANDROID.equals(this);
    }    

}
