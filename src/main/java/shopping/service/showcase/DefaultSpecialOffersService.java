package shopping.service.showcase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultSpecialOffersService implements SpecialOffersService {
    
    @Override
    @Transactional
    public void saveOrder(SpecialOrder order) {
        
        // 이름 / 연락처 / 주소 저장.
        
        if(order.getColors() != null) {
            for(int idx=0; idx<order.getColors().length; idx++) {
                // 색상, 주문수량 저장
                String color = order.getColors()[idx];
                int quantity = order.getQuantitys()[idx];
                
                System.out.println(String.format("색상: %s, 수량: %d", color, quantity));
            }
        }        
    }

}
