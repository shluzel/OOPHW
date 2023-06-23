package seminar05.controller;

import seminar05.model.user;
import java.util.List;

public interface usercontroller<T extends user>  {
    
    void create(String fullName, Integer age, String phone);
    void createRandom(Integer quantity);
    List<T> getAllUsersSortedByFirstName();
    List<T> getAllUsersSortedByLastName();
    List<T> getAllUsersSortedByAge();
    List<T> getAllUsersSortedById();
    boolean remove(String fullName);
    List<T> getAll();
    void edit(String fullName, Integer age, String phone);
}
