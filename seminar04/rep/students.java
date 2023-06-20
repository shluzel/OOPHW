package seminar04.rep;

import seminar04.model.student;

import java.util.ArrayList;
import java.util.List;

public class students implements users<student> {

    private final List<student> students;

    public students() {
        this.students = new ArrayList<>();
    }

    public List<student> getAll() {
        return students;
    }

    public void add(student student) {
        students.add(student);
    }

    public void remove(String fullName) {
        for (student student : students) {
            if (student.getFullName().equals(fullName)) {
                students.remove(student);
                return;
            }
        }
    }

    public Long getMaxId() {
        Long maxId = 0L;
        for (student student : students) {
            if (student.getId() > maxId) {
                maxId = student.getId();
            }
        }
        return maxId;
    }
}
