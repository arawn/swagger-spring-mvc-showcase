package shopping.service.showcase.bestseller;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import shopping.domain.showcase.AlbumBestSeller;
import shopping.repositories.showcase.bestseller.AlbumBestSellerRepository;

@Service
public class AlbumBestSellerService implements BestSellerService<AlbumBestSeller> {

    @Inject
    AlbumBestSellerRepository albumBestSellerRepository;
    
    @Override
    public List<AlbumBestSeller> getLatestBestSellers(int size) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        
        return findBestSellers(year, month, 0, size).getContent();
    }

    @Override
    public Page<AlbumBestSeller> findBestSellers(int year, int month, int page, int size) {
        return albumBestSellerRepository.findByYearAndMonth(year, month, 
                new PageRequest(page, size, new Sort(Direction.ASC, "rank")));
    }

}
