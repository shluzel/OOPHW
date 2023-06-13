package seminar02.operations;

import java.util.Scanner;

public abstract class operation implements calc{
    operation() {
    }
    private float firstnum;
    private float secondnum;

    float getfirstnum() {
        return firstnum;
    }
    //body for our operations
    public void setfirstnum(Scanner scan) {
        System.out.println("Введите первое число: ");
        this.firstnum = scan.nextFloat();
    }

    float getsecondnum() {
        return secondnum;
    }

    public void setsecondnum(Scanner scan) {
        System.out.println("Введите второе число: ");
        this.secondnum = scan.nextFloat();
    }
}

