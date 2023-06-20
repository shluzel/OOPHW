package seminar04.controller;

import seminar04.model.teacher;
import seminar04.service.teacherservice;
import seminar04.service.userservice;

import java.util.List;

public class teachercontroller {

    public userservice<teacher> teacherservice;

    public teachercontroller(teacherservice teacherservice) {
        this.teacherservice = teacherservice;
    }

    public void create(String fullName, Integer age, String phone) {
        teacherservice.create(fullName, age, phone);
    }

    public List<teacher> getAllUsersSortedByFirstName() {
        return teacherservice.getAllUsersSortedByFirstName();
    }

    public List<teacher> getAllUsersSortedByLastName() {
        return teacherservice.getAllUsersSortedByLastName();
    }

    public List<teacher> getAllUsersSortedByAge() {
        return teacherservice.getAllUsersSortedByAge();
    }

    public List<teacher> getAllUsersSortedById() {
        return teacherservice.getAllUsersSortedById();
    }

    public boolean remove(String fullName) {
        teacherservice.remove(fullName);
        return true;
    }

    public List<teacher> getAll() {
        return teacherservice.getAll();
    }

    public void edit(String fullName, Integer age, String phone) {
        teacherservice.edit(fullName, age, phone);
    }

}
