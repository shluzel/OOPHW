package seminar07.calculations;

import seminar07.complex.complexnumber;
import seminar07.message.message;

public class complexcalculator implements calculator{

    private message message;

    public complexcalculator(message message) {
        this.message = message;
    }

    public complexnumber add(complexnumber firstnum, complexnumber secondnum) {
        complexnumber result = firstnum.add(secondnum);
        message.log("Summary: " + firstnum + " + " + secondnum + " = " + result);
        return result;
    }

    public complexnumber multiply(complexnumber firstnum, complexnumber secondnum) {
        complexnumber result = firstnum.multiply(secondnum);
        message.log("Multiplication: " + firstnum + " * " + secondnum + " = " + result);
        return result;
    }

    public complexnumber divide(complexnumber firstnum, complexnumber secondnum) {
        complexnumber result = firstnum.divide(secondnum);
        message.log("Division: " + firstnum + " / " + secondnum + " = " + result);
        return result;
    }
}