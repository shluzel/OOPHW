package seminar04.task;

import seminar04.controller.usercontroller;
import seminar04.model.teacher;

import java.util.List;

public class teacherview implements userview<teacher> {
    
    usercontroller<teacher> controller;

    public teacherview(usercontroller<teacher> controller) {
        this.controller = controller;
    }

    public void sendOnConsole(String sortType) {
        int separatorLength = 32;
        List<teacher> groupteachers = switch (sortType) {
            case SortType.NONE -> controller.getAll();
            case SortType.ID -> controller.getAllUsersSortedById();
            case SortType.FIRSTNAME -> controller.getAllUsersSortedByFirstName();
            case SortType.LASTNAME -> controller.getAllUsersSortedByLastName();
            case SortType.AGE -> controller.getAllUsersSortedByAge();
            default -> null;
        };
        if (groupteachers == null) {
            System.out.println("teachers is null");
            return;
        }
        System.out.println("-".repeat(separatorLength));
        for (teacher teacher : groupteachers) {
            System.out.println(teacher);
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
