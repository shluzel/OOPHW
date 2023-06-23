package seminar05.service.comparator;

import seminar05.model.user;

import java.util.Comparator;

public class usercomparator<T extends user> implements Comparator<T> {

    public int compare(T o1, T o2) {
        String familyName1 = o1.getFullName().split("\\s+")[1];
        String familyName2 = o2.getFullName().split("\\s+")[1];
        return familyName1.compareTo(familyName2);
    }
}
