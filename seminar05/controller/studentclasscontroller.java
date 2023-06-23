package seminar05.controller;

import seminar05.model.user;

import java.util.List;

public interface studentclasscontorller<T extends user> {
    List<T> getAll();
    void add(T t);
    void remove(String name);
    Long getMaxId();
}
