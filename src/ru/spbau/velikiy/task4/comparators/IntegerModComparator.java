package spbau.velikiy.task4.comparators;


import spbau.velikiy.task4.types.ComparableInteger;
import spbau.velikiy.task4.core.Comparator;

// TODO comment
public class IntegerModComparator implements Comparator<ComparableInteger> {

    public final int n;

    public IntegerModComparator(int n) {
        this.n = n;
    }

    public int compare(ComparableInteger a, ComparableInteger b) {
        return (a.value % n >= b.value % n) ? 1 : 0;
    }

}
