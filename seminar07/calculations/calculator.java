package seminar07.calculations;

import seminar07.complex.complexnumber;


public interface calculator {

    complexnumber add(complexnumber firstnum, complexnumber secondnum);

    complexnumber multiply(complexnumber firstnum, complexnumber secondnum);

    complexnumber divide(complexnumber firstnum, complexnumber secondnum);
}