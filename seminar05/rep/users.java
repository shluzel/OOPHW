package seminar05.rep;

import seminar05.model.user;

import java.util.List;

public interface users<T extends user> {

    List<T> getAll();
    void add(T t);
    void remove(String name);
    Long getMaxId();
}
