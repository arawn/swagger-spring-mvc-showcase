package shopping.domain.product;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class Movie extends Product {

    private String director;
    @ElementCollection
    private List<String> actors;
    
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public List<String> getActors() {
        return actors;
    }
    public void setActors(List<String> actors) {
        this.actors = actors;
    }
    
}
