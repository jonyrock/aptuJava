package spbau.velikiy.task4.types;

/**
 * Type with integer inside
 * 
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */
public class ComparableInteger implements spbau.velikiy.task4.core.Comparable<ComparableInteger> {

    /**
     * real value
     */
    public final int value;

    /**
     * Create by integer value
     * @param value inner value
     */
    public ComparableInteger(int value) {
        this.value = value;
    }

    /**
     * natural comparing
     * @param x another object
     * @return 1 if a >= x and 0 otherwise
     */
    public int compareTo(ComparableInteger x) {
        return (value >= x.value) ? 1 : 0;
    }

    /**
     * get string representation
     * @return real value as string
     */
    @Override
    public String toString() {
        return this.value + "";
    }

}
