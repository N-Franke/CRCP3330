import java.util.ArrayList;

public class Tree<T>{
	//Data
		Node root = new Node(); 
		int L = 3; //length of the maximum  token sequence length
		float Pmin = 0.15f; // – set in constructor
		int totalInputTokens = 0; //– the total number of input tokens, initially set to 1
		
		//Methods
	 void train(ArrayList<T> input){
		int count =0;
		
		for(int i = 1; i<=L; i++) {
			//need input length
			int inputSize = input.size();
			for(int j=i-1; j < (inputSize-1); j++) {		
				ArrayList<T> currentSequence = new ArrayList<T>(input.subList(j-(i-1), j+1));
				Node newNode = new Node();
				newNode.setSequence(currentSequence);
				root.addNode(newNode);
			}
		}
		totalInputTokens = input.size();
		System.out.println("Sum of Total  Tokens = " + totalInputTokens);
		root.pMinElimination(totalInputTokens, Pmin);
	}

	void print(){
			root.print();
	}

}
