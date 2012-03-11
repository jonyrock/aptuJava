package spbau.velikiy.task4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeapSort<T extends Comparable<T>> implements Sorter<T> {

    public void sort(List<T> list) {
        
        this.sort(list, new Comparator<T>() {
            public int compare(T a, T b) {
                return a.compareTo(b);
            }
        });

    }

    public void sort(final List<T> list, final Comparator<T> comparator) {
                
        Heap<T> heap = new Heap<T>(list.size(), comparator);
        for (T t : list){
            heap.add(t);
        }
        list.clear();
        while (!heap.isEmpty()){
            list.add(heap.pop());
        }

    }

    private static class Heap<T> {

        public ArrayList<T> data;
        public int topIndex = 0;
        public final Comparator<T> comparator;

        public Heap(int capacity, Comparator<T> comparator) {
            data = new ArrayList<T>();
            this.comparator = comparator;
        }
        
        public boolean isEmpty(){
            return topIndex == 0;
        }
        
        public void add(T n) {
            data.add(n);
            heapify(topIndex);
            topIndex++;
        }

        public T pop() {
            T t = data.get(0);
            data.set(0, data.get(topIndex - 1));
            topIndex--;
            heapifyDown(0);
            return t;
        }

        public int heapify(int i) {

            int p;
            while (i != 0) {
                p = (i - 1) / 2;
                if (comparator.compare(data.get(p), data.get(i)) == 1) {
                    break;
                }
                swap(p, i);
                i = p;
            }

            return i;

        }

        public int heapifyDown(int i) {

            while (true) {

                int ci1 = i * 2 + 1;
                int ci2 = ci1 + 1;
                int mi;

                if (ci1 >= topIndex) {
                    break;
                }

                if (ci2 >= topIndex) {
                    mi = ci1;
                } else {
                    mi = (comparator.compare(data.get(ci1),
                            data.get(ci2)) == 1) ? ci1 : ci2;
                }

                if (comparator.compare(data.get(i), data.get(mi)) == 0) {
                    swap(i, mi);
                } else {
                    break;
                }

                i = mi;

            }

            return i;

        }

        void swap(int i, int j) {
            T t = data.get(i);
            data.set(i, data.get(j));
            data.set(j, t);
        }

    }

    @Override
    public String toString() {
        return "HeapSort";
    }
}
