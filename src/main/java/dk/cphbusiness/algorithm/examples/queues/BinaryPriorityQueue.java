package dk.cphbusiness.algorithm.examples.queues;

import java.lang.reflect.Array;

/**
 * BinaryPriorityQueue
 */
public class BinaryPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

    private Object[] data;
    private int tail;

    public BinaryPriorityQueue(int size) {
        this.data = new Object[size];
        this.tail = 1;
    }

    public void print() {
        for(int i = 1; i < tail; i++) {
            System.out.println(get(i));
        }
    }

    @Override
    public T dequeue() {
        if (size() == 0) return null;
        T item = get(1);
        
        swap(1, --tail);
        int i = 1;
        while(i*2 < tail) {
            int j = i*2;
            // If smaller than child
            if (j < tail && get(j).compareTo(get(j+1)) < 0) {
                swap(i, j);
            } else {
                break;
            }
            i = j;
        }

        return item;
    }

    public T get(int index) {
        return (T)data[index];
    }

    @Override
    public void enqueue(T item) {
        data[tail] = item;
        int i = tail;
        for (; i > 1; i /= 2) {
            // if smaller than parent
            if (item.compareTo(get(i / 2)) < 0) {
                this.swap(i, i / 2);
            } else {
                break;
            }
        }
        tail++;
    }

    private void swap(int i, int j) {
        T tmp = get(i);
        data[i] = data[j];
        data[j] = tmp;
    }

    @Override
    public T peek() {
        return get(1);
    }

    @Override
    public int size() {
        return tail - 1;
    }
}