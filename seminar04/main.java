package seminar04;

import seminar04.controller.studentcontroller;
import seminar04.controller.teachercontroller;
import seminar04.rep.students;
import seminar04.rep.teachers;
import seminar04.service.studentservice;
import seminar04.service.teacherservice;
import seminar04.task.sorttype;
import seminar04.task.studentview;
import seminar04.task.teacherview;

public class main {
    public static void main(String[] args) {

        studentview studentview = getstudentview();
        teacherview teacherview = getteacherview();


        studentview.create("Иван Иванов", 14, "+7928349176");
        studentview.create("Федор Федоров", 11, "+79238467522");
        studentview.create("Петр Петров", 12, "+79346752736");
        studentview.create("Иван Иванов", 14, "+7928349176");
        studentview.create("Анатолий Анатольев", 13, "+793467273");

        studentview.sendOnConsole(sorttype.AGE);

        teacherview.create("Евгений Архимедов", 40, "+79345235");
        teacherview.create("Леонид Гауссов", 42, "+79123746");
        teacherview.create("Константин Евклидов", 45, "+793429334");
        teacherview.create("Антонина Пифагорова", 36, "+7934762856");
        teacherview.create("Милана Декартова", 34, "+7934728562");
        teacherview.create("Софья Нейманова", 40, "+793756425");

        teacherview.sendOnConsole(sorttype.ID);

    }

    private static studentview getstudentview() {
        students repository = new students();
        studentservice service = new studentservice(repository);
        studentcontroller controller = new studentcontroller(service);
        return new studentview(controller);
    }

    private static teacherview getteacherview() {
        teachers repository = new teachers();
        teacherservice service = new teacherservice(repository);
        teachercontroller controller = new teachercontroller(service);
        return new teacherview(controller);
    }
}
