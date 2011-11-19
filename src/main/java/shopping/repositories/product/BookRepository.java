package shopping.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.domain.product.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
