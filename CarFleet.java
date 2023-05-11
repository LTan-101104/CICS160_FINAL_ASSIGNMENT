import java.util.HashMap;
import java.util.ArrayList;

public class CarFleet {
    private Queue<Car> gasQueue;
    private Queue<Car> hyQueue;
    private Queue<Car> EQueue;
    private HashMap<Integer, Queue<Car>> CmdToCar;

    CarFleet(){
        this.gasQueue = new Queue<>();
        this.hyQueue = new Queue<>();
        this.EQueue = new Queue<>();
        this.CmdToCar = new HashMap<Integer, Queue<Car>>();
        // add key-value pair to use the hash map later
        this.CmdToCar.put(1, this.gasQueue);
        this.CmdToCar.put(2, this.hyQueue);
        this.CmdToCar.put(3, this.EQueue);
    }

    public boolean addCar(Car obj){
        int powerSource = obj.getPowerSource();
        if (! this.CmdToCar.containsKey(powerSource)) return false;
        this.CmdToCar.get(powerSource).enqueue(obj);
        return true;
    }

    public ArrayList<Car> processRequests(Queue<Integer> cmd){
        ArrayList<Car> res = new ArrayList<Car>();
        while (!cmd.isEmpty()){
            int pS = cmd.dequeue();
            if (!(this.CmdToCar.containsKey(pS)) || this.CmdToCar.get(pS).isEmpty()) {
                Car obj = new Car(0, 0,0.0f);
                res.add(obj);
                continue;
            }
            res.add(this.CmdToCar.get(pS).dequeue());
        }
        return res;
    }

    public Queue<Car> getQueue(int cmd){
        if (this.CmdToCar.containsKey(cmd)) return this.CmdToCar.get(cmd);
        return null;
    }
    
    
}
