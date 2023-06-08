package seminar01;

public abstract class hotdrink extends product {

    private int volume;
    private int temp;

    public hotdrink(String name, double price, int volume, int temp) {
        super(name, price);
        this.volume = volume;
        this.temp = temp;
    }

    public String toString() {
        return "Горячий напиток " + getname() +
                ", температура:" + gettemp() +
                " °C, объем:" + getvolume() +
                " мл, стоимость:" + getprice() +
                "рублей" +
                '}';
    }

    public int getvolume() {
        return volume;
    }
    public void setvolume(int volume) {
        this.volume = volume;
    }
    public int gettemp() {
        return temp;
    }
    public void settemp(int temp) {
        this.temp = temp;
    }
}
