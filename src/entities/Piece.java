package entities;

abstract class Piece {

	protected String color;
	protected int positionX;
	protected int positionY;
	
	public String getColor() {
		return this.color;
		
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public void setInitialPosition (int x, int y) {
		
		this.positionX = x;
		this.positionY = y;
		
	}
}
