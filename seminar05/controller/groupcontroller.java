package seminar05.controller;

import seminar05.model.student;
import seminar05.model.teacher;
import seminar05.model.group;

import java.util.List;

public interface groupcontroller<T extends group> {

    void create(String groupName);

    void createAndPopulate(String groupName);

    void populateStudentClassById(Long id);

    void load();

    List<T> getAllTeamsSortedById();

    List<T> getAllTeamsSortedByTeamName();

    void remove(String teamName);

    List<T> getAll();

    T getStudentClassById(Long id);

    void addTeacher(Long teacherId, Long studentClassId);

    void addTeacher(String teacherName, Long studentClassId);

    void addStudent(Long studentId, Long studentClassId);

    void addStudent(String studentName, Long studentClassId);

    void setStudentClassTeacherLimitById(Long id, int limit);

    Long getStudentClassIdByUserName(String fullName);

    List<student> getStudentClassStudentsList(T studentClass);

    List<teacher> getStudentClassTeachersList(T studentClass);
}
