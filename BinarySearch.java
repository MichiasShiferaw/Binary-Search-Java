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
  public static void main(String[] args) throws IOException {
    
    //uses the binarySearch function to search
    InputStreamReader r = new InputStreamReader(System.in); 
    BufferedReader br = new BufferedReader(r);
    Scanner inputter = new Scanner(System.in);
    //Declare varaible
    String verify = null; 
    String checker = null;
    String options = null;
    int numIn = 0;
    int max = 250;
    
    //create 3 array list for..
    List<Integer> randListorg = new ArrayList<>(); // the original rand output
    List<Integer> sortedList = new ArrayList<>(); // the sorted list
    List<Integer> randList = new ArrayList<>(); // the new adjusted list
    
    
    System.out.println("Random Output:");
    //output 250 random numbers
    for (int count = 0; count < max; count++) {      
    
      //add random number ranging from 0 to 600
      int randNum = new Random().nextInt(601);
      System.out.print(randNum + " "); //output for display
      //add each value to both of the randList
      randList.add(randNum);
      randListorg.add(randNum);
    }    
    
    sortedList = sortList(randListorg); //sorts the original list from least to greatest
      
    System.out.println("");
    System.out.print("\nORDERED LIST:\n" + sortedList + "\n");
      
    //see if user wants to input a value or search
    System.out.println("-----------------------------------------------");
    
    boolean finished = false;
    while (finished == false) {
      //while the user has not decided to leave the program
      boolean checking = false;
      do {
        System.out.println("N : insert new value \nS : search for value \nE : exit program");
        String optionfilt = br.readLine();
        options = (optionfilt.toUpperCase());

        if ((options.equals("N")) || (options.equals("S"))) {
          checking = false;
        } else if (options.equals("E")) {
          System.out.println("BYE BYE!");//farewell to the user
          System.exit(0);//close application
        } else {
           
          System.out.println("Your input was not sufficient enough. Please try again.");
             
          checking = true;
        }
           
      } while (checking != false);//continue to loop while the value is not false
         
      //int newAdd = "";
      int newAdd = 0;
                  
      //closing for get number
      if (options.equals("N")) {
        //insert value
        boolean validiate = false;
        System.out.println("Please enter an integer!");
        do { 
          try {
            //check if response is an integer
            //insert value
            verify = br.readLine();
            newAdd = Integer.parseInt(verify);
            validiate = false;
          } catch (IllegalArgumentException x) { 
            validiate = true;
            System.out.println("Your input was not an integer!");
            System.out.println("Please try again and enter an integer!");

          }      
        } while (validiate != false); //continue to loop while the value is not false
        
        randList.add(newAdd);
        //sort
        sortedList = sortList(randList); //sorts list from least to greatest 
        System.out.print("\nADUSTED ORDERED LIST :\n" + sortedList + "\n");
      } else if (options.equals("S")) {
        //String verify = null;
        System.out.println("Please enter the integer you want to find here:!");
       
        boolean validiate2 = false; 

        do {
          try {
            //check if response is an integer
            checker = br.readLine();
            validiate2 = false;
            numIn = Integer.parseInt(checker);
          } catch (IllegalArgumentException x) { 
            validiate2 = true;
            System.out.println("Sorry this is not an integer");
            System.out.println("Please try again and enter an integer you want to find!");
          }
        } while (validiate2 != false); //continue to loop while the value is not false  
     
        
        
        int looking = searching(sortedList, numIn);//search value
        
        if (looking == -1) {
          //not in the list
          System.out.println("\nNumber is not in display!");
        } else {
          //the input is in the list
          System.out.println("\n" + numIn + " is at " + looking + " index!");
        }
      }        
