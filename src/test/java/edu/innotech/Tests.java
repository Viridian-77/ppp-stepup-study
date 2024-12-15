package edu.innotech;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

@ExtendWith(Tests.EducationExtension.class)
public class Tests {
//    @Test
//    public void testRating() {
//        Student s = new Student("vasa");
//        s.addMark(4);
//        StudentRepo sr = Mockito.mock(StudentRepo.class);
//        Mockito.when(sr.getRatingForGradeSum(Mockito.anyInt()))
//                .thenReturn(10);
//        s.setStudentRepo(sr);
//        Assertions.assertEquals(10, s.rating());
//    }
//
//    @RepeatedTest(value = 4, name = "корректные добав")
//    public void test1(RepetitionInfo repetitionInfo) {
//        System.out.println("test " + repetitionInfo.getCurrentRepetition());
//        Student s = new Student("vasa");
//        int num = repetitionInfo.getCurrentRepetition() + 1;
//        s.addMark(num);
//        Assertions.assertEquals(num, s.getMarks().get(0));
//    }
//
//    @ParameterizedTest(name = "некорректные недобав")
//    @MethodSource("edu.innotech.MarksGenerator#integers")
//    public void test2(int x) {
//        System.out.println("test2");
//        Student s = new Student("vasa");
//        Assertions.assertThrows(IllegalArgumentException.class, () -> s.addMark(x));
//    }
//}

class EducationExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Printing before each + context: " + context);
    }
}
