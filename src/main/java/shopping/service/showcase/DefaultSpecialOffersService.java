package shopping.service.showcase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultSpecialOffersService implements SpecialOffersService {
    
    @Override
    @Transactional
    public void saveOrder(SpecialOrder order) {
        
        // 이름 / 연락처 / 주소 저장.
        
        for(OrderItem item : order.getItems())
            System.out.println(String.format("색상: %s, 수량: %d", item.getColor(), item.getQuantity()));
    }

}
