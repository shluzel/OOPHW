package seminar01;

import java.util.Comparator;

public class comparable implements Comparator<hotdrink> {
     public int compare(hotdrink drink1, hotdrink drink2) {
        int resultOfComparing = Long.valueOf(drink1.getprice()).compareTo(Long.valueOf(drink2.getprice()));
            return resultOfComparing;
        }
}

