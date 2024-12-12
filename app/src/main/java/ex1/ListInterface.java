package ex1;

import java.util.NoSuchElementException;

public interface ListInterface<T> {
    
    public boolean isEmpty();

    public void insertAtFront(T item);

    public void insertAtBack(T item);

    public T removeFromFront() throws NoSuchElementException;
    
    public T removeFromBack() throws NoSuchElementException;

    public String toString();
}
