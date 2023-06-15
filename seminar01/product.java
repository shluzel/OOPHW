package seminar01;

public abstract class product {

    private String name;
    private long price;

    public product(String name, long price) {
        this.name = name;
        this.price = price;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public long getprice() {
        return price;
    }
    public void setprice(long price) {
        this.price = price;
    }
}
