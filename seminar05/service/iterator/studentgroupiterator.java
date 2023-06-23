package seminar05.service;

import seminar05.model.student;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class studentgroupiterator implements Iterator<student> {

    private final List<student> studentlist;
    private int position;

    public studentgroupiterator(List<student> studentslist) {
        this.studentlist = studentslist;
    }

    public boolean hasNext() {
        return position < studentlist.size();
    }

    public student next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return studentlist.get(position++);
    }

    public void remove() {
        studentlist.remove(position-1);
    }
}
