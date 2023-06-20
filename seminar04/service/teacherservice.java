package seminar04.service;

import seminar04.model.teacher;
import seminar04.model.user;
import seminar04.rep.teachers;
import seminar04.rep.users;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class teacherservice implements UserService<teacher> {

    private final Users<teacher> teachers;

    public teacherservice(teachers teachers) {
        this.teachers = teachers;
    }

    public void create(String fullName, Integer age, String phone) {
        for (teacher teacher : teachers.getAll()) {
            if (teacher.getFullName().equals(fullName)) {
                System.out.println("(create:)'"+fullName+ "' <- запись уже существует");
                return;
            }
        }
        Long id = teachers.getMaxId() + 1;
        teacher teacher = new Teacher(id, fullName, age, phone);
        teachers.add(teacher);
    }

    public List<teacher> getAll() {
        return teachers.getAll();
    }

    public List<teacher> getAllUsersSortedByFirstName() {
        List<teacher> groupteachers = teachers.getAll();
        Collections.sort(groupteachers);

        return groupteachers;
    }

    public List<teacher> getAllUsersSortedByLastName() {
        List<teacher> groupteachers = teachers.getAll();
        groupteachers.sort(new usercomparator<>());

        return groupteachers;
    }

    public List<teacher> getAllUsersSortedByAge() {
        List<teacher> groupteachers = teachers.getAll();
        groupteachers.sort((Comparator.comparing(user::getAge)));

        return groupteachers;
    }

    public List<teacher> getAllUsersSortedById() {
        List<teacher> groupteachers = teachers.getAll();
        groupteachers.sort((Comparator.comparing(user::getId)));

        return groupteachers;
    }

    public void remove(String fullName) {
        teachers.remove(fullName);
    }

    public void edit(String fullName, Integer age, String phone) {
        for (teacher teacher : teachers.getAll()) {
            if (teacher.getFullName().equals(fullName)) {
                System.out.println("(редактирование:)'"+fullName+ "' <- запись найдена");
                System.out.println("(редактирование:)*поля возраст и телефон обновлены*");
                Long id = teacher.getId();
                teachers.remove(fullName);
                teacher editedTeacher = new teacher(id, fullName, age, phone);
                teachers.add(editedTeacher);
                return;
            }
        }
        System.out.println("(редактирование:)'"+fullName+ "' <- запись не найдена");
    }
    
}
