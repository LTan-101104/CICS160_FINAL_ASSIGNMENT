import java.util.LinkedList;
public class Queue<T> { // when I did not specify the T type at here, it gave an error. 
    // Seem like to deal with generic type, we always have to create a new class or blueprint for dealing with any type, by specifying the T
    private int size;
    private LinkedList<T> list;

    public Queue(){
        this.size = 0;
        this.list = new LinkedList<T>();
    }

    public int getSize(){
        return this.size;
    }
    
    public void enqueue(T e){
        this.list.add(e);
        this.size ++;
    }

    public T dequeue(){
        this.size --;
        return this.list.removeFirst();
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public T peek(){
        return this.list.peek();
    }

    public LinkedList<T> getInternalList(){
        return this.list;
    }

}
