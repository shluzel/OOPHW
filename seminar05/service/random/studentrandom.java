package seminar05.service.random;

import lombok.Data;
import lombok.EqualsAndHashCode;
import seminar05.service.data.readdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@EqualsAndHashCode(callSuper = true)
public class studentrandom extends readdata {
    
    Random random;

    public studentrandom() throws IOException {
        this.random = new Random();
    }

    public List<String> getData() {
        List<String> studentDataList = new ArrayList<>();
        String fullName = "";
        int age = 0;
        String phone = "";
        int gender;

        gender = random.nextInt(2);
        if (gender == 0) {
            fullName = getLoadedWomenFirstNames().get(random.nextInt(getLoadedWomenFirstNames().size()))
                    + " "
                    + getLoadedWomenLastNames().get(random.nextInt(getLoadedWomenLastNames().size()));
            age = random.nextInt(16, 21);
            phone = phonerandom.getPhone();
        }
        if (gender == 1) {
            fullName = getLoadedMenFirstNames().get(random.nextInt(getLoadedMenFirstNames().size()))
                    + " "
                    + getLoadedMenLastNames().get(random.nextInt(getLoadedMenLastNames().size()));
            age = random.nextInt(16, 21);
            phone = phonerandom.getPhone();
        }
        studentDataList.add(fullName);
        studentDataList.add(String.valueOf(age));
        studentDataList.add(phone);

        return studentDataList;
    }

}
