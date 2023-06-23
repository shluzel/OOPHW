package seminar05.service.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class studentclassesload extends readdata{

    List<String> studentClasses;

    public studentclassesload() throws IOException {
        this.studentClasses = getStudentClassNames();
    }

    public List<String> getData() {
        return this.studentClasses;
    }
}
