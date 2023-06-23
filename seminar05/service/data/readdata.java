package seminar05.service.data;

import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class readdata {
    
    private final List<String> loadedMenFirstNames;
    private final List<String> loadedMenLastNames;
    private final List<String> loadedWomenFirstNames;
    private final List<String> loadedWomenLastNames;
    private final List<String> fileNames;
    private final List<List<String>> listNames;
    private final List<String> studentClassNames;

    private final String pathToFiles = "./seminar05/service/data/";

    public readdata() throws IOException {
        this.loadedMenFirstNames = new ArrayList<>();
        this.loadedMenLastNames = new ArrayList<>();
        this.loadedWomenFirstNames = new ArrayList<>();
        this.loadedWomenLastNames = new ArrayList<>();
        this.fileNames = new ArrayList<>();
        this.listNames = new ArrayList<>();
        this.studentClassNames = new ArrayList<>();

        fileNames.add("menfirstnames.txt");
        listNames.add(loadedMenFirstNames);
        fileNames.add("menlastnames.txt");
        listNames.add(loadedMenLastNames);
        fileNames.add("womenfirstnames.txt");
        listNames.add(loadedWomenFirstNames);
        fileNames.add("womenlastnames.txt");
        listNames.add(loadedWomenLastNames);
        fileNames.add("studentclass.txt");
        listNames.add(studentClassNames);

        for (int i = 0; i < fileNames.size(); i++) {
            BufferedReader br = new BufferedReader(new FileReader(pathToFiles+fileNames.get(i)));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    listNames.get(i).add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
