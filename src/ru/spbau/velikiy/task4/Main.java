package spbau.velikiy.task4;

import java.util.ArrayList;
import java.util.Date;
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

        //stringsTest();
        integersTest();

    }


    // TODO abstract sorting, test correctness
    private static void integersTest() {

        List<ComparableInteger> list;

        // heaSort testing
        System.out.println("HeapSort testing:");

        Sorter<ComparableInteger> sorter = new ShakerSort<ComparableInteger>();
        list = new ArrayList<ComparableInteger>();
        List<Long> results = new ArrayList<Long>();


        fillListIntegers(list, 10);

        printList(list, true);
        System.out.println("-----------------------");

        results.add(getTime(list, sorter,
                new Comparator<ComparableInteger>() {
                    public int compare(ComparableInteger a, ComparableInteger b) {
                        return a.compareTo(b);
                    }
                }
        ));

        printList(list, true);

        if (1 < 2) {
            return;
        }


        fillListIntegers(list, 100);
        results.add(getTime(list, sorter, new IntegerModComparator(7)));

        fillListIntegers(list, 1000);
        results.add(getTime(list, sorter, new IntegerModComparator(7)));

        fillListIntegers(list, 10000);
        results.add(getTime(list, sorter, new IntegerModComparator(8)));

        System.out.println("10\t\t100\t\t1000\t10000");
        for (Long res : results) {
            System.out.print(res + "ms\t\t");
        }
        System.out.println();


    }

    private static void stringsTest() {

        List<ComparableString> list = new ArrayList<ComparableString>();
        fillListStrings(list, 10, 20);
        Sorter<ComparableString> sorter = new HeapSort<ComparableString>();
        sorter.sort(list, new StringLengthComparator());


        printList(list, true);

    }


    private static void fillListIntegers(List<ComparableInteger> list, int count) {

        list.clear();
        for (int i = 0; i < count; i++) {
            list.add(new ComparableInteger(
                    (int) (Math.random() * 1000)));
        }

    }

    private static void fillListStrings(List<ComparableString> list, int count, int length) {

        list.clear();

        StringBuilder builder = new StringBuilder();
        int range = 'z' - 'a';

        for (int i = 0; i < count; i++) {
            builder = new StringBuilder();
            int lengthRandom = (int) (Math.random() * length) + 3;
            for (int j = 0; j < lengthRandom; j++) {
                builder.append((char) ('a' + (int) (Math.random() * range)));
            }
            list.add(new ComparableString(builder.toString()));
        }

    }

    private static <T> void printList(List<T> list, boolean inline) {

        for (T item : list) {
            if (inline) {
                System.out.print(item + " ");
            } else {
                System.out.println(item);
            }
        }

        System.out.println();

    }

    private static <T> long getTime(List<T> list, Sorter<T> sorter) {
        Date startDate = new Date();
        sorter.sort(list);
        return new Date().getTime() - startDate.getTime();
    }

    private static <T> long getTime(List<T> list, Sorter<T> sorter, Comparator<T> comparator) {
        Date startDate = new Date();
        sorter.sort(list, comparator);
        return new Date().getTime() - startDate.getTime();
    }

}
