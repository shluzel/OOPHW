package seminar02;

import seminar02.operations.*;
import java.util.Scanner;

public class calculations {
   
    private operation currentoperation;
    public calculations() {
    }

    public operation getсurrent() { 
        return currentoperation;
    }

    private void setcurrent(operation currentoperation) { //setting operation
        this.currentoperation = currentoperation;
    }

    public void selectoperation(Scanner scan) {
        System.out.print("Введите символ: ");
        switch (scan.next().charAt(0)) { //user chooses operation or programm keeps asking for right symbol
            case '+':
                this.setcurrent(new sum());
                break;
            case '-':
                this.setcurrent(new substraction());
                break;
            case '*':
                this.setcurrent(new multiplication());
                break;
            case '/':
                this.setcurrent(new division());
                break;
            default:
                System.out.println("Неправильно введена операция.");
                this.selectoperation(scan);
                break;
        }
    }

    public Boolean selectnew(Scanner scan) {
        System.out.println("\nПродолжаем? (y/n) ");
        return (scan.next().equals("y"));
    };

}
