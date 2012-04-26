package spbau.velikiy.task7;

import java.util.LinkedList;
import java.util.Queue;

public class DistributedIncrementor {

    int idCount = 0;
    private final Queue<Task> queue = new LinkedList<Task>();

    /**
     * Increment i one
     *
     * @param i to increment
     * @return i + 1
     * @throws InterruptedException if interrupted
     */
    public int increment(int i) throws InterruptedException {

        Task t = new Task(i, idCount++);

        synchronized (queue) {
            queue.add(t);
            queue.notifyAll();
        }

        synchronized (t) {
            while (!t.isDone) {
                t.wait();
            }
        }

        return t.result;

    }

    /**
     * Standard constructor
     */
    public DistributedIncrementor() {

        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(new Worker(queue));
            t.setDaemon(true);
            t.start();
        }

    }

}
