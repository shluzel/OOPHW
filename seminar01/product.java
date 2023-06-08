package seminar01;

public abstract class product {

    private String name;
    private double price;

    public product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public double getprice() {
        return price;
    }
    public void setprice(double price) {
        this.price = price;
    }
}
