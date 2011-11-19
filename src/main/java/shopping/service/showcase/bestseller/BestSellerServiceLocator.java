package shopping.service.showcase.bestseller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;

import shopping.domain.product.ProductType;

@Component
public class BestSellerServiceLocator {

    private final Map<ProductType, BestSellerService<?>> bestSellerServices; 
    
    @Inject
    @SuppressWarnings("rawtypes")
    public BestSellerServiceLocator(ListableBeanFactory beanFactory) {
        Map<String, BestSellerService> services = BeanFactoryUtils
                .beansOfTypeIncludingAncestors(beanFactory, BestSellerService.class);
        bestSellerServices = new HashMap<ProductType, BestSellerService<?>>(services.size());
        for(BestSellerService service : services.values())
            bestSellerServices.put(service.getType(), service);
    }
    
    public BestSellerService<?> getBestSellerService(ProductType productType) {
        if(!bestSellerServices.containsKey(productType))
            throw new IllegalArgumentException(productType + "은 지원하지 않습니다.");
        
        return bestSellerServices.get(productType);
    }

}
