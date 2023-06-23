package seminar05.task;

import seminar05.controller.groupcontroller;
import seminar05.model.student;
import seminar05.model.studentclass;
import seminar05.model.teacher;

import java.util.List;

public class studentclassview implements groupview<studentclass>{

    groupcontroller<studentclass> controller;

    public studentclassview(groupcontroller<studentclass> controller) {
        this.controller = controller;
    }

    public void sendOnConsole(String sortType) {
        int separatorLength = 39;
        List<studentclass> studentClasses = switch (sortType) {
            case sorttype.NONE -> controller.getAll();
            case sorttype.TEAM_ID -> controller.getAllTeamsSortedById();
            case sorttype.TEAM_NAME -> controller.getAllTeamsSortedByTeamName();
            default -> null;
        };
        if (studentClasses == null || studentClasses.size() < 1) {
            System.out.println("(DB:) учебные группы отсутствуют");
            return;
        }
        System.out.println("-".repeat(separatorLength));
        System.out.println("Учебные группы:");
        for (studentclass studentClass : studentClasses) {
            System.out.println(studentClass);
        }
        System.out.println("-".repeat(separatorLength));
    }

    public void sendOnConsole(String sortType, String fullName) {
        studentclass studentClass = getStudentClassById(getStudentClassIdByUserName(fullName));
        int separatorLength = 39;
        System.out.println("-".repeat(separatorLength));
        System.out.println("Учебная группа:");
        System.out.println(getStudentClassById(getStudentClassIdByUserName(fullName)));
        System.out.println("Преподаватели:");
        for (teacher teacher : getStudentClassTeachersList(studentClass)) {
            System.out.println(teacher);
        }
        System.out.println("Студенты:");
        for (student student : getStudentClassStudentsList(studentClass)) {
            System.out.println(student);
        }
        System.out.println("-".repeat(separatorLength));
    }

    private List<student> getStudentClassStudentsList(studentclass studentClass) {
        return controller.getStudentClassStudentsList(studentClass);
    }

    private List<teacher> getStudentClassTeachersList(studentclass studentClass) {
        return controller.getStudentClassTeachersList(studentClass);
    }

    public void create(String groupName) {
        controller.create(groupName);
    }

    public void createAndPopulate(String groupName) {
        controller.createAndPopulate(groupName);
    }

    public void populateStudentClassById(Long id) {
        controller.populateStudentClassById(id);
    }

    public void load() {
        controller.load();
    }

    public void remove(String groupName) {
        controller.remove(groupName);
    }

    public void addTeacher(Long teacherId, Long studentClassId) {
        controller.addTeacher(teacherId, studentClassId);
    }

    public void addTeacher(String teacherName, Long studentClassId) {
        controller.addTeacher(teacherName, studentClassId);
    }

    public void addStudent(Long studentId, Long studentClassId) {
        controller.addStudent(studentId, studentClassId);
    }

    public void addStudent(String studentName, Long studentClassId) {
        controller.addStudent(studentName, studentClassId);
    }

    public void setStudentClassTeacherLimitById(Long id, int limit) {
        controller.setStudentClassTeacherLimitById(id, limit);
    }

    public Long getStudentClassIdByUserName(String fullName) {
        return controller.getStudentClassIdByUserName(fullName);
    }

    public studentclass getStudentClassById(Long id) {
        return controller.getStudentClassById(id);
    }

}
