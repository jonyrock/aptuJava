package spbau.velikiy.task4;


import java.util.Collections;
import java.util.List;

public class HeapSort<T extends Comparable<T>> implements Sorter<T> {

    public void sort(List<T> list) {
            
        

    }

    public void sort(final List<T> list, final Comparator<T> c) {

        Collections.sort(list, new java.util.Comparator<T>() {
            public int compare(T t, T t1) {
                return c.compare(t, t1);
            }
        });

    }

}
