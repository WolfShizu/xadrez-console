package game;

import java.util.ArrayList;
import java.util.List;

import entities.Pawn;

public class Board {
	private List<Pawn> whitePawnList = new ArrayList<>();
	private List<Pawn> BlackPawnList = new ArrayList<>();
	
	public void createPieces() {
		
		for (int i = 0; i < 8; i++) {
			whitePawnList.add(new Pawn(i+2, 2+2, "white"));
			BlackPawnList.add(new Pawn(i+2, 7+2, "white"));
		}
	}
	
	public void placePieces() {
		
	}
	
}
