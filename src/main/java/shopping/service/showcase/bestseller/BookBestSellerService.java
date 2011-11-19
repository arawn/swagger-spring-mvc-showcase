package shopping.service.showcase.bestseller;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import shopping.domain.showcase.BookBestSeller;
import shopping.repositories.showcase.bestseller.BookBestSellerRepository;

@Service
public class BookBestSellerService implements BestSellerService<BookBestSeller> {

    @Inject
    BookBestSellerRepository bookBestSellerRepository;
    
    @Override
    public List<BookBestSeller> getLatestBestSellers(int size) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        
        return findBestSellers(year, month, 0, size).getContent();
    }

    @Override
    public Page<BookBestSeller> findBestSellers(int year, int month, int page, int size) {
        return bookBestSellerRepository.findByYearAndMonth(year, month, 
                new PageRequest(page, size, new Sort(Direction.ASC, "rank")));
    }

}
