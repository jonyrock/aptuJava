package spbau.velikiy.task4;

import spbau.velikiy.task4.comparators.IntegerModComparator;
import spbau.velikiy.task4.comparators.StringLengthComparator;
import spbau.velikiy.task4.core.Comparable;
import spbau.velikiy.task4.core.Comparator;
import spbau.velikiy.task4.core.Sorter;
import spbau.velikiy.task4.sorters.HeapSort;
import spbau.velikiy.task4.sorters.ShakerSort;
import spbau.velikiy.task4.types.ComparableInteger;
import spbau.velikiy.task4.types.ComparableString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Arithmetic Parser. With functions definitions.
 * Start point
 *
 * @author Alexey Velikiy. APTU. Java. Homework 4.
 * @version %I%, %G%
 */
public class Main {

    /**
     * Start point
     *
     * @param args program source path (not real using)
     */
    public static void main(String[] args) {

        System.out.println("HeapSort testing");
        System.out.println("------------------------------------------");
        integersTest(new HeapSort<ComparableInteger>());
        System.out.println();
        integersTestWithComparators(new HeapSort<ComparableInteger>());
        System.out.println();
        stringsTest(new HeapSort<ComparableString>());
        System.out.println();
        stringsTestWithComparators(new HeapSort<ComparableString>());

        System.out.println("ShakerSort testing");
        System.out.println("------------------------------------------");
        integersTest(new ShakerSort<ComparableInteger>());
        System.out.println();
        integersTestWithComparators(new ShakerSort<ComparableInteger>());
        System.out.println();
        stringsTest(new ShakerSort<ComparableString>());
        System.out.println();
        stringsTestWithComparators(new ShakerSort<ComparableString>());

    }


    private static void integersTest(Sorter<ComparableInteger> sorter) {

        System.out.println("ComparableInteger tests");

        // preparing computation structures
        List<ComparableInteger> list = new ArrayList<ComparableInteger>();
        List<Long> results = new ArrayList<Long>();

        // checking correctness and save statistics
        fillListIntegers(list, 10);
        System.out.println("Checking correctness");
        System.out.print("Source list: ");
        printList(list, true);
        results.add(getTime(list, sorter));
        System.out.print("Sorted list: ");
        printList(list, true);

        // collect statistics
        System.out.println("Executing bigger test (without comparator):");
        fillListIntegers(list, 100);
        results.add(getTime(list, sorter));
        fillListIntegers(list, 1000);
        results.add(getTime(list, sorter));
        fillListIntegers(list, 10000);
        results.add(getTime(list, sorter));
        System.out.println("10 \t\t100  \t\t1000\t\t10000");
        for (Long res : results) {
            System.out.print(res + "ms\t\t");
        }
        System.out.println();

    }

    private static void integersTestWithComparators(Sorter<ComparableInteger> sorter) {

        System.out.println("ComparableInteger tests with comparators");
        System.out.println("using IntegerModComparator(10)");

        // preparing computation structures
        List<ComparableInteger> list = new ArrayList<ComparableInteger>();
        List<Long> results = new ArrayList<Long>();
        Comparator<ComparableInteger> comparator = new IntegerModComparator(10);

        // checking correctness and save statistics
        fillListIntegers(list, 10);
        System.out.println("Checking correctness");
        System.out.print("Source list: ");
        printList(list, true);
        results.add(getTime(list, sorter, comparator));
        System.out.print("Sorted list: ");
        printList(list, true);

        // collect statistics
        System.out.println("Executing bigger test:");
        fillListIntegers(list, 100);
        results.add(getTime(list, sorter, comparator));
        fillListIntegers(list, 1000);
        results.add(getTime(list, sorter, comparator));
        fillListIntegers(list, 10000);
        results.add(getTime(list, sorter, comparator));
        System.out.println("10 \t\t100  \t\t1000\t\t10000");
        for (Long res : results) {
            System.out.print(res + "ms\t\t");
        }
        System.out.println();

    }

    private static void stringsTest(Sorter<ComparableString> sorter) {

        System.out.println("ComparableString tests");

        // preparing computation structures
        List<ComparableString> list = new ArrayList<ComparableString>();
        List<Long> results = new ArrayList<Long>();

        // checking correctness and save statistics
        fillListStrings(list, 10, 10);
        System.out.println("Checking correctness");
        System.out.println("Source list: ");
        printList(list, false);
        results.add(getTime(list, sorter));
        System.out.println("Sorted list: ");
        printList(list, false);

        // collect statistics
        System.out.println("Executing bigger test (without comparator):");
        fillListStrings(list, 100, 10);
        results.add(getTime(list, sorter));
        fillListStrings(list, 1000, 10);
        results.add(getTime(list, sorter));
        fillListStrings(list, 10000, 10);
        results.add(getTime(list, sorter));
        System.out.println("10 \t\t100  \t\t1000\t\t10000");
        for (Long res : results) {
            System.out.print(res + "ms\t\t");
        }
        System.out.println();
    }

    private static void stringsTestWithComparators(Sorter<ComparableString> sorter) {

        System.out.println("ComparableString tests with comparators");
        System.out.println("using StringLengthComparator");

        // preparing computation structures
        List<ComparableString> list = new ArrayList<ComparableString>();
        List<Long> results = new ArrayList<Long>();
        Comparator<ComparableString> comparator = new StringLengthComparator();

        // checking correctness and save statistics
        fillListStrings(list, 10, 10);
        System.out.println("Checking correctness");
        System.out.println("Source list: ");
        printList(list, false);
        results.add(getTime(list, sorter, comparator));
        System.out.println("Sorted list: ");
        printList(list, false);

        // collect statistics
        System.out.println("Executing bigger test:");
        fillListStrings(list, 100, 10);
        results.add(getTime(list, sorter, comparator));
        fillListStrings(list, 1000, 10);
        results.add(getTime(list, sorter, comparator));
        fillListStrings(list, 10000, 10);
        results.add(getTime(list, sorter, comparator));
        System.out.println("10 \t\t100  \t\t1000\t\t10000");
        for (Long res : results) {
            System.out.print(res + "ms\t\t");
        }
        System.out.println();
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

        StringBuilder builder;
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

    private static <T extends Comparable> long getTime(List<T> list, Sorter<T> sorter) {
        Date startDate = new Date();
        sorter.sort(list);
        return new Date().getTime() - startDate.getTime();
    }

    private static <T extends Comparable> long getTime(List<T> list, Sorter<T> sorter,
                                                       Comparator<T> comparator) {
        Date startDate = new Date();
        sorter.sort(list, comparator);
        return new Date().getTime() - startDate.getTime();
    }

}
