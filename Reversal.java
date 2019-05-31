package Reversi;

public class Reversal {
	int [][] allChess = new int[8][8];
	int x,y;
	public Reversal(int[][] c, int x, int y) {
		this.allChess = c;
		this.x = x;
		this.y = y;
	}
	public void change() {
		int m,n;
		if (allChess[x][y] == 1) {
			if(x - 1 >= 0 && allChess[x - 1][y] == 2) {
				m = x - 1;
				while(m >= 0 && allChess[m][y] == 2) {
					m--;
				}
				if(m >= 0 && allChess[m][y] == 1) {
					while(m != x) {
						allChess[m][y] = 1;
						m++;
					}
				}
			}
			if(x + 1 < 8 && allChess[x + 1][y] == 2) {
				m = x + 1;
				while(m < 8 && allChess[m][y] == 2) {
					m++;
				}
				if(m < 8 && allChess[m][y] == 1) {
					while(m != x) {
						allChess[m][y] = 1;
						m--;
					}
				}
			}
			if(y - 1 >= 0 && allChess[x][y - 1] == 2) {
				n = y - 1;
				while(n >= 0 && allChess[x][n] == 2) {
					n--;
				}
				if(n >= 0 && allChess[x][n] == 1) {
					while(n != y) {
						allChess[x][n] = 1;
						n++;
					}
				}
			}
			if(y + 1 < 8 && allChess[x][y + 1] == 2) {
				n = y + 1;
				while(n < 8 && allChess[x][n] == 2) {
					n++;
				}
				if(n < 8 && allChess[x][n] == 1) {
					while(n != y) {
						allChess[x][n] = 1;
						n--;
					}
				}
			}
			if(x - 1 >= 0 && y - 1 >= 0 && allChess[x - 1][y - 1] == 2) {
				m = x - 1;
				n = y - 1;
				while((m >= 0 && n >= 0) && allChess[m][n] == 2) {
					m--;
					n--;
				}
				if((m >= 0 && n >= 0) && allChess[m][n] == 1) {
					while(n != y) {
						allChess[m][n] = 1;
						n++;
						m++;
					}
				}
			}
			if(x + 1 < 8 && y + 1 < 8 && allChess[x + 1][y + 1] == 2) {
				m = x + 1;
				n = y + 1;
				while((m < 8 && n < 8) && allChess[m][n] == 2) {
					m++;
					n++;
				}
				if((m < 8 && n < 8) && allChess[m][n] == 1) {
					while(n != y) {
						allChess[m][n] = 1;
						n--;
						m--;
					}
				}
			}
			if(x + 1 < 8 && y - 1 >= 0 && allChess[x + 1][y - 1] == 2) {
				m = x + 1;
				n = y - 1;
				while((m < 8 && n >= 0) && allChess[m][n] == 2) {
					m++;
					n--;
				}
				if((m < 8 && n >= 0) && allChess[m][n] == 1) {
					while(n != y) {
						allChess[m][n] = 1;
						n++;
						m--;
					}
				}
			}
			if(x - 1 >= 0 && y + 1 < 8 && allChess[x - 1][y + 1] == 2) {
				m = x - 1;
				n = y + 1;
				while((m >= 0 && n < 8) && allChess[m][n] == 2) {
					m--;
					n++;
				}
				if((m >= 0 && n < 8) && allChess[m][n] == 1) {
					while(n != y) {
						allChess[m][n] = 1;
						n--;
						m++;
					}
				}
			}			
		}
		if (allChess[x][y] == 2) {
			if(x - 1 >= 0 && allChess[x - 1][y] == 1) {
				m = x - 1;
				while(m >= 0 && allChess[m][y] == 1) {
					m--;
				}
				if(m >= 0 && allChess[m][y] == 2) {
					while(m != x) {
						allChess[m][y] = 2;
						m++;
					}
				}
			}
			if(x + 1 < 8 && allChess[x + 1][y] == 1) {
				m = x + 1;
				while(m < 8 && allChess[m][y] == 1) {
					m++;
				}
				if(m < 8 && allChess[m][y] == 2) {
					while(m != x) {
						allChess[m][y] = 2;
						m--;
					}
				}
			}
			if(y - 1 >= 0 && allChess[x][y - 1] == 1) {
				n = y - 1;
				while(n >= 0 && allChess[x][n] == 1) {
					n--;
				}
				if(n >= 0 && allChess[x][n] == 2) {
					while(n != y) {
						allChess[x][n] = 2;
						n++;
					}
				}
			}
			if(y + 1 < 8 && allChess[x][y + 1] == 1) {
				n = y + 1;
				while(n < 8 && allChess[x][n] == 1) {
					n++;
				}
				if(n < 8 && allChess[x][n] == 2) {
					while(n != y) {
						allChess[x][n] = 2;
						n--;
					}
				}
			}
			if(x - 1 >= 0 && y - 1 >= 0 && allChess[x - 1][y - 1] == 1) {
				m = x - 1;
				n = y - 1;
				while((m >= 0 && n >= 0) && allChess[m][n] == 1) {
					m--;
					n--;
				}
				if((m >= 0 && n >= 0) && allChess[m][n] == 2) {
					while(n != y) {
						allChess[m][n] = 2;
						n++;
						m++;
					}
				}
			}
			if(x + 1 < 8 && y + 1 < 8 && allChess[x + 1][y + 1] == 1) {
				m = x + 1;
				n = y + 1;
				while((m < 8 && n < 8) && allChess[m][n] == 1) {
					m++;
					n++;
				}
				if((m < 8 && n < 8) && allChess[m][n] == 2) {
					while(n != y) {
						allChess[m][n] = 2;
						n--;
						m--;
					}
				}
			}
			if(x + 1 < 8 && y - 1 >= 0 && allChess[x + 1][y - 1] == 1) {
				m = x + 1;
				n = y - 1;
				while((m < 8 && n >= 0) && allChess[m][n] == 1) {
					m++;
					n--;
				}
				if((m < 8 && n >= 0) && allChess[m][n] == 2) {
					while(n != y) {
						allChess[m][n] = 2;
						n++;
						m--;
					}
				}
			}
			if(x - 1 >= 0 && y + 1 < 8 && allChess[x - 1][y + 1] == 1) {
				m = x - 1;
				n = y + 1;
				while((m >= 0 && n < 8) && allChess[m][n] == 1) {
					m--;
					n++;
				}
				if((m >= 0 && n < 8) && allChess[m][n] == 2) {
					while(n != y) {
						allChess[m][n] = 2;
						n--;
						m++;
					}
				}
			}			
		}
	}
}
