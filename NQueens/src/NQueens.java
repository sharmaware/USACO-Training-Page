/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author saarthaksharma
 */
public class NQueens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 8;
        int board[][] = new int [n][n];
        
        board = nQueens(n, 0, 0, board);
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int [][] nQueens(int n, int x, int y, int [][] board){
        if(n == 0){return board;}
        
        if(isOpen(x,y, board) == true){
            n-=1;
            board[x][y] = 1;
            return nQueens(n, x, y, board);
        }
        else{
            if(x < board.length){
                return nQueens(n, x+1, y, board);
            }
            else{
                if(y < board[0].length){
                    return nQueens(n, 0, y+1, board);
                }
                else{
                    //undo, i = c; j =r
                    int k = 1;
                    int i,j = board.length;
                    for(i = board.length-1; i >= 0; i--){
                        for(j = board[0].length-1; j >= 0; j--){
                            if(board[i][j] == 1 && k > 0){
                                board[i][j] = 0;
                                k -= 1;                              
                            }
                        }
                    }
                    if(i < board.length){
                        return nQueens(n+1, i+1, j, board);
                    }
                    else{
                        if(y < board[0].length){
                            return nQueens(n+1, 0, y+1, board);
                        }
                        else{
                            //failure
                            int [][] failure = new int [board.length][board[0].length];
                            return failure;
                        }
                    } 
                }
            }
        }
    }
    
    
    public static boolean isOpen(int x, int y, int [][] board){
        if(isOpenHorizontal(x, y, board) && isOpenVertical(x, y, board) && isOpenHorizontal(x, y, board) == true){
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean isOpenHorizontal(int x, int y, int [][] board){
       for(int i =0; i < board.length; i++){
           if(board[i][y] == 1){
               return false;
           }         
       }
       return true;
    }
    private static boolean isOpenVertical(int x, int y, int [][] board){
       for(int i =0; i < board[0].length; i++){
           if(board[x][i] == 1){
               return false;
           }    
       }
       return true;
    }
    /*Fix this */
    private static boolean isOpenDiagonal(int x, int y, int [][] board){
        boolean diagonalUp = false;
        boolean diagonalDown = false;
               
        for(int i = 0; i < board.length; i++){
            if(board[i][i] == 1){
                return false;
            }
        }
        return true;
    }
}
