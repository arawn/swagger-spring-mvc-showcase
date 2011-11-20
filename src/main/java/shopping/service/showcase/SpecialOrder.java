package shopping.service.showcase;

public class SpecialOrder {
    
    private String name;
    private String telno;
    private String address;
    
    private String[] colors;
    private int[] quantitys;
    
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
    public String[] getColors() {
        return colors;
    }
    public void setColors(String[] colors) {
        this.colors = colors;
    }
    public int[] getQuantitys() {
        return quantitys;
    }
    public void setQuantitys(int[] quantitys) {
        this.quantitys = quantitys;
    }

}
