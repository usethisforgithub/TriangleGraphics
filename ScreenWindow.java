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
	//public static String TITLE = "New Window";
	private boolean isRunning,isDone;
	private Image imgBuffer;
	private Triangle triangle;
	
	
	
	
	
	public ScreenWindow(){
		super();
		this.addWindowListener(this);
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.setSize(1100,748);
		this.setTitle("Triangle Game");
		isRunning = true;
		isDone = false;
		this.setVisible(true);
		imgBuffer = this.createImage(1100, 748);
		triangle = new Triangle(5,70);
		this.setMinimumSize(new Dimension(500,500));
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
			Font font = new Font("Callibri", Font.PLAIN, (int)((3.0/44.0)*(double)this.getWidth()));//font.getStringBounds("Waller's Triangle Game", g2.getFontRenderContext()).getWidth())/2)
		
			g2.setFont(font);
			g2.drawString("Waller's Triangle Game", (int)((this.getWidth() - font.getStringBounds("Waller's Triangle Game", g2.getFontRenderContext()).getWidth())/2), 125 + font.getSize()-75);
			
			
			
			for(int i = 0; i < triangle.boardSize(); i++){
				
				triangle.getPeg(i).setDiameter((int)(((int)((550.0/748.0)*(double)(this.getHeight())))/((3.0/2.0)* (double)triangle.getNumRows())));//(int)((35.0/374.0)*this.getHeight())
				triangle.getPeg(i).setCoordX(500);
	
                                                                                  //draws separation				
				triangle.getPeg(i).setCoordY(((triangle.getPeg(i).getDiameter()/4)+triangle.getPeg(i).getDiameter())*triangle.getPeg(i).getBoardY()+(triangle.getPeg(i).getDiameter()/2) + (this.getHeight()-((triangle.getNumRows()*triangle.getPeg(i).getDiameter())+(triangle.getNumRows()*(triangle.getPeg(i).getDiameter()/4)))));// + ((triangle.getNumRows()*triangle.getPeg(i).getDiameter())+(triangle.getNumRows()*(triangle.getPeg(i).getDiameter()/4)))
				triangle.getPeg(i).draw(g2);
				//System.out.println("boardX " + triangle.getPeg(i).getBoardX());
				//System.out.println("boardY " + triangle.getPeg(i).getBoardY());
				//System.out.println("coordX " + triangle.getPeg(i).getCoordX());
				//System.out.println("coordY " + triangle.getPeg(i).getCoordY());
			}
			
		
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
