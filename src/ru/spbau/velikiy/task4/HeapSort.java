package spbau.velikiy.task4;


import java.util.Collections;
import java.util.List;

public class HeapSort<T extends Comparable<T>> implements Sorter<T> {

    public void sort(List<T> list) {


    }

    public void sort(final List<T> list, final Comparator<T> c) {

        Collections.sort(list, new java.util.Comparator<T>() {
            public int compare(T t, T t1) {
                return c.compare(t, t1);
            }
        });

    }

    private static class Heap {

        public Pair[] data;
        public int topIndex = 0;

        public Heap(int capacity) {
            data = new Pair[capacity];
        }

        public void add(Pair n) {
            data[topIndex] = n;
            heapify(topIndex);
            topIndex++;
        }

        public Pair pop() {
            Pair t = data[0];
            data[0] = data[topIndex - 1];
            topIndex--;
            heapifyDown(0);
            return t;
        }

        public int heapify(int i) {

            int p;
            while (i != 0) {
                p = (i - 1) / 2;
                if (data[p].l < data[i].l)
                    break;
                swap(p, i);
                i = p;
            }

            return i;

        }

        public int heapifyDown(int i) {

            while (true) {

                int ci1 = i * 2 + 1;
                int ci2 = ci1 + 1;
                int mi;

                if (ci1 >= topIndex)
                    break;

                if (ci2 >= topIndex)
                    mi = ci1;
                else
                    mi = (data[ci1].l < data[ci2].l) ? ci1 : ci2;

                if (data[i].l > data[mi].l)
                    swap(i, mi);
                else
                    break;

                i = mi;

            }

            return i;

        }

        void swap(int i, int j) {
            Pair t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

    }

    private static class Pair {

        public int l;
        public int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public static class ByLSort implements Comparator<Pair> {

            public int compare(Pair one, Pair two) {

                return (one.l > two.l) ? 1 : -1;

            }
        }

        public static class ByRSort implements Comparator<Pair> {

            public int compare(Pair one, Pair two) {

                return (one.r > two.r) ? 1 : -1;

            }
        }

    }
    
}
