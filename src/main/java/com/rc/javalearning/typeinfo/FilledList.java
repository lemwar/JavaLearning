package com.rc.javalearning.typeinfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CountedInteger {
    private static long counter;
    private final long id = counter++;
    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<T> {
    private Class<T> type;

    private FilledList(Class<T> type) {
        this.type = type;
    }

    private List<T> create(int nElements) {
        List<T> result = new ArrayList<>();
        for(int i = 0; i < nElements; i++) {
            try {
                result.add(type.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        FilledList<String> f1 = new FilledList<String>(CountedInteger.class);
//        System.out.println(f1.create(15));
//        List list = new LinkedList();

    }

}
