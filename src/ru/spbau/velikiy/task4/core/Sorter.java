package spbau.velikiy.task4.core;


import java.util.List;

/**
 * Interface for sorting algorithms
 * 
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public interface Sorter {

    /**
     * Sort list
     *
     * @param list for sorting
     */
    <T extends Comparable<T>> void sort(List<T> list);

    /**
     * Sort list with comparator
     *
     * @param list       for sorting
     * @param comparator for comparing
     */
    <T> void sort(List<T> list, Comparator<T> comparator);

}
