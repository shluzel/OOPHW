package seminar05.rep;

import seminar05.model.studentclass;

import java.util.ArrayList;
import java.util.List;

public class studentsclass implements groups<studentclass> {

    private static studentsclass INSTANCE;

    public static studentsclass getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new studentsclass();
        }
        return INSTANCE;
    }

    private final List<studentclass> studentClasses;

    public studentsclass() {
        this.studentClasses = new ArrayList<>();
    }

    public List<studentclass> getAll() {
        return studentClasses;
    }

    public void add(studentclass aStudentClass) {
        studentClasses.add(aStudentClass);
    }

    public void remove(String groupName) {
        for (studentclass studentClass : studentClasses) {
            if (studentClass.getGroupName().equals(groupName)) {
                studentClasses.remove(studentClass);
                return;
            }
        }
    }

    public Long getMaxId() {
        Long maxId = 0L;
        for (studentclass studentClass : studentClasses) {
            if (studentClass.getId() > maxId) {
                maxId = studentClass.getId();
            }
        }
        return maxId;
    }
}
