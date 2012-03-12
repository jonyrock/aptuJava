package spbau.velikiy.task4.core;


import java.util.List;

/**
 * Interface for sorting algorithms
 *
 * @param <T> storing type
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public interface Sorter<T extends Comparable> {

    /**
     * Sort list
     *
     * @param list for sorting
     */
    void sort(List<T> list);

    /**
     * Sort list with comparator
     *
     * @param list       for sorting
     * @param comparator for comparing
     */
    void sort(List<T> list, Comparator<T> comparator);

}
