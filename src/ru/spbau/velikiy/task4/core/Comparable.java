package spbau.velikiy.task4.core;

/**
 * Inner interface for comparing objects
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public interface Comparable<T> {
    /**
     * Compare itself with another object b
     *
     * @param x another object
     * @return 1 if a >= x and 0 otherwise
     */
    int compareTo(T x);
}
