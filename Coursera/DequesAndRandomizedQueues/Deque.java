import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    // class Node
    private class Node {
        private Node next;
        private Item item;
    }

    private Node head;
    private int size;

    // construct an empty deque
    public Deque() {
        head = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Illegal");
        Node newNode = new Node();
        newNode.item = item;
        if (size == 0) {
            newNode.next = null;
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Illegal");
        Node newNode = new Node();
        newNode.item = item;
        if(size == 0) {
            newNode.next = null;
            head = newNode;
        }
        else {
            Node cur = head;
            while(cur.next != null)
                cur = cur.next;
            cur.next = newNode;
            newNode.next = null;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if(size == 0)
            throw new NoSuchElementException("Queue is empty");
        Item curItem = null;
        if(size == 1) {
            curItem = head.item;
            head = null;
        }
        else {
            Node cur = head;
            curItem = head.item;
            head = cur.next;
        }
        size--;
        return curItem;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0)
            throw new NoSuchElementException("Queue is empty");
        Item curItem = null;
        if (size == 1) {
            curItem = head.item;
            head = null;
        }
        else {
            Node cur = head;
            while (cur.next.next != null)
                cur = cur.next;
            curItem = cur.next.item;
            cur.next = null;
        }
        size--;
        return curItem;
    }

    private class IteratorList implements Iterator<Item> {
        Node cur = head;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Error");
        }

        @Override
        public Item next() {
            if (cur == null)
                throw new NoSuchElementException("Empty");
            Item curItem = cur.item;
            cur = cur.next;
            return curItem;
        }
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new IteratorList();
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> queue = new Deque<Integer>();
        System.out.println(queue.size());
        queue.addFirst(2);
        queue.addFirst(1);
        queue.addLast(3);
        System.out.println(queue.size());
        queue.addLast(4);
        queue.addLast(5);
        System.out.println(queue.size());
        queue.removeFirst();
        queue.removeLast();
        System.out.println(queue.size());
        Iterator<Integer> iter = queue.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

    }
}
