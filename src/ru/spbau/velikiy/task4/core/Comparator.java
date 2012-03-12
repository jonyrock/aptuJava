package spbau.velikiy.task4.core;

/**
 * Outer interface for comparing objects
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public interface Comparator<T> {

    /**
     * Compare two objects
     *
     * @param a first object
     * @param b second object
     * @return 1 if a >= b and 0 otherwise
     */
    int compare(T a, T b);

}
