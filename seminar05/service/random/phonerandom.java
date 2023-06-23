package seminar05.service.random;

import java.util.Random;

public class phonerandom {
    
    public static String getPhone() {
        Random random = new Random();

        return String.format("%s-%s",
            random.nextInt(100, 1000),
            random.nextInt(1000, 10000)
                );

    }
}
