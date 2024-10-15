package entities;

public abstract class Piece {

	protected String color;
	protected int positionX;
	protected int positionY;
	protected String name;
	
//	public void setInitialPosition (int x, int y) {
//		
//		this.positionX = x;
//		this.positionY = y;
//		
//	}

	public String getColor() {
		return this.color;
		
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	
	public String getName() {
		return this.name;
	}
	
}
