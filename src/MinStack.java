import java.util.ArrayList;
import java.util.Collections;

class MinStack {
    ArrayList<Integer> minStack = new ArrayList<Integer>();
    public MinStack() {
        this.minStack = minStack;
    }

    public void push(int val) {
        this.minStack.add(val);
    }

    public void pop() {
        this.minStack.remove(this.minStack.size()-1);
    }

    public int top() {
        return (int) this.minStack.get(this.minStack.size()-1);
    }

    public int getMin() {
        ArrayList another = (ArrayList) this.minStack.clone();
        Collections.sort(another);
        return (int) another.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
