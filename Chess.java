package Reversi;

import java.awt.Color;
import java.awt.Graphics;

public class Chess {
	//0 不可下棋点，1 黑棋（玩家），2 白棋（电脑）, 3可下棋点
	int [][] allChess = new int[8][8];
	int black = 0;
	int white = 0;
	
	public Chess (int[][] c) {
		this.allChess = c;
	}
	
	public void Draw (Graphics g) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(allChess[i][j] == 1) {
					int tempX = 42 + i * Constant.Grid_Length + Constant.Grid_Length / 2;
					int tempY = 64 + j * Constant.Grid_Length + Constant.Grid_Length / 2;
					Color c = g.getColor();
					g.setColor(Color.BLACK);
					g.fillOval(tempX - Constant.ChessRadius , tempY - Constant.ChessRadius , Constant.ChessRadius * 2 , Constant.ChessRadius * 2);
					g.setColor(c);
				}
				if(allChess[i][j] == 2){
					int tempX = 42 + i * Constant.Grid_Length + Constant.Grid_Length / 2;
					int tempY = 64 + j * Constant.Grid_Length + Constant.Grid_Length / 2;
					Color c = g.getColor();
					g.setColor(Color.WHITE);
					g.fillOval(tempX - Constant.ChessRadius , tempY - Constant.ChessRadius , Constant.ChessRadius * 2 , Constant.ChessRadius * 2);
					g.setColor(c);
				}
				if(allChess[i][j] == 3) {
					int tempX = 42 + i * Constant.Grid_Length + Constant.Grid_Length / 2;
					int tempY = 64 + j * Constant.Grid_Length + Constant.Grid_Length / 2;
					Color c = g.getColor();
					g.setColor(Color.DARK_GRAY);
					g.fillOval(tempX - 5 , tempY - 5 , 10 , 10);
					g.setColor(c);
				}
			}
		}
	}
	public void Count() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(allChess[i][j] == 1) {
					black++;
				}
				if(allChess[i][j] == 2) {
					white++;
				}
			}
		}
	}
	public int Black() {
		return black;
	}
	
	public int White() {
		return white;
	}
}
