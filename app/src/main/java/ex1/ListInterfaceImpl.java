package ex1;

import java.util.NoSuchElementException;

public class ListInterfaceImpl<T> implements ListInterface<T> {

    private Node<T> head;
    private Node<T> tail;

    public ListInterfaceImpl() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    // Insert data before the head
    @Override
    public void insertAtFront(T item) {
        Node<T> node = new Node<T>(item);

        if (isEmpty()) {
            head = node;
            tail = node;
        }
        else {
            node.setNext(head);
            head = node;
        }
    }

    // Insert data before after the tail
    @Override
    public void insertAtBack(T item) {
        Node<T> node = new Node<T>(item);

        if (isEmpty()) {
            head = node;
            tail = node;
        }
        else {
            tail.setNext(node);
            tail = node;
        }

    }

    // Remove data before the head
    @Override
    public T removeFromFront() throws NoSuchElementException {
        
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T item = head.getItem();
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            head = head.getNext();
        }

        return item;
    }

    // Remove data after the tail
    @Override
    public T removeFromBack() throws NoSuchElementException {
        
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T item = tail.getItem();
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            Node<T> it = head;
            while (it.getNext() != tail) {
                it = it.getNext();
            }

            it.setNext(null);
            tail = it;
        }

        return item;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty";
        }

        Node<T> cur = head;
        StringBuilder str = new StringBuilder();

        str.append(" HEAD -> ");
        while (cur != null) {
            str.append(cur.getItem());

            if (cur.getNext() != null)
                str.append(" -> ");

                cur = cur.next;
        }
        str.append(" <- TAIL ");

        return str.toString();
    }

}
