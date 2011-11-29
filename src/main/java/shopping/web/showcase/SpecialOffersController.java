package shopping.web.showcase;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import shopping.service.showcase.SpecialOffersService;
import shopping.service.showcase.SpecialOrder;

@Controller
@RequestMapping("/specialoffers/*")
public class SpecialOffersController {
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 2.5.x 시절로 돌아가기 위해서 강제로 기능 정지!
        binder.setAutoGrowNestedPaths(false);
    }
    
    @Inject
    SpecialOffersService specialOffersService;
    
    @RequestMapping    
    public String main() {
        return "/specialoffers/main";
    }
    
    @RequestMapping    
    public void orderconfirmation(@ModelAttribute("order") SpecialOrder order) {

        // validation 등의 로직 처리
        
        // 주문 저장
        specialOffersService.saveOrder(order);
    }
    
}
