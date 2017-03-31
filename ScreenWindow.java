import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ScreenWindow extends Frame implements WindowListener, Runnable, KeyListener, MouseListener{

	//public static final Dimension SIZE = new Dimension(1100,748);
	//private Frame frame;
	public static String TITLE = "New Window";
	private boolean isRunning,isDone;
	private Image imgBuffer;
	private final int sizeRatio = 1100/748;
	private Triangle triangle;
	
	
	
	
	
	public ScreenWindow(){
		super();
		this.addWindowListener(this);
		//frame = new Frame();
		this.addKeyListener(this);
		this.addMouseListener(this);
		
		this.setSize(1100,748);
		this.setTitle(TITLE);
		isRunning = true;
		isDone = false;
		this.setVisible(true);
		imgBuffer = this.createImage(1100, 748);
		triangle = new Triangle(80);
	}
	
	public void run(){
		while(isRunning){
			
			
			draw();
			
			
			try{
				Thread.sleep(10);
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}
		}
		isDone = true;
	}
	
	
	public void draw(){
		imgBuffer = this.createImage(this.getWidth(), this.getHeight());
		Graphics2D g2 = (Graphics2D)imgBuffer.getGraphics();
		
		g2.setColor(Color.BLUE);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		
			g2.setColor(Color.black);
			Font font = new Font("Callibri", Font.PLAIN, 75);
		
			g2.setFont(font);
			g2.drawString("Waller's Triangle Game", (int)((this.getWidth() - font.getStringBounds("Waller's Triangle Game", g2.getFontRenderContext()).getWidth())/2), 100);
			
			for(int i = 0; i < triangle.boardSize(); i++){
				triangle.getPeg(i).draw(g2);
			}
			
			
		//	g2.setColor(Color.lightGray);
			//g2.fillOval(frame.getWidth()/2 - 35, frame.getHeight()/2, 70, 70);

	
		g2 = (Graphics2D)this.getGraphics();
		g2.drawImage(imgBuffer, 0, 0, this.getWidth(), this.getHeight(), 0, 0, this.getWidth(), this.getHeight(), null);
		g2.dispose();
	}
	
	
	

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		while(true){
			if(isDone){
				System.exit(0);
			}try{
				Thread.sleep(100);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		isRunning = false;
		this.dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		for(int i = 0; i < triangle.boardSize(); i++ ){
			if(triangle.getPeg(i).contains(arg0.getX(), arg0.getY())){
				triangle.getPeg(i).toggle();
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
