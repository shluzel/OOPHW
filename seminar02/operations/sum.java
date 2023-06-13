package seminar02.operations;

public class sum extends operation implements calc{
    public sum() {
        super();
    }

    public float calculate() {
        System.out.println("Сложение...");
        float result = super.getfirstnum() + super.getsecondnum();
        System.out.printf("Результат: %.2f\n", result);
        return result;
    }
}
