package Reversi;

 import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
	//0 无棋子，1 黑棋，2 白棋
	int [][] allChess = new int[8][8];
	//当前棋色
	boolean isBlack = true;
	boolean gameOver = false;
	boolean canPlace = true;
	//初始化棋盘
	Initialize c = new Initialize(allChess);
	
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
	
	public void paint(Graphics g) {
		g.drawImage(bgImage, 10, 25, this);
		Chess chess = new Chess(allChess);
		chess.Draw(g);
		chess.Count();
		g.setFont(new Font("黑体",Font.BOLD,40));
		g.drawString(String.valueOf(chess.Black()), 860, 270);
		g.drawString(String.valueOf(chess.White()), 860, 370);
		if(isBlack==true) {
			g.setFont(new Font("Adobe Gothic Std B",Font.BOLD,32));
			g.drawString("Black  Turn",710,215);
		}
		else if(isBlack==false) {
			g.setFont(new Font("Adobe Gothic Std B",Font.BOLD,32));
			g.drawString("White  Turn",710,215);
		}
		if(gameOver == true) {
			if(chess.Black() > chess.White()) {
				JOptionPane.showMessageDialog(this,"Game Over.You win!");
			}else if(chess.Black() < chess.White()) {
				JOptionPane.showMessageDialog(this,"Game Over.You lose!");
			}else if(chess.Black() == chess.White()){
				JOptionPane.showMessageDialog(this,"Game Over.This is a draw!");
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
		if(isBlack == true) {
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
				}else if(allChess[x][y] == 0) {
					JOptionPane.showMessageDialog(this,"You can not put chess here.");
				}else {
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
		if(x>697 && x<875 && y>556 && y<620) {
			AccessMenu am = new AccessMenu();
			this.setVisible(false);
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(isBlack == false) {
			Minimax m = new Minimax();
			allChess = m.Min(allChess);
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
		}
	}
}