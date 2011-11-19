package shopping.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;

import shopping.domain.product.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
