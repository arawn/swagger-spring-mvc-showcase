package shopping.domain.showcase;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import shopping.domain.product.Book;

@Entity
public class BookBestSeller extends BestSeller<Book> {
    
    public BookBestSeller() {
        super();
    }
    
    public BookBestSeller(Long id) {
        super();
        
        setId(id);
    }
    
    @OneToOne
    @JoinColumn(name="Book_id")
    private Book book;

    @Override
    public Book getProduct() {
        return book;
    }
    @Override
    public void setProduct(Book product) {
        this.book = product;
    }
    
}
