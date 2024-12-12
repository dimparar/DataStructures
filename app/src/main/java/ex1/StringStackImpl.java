package ex1;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl<T> implements StringStack<T> {

    private static final int CAPACITY = 15;
    private ListInterfaceImpl<T> list;
    private int size;

    @SuppressWarnings("unchecked")
    public StringStackImpl() {
        this.list = new ListInterfaceImpl<T>();
        this.size = 0;
    }


    @Override
    public boolean isEmpty() {
        if (this.size == 0) return true;
        
        return false;
    }

    @Override
    public void push(T item) {
        
        this.list.insertAtBack(item);
        size++;
    }

    @Override
    public T pop() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        
        size--;
        return this.list.removeFromBack();
        
    }

    @Override
    public T peek() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        T item = list.removeFromBack();

        list.insertAtBack(item);
        return item;
    }

    @Override
    public void printStack(PrintStream stream) {
        
        if (isEmpty()) stream.println("Stack is empty");
        else stream.println(this.list.toString());
    }

    @Override
    public int size() {
        return this.size;
    }

}