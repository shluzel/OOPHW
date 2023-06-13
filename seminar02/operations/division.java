package seminar02.operations;

public class division extends operation implements calc {
    public division() {
        super();
    }

    public float calculate() {
        System.out.println("Деление...");
        float result = super.getfirstnum() / super.getsecondnum();
        System.out.printf("Результат: %.2f\n", result);
        return result;
    }
}
