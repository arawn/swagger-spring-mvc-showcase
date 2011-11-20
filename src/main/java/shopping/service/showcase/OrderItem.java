package shopping.service.showcase;

public class OrderItem {

    private String color;
    private int quantity;
    
    public OrderItem() {
    }
    
    public OrderItem(String color, int quantity) {
        this.color = color;
        this.quantity = quantity;
    }
    
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
