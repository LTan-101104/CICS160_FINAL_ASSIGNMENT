import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
public class QueueTests {
    
    //test for constructors
    @Test
    public void QueueTest(){
        Queue<Integer> testObj = new Queue<>();
        assertTrue(testObj instanceof Queue);
    }    
    
    @Test
    public void QueueTest1(){
        Queue<Integer> testObj = new Queue<>();
        assertEquals(testObj.getSize(), 0); //check if when created, size of queue will be zero
    }    

    @Test
    public void QueueTest2(){
        Queue<Integer> testObj = new Queue<>();
        assertNotNull(testObj.getInternalList()); //check if when created, the internal list is actually created and exist
    }

    //test enQueue
    @Test
    public void enQueueTest(){
        Queue<Integer> testObj = new Queue<>();
        testObj.enqueue(1);
        testObj.enqueue(2);
        testObj.enqueue(3);
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
        testObj.enqueue("Hello");
        assertEquals(testObj.getInternalList().get(0), "Hello");
        testObj.enqueue("Test");
        assertEquals(testObj.getInternalList().get(1), "Test");
    }


    @Test
    public void deQueueTest1(){
        Queue<String> testObj = new Queue<>();
        testObj.enqueue("Hello");
        testObj.enqueue("Test");
        testObj.enqueue("World");
        assertEquals(testObj.dequeue(), "Hello");
    }

    @Test
    public void deQueueTest2(){
        Queue<String> testObj = new Queue<>();
        testObj.enqueue("Hello");
        testObj.enqueue("Test");
        testObj.enqueue("World");
        testObj.dequeue();
        assertEquals(testObj.getInternalList().get(0), "Test");
    }

    @Test
    public void testPeek1(){
        Queue<String> testObj = new Queue<>();
        testObj.enqueue("Hello");
        testObj.enqueue("Test");
        testObj.enqueue("World");
        assertEquals(testObj.peek(), "Hello");
    }

    @Test
    public void testPeek2(){
        Queue<String> testObj = new Queue<>();
        testObj.enqueue("Hello");
        testObj.enqueue("Test");
        testObj.enqueue("World");
        testObj.dequeue();
        assertEquals(testObj.peek(), "Test");
    }


    @Test
    public void testisEmpty(){
        Queue<String> testObj = new Queue<>();
        testObj.enqueue("Hello");
        testObj.enqueue("Test");
        testObj.enqueue("World");
        assertFalse(testObj.isEmpty());
    }

    @Test
    public void testIsEmpty2(){
        Queue<String> testObj = new Queue<>();
        assertTrue(testObj.isEmpty());
    }

}
