package game;

import java.util.ArrayList;
import java.util.List;

import entities.Pawn;
import entities.Piece;
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
	
	public void createPieces() {
		
		for (int j = 0; j < 8; j++) {
			pieceList.add(new Pawn(1, j, "black", "[p]"));
			pieceList.add(new Pawn(6, j, "white", "[P]"));
		}
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
