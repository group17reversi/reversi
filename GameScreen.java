package Reversi;

 import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameScreen extends JFrame implements MouseListener {

	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	BufferedImage bgImage = null;
	//棋子坐标
	int x = 0;
	int y = 0;
	//保存之前下的棋子坐标
	//0 不可下棋点，1 黑棋，2 白棋, 3 可下棋点
	int [][] allChess = new int[8][8];
	//当前棋色
	boolean isBlack = true;
	boolean gameOver = false;
	boolean canPlace = true;
	//初始化棋盘
	Initialize c = new Initialize(allChess);
	//Modes m = new Modes();
	//true:one player false:two players
	boolean mode;
	//Levels l = new Levels();
	//0:easy 1:hard
	int level;
	Record re = new Record(null, null, null);
	
	public GameScreen() {
		this.setTitle("Reversi");
		this.setSize(Constant.Width ,Constant.Height );
		this.setLocation((width - Constant.Width)/2, (height - Constant.Height)/2);
		//窗体大小不可变
		this.setResizable(false);
		//默认关闭后程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			bgImage = ImageIO.read(new File("./Image/background.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addMouseListener(this);
		//显示窗体
		this.setVisible(true);
	}
	public void newRecord(Record r) {
		if (level == 1) {
			r.level = "hard";
		}else if (level==0) {
			r.level = "easy";
		}
		if(mode == true) {
			r.mode = "one player";
		}else if (mode == false) {
			r.mode = "two players";
			r.level = "    ";
			if (r.winner == "computer") {
				r.winner = "white     ";
			}else if (r.winner == "player") {
				r.winner = "black     ";
			}
		}
		
	}
	public static void fileChaseFW(String filePath, String content) {
		try {
        	//构造函数中的第二个参数true表示以追加形式写文件
        	FileWriter fw = new FileWriter(filePath,true);
        	fw.write(content);
        	fw.close();
    	} catch (IOException e) {
        	System.out.println("failed！" + e);
    	}
	}
	
	public void paint(Graphics g) {
		g.drawImage(bgImage, 10, 25, this);
		Chess chess = new Chess(allChess);
		chess.Draw(g);
		chess.Count();
		Font f = g.getFont();
		g.setFont(new Font("黑体",Font.BOLD,40));
		g.drawString(String.valueOf(chess.Black()), 860, 270);
		g.drawString(String.valueOf(chess.White()), 860, 370);
		g.setFont(f);
		if(isBlack==true) {
			f = g.getFont();
			g.setFont(new Font("Adobe Gothic Std B",Font.BOLD,32));
			g.drawString("Your Turn",710,215);
			g.setFont(f);
		}
		else if(isBlack==false) {
			f = g.getFont();
			g.setFont(new Font("Adobe Gothic Std B",Font.BOLD,32));
			g.drawString("Opponent's Turn",690,215);
			g.setFont(f);
		}
		if(gameOver == true) {
			if(chess.Black() > chess.White()) {
				JOptionPane.showMessageDialog(this,"Game Over.You win!");
				re.winner = "player  ";
			}else if(chess.Black() < chess.White()) {
				JOptionPane.showMessageDialog(this,"Game Over.You lose!");
				re.winner = "computer";
			}else if(chess.Black() == chess.White()){
				JOptionPane.showMessageDialog(this,"Game Over.This is a draw!");
				re.winner = "draw    ";
			}
			newRecord(re);
			String content = re.winner + "                  "+ re.level +"                      "+ re.mode + "\n";
			try {
	            	FileWriter fw = new FileWriter("./records/records.txt", true);
	            	BufferedWriter bw = new BufferedWriter(fw);
	           	bw.write(content);
	            	bw.close();
	            	fw.close();
	        	} catch (Exception e) {
	            	e.printStackTrace();
	        	}
		}else {
			if(canPlace == false) {
				if(isBlack = false) {
					JOptionPane.showMessageDialog(this,"You cannot place chess, it is opponent's turn!");
					isBlack = true;
					System.out.println(isBlack);
					ChessState state = new ChessState(allChess, isBlack);
					state.judgeState();
					this.repaint();
				}else {
					JOptionPane.showMessageDialog(this,"Opponent cannot place chess, it is your turn!");
					isBlack = false;
					System.out.println(isBlack);
					ChessState state = new ChessState(allChess, isBlack);
					state.judgeState();
					this.repaint();
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getX());
		//System.out.println(e.getY());
		if(mode == true) {
			if(isBlack == true) {
				//System.out.println("black");
				x = e.getX();
				y = e.getY();
				if (x >= 42 && x <= 634 && y >= 64 && y <= 656) {
					x = (x - 42) / Constant.Grid_Length;
					y = (y - 64) / Constant.Grid_Length;
					if(allChess[x][y] == 3) {
						allChess[x][y] = 1;
						isBlack = false;
						Reversal r = new Reversal(allChess,x,y);
						r.change();
					}else if(allChess[x][y] == 0 && isBlack == true) {
						System.out.println("1");
						JOptionPane.showMessageDialog(this,"You can not put chess here.");
					}else if((allChess[x][y] == 1 || allChess[x][y] == 2) && isBlack == true) {
						System.out.println("2");
						JOptionPane.showMessageDialog(this,"It has chess here,choose another place.");
					}
					ChessState state = new ChessState(allChess, isBlack);
					state.judgeState();
					GameOver go = new GameOver(allChess);
					go.isGameOver();
					go.canPlace();
					gameOver = go.Over();
					canPlace = go.Place();
					this.repaint();
				}
				if (x >= 694 && x <= 874 && y >= 472 && y <= 540) {
					isBlack = true;
					c = new Initialize(allChess);
					ChessState state = new ChessState(allChess, isBlack);
					state.judgeState();
					GameOver go = new GameOver(allChess);
					go.isGameOver();
					go.canPlace();
					gameOver = go.Over();
					canPlace = go.Place();
					this.repaint();
				}
			}
		}
		
		if(mode == false) {
			if(isBlack == true) {
				//System.out.println("black");
				x = e.getX();
				y = e.getY();
				if (x >= 42 && x <= 634 && y >= 64 && y <= 656) {
					x = (x - 42) / Constant.Grid_Length;
					y = (y - 64) / Constant.Grid_Length;
					if(allChess[x][y] == 3) {
						allChess[x][y] = 1;
						isBlack = false;
						Reversal r = new Reversal(allChess,x,y);
						r.change();
					}else if(allChess[x][y] == 0 && isBlack == true) {
						System.out.println("1");
						JOptionPane.showMessageDialog(this,"You can not put chess here.");
					}else if((allChess[x][y] == 1 || allChess[x][y] == 2) && isBlack == true) {
						System.out.println("2");
						JOptionPane.showMessageDialog(this,"It has chess here,choose another place.");
					}
					ChessState state = new ChessState(allChess, isBlack);
					state.judgeState();
					GameOver go = new GameOver(allChess);
					go.isGameOver();
					go.canPlace();
					gameOver = go.Over();
					canPlace = go.Place();
					this.repaint();
				}
				if (x >= 694 && x <= 874 && y >= 472 && y <= 540) {
					isBlack = true;
					c = new Initialize(allChess);
					ChessState state = new ChessState(allChess, isBlack);
					state.judgeState();
					GameOver go = new GameOver(allChess);
					go.isGameOver();
					go.canPlace();
					gameOver = go.Over();
					canPlace = go.Place();
					this.repaint();
				}
			}else{
				//System.out.println("white");
				x = e.getX();
				y = e.getY();
				if (x >= 42 && x <= 634 && y >= 64 && y <= 656) {
					x = (x - 42) / Constant.Grid_Length;
					y = (y - 64) / Constant.Grid_Length;
					if(allChess[x][y] == 3) {
						allChess[x][y] = 2;
						isBlack = true;
						Reversal r = new Reversal(allChess,x,y);
						r.change();
					}else if(allChess[x][y] == 0 && isBlack == false) {
						System.out.println("3");
						JOptionPane.showMessageDialog(this,"You can not put chess here.");
					}else if((allChess[x][y] == 1 || allChess[x][y] == 2) && isBlack == false){
						System.out.println("4");
						JOptionPane.showMessageDialog(this,"It has chess here,choose another place.");
					}
					ChessState state = new ChessState(allChess, isBlack);
					state.judgeState();
					GameOver go = new GameOver(allChess);
					go.isGameOver();
					go.canPlace();
					gameOver = go.Over();
					canPlace = go.Place();
					this.repaint();
				}
				if (x >= 694 && x <= 874 && y >= 472 && y <= 540) {
					isBlack = true;
					c = new Initialize(allChess);
					ChessState state = new ChessState(allChess, isBlack);
					state.judgeState();
					GameOver go = new GameOver(allChess);
					go.isGameOver();
					go.canPlace();
					gameOver = go.Over();
					canPlace = go.Place();
					this.repaint();
				}
			}
		}
		if(x>697 && x<875 && y>556 && y<620) {
			AccessMenu am = new AccessMenu();
			this.setVisible(false);
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(mode == true) {
			if(isBlack == false) {
				if(level == 1) {
					Minimax m = new Minimax();
					allChess = m.Min(allChess);
				}else if(level == 0) {
					Minimax m = new Minimax();
					allChess = m.EasyLevel(allChess);
				}
				//x = m.getX();
				//y = m.getY();
				//allChess[x][y] = 2;
				isBlack = true;
				Reversal r = new Reversal(allChess,x,y);
				r.change();
				ChessState state = new ChessState(allChess, isBlack);
				state.judgeState();
				GameOver go = new GameOver(allChess);
				go.isGameOver();
				go.canPlace();
				gameOver = go.Over();
				canPlace = go.Place();
				this.repaint();
				//System.out.println("hard");
			}
		}
	}
}