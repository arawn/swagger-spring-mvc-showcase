package shopping.service.showcase;

import java.util.List;

import org.springframework.util.AutoPopulatingList;

public class SpecialOrder {
    
    private String name;
    private String telno;
    private String address;
    
    // 자동으로 자라주세요!
    private List<OrderItem> items = new AutoPopulatingList<OrderItem>(OrderItem.class);

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTelno() {
        return telno;
    }
    public void setTelno(String telno) {
        this.telno = telno;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

}
