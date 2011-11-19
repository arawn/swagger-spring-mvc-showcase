package shopping.domain.showcase;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import shopping.domain.product.Album;

@Entity
public class AlbumBestSeller extends BestSeller<Album> {
    
    @OneToOne
    @JoinColumn(name="Album_id")
    private Album album;

    @Override
    public Album getProduct() {
        return album;
    }

    @Override
    public void setProduct(Album product) {
        this.album = product;
    }
    
}
