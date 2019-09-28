import java.util.*;
import java.io.*;
public class Homework2{
   
   public static int[] dataSort1;
   public static int[] dataSort2;
   public static int[] dataSort3;
   public static int[] dataSort4;

   public static void main (String [] args)throws Exception{

         System.out.print("Enter file name: ");//User needs to enter an existing file
         Scanner inputFile = new Scanner(System.in);//Preps the user to enter a file name
         File file = new File(inputFile.nextLine());//When user enters a file name, this tells the scanner its scanning a file
         System.out.print("Enter output file name:\t");
         File outFile = new File(inputFile.nextLine());
      try{
         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));//Reads the file
     
         String data1 = br.readLine();
         String[] dataArray1 = data1.split(" ");
         dataSort1 = new int [dataArray1.length];
         for (int i = 0; i < dataArray1.length; i++){
            dataSort1[i] = Integer.parseInt(dataArray1[i]);
         }
         br.readLine();
         String data2 = br.readLine();
         String[] dataArray2 = data2.split(" ");
         dataSort2 = new int [dataArray2.length];
         for (int i = 0; i < dataArray2.length; i++){
            dataSort2[i] = Integer.parseInt(dataArray2[i]);
         }
         br.readLine();
         String data3 = br.readLine();
         String[] dataArray3 = data3.split(" ");
         dataSort3 = new int [dataArray3.length];
         for (int i = 0; i < dataArray3.length; i++){
            dataSort3[i] = Integer.parseInt(dataArray3[i]);
         }
         br.readLine();
         String data4 = br.readLine();
         String[] dataArray4 = data4.split(" ");
         dataSort4 = new int [dataArray4.length];
         for (int i = 0; i < dataArray4.length; i++){
            dataSort4[i] = Integer.parseInt(dataArray4[i]);
         }
           br.close();
      }
      catch(Exception e){
         System.out.println("Error" + e);   
         }
         System.out.println("\nRandom Data: \n");
         long T1 = System.nanoTime();
         bubbleSort(dataSort1);
         long T2 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Bubble sort method: " + (T2 - T1) + " NanoSeconds" + "\n");
         
         long T3 = System.nanoTime();
         insertionSort(dataSort1);
         long T4 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Insertion sort method: " + (T4 - T3) + " NanoSeconds" + "\n");
         
         long T5 = System.nanoTime();
         selectionSort(dataSort1);
         long T6 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Selection sort method: " + (T6 - T5) + " NanoSeconds" + "\n");      
         
         long T7 = System.nanoTime();
         mergeSort(dataSort1, 0, dataSort1.length - 1);
         long T8 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Merge sort method: " + (T8 - T7) + " NanoSeconds" + "\n");      
         
         System.out.println("-------------------------------------------------");
         System.out.println("\nAll Ones Data: \n");
         long T9 = System.nanoTime();
         bubbleSort(dataSort2);
         long T10 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Bubble sort method: " + (T10 - T9) + " NanoSeconds" + "\n");
         
         long T11 = System.nanoTime();
         insertionSort(dataSort2);
         long T12 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Insertion sort method: " + (T12 - T11) + " NanoSeconds" + "\n");
         
         long T13 = System.nanoTime();
         selectionSort(dataSort2);
         long T14 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Selection sort method: " + (T14 - T13) + " NanoSeconds" + "\n");
         
         long T15 = System.nanoTime();
         mergeSort(dataSort2, 0, dataSort2.length - 1);
         long T16 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Merge sort method: " + (T16 - T15) + " NanoSeconds" + "\n");
         
         System.out.println("-------------------------------------------------");
         System.out.println("\nSorted Data: \n");
         long T17 = System.nanoTime();
         bubbleSort(dataSort3);
         long T18 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Bubble sort method: " + (T18 - T17) + " NanoSeconds" + "\n");
         
         long T19 = System.nanoTime();
         insertionSort(dataSort3);
         long T20 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Insertion sort method: " + (T20 - T19) + " NanoSeconds" + "\n");
         
         long T21 = System.nanoTime();
         selectionSort(dataSort3);
         long T22 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Selection sort method: " + (T22 - T21) + " NanoSeconds" + "\n");
         
         long T23 = System.nanoTime();
         mergeSort(dataSort3, 0, dataSort3.length - 1);
         long T24 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Merge sort method: " + (T24 - T23) + " NanoSeconds" + "\n");
        
         System.out.println("-------------------------------------------------");
         System.out.println("\nReverse Data: \n");
         long T25 = System.nanoTime();
         bubbleSort(dataSort4);
         long T26 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Bubble sort method: " + (T26 - T25) + " NanoSeconds" + "\n");
         
         long T27 = System.nanoTime();
         insertionSort(dataSort4);
         long T28 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Insertion sort method: " + (T28 - T27) + " NanoSeconds" + "\n");
         
         long T29 = System.nanoTime();
         selectionSort(dataSort4);
         long T30 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Selection sort method: " + (T30 - T29) + " NanoSeconds" + "\n");
         
         long T31 = System.nanoTime();
         mergeSort(dataSort4, 0, dataSort4.length - 1);
         long T32 = System.nanoTime();
         System.out.println("\n\nApproximate time to perform Merge sort method: " + (T32 - T31) + " NanoSeconds" + "\n");
      
       
      try {
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
         for(int i = 0; i < dataSort1.length; i++){
            bw.write(dataSort1[i] + " ");
         }
         bw.newLine();
         bw.newLine();
         
         for(int i = 0; i < dataSort2.length; i++){
            bw.write(dataSort2[i] + " ");
         }
         bw.newLine();
         bw.newLine();
         
         for(int i = 0; i < dataSort3.length; i++){
            bw.write(dataSort3[i] + " ");
         }
         bw.newLine();
         bw.newLine();
         
         for(int i = 0; i < dataSort4.length; i++){
            bw.write(dataSort4[i] + " ");
         }
         bw.close();
      }
      catch(IOException e){
         
         System.out.println("Error" + e);
         }
      }
      public static void bubbleSort(int [] dataLine)throws Exception{
  
      int temp = 0;
      for(int i = 0; i < dataLine.length; i++){
         for(int j = 1; j < dataLine.length - i; j++){   
         
            if (dataLine[j - 1] > dataLine[j]){
            
               temp = dataLine[j - 1];
               dataLine[j - 1] = dataLine[j];
               dataLine[j] = temp;
            }
         }
      }
   }
   public static void insertionSort(int [] dataLine){
   
      int temp;
      for (int i = 1; i < dataLine.length; i++){
         for (int j = i; j > 0; j--){
           if(dataLine[j] < dataLine[j - 1]){
               temp = dataLine[j];
               dataLine[j] = dataLine[j - 1];
               dataLine[j - 1] = temp;
           } 
         }
      }
   }
   public static void selectionSort(int [] dataLine){

      for(int i = 0 ; i < dataLine.length - 1; i++){
         
         int currentMin = dataLine[i];
         int currentMinIndex = i;
         
         for (int j = i + 1; j < dataLine.length; j++){
            
            if(currentMin > dataLine[j]){
               currentMin = dataLine[j];
               currentMinIndex = j;
            }
         }
         if(currentMinIndex != i){
            
            dataLine[currentMinIndex] = dataLine[i];
            dataLine[i] = currentMin;  
         }
      }

   }
    public static void merge(int newArray[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 =  r - m;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (i = 0; i < n1; i++)
            leftArray[i] = newArray[l + i];
        for (j = 0; j < n2; j++)
            rightArray[j] = newArray[m + 1+ j];

        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2)
        {
            if (leftArray[i] <= rightArray[j])
            {
                newArray[k] = leftArray[i];
                i++;
            }
            else
            {
                newArray[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            newArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            newArray[k] = rightArray[j];
            j++;
            k++;
        }
    }

   public static void mergeSort(int newArray[], int l, int r)
   {
      if (l < r)
      {
        int m = l+(r-l)/2;

        mergeSort(newArray, l, m);
        mergeSort(newArray, m+1, r);
        merge(newArray, l, m, r);
        
      }
   }

}
