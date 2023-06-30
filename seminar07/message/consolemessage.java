package seminar07.message;

public class consolemessage implements message{

     public void log(String message) {
        System.out.println("[ConsoleMessage] " + message);
    }
}