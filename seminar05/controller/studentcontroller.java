package seminar05.controller;

import seminar05.model.student;
import seminar05.service.user.studentservice;
import seminar05.service.user.userservice;

import java.util.List;

public class studentcontroller implements usercontroller<student>{

    public userservice<student> studentservice;

    public studentcontroller(studentservice studentservice) {
        this.studentservice = studentservice;
    }

    public void create(String fullName, Integer age, String phone) {
        studentservice.create(fullName, age, phone);
    }

    public List<student> getAllUsersSortedByFirstName() {
        return studentservice.getAllUsersSortedByFirstName();
    }

    public List<student> getAllUsersSortedByLastName() {
        return studentservice.getAllUsersSortedByLastName();
    }

    public List<student> getAllUsersSortedByAge() {
        return studentservice.getAllUsersSortedByAge();
    }

    public List<student> getAllUsersSortedById() {
        return studentservice.getAllUsersSortedById();
    }

    public boolean remove(String fullName) {
        studentservice.remove(fullName);
        return true;
    }

    public List<student> getAll() {
        return studentservice.getAll();
    }

    public void edit(String fullName, Integer age, String phone) {
        studentservice.edit(fullName, age, phone);
    }
}
