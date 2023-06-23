package seminar05.service.initialise;

import lombok.Data;
import lombok.Getter;
import seminar05.controller.studentclasscontroller;
import seminar05.controller.studentcontroller;
import seminar05.controller.teachercontroller;
import seminar05.rep.studentsclass;
import seminar05.rep.students;
import seminar05.rep.teachers;
import seminar05.service.random.studentclassgrouprandom;
import seminar05.service.group.studentclassservice;
import seminar05.service.user.studentservice;
import seminar05.service.user.teacherservice;
import seminar05.task.studentclassview;
import seminar05.task.studentview;
import seminar05.task.teacherview;

import java.io.IOException;

@Data
@Getter
public class init {
    
    private final students studentRepository;
    private final teachers teacherRepository;
    private final studentsclass studentClassRepository;

    private final studentservice studentService;
    private final teacherservice teacherService;
    private final studentclassservice studentClassService;
    private final studentclassgrouprandom studentClassGroupRandomizer;

    public final studentview studentView;
    public final teacherview teacherView;
    public final studentclassview studentClassView;

    public init() throws IOException {
        this.studentRepository = students.getInstance();
        this.teacherRepository = teachers.getInstance();
        this.studentClassRepository = studentsclass.getInstance();
        this.studentService = initStudentService();
        this.teacherService = initTeacherService();
        this.studentClassService = iniStudentClassService();
        this.studentView = initStudentView(studentService);
        this.teacherView = initTeacherView(teacherService);
        this.studentClassView = initStudentClassView(studentClassService);
        this.studentClassGroupRandomizer = new StudentClassGroupRandomizer(this.studentClassService);
    }

    private static studentservice initStudentService() throws IOException {
        return new studentservice();
    }

    private static teacherservice initTeacherService() throws IOException {
        return new teacherservice();
    }

    private static studentclassservice iniStudentClassService() {
        return new studentclassservice();
    }

    private static studentview initStudentView(studentservice studentService) {
        studentcontroller studentController = new studentcontroller(studentService);
        return new studentview(studentController);
    }

    private static teacherview initTeacherView(teacherservice teacherService) {
        teachercontroller teacherController = new teachercontroller(teacherService);
        return new teacherview(teacherController);
    }

    private static studentclassview initStudentClassView(studentclassservice studentClassService) {
        studentclasscontroller studentClassController = new studentclasscontroller(studentClassService);
        return new studentclassview(studentClassController);
    }
}
