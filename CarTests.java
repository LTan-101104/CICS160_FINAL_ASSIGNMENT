import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class CarTests {
    //Test for constructors
    @Test
    public void CarTest(){ 
        Car test = new Car(65, 3, 54.5f);
        assertTrue(test instanceof Car);
    }

    @Test
    public void CatTest2(){
        Car test = new Car(65, 3, 54.5f);
        assertEquals(test.getId(), 65);
        assertEquals(test.getPowerSource(), 3);
        assertEquals(test.getPricePerDay(), 54.5f, 0);
        //test if all the assigning values of constructor works fine
    }
    
    @Test
    public void getIdTest(){
        int id = 45;
        Car test = new Car(id, 1, 3.4f);
        assertEquals(test.getId(), id);
    }

    @Test
    public void setIdTest(){
        Car test = new Car (45, 2, 16.6f);
        int id = 50;
        test.setId(id);
        assertEquals(test.getId(), id);
    }

    @Test
    public void getPowerSourceTest(){
        Car test = new Car(45, 1, 3.4f);
        assertEquals(test.getPowerSource(), 1);
    }

    @Test
    public void setPowerSourceTest(){
        Car test = new Car(45, 1, 3.4f);
        test.setPowerSource(3);
        assertEquals(test.getPowerSource(), 3);
    }

    @Test
    public void getPricePerDay(){
        float val = 3.4f;
        Car test = new Car(45, 1, val);
        assertEquals(test.getPricePerDay(), val,0); 
        // the assertEqual does not support comparison between 2 floating point value any more. Instead we use assertEqual(val1, val2, delta) where delta is the maximum difference between 2 val in which it is still considered equal
    }

    @Test
    public void setPricePerDay(){
        Car test = new Car(45, 1, 3.4f);
        test.setPricePerDay(5.6f);
        assertEquals(test.getPricePerDay(), 5.6f, 0);        
    }
}
