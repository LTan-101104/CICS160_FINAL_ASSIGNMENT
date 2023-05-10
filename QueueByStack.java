import java.util.Stack;
public class QueueByStack<T> {
    private Stack<T> mainStack;
    private Stack<T> supStack;
    QueueByStack(){
        this.mainStack = new Stack<T>();
        this.supStack = new Stack<T>();

    }

    public void enQueue(T e){
        this.mainStack.push(e);
    }

    public T deQueue(){
        while (this.mainStack.size() > 1){
            this.supStack.push(this.mainStack.pop());
        }
        T res = this.mainStack.pop(); // pop the first element out after temporatily pop out all later elements
        while(this.supStack.size() > 0){
            this.mainStack.push(this.supStack.pop());
        }
        return res;
    }

    public T peek(){
        while (this.mainStack.size() > 1){
            this.supStack.push(this.mainStack.pop());
        }
        T res = this.mainStack.peek();
        while(this.supStack.size() > 0){
            this.mainStack.push(this.supStack.pop());
        }
        return res;
    }

    public boolean isEmpty(){
        return (this.mainStack.size() == 0);
    }
}
