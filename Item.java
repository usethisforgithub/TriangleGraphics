import java.awt.Graphics2D;

public abstract class Item {

	public Item(){
		
	}
	
	public boolean isDrawable(){
		return false;
	}
	
	public boolean isClickable(){
		return false;
	}
	
	public abstract void draw(Graphics2D g2);
}
