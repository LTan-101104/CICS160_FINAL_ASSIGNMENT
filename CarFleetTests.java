
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class CarFleetTests {
    //Tests for constructor
    @Test
    public void CarFleetTest(){
        CarFleet test = new CarFleet();
        Assert.assertTrue(test instanceof CarFleet); 
    }

    @Test
    public void CarFleetTest2(){
        CarFleet test = new CarFleet();
        Assert.assertNotNull(test.getQueue(1));
        Assert.assertNotNull(test.getQueue(2));
        Assert.assertNotNull(test.getQueue(3));
        Assert.assertNull(test.getQueue(4));
        //check if after constructing, there exists all necessary queue
    }


    @Test
    public void addCarTest1(){
        CarFleet testObj = new CarFleet();
        Car obj = new Car(123, 5, 56.7f);
        Assert.assertFalse(testObj.addCar(obj));
    }

    @Test
    public void addCarTest2(){
        CarFleet testObj = new CarFleet();
        Car obj = new Car(250, 2, 8.9f);
        Assert.assertTrue(testObj.addCar(obj));
    }

    //test getQueue() so that can use getQueue() for later test
    @Test
    public void getQueueTest(){
        CarFleet testObj = new CarFleet();
        Assert.assertNull(testObj.getQueue(4));
    }

    @Test
    public void getQueueTest2(){
        CarFleet testObj = new CarFleet();
        Assert.assertNotNull(testObj.getQueue(2));
    }

    @Test
    public void addCarTest3(){
        CarFleet testObj = new CarFleet();
        Car obj = new Car(26, 3, 78.5f);
        testObj.addCar(obj);
        Assert.assertTrue(testObj.getQueue(3).peek() == obj);
    }

    @Test
    public void processRequestsTest1(){
        CarFleet testObj = new CarFleet();
        Queue<Integer> cmd = new Queue<Integer>();
        cmd.enQueue(5);
        cmd.enQueue(6);
        ArrayList<Car> res = testObj.processRequests(cmd);
        Assert.assertTrue(res.get(0).getId() == 0);
        Assert.assertTrue(res.get(1).getId() == 0);
    }    

    @Test
    public void processRequestsTest2(){
        CarFleet testObj = new CarFleet(); // all empty queue
        Queue<Integer> cmd = new Queue<Integer>(); 
        cmd.enQueue(1);
        cmd.enQueue(2);
        ArrayList<Car> res = testObj.processRequests(cmd);
        Assert.assertTrue(res.get(0).getId() == 0);
        Assert.assertTrue(res.get(1).getId() == 0);            
    }

    @Test
    public void processRequestsTest3(){
        CarFleet testObj = new CarFleet(); 
        Queue<Integer> cmd = new Queue<Integer>(); 
        cmd.enQueue(2);
        cmd.enQueue(2);
        cmd.enQueue(1);
        Car car = new Car(80, 1, 75.4f);
        Car car1 = new Car(57, 2, 8.9f);
        Car car2 = new Car(90, 2, 70.0f);

        testObj.addCar(car);
        testObj.addCar(car1);
        testObj.addCar(car2);

        ArrayList<Car> sampleCars = new ArrayList<Car>();
        sampleCars.add(car1);
        sampleCars.add(car2);
        sampleCars.add(car);
        Assert.assertEquals(testObj.processRequests(cmd), sampleCars);
    }

    @Test
    public void processRequestsTest4(){
        CarFleet testObj = new CarFleet(); 
        Queue<Integer> cmd = new Queue<Integer>(); 
        cmd.enQueue(2);
        cmd.enQueue(5);
        Car car1 = new Car(57, 2, 8.9f);
        Car car2 = new Car(90, 2, 70.0f);
        testObj.addCar(car1);
        testObj.addCar(car2);

        ArrayList<Car> res = testObj.processRequests(cmd);
        Assert.assertTrue(res.get(0).getId() != 0 );
        Assert.assertTrue(res.get(1).getId() == 0);
    }
}
