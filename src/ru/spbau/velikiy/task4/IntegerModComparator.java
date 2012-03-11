package spbau.velikiy.task4;


// TODO comment
public class IntegerModComparator extends ComparableInteger {

    public final int n;

    public IntegerModComparator(int n, int value) {
        super(value);
        this.n = n;
    }

    @Override
    public int compareTo(ComparableInteger x) {
        return (value % n >= x.value % n) ? 1 : 0;
    }
}
