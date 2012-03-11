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

        for (int p = 1; p <= data.size() / 2; p++) {

            // first do left to right bubbling pass
            for (int i = p - 1; i < data.size() - p; i++) {

                if (comparator.compare(data.get(i), data.get(i + 1)) == 1) {
                    swap(data, i, i + 1);
                }
            }

            // now do right to left bubbling pass
            for (int i = data.size() - p - 1; i >= p; i--) {
                if (comparator.compare(data.get(i), data.get(i + 1)) != 1) {
                    swap(data, i, i - 1);
                }
            }

        }
        
        list.clear();
        list.addAll(data);

    }


    private void swap(ArrayList<T> data, int i, int j) {
        T t = data.get(i);
        data.set(i, data.get(j));
        data.set(j, t);
    }

}
