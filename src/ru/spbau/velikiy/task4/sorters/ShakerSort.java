package spbau.velikiy.task4.sorters;


import spbau.velikiy.task4.core.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Sorting with shakeSort algorithm 
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class ShakerSort<T extends spbau.velikiy.task4.core.Comparable<T>> implements Sorter<T> {

    /**
     * sorts elements in list with comparable objects 
     * @param list for sorting
     */
    public void sort(List<T> list) {

        this.sort(list, new Comparator<T>() {
            public int compare(T a, T b) {
                return a.compareTo(b);
            }
        });

    }

    /**
     * sorts elements in list with comparable objects 
     * @param list for sorting
     */
    public void sort(List<T> list, Comparator<T> comparator) {

        ArrayList<T> data = new ArrayList<T>(list);

        int a;
        boolean exchange;        
        int count = data.size();

        do {
            
            exchange = false;
            
            for (a = count - 1; a > 0; --a) {
                if (comparator.compare(data.get(a - 1), data.get(a)) == 0) {
                    swap(data, a - 1, a);
                    exchange = true;
                }
            }
            
            for (a = 1; a < count; ++a) {
                if (comparator.compare(data.get(a - 1), data.get(a)) == 0) {
                    swap(data, a - 1, a);
                    exchange = true;
                }
            }
            
        } while (exchange);


        list.clear();
        list.addAll(data);

    }

    private void swap(ArrayList<T> data, int i, int j) {
        T t = data.get(i);
        data.set(i, data.get(j));
        data.set(j, t);
    }

}
