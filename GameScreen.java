 package reversi;

import java.awt.Color;
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




public class GameScreen extends  JFrame implements MouseListener{
	
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	BufferedImage bgImage=null;
	
	
	int x=0;
	int y=0;
	
	//0没有棋子1黑子2白字
	int[][] allChess=new int[8][8];
	//标识当前棋色
	boolean isBlack=true;
	
	
	public GameScreen() {
		this.setTitle("Reversi");
		this.setSize(Constant.Width,Constant.Height);
		this.setLocation((width-950)/2,(height-750)/2);
		//窗体设置大小不可改变
		this.setResizable(false);
		//关闭后程序结束
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			bgImage=ImageIO.read(new File("./Image/background.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addMouseListener(this);
		this.setVisible(true);
		Initialize i=new Initialize(allChess);
		i.initialize();
	}
	public void paint(Graphics g) {		
		g.drawImage(bgImage,10,25,this);
		
		
		Chess chess=new Chess(allChess);
		
		ChessState state = new ChessState(allChess,isBlack);
		state.judgeState();	
		chess.paint(g);
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
                                                                                                                                                                                                                                          		
	}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x=e.getX();
		y=e.getY();
		//System.out.println(x);
		//System.out.println(y);
		
		if(x>=42 && x<=634 &&y>=64 && y<=656) {
			x=(x-42)/Constant.Grid_Length;
			y=(y-64)/Constant.Grid_Length;
			
			if(allChess[x][y]==3) {
				if(isBlack==true) {
					allChess[x][y]=1;
					isBlack=false;
				}else {
					allChess[x][y]=2;
					isBlack=true;
				}
				Reversal reverstal =new Reversal(allChess,x,y);
				reverstal.change();
			}
			else if(allChess[x][y]==0) {
				JOptionPane.showMessageDialog(this, "illege2");
			}
			
			else {
				JOptionPane.showMessageDialog(this, "illege");
			}
			//state.judgeState();
			this.repaint();
		}
		if(x>=694 && x<=874 &&y>=472 && y<=540) {
			Initialize i=new Initialize(allChess);
			i.initialize();
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
