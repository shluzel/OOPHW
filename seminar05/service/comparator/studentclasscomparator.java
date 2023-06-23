package seminar05.service;

import seminar05.model.group;

import java.util.Comparator;

public class studentclasscomparator<T extends group> implements Comparator<T> {
    public int compare(T o1, T o2) {
        return o1.getGroupName().compareTo(o2.getGroupName());
    }
}
