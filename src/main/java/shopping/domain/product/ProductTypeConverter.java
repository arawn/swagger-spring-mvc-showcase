package shopping.domain.product;

import java.util.Collections;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import shopping.common.lang.CodeEncodableEnum;

public class ProductTypeConverter implements GenericConverter {
    
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, ProductType.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        return CodeEncodableEnum.CodeEncodableEnumUtils.valueFromCode(ProductType.class, (String) source);
    }

}
