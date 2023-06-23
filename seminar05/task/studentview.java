package seminar05.task;

import seminar05.controller.usercontroller;
import seminar05.model.student;

import java.util.List;

public class studentview implements userview<student> {

    usercontroller<student> controller;

    public studentview(usercontroller<student> controller) {
        this.controller = controller;
    }

    public void sendOnConsole(String sortType) {
        int separatorLength = 39;
        List<student> students = switch (sortType) {
            case sorttype.NONE -> controller.getAll();
            case sorttype.ID -> controller.getAllUsersSortedById();
            case sorttype.FIRSTNAME -> controller.getAllUsersSortedByFirstName();
            case sorttype.LASTNAME -> controller.getAllUsersSortedByLastName();
            case sorttype.AGE -> controller.getAllUsersSortedByAge();
            default -> null;
        };
        if (students == null || students.size() < 1) {
            System.out.println("(DB:) студенты отсутствуют");
            return;
        }
        System.out.println("-".repeat(separatorLength));
        System.out.println("Студенты:");
        for (student student : students) {
            System.out.println(student);
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
