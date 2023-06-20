package seminar04.service;

import seminar04.model.student;
import seminar04.model.user;
import seminar04.rep.students;
import seminar04.rep.users;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class studentservice implements userservice<student> {

    private final users<student> students;

    public studentservice(students students) {
        this.students = students;
    }

    public void create(String fullName, Integer age, String phone) {
        for (student student : students.getAll()) {
            if (student.getFullName().equals(fullName)) {
                System.out.println("(create:)'"+fullName+ "' <- запись уже существует");
                return;
            }
        }
        Long id = students.getMaxId() + 1;
        student student = new student(id, fullName, age, phone);
        students.add(student);
    }

    public List<student> getAll() {
        return students.getAll();
    }


    public List<Student> getAllUsersSortedByFirstName() {
        List<student> groupstudents = students.getAll();
        Collections.sort(groupstudents);

        return groupstudents;
    }

    public List<student> getAllUsersSortedByLastName() {
        List<student> groupstudents = students.getAll();
        groupstudents.sort(new usercomparator<>());

        return groupstudents;
    }

    public List<student> getAllUsersSortedByAge() {
        List<student> groupstudents = students.getAll();
        groupstudents.sort((Comparator.comparing(user::getAge)));

        return groupstudents;
    }

    public List<student> getAllUsersSortedById() {
        List<student> groupstudents = students.getAll();
        groupstudents.sort((Comparator.comparing(user::getId)));

        return groupstudents;
    }

    public void remove(String fullName) {
        students.remove(fullName);
    }

    public void edit(String fullName, Integer age, String phone) {
        for (student student : students.getAll()) {
            if (student.getFullName().equals(fullName)) {
                System.out.println("(редактирование:)'"+fullName+ "' <- запись найдена");
                System.out.println("(редактирование:)*поля возраст и телефон обновлены*");
                Long id = student.getId();
                students.remove(fullName);
                student editedStudent = new student(id, fullName, age, phone);
                students.add(editedStudent);
                return;
            }
        }
        System.out.println("(редактирование:)'"+fullName+ "' <- запись не найдена");
    }
    
}
