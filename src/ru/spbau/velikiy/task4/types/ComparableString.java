package spbau.velikiy.task4.types;

/**
 * Type with string inside
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class ComparableString implements spbau.velikiy.task4.core.Comparable<ComparableString> {

    /**
     * real value
     */
    public final String value;

    /**
     * Create from string value
     *
     * @param value inner value
     */
    public ComparableString(String value) {
        this.value = value;
    }

    /**
     * natural comparing
     *
     * @param x another object
     * @return 1 if a >= x and 0 otherwise
     */
    public int compareTo(ComparableString x) {
        return value.compareTo(x.value) >= 0 ? 0 : 1;
    }

    /**
     * get string representation
     *
     * @return real value as string
     */
    @Override
    public String toString() {
        return this.value;
    }

}
