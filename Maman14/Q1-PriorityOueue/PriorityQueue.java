import java.util.ArrayList;
import java.util.Iterator;

public class PriorityQueue<E> {
    private ArrayList<E>[] priorityQueue;
    private int size;

    public PriorityQueue(int maxNumOfPriorities) {
        if(maxNumOfPriorities < 1 || maxNumOfPriorities > 10)
            maxNumOfPriorities = 10;
        priorityQueue = new ArrayList[maxNumOfPriorities];
        for (int i = 0; i < maxNumOfPriorities; i++) {
            priorityQueue[i] = new ArrayList<E>();
        }
        size = 0;
    }

    public void add(E element, int priority) {
        if (priority > priorityQueue.length - 1)
            priorityQueue[priorityQueue.length - 1].add(element);
        else
            priorityQueue[priority].add(element);
        size++;
    }

    public E poll() {
        E element;
        for (int i = 0; i < priorityQueue.length; i++) {
            for (int j = 0; j < priorityQueue[i].size(); j++) {
                if (priorityQueue[i].get(j) != null) {
                    element = priorityQueue[i].get(j);
                    priorityQueue[i].remove(j);
                    return element;
                }
            }
        }
        return null;
    }

    public boolean contains(E element) {
        for (int i = 0; i < priorityQueue.length; i++) {
            for (int j = 0; j < priorityQueue[i].size(); j++) {
                if (priorityQueue[i].get(j).equals(element))
                    return true;
            }
        }
        return false;
    }

    public boolean remove(E element) {
        for (int i = 0; i < priorityQueue.length; i++) {
            if (priorityQueue[i].contains(element)) {
                priorityQueue[i].remove(element);
                size--;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public Iterator<E> iterator() {
        ArrayList<E> list = new ArrayList<E>();
        for (int i = 0; i < priorityQueue.length; i++) {
            list.addAll(priorityQueue[i]);
        }
        return list.iterator();
    }
}



