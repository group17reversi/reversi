package Reversi;

import javax.swing.JOptionPane;

public class GameOver {
	boolean gameOver = false;
	boolean canPlace = true;
	boolean full = false;
	int[][] allChess;
	public GameOver(int[][] c) {
		this.allChess = c;
	}
	public void isGameOver() {
		isFull();
		canPlace();
		if(Full() == true) {
			gameOver = true;
		}else {
			if(Place() == true) {
				gameOver = false;
			}else {
				Chess chess = new Chess(allChess);
				chess.Count();
				if(chess.Black() == 0 || chess.White() == 0) {
					gameOver = true;
				}else {
					gameOver = false;
				}
			}
		}
	}
	public void isFull() {
		Chess chess = new Chess(allChess);
		chess.Count();
		if(chess.Black() + chess.White() == 64) {
			full = true;
		}else {
			full = false;
		}
	}
	public void canPlace() {
		int num = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(allChess[i][j] == 3) {
					num ++;
				}
			}
		}
		if(num > 0) {
			canPlace = true;
		}else {
			canPlace = false;
		}
	}
	public boolean Over() {
		return gameOver;
	}
	public boolean Place() {
		return canPlace;
	}
	public boolean Full() {
		return full;
	}
}
