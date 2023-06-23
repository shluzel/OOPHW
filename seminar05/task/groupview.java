package seminar05.task;

import seminar05.model.group;

public interface groupview<T extends group> {

    void sendOnConsole(String sortType);  
    void sendOnConsole(String sortType, String fullName); 
    void create(String groupName);
    void createAndPopulate(String groupName);
    void populateStudentClassById(Long id);

    void load();
    void remove(String fullName);  
    void addTeacher(Long teacherId, Long studentClassId);
    void addTeacher(String teacherName, Long studentClassId);
    void addStudent(Long studentId, Long studentClassId);
    void addStudent(String studentName, Long studentClassId);

    void setStudentClassTeacherLimitById(Long id, int limit);

    Long getStudentClassIdByUserName(String fullName);
}
