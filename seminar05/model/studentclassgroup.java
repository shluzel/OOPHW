package seminar05.model;

import lombok.Getter;
import lombok.ToString;
import seminar05.service.studentclassgroupiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@ToString
public class studentclassgroup implements Iterable<studentclass> {
    
     private final List<studentclass> studentClass;

    public studentclassgroup() {
        this.studentClass = new ArrayList<>();
    }

    public Iterator<StudentClass> iterator() {
        return new studentclassgroupiterator(studentClass);
    }
}
