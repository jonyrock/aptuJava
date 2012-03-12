package spbau.velikiy.task4.comparators;


import spbau.velikiy.task4.core.Comparator;
import spbau.velikiy.task4.types.ComparableString;

/**
 * Comparing by string length
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class StringLengthComparator implements Comparator<ComparableString> {

    /**
     * compare two string by length
     *
     * @param a first object
     * @param b second object
     * @return 1 if length(a) >= length(b) and 0 otherwise
     */
    public int compare(ComparableString a, ComparableString b) {
        return (a.value.length() >= b.value.length()) ? 1 : 0;
    }

}
