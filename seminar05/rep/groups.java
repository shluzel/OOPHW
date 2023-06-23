package seminar05.rep;

import seminar05.model.group;

import java.util.List;

public interface groups<T extends group> {
    
    List<T> getAll();
    void add(T t);
    void remove(String teamName);
    Long getMaxId();
}
