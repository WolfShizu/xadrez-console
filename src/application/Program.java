package application;

import java.util.Scanner;

import game.GameState;
import util.Functions;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Functions fun = new Functions();
		GameState gameState = new GameState();
		
		fun.setGameState(gameState);
		gameState.setFuncions(fun);
		
		gameState.createBoard();
		gameState.showRealBoard();
		
		
		}

}
