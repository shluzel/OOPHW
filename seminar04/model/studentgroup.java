package seminar04.model;

import lombok.Getter;
import lombok.ToString;
import seminar04.service.studentgroupiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@ToString
public class studentgroup implements Iterable<student>{
    private final List<student> studentslist;

    public studentgroup() {
        studentslist = new ArrayList<>();
    }

    @Override
    public Iterator<student> iterator() {
        return new studentgroupiterator(studentslist);
    }
    
}