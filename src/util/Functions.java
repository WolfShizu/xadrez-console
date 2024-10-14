package util;

import game.GameState;

public class Functions {
	
	GameState gameState = new GameState();
	
	private String[] letters = {"a","b","c","d","e","f","g","h"};
	
	public void setBoard(GameState board) {
		this.gameState = board;
	}
	
	private String[][] createBaseBoard() {	
		String[][] baseBoard = new String[10][10];

		// Cria os espaços em cadda célula
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				baseBoard[i][j] = "   ";
			}
		}
		
		// Cria os espaços do tabuleiro em cada célula do tabuleiro
		for(int i = 2; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				baseBoard[i][j] = "[ ]";
			}
		}
		
		// Cria o guia de coordenadas
		for(int i = 2; i < 10; i++) {
			baseBoard[0][i] = "[" + this.letters[i-2] + "]"; 
			baseBoard[i][0] = "[" + String.valueOf(i-1) + "]";
		}
		return baseBoard;
	}
	
	private void updateBoard(String[][] realBoard2) {
		String[][] realBoard = gameState.getRealBoard();
		
		for (int i = 2; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				
				realBoard[i][j] = realBoard2[i-2][j-2];
				
			}
			
		}
		
		gameState.setBoard(realBoard);
		
	}
	
	
		
}
