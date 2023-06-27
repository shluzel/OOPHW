package seminar05.service.iterator;

import seminar05.model.teacher;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class teachergroupiterator implements Iterator<teacher> {

    private final List<teacher> teacherlist;
    private int position;

    public teachergroupiterator(List<teacher> teacherlist) {
        this.teacherlist = teacherlist;
    }

    public boolean hasNext() {
        return position < teacherlist.size();
    }

    public teacher next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return teacherlist.get(position++);
    }

    public void remove() {
        teacherlist.remove(position - 1);
    }
}
