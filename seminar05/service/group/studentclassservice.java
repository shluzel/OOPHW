package seminar05.service.group;

import seminar05.model.student;
import seminar05.model.studentclass;
import seminar05.model.teacher;
import seminar05.model.group;
import seminar05.rep.studentsclass;
import seminar05.rep.students;
import seminar05.rep.teachers;
import seminar05.rep.groups;
import seminar05.service.data.studentclassesload;
import seminar05.service.comparator.studentclasscomparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class studentclassservice implements groupservice<studentclass>{

    private final Random random;

    private final groups<studentclass> studentClassRepository;
    private final students studentRepository;
    private final teachers teacherRepository;

    public studentclassservice() {
        this.random = new Random();
        this.studentClassRepository = studentClassRepository.getInstance();
        this.studentRepository = students.getInstance();
        this.teacherRepository = teachers.getInstance();
    }

    public void create(String groupName) {
        for (studentclass studentClass : studentClassRepository.getAll()) {
            if (studentClass.getGroupName().equals(groupName)) {
                System.out.println("(createStudentClass:)'" + groupName + "' <- запись уже существует");
                return;
            }
        }
        Long id = studentClassRepository.getMaxId() + 1;
        int maxStudents = 30;
        int maxTeachers = 1;
        studentclass studentClass = new studentclass(id, groupName, maxStudents, maxTeachers,
                new ArrayList<>(), new ArrayList<>());
        studentClassRepository.add(studentClass);
    }

    public void createAndPopulate(String groupName) {
        create(groupName);
        populateStudentClassById(getStudentClassByName(groupName).getId());
    }

    public void populateStudentClassById(Long id) {
        studentclass studentClass = getStudentClassById(id);
        int freeTeacherSlots = studentClass.getMaxTeachers() - studentClass.getTeacherRoster().size();
        int freeStudentSlots = studentClass.getMaxStudents() - studentClass.getStudentRoster().size();

        if (freeTeacherSlots > 0 && getAvailableTeachers().size() > 0) {
            do {
                addTeacher(getAvailableTeachers().get(random.nextInt(getAvailableTeachers().size())).getId(), id);
                freeTeacherSlots = studentClass.getMaxTeachers() - studentClass.getTeacherRoster().size();
            } while (freeTeacherSlots > 0 && getAvailableTeachers().size() > 0);
        }
        if (freeStudentSlots > 0 && getAvailableStudents().size() > 0) {
            do {
                addStudent(
                        getAvailableStudents().
                                get(random.nextInt(getAvailableStudents().size())).getId(), id);
                freeStudentSlots = studentClass.getMaxStudents() - studentClass.getStudentRoster().size();
            } while (freeStudentSlots > 0 && getAvailableStudents().size() > 0);
        }
    }


    public void load() {
        try {
            studentclassesload classLoader = new studentclassesloader();
            for (int i = 0, max = classLoader.getData().size(); i < max; i++) {
                create(classLoader.getData().get(i));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<studentclass> getAll() {
        return studentClassRepository.getAll();
    }

    public studentclass getStudentClassById(Long id) {
        for (studentclass studentClass : studentClassRepository.getAll()) {
            if (studentClass.getId().equals(id)) {
                return studentClass;
            }
        }
        System.out.println("(DB/StudentGroup:) <- id '" + id + "' не найден");
        return null;
    }

    public studentclass getStudentClassByName(String groupName) {
        for (studentclass studentClass : studentClassRepository.getAll()) {
            if (studentClass.getGroupName().equals(groupName)) {
                return studentClass;
            }
        }
        System.out.println("(DB/StudentGroup:) <- teamName '" + groupName + "' не найден");
        return null;
    }

    public void addTeacher(Long teacherId, Long studentClassId) {
        teacher teacher = null;
        studentclass studentClass = null;
        for (teacher aTeacher : teacherRepository.getAll()) {
            if (aTeacher.getId().equals(teacherId)) {
                teacher = aTeacher;
                break;
            }
        }
        if (teacher == null) {
            System.out.println("(addTeacher:) teacherId '" + teacherId + "' <- запись не найдена");
            return;
        }
        if (teacher.getGroup_id() != null) {
            System.out.println("(addTeacher:) teacherId '" + teacherId + "'-'" + teacher.getFullName()
                    + "' <- уже добавлен в группу '" + teacher.getGroup_id() + "'");
            return;
        }
        for (studentclass aStudentClass : studentClassRepository.getAll()) {
            if (aStudentClass.getId().equals(studentClassId)) {
                studentClass = aStudentClass;
            }
        }
        if (studentClass == null) {
            System.out.println("(addTeacher:) studentClassId '" + studentClassId + "' <- запись не найдена");
            return;
        }
        if (studentClass.getTeacherRoster().size() >= studentClass.getMaxTeachers()) {
            System.out.println("(addTeacher:) studentClassId '" + studentClassId
                    + "' <- уже имеет максимальное число преподавателей");
            return;
        }
        studentClass.getTeacherRoster().add(teacher);
        teacher.setGroup_id(studentClassId);
    }

    public void addTeacher(String teacherName, Long studentClassId) {
    }

    public void addStudent(Long studentId, Long studentClassId) {
        student student = null;
        studentclass studentClass = null;
        for (student aStudent : studentRepository.getAll()) {
            if (aStudent.getId().equals(studentId)) {
                student = aStudent;
                break;
            }
        }
        if (student == null) {
            System.out.println("(addStudent:) studentId '" + studentId + "' <- запись не найдена");
        }
        if (student != null && student.getGroup_id() != null) {
            System.out.println("(addStudent:) studentId '" + studentId + "'-'" + student.getFullName()
                    + "' <- уже добавлен в группу '" + student.getGroup_id() + "'");
            return;
        }
        for (studentclass aStudentClass : studentClassRepository.getAll()) {
            if (aStudentClass.getId().equals(studentClassId)) {
                studentClass = aStudentClass;
            }
        }
        if (studentClass == null) {
            System.out.println("(addStudent:) studentClassId '" + studentClassId + "' <- запись не найдена");
            return;
        }
        if (studentClass.getStudentRoster().size() >= studentClass.getMaxStudents()) {
            System.out.println("(addStudent:) studentClassId '" + studentClassId
                    + "' <- уже имеет максимальное число студентов");
            return;
        }
        studentClass.getStudentRoster().add(student);
        assert student != null;
        student.setGroup_id(studentClassId);
    }

    public void addStudent(String studentName, Long studentClassId) {
    }

    public void setStudentClassTeacherLimitById(Long id, int limit) {
        getStudentClassById(id).setMaxTeachers(limit);
    }

    public Long getStudentClassIdByUserName(String fullName) {
        for (teacher teacher : teacherRepository.getAll()) {
            if (teacher.getFullName().equals(fullName)) {
                return teacher.getGroup_id();
            }
        }
        for (student student : studentRepository.getAll()) {
            if (student.getFullName().equals(fullName)) {
                return student.getGroup_id();
            }
        }
        return null;
    }

    public List<student> getStudentClassStudentsList(studentclass studentClass) {
        List<student> students = new ArrayList<>();
        for (student student : studentRepository.getAll()) {
            if (student.getGroup_id() != null && student.getGroup_id().equals(studentClass.getId())) {
                students.add(student);
            }
        }
        return students;
    }

    public List<teacher> getStudentClassTeachersList(studentclass studentClass) {
        List<teacher> teachers = new ArrayList<>();
        for (teacher teacher : teacherRepository.getAll()) {
            if (teacher.getGroup_id() != null && teacher.getGroup_id().equals(studentClass.getId())) {
                teachers.add(teacher);
            }
        }
        return teachers;
    }

    public List<studentclass> getAllTeamsSortedById() {
        List<studentclass> studentClasses = studentClassRepository.getAll();
        studentClasses.sort(Comparator.comparing(group::getId));
        return studentClasses;
    }

    public List<studentclass> getAllTeamsSortedByTeamName() {
        List<studentclass> studentClasses = studentClassRepository.getAll();
        studentClasses.sort(new studentclasscomparator<>());
        return studentClasses;
    }

    public void remove(String groupName) {
        studentClassRepository.remove(groupName);
    }

    public List<student> getAvailableStudents() {
        List<student> studentList = new ArrayList<>();
        for (student student : studentRepository.getAll()) {
            if (student.getGroup_id() == null) {
                studentList.add(student);
            }
        }
        return studentList;
    }

    public List<teacher> getAvailableTeachers() {
        List<teacher> teacherList = new ArrayList<>();
        for (teacher teacher : teacherRepository.getAll()) {
            if (teacher.getGroup_id() == null) {
                teacherList.add(teacher);
            }
        }
        return teacherList;
    }

}
