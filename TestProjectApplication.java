package com.example.testproject;

import java.util.Iterator;
import java.util.List;

public class TestProjectApplication {

  public static void main(String[] args) {

    Iterator<Integer> a1 = List.of(6, 8, 19, 21, 32, 66, 67, 77, 89).iterator();
    Iterator<Integer> a2 = List.of(1, 3, 5, 24, 33, 45, 57, 59, 89).iterator();
    Iterator<Integer> a3 = List.of(2, 4, 9, 18, 22, 44, 46, 89, 89).iterator();

    GloballySortIterator globallySortIterator = new GloballySortIterator(List.of(a1, a2, a3));

    while (globallySortIterator.hasNext()) {
      System.out.println(globallySortIterator.next());
    }

  }

}
