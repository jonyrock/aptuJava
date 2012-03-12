package spbau.velikiy.task4.comparators;


import spbau.velikiy.task4.core.Comparator;
import spbau.velikiy.task4.types.ComparableInteger;

/**
 * Comparing by mod
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class IntegerModComparator implements Comparator<ComparableInteger> {

    /**
     * comparing mod
     */
    public final int n;

    /**
     * create from mod value
     *
     * @param n mod value
     */
    public IntegerModComparator(int n) {
        this.n = n;
    }

    /**
     * Compare two objects by mod value
     *
     * @param a first object
     * @param b second object
     * @return 1 if a%n >= b%n and 0 otherwise
     */
    public int compare(ComparableInteger a, ComparableInteger b) {
        return (a.value % n >= b.value % n) ? 1 : 0;
    }

}
