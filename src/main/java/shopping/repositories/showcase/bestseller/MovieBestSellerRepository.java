package shopping.repositories.showcase.bestseller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shopping.domain.showcase.MovieBestSeller;

public interface MovieBestSellerRepository extends JpaRepository<MovieBestSeller, Long> {

    @Query("FROM MovieBestSeller t where t.year = ?1 and t.month = ?2")
    public Page<MovieBestSeller> findByYearAndMonth(int year, int month, Pageable pageable);
    
}
