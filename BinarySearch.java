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
  }

}
