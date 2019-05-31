package Reversi;

public class Minimax {
	//int[][] allChess = new int[8][8];
	int min = 64;
	int max = 0;
	int maxX,maxY,minX,minY;
	Reversal R;
	Chess C;
	ChessState S;
	boolean isBlack = false;
	/*public Minimax(int[][] c) {
		this.allChess = c;
	}
	/*public void Min() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(allChess[i][j] == 3) {
					x = i;
					y = j;
				}
			}
		}
	}*/
	public int[][] Min(int[][] c) {
		int[][] chess1 = new int[8][8];
		for(int m = 0; m < 8; m++) {
			for(int n = 0; n < 8; n++) {
				chess1[m][n] = c[m][n];
			}
		}
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(chess1[i][j] == 3) {
					int[][] chess2 = new int[8][8];
					for(int m = 0; m < 8; m++) {
						for(int n = 0; n < 8; n++) {
							chess2[m][n] = chess1[m][n];
						}
					}
					chess2[i][j] = 2;
					isBlack = true;
					R = new Reversal(chess2,i,j);
					R.change();
					S = new ChessState(chess2,isBlack);
					S.judgeState();
					chess2 = Max(chess2);
					C = new Chess(chess2);
					C.Count();
					if(C.black < min) {
						min = C.black;
						minX = i;
						minY = j;
					}
				}
			}
		}
		c[minX][minY] = 2;
		R = new Reversal(c,minX,minY);
		R.change();
		//System.out.println("x " + x + "----" + "y " + y);
		return c;
	}
	public int[][] Max(int[][] c) {
		int[][] chess1 = new int[8][8];
		for(int m = 0; m < 8; m++) {
			for(int n = 0; n < 8; n++) {
				chess1[m][n] = c[m][n];
			}
		}
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(chess1[i][j] == 3) {
					int[][] chess2 = new int[8][8];
					for(int m = 0; m < 8; m++) {
						for(int n = 0; n < 8; n++) {
							chess2[m][n] = chess1[m][n];
						}
					}
					chess2[i][j] = 1;
					isBlack = false;
					R = new Reversal(chess2,i,j);
					R.change();
					C = new Chess(chess2);
					C.Count();
					if(C.black > max) {
						max = C.black;
						maxX = i;
						maxY = j;
					}
				}
			}
		}
		c[maxX][maxY] = 1;
		R = new Reversal(c,minX,minY);
		R.change();
		return c;
	}
	public int[][] EasyLevel(int[][] c) {
		int p = 0;
		int q = 64;
		int x = 0,y = 0;
		int[][] chess1 = new int[8][8];
		for(int m = 0; m < 8; m++) {
			for(int n = 0; n < 8; n++) {
				chess1[m][n] = c[m][n];
			}
		}
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(chess1[i][j] == 3) {
					int[][] chess2 = new int[8][8];
					for(int m = 0; m < 8; m++) {
						for(int n = 0; n < 8; n++) {
							chess2[m][n] = chess1[m][n];
						}
					}
					chess2[i][j] = 2;
					isBlack = true;
					R = new Reversal(chess2,i,j);
					R.change();
					S = new ChessState(chess2,isBlack);
					S.judgeState();
					chess2 = Max(chess2);
					C = new Chess(chess2);
					C.Count();
					if(C.black > p) {
						p = C.black;
						x = i;
						y = j;
					}						
				}
			}
		}
		c[x][y] = 2;
		R = new Reversal(c,x,y);
		R.change();
		//System.out.println("x " + x + "----" + "y " + y);
		return c;
	}
}
