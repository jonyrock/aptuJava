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

        //stringsTest();
        integersTest();

    }
    
    private static void integersTest(){
        
        List<ComparableInteger> list = new ArrayList<ComparableInteger>();
        fillListIntegers(list, 10);
        Sorter<ComparableInteger> sorter = new HeapSort<ComparableInteger>();
        sorter.sort(list, new IntegerModComparator(10));

        printList(list);
        
    }

    private static void stringsTest(){

        List<ComparableString> list = new ArrayList<ComparableString>();
        fillListStrings(list, 10, 20);
        Sorter<ComparableString> sorter = new HeapSort<ComparableString>();
        sorter.sort(list, new StringLengthComparator());

        printList(list);

    }


    private static void fillListIntegers(List<ComparableInteger> list, int count) {


        for (int i = 0; i < count; i++) {
            list.add(new ComparableInteger(
                    (int) (Math.random() * 1000)));
        }

    }

    private static void fillListStrings(List<ComparableString> list, int count, int length) {

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

    private static<T> void printList(List<T> list) {

        for (T item : list) {
            System.out.println(item);
        }

        System.out.println();

    }
   

}
