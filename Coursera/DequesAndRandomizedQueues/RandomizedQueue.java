import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] randomQueue;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        randomQueue = (Item[]) new Object[1];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // resize array
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for(int i = 0;i < size;i++)
            copy[i] = randomQueue[i];
        randomQueue = copy;
    }

    // add the item
    public void enqueue(Item item) {
        if(item == null)
            throw new IllegalArgumentException("Illegal");
        if(size == randomQueue.length)
            resize(2 * randomQueue.length);
        randomQueue[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0)
            throw new NoSuchElementException("Empty");
        int rand = StdRandom.uniform(0, size);
        size--;
        Item value = randomQueue[rand];
        randomQueue[rand] = randomQueue[size];
        randomQueue[size] = null;
        if(size > 0 && size == randomQueue.length / 4)
            resize(randomQueue.length / 2);
        return value;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0)
            throw new NoSuchElementException("Empty");
        return randomQueue[StdRandom.uniform(0, size)];
    }

    private class IteratorRand implements Iterator<Item> {
        private int iteSize;
        private Item[] randIterator;

        public IteratorRand() {
            iteSize = size;
            randIterator = (Item[]) new Object[size];
            for(int i = 0;i < size;i++) {
                randIterator[i] = randomQueue[i];
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Error");
        }

        @Override
        public boolean hasNext() {
            return iteSize > 0;
        }

        @Override
        public Item next() {
            if(iteSize == 0)
                throw new NoSuchElementException("Empty");
            int rd = StdRandom.uniform(0, size);
            Item curItem = randIterator[rd];
            iteSize--;
            randIterator[rd] = randIterator[iteSize];
            return curItem;
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new IteratorRand();
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rand = new RandomizedQueue<Integer>();
        rand.enqueue(1);
        rand.enqueue(2);
        rand.enqueue(3);
        rand.enqueue(4);
        rand.enqueue(5);
        rand.enqueue(6);
        rand.enqueue(7);
        rand.enqueue(8);
        rand.enqueue(9);
        Iterator<Integer> it = rand.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(rand.size());
    }
}
