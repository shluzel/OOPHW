package seminar04.model;

import lombok.Getter;
import lombok.ToString;
import seminar04.service.teachergroupiterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@ToString
public class teachergroup implements Iterable<teacher> {
    private final List<teacher> teacherslist;

    public teachergroup() {
        teacherslist = new ArrayList<>();
    }

    public Iterator<teacher> iterator() {
        return new teachergroupiterator(teacherslist);
    }
}
