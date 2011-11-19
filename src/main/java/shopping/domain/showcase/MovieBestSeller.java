package shopping.domain.showcase;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import shopping.domain.product.Movie;

@Entity
public class MovieBestSeller extends BestSeller<Movie> {
    
    @OneToOne
    @JoinColumn(name="Movie_id")
    private Movie movie;

    @Override
    public Movie getProduct() {
        return movie;
    }
    @Override
    public void setProduct(Movie product) {
        this.movie = product;
    }
    
}
