package shopping.web.showcase.bestseller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shopping.domain.product.ProductType;
import shopping.service.showcase.bestseller.AlbumBestSellerService;
import shopping.service.showcase.bestseller.BestSellerServiceLocator;
import shopping.service.showcase.bestseller.BookBestSellerService;
import shopping.service.showcase.bestseller.MovieBestSellerService;
import shopping.web.client.Client;

@Controller
public class BestSellerController {
    
    @Inject
    BookBestSellerService bookBestSellerService;
    
    @Inject
    AlbumBestSellerService albumBestSellerService;
    
    @Inject
    MovieBestSellerService movieBestSellerService;
    
    @Inject
    BestSellerServiceLocator bestSellerServiceLocator;
    
    
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
    public String bestSeller(Client client, Model model) {
        if(!client.isPhone()) {
            int latestBestsellerSize = client.isTablet() ? tabletLatestBestsellerSize : etcLatestBestsellerSize;
    
            model.addAttribute("bookBestSellers", bookBestSellerService.getLatestBestSellers(latestBestsellerSize));
            model.addAttribute("albumBestSellers", albumBestSellerService.getLatestBestSellers(latestBestsellerSize));
            model.addAttribute("movieBestSellers", movieBestSellerService.getLatestBestSellers(latestBestsellerSize));
        }
        
        return "/bestseller/bestseller_" + client.getClientType().getCode();
    }
    
    @RequestMapping(value="/showcase/bestseller/{productType}", method=RequestMethod.GET)
    public String bookBestSeller(
            @PathVariable("productType") ProductType productType,
            @ModelAttribute("condition") BestSellerCondition condition,
            Client client, Model model) {
        
        if(condition.isEmpty())
            setBestSellerConditionDefaultValue(client, condition);
        
        Page<?> page = bestSellerServiceLocator.getBestSellerService(productType).findBestSellers(
                condition.getYear(), condition.getMonth(), condition.getPage(), condition.getSize());

        model.addAttribute("bestSellers", page.getContent());
        model.addAttribute("hasNextPage", page.hasNextPage());
        
        return "/bestseller/" + productType.getCode() + "_" + client.getClientType().getCode();
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
