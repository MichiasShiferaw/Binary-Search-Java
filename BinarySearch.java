//have to import the following:
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
  public static int searching(List<Integer> inputArray, int numIn) {
    
    int lowerBound = 0;
    int upperBound = (inputArray.size() - 1);
    int middleValue;
    
    while (lowerBound <= upperBound) {
      //while range is valid and exists
      //check halves for number 
      
      int middlePoint = (int) Math.round((upperBound + lowerBound) / 2);
      middleValue = inputArray.get(middlePoint);    
      
      //if input is at middleValue
      if (numIn == middleValue) {
        return middlePoint; //this breaks the 'while' and the 'searching'
        
      } else if (numIn > middleValue) {
        //if input is greater than middleValue
        //ignore left half(numbers less than the middle)
        lowerBound = middlePoint + 1; //not including mid
        
      } else if (numIn < middleValue) {
        //if input is less than middleValue
        //ignore right half(numbers greater than the middle)
        upperBound = middlePoint - 1; //not including mid
      } // closing for if statement
    } //closing for while
      
    //if reach here, no values are in the list
    //so return '-1'
    return -1;
  } //closing for searching
    
  /**
  * opening for sort method .
  */
  
  public static List<Integer> sortList(List<Integer> inputArray) {
    //Sorts the unsorted list and assigns the result to return a sorted list

    List<Integer> sortedList = new ArrayList<>();
    
    Integer minima = 0; //default is 0
      
    for (int count = 0;count < inputArray.size();) {
      //check all values of input array 
      minima = inputArray.get(0); //set as new smallest number
      for (int current: inputArray) {
        //search for the smallest value in input array and restate it as such
        //if the value is less than the smallest value, set it to new smallest value
        //inspiration from http://www.cafeaulait.org/course/week2/43.html
        minima = (current < minima) ? current : minima; 
      }
    
      sortedList.add(minima); //add to sortedList
      inputArray.remove(minima); //remove the small value from input array
    }
      
    return sortedList;
 } //closing for sorted method
  
  /**
  * opening for main. 
  */
