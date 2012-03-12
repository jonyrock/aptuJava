package spbau.velikiy.task4.additionComparatorTest;

import spbau.velikiy.task4.Main;
import spbau.velikiy.task4.core.Comparator;
import spbau.velikiy.task4.sorters.HeapSort;

import java.util.ArrayList;
import java.util.List;


public class ATest {

    static class A {
        public int v;

        public A(int v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return this.v + "";
        }
    }

    static class CompA implements Comparator<A> {
        public int compare(A a, A b) {
            return (a.v >= b.v) ? 1 : 0;
        }
    }

    private static void f() {

        List<A> list = new ArrayList<A>();
        list.add(new A(10));
        list.add(new A(11));
        list.add(new A(9));
        list.add(new A(5));
        list.add(new A(13));
        new HeapSort().sort(list, new CompA());

        Main.printList(list, true);
        
    }

}
