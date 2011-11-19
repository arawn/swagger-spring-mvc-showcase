package shopping.service.showcase.bestseller;

import java.util.List;

import org.springframework.data.domain.Page;

import shopping.domain.product.ProductType;
import shopping.domain.showcase.BestSeller;

public interface BestSellerService<T extends BestSeller<?>> {

    public ProductType getType();
    
    public List<T> getLatestBestSellers(int size);
    
    public Page<T> findBestSellers(int year, int month, int page, int size);

    
}