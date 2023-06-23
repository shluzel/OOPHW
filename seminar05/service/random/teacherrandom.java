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
public class teacherrandom extends readdata{
    
    Random random;

    public teacherrandom() throws IOException {
        this.random = new Random();
    }

    public List<String> getData() {
        List<String> teacherDataList = new ArrayList<>();
        String fullName = "";
        int age = 0;
        String phone = "";
        int gender;

        gender = random.nextInt(2);
        if (gender == 0) {
            fullName = getLoadedWomenFirstNames().get(random.nextInt(getLoadedWomenFirstNames().size()))
                    + " "
                    + getLoadedWomenLastNames().get(random.nextInt(getLoadedWomenLastNames().size()));
            age = random.nextInt(27, 67);
            phone = phonerandom.getPhone();
        }
        if (gender == 1) {
            fullName = getLoadedMenFirstNames().get(random.nextInt(getLoadedMenFirstNames().size()))
                    + " "
                    + getLoadedMenLastNames().get(random.nextInt(getLoadedMenLastNames().size()));
            age = random.nextInt(27, 67);
            phone = phonerandom.getPhone();
        }
        teacherDataList.add(fullName);
        teacherDataList.add(String.valueOf(age));
        teacherDataList.add(phone);

        return teacherDataList;
    }
}
