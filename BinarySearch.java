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
}
