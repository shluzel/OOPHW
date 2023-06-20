package seminar04.controller;

import seminar04.model.user;
import java.util.List;

public interface usercontroller<T extends user>  {
    
    void create(String fullName, Integer age, String phone);
    List<T> getAllUsersSortedByFirstName();
    List<T> getAllUsersSortedByLastName();
    List<T> getAllUsersSortedByAge();
    List<T> getAllUsersSortedById();
    boolean remove(String fullName);
    List<T> getAll();
    void edit(String fullName, Integer age, String phone);
}
