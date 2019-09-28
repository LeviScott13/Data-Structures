import java.util.*;

public class HW3 {

    public static int[] binarySearchArray;
    public static int[] linearSearchArray;

    public static void main (String[]args) {

        inputArraySize((int)Math.pow(2,20));

        int key = (int)(Math.random()*1000000 + 1);

        System.out.println("\nRecursive Binary Search:\n");
        long T1 = System.nanoTime();
        System.out.println("Key = " + key);
        System.out.println("Key Exists? " + recursiveBinarySearch(binarySearchArray,key));
        long T2 = System.nanoTime();
        System.out.println("Approximate time to perform search: " + (T2 - T1) + " nanoseconds");
         
        System.out.println("\n========================================================");
        
        System.out.println("\nRecursive Linear Search:\n");
        long T3 = System.nanoTime();
        System.out.println("Key = " + key);
        System.out.println("Key Exists? " + recursiveLinearSearch(linearSearchArray,key,0, linearSearchArray.length - 1));
        long T4 = System.nanoTime();
        System.out.println("Approximate time to perform search: " + (T4 - T3) + " nanoseconds");
    }
    public static void inputArraySize(int inputSize){
        binarySearchArray = new int [inputSize];
        for (int i = 0; i < binarySearchArray.length; i++){
            binarySearchArray[i] = (int)(Math.random()*1000000 + 1);
        }
        Arrays.sort(binarySearchArray);

        linearSearchArray = new int[inputSize];
        for (int i = 0; i < linearSearchArray.length; i++) {
            linearSearchArray[i] = (int) (Math.random() * 1000000 + 1);
        }
    }

    public static boolean recursiveBinarySearch(int[] binarySearchArray, int key){

        return recursiveBinarySearchHelper(binarySearchArray, key, 0, binarySearchArray.length-1);
    }
    public static boolean recursiveBinarySearchHelper(int binarySearchArray [], int key, int low, int high){
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key == binarySearchArray[mid])
            {
                return true;
            }
            else if (key < binarySearchArray[mid])
            {
                return recursiveBinarySearchHelper(binarySearchArray, key, low, mid - 1);
            }
            else
            {
                return recursiveBinarySearchHelper(binarySearchArray, key, mid + 1, high);
            }
        }
        return false;
    }
    public static boolean recursiveLinearSearch(int linearSearchArray [], int key, int low, int high) {

        if(low == high){

            return false;
        }
        else if(linearSearchArray[low] != key){

            return recursiveLinearSearch(linearSearchArray, key, low + 1, high);
        }
        else{

            return true;
        }
    }
}