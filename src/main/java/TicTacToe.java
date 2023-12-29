import model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TicTacToe {
    Deque<Player> players ;
    Board gameBoard ;

    void intializeBoard(int size){
        gameBoard = new Board(size);
        players = new LinkedList<>();
        Player xPlayer = new Player("PlayerX",new PlayingPieceX());
        Player oPlayer = new Player("PlayerO",new PlayingPieceO());
        players.add(xPlayer);
        players.add(oPlayer);
        System.out.println("Winner of Game is "+ startGame());
    }

    String startGame() {
        boolean isWinner = false;
        while (!isWinner) {
            List<int[]> freeCells = gameBoard.getAllEmptyCells();
            if (freeCells.size() == 0) {
                break;
            }
            gameBoard.printBoard();
            Player player = players.removeFirst();
            //System.out.println( player.getPlayingPiece().getPiece().name() + " "+ player.getName());
            Scanner sc = new Scanner(System.in);
            int row = sc.nextInt();
            int col = sc.nextInt();
            boolean isPieceAdded = gameBoard.addPiece(row, col, player.getPlayingPiece());
            if (!isPieceAdded) {
                System.out.println("Incorret position chosen, try again");
                players.addFirst(player);
                continue;
            }
            if(isWinner(row , col , player.getPlayingPiece())){
                return player.getName();

            }

            players.addLast(player);


        }

        return "tie";

    }

    boolean isWinner (int row , int col , PlayingPiece piece){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;
            for(int i = 0 ; i < gameBoard.size ; i++){
                if(gameBoard.board[row][i] == null || gameBoard.board[row][i] != piece ) {
                    rowMatch = false;
                    break;
                }
            }
            for(int i = 0 ; i < gameBoard.size ; i++) {
                if (gameBoard.board[i][col] == null || gameBoard.board[i][col] != piece) {
                    columnMatch = false;
                    break;
                }
            }

            for(int i = 0 , j = 0  ; i < gameBoard.size ; i++ , j++) {
                if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != piece) {
                    diagonalMatch = false;
                break;
            }
        }

        for(int i = 0 , j = gameBoard.size - 1   ; i < gameBoard.size ; i++ , j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j] != piece) {
                antiDiagonalMatch = false;
                break;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch ;


    }
}
