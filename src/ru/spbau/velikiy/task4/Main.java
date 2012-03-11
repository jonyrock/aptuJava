package spbau.velikiy.task4;

import java.util.ArrayList;
import java.util.List;

/**
 * Arithmetic Parser. With functions definitions.
 * Start point
 *
 * @author Alexey Velikiy. APTU. Java. Homework 3.
 * @version %I%, %G%
 */
public class Main {

    /**
     * Start point
     *
     * @param args program source path
     */
    public static void main(String[] args) {

        List<ComparableInteger> list = new ArrayList<ComparableInteger>();
        fillList(list, 10);
        Sorter<ComparableInteger> sorter = new HeapSort<ComparableInteger>();
        sorter.sort(list, new IntegerModComparator(10));
        
        printList(list);

    }

    private static void fillList(List<ComparableInteger> list, int count) {


        for (int i = 0; i < count; i++) {
            list.add(new ComparableInteger(
                    (int) (Math.random() * 1000)));
        }

    }

    private static void printList(List<ComparableInteger> list) {

        for (ComparableInteger item : list) {
            System.out.print(item.value + " ");
        }

        System.out.println();

    }

}
