package spbau.velikiy.task4.core;


import java.util.List;

public interface Sorter<T> {

    void sort(List<T> list);

    void sort(List<T> list, Comparator<T> comparator);

}
