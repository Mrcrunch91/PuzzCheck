



import java.io.*;
import java.util.*;


public class Suk {
   private final static int horse = 3;
   private final static int SIZE = 9;
   
   public static int checkBox(int[][] matrix, int startRow, int startCol){
            
      
       for(int i = startRow; i<(startRow + horse); i++){
           for(int j = startCol; j< (startCol + horse); j++){               
               for(int k = startRow; k<(startRow + horse); k++){
                     for(int p = startCol; p < (startCol + horse); p++){               
                            if(matrix[i][j] == matrix[k][p] && k != i)
                                return 1;
                          
       
                          }
       }                        
       
                          }
       }      
        return 0;      
   }
   
    public static int checkBoxes(int[][] matrix){
        for(int i = 0; i<SIZE; i+=horse){
            for(int j = 0; j< SIZE; j+=horse){
             if(checkBox(matrix,i,j) == 1)
                 return 1;
            }
        }
        return 0;
    }    
    
    public static  int checkRow(int[][] matrix){
       
        
        for(int i = 0; i<SIZE; i++){
             int[] freq = new int [SIZE+1];
        
        for(int count = 0; count<= SIZE;count++){
            freq[count] = 0;
        }
            for(int j = 0; j<SIZE; j++){
                freq[matrix[j][i]]++;
            }            
        
        
         for(int count = 1; count<= SIZE;count++){
            if(freq[count]!= 1){
                return 1;
            }         
        
    }
        }
         return 0;
    }
    
    public static int checkCol(int[][] matrix){
        
        
        for(int i = 0; i< SIZE;i++){
            int[] freq = new int[SIZE+1];
            
            for(int q = 0; q<=SIZE;q++){
                freq[q]= 0;
            }
            for(int j = 0; j<SIZE; j++){
                freq[matrix[i][j]]++;
            }
        
        
        for(int count = 1; count<=SIZE; count++){
            if(freq[count]!= 1){
                return 1;
            }
        }
        }
        return 0;
    }
    
    public static int startMatrix(int[][] matrix){
        if((checkBoxes(matrix) == 0)){
            if(checkRow(matrix) == 0){
                if(checkCol(matrix) == 0){
                    return 0;
                }else return 1;
                    
            }else return 1;
        }else return 1;
        
    }

    public static void main(String[] args) throws IOException {
        
       
        int matrix[][] = new int[SIZE][SIZE];
        int count ;        
        int j = 0;  
            Scanner input = new Scanner(new FileReader("sudokode.in"));
            count = input.nextInt();
         System.out.println(count);
           for(int i = 0; i < count; i++){
               
               while(input.hasNextLine()){                   
                   
                       String hold = input.next();
                       
                       for(int k = 0; k< SIZE; k++){                          
                           matrix[j][k] = hold.charAt(k)- '0'; 
                           
                       }                       
                   j++;
                   if(j == 9){
                      j=0;break;                       
                   }
               }
               if(startMatrix(matrix) == 0){
                   System.out.println("YES");
               }else{
                   System.out.println("NO");
               }
           }
          
}
}