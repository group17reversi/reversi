package Reversi;

public class Initialize {
	int[][] allChess;
	public Initialize(int[][] allChess) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if((i == 3 && j == 3) || (i == 4 && j == 4)) {
					allChess[i][j] = 1;
				}
				else if((i == 4 && j == 3) || (i == 3 && j == 4)) {
					allChess[i][j] = 2;
				}
				else {
					allChess[i][j] = 0;
				}
			}
		}
	}
}
