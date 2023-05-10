import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedList;
public class QueueTests {
    
    //TODO: test constructor
    

    //test enQueue
    @Test
    public void enQueueTest(){
        Queue<Integer> testObj = new Queue<>();
        testObj.enQueue(1);
        testObj.enQueue(2);
        testObj.enQueue(3);
        LinkedList<Integer> test = new LinkedList<>();
        for (int i = 1; i < 4; i++){
            test.add(i);
        }

        assertEquals(testObj.getInternalList(), test);
        test.remove(0);
        assertNotEquals(testObj.getInternalList(), test);
    }

    @Test
    public void enQueueTest2(){
        Queue<String> testObj = new Queue<>();
        testObj.enQueue("Hello");
        assertEquals(testObj.getInternalList().get(0), "Hello");
        testObj.enQueue("Test");
        assertEquals(testObj.getInternalList().get(1), "Test");
    }


    @Test
    public void deQueueTest1(){
        Queue<String> testObj = new Queue<>();
        testObj.enQueue("Hello");
        testObj.enQueue("Test");
        testObj.enQueue("World");
        assertEquals(testObj.deQueue(), "Hello");
    }

    @Test
    public void deQueueTest2(){
        Queue<String> testObj = new Queue<>();
        testObj.enQueue("Hello");
        testObj.enQueue("Test");
        testObj.enQueue("World");
        testObj.deQueue();
        assertEquals(testObj.getInternalList().get(0), "Test");
    }

    @Test
    public void testPeek1(){
        Queue<String> testObj = new Queue<>();
        testObj.enQueue("Hello");
        testObj.enQueue("Test");
        testObj.enQueue("World");
        assertEquals(testObj.peek(), "Hello");
    }

    @Test
    public void testPeek2(){
        Queue<String> testObj = new Queue<>();
        testObj.enQueue("Hello");
        testObj.enQueue("Test");
        testObj.enQueue("World");
        testObj.deQueue();
        assertEquals(testObj.peek(), "Test");
    }


    @Test
    public void testisEmpty(){
        Queue<String> testObj = new Queue<>();
        testObj.enQueue("Hello");
        testObj.enQueue("Test");
        testObj.enQueue("World");
        assertFalse(testObj.isEmpty());
    }

    @Test
    public void testIsEmpty2(){
        Queue<String> testObj = new Queue<>();
        assertTrue(testObj.isEmpty());
    }

}
