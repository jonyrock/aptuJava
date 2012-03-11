package spbau.velikiy.task4;

//TODO comment
public class ComparableInteger implements Comparable<ComparableInteger> {

    public final int value;

    public ComparableInteger(int value) {
        this.value = value;
    }

    public int compareTo(ComparableInteger x) {
        return (value >= x.value) ? 1 : 0;
    }
}
