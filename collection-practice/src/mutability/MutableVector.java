package mutability;


import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class MutableVector {

	private Vector<String> createVector(){
		Vector<String> vector = new Vector<String>();
		vector.add("Ranjan");
		vector.add("Kumar");
		return vector;
	}
	
	private List<String> createUnmodifiableVector(Vector<String> vector){
		List<String> unmodifiable = Collections.unmodifiableList(vector);
		return unmodifiable;
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			MutableVector mutableVector = new MutableVector();
			Vector<String> vector = mutableVector.createVector();		
			vector.add("Patel");		
			System.out.println(vector.toString());
			
			List<String> unmodifiable = mutableVector.createUnmodifiableVector(vector);
			unmodifiable.add("lanthan");
			
			System.out.println(unmodifiable.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
