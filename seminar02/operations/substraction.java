package seminar02.operations;

public class substraction extends operation implements calc {
    public substraction() {
        super();
    }

    public float calculate() {
        System.out.println("Выситание...");
        float result = super.getfirstnum() - super.getsecondnum();
        System.out.printf("Результат: %.2f\n", result);
        return result;
    }
}
