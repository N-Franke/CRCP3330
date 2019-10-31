import java.util.ArrayList;

public class Node<T> {
	// Data
	ArrayList<T> tokenSequence = new ArrayList<T>(); // tokenSequence at this node
	ArrayList<Node> children = new ArrayList<Node>();
	int nodeCount = 1;
	float empVal;
	
	// Methods
	void setSequence(ArrayList<T> inputArray) {
		tokenSequence = inputArray; // this works
	}

	ArrayList<T> getSequence() {
		return tokenSequence;
	}

	int getNodeCount() {
		return nodeCount;
	}
	
	boolean addNode(Node testNode) {
		boolean found = false;
		if (tokenSequence.equals(testNode.getSequence())) {
			found = true;
			nodeCount++;
		}

		if (amIaSuffix(testNode) || (tokenSequence.size() == 0)) {
			// Add nodes to children
			int m = 0;
			while (!found && (m < children.size())) {
				found=children.get(m).addNode(testNode);
				m++;
			}
			if(!found) {
			children.add(testNode);
			found=true;
			}
		}
		return found;
		
	}

	void print() {
		System.out.println(tokenSequence);
		for (int i = 0; i < children.size(); i++) {
			children.get(i).print(1);
		}
	}

	void print(int numSpacesBefore) {
		for (int i = 0; i < numSpacesBefore; i++) {
			System.out.print("  ");
		}
		System.out.print("-->");
		System.out.println(tokenSequence);
		
		for (int i = 0; i < children.size(); i++) {
			children.get(i).print(numSpacesBefore + 1);
		}
	}

	boolean amIaSuffix(Node input) {
		boolean suffix;
		ArrayList<T> testArray = new ArrayList<T>();
		testArray = input.getSequence();
		int lengthCurrent = tokenSequence.size();
		int lengthTest = testArray.size() - lengthCurrent;
		if (tokenSequence.equals(testArray.subList(lengthTest, testArray.size()))) {
			suffix = true;
		} else {
			suffix = false;
		}
		return suffix;
	}
	
	public boolean pMinElimination (int totalTokens, float pMin) {
		boolean shouldRemove;
		empVal = nodeCount / (float) (totalTokens - (tokenSequence.size() -1));
		if(tokenSequence.size() < 1) {
			shouldRemove = false;
		}
		else {
			shouldRemove = empVal < pMin;
		}
		if (!shouldRemove) {
			//root node is skipped
			for(int i=(children.size()-1); i>=0; i--) {
				children.get(i).pMinElimination(totalTokens, pMin);
				if (children.get(i).pMinElimination(totalTokens, pMin)){
					children.remove(children.get(i));
				}
			}
		}
		return shouldRemove;
	}
}
