package seminar02;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Для необходимых вычислений введите подходящий символ:");
        System.out.println("Сложение(+), Вычитание(-), Умножение(*), Деление(/))");

        calculations cal = new calculations();

        try {
            do {
                cal.selectoperation(scan);
                cal.getсurrent().setfirstnum(scan);
                cal.getсurrent().setsecondnum(scan);
                cal.getсurrent().calculate();

            } while(cal.selectnew(scan));
        } finally {
            scan.close();
        }
    }
}
