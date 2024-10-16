package util;

import game.GameState;

public class Functions {
	
	GameState gameState;
	
	private String[] letters = {"a","b","c","d","e","f","g","h"};
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	public String[][] createRealBoard() {	
		String[][] realBoard = new String[10][10];

		// Cria os espaços em cadda célula
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				realBoard[i][j] = "   ";
			}
		}
		
		// Cria o guia de coordenadas
		for(int i = 2; i < 10; i++) {
			realBoard[0][i] = "[" + this.letters[i-2] + "]"; 
			realBoard[i][0] = "[" + String.valueOf(10-i) + "]";
		}
		return realBoard;
	}
	
	public String[][] createGameBoard(){
		String gameBoard[][] = new String[8][8];
		for (int i = 0; i <8; i++) {
			for (int j = 0; j<8; j++) {
				gameBoard[i][j] = "[ ]";
			}
		}
		return gameBoard;
		
	}
	
	public void updateBoard(String[][] gameBoard) {
		String[][] realBoard = gameState.getRealBoard();
		
		for (int i = 2; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				realBoard[i][j] = gameBoard[i-2][j-2];
			}
		}
		gameState.setRealBoard(realBoard);
	}
		
}
