import java.awt.Color;

public class Triangle {
	private Peg[] pegSet;
	
	public Triangle(int i){
		pegSet = new Peg[i];
		for(int j = 0; j < i; j++){
			pegSet[j] = new Peg(100*j, 100*j, 100*j, 500, 70);
		}
	}
	
	public boolean pegEmpty(int i){
		return !pegSet[i].isFull();
	}
	
	public boolean pegFull(int i){
		return pegSet[i].isFull();
	}
	
	//public void togglePeg(int i){
	//	pegSet[i].toggle();
	//}
	
	public Peg getPeg(int i){
		return pegSet[i];
	}
	
	public int boardSize(){
		return pegSet.length;
	}
	
}
