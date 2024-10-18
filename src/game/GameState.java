package game;

import java.util.ArrayList;
import java.util.List;

import entities.*;
import util.Functions;

public class GameState {
	
	private Functions fun;
	
	private List<Piece> pieceList = new ArrayList<>();
	
	private String[][] realBoard;
	private String[][] gameBoard;
	
	public void setFuncions (Functions fun) {
		this.fun = fun;
	}
	
	public String[][] getRealBoard(){
		return this.realBoard;
	}
	
	public void setRealBoard(String[][] realBoard) {
		this.realBoard = realBoard;
	}
	
	public Piece getPiece(int targetX, int targetY) {
		
		for (Piece piece : pieceList) {	
			int sourceX = piece.getPositionX();
			int sourceY = piece.getPositionY();
			
			if (sourceX == targetX && sourceY == targetY) {
				return piece;
			}
		}
		return null;
	}
	
	public void createPieces() {
		
		for (int j = 0; j < 8; j++) {
			pieceList.add(new Pawn(1, j, "black", "[p]"));
			pieceList.add(new Pawn(6, j, "white", "[P]"));
		}
		
		pieceList.add(new Rook(0, 0, "black", "[r]"));
		pieceList.add(new Rook(0, 7, "black", "[r]"));
		pieceList.add(new Rook(7, 0, "white", "[R]"));
		pieceList.add(new Rook(7, 7, "white", "[R]"));
		
		pieceList.add(new Knight(0, 1, "black", "[h]"));
		pieceList.add(new Knight(0, 6, "black", "[h]"));
		pieceList.add(new Knight(7, 1, "white", "[H]"));
		pieceList.add(new Knight(7, 6, "white", "[H]"));
		
		pieceList.add(new Bishop(0, 2, "black", "[b]"));
		pieceList.add(new Bishop(0, 5, "black", "[b]"));
		pieceList.add(new Bishop(7, 2, "white", "[B]"));
		pieceList.add(new Bishop(7, 5, "white", "[B]"));
		
		pieceList.add(new Queen(0, 3, "black", "[q]"));
		pieceList.add(new Queen(7, 3, "white", "[Q]"));
		pieceList.add(new King(0, 4, "black", "[k]"));
		pieceList.add(new King(7, 4, "white", "[K]"));
		
	}
	
	
	
	public void placePieces() {
		
		for (Piece piece : pieceList) {
			
			String name = piece.getName();
			int positionX = piece.getPositionX();
			int positionY = piece.getPositionY();
			
			this.gameBoard[positionX][positionY] = name;
			
		}
		
		fun.updateBoard(this.gameBoard);
		
	}
	
	public void createBoard() {
		
		this.realBoard = fun.createRealBoard();
		this.gameBoard = fun.createGameBoard();
		createPieces();
		placePieces();
	}
	
	public void showRealBoard() {
		
		for (int i = 0; i < 10; i++) {
			System.out.println();
			for (int j = 0; j < 10; j++) {
				System.out.print(this.realBoard[i][j]);
			}
		}
	}
	
}
