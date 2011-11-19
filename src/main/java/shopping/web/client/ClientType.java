package shopping.web.client;

import shopping.common.lang.CodeEncodableEnum;

public enum ClientType implements CodeEncodableEnum {

    PHONE("phone", "스마트폰 유형의 클라이언트"), 
    TABLET("tablet", "태블릿 유형의 클라이언트"), 
    ETC("etc", "스마트폰, 태블릿을 제외한 나머지 모든 유형");
    
    private String code;
    private String description;
    
    ClientType(String code, String description) {
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
    
    public boolean isPhone() {
        return PHONE.equals(this);
    }
    
    public boolean isTablet() {
        return TABLET.equals(this);
    }
    
    public boolean isEtc() {
        return ETC.equals(this);
    }
    
}
