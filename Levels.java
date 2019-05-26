package Reversi;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Levels extends JFrame implements MouseListener {

	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	BufferedImage bgImage = null;
	
	int x=0;
	int y=0;
	
	int level;
	boolean mode;
	
	public Levels() {
		this.setSize(Constant.Width,Constant.Height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation((width - Constant.Width)/2, (height - Constant.Height)/2);
		try {
			bgImage = ImageIO.read(new File("./Image/level.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		this.addMouseListener(this);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawImage(bgImage, 10, 25, this);
	
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
		x=e.getX();
		y=e.getY();
		
		//System.out.println(e.getX());
		//System.out.println(e.getY());
		if(x>345 &&x<635 && y>265 && y<350){
			level = 0;
			GameScreen gs=new GameScreen();
			gs.mode = getMode();
			gs.level = getLevel();
		}
		
		if(x>345 && x<635 && y>455 && y<542) {
			level = 1;
			GameScreen gs=new GameScreen();
			gs.mode = getMode();
			gs.level = getLevel();
		}
		
		if(x>44 && x<85 && y>55 && y<110) {
			
			Modes m=new Modes();
			this.setVisible(false);
			
		}
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public int getLevel() {
		return level;
	}
	public boolean getMode() {
		return mode;
	}
}
