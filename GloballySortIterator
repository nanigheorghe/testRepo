package com.example.testproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Sort globally all elements from the provided iterators.
 */
public class GloballySortIterator implements Iterator<Integer> {

  private final List<Iterator<Integer>> iteratorList;
  private Integer[] tempIterationArray;
  private final List<Integer> overflowTempIterationArray = new ArrayList<>();

  public GloballySortIterator(List<Iterator<Integer>> iteratorList) {
    this.iteratorList = iteratorList;
    this.tempIterationArray = new Integer[iteratorList.size()];
  }

  @Override
  public boolean hasNext() {
    //If there are elements in temp list then return true
    if(!isEmpty(tempIterationArray) || !overflowTempIterationArray.isEmpty()){
      return true;
    }
    //If there are elements in iterators return true
    for (Iterator<Integer> integerIterator : iteratorList) {
      if (integerIterator.hasNext()) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Integer next() {
    //Iterate through elements gathered in tempIterationArray and return until array is empty
    //Once element is returned - set it to null in tempIterationArray
    for (int index = 0; index < tempIterationArray.length; index++) {
      if (tempIterationArray[index] != null) {
        Integer result = tempIterationArray[index];
        tempIterationArray[index] = null;
        return result;
      }
    }

    //Iterate through overflowTempIterationArray and add elements in tempIterationArray, clear list after
    overflowTempIterationArray.forEach(this::addElementInTempArray);
    overflowTempIterationArray.clear();

    //Iterate through all iterators get first element and save in the temp array
    for (Iterator<Integer> integerIterator : iteratorList) {
      if (integerIterator.hasNext()) {
        Integer nextValue = integerIterator.next();
        addElementInTempArray(nextValue);
      }
    }

    //Find max element from temp array
    //Iterate though iterators and check if there are elements lower than max element in temp array
    //then add element in temp array, and values which are greater save in overflowTempIterationArray
    Integer maxElement = getLastElement(tempIterationArray);
    for (Iterator<Integer> integerIterator : iteratorList) {
      while (integerIterator.hasNext()) {
        Integer nextValue = integerIterator.next();
        if (nextValue <= maxElement) {
          addElementInTempArray(nextValue);
        } else {
          overflowTempIterationArray.add(nextValue);
          break;
        }
      }
    }

    //If temp array is empty then throw exception
    //Otherwise next() - which will get data from temp array
    if (isEmpty(tempIterationArray)) {
      throw new NoSuchElementException();
    } else {
      return next();
    }
  }

  private Integer getLastElement(Integer[] tempIterationArray) {
    for (int i = tempIterationArray.length - 1; i > 0; i--){
      if(tempIterationArray[i] != null){
        return tempIterationArray[i];
      }
    }
    throw new IllegalStateException("Array is empty");
  }

  /**
   * Add new element in the temp array directly in sorted manner
   * In case of array overflow - resize array
   *
   * @param nextValue - next element to be added in the array
   */
  private void addElementInTempArray(Integer nextValue) {
    if (tempIterationArray[tempIterationArray.length - 1] != null) {
      Integer[] temp = new Integer[2 * tempIterationArray.length];
      System.arraycopy(tempIterationArray, 0, temp, 0, tempIterationArray.length);
      tempIterationArray = temp;
    }

    for (int i = 0; i < tempIterationArray.length; i++) {
      if (tempIterationArray[i] == null) {
        tempIterationArray[i] = nextValue;
        return;
      } else if (nextValue < tempIterationArray[i]) {
        shiftArrayElementsStartingWith(i);
        tempIterationArray[i] = nextValue;
        return;
      }
    }
  }

  /**
   * Shift all elements from tempIterationArray on the right starting with specific index
   *
   * @param index - starting shift index
   */
  private void shiftArrayElementsStartingWith(int index) {
    for (int i = tempIterationArray.length - 2; i >= index; i--) {
      tempIterationArray[i + 1] = tempIterationArray[i];
    }
  }

  /**
   * Check if array is empty
   *
   * @param array
   * @return true - array has just null elements
   *         false - array has non-null elements
   */
  private boolean isEmpty(Integer[] array) {
    for (int index = 0; index < array.length; index++) {
      if (tempIterationArray[index] != null) {
        return false;
      }
    }
    return true;
  }
}
