package shopping.repositories.showcase.bestseller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import shopping.domain.showcase.BookBestSeller;

public interface BookBestSellerRepository extends JpaRepository<BookBestSeller, Long> {

    @Query("FROM BookBestSeller t where t.year = ?1 and t.month = ?2")
    public Page<BookBestSeller> findByYearAndMonth(int year, int month, Pageable pageable);
    
}
