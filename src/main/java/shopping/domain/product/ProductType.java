package shopping.domain.product;

import shopping.common.lang.CodeEncodableEnum;

public enum ProductType implements CodeEncodableEnum {

    BOOK("book", "책"), 
    ALBUM("album", "음반"), 
    MOVIE("movie", "영화");
    
    private String code;
    private String description;
    
    ProductType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    
}
