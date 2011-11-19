package shopping.service.showcase;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import shopping.domain.product.Movie;
import shopping.repositories.product.MovieRepository;

import com.google.common.collect.Lists;

@Service
public class DefaultMovieService implements ProductService<Movie> {

    @Inject
    MovieRepository movieRepository;
    
    @Override
    public Movie getProduct(Long id) {
        return movieRepository.findOne(id);
    }

    @Override
    public List<Movie> getProducts() {
        return Lists.newArrayList(movieRepository.findAll());
    }

}
