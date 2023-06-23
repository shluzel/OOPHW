package seminar05.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
    
@Getter
@EqualsAndHashCode(callSuper = true)
public class studentclass extends group implements Comparable<studentclass> {

    public studentclass(Long id,
                        String groupName,
                        int maxStudents,
                        int maxTeachers,
                        List<student> studentRoster,
                        List<teacher> teacherRoster
                        ) {
        super(id, groupName, maxStudents, maxTeachers, studentRoster, teacherRoster);
    }

    public int compareTo(studentclass o) {
        return getGroupName().compareTo(o.getGroupName());
    }

    public String toString() {
        return String.format("%3s %22s  %s/%s  %2s/%2s"
                , getId()
                , getGroupName()
                , getTeacherRoster().size()
                , getMaxTeachers()
                , getStudentRoster().size()
                , getMaxStudents()
                );
    }
}
