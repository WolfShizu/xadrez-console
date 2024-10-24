package util;

import entities.Piece;
import game.GameState;

public class Functions {

	GameState gameState;

	private String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h" };

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public String[][] createRealBoard() {
		String[][] realBoard = new String[10][10];

		// Cria os espaços em cadda célula
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				realBoard[i][j] = "   ";
			}
		}

		// Cria o guia de coordenadas
		for (int i = 2; i < 10; i++) {
			realBoard[0][i] = "[" + this.letters[i - 2] + "]";
			realBoard[i][0] = "[" + String.valueOf(10 - i) + "]";
		}
		return realBoard;
	}

	public String[][] createGameBoard() {
		String gameBoard[][] = new String[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				gameBoard[i][j] = "[ ]";
			}
		}
		return gameBoard;

	}

	public void updateBoard(String[][] gameBoard) {
		String[][] realBoard = gameState.getRealBoard();

		for (int i = 2; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				realBoard[i][j] = gameBoard[i - 2][j - 2];
			}
		}
		gameState.setRealBoard(realBoard);
	}

	public String getCurrentRoundColor(int turn) {
		return (turn % 2 == 0) ? "black" : "white";
	}

	public boolean movePiece(String sourceCoord, String targetCoord, String roundColor) {
		// confere se as coordenadas estão corretas e separa elas
		Integer sourceX = this.getAndValidateCoordX(sourceCoord), sourceY = this.getAndValidateCoordY(sourceCoord);
		Integer targetX = this.getAndValidateCoordX(targetCoord), targetY = this.getAndValidateCoordY(targetCoord);

		boolean isTargetPiece = false;

		Piece source, target;

		// confere se a origem é uma peça e guarda o objeto
		if (this.validateSource(sourceX, sourceY, roundColor)) {
			source = gameState.getPiece(sourceX, sourceY);
		} else {
			return false;
		}

		// confere o que é o alvo, se ele é valido e guarda ele
		switch (this.validateTarget(targetX, targetY, roundColor)) {
		case "INVALID":
			return false;

		case "CELL":
			isTargetPiece = false;
			break;

		case "PIECE":
			isTargetPiece = true;
			break;
		}

		// faz a movimentação e a captura de peça
		if (source.move()) {
			if (isTargetPiece) {
				target = gameState.getPiece(targetX, targetY);
				target.die();
			}
			return true;

		}
		return false;
	}

	private Integer getAndValidateCoordX(String coord) {
		int x;

		if (coord.length() > 2) {
			return null;
		}

		if (Character.isDigit(coord.charAt(1))) {
			x = coord.charAt(1) - '0';
		} else {
			return null;
		}

		if (x <= 8 && x > 0) {
			return x - 1;
		}

		return null;
	}

	private Integer getAndValidateCoordY(String coord) {
		if (coord.length() > 2) {
			return null;
		}

		String y = "" + coord.charAt(0);

		for (int i = 0; i < 8; i++) {

			if (this.letters[i].equals(y)) {
				return i;
			}

		}
		return null;
	}

	private boolean validateSource(int sourceX, int sourceY, String turn) {
		Piece sourcePiece = gameState.getPiece(sourceX, sourceY);

		if (sourcePiece == null || sourcePiece.getColor() != turn) {
			return false;
		}
		return true;
	}

	private String validateTarget(int targetX, int targetY, String turn) {
		Piece targetPiece = gameState.getPiece(targetX, targetY);

		if (targetPiece == null) {
			return "CELL";
		}

		if (targetPiece.getColor() != turn) {
			return "PIECE";
		}

		return "INVALID";
	}
}
