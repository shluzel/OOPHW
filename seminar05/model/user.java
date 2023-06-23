package seminar05.model;
import lombok.Data;

@Data
public class user {
    private final Long id;
    private final String fullName;
    private final Integer age;
    private final String phone;
}
