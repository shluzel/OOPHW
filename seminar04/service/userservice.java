package seminar04.service;

import seminar04.model.user;

import java.util.List;

public interface userservice<T extends user> {

    void create(String fullName, Integer age, String phone);
    List<T> getAll();
    List<T> getAllUsersSortedByFirstName();
    List<T> getAllUsersSortedByLastName();
    List<T> getAllUsersSortedByAge();
    List<T> getAllUsersSortedById();
    void remove(String fullName);
    void edit(String fullName, Integer age, String phone);
}
