package seminar04.task;

import seminar04.controller.usercontroller;
import seminar04.model.student;

import java.util.List;

public class studentview implements userview<student> {

    usercontroller<student> controller;

    public studentview(usercontroller<student> controller) {
        this.controller = controller;
    }

    public void sendOnConsole(String sortType) {
        int separatorLength = 32;
        List<student> groupstudents = switch (sortType) {
            case sorttype.NONE -> controller.getAll();
            case sorttype.ID -> controller.getAllUsersSortedById();
            case sorttype.FIRSTNAME -> controller.getAllUsersSortedByFirstName();
            case sorttype.LASTNAME -> controller.getAllUsersSortedByLastName();
            case sorttype.AGE -> controller.getAllUsersSortedByAge();
            default -> null;
        };
        if (groupstudents == null) {
            System.out.println("students is null");
            return;
        }
        System.out.println("-".repeat(separatorLength));
        for (student student : groupstudents) {
            System.out.println(student);
        }
        System.out.println("-".repeat(separatorLength));
    }

    public void create(String fullName, Integer age, String phone) {
        controller.create(fullName, age, phone);
    }

    public void remove(String fullName) {
        controller.remove(fullName);
    }

    public void edit(String fullName, Integer age, String phone) {
        controller.edit(fullName, age, phone);
    }
}
