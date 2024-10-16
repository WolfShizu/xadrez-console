package entities;

public abstract class Piece {

	protected String color;
	// Linha
	protected int positionX;
	// Coluna
	protected int positionY;
	protected String name;

	public Piece (int positionX, int positionY, String color, String name) {
		
		this.positionX = positionX;
		this.positionY = positionY;
		this.color = color;
		this.name = name;
		
	}
	
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
