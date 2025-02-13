import java.util.*;

class Stack {
    int size;
    int arr[];
    int top;

    public Stack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + data);
            return;
        }
        arr[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is already empty!");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

class Queue {
    private Stack s1, s2;

    public Queue(int size) {
        s1 = new Stack(size);
        s2 = new Stack(size);
    }

    public void enqueue(int data) {
        if (s1.isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }

        s1.push(data);
    }

    public int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void display() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue: ");

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        for (int i = 0; i <= s2.top; i++) {
            System.out.print(s2.arr[i] + " ");
        }

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        System.out.println();
    }

}

public class QueueUsingStack {
    public static void main(String[] args) {

        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.display();
        q.dequeue();
        q.display();
    }
}
