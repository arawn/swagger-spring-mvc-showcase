package shopping.service.showcase;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import shopping.domain.product.Album;
import shopping.repositories.product.AlbumRepository;

import com.google.common.collect.Lists;

@Service
public class DefaultAlbumService implements ProductService<Album> {
    
    @Inject
    AlbumRepository albumRepository;
    
    @Override
    public Album getProduct(Long id) {
        return albumRepository.findOne(id);
    }

    @Override
    public List<Album> getProducts() {
        return Lists.newArrayList(albumRepository.findAll());
    }

}
