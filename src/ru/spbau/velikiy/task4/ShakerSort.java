package spbau.velikiy.task4;


import java.util.ArrayList;
import java.util.List;

public class ShakerSort<T extends Comparable<T>> implements Sorter<T> {

    public void sort(List<T> list) {

        this.sort(list, new Comparator<T>() {
            public int compare(T a, T b) {
                return a.compareTo(b);
            }
        });

    }

    public void sort(List<T> list, Comparator<T> comparator) {

        ArrayList<T> data = new ArrayList<T>(list);

        int a;
        boolean exchange;        
        int count = data.size();

        do {
            
            exchange = false;
            
            for (a = count - 1; a > 0; --a) {
                if (comparator.compare(data.get(a - 1), data.get(a)) == 0) {
                    swap(data, a - 1, a);
                    exchange = true;
                }
            }
            
            for (a = 1; a < count; ++a) {
                if (comparator.compare(data.get(a - 1), data.get(a)) == 0) {
                    swap(data, a - 1, a);
                    exchange = true;
                }
            }
            
        } while (exchange);


        list.clear();
        list.addAll(data);

    }

    private void swap(ArrayList<T> data, int i, int j) {
        T t = data.get(i);
        data.set(i, data.get(j));
        data.set(j, t);
    }

}
