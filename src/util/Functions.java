package util;

import game.GameState;

public class Functions {
	
	private GameState game;
	
	private String[] letters = {"a","b","c","d","e","f","g","h"};
	
	public void setGameState(GameState game) {
		this.game = game;
	}
	
	public void createBoard() {
		String[][] board = createBaseBoard();
		
		  
		
	}
	
	private String[][] createBaseBoard() {	
		String[][] baseGrid = new String[10][10];

		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				baseGrid[i][j] = "   ";
			}
		}
		
		for(int i = 2; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				baseGrid[i][j] = "[ ]";
			}
		}
		
		for(int i = 2; i < 10; i++) {
			baseGrid[0][i] = "[" + this.letters[i-2] + "]"; 
			baseGrid[i][0] = "[" + String.valueOf(i-1) + "]";
		}
		return baseGrid;
	}
	
//	colocar  na classe do gamestate
//	public void showBoard() {
//		for(int i = 0; i< 10; i++) {
//			System.out.println();
//			for(int j = 0; j < 10; j++) {
//				System.out.print(game.getBoard[i][j]);
//			}
//		}
//		
//	}
	
}
