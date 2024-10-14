package application;

import java.util.Scanner;

import game.Board;
import game.GameState;
import util.Functions;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Functions fun = new Functions();
		GameState game = new GameState();
		Board board = new Board();
		
		fun.setGameState(game);
		board.createPieces();
		
		
		}

}
