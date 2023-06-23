package seminar05.task;

import seminar05.controller.usercontroller;
import seminar05.model.teacher;

import java.util.List;

public class teacherview implements userview<teacher> {
    
    usercontroller<teacher> controller;

    public teacherview(usercontroller<teacher> controller) {
        this.controller = controller;
    }

    public void sendOnConsole(String sortType) {
        int separatorLength = 39;
        List<teacher> teachers = switch (sortType) {
            case sorttype.NONE -> controller.getAll();
            case sorttype.ID -> controller.getAllUsersSortedById();
            case sorttype.FIRSTNAME -> controller.getAllUsersSortedByFirstName();
            case sorttype.LASTNAME -> controller.getAllUsersSortedByLastName();
            case sorttype.AGE -> controller.getAllUsersSortedByAge();
            default -> null;
        };
        if (teachers == null || teachers.size() < 1) {
            System.out.println("(DB:) преподаватели отсутствуют");
            return;
        }
        System.out.println("-".repeat(separatorLength));
        System.out.println("Преподаватели:");
        for (teacher teacher : teachers) {
            System.out.println(teacher);
        }
        System.out.println("-".repeat(separatorLength));
    }

    public void create(String fullName, Integer age, String phoneNumber) {
        controller.create(fullName, age, phoneNumber);
    }

    public void createRandom(Integer quantity) {
        controller.createRandom(quantity);
    }

    public void remove(String fullName) {
        controller.remove(fullName);
    }

    public void edit(String fullName, Integer age, String phone) {
        controller.edit(fullName, age, phone);
    }
}
