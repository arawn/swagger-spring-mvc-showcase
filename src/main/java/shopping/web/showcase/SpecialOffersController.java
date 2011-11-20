package shopping.web.showcase;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import shopping.service.showcase.SpecialOffersService;
import shopping.service.showcase.SpecialOrder;

@Controller
@RequestMapping("/specialoffers/*")
public class SpecialOffersController {
    
    @Inject
    SpecialOffersService specialOffersService;
    
    @RequestMapping    
    public void main() {
    }
    
    @RequestMapping    
    public void orderconfirmation(@ModelAttribute("order") SpecialOrder order) {

        // validation 등의 로직 처리
        
        // 주문 저장
        specialOffersService.saveOrder(order);
    }
    
}
