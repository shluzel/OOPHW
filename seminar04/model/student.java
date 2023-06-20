package seminar04.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class student extends user implements Comparable<student>{
    private Double mark;  
    private String tutor; 

    public student(Long id, String fullName, Integer age, String phone) {
        super(id, fullName, age, phone);
    }

    public int compareTo(student o) {
        return getFullName().compareTo(o.getFullName());
    }

    public String toString() {
        return String.format("%s %18s %2s %8s"
                , getId()
                , getFullName()
                , getAge()
                , getPhone());
    }
}