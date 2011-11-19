package shopping.web.showcase.bestseller;

import java.util.Calendar;

public class BestSellerCondition {

    private Integer year;
    private Integer month;
    private Integer page;
    private Integer size;
    
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getMonth() {
        return month;
    }
    public void setMonth(Integer month) {
        this.month = month;
    }
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return year == null;
    }
    
    public void setDefaultValue(int size) {
        setYear(Calendar.getInstance().get(Calendar.YEAR));
        setMonth(Calendar.getInstance().get(Calendar.MONTH) + 1);
        setPage(0); 
        setSize(size);
    }

}
