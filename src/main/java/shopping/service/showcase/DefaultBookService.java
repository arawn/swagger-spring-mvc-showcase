package shopping.service.showcase;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import shopping.domain.product.Book;
import shopping.repositories.product.BookRepository;

import com.google.common.collect.Lists;

@Service
public class DefaultBookService implements ProductService<Book> {

    @Inject
    BookRepository bookRepository;
    
    @Override
    public Book getProduct(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public List<Book> getProducts() {
        return Lists.newArrayList(bookRepository.findAll());
    }

}
