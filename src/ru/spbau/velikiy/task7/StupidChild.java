package spbau.velikiy.task7;

import org.omg.CORBA.TIMEOUT;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class StupidChild implements Runnable {

    private int[] numbers;
    private int id;
    private DistributedIncrementor incrementor;

    /**
     * Constructor with constraints
     *
     * @param incrementor  link to service
     * @param id           of the thread
     * @param numbersCount count for generated numbers
     * @param p            numbers interval begin
     * @param q            numbers interval end
     */
    public StupidChild(DistributedIncrementor incrementor, int id, int numbersCount, int p, int q) {

        if (p > q) {
            int t = p;
            p = q;
            q = t;
        }

        this.id = id;
        this.incrementor = incrementor;

        numbers = new int[numbersCount];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = p + rand.nextInt(q - p);
        }

    }


    /**
     * Generate numbers and asks DistributedIncrementor
     * to add one
     */
    public void run() {
        System.out.println("StupidChild " + id + " is started");
        for (int i : numbers) {
            int after;
            try {
                Thread.sleep(10);
                after = incrementor.increment(i);
                Thread.yield();
            } catch (InterruptedException e) {
                after = -1;
            }
            System.out.println(id + " " + i + "->" + after);
            
        }
    }

}
