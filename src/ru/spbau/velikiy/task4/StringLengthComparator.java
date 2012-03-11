package spbau.velikiy.task4;


// TODO comment
public class StringLengthComparator implements Comparator<ComparableString> {
   
    public int compare(ComparableString a, ComparableString b) {
        return (a.value.length() >= b.value.length()) ? 1 : 0;
    }

}
