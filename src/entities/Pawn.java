package entities;

public class Pawn extends Piece {

	private int moves = 0;

	public Pawn(int positionX, int positionY, String color, String name) {

		super(positionX, positionY, color, name);

	}

	public boolean pawnMove(int targetX, int targetY, boolean piece) {
		
		// movimentação básica
		if(targetY == this.positionY) {
			if (targetX == (this.positionX + 1) || (targetX == (this.positionX + 2) && moves == 0)) {
				this.positionX = targetX;
				this.positionY = targetY;
				return true;
			}
		}
		
		// movendo e capturando peça (a peça é capturada fora desse objeto)
		if ((targetY == (this.positionY + 1) || targetY == (this.positionY - 1)) &&
			targetX == (this.positionX + 1) && piece == true) {
			this.positionX = targetX;
			this.positionY = targetY;
			return true;
		}
		return false;
	}

}
