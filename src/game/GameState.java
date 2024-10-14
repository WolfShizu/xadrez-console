package game;

import java.util.ArrayList;
import java.util.List;

import entities.Pawn;

public class GameState {
	private List<Pawn> whitePawnList = new ArrayList<>();
	private List<Pawn> BlackPawnList = new ArrayList<>();
	
	private String[][] realBoard = new String[10][10];
	
	public void setBoard(String[][] board) {
		this.realBoard = board;
	}
	
	public String[][] getRealBoard(){
		return this.realBoard;
	}
	
	public void setRealBoard(String[][] realBoard) {
		this.realBoard = realBoard;
	}
	
	public void createPieces() {
		
		for (int i = 0; i < 8; i++) {
			whitePawnList.add(new Pawn(i+2, 2+2, "white"));
			BlackPawnList.add(new Pawn(i+2, 7+2, "black"));
		}
	}
	
	public void placePieces() {
		
	}
	
}
