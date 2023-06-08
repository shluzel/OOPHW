package seminar01;

import java.util.ArrayList;
import java.util.List;

public class hotdrinkvendingmachine implements vendingmachine {

    private final List<hotdrink> list;

    public hotdrinkvendingmachine() {
        list = new ArrayList<>();
    }

    public void addproduct(product product) {
        list.add((hotdrink) product);
    }

    public product getproduct(String name) {
        for (product product : list) {
            if (name.equals(product.getname())){
                return product;
            }
        }
        return null;
    }

    public hotdrink getproduct(String name, Integer volume, Integer temp) {
        for (hotdrink product : list) {
            if (name.equals(product.getname())
                    && volume.equals(product.getvolume())
                    && temp.equals(product.gettemp()) ){
                return product;
            }
        }
        return null;
    }

}