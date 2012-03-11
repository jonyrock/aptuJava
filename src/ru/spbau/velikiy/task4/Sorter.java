package spbau.velikiy.task4;


import java.util.List;

public interface Sorter<T> {

    void sort(List<T> list);

    void sort(List<T> list, Comparator<T> c);

}
