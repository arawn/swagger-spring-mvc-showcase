package shopping.web.showcase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import shopping.web.client.Client;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Client client) {
        // 기본 로직 수행
        
        if(client.isTablet()) {
            // 태블릿 추가 로직 수행
        }
        
        return "/home";
    }
    
}
