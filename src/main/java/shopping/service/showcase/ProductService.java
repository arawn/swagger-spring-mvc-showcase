package shopping.service.showcase;

import java.util.List;

import shopping.domain.product.Product;

public interface ProductService<T extends Product> {

    public T getProduct(Long id);
    
    public List<T> getProducts();
    
}
