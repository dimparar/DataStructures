package ex1;

public class Node<T> {

    protected T item;
    protected Node<T> next;

    public Node(T item) {
        next = null;
        this.item = item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}