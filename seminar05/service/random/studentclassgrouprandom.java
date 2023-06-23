package seminar05.service.random;

import seminar05.model.studentclass;
import seminar05.rep.studentsclass;
import seminar05.service.group.studentclassservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class studentclassgrouprandom {
    
    private final Random random;

    studentsclass studentClassRepository;
    studentclass studentClass;
    studentclassservice studentClassService;

    public studentclassgrouprandom(studentclassservice studentClassService) {
        this.random = new Random();
        this.studentClassRepository = studentsclass.getInstance();
        this.studentClassService = studentClassService;
    }

    public List<studentclass> getAvailableStudentClasses() {
        List<studentclass> studentClasses = new ArrayList<>();
        int freeTeacherSlots, freeStudentSlots;
        for (studentclass studentClass : studentClassRepository.getAll()) {
            freeTeacherSlots = studentClass.getMaxTeachers() - studentClass.getTeacherRoster().size();
            freeStudentSlots = studentClass.getMaxStudents() - studentClass.getStudentRoster().size();
            if (freeTeacherSlots > 0
                    && studentClassService.getAvailableTeachers().size() > 0
                    || freeStudentSlots > 0
                    && studentClassService.getAvailableStudents().size() > 0) {
                studentClasses.add(studentClass);
            }
        }
        return studentClasses;
    }

    public void populateAllStudentClasses() {
        List<studentclass> studentClasses = getAvailableStudentClasses();
        if (studentClasses.size() == 0) {
            System.out.println("(fillAll:) <- все классы укомплектованы");
        }
        if (studentClasses.size() > 0) {
            do {
                studentClass = studentClasses.get(random.nextInt(studentClasses.size()));
                studentClassService.populateStudentClassById(studentClass.getId());
                studentClasses = getAvailableStudentClasses();
            } while (studentClasses.size() > 0);
        }
    }
}
