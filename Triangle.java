import java.awt.Color;

public class Triangle {
	private Peg[] pegSet;
	private int numRows;
	
	public Triangle(int numRows, int pegSize){
	
		int result = 0;
		for(int i = 0; i < numRows ;i++){
			for(int j = 0; j <= i; j++){
				result++;
			}
		}
		
		this.numRows = numRows;
		
		
		pegSet = new Peg[result];
		
		result = 0;
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j <= i; j++){
				
			pegSet[result] = new Peg(j, i, pegSize);
			result++;
			}
		}
	}
	
	public boolean pegEmpty(int i){
		return !pegSet[i].isFull();
	}
	
	public boolean pegFull(int i){
		return pegSet[i].isFull();
	}
	
	public int getNumRows(){
		return numRows;
	}
	
	public Peg getPeg(int i){
		return pegSet[i];
	}
	
	public int boardSize(){
		return pegSet.length;
	}
	
}
