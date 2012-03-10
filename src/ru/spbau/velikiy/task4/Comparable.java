package spbau.velikiy.task4;

/**
 * Inner interface for comparing objects
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */
public interface Comparable<T> {
    /**
     * Compare itself with another object b     
     * @param x another object
     * @return 1 if a>b, 0 if a=b and -1 if a<b 
     */
    int compareTo(T x);
}
