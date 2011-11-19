package shopping.web.showcase.bestseller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import shopping.domain.showcase.AlbumBestSeller;
import shopping.domain.showcase.BookBestSeller;
import shopping.domain.showcase.MovieBestSeller;
import shopping.service.showcase.bestseller.AlbumBestSellerService;
import shopping.service.showcase.bestseller.BookBestSellerService;
import shopping.service.showcase.bestseller.MovieBestSellerService;
import shopping.web.client.Client;
import shopping.web.client.ClientFactory;

@Controller
public class BestSellerController {
    
    @Inject
    ClientFactory clientFactory;
    
    @Inject
    BookBestSellerService bookBestSellerService;
    
    @Inject
    AlbumBestSellerService albumBestSellerService;
    
    @Inject
    MovieBestSellerService movieBestSellerService;
    
    
    @Value("#{viewConfigProperties['phone.latest.bestseller.size']}")
    int phoneLatestBestsellerSize;
    @Value("#{viewConfigProperties['tablet.latest.bestseller.size']}")
    int tabletLatestBestsellerSize;
    @Value("#{viewConfigProperties['etc.latest.bestseller.size']}")
    int etcLatestBestsellerSize;
    
    @Value("#{viewConfigProperties['phone.default.bestseller.size']}")
    int phoneDefaultBestsellerSize;
    @Value("#{viewConfigProperties['tablet.default.bestseller.size']}")
    int tabletDefaultBestsellerSize;
    @Value("#{viewConfigProperties['etc.default.bestseller.size']}")
    int etcDefaultBestsellerSize;
    
    
    @RequestMapping(value="/showcase/bestseller", method=RequestMethod.GET)
    public String bestSeller(WebRequest webRequest, Model model) {
        Client client = clientFactory.create(webRequest);

        if(!client.isPhone()) {
            int latestBestsellerSize = client.isTablet() ? tabletLatestBestsellerSize : etcLatestBestsellerSize;
    
            model.addAttribute("bookBestSellers", bookBestSellerService.getLatestBestSellers(latestBestsellerSize));
            model.addAttribute("albumBestSellers", albumBestSellerService.getLatestBestSellers(latestBestsellerSize));
            model.addAttribute("movieBestSellers", movieBestSellerService.getLatestBestSellers(latestBestsellerSize));
        }
        
        return "/bestseller/bestseller_" + client.getClientType().getCode();
    }
    
    @RequestMapping(value="/showcase/bestseller/book", method=RequestMethod.GET)
    public String bookBestSeller(@ModelAttribute("condition") BestSellerCondition condition, WebRequest webRequest, Model model) {
        Client client = clientFactory.create(webRequest);
        
        if(condition.isEmpty())
            setBestSellerConditionDefaultValue(client, condition);
        
        Page<BookBestSeller> page = bookBestSellerService
                .findBestSellers(condition.getYear(), condition.getMonth(), condition.getPage(), condition.getSize());
        
        model.addAttribute("bestSellers", page.getContent());
        model.addAttribute("hasNextPage", page.hasNextPage());
        
        return "/bestseller/book_" + client.getClientType().getCode();
    }

    @RequestMapping(value="/showcase/bestseller/album", method=RequestMethod.GET)
    public String albumBestSeller(BestSellerCondition condition, WebRequest webRequest, Model model) {
        Client client = clientFactory.create(webRequest);

        if(condition.isEmpty())
            setBestSellerConditionDefaultValue(client, condition);
        
        Page<AlbumBestSeller> page = albumBestSellerService
                .findBestSellers(condition.getYear(), condition.getMonth(), condition.getPage(), condition.getSize());
        
        model.addAttribute("bestSellers", page.getContent());
        model.addAttribute("hasNextPage", page.hasNextPage());
        
        return "/bestseller/album_" + client.getClientType().getCode();
    }
    
    @RequestMapping(value="/showcase/bestseller/movie", method=RequestMethod.GET)
    public String movieBestSeller(BestSellerCondition condition, WebRequest webRequest, Model model) {
        Client client = clientFactory.create(webRequest);

        if(condition.isEmpty())
            setBestSellerConditionDefaultValue(client, condition);
            
        Page<MovieBestSeller> page = movieBestSellerService
                .findBestSellers(condition.getYear(), condition.getMonth(), condition.getPage(), condition.getSize());
        
        model.addAttribute("bestSellers", page.getContent());
        model.addAttribute("hasNextPage", page.hasNextPage());
        
        return "/bestseller/movie_" + client.getClientType().getCode();
    }
    
    private void setBestSellerConditionDefaultValue(Client client, BestSellerCondition condition) {
        int defaultBestsellerSize = phoneDefaultBestsellerSize;
        
        if(client.isTablet()) {
            defaultBestsellerSize = tabletDefaultBestsellerSize;
        } else if(client.isEtc()) {
            defaultBestsellerSize = etcDefaultBestsellerSize;
        }
        
        condition.setDefaultValue(defaultBestsellerSize);
    }
}
