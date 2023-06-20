package seminar04.rep;

import seminar04.model.user;

import java.util.List;

public interface users<T extends user> {

    List<T> getAll();
    void add(T t);
    void remove(String name);
    Long getMaxId();
}
