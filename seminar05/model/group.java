package seminar05.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class group {
    private final Long id;
    private String groupName;
    private int maxStudents;
    private int maxTeachers;
    private List<student> studentRoster;
    private List<teacher> teacherRoster;
}
