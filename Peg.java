import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Peg{

	private boolean isFull, isHovering;
	private int boardX, boardY, coordX, coordY, diameter;
	
	
	
	public Peg(int bX, int bY, int diam){
		boardX = bX;
		boardY = bY;
		diameter = diam;
		isFull = false;
		isHovering = false;
		coordX = -1000;
		coordY = -1000;
		
	}
	
	

	
	public void draw(Graphics2D g2) {
		if(isFull){
		g2.setColor(Color.BLACK);
		}else{
			g2.setColor(Color.white);
		}
		g2.fillOval(coordX - (diameter/2), coordY - (diameter/2), diameter, diameter);
		
		
		
	}
	
	public int getBoardX(){
		return boardX;
	}
	
	public int getBoardY(){
		return boardY;
	}
	
	public int getCoordX(){
		return coordX;
	}
	
	public int getCoordY(){
		return coordY;
	}
	
	public void setCoordX(int x){
		coordX = x;
	}

	public void setCoordY(int y){
		coordY = y;
	}
	
	public boolean isFull(){
		return isFull;
	}
	
	public void toggle(){
		isFull = !isFull;
	}
	
	public void setDiameter(int diam){
		diameter = diam;
	}
	
	public int getDiameter(){
		return diameter;
	}
	
	public boolean contains(int x, int y){
		int centerX = coordX;
		int centerY = coordY;
		int leg1 = Math.abs(centerX - x);
		int leg2 = Math.abs(centerY - y);
		double hypotenuse = Math.sqrt(leg1 * leg1 + leg2 * leg2);
		return hypotenuse < diameter / 2;
	}
	
	
	
	//public boolean isHovering(mousepositions???){}
	
	//void setHovering(boolean state){}

}
