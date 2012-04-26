package spbau.velikiy.task7;

/**
 * Threading computing task
 * Start point
 *
 * @author Alexey Velikiy. APTU. Java. Homework 7.
 * @version %I%, %G%
 */

public class Main {

    /**
     * Start point
     *
     * @param args (not real using)
     */
    public static void main(String args[]) {

        DistributedIncrementor incrementor = new DistributedIncrementor();
        for (int i = 1; i <= 5; i++) {
            new Thread(new StupidChild(incrementor, i, 10000, 1, 1000)).start();
        }

    }

}
