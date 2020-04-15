import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;

import org.junit.jupiter.params.provider.ValueSource;

import javax.management.ConstructorParameters;
import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.util.stream.Stream;

class PriorityQueueTest{

    @ParameterizedTest
    @MethodSource("QueueProvider")
    void isEqual(int[] input, int[] expected) {
        List<Integer> inputList = new ArrayList<Integer>(input.length);
        for(int i =0;i<input.length;i++)inputList.add(input[i]);
        PriorityQueue<Integer> theResult = new PriorityQueue<Integer>(inputList);

        List<Integer> expectedList = new ArrayList<Integer>(expected.length);
        for(int i =0;i<expected.length;i++)expectedList.add(expected[i]);

        boolean comparedResult = true;
        for(int i = 0 ; i<input.length;i++){
            int expectedElement = expectedList.remove(0);
            int queuePopElement = theResult.poll();
            if( queuePopElement!= expectedElement){
                comparedResult = false;
;            }
        }
        assertTrue(comparedResult);
    }

    private static Stream<Arguments> QueueProvider() {
        return Stream.of(
                //  test,correctAnswer
                Arguments.of(new int[]{1,2,3,4,5,6,8,4}, new int[]{1,2,3,4,4,5,6,8}),
                Arguments.of(new int[]{1,2,1,1,1,2,3,1}, new int[]{1,1,1,1,1,2,2,3}),
                Arguments.of(new int[]{8,9,5,7,1,5,3,3}, new int[]{1,3,3,5,5,7,8,9}),
                Arguments.of(new int[]{5,5,5,5,5,5,5,1}, new int[]{1,5,5,5,5,5,5,5}),
                Arguments.of(new int[]{9,7,6,5,4,3,2,1}, new int[]{1,2,3,4,5,6,7,9})
        );
    }

    @Test
    public void whenExceptionThrown_CapacityTest() {
         Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue temp = new PriorityQueue(-5);
        });
    }
    @Test
    public void whenExceptionThrown_ConstructorTest() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            List<Integer> toTest = new ArrayList<Integer>(5);
            toTest.add(null);
            PriorityQueue temp = new PriorityQueue(toTest);
        });
    }
    @Test
    public void whenExceptionThrown_ArrayTest() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            List<Integer> toTest = new ArrayList<Integer>(5);
            toTest.add(null);
            PriorityQueue temp = new PriorityQueue(toTest);
            temp.toArray();
        });
    }
}