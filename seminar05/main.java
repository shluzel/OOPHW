package seminar05;

import seminar05.service.initialise.init;
import seminar05.service.random.studentclassgrouprandom;
import seminar05.task.sorttype;
import seminar05.task.studentclassview;
import seminar05.task.studentview;
import seminar05.task.teacherview;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        init init = new init();
        studentclassgrouprandom studentClassGroupRandomizer = init.getStudentClassGroupRandomizer();
        studentview studentView = init.studentView;
        teacherview teacherView = init.teacherView;
        studentclassview classView = init.studentClassView;

        studentView.createRandom(14);
        studentView.sendOnConsole(sorttype.ID);
        teacherView.createRandom(2);
        teacherView.sendOnConsole(sorttype.ID);

        classView.createAndPopulate("Айсберг");
        classView.sendOnConsole(sorttype.TEAM_ID);

        classView.setStudentClassTeacherLimitById(1L, 3);
        classView.sendOnConsole(sorttype.TEAM_ID);

        studentView.create("Иван Сидоров", 13, "123-4567");
        studentView.createRandom(250);
        teacherView.createRandom(11);

        studentClassGroupRandomizer.populateAllStudentClasses();
        classView.sendOnConsole(sorttype.TEAM_ID);
    }

}
