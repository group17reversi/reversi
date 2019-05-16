package reversi;

import java.awt.Graphics;

public class ChessState {
	int [][] allChess = new int[8][8];
	boolean isBlack;
	
	public ChessState(int[][] c, boolean isB) {
		this.allChess = c;
		this.isBlack = isB;
	}
	public void judgeState() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(allChess[i][j] == 3) {
					allChess[i][j] = 0;
				}
			}
		}
		if (isBlack == false) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					if(allChess[i][j] == 2) {
						if(i - 1 > 0 && allChess[i - 1][j] == 1) {
							int m = i - 1;
							while(m >= 0 && allChess[m][j] == 1) {
								m--;
							}
							if(m >= 0 && allChess[m][j] == 0) {
								allChess[m][j] = 3;
							}
						}
						if(i + 1 < 8 && allChess[i + 1][j] == 1) {
							int m = i + 1;
							while(m < 8 && allChess[m][j] == 1) {
								m++;
							}
							if(m < 8 && allChess[m][j] == 0) {
								allChess[m][j] = 3;
							}
						}
						if(j - 1 > 0 && allChess[i][j - 1] == 1) {
							int n = j - 1;
							while(n >= 0 && allChess[i][n] == 1) {
								n--;
							}
							if(n >= 0 && allChess[i][n] == 0) {
								allChess[i][n] = 3;
							}
						}
						if(j + 1 < 8 && allChess[i][j + 1] == 1) {
							int n = j + 1;
							while(n < 8 && allChess[i][n] == 1) {
								n++;
							}
							System.out.println(i + " " + n);
							if(n < 8 && allChess[i][n] == 0) {
								allChess[i][n] = 3;
							}
						}
						if(i - 1 > 0 && j - 1 > 0 && allChess[i - 1][j - 1] == 1) {
							int m = i - 1, n = j - 1;
							while((m >= 0 && n >= 0) && allChess[m][n] == 1) {
								m--;
								n--;
							}
							if((m >= 0 && n >= 0) && allChess[m][n] == 0) {
								allChess[m][n] = 3;
							}
						}
						if(i + 1 < 8 && j + 1 < 8 && allChess[i + 1][j + 1] == 1) {
							int m = i + 1, n = j + 1;
							while((m < 8 && n < 8) && allChess[m][n] == 1) {
								m++;
								n++;
							}
							if((m < 8 && n < 8) && allChess[m][n] == 0) {
								allChess[m][n] = 3;
							}
						}
						if(i + 1 < 8 && j - 1 > 0 && allChess[i + 1][j - 1] == 1) {
							int m = i + 1, n = j - 1;
							while((m < 8 && n >= 0) && allChess[m][n] == 1) {
								m++;
								n--;
							}
							if((m < 8 && n >= 0) && allChess[m][n] == 0) {
								allChess[m][n] = 3;
							}
						}
						if(i - 1 > 0 && j + 1 < 8 && allChess[i - 1][j + 1] == 1) {
							int m = i - 1, n = j + 1;
							while((m >= 0 && n < 8) && allChess[m][n] == 1) {
								m--;
								n++;
							}
							if((m >= 0 && n < 8) && allChess[m][n] == 0) {
								allChess[m][n] = 3;
							}
						}
					}
				}
			}
		}
		if (isBlack == true) {
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					if(allChess[i][j] == 1) {
						if(i - 1 > 0 && allChess[i - 1][j] == 2) {
							int m = i - 1;
							while(m >= 0 && allChess[m][j] == 2) {
								m--;
							}
							if(m >= 0 && allChess[m][j] == 0) {
								allChess[m][j] = 3;
							}
						}
						if(i + 1 < 8 && allChess[i + 1][j] == 2) {
							int m = i + 1;
							while(m < 8 && allChess[m][j] == 2) {
								m++;
							}
							if(m < 8 && allChess[m][j] == 0) {
								allChess[m][j] = 3;
							}
						}
						if(j - 1 > 0 && allChess[i][j - 1] == 2) {
							int n = j - 1;
							while(n >= 0 && allChess[i][n] == 2) {
								n--;
							}
							if(n >= 0 && allChess[i][n] == 0) {
								allChess[i][n] = 3;
							}
						}
						if(j + 1 < 8 && allChess[i][j + 1] == 2) {
							int n = j + 1;
							while(n < 8 && allChess[i][n] == 2) {
								n++;
							}
							if(n < 8 && allChess[i][n] == 0) {
								allChess[i][n] = 3;
							}
						}
						if(i - 1 > 0 && j - 1 > 0 && allChess[i - 1][j - 1] == 2) {
							int m = i - 1, n = j - 1;
							while((m >= 0 && n >= 0) && allChess[m][n] == 2) {
								m--;
								n--;
							}
							if((m >= 0 && n >= 0) && allChess[m][n] == 0) {
								allChess[m][n] = 3;
							}
						}
						if(i + 1 < 8 && j + 1 < 8 && allChess[i + 1][j + 1] == 2) {
							int m = i + 1, n = j + 1;
							while((m < 8 && n < 8) && allChess[m][n] == 2) {
								m++;
								n++;
							}
							if((m < 8 && n < 8) && allChess[m][n] == 0) {
								allChess[m][n] = 3;
							}
						}
						if(i + 1 < 8 && j - 1 > 0 && allChess[i + 1][j - 1] == 2) {
							int m = i + 1, n = j - 1;
							while((m < 8 && n >= 0) && allChess[m][n] == 2) {
								m++;
								n--;
							}
							if((m < 8 && n >= 0) && allChess[m][n] == 0) {
								allChess[m][n] = 3;
							}
						}
						if(i - 1 > 0 && j + 1 < 8 && allChess[i - 1][j + 1] == 2) {
							int m = i - 1, n = j + 1;
							while((m >= 0 && n < 8) && allChess[m][n] == 2) {
								m--;
								n++;
							}
							if((m >= 0 && n < 8) && allChess[m][n] == 0) {
								allChess[m][n] = 3;
							}
						}
					}
				}
			}
		}
	}
}
