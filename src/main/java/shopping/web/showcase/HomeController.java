package shopping.web.showcase;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import shopping.web.client.Client;
import shopping.web.client.ClientFactory;

@Controller
public class HomeController {

    @Inject
    ClientFactory clientFactory;
    
    @RequestMapping("/")
    public String home(WebRequest webRequest, Model model) {
        Client client = clientFactory.create(webRequest);

        // 기본 로직 수행
        
        if(client.isTablet()) {
            // 태블릿 추가 로직 수행
        }
        
        return "/home_" + client.getClientType().getCode();
    }
    
}
