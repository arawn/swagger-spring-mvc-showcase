package shopping.domain.product;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class Album extends Product {

    private String singer;
    
    @ElementCollection
    @Column(name="title")
    private List<String> songs;
    
    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }
    public List<String> getSongs() {
        return songs;
    }
    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
    
}
