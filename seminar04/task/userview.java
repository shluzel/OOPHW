package seminar04.task;

import seminar04.model.user;

public interface userview<T extends user> {
    void sendOnConsole(String sortType);  
    void create(String fullName, Integer age, String phone); 
    void remove(String fullName);
    void edit(String fullName, Integer age, String phone);
}
