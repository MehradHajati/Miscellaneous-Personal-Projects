// Mehrad Hajati
// This is a treasure hunting game where the player is on a 2d grid, each position in the grid is either North (N), South (S), East (E), West(W) or True(T)
// The first four represent the compass direction to go and T represents the position where the treasure is
// The game continues until the treasure is found and you win or you reach a position you have visited before and you lose or you move off the board.
// You start at position 0,0 ie the top left position in grid
// N takes you one row up, S takes you one row down, W takes you one column to the left and E takes you one column to the right
// Input File format: - the first line is two positive integers seperated by a space represting the rows (R) and columns (C) respectively
//                       - each of the next R lines contains C characters; the only characters that appear are N, S, W, E, or T (and there is only one T)

import java.util.*;
import java.io.*;

/**
 * Author: Mehrad Hajati
 * Date: 2020/12/13
 */
public class TreasureHuntGame{
    
    //Constants 
    public static final int FELL_OFF = -1;
    public static final int GOING_IN_CIRCLES = -2;

    //Instance Variables
    private int numRows;
    private int numColumns;
    private char[][] gameBoard;

    //Constructor
    public GridGame(int rows, int columns, char[][] board){
        this.numRows = rows;
        this.numColumns = columns;
        this.gameBoard = new char[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int b = 0; b < columns; b++){
                this.gameBoard[i][b] = board[i][b];
            }
        }
    }


    //PlayGame method
    // in this method another boolean array was created to keep track of where we have been before, if one position is ever that we arrive at is true
    // we know were are going in circles and we return the appropriate constant
    // The only way we fall of the board is if have an ArrayOutOfBounds exception so we create a try and catch statement, if it is ever caught the appropriate constatn is returned
    // The while loop will keep us moving as long as we are not at T if we ever arrive without a hiccup, we return the number of moves with the movescounter variable
    public int playGame(){
        boolean[][] visited = new boolean[numRows][numColumns];
        int rowLocation = 0; 
        int columnLocation = 0;
        int movesCounter = 0;
        try{
            while (!(this.gameBoard[rowLocation][columnLocation] == 'T')){
                if (visited[rowLocation][columnLocation]){
                    return GOING_IN_CIRCLES;
                }
                else{
                    visited[rowLocation][columnLocation] = true;
                    if (this.gameBoard[rowLocation][columnLocation] == 'W'){
                        movesCounter++; 
                        columnLocation--;
                    }
                    if (this.gameBoard[rowLocation][columnLocation] == 'E'){
                        movesCounter++; 
                        columnLocation++;
                    }
                    if (this.gameBoard[rowLocation][columnLocation] == 'S'){
                        movesCounter++; 
                        rowLocation++;
                    }
                    if (this.gameBoard[rowLocation][columnLocation] == 'N'){
                        movesCounter++; 
                        rowLocation--;
                    }
                }
            }
            return movesCounter;
        }
        catch (ArrayIndexOutOfBoundsException ex){
            return FELL_OFF;
        }
    }// End of playGame method

    
    public static void main(String[] args){
        System.out.println("Please type the path for your selected file");
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        File file = new File(path);
        try{
            Scanner sc2 = new Scanner(file);
            int numRows = sc2.nextInt();
            int numColumns = sc2.nextInt();
            char[][] board = new char[numRows][numColumns];
            for (int i = 0; i < numRows; i++){
                String line = sc2.next();
                for (int b = 0; b < numColumns; b++){
                    board[i][b] = line.charAt(b);
                }
            }
            sc2.close();
            GridGame game = new GridGame(numRows, numColumns, board);
            int result = game.playGame();
            if (result == GridGame.FELL_OFF){
                System.out.println("I fell off the board!");
            }
            else if(result == GridGame.GOING_IN_CIRCLES){
                System.out.println("I'm really lost :(");
            }
            else{
                System.out.println("I reached the treasure in " + result + " turns");
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("There was a file not found exception");
        }

    }// End of Main Method

}// End of TreasureHuntGame class