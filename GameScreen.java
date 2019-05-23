 package reversi;

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
	//��������
	int x = 0;
	int y = 0;
	//����֮ǰ�µ���������
	//0 �����ӣ�1 ���壬2 ����
	int [][] allChess = new int[8][8];
	//��ǰ��ɫ
	boolean isBlack = true;
	//��ʼ������
	Initialize c = new Initialize(allChess);
	
	public GameScreen() {
		this.setTitle("Reversi");
		this.setSize(Constant.Width ,Constant.Height );
		this.setLocation((width - Constant.Width)/2, (height - Constant.Height)/2);
		//�����С���ɱ�
		this.setResizable(false);
		//Ĭ�Ϲرպ�������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			bgImage = ImageIO.read(new File("./Image/background.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addMouseListener(this);
		//��ʾ����
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawImage(bgImage, 10, 25, this);
		ChessState state = new ChessState(allChess, isBlack);
		state.judgeState();
		Chess chess = new Chess(allChess);
		chess.Draw(g);
		chess.Count();
		g.setFont(new Font("����",Font.BOLD,40));
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
				//state.judgeState();
				this.repaint();
			}
			if (x >= 694 && x <= 874 && y >= 472 && y <= 540) {
				isBlack = true;
				c = new Initialize(allChess);
				this.repaint();
			}
		}else {
			Minimax m = new Minimax();
			allChess = m.Min(allChess);
			//x = m.getX();
			//y = m.getY();
			//allChess[x][y] = 2;
			isBlack = true;
			Reversal r = new Reversal(allChess,x,y);
			r.change();
			this.repaint();
		}
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}