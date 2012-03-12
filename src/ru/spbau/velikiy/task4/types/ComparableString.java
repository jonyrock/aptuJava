package spbau.velikiy.task4.types;

//TODO comment
public class ComparableString implements spbau.velikiy.task4.core.Comparable<ComparableString> {

    public final String value;

    public ComparableString(String value) {
        this.value = value;
    }

    public int compareTo(ComparableString x) {
        return value.compareTo(x.value) >= 0 ? 0 : 1;
    }


    @Override
    public String toString() {
        return this.value;
    }
    
}
