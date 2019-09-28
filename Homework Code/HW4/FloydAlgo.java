import java.util.*;

public class FloydAlgo {

   public static void main(String[] args) {
  
      // My Example:
      //
      // D0:
      //
      //     A   B   C   D   E
      //     
      //  A  0   3   2  Inf Inf      
      //  
      //  B  3   0   1   2  Inf
      //  
      //  C  2   1   0   4   3
      //  
      //  D Inf  2   4   0   5
      //
      //  E Inf Inf  3   5   0
      
      makeGraph();

   }
   public static void makeGraph(){
      
      Scanner input = new Scanner(System.in);
      System.out.print(" Enter Number of Vertices: ");
      int vertices = input.nextInt();
      
      double floyd[][] = new double[vertices][vertices];

      System.out.println("------------------------------------------------------------------------\n");      
      System.out.println(" Input (non-negative) values that correspond to the weight of the edges \n connected to each vertex in your graph.\n"); 
      System.out.println(" NOTE!! If there is no edge connected to a vertex, simply type in 99 \n to represent the weight as Infinity.");     
      System.out.println("\n------------------------------------------------------------------------");      

      System.out.println(" Read instructions abvove!^\n");
      for(int r = 0; r < floyd.length; r++){
         
         System.out.print(" Input values in row " + character(vertices)[r] + ": ");
         for (int c = 0; c < floyd[r].length; c++){

            floyd[r][c] = input.nextInt();
         }
                  System.out.println();

      }  
      printD0(floyd, vertices);
      calculateFloyd(floyd, vertices);
   }
   public static char[] character(int vertices){
   
      char [] characters = new char [vertices];
      
      for (int i = 0; i < characters.length; i++){
      
         characters[i] = (char)(i + 65);
      }
      return characters;
   }
   public static void printD0(double [][] floyd, int v){
      
     System.out.println("------------------------------------------------------------------------");
     System.out.print(" \n D0:\n\n");
     for (int i = 0; i < floyd.length; i++){
     
         System.out.printf(" \t%-6s", character(v)[i]);
     }
     System.out.println("\n");

     for (int r = 0; r < floyd.length; r++){
     
         System.out.printf(" %-6s", character(v)[r]);
         
         for (int c = 0; c < floyd[r].length; c++){
            double infinity = 99;
            if(floyd[r][c] == infinity){
               
               System.out.print("Infinity  ");
            }
            else{
               System.out.printf("%-8.2f", floyd[r][c]);
            }
         }
         System.out.println("\n"); 
      } 
   }   
   public static void calculateFloyd(double [][] floyd, int v){

      for (int i = 0; i < floyd.length; i++){
         System.out.println("------------------------------------------------------------------------");
         System.out.print(" D" + (i + 1) + ":" + "\n\n");
         
         for (int j = 0; j < character(v).length; j++){
            System.out.printf(" \t%-6s", character(v)[j]);
         }
         System.out.println();

         for (int r = 0; r < floyd.length; r++){
         System.out.println();    
          
         System.out.printf(" %-6s", character(v)[r]);
         
            for (int c = 0; c < floyd[r].length; c++){
                                 
               if(floyd[r][c] > floyd[r][i] + floyd[i][c]){
                  
                  floyd[r][c] = floyd[r][i] + floyd[i][c];
               }
               double infinity = 99;

               if(floyd[r][c] == infinity){
               
               System.out.print("Infinity  ");
               }
               else{
                  System.out.printf("%-8.2f", floyd[r][c]);
               }
            }
            System.out.println("\n"); 
         }
      }
      System.out.println("------------------------------------------------------------------------");
      System.out.println(" Interpreting the output:\n");
      System.out.println(" Notice as you look at each graph the values update, until the end, \n showing the shortest path taken between all pairs of vertices");
   }
}