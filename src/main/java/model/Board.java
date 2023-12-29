package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size ;
    public PlayingPiece[][] board ;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public List<int[]> getAllEmptyCells(){
        List<int[]> freeCells = new ArrayList<>();
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j <size ; j++){
                if(board[i][j] == null)
                    freeCells.add(new int[]{i,j});
            }
        }
        return freeCells;
    }

    public boolean addPiece(int i , int j , PlayingPiece piece){
        if(board[i][j] != null)
            return false ;
        else
            board[i][j] = piece;
        return true ;
    }

    public void printBoard(){
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(board[i][j]  != null)
                     System.out.print(board[i][j].piece.name()+" ");
                else
                    System.out.print("  ");
                System.out.print("|");
            }
            System.out.println();

        }
    }



}

