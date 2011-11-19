package shopping.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.domain.product.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
