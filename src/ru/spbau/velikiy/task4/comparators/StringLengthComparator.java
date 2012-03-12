package spbau.velikiy.task4.comparators;


import spbau.velikiy.task4.types.ComparableString;
import spbau.velikiy.task4.core.Comparator;

// TODO comment
public class StringLengthComparator implements Comparator<ComparableString> {
   
    public int compare(ComparableString a, ComparableString b) {
        return (a.value.length() >= b.value.length()) ? 1 : 0;
    }

}
