package seminar02.operations;

public class multiplication extends operation implements calc {
    public multiplication() {
        super();
    }

    public float calculate() {
        System.out.println("Умножение...");
        float result = super.getfirstnum() * super.getsecondnum();
        System.out.printf("Результат: %.2f\n", result);
        return result;
    }
}
