package seminar04.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class teacher extends user implements Comparable<teacher> {

    private String degree;

    public teacher(Long id, String fullName, Integer age, String phone) {
        super(id, fullName, age, phone);
    }

    @Override
    public int compareTo(teacher o) {
        return getFullName().compareTo(o.getFullName());
    }

    @Override
    public String toString() {
        return String.format("%s %18s %2s %8s"
                , getId()
                , getFullName()
                , getAge()
                , getPhone());
    }
}
