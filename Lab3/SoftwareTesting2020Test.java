import jdk.jfr.StackTrace;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SoftwareTesting2020Test {
    Student student = new Student();
    SoftwareTesting2020 softwareTesting2020 = new SoftwareTesting2020();
    @Test
    public void test_a() throws InterruptedException {
        class DateStub extends Date{
            @Override
            public int getWeekday(){return 4;}
        }
        Date date;
        SoftwareTesting2020 test = new SoftwareTesting2020();
        test.date = new DateStub();
        Hospital mockHospital = mock(Hospital.class);
        test.hospital = mockHospital;
        test.enterClass(student);
        verify(test.hospital,times(0)).treatment(student);
    }

    @Test
    public void test_b()throws InterruptedException {
        class DateStub extends Date{
            @Override
            public int getWeekday(){return 5;}
        }
        Date date;
        SoftwareTesting2020 test = new SoftwareTesting2020();
        test.date = new DateStub();
        Hospital mockHospital = mock(Hospital.class);
        test.hospital = mockHospital;
        when(mockHospital.treatment(any())).thenReturn("After a long time treatment. The student can get out! ^__^");
        assertEquals("After a long time treatment. The student can get out! ^__^",test.enterClass(student));
        //verify(test.hospital,times(0)).treatment(student);
    }
    @Test
    public void test_c()throws InterruptedException {
        class DateStub extends Date{
            @Override
            public int getWeekday(){return 5;}
        }
        SoftwareTesting2020 test = new SoftwareTesting2020();
        Date date;
        test.date = new DateStub();

        Hospital spyHospital = spy(Hospital.class);
        doNothing().when(spyHospital).isolation(any());
        test.hospital = spyHospital;

        Student st1 = new Student();
        Student st2 = new Student();
        Student st3 = new Student();

        test.enterClass(st1);
        test.enterClass(st2);
        test.enterClass(st3);

        ArrayList testArray = test.hospital.getLog();
        assertEquals(testArray.size(),3);
    }
    @Test
    public void test_d()throws InterruptedException{
        SoftwareTesting2020 test = new SoftwareTesting2020();
        test.MyDatabase = mock(NCTUDatabase.class);
        when(test.MyDatabase.getScore(any())).thenReturn(90);
        Student st1 = new Student();
        int score = test.getScore(st1.getStudentId());
        assertEquals(90,score);
    }
    @Test
    public void test_e()throws InterruptedException{
        class MyService implements paypalService{
            @Override
            public String doDonate() {
                return "successed";
            }
        }
        SoftwareTesting2020 test = new SoftwareTesting2020();
        paypalService payService = new MyService();

        assertEquals("Thanks you",test.donate(payService));
    }
}