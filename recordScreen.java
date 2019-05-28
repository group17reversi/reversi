package reversi;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class recordScreen extends JFrame implements MouseListener{
	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	BufferedImage bgImage = null;
	
	int x=0;
	int y=0;
	public recordScreen() {
		this.setTitle("Reversi");
		this.setSize(Constant.Width,Constant.Height);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation((width - Constant.Width)/2, (height - Constant.Height)/2);
		try {
			bgImage = ImageIO.read(new File("./Image/recordscreen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setVisible(true);
		this.addMouseListener(this);
	}
	public void paint(Graphics g) {
		g.drawImage(bgImage, 10, 25, this);
		g.setFont(new Font("Comic Sans MS",Font.BOLD,26));
		ArrayList<String> records = read();
		int x = 115;
		int y = 224;
		int n = Math.min(5, records.size());
		for (int i = 0; i<n;i++) {
			String r = records.get(i);
			g.drawString(r, x, y);
			y=y+50;
		}
		String total = " " + records.size();
		g.drawString(total,327,585);
	}
	public ArrayList<String>  read() {
		BufferedReader reader = null;
        	ArrayList<String> records = new ArrayList<String>();
        try {   
            reader = new BufferedReader(new FileReader("./records/records.txt"));  
            String tempString = null;  
            while ((tempString = reader.readLine()) != null) { 
            	records.add(0, tempString);
            }  
            reader.close();  
        } catch (IOException ex ){  
            ex.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }
		return records;
        
	}
	public void mousePressed(MouseEvent e) {
		//System.out.println(e.getX());
		//System.out.println(e.getY());
		x = e.getX();
		y = e.getY();
		if(x>40 && x<68 && y>52 && y<94) {
			AccessMenu am = new AccessMenu();
			this.setVisible(false);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
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
}
