package seminar05.rep;

import seminar05.model.teacher;

import java.util.ArrayList;
import java.util.List;

public class teachers implements users<teacher> {
    private final List<teacher> teachers;

    public teachers() {
        this.teachers = new ArrayList<>();
    }

    public List<teacher> getAll() {
        return teachers;
    }

    public void add(teacher teacher) {
        teachers.add(teacher);
    }

    public void remove(String name) {
        for (teacher teacher : teachers) {
            if (teacher.getFullName().equals(name)) {
                teachers.remove(teacher);
                return;
            }
        }
    }

    public Long getMaxId() {
        Long maxId = 0L;
        for (teacher teacher : teachers) {
            if (teacher.getId() > maxId) {
                maxId = teacher.getId();
            }
        }
        return maxId;
    }
}
