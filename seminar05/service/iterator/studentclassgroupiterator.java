package seminar05.service.iterator;

import seminar05.model.studentclass;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class studentclassgroupiterator implements Iterator<studentclass> {

    private final List<studentclass> studentClasses;
    private int position;

    public studentclassgroupiterator(List<studentclass> studentClasses) {
        this.studentClasses = studentClasses;
    }

    public boolean hasNext() {
        return position < studentClasses.size();
    }

    public studentclass next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return studentClasses.get(position++);
    }

    public void remove() {
        studentClasses.remove(position - 1);
    }
}
