import java.util.*;

public class Homework1{
   
   public static int [] elements; 
   
   public static void main(String[] args){
        
      inputArraySize(100000);
      
      int key = (int)(Math.random()*100001 + 1);
      
      System.out.println("\nLinear Search:\n");
      long T1 = System.nanoTime();
      System.out.println("Key = " + key + "\n");
      System.out.println("The Key exists? " + linearSearch(key) + "\n");
      long T2 = System.nanoTime();
      System.out.println("Approximate time to perform search: " + (T2 - T1) + "\n");
      System.out.println("---------------------------------------------------------");

      System.out.println("\nBinary Search:\n");
      long T3 = System.nanoTime();
      System.out.println("Key = " + key + "\n");
      System.out.println("The Key exists? " + binarySearch(key) + "\n");
      long T4 = System.nanoTime();
      System.out.println("Approximate time to perform search: " + (T4 - T3));
      
      
      }
      public static void inputArraySize(int inputSize){
         elements = new int [inputSize];
         for (int i = 0; i < elements.length; i++){
            elements[i] = (int)(Math.random()*100000 + 1);
         }
         Arrays.sort(elements);

      }  
      public static boolean linearSearch(int key){
      
         for (int i = 0; i < elements.length; i++){
         
            if(key == elements[i]){
               return true;
            }
        }
        return false;
      }      
      public static boolean binarySearch(int key){
         
         int low = 0;
         int high = elements.length - 1;
         int mid;
         
         while(low <= high){
            
            mid = (low + high)/2;
            
            if(elements[mid] < key){
               
               low = mid + 1;
            }
            else if(elements[mid] > key){
               
               high = mid - 1;
            }
            else{
               
               return true;
            }
         }
         return false;         
      }        
}
