package spbau.velikiy.task7;

import java.util.Queue;
import java.util.Random;

public class Worker implements Runnable {

    private final Queue<Task> queue;

    /**
     * Constructor from queue with tasks
     * @param queue with tasks
     */
    public Worker(Queue<Task> queue) {
        this.queue = queue;
    }

    /**
     * Action
     */
    public void run() {

        try {

            while (!Thread.interrupted()) {
                Task task = null;
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        queue.wait();
                    }
                    task = queue.poll();
                }

                synchronized (task) {
                    Thread.sleep(50 + new Random().nextInt(100));
                    task.setResult(task.i + 1);
                    task.notifyAll();
                }

            }


        } catch (InterruptedException e) {
            System.out.println("Worker " + Thread.currentThread().getId() + " is stopped");
        }

    }
}
