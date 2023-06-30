package seminar07.complex;

public class complexnumber {

    private double real;
    private double imaginary;

    public complexnumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getreal() {
        return real;
    }

    public double getimaginary() {
        return imaginary;
    }

    public complexnumber add(complexnumber other) {
        double sumreal = this.real + other.real;
        double sumimaginary = this.imaginary + other.imaginary;
        return new complexnumber(sumreal, sumimaginary);
    }

    public complexnumber multiply(complexnumber other) {
        double partreal = this.real * other.real - this.imaginary * other.imaginary;
        double partimaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new complexnumber(partreal, partimaginary);
    }

    public complexnumber divide(complexnumber other) {
        double div = other.real * other.real + other.imaginary * other.imaginary;
        double partreal = (this.real * other.real + this.imaginary * other.imaginary) / div;
        double partimaginary = (this.imaginary * other.real - this.real * other.imaginary) / div;
        return new complexnumber(partreal, partimaginary);
    }

    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}