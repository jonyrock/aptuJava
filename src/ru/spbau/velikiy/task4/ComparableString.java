package spbau.velikiy.task4;

//TODO comment
public class ComparableString implements Comparable<ComparableString> {

    public final String value;

    public ComparableString(String value) {
        this.value = value;
    }

    public int compareTo(ComparableString x) {
        return value.compareTo(x.value);
    }


    @Override
    public String toString() {
        return this.value;
    }
    
}