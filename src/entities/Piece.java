package entities;

public abstract class Piece {

	protected boolean[][] validPosition;

	protected String color;
	protected Integer positionX; // Linha
	protected Integer positionY; // Coluna
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
	
	public void die() {
		this.positionX = null;
		this.positionY = null;
	}
	
}
